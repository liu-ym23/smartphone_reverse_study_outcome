package com.lynx.devtool;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.Toast;
import com.lynx.devtool.helper.EmulateTouchHelper;
import com.lynx.devtool.helper.LepusDebugInfoHelper;
import com.lynx.devtool.helper.ScreenCapturer;
import com.lynx.devtool.helper.ScreenCastHelper;
import com.lynx.devtool.helper.UITreeHelper;
import com.lynx.devtoolwrapper.IDevToolDelegate;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.PageReloadHelper;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import h6a.a;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DevToolPlatformAndroidDelegate {
    static final String NO_DEBUG_INFO_FOUND_BY_URL = "NO_DEBUG_INFO_FOUND_BY_URL";
    private static final String TAG = "DevToolPlatformAndroidDelegate";
    private ScreenCastHelper mCastHelper;
    private ConsoleDelegateManager mConsoleDelegateManager;
    private a mDebugInfoRecorder;
    private IDevToolDelegate mDevToolDelegate;
    private long mFacadePtr;
    private LepusDebugInfoHelper mLepusDebugInfoHelper;
    private WeakReference<LynxView> mLynxView;
    private PageReloadHelper mReloadHelper;
    private EmulateTouchHelper mTouchHelper;
    private UITreeHelper mUITreeHelper;

    private native long nativeCreateDevToolPlatformFacade();

    private native void nativeDestroyDevToolPlatformFacade(long r1);

    private native void nativeDispatchScreencastVisibilityChanged(long r1, boolean r3);

    private native String nativeGetLepusDebugInfoUrl(long r1, String r3);

    private native void nativeSendCDPEvent(long r1, String r3);

    private native void nativeSendConsoleEvent(long r1, String r3, int r4, long r5);

    private native void nativeSendLayerTreeDidChangeEvent(long r1);

    private native void nativeSendLynxScreenshotCapturedEvent(long r1, String r3);

    private native void nativeSendPageScreencastFrameEvent(long r1, String r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10);

    public int[] getViewLocationOnScreen() {
        int[] r0 = {-1, -1};
        UITreeHelper r1 = this.mUITreeHelper;
        if (r1 == null) goto L5;
        r1.getViewLocationOnScreen(r0);
    L5:
        return r0;
    }

    public native void nativeFlushConsoleMessages(long r1);

    public native void nativeGetConsoleObject(long r1, String r3, boolean r4, int r5);

    public void continueCasting() {
        ScreenCastHelper r0 = this.mCastHelper;
        if (r0 == null) goto L6;
        r0.continueCasting();
        return;
    }

    public void destroy() {
        long r0 = this.mFacadePtr;
        if (r0 == 0) goto L5;
        nativeDestroyDevToolPlatformFacade(r0);
    L5:
        this.mFacadePtr = 0;
    }

    public String getLynxUITree() {
        UITreeHelper r0 = this.mUITreeHelper;
        if (r0 != null) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        return r0.getLynxUITree();
    }

    public float[] getRectToWindow() {
        UITreeHelper r0 = this.mUITreeHelper;
        if (r0 == null) goto L7;
        return r0.getRectToWindow();
    L7:
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    public long getTemplateDataPtr() {
        PageReloadHelper r0 = this.mReloadHelper;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getTemplateDataPtr();
    }

    public String getTemplateUrl() {
        PageReloadHelper r0 = this.mReloadHelper;
        if (r0 != null) goto L5;
        LLog.w(TAG, "mReloadHelper == null");
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        return r0.getURL();
    }

    public void onAckReceived() {
        ScreenCastHelper r0 = this.mCastHelper;
        if (r0 == null) goto L6;
        r0.onAckReceived();
        return;
    }

    public void pauseCasting() {
        ScreenCastHelper r0 = this.mCastHelper;
        if (r0 == null) goto L6;
        r0.pauseCasting();
        return;
    }

    public void sendCardPreview() {
        ScreenCastHelper r0 = this.mCastHelper;
        if (r0 == null) goto L6;
        r0.sendCardPreview(this.mDevToolDelegate);
        return;
    }

    public void sendLayerTreeDidChangeEvent() {
        long r0 = this.mFacadePtr;
        if (r0 == 0) goto L6;
        nativeSendLayerTreeDidChangeEvent(r0);
        return;
    }

    public void stopCasting() {
        ScreenCastHelper r0 = this.mCastHelper;
        if (r0 == null) goto L6;
        r0.stopCasting();
        return;
    }

    public static String getLynxVersion() {
        return LynxEnv.inst().getLynxVersion();
    }

    public long getNativePtr() {
        return this.mFacadePtr;
    }

    public DevToolPlatformAndroidDelegate(LynxView r4) {
        this.mDevToolDelegate = null;
        this.mUITreeHelper = new UITreeHelper();
        this.mConsoleDelegateManager = new ConsoleDelegateManager();
        this.mLynxView = new WeakReference(r4);
        this.mLepusDebugInfoHelper = new LepusDebugInfoHelper();
        this.mCastHelper = new ScreenCastHelper(this, r4);
        this.mFacadePtr = nativeCreateDevToolPlatformFacade();
        this.mTouchHelper = new EmulateTouchHelper(this.mLynxView);
        this.mReloadHelper = null;
        this.mDebugInfoRecorder = null;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_devtool_DevToolPlatformAndroidDelegate_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public void attach(LynxView r2) {
        this.mLynxView = new WeakReference(r2);
        if (this.mCastHelper == null) goto L6;
        this.mCastHelper.attach(r2);
    L6:
        if (this.mTouchHelper == null) goto L9;
        this.mTouchHelper.attach(r2);
        return;
    }

    public void attachLynxUIOwner(LynxUIOwner r2) {
        if (this.mUITreeHelper == null) goto L6;
        this.mUITreeHelper.attachLynxUIOwner(r2);
        return;
    }

    public void dispatchScreencastVisibilityChanged(boolean r6) {
        long r0 = this.mFacadePtr;
        if (r0 == 0) goto L6;
        nativeDispatchScreencastVisibilityChanged(r0, r6);
        return;
    }

    public void focus(final int r5) {
        LynxView r0 = this.mLynxView.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getLynxContext() == null) goto L13;
        LynxUIOwner r1 = r0.getLynxContext().getLynxUIOwner();
        if (r1 != null) goto L10;
        return;
    L10:
        r1.invokeUIMethodForSelectorQuery(r5, "focus", new JavaOnlyMap(), new AnonymousClass1(this, r5));
        return;
    }

    public String getDebugInfoByUrl(String r2) {
        a r0 = this.mDebugInfoRecorder;
        if (r0 == null) goto L7;
        String r3 = r0.getDebugInfo(r2);
        if (r3 == null) goto L9;
        return r3;
    L9:
        return NO_DEBUG_INFO_FOUND_BY_URL;
    L7:
        return NO_DEBUG_INFO_FOUND_BY_URL;
    }

    public String getLepusDebugInfo(String r2) {
        LepusDebugInfoHelper r0 = this.mLepusDebugInfoHelper;
        if (r0 != null) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        return r0.getDebugInfo(r2);
    }

    public String getLepusDebugInfoUrl(String r6) {
        long r0 = this.mFacadePtr;
        if (r0 != 0) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        return nativeGetLepusDebugInfoUrl(r0, r6);
    }

    public String getUINodeInfo(int r2) {
        UITreeHelper r0 = this.mUITreeHelper;
        if (r0 != null) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        return r0.getUINodeInfo(r2);
    }

    public void insertText(String r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        LynxView r0 = this.mLynxView.get();
        if (r0 != null) goto L7;
        return;
    L7:
        View r1 = r0.findFocus();
        if (r1 != null) goto L13;
        if (r0.getRootView() == null) goto L13;
        r1 = r0.getRootView().findFocus();
    L13:
        if ((r1 instanceof EditText) == true) goto L16;
        LLog.w(TAG, "Input.insertText ignored because no EditText is focused.");
        return;
    L16:
        EditText r2 = (EditText) r1;
        InputConnection r3 = r2.onCreateInputConnection(new EditorInfo());
        if (r3 != null) goto L19;
    L21:
        int r4 = r2.getSelectionStart();
        int r5 = r2.getSelectionEnd();
        if (r4 < 0) goto L27;
        if (r5 < 0) goto L27;
        int r6 = r2.getText().length();
        int r8 = Math.min(r6, Math.max(0, Math.min(r4, r5)));
        int r9 = Math.min(r6, Math.max(0, Math.max(r4, r5)));
        r2.getText().replace(r8, r9, r7);
        return;
    L27:
        r2.getText().append(r7);
        return;
    L19:
        if (r3.commitText(r7, 1) == false) goto L21;
    }

    public void navigate(String r2) {
        if (this.mReloadHelper == null) goto L6;
        this.mReloadHelper.navigate(r2);
        return;
    }

    public void onConsoleMessage(String r2) {
        ConsoleDelegateManager r0 = this.mConsoleDelegateManager;
        if (r0 == null) goto L6;
        r0.onConsoleMessage(r2);
        return;
    }

    public void scrollIntoViewFromUI(int r2) {
        IDevToolDelegate r0 = this.mDevToolDelegate;
        if (r0 == null) goto L6;
        r0.scrollIntoViewFromUI(r2);
        return;
    }

    public void sendCDPEvent(String r6) {
        long r0 = this.mFacadePtr;
        if (r0 == 0) goto L6;
        nativeSendCDPEvent(r0, r6);
        return;
    }

    public void sendCardPreviewData(String r6) {
        long r0 = this.mFacadePtr;
        if (r0 == 0) goto L6;
        nativeSendLynxScreenshotCapturedEvent(r0, r6);
        return;
    }

    public void setDebugInfoInterceptor(a r1) {
        this.mDebugInfoRecorder = r1;
    }

    public void setDevToolDelegate(IDevToolDelegate r1) {
        this.mDevToolDelegate = r1;
    }

    public void setLynxInspectorConsoleDelegate(Object r7) {
        ConsoleDelegateManager r0 = this.mConsoleDelegateManager;
        if (r0 == null) goto L8;
        long r1 = this.mFacadePtr;
        if (r1 == 0) goto L9;
        r0.setLynxInspectorConsoleDelegate(r7, this, r1);
        return;
    L9:
        return;
    }

    public void setReloadHelper(PageReloadHelper r1) {
        this.mReloadHelper = r1;
    }

    public String getTemplateJsInfo(int r2, int r3) {
        PageReloadHelper r0 = this.mReloadHelper;
        if (r0 != null) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        return r0.getTemplateJsInfo(r2, r3);
    }

    public float[] getTransformValue(int r2, float[] r3) {
        IDevToolDelegate r0 = this.mDevToolDelegate;
        if (r0 == null) goto L7;
        return r0.getTransformValue(r2, r3);
    L7:
        return new float[0];
    }

    public void onConsoleObject(String r2, int r3) {
        ConsoleDelegateManager r0 = this.mConsoleDelegateManager;
        if (r0 == null) goto L6;
        r0.onConsoleObject(r2, r3);
        return;
    }

    public void onReceiveTemplateFragment(String r2, boolean r3) {
        if (this.mReloadHelper == null) goto L6;
        this.mReloadHelper.onReceiveTemplateFragment(r2, r3);
        return;
    }

    public int findNodeIdForLocationFromUI(float r2, float r3, String r4) {
        IDevToolDelegate r0 = this.mDevToolDelegate;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getNodeForLocation(r2, r3, r4);
    }

    public void getConsoleObject(String r8, boolean r9, Callback r10) {
        ConsoleDelegateManager r0 = this.mConsoleDelegateManager;
        if (r0 == null) goto L8;
        long r5 = this.mFacadePtr;
        if (r5 == 0) goto L9;
        r0.getConsoleObject(r8, r9, r10, this, r5);
        return;
    L9:
        return;
    }

    public void sendConsoleEvent(String r8, int r9, long r10) {
        long r1 = this.mFacadePtr;
        if (r1 == 0) goto L6;
        nativeSendConsoleEvent(r1, r8, r9, r10);
        return;
    }

    public void sendEventToVM(String r3, String r4, String r5) {
        if (this.mDevToolDelegate != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putString("type", r4);
        if (r5 != null) goto L12;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L12:
        r0.putString(LynxResourceModule.DATA_KEY, r5);
        r0.putString("origin", "Devtool");
        r0.putString("target", r3);
        this.mDevToolDelegate.onDispatchMessageEvent(r0);
        return;
    }

    public int setUIStyle(int r2, String r3, String r4) {
        UITreeHelper r0 = this.mUITreeHelper;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.setUIStyle(r2, r3, r4);
    }

    public void sendScreenCast(String r12, ScreenCapturer.ScreenMetadata r13, float r14, float r15) {
        if (r12 == null) goto L9;
        if (r13 == null) goto L11;
        long r1 = this.mFacadePtr;
        if (r1 == 0) goto L10;
        nativeSendPageScreencastFrameEvent(r1, r12, r13.mOffsetTop, r14, r13.mDeviceWidth, r13.mDeviceHeight, r13.mScrollOffsetX, r13.mScrollOffsetY, r13.mTimestamp);
        return;
    L10:
        return;
    L11:
        return;
    }

    public void startCasting(int r7, int r8, int r9, String r10) {
        ScreenCastHelper r0 = this.mCastHelper;
        if (r0 == null) goto L6;
        r0.startCasting(r7, r8, r9, r10, this.mDevToolDelegate);
        return;
    }

    public void pageReload(boolean r8, String r9, boolean r10, int r11, String r12) {
        if (this.mReloadHelper == null) goto L9;
        LynxView r0 = this.mLynxView.get();
        if (r0 == null) goto L7;
        Toast.makeText(r0.getContext(), "Start to download & reload...", 0).show();
    L7:
        this.mReloadHelper.reload(r8, r9, r10, r11, r12);
        return;
    }

    public void emulateTouch(String r10, int r11, int r12, float r13, float r14, String r15) {
        if (this.mTouchHelper != null) goto L5;
        return;
    L5:
        LynxView r0 = this.mLynxView.get();
        if (r0 == null) goto L9;
        float r1 = INVOKEVIRTUAL_com_lynx_devtool_DevToolPlatformAndroidDelegate_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r0.getLynxContext().getResources()).density;
        this.mTouchHelper.emulateTouch(r10, (int) ((r11 * r1) + 0.5f), (int) ((r12 * r1) + 0.5f), (r13 * r1) + 0.5f, (r14 * r1) + 0.5f, r15, this.mDevToolDelegate);
        return;
    }
}
