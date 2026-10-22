package com.lynx.devtool;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.lynx.debugrouter.DebugRouter;
import com.lynx.devtool.helper.TestbenchDumpFileHelper;
import com.lynx.devtool.tracing.FrameViewTrace;
import com.lynx.devtool.utils.ErrorUtils;
import com.lynx.devtoolwrapper.CDPEventListener;
import com.lynx.devtoolwrapper.CDPResultCallback;
import com.lynx.devtoolwrapper.CustomizedMessage;
import com.lynx.devtoolwrapper.DevToolSettings;
import com.lynx.devtoolwrapper.GlobalPropsObserver;
import com.lynx.devtoolwrapper.IDevToolDelegate;
import com.lynx.devtoolwrapper.LynxBaseInspectorController;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwnerNG;
import com.lynx.devtoolwrapper.MessageHandler;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.PageReloadHelper;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import h6a.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxInspectorOwner implements LynxBaseInspectorOwnerNG, LynxBaseInspectorController {
    private static final String DEBUG_ACTIVE_MES = "Debugger.setDebugActive";
    private static final String GLOBAL_KEY = "global_key";
    private static final String GLOBAL_VALUE = "global_value";
    private static final String TAG = "LynxInspectorOwner";
    private TemplateData cachedGlobalProps;
    private TemplateData cachedTemplateData;
    private GlobalPropsObserver globalPropsObserver;
    private boolean mDebuggable;
    private LynxDevMenu mDevMenu;
    private IDevToolDelegate mDevToolDelegate;
    private boolean mIsDebugging;
    private LynxDevToolNGDelegate mLynxDevToolNG;
    private WeakReference<LynxView> mLynxView;
    private boolean mNavigatePending;
    private DevToolPlatformAndroidDelegate mPlatform;
    private long mRecordID;
    private PageReloadHelper mReloadHelper;

    private native void nativeEndTestbench(String r1);

    private native void nativeInitRecorderConfig(String r1, int r2, float r3, float r4, long r5);

    private native void nativeRecordEventAndroid(int r1, String[] r2, long r3);

    private native void nativeSendFileByAgent(String r1, String r2);

    public String getHttpServerIp() {
        return "Not Supported";
    }

    public String getHttpServerPort() {
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public boolean isHttpServerWorking() {
        return false;
    }

    private void stopCasting() {
        this.mPlatform.stopCasting();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private void triggerGlobalPropsObserver() {
        if (this.globalPropsObserver == null) goto L10;
        TemplateData r0 = this.cachedGlobalProps;
        if (r0 == null) goto L7;
        Map<Object, Object> r1 = r0.toMap();
    L8:
        this.globalPropsObserver.onGlobalPropsUpdated(r1);
        return;
    L7:
        r1 = null;
        goto L8
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void continueCasting() {
        LynxDevToolNGDelegate r0 = this.mLynxDevToolNG;     // Catch: Throwable -> L8
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAttachToDebugRouter() == false) goto L14;
        this.mPlatform.continueCasting();     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    public LynxView getLynxView() {
        return this.mLynxView.get();
    }

    public int getSessionID() {
        LynxDevToolNGDelegate r0 = this.mLynxDevToolNG;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getSessionId();
    }

    public String getTemplateUrl() {
        DevToolPlatformAndroidDelegate r0 = this.mPlatform;
        if (r0 != null) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        return r0.getTemplateUrl();
    }

    public View getTemplateView() {
        return this.mLynxView.get();
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void onPageUpdate() {
        DevToolPlatformAndroidDelegate r0 = this.mPlatform;
        if (r0 == null) goto L6;
        r0.sendLayerTreeDidChangeEvent();
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void pauseCasting() {
        LynxDevToolNGDelegate r0 = this.mLynxDevToolNG;     // Catch: Throwable -> L8
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAttachToDebugRouter() == false) goto L14;
        this.mPlatform.pauseCasting();     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
    }

    private void initRecord() {
        LynxView r0 = getLynxView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getLynxContext() == null) goto L15;
        File r1 = r0.getLynxContext().getExternalFilesDir(null);
        if (r1 != null) goto L10;
        r1 = r0.getLynxContext().getFilesDir();
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        DisplayMetrics r2 = INVOKEVIRTUAL_com_lynx_devtool_LynxInspectorOwner_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getContext().getResources());
        nativeInitRecorderConfig(r1.getPath(), this.mLynxDevToolNG.getSessionId(), r2.widthPixels, r2.heightPixels, this.mRecordID);
        return;
    }

    public void addUITreeToTestbench() {
        LynxView r0 = getLynxView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getLynxUIRoot() == null) goto L9;
        sendFileByAgent("UITree", TestbenchDumpFileHelper.getUITree(r0.getLynxUIRoot()));
        return;
    }

    public void addViewTreeToTestbench() {
        LynxView r0 = getLynxView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getRootView() == null) goto L9;
        sendFileByAgent("ViewTree", TestbenchDumpFileHelper.getViewTree(r0.getRootView()));
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void destroy() {
        stopCasting();     // Catch: Throwable -> L9
        LynxDevToolNGDelegate r0 = this.mLynxDevToolNG;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.detachToDebug();     // Catch: Throwable -> L9
        this.mLynxDevToolNG.destroy();     // Catch: Throwable -> L9
        this.mLynxDevToolNG = null;     // Catch: Throwable -> L9
    L5:
        DevToolPlatformAndroidDelegate r1 = this.mPlatform;     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        r1.destroy();     // Catch: Throwable -> L9
        this.mPlatform = null;     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public boolean isDebugging() {
        return this.mIsDebugging;
    }

    public LynxInspectorOwner(boolean r2) {
        this.mDevToolDelegate = null;
        this.globalPropsObserver = null;
        this.cachedGlobalProps = null;
        this.cachedTemplateData = TemplateData.fromMap(new HashMap());
        this.mDebuggable = r2;
        init(r2);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_devtool_LynxInspectorOwner_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static boolean isApkDebuggable(Context r1) {
        if ((r1.getApplicationInfo().flags & 2) == 0) goto L13;
        return true;
    L13:
        return false;
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void attach(LynxView r2) {
        this.mLynxView = new WeakReference(r2);
        if (this.mDevMenu == null) goto L6;
        this.mDevMenu.attach(r2);
    L6:
        if (this.mPlatform == null) goto L9;
        this.mPlatform.attach(r2);
    L9:
        if (TraceEvent.enableTrace() == false) goto L12;
        FrameViewTrace.getInstance().attachView(r2);
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void attachLynxUIOwnerToAgent(LynxUIOwner r2) {
        if (this.mPlatform == null) goto L6;
        this.mPlatform.attachLynxUIOwner(r2);
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void attachToDebugBridge(String r5) {
        LLog.i(TAG, "attachToDebugBridge:" + r5);
        LynxDevToolNGDelegate r0 = this.mLynxDevToolNG;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAttachToDebugRouter() == true) goto L17;
        LynxDevToolNGDelegate r1 = this.mLynxDevToolNG;
        if (r5 != null) goto L9;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        int r6 = r1.attachToDebug(r5);
        if (this.mDebuggable == false) goto L12;
        DebugRouter.getInstance().enableSingleSession(r6);
    L12:
        LynxView r2 = getLynxView();
        if (r6 <= 0) goto L17;
        if (r2 == null) goto L17;
        DebugRouter.getInstance().setSessionIdOfView(r2, r6);
    L17:
        if (this.mRecordID == 0) goto L21;
        initRecord();
        return;
    }

    public void dispatchMessageEvent(ReadableMap r2) {
        IDevToolDelegate r0 = this.mDevToolDelegate;
        if (r0 == null) goto L6;
        r0.onDispatchMessageEvent(r2);
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void endTestbench(String r3) {
        LLog.d(TAG, "end testbench replay test");
        addUITreeToTestbench();
        addViewTreeToTestbench();
        nativeEndTestbench(r3);
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public String getDebugInfoUrl(String r2) {
        DevToolPlatformAndroidDelegate r0 = this.mPlatform;
        if (r0 != null) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        return r0.getLepusDebugInfoUrl(r2);
    }

    public Object getGlobalSwitch(String r5) {
        String r6 = JSONObjectProtectorUtils.getString(new JSONObject(r5), GLOBAL_KEY);     // Catch: JSONException -> L56
        switch(r6.hashCode()) {
            case -1901962558: goto L31;
            case -1102772149: goto L28;
            case -901746007: goto L25;
            case -631653698: goto L22;
            case -97356687: goto L19;
            case 708962762: goto L16;
            case 1065947715: goto L13;
            case 1242606350: goto L10;
            case 1285107639: goto L7;
            default: goto L33;
        };     // Catch: JSONException -> L56
    L33:
        byte r3 = -1;
    L34:
        switch(r3) {
            case 0: goto L53;
            case 1: goto L51;
            case 2: goto L49;
            case 3: goto L47;
            case 4: goto L45;
            case 5: goto L43;
            case 6: goto L41;
            case 7: goto L39;
            case 8: goto L37;
            default: goto L54;
        };     // Catch: JSONException -> L56
    L54:
        LLog.e(TAG, "getGlobalSwitch, unsupported key: ".concat(r6));     // Catch: JSONException -> L56
        return null;
    L37:
        return Boolean.valueOf(DevToolSettings.inst().isPerfMetricsEnabled());
    L39:
        return Boolean.valueOf(DevToolSettings.inst().isPixelCopyEnabled());
    L41:
        return Boolean.valueOf(DevToolSettings.inst().isLongPressMenuEnabled());
    L43:
        return Boolean.valueOf(DevToolSettings.inst().isDOMTreeEnabled());
    L45:
        return Integer.valueOf(DevToolSettings.inst().getV8Enabled());
    L47:
        return Boolean.valueOf(DevToolSettings.inst().isQuickJSDebugEnabled());
    L49:
        return Boolean.valueOf(DevToolSettings.inst().isDebugModeEnabled());
    L51:
        return Boolean.valueOf(DevToolSettings.inst().isLogBoxEnabled());
    L53:
        return Boolean.valueOf(DevToolSettings.inst().isDevToolEnabled());
    L7:
        if (r6.equals("enable_dom_tree") == false) goto L33;
        r3 = 5;
        goto L34
    L10:
        if (r6.equals("enable_quickjs_debug") == false) goto L33;
        r3 = 3;
        goto L34
    L13:
        if (r6.equals("enable_logbox") == false) goto L33;
        r3 = 1;
        goto L34
    L16:
        if (r6.equals("enable_pixel_copy") == false) goto L33;
        r3 = 7;
        goto L34
    L19:
        if (r6.equals("enable_devtool") == false) goto L33;
        r3 = 0;
        goto L34
    L22:
        if (r6.equals("enable_v8") == false) goto L33;
        r3 = 4;
        goto L34
    L25:
        if (r6.equals("enable_perf_metrics") == false) goto L33;
        r3 = 8;
        goto L34
    L28:
        if (r6.equals("enable_debug_mode") == false) goto L33;
        r3 = 2;
        goto L34
    L31:
        if (r6.equals("enable_long_press_menu") == false) goto L33;
        r3 = 6;
    L56:
        e = move-exception;
        LLog.e(TAG, e.toString());
        return null;
    }

    public void getViewLocationOnScreen(int[] r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.length < 2) goto L15;
        WeakReference<LynxView> r0 = this.mLynxView;
        if (r0 == null) goto L18;
        LynxView r1 = r0.get();
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.getLynxContext() == null) goto L17;
        r1.getLocationOnScreen(r4);
        float r2 = INVOKEVIRTUAL_com_lynx_devtool_LynxInspectorOwner_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r1.getLynxContext().getResources()).density;
        r4[0] = (int) (r4[0] / r2);
        r4[1] = (int) (r4[1] / r2);
        return;
    L17:
        return;
    L18:
        return;
    }

    public void init(boolean r2) {
        if (LynxEnv.inst().isDevLibraryLoaded() == true) goto L5;
        LynxDevtoolEnv.inst().loadNativeDevtoolLibrary();
    L5:
        this.mLynxDevToolNG = new LynxDevToolNGDelegate(r2);
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public long onBackgroundRuntimeCreated(String r3) {
        LynxDevToolNGDelegate r0 = this.mLynxDevToolNG;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.onBackgroundRuntimeCreated(r3);
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void onGlobalPropsUpdated(TemplateData r1) {
        this.cachedGlobalProps = r1;
        triggerGlobalPropsObserver();
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void onMTSRuntimeCreated(long r3) {
        LynxDevToolNGDelegate r0 = this.mLynxDevToolNG;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onMTSRuntimeCreated(r3);
        DevToolPlatformAndroidDelegate r4 = this.mPlatform;
        if (r4 == null) goto L9;
        this.mLynxDevToolNG.setDevToolPlatformAbility(r4.getNativePtr());
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void onReceiveMessageEvent(ReadableMap r6) {
        LynxDevToolNGDelegate r2 = this.mLynxDevToolNG;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isAttachToDebugRouter() == false) goto L23;
        if (r6 != null) goto L9;
        return;
    L9:
        String r3 = r6.getString("type");
        if (TextUtils.isEmpty(r3) == false) goto L19;
        return;
    L19:
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L16
        r4.putOpt("event", r3);     // Catch: JSONException -> L16
        r4.putOpt("vmType", r6.getString("origin", NameKeys.UnloadStrategy_No_Strategy));     // Catch: JSONException -> L16
        r4.putOpt(LynxResourceModule.DATA_KEY, r6.getString(LynxResourceModule.DATA_KEY, NameKeys.UnloadStrategy_No_Strategy));     // Catch: JSONException -> L16
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L16
        r7.put("method", "Lynx.onVMEvent");     // Catch: JSONException -> L16
        r7.put(LynxResourceModule.PARAMS_KEY, r4);     // Catch: JSONException -> L16
        DevToolPlatformAndroidDelegate r0 = this.mPlatform;     // Catch: JSONException -> L16
        if (r0 == null) goto L22;
        r0.sendCDPEvent(r7.toString());     // Catch: JSONException -> L16
        return;
    L22:
        return;
    L16:
        e = move-exception;
        LLog.e(TAG, e.toString());
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void onRootViewInputEvent(InputEvent r7) {
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L6;
        return;
    L6:
        if ((r7 instanceof MotionEvent) == false) goto L14;
        if (this.mDevMenu == null) goto L14;
        MotionEvent r8 = (MotionEvent) r7;
        if (LynxDevtoolEnv.inst().isLongPressMenuEnabled() == false) goto L12;
        this.mDevMenu.onRootViewTouchEvent(r8);
    L12:
        nativeRecordEventAndroid(0, new String[]{String.valueOf(r8.getAction()), String.valueOf(r8.getX()), String.valueOf(r8.getY()), String.valueOf(r8.getMetaState())}, this.mRecordID);
        return;
    L14:
        if ((r7 instanceof KeyEvent) == false) goto L18;
        KeyEvent r9 = (KeyEvent) r7;
        nativeRecordEventAndroid(1, new String[]{String.valueOf(r9.getAction()), String.valueOf(r9.getKeyCode()), String.valueOf(r9.getMetaState())}, this.mRecordID);
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void onTemplateAssemblerCreated(long r5) {
        LynxDevToolNGDelegate r0 = this.mLynxDevToolNG;
        if (r0 == null) goto L7;
        r0.onTASMCreated(r5);
        DevToolPlatformAndroidDelegate r1 = this.mPlatform;
        if (r1 == null) goto L7;
        this.mLynxDevToolNG.setDevToolPlatformAbility(r1.getNativePtr());
        this.mPlatform.setDevToolDelegate(this.mDevToolDelegate);
    L7:
        this.mRecordID = r5;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void onTemplateDataReset(TemplateData r1) {
        this.cachedTemplateData = r1;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void onTemplateDataUpdated(TemplateData r2) {
        this.cachedTemplateData.updateWithTemplateData(r2);
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorOwner
    public void registerGlobalPropsUpdatedObserver(GlobalPropsObserver r1) {
        this.globalPropsObserver = r1;
        if (this.cachedGlobalProps == null) goto L6;
        triggerGlobalPropsObserver();
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorOwner
    public void reload(boolean r7) {
        reload(r7, null, false, 0, NameKeys.UnloadStrategy_No_Strategy);
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorOwner
    public void removeCDPEventListener(String r2) {
        this.mLynxDevToolNG.removeCDPEventListener(r2);
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorOwnerNG
    public void sendMessage(CustomizedMessage r3) {
        LynxDevToolNGDelegate r0 = this.mLynxDevToolNG;
        if (r0 == null) goto L7;
        if (r3 == null) goto L8;
        r0.sendMessageToDebugPlatform(r3.getType(), r3.getData());
        return;
    L8:
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void setDebugInfoInterceptor(a r2) {
        DevToolPlatformAndroidDelegate r0 = this.mPlatform;
        if (r0 == null) goto L6;
        r0.setDebugInfoInterceptor(r2);
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorOwner
    public void setDebugTag(String r2) {
        LynxDevToolNGDelegate r0 = this.mLynxDevToolNG;
        if (r0 == null) goto L6;
        r0.setTag(r2);
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void setDevToolDelegate(IDevToolDelegate r2) {
        this.mDevToolDelegate = r2;
        DevToolPlatformAndroidDelegate r0 = this.mPlatform;
        if (r0 == null) goto L6;
        r0.setDevToolDelegate(r2);
        return;
    }

    public Object setGlobalSwitch(String r6) {
        JSONObject r3 = new JSONObject(r6);     // Catch: JSONException -> L56
        String r7 = JSONObjectProtectorUtils.getString(r3, GLOBAL_KEY);     // Catch: JSONException -> L56
        Object r4 = r3.get(GLOBAL_VALUE);     // Catch: JSONException -> L56
        switch(r7.hashCode()) {
            case -1901962558: goto L31;
            case -1102772149: goto L28;
            case -901746007: goto L25;
            case -631653698: goto L22;
            case -97356687: goto L19;
            case 708962762: goto L16;
            case 1065947715: goto L13;
            case 1242606350: goto L10;
            case 1285107639: goto L7;
            default: goto L33;
        };     // Catch: JSONException -> L56
    L33:
        byte r5 = -1;
    L34:
        switch(r5) {
            case 0: goto L52;
            case 1: goto L50;
            case 2: goto L48;
            case 3: goto L46;
            case 4: goto L44;
            case 5: goto L42;
            case 6: goto L40;
            case 7: goto L38;
            case 8: goto L36;
            default: goto L54;
        };     // Catch: JSONException -> L56
    L36:
        DevToolSettings.inst().setPerfMetricsEnabled(((Boolean) r4).booleanValue());     // Catch: JSONException -> L56
        return r4;
    L38:
        DevToolSettings.inst().setPixelCopyEnabled(((Boolean) r4).booleanValue());     // Catch: JSONException -> L56
        return r4;
    L40:
        DevToolSettings.inst().setLongPressMenuEnabled(((Boolean) r4).booleanValue());     // Catch: JSONException -> L56
        return r4;
    L42:
        DevToolSettings.inst().setDOMTreeEnabled(((Boolean) r4).booleanValue());     // Catch: JSONException -> L56
        return r4;
    L44:
        DevToolSettings.inst().setV8Enabled(((Integer) r4).intValue());     // Catch: JSONException -> L56
        return r4;
    L46:
        DevToolSettings.inst().setQuickJSDebugEnabled(((Boolean) r4).booleanValue());     // Catch: JSONException -> L56
        return r4;
    L48:
        DevToolSettings.inst().setDebugModeEnabled(((Boolean) r4).booleanValue());     // Catch: JSONException -> L56
        return r4;
    L50:
        DevToolSettings.inst().setLogBoxEnabled(((Boolean) r4).booleanValue());     // Catch: JSONException -> L56
        return r4;
    L52:
        DevToolSettings.inst().setDevToolEnabled(((Boolean) r4).booleanValue());     // Catch: JSONException -> L56
        return r4;
    L54:
        LLog.e(TAG, "setGlobalSwitch, unsupported key: ".concat(r7));     // Catch: JSONException -> L56
        return null;
    L7:
        if (r7.equals("enable_dom_tree") == false) goto L33;
        r5 = 5;
        goto L34
    L10:
        if (r7.equals("enable_quickjs_debug") == false) goto L33;
        r5 = 3;
        goto L34
    L13:
        if (r7.equals("enable_logbox") == false) goto L33;
        r5 = 1;
        goto L34
    L16:
        if (r7.equals("enable_pixel_copy") == false) goto L33;
        r5 = 7;
        goto L34
    L19:
        if (r7.equals("enable_devtool") == false) goto L33;
        r5 = 0;
        goto L34
    L22:
        if (r7.equals("enable_v8") == false) goto L33;
        r5 = 4;
        goto L34
    L25:
        if (r7.equals("enable_perf_metrics") == false) goto L33;
        r5 = 8;
        goto L34
    L28:
        if (r7.equals("enable_debug_mode") == false) goto L33;
        r5 = 2;
        goto L34
    L31:
        if (r7.equals("enable_long_press_menu") == false) goto L33;
        r5 = 6;
    L56:
        e = move-exception;
        LLog.e(TAG, e.toString());
        return null;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorOwner
    public void setLynxInspectorConsoleDelegate(Object r2) {
        DevToolPlatformAndroidDelegate r0 = this.mPlatform;
        if (r0 == null) goto L6;
        r0.setLynxInspectorConsoleDelegate(r2);
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void setReloadHelper(PageReloadHelper r2) {
        this.mReloadHelper = r2;
        DevToolPlatformAndroidDelegate r0 = this.mPlatform;
        if (r0 == null) goto L6;
        r0.setReloadHelper(r2);
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void showErrorMessageOnConsole(LynxError r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isValid() == true) goto L6;
        return;
    L6:
        if (r4.isJSError() == false) goto L8;
        return;
    L8:
        if (r4.isLepusError() == true) goto L15;
        sendConsoleMessage("Native error:\n" + ErrorUtils.getKeyMessage(r4), ErrorUtils.errorLevelStrToInt(r4.getLevel()), System.currentTimeMillis());
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorOwnerNG
    public void unsubscribeMessage(String r2) {
        LynxDevToolNGDelegate r0 = this.mLynxDevToolNG;
        if (r0 == null) goto L6;
        r0.unSubscribeMessage(r2);
        return;
    }

    public LynxInspectorOwner(LynxView r4, boolean r5) {
        this.mDevToolDelegate = null;
        this.globalPropsObserver = null;
        this.cachedGlobalProps = null;
        this.cachedTemplateData = TemplateData.fromMap(new HashMap());
        this.mDebuggable = r5;
        init(r5);
        this.mLynxView = new WeakReference(r4);
        this.mRecordID = 0;
        this.mIsDebugging = false;
        this.mNavigatePending = false;
        this.mDevMenu = new LynxDevMenu(this, r4);
        this.mPlatform = new DevToolPlatformAndroidDelegate(r4);
        this.mReloadHelper = null;
        if (TraceEvent.enableTrace() == false) goto L6;
        FrameViewTrace.getInstance().attachView(r4);
        return;
    }

    private void sendFileByAgent(String r1, String r2) {
        nativeSendFileByAgent(r1, r2);
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorOwner
    public void addCDPEventListener(String r2, CDPEventListener r3) {
        this.mLynxDevToolNG.addCDPEventListener(r2, r3);
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorOwner
    public void invokeCDPFromSDK(String r2, CDPResultCallback r3) {
        this.mLynxDevToolNG.invokeCDPFromSDK(r2, r3);
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void onPerfMetricsEvent(String r3, JSONObject r4) {
        if (LynxDevtoolEnv.inst().isPerfMetricsEnabled() == true) goto L10;
        return;
    L10:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L7
        r0.put("method", r3);     // Catch: JSONException -> L7
        r0.put(LynxResourceModule.PARAMS_KEY, r4);     // Catch: JSONException -> L7
        sendMessage(new CustomizedMessage("CDP", r0.toString()));     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        LLog.e(TAG, e.toString());
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void showMessageOnConsole(String r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        sendConsoleMessage(r3, r4, System.currentTimeMillis());
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorOwnerNG
    public void subscribeMessage(String r2, MessageHandler r3) {
        if (this.mLynxDevToolNG == null) goto L6;
        this.mLynxDevToolNG.subscribeMessage(r2, r3);
        return;
    }

    private void sendConsoleMessage(String r2, int r3, long r4) {
        DevToolPlatformAndroidDelegate r0 = this.mPlatform;
        if (r0 == null) goto L6;
        r0.sendConsoleEvent(r2, r3, r4);
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorOwner
    public void getConsoleObject(String r2, boolean r3, Callback r4) {
        DevToolPlatformAndroidDelegate r0 = this.mPlatform;
        if (r0 == null) goto L6;
        r0.getConsoleObject(r2, r3, r4);
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void updateScreenMetrics(int r2, int r3, float r4) {
        LynxDevToolNGDelegate r0 = this.mLynxDevToolNG;
        if (r0 == null) goto L6;
        r0.updateScreenMetrics(r2, r3, r4);
        return;
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorOwner
    public void reload(boolean r7, String r8, boolean r9, int r10) {
        reload(r7, r8, r9, r10, NameKeys.UnloadStrategy_No_Strategy);
    }

    @Override // com.lynx.devtoolwrapper.LynxBaseInspectorController
    public void reload(boolean r8, String r9, boolean r10, int r11, String r12) {
        if (this.mReloadHelper == null) goto L9;
        LynxView r0 = getLynxView();
        if (r0 == null) goto L7;
        Toast.makeText(r0.getContext(), "Start to download & reload...", 0).show();
    L7:
        this.mReloadHelper.reload(r8, r9, r10, r11, r12);
        return;
    }
}
