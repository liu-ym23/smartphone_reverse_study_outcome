package com.lynx.devtool;

import android.content.Context;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.debugrouter.DebugRouter;
import com.lynx.devtool.memory.MemoryController;
import com.lynx.devtoolwrapper.DevToolLifecycle;
import com.lynx.devtoolwrapper.DevToolSettings;
import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.LynxTraceEnv;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxDevtoolEnv {
    public static final String ENABLE_PERF_METRICS = "enable_perf_metrics";
    private static volatile LynxDevtoolEnv sInstance;
    private final String TAG;
    private Context mContext;
    private INativeLibraryLoader mDevtoolLibraryLoader;

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public String getVersion() {
        return "4.1.1-rc.34";
    }

    public boolean isAttached() {
        return true;
    }

    public void setShowDevtoolBadge(boolean r1) {
    }

    public boolean showDevtoolBadge() {
        return false;
    }

    public static LynxDevtoolEnv inst() {
        if (sInstance != null) goto L15;
        monitor-enter(LynxDevtoolEnv.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LynxDevtoolEnv();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxDevtoolEnv.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void loadNativeDevtoolLibrary() {
        INativeLibraryLoader r0 = this.mDevtoolLibraryLoader;
        if (r0 == null) goto L12;
        r0.loadLibrary("lynxdebugrouter");
        this.mDevtoolLibraryLoader.loadLibrary("basedevtool");
        this.mDevtoolLibraryLoader.loadLibrary("lynxdevtool");
        if (shouldLoadQJSBridge() == false) goto L8;
        this.mDevtoolLibraryLoader.loadLibrary("lynxdevtool_qjs_bridge");
    L8:
        if (shouldLoadV8Bridge() == false) goto L10;
        this.mDevtoolLibraryLoader.loadLibrary("v8_libfull.cr");
        this.mDevtoolLibraryLoader.loadLibrary("lynxdevtool_v8_bridge");
    L10:
        LLog.i("LynxDevtoolEnv", "liblynxdevtool and libv8_libfull loaded via custom devtool library loader");
    L27:
        LynxEnv.inst().setDevLibraryLoaded(true);
        return;
    L12:
        if (LynxEnv.inst().getLibraryLoader() == null) goto L20;
        LynxEnv.inst().getLibraryLoader().loadLibrary("lynxdebugrouter");
        LynxEnv.inst().getLibraryLoader().loadLibrary("basedevtool");
        LynxEnv.inst().getLibraryLoader().loadLibrary("lynxdevtool");
        if (shouldLoadQJSBridge() == false) goto L17;
        LynxEnv.inst().getLibraryLoader().loadLibrary("lynxdevtool_qjs_bridge");
    L17:
        if (shouldLoadV8Bridge() == false) goto L19;
        LynxEnv.inst().getLibraryLoader().loadLibrary("v8_libfull.cr");
        LynxEnv.inst().getLibraryLoader().loadLibrary("lynxdevtool_v8_bridge");
    L19:
        LLog.i("LynxDevtoolEnv", "liblynxdevtool loaded via library loader");
        goto L27
    L20:
        INVOKESTATIC_com_lynx_devtool_LynxDevtoolEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("basedevtool");
        INVOKESTATIC_com_lynx_devtool_LynxDevtoolEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lynxdevtool");
        if (shouldLoadQJSBridge() == false) goto L24;
        INVOKESTATIC_com_lynx_devtool_LynxDevtoolEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lynxdevtool_qjs_bridge");
    L24:
        if (shouldLoadV8Bridge() == false) goto L26;
        INVOKESTATIC_com_lynx_devtool_LynxDevtoolEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("v8_libfull.cr");
        INVOKESTATIC_com_lynx_devtool_LynxDevtoolEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lynxdevtool_v8_bridge");
    L26:
        LLog.i("LynxDevtoolEnv", "liblynxdevtool loaded via system loader");
        goto L27
    }

    private LynxDevtoolEnv() {
        this.TAG = "LynxDevtoolEnv";
        this.mDevtoolLibraryLoader = null;
    }

    private boolean shouldLoadQJSBridge() {
        return DevToolSettings.inst().bootstrap().shouldLoadQJSBridge();
    }

    private boolean shouldLoadV8Bridge() {
        return DevToolSettings.inst().bootstrap().shouldLoadV8Bridge();
    }

    public void enableAllSessions() {
        DebugRouter.getInstance().enableAllSessions();
    }

    public int getV8Enabled() {
        return DevToolSettings.inst().getV8Enabled();
    }

    public boolean isDomTreeEnabled() {
        return DevToolSettings.inst().isDOMTreeEnabled();
    }

    public boolean isLongPressMenuEnabled() {
        return DevToolSettings.inst().isLongPressMenuEnabled();
    }

    public boolean isPerfMetricsEnabled() {
        return DevToolSettings.inst().isPerfMetricsEnabled();
    }

    public boolean isPreviewScreenShotEnabled() {
        return DevToolSettings.inst().isPreviewScreenshotEnabled();
    }

    public boolean isQuickjsCacheEnabled() {
        return DevToolSettings.inst().isQuickJSCacheEnabled();
    }

    public boolean isQuickjsDebugEnabled() {
        return DevToolSettings.inst().isQuickJSDebugEnabled();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_devtool_LynxDevtoolEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    private void setDefaultAppInfo(Context r5) {
        HashMap r0 = new HashMap();
        String r1 = r5.getPackageManager().getApplicationInfo(r5.getPackageName(), LynxTouchEvent.kPseudoStateFocusTransition).loadLabel(r5.getPackageManager()).toString();     // Catch: Throwable -> L7
        if (r1 == null) goto L9;
        r0.put("App", r1);     // Catch: Throwable -> L7
    L9:
        LynxGlobalDebugBridge.getInstance().setAppInfo(r5, r0);
        return;
    L7:
        th = move-exception;
        LLog.w("LynxDevtoolEnv", th.toString());
        goto L9
    }

    private boolean tryLoadDebugLynxLibrary(INativeLibraryLoader r6) {
        if (LynxEnv.inst().isDebugModeEnabled() == true) goto L20;
    L19:
        return false;
    L20:
        if (r6 == null) goto L13;
        if (LynxLiteConfigs.requireQuickSharedLibrary() == false) goto L9;
        r6.loadLibrary("quick");     // Catch: UnsatisfiedLinkError -> L17
    L9:
        r6.loadLibrary("lynx_debug");     // Catch: UnsatisfiedLinkError -> L17
        if (LynxTraceEnv.inst().isNativeLibraryLoaded() == true) goto L16;
        r6.loadLibrary("lynxtrace");     // Catch: UnsatisfiedLinkError -> L17
        LynxTraceEnv.inst().markNativeLibraryLoaded(true);     // Catch: UnsatisfiedLinkError -> L17
    L16:
        return true;
    L13:
        if (LynxLiteConfigs.requireQuickSharedLibrary() == false) goto L15;
        INVOKESTATIC_com_lynx_devtool_LynxDevtoolEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("quick");     // Catch: UnsatisfiedLinkError -> L17
    L15:
        INVOKESTATIC_com_lynx_devtool_LynxDevtoolEnv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lynx_debug");     // Catch: UnsatisfiedLinkError -> L17
    L17:
        e = move-exception;
        LLog.e("LynxDevtoolEnv", "Debug Lynx Library load from system with error message " + e.getMessage());
        goto L19
    }

    public void enableDomTree(boolean r2) {
        DevToolSettings.inst().setDOMTreeEnabled(r2);
    }

    public void enableLongPressMenu(boolean r2) {
        DevToolSettings.inst().setLongPressMenuEnabled(r2);
    }

    public void enablePerfMetrics(boolean r2) {
        DevToolSettings.inst().setPerfMetricsEnabled(r2);
    }

    public void enableQuickjsCache(boolean r2) {
        DevToolSettings.inst().setQuickJSCacheEnabled(r2);
    }

    public void enableQuickjsDebug(boolean r2) {
        DevToolSettings.inst().setQuickJSDebugEnabled(r2);
    }

    public void enableV8(int r3) {
        if (r3 <= 2) goto L5;
        LLog.w("LynxDevtoolEnv", "The value must be 0 or 1 or 2. Change the value to 2!");
        r3 = 2;
    L7:
        DevToolSettings.inst().setV8Enabled(r3);
        return;
    L5:
        if (r3 >= 0) goto L7;
        LLog.w("LynxDevtoolEnv", "The value must be 0 or 1 or 2. Change the value to 0!");
        r3 = 0;
        goto L7
    }

    public void init(Context r3) {
    L19:
        th = move-exception;
        LLog.e("LynxDevtoolEnv", th.toString());
        throw th;
    L3:
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L9;
        if (tryLoadDebugLynxLibrary(LynxEnv.inst().getLibraryLoader()) == false) goto L7;
        LynxEnv.inst().setNativeLibraryLoaded(true);     // Catch: Throwable -> L19
        goto L9
    L7:
        LynxEnv.inst().initNativeLibraries(LynxEnv.inst().getLibraryLoader());     // Catch: Throwable -> L19
    L9:
        if (this.mContext != null) goto L12;
        this.mContext = r3;     // Catch: Throwable -> L19
    L12:
        if (LynxEnv.inst().isDevLibraryLoaded() == true) goto L14;
        loadNativeDevtoolLibrary();     // Catch: Throwable -> L19
    L14:
        MemoryController.getInstance().init(this.mContext);     // Catch: Throwable -> L19
        setDefaultAppInfo(r3);     // Catch: Throwable -> L19
        DevToolLifecycle.getInstance().onInitialized();
        DevToolSettings.inst().syncToNative();
        if (LynxGlobalDebugBridge.getInstance().isEnabled() == false) goto L24;
        DevToolLifecycle.getInstance().onConnected();
        return;
    }

    public boolean isErrorTypeIgnored(int r2) {
        return DevToolSettings.inst().isErrorTypeIgnored(r2);
    }

    public boolean isIgnoreErrorTypeEnabled(Integer r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (DevToolSettings.inst().isErrorTypeIgnored(r2.intValue()) == false) goto L6;
        return true;
    }

    public void setDevToolLibraryLoader(INativeLibraryLoader r1) {
        this.mDevtoolLibraryLoader = r1;
    }
}
