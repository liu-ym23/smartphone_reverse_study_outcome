package com.lynx.devtoolwrapper;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.InputEvent;
import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.PageReloadHelper;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.r;
import com.lynx.tasm.service.ILynxDevToolService;
import com.obric.aivoice.core.data.NameKeys;
import i8a.n;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxDevtool {
    private static final String TAG = "LynxDevtool";
    private static ILynxDevToolService sDevToolService;
    private ILynxLogBox mLogBox;
    private LynxBaseInspectorController mOwner;
    private PageReloadHelper mReloader;
    private WeakReference<LynxTemplateRender> mRender;
    private WeakReference<LynxView> mView;

    public void destroy() {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.destroy();
        this.mOwner = null;
        LLog.i(TAG, "mOwner = null");
        return;
    }

    public Boolean enableAirStrictMode() {
        LynxTemplateRender r0 = this.mRender.get();
        if (r0 == null) goto L7;
        return Boolean.valueOf(r0.enableAirStrictMode());
    L7:
        return Boolean.FALSE;
    }

    public Map<String, Object> getAllJsSource() {
        LynxTemplateRender r0 = this.mRender.get();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getAllJsSource();
    }

    public LynxBaseInspectorOwner getBaseInspectorOwner() {
        LynxBaseInspectorController r0 = this.mOwner;
        if ((r0 instanceof LynxBaseInspectorOwner) == true) goto L5;
        return null;
    L5:
        return (LynxBaseInspectorOwner) r0;
    }

    public LynxContext getLynxContext() {
        LynxTemplateRender r0 = this.mRender.get();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getLynxContext();
    }

    public String getTemplateUrl() {
        LynxTemplateRender r0 = this.mRender.get();
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r0.getTemplateUrl();
    }

    public void onEnterBackground() {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.pauseCasting();
        return;
    }

    public void onEnterForeground() {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.continueCasting();
        return;
    }

    public void onPageUpdate() {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.onPageUpdate();
        return;
    }

    public LynxBaseInspectorController getBaseInspectorController() {
        return this.mOwner;
    }

    public void attach(LynxView r2) {
        this.mView = new WeakReference(r2);
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.attach(r2);
        return;
    }

    public void attachContext(Context r2) {
        ILynxLogBox r0 = this.mLogBox;
        if (r0 == null) goto L6;
        r0.attachContext(r2);
        return;
    }

    public void attachLynxUIOwner(LynxUIOwner r2) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.attachLynxUIOwnerToAgent(r2);
        this.mOwner.setReloadHelper(this.mReloader);
        return;
    }

    public void attachToDebugBridge(String r2) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.attachToDebugBridge(r2);
        return;
    }

    public String getDebugInfoUrl(String r2) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 != null) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        return r0.getDebugInfoUrl(r2);
    }

    public long onBackgroundRuntimeCreated(String r3) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.onBackgroundRuntimeCreated(r3);
    }

    public void onGlobalPropsChanged(TemplateData r2) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L5;
        r0.onGlobalPropsUpdated(r2);
    L5:
        PageReloadHelper r1 = this.mReloader;
        if (r1 == null) goto L9;
        r1.onGlobalPropsUpdated(r2);
        return;
    }

    public void onMTSRuntimeCreated(long r2) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.onMTSRuntimeCreated(r2);
        return;
    }

    public void onReceiveMessageEvent(ReadableMap r2) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.onReceiveMessageEvent(r2);
        return;
    }

    public void onRegisterModule(LynxModuleFactory r5) {
        if (LynxEnv.inst().isLynxDebugEnabled() == true) goto L5;
        return;
    L5:
        ILynxDevToolService r0 = sDevToolService;
        if (r0 != null) goto L9;
        LLog.e(TAG, "sDevToolService is null");
        return;
    L9:
        Class<? extends LynxModule> r1 = r0.getDevToolSetModuleClass();
        if (r1 == null) goto L12;
        r5.c(r1.getSimpleName(), r1, null);
        LLog.i(TAG, "register LynxDevToolSetModule!");
    L12:
        Class<? extends LynxModule> r2 = sDevToolService.getLynxWebSocketModuleClass();
        if (r2 == null) goto L15;
        r5.c(r2.getSimpleName(), r2, null);
        LLog.i(TAG, "register LynxWebSocketModule!");
    L15:
        Class<? extends LynxModule> r3 = sDevToolService.getLynxTrailModule();
        if (r3 == null) goto L19;
        r5.c(r3.getSimpleName(), r3, null);
        LLog.i(TAG, "register LynxTrailModule!");
        return;
    }

    public void onRootViewInputEvent(InputEvent r2) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.onRootViewInputEvent(r2);
        return;
    }

    public void onTemplateAssemblerCreated(long r2) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.onTemplateAssemblerCreated(r2);
        return;
    }

    public void onTemplateDataChanged(TemplateData r2) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L5;
        r0.onTemplateDataUpdated(r2);
    L5:
        PageReloadHelper r1 = this.mReloader;
        if (r1 == null) goto L9;
        r1.onTemplateDataUpdated(r2);
        return;
    }

    public void onTemplateDataReset(TemplateData r2) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L5;
        r0.onTemplateDataReset(r2);
    L5:
        PageReloadHelper r1 = this.mReloader;
        if (r1 == null) goto L9;
        r1.onTemplateDataReset(r2);
        return;
    }

    public void onTemplateLoadSuccess(byte[] r2) {
        PageReloadHelper r0 = this.mReloader;
        if (r0 == null) goto L6;
        r0.onTemplateLoadSuccess(r2);
        return;
    }

    public void showErrorMessage(LynxError r2) {
        ILynxLogBox r0 = this.mLogBox;
        if (r0 == null) goto L5;
        r0.showLogMessage(r2);
    L5:
        LynxBaseInspectorController r1 = this.mOwner;
        if (r1 == null) goto L9;
        r1.showErrorMessageOnConsole(r2);
        return;
    }

    public LynxDevtool(Context r2, boolean r3) {
        this.mOwner = null;
        this.mLogBox = null;
        this.mReloader = null;
        this.mView = null;
        this.mRender = null;
        init(null, null, r3, r2);
    }

    public void attach(LynxView r2, LynxTemplateRender r3) {
        this.mView = new WeakReference(r2);
        this.mRender = new WeakReference(r3);
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.attach(r2);
    L6:
        if (this.mReloader == null) goto L8;
        this.mReloader.attach(r2);
    L8:
        LynxBaseInspectorController r4 = this.mOwner;
        if (r4 == null) goto L11;
        r4.setDevToolDelegate(new r(r3));
    L11:
        DisplayMetrics r5 = r3.getLynxContext().getScreenMetrics();
        updateScreenMetrics(r5.widthPixels, r5.heightPixels, r5.density);
    }

    public void onPerfMetricsEvent(String r2, JSONObject r3) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.onPerfMetricsEvent(r2, r3);
        return;
    }

    public LynxDevtool(LynxView r2, LynxTemplateRender r3, boolean r4) {
        this.mOwner = null;
        this.mLogBox = null;
        this.mReloader = null;
        this.mView = null;
        this.mRender = null;
        init(r2, r3, r4, r3.getLynxContext().getContext());
    }

    public void onLoadFromBundle(TemplateBundle r2, TemplateData r3, String r4) {
        PageReloadHelper r0 = this.mReloader;
        if (r0 == null) goto L5;
        r0.loadFromBundle(r2, r3, r4);
    L5:
        ILynxLogBox r5 = this.mLogBox;
        if (r5 == null) goto L9;
        r5.onLoadTemplate();
        return;
    }

    public void onLoadFromLocalFile(byte[] r2, TemplateData r3, String r4) {
        PageReloadHelper r0 = this.mReloader;
        if (r0 == null) goto L5;
        r0.loadFromLocalFile(r2, r3, r4);
    L5:
        ILynxLogBox r5 = this.mLogBox;
        if (r5 == null) goto L9;
        r5.onLoadTemplate();
        return;
    }

    public void updateScreenMetrics(int r2, int r3, float r4) {
        LynxBaseInspectorController r0 = this.mOwner;
        if (r0 == null) goto L6;
        r0.updateScreenMetrics(r2, r3, r4);
        return;
    }

    private void init(LynxView r5, LynxTemplateRender r6, boolean r7, Context r8) {
        TraceEvent.beginSection("LynxDevtool initialized");
        LLog.i(TAG, "Initialize LynxDevtool, lynxDebugEnabled:" + LynxEnv.inst().isLynxDebugEnabled());     // Catch: Exception -> L29
        this.mView = new WeakReference(r5);     // Catch: Exception -> L29
        this.mRender = new WeakReference(r6);     // Catch: Exception -> L29
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L21;
        LLog.i(TAG, "devtoolEnabled:" + LynxEnv.inst().isDevtoolEnabled() + ", logBoxEnabled:" + LynxEnv.inst().isLogBoxEnabled() + ", debuggable:" + r7);     // Catch: Exception -> L29
        sDevToolService = (ILynxDevToolService) n.c().a(ILynxDevToolService.class);     // Catch: Exception -> L29
        if (LynxEnv.inst().isDevtoolEnabled() == true) goto L8;
        if (r7 == true) goto L8;
    L14:
        if (LynxEnv.inst().isLogBoxEnabled() == false) goto L18;
        ILynxDevToolService r9 = sDevToolService;     // Catch: Exception -> L29
        if (r9 == null) goto L18;
        this.mLogBox = r9.createLogBox(this);     // Catch: Exception -> L29
        LLog.i(TAG, "LogBox init");     // Catch: Exception -> L29
    L18:
        if (r6 == null) goto L21;
        DisplayMetrics r10 = r6.getLynxContext().getScreenMetrics();     // Catch: Exception -> L29
        updateScreenMetrics(r10.widthPixels, r10.heightPixels, r10.density);     // Catch: Exception -> L29
    L8:
        ILynxDevToolService r0 = sDevToolService;     // Catch: Exception -> L29
        if (r0 == null) goto L14;
        LynxBaseInspectorController r11 = r0.createInspectorOwner(r5, r7);     // Catch: Exception -> L29
        this.mOwner = r11;     // Catch: Exception -> L29
        if (r11 == null) goto L14;
        LLog.i(TAG, "owner init");     // Catch: Exception -> L29
    L21:
        if (this.mOwner == null) goto L23;
    L24:
        this.mReloader = new PageReloadHelper(r5);     // Catch: Exception -> L29
    L25:
        LynxBaseInspectorController r12 = this.mOwner;     // Catch: Exception -> L29
        if (r12 == null) goto L31;
        r12.setDevToolDelegate(new r(r6));     // Catch: Exception -> L29
    L31:
        TraceEvent.endSection("LynxDevtool initialized");
        return;
    L23:
        if (this.mLogBox == null) goto L25;
    L29:
        e = move-exception;
        LLog.e(TAG, "failed to init LynxDevtool: " + e.toString());
        this.mOwner = null;
        this.mLogBox = null;
        this.mReloader = null;
        goto L31
    }

    public void onLoadFromURL(String r1, String r2, TemplateData r3, Map<String, Object> r4, String r5) {
        PageReloadHelper r6 = this.mReloader;
        if (r6 == null) goto L5;
        r6.saveURL(r1, r3, r4, r5);
    L5:
        ILynxLogBox r7 = this.mLogBox;
        if (r7 == null) goto L9;
        r7.onLoadTemplate();
        return;
    }
}
