package com.lynx.devtoolwrapper;

import android.content.Context;
import android.content.SharedPreferences;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DevToolSettings {
    private static final String CDP_DOMAIN_KEY_PREFIX = "enable_cdp_domain_";
    private static final int MAX_REPORTED_CALLER_FRAMES = 3;
    private static final String SP_KEY_ACTIVATED_CDP_DOMAINS = "activated_cdp_domains";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_CSS = "enable_cdp_domain_css";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_DEBUGGER = "enable_cdp_domain_debugger";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_DOM = "enable_cdp_domain_dom";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_OVERLAY = "enable_cdp_domain_overlay";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_PAGE = "enable_cdp_domain_page";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_RUNTIME = "enable_cdp_domain_runtime";
    public static final String SP_KEY_ENABLE_DEBUG_MODE = "enable_debug_mode";
    public static final String SP_KEY_ENABLE_DEVTOOL = "enable_devtool";
    public static final String SP_KEY_ENABLE_DOM_TREE = "enable_dom_tree";
    public static final String SP_KEY_ENABLE_FSP_SCREENSHOT = "enable_fsp_screenshot";
    public static final String SP_KEY_ENABLE_HIGHLIGHT_TOUCH = "enable_highlight_touch";
    public static final String SP_KEY_ENABLE_LAUNCH_RECORD = "enable_launch_record";
    public static final String SP_KEY_ENABLE_LOGBOX = "enable_logbox";
    public static final String SP_KEY_ENABLE_LONG_PRESS_MENU = "enable_long_press_menu";
    public static final String SP_KEY_ENABLE_PERF_METRICS = "enable_perf_metrics";
    public static final String SP_KEY_ENABLE_PIXEL_COPY = "enable_pixel_copy";
    public static final String SP_KEY_ENABLE_PREVIEW_SCREEN_SHOT = "enable_preview_screen_shot";
    public static final String SP_KEY_ENABLE_QUICKJS_CACHE = "enable_quickjs_cache";
    public static final String SP_KEY_ENABLE_QUICKJS_DEBUG = "enable_quickjs_debug";
    public static final String SP_KEY_ENABLE_V8 = "enable_v8";
    private static final String SP_KEY_IGNORE_ERROR_TYPES = "ignore_error_types";
    private static final String SP_NAME = "lynx_env_config";
    private static final String TAG = "DevToolSettings";
    public static final int V8_ALIGN_WITH_PROD = 2;
    public static final int V8_OFF = 0;
    public static final int V8_ON = 1;
    private static final String VM_STACK_CLASS_NAME = "dalvik.system.VMStack";
    private static volatile DevToolSettings sInstance;
    private final BootstrapSettings mBootstrapSettings;
    private volatile boolean mHighlightTouchEnabled;
    private volatile boolean mPerfMetricsEnabled;
    private volatile boolean mPreviewScreenshotEnabled;
    private SharedPreferences mSharedPreferences;

    /* JADX INFO: renamed from: com.lynx.devtoolwrapper.DevToolSettings$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class BootstrapSettings {
        private volatile Boolean mLoadQJSBridge;
        private volatile Boolean mLoadV8Bridge;
        private volatile Boolean mLogBoxEnabled;
        private volatile Boolean mLynxDebugEnabled;

        private void resetForTesting() {
            this.mLynxDebugEnabled = null;
            this.mLogBoxEnabled = null;
            this.mLoadQJSBridge = null;
            this.mLoadV8Bridge = null;
        }

        public void applyDevelopmentDefaultsIfUnset() {
            if (this.mLynxDebugEnabled != null) goto L6;
            this.mLynxDebugEnabled = Boolean.TRUE;
        L6:
            if (this.mLogBoxEnabled != null) goto L9;
            this.mLogBoxEnabled = Boolean.TRUE;
        L9:
            if (this.mLoadQJSBridge != null) goto L12;
            this.mLoadQJSBridge = Boolean.TRUE;
        L12:
            if (this.mLoadV8Bridge != null) goto L15;
            this.mLoadV8Bridge = Boolean.TRUE;
            return;
        }

        public boolean isLogBoxEnabled() {
            return isEnabled(this.mLogBoxEnabled);
        }

        public boolean isLynxDebugEnabled() {
            return isEnabled(this.mLynxDebugEnabled);
        }

        public boolean shouldLoadQJSBridge() {
            return isEnabled(this.mLoadQJSBridge);
        }

        public boolean shouldLoadV8Bridge() {
            return isEnabled(this.mLoadV8Bridge);
        }

        private BootstrapSettings() {
            this.mLynxDebugEnabled = null;
            this.mLogBoxEnabled = null;
            this.mLoadQJSBridge = null;
            this.mLoadV8Bridge = null;
        }

        public /* synthetic */ BootstrapSettings(AnonymousClass1 r1) {
            this();
        }

        public static /* synthetic */ void access$100(BootstrapSettings r0) {
            r0.resetForTesting();
        }

        private static boolean isEnabled(Boolean r0) {
            if (r0 != null) goto L4;
        L6:
            return false;
        L4:
            if (r0.booleanValue() == false) goto L6;
            return true;
        }

        public void setLoadQJSBridge(boolean r1) {
            this.mLoadQJSBridge = Boolean.valueOf(r1);
        }

        public void setLoadV8Bridge(boolean r1) {
            this.mLoadV8Bridge = Boolean.valueOf(r1);
        }

        public void setLogBoxEnabled(boolean r1) {
            this.mLogBoxEnabled = Boolean.valueOf(r1);
        }

        public void setLynxDebugEnabled(boolean r1) {
            this.mLynxDebugEnabled = Boolean.valueOf(r1);
        }
    }

    public static /* synthetic */ Map a(String r0) {
        return lambda$reportEnableEventIfNeeded$0(r0);
    }

    public static DevToolSettings inst() {
        if (sInstance != null) goto L15;
        monitor-enter(DevToolSettings.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DevToolSettings();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DevToolSettings.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public Set<String> getEnabledCDPDomains() {
        return getPersistedStringSet("activated_cdp_domains");
    }

    public Set<String> getIgnoredErrorTypes() {
        return getPersistedStringSet("ignore_error_types");
    }

    public int getV8Enabled() {
        return getPersistedInt("enable_v8", 2);
    }

    public boolean isDOMTreeEnabled() {
        return getPersistedBoolean("enable_dom_tree", true);
    }

    public boolean isDebugModeEnabled() {
        return getPersistedBoolean("enable_debug_mode", false);
    }

    public boolean isDevToolEnabled() {
        return getPersistedBoolean("enable_devtool", false);
    }

    public boolean isFSPScreenshotEnabled() {
        return getPersistedBoolean("enable_fsp_screenshot", false);
    }

    public boolean isLaunchRecordEnabled() {
        return getPersistedBoolean("enable_launch_record", false);
    }

    public boolean isLogBoxEnabled() {
        return getPersistedBoolean("enable_logbox", true);
    }

    public boolean isLongPressMenuEnabled() {
        return getPersistedBoolean("enable_long_press_menu", false);
    }

    public boolean isPixelCopyEnabled() {
        return getPersistedBoolean("enable_pixel_copy", true);
    }

    public boolean isQuickJSCacheEnabled() {
        return getPersistedBoolean("enable_quickjs_cache", true);
    }

    public boolean isQuickJSDebugEnabled() {
        return getPersistedBoolean("enable_quickjs_debug", true);
    }

    public void resetNonPersistedSettingsForTesting() {
        BootstrapSettings.access$100(this.mBootstrapSettings);
        this.mHighlightTouchEnabled = false;
        this.mPreviewScreenshotEnabled = true;
        this.mPerfMetricsEnabled = false;
    }

    private DevToolSettings() {
        this.mBootstrapSettings = new BootstrapSettings(null);
        this.mHighlightTouchEnabled = false;
        this.mPreviewScreenshotEnabled = true;
        this.mPerfMetricsEnabled = false;
    }

    public boolean isCSSErrorIgnored() {
        return isErrorTypeIgnored(130100);
    }

    public void syncToNative() {
        if (DevToolLifecycle.getInstance().isInitialized() == true) goto L6;
        LLog.e(TAG, "DevTool is not initialized yet, can't sync references to native");
        return;
    L6:
        syncToNativeBoolean("enable_devtool", getPersistedBoolean("enable_devtool", false));
        syncToNativeBoolean("enable_quickjs_cache", getPersistedBoolean("enable_quickjs_cache", true));
        syncToNativeInt("enable_v8", getPersistedInt("enable_v8", 2));
        syncToNativeBoolean("enable_quickjs_debug", getPersistedBoolean("enable_quickjs_debug", true));
        syncToNativeBoolean("enable_dom_tree", getPersistedBoolean("enable_dom_tree", true));
        syncToNativeBoolean("enable_logbox", getPersistedBoolean("enable_logbox", true));
        syncToNativeEnabledCDPDomains(getEnabledCDPDomains());
    }

    public BootstrapSettings bootstrap() {
        return this.mBootstrapSettings;
    }

    public boolean isHighlightTouchEnabled() {
        return this.mHighlightTouchEnabled;
    }

    public boolean isPerfMetricsEnabled() {
        return this.mPerfMetricsEnabled;
    }

    public boolean isPreviewScreenshotEnabled() {
        return this.mPreviewScreenshotEnabled;
    }

    private String getEnableCaller(String r8) {
        String r0 = DevToolSettings.class.getName();
        String r1 = LynxEnv.class.getName();
        return getCallerBacktrace(r0, r8, new String[]{r1}, new String[]{Thread.class.getName(), r0, r1});
    }

    private Set<String> getPersistedStringSet(String r3) {
        SharedPreferences r0 = this.mSharedPreferences;
        if (r0 == null) goto L5;
        Set<String> r4 = r0.getStringSet(r3, Collections.emptySet());
        if (r4 != null) goto L11;
        return new HashSet();
    L11:
        return new HashSet(r4);
    L5:
        return new HashSet();
    }

    private static /* synthetic */ Map lambda$reportEnableEventIfNeeded$0(String r2) {
        HashMap r0 = new HashMap();
        r0.put("backtrace", r2);
        return r0;
    }

    private void syncToNativeEnabledCDPDomains(Set<String> r3) {
        if (DevToolLifecycle.getInstance().isInitialized() == true) goto L5;
        return;
    L5:
        LynxEnv.inst().nativeSetGroupedEnvWithGroupSet("activated_cdp_domains", new HashSet(r3));
    }

    private boolean verifyCDPDomainKey(String r2) {
        if (r2.startsWith(CDP_DOMAIN_KEY_PREFIX) == true) goto L6;
        LLog.e(TAG, "Invalid CDP domain key: ".concat(r2));
        return false;
    L6:
        return true;
    }

    public void init(Context r3) {
        if (r3 != null) goto L5;
        LLog.e(TAG, "init with null context");
        return;
    L5:
        this.mSharedPreferences = r3.getSharedPreferences("lynx_env_config", 0);
    }

    public boolean isCDPDomainEnabled(String r2) {
        if (verifyCDPDomainKey(r2) == true) goto L7;
        return false;
    L7:
        return getEnabledCDPDomains().contains(r2);
    }

    public boolean isErrorTypeIgnored(int r2) {
        return getIgnoredErrorTypes().contains(String.valueOf(r2));
    }

    public void setCSSErrorIgnored(boolean r2) {
        setErrorTypeIgnored(130100, r2);
    }

    public void setDOMTreeEnabled(boolean r2) {
        setPersistedBoolean("enable_dom_tree", r2);
        syncToNativeBoolean("enable_dom_tree", r2);
    }

    public void setDebugModeEnabled(boolean r3) {
        setPersistedBoolean("enable_debug_mode", r3);
        reportEnableEventIfNeeded("setDebugModeEnabled", "lynxsdk_enable_debug_mode_event", r3);
    }

    public void setDevToolEnabled(boolean r3) {
        setPersistedBoolean("enable_devtool", r3);
        syncToNativeBoolean("enable_devtool", r3);
        reportEnableEventIfNeeded("setDevToolEnabled", "lynxsdk_enable_devtool_event", r3);
    }

    public void setEnabledCDPDomains(Collection<String> r3) {
        HashSet r0 = new HashSet(r3);
        Iterator r4 = r0.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        if (verifyCDPDomainKey((String) r4.next()) == true) goto L4;
        return;
    L8:
        setPersistedStringSet("activated_cdp_domains", r0);
        syncToNativeEnabledCDPDomains(r0);
    }

    public void setFSPScreenshotEnabled(boolean r2) {
        setPersistedBoolean("enable_fsp_screenshot", r2);
    }

    public void setHighlightTouchEnabled(boolean r1) {
        this.mHighlightTouchEnabled = r1;
    }

    public void setIgnoredErrorTypes(Collection<String> r2) {
        setPersistedStringSet("ignore_error_types", new HashSet(r2));
    }

    public void setLaunchRecordEnabled(boolean r2) {
        setPersistedBoolean("enable_launch_record", r2);
    }

    public void setLogBoxEnabled(boolean r3) {
        setPersistedBoolean("enable_logbox", r3);
        syncToNativeBoolean("enable_logbox", r3);
        reportEnableEventIfNeeded("setLogBoxEnabled", "lynxsdk_enable_logbox_event", r3);
    }

    public void setLongPressMenuEnabled(boolean r2) {
        setPersistedBoolean("enable_long_press_menu", r2);
    }

    public void setPerfMetricsEnabled(boolean r1) {
        this.mPerfMetricsEnabled = r1;
    }

    public void setPixelCopyEnabled(boolean r2) {
        setPersistedBoolean("enable_pixel_copy", r2);
    }

    public void setPreviewScreenshotEnabled(boolean r1) {
        this.mPreviewScreenshotEnabled = r1;
    }

    public void setQuickJSCacheEnabled(boolean r2) {
        setPersistedBoolean("enable_quickjs_cache", r2);
        syncToNativeBoolean("enable_quickjs_cache", r2);
    }

    public void setQuickJSDebugEnabled(boolean r2) {
        setPersistedBoolean("enable_quickjs_debug", r2);
        syncToNativeBoolean("enable_quickjs_debug", r2);
    }

    public void setV8Enabled(int r2) {
        setPersistedInt("enable_v8", r2);
        syncToNativeInt("enable_v8", r2);
    }

    private static String buildBacktrace(StackTraceElement[] r3, int r4) {
        StringBuilder r0 = new StringBuilder();
        int r1 = Math.min(r4 + 3, r3.length);
    L3:
        if (r4 >= r1) goto L9;
        if (r0.length() <= 0) goto L7;
        r0.append('\n');
    L7:
        r0.append(r3[r4]);
        r4 = r4 + 1;
        goto L3
    L9:
        return r0.toString();
    }

    private static int findFirstExternalFrameIndex(StackTraceElement[] r2, String... r3) {
        return findFirstNonSkippedFrameIndex(r2, 0, r3, true);
    }

    private boolean getPersistedBoolean(String r2, boolean r3) {
        SharedPreferences r0 = this.mSharedPreferences;
        if (r0 != null) goto L5;
        return r3;
    L5:
        return r0.getBoolean(r2, r3);
    }

    private int getPersistedInt(String r2, int r3) {
        SharedPreferences r0 = this.mSharedPreferences;
        if (r0 != null) goto L5;
        return r3;
    L5:
        return r0.getInt(r2, r3);
    }

    private static boolean matchesAnyClassName(String r4, String[] r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        if (r5[r2].equals(r4) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private void setPersistedBoolean(String r2, boolean r3) {
        SharedPreferences r0 = this.mSharedPreferences;
        if (r0 == null) goto L6;
        r0.edit().putBoolean(r2, r3).apply();
        return;
    }

    private void setPersistedInt(String r2, int r3) {
        SharedPreferences r0 = this.mSharedPreferences;
        if (r0 == null) goto L6;
        r0.edit().putInt(r2, r3).apply();
        return;
    }

    private void setPersistedStringSet(String r3, Set<String> r4) {
        SharedPreferences r0 = this.mSharedPreferences;
        if (r0 == null) goto L6;
        r0.edit().putStringSet(r3, new HashSet(r4)).apply();
        return;
    }

    private void syncToNativeBoolean(String r2, boolean r3) {
        if (DevToolLifecycle.getInstance().isInitialized() == true) goto L5;
        return;
    L5:
        LynxEnv r0 = LynxEnv.inst();
        if (r3 == false) goto L8;
        String r4 = "1";
    L9:
        r0.nativeSetLocalEnv(r2, r4);
        return;
    L8:
        r4 = "0";
        goto L9
    }

    private void syncToNativeInt(String r2, int r3) {
        if (DevToolLifecycle.getInstance().isInitialized() == true) goto L5;
        return;
    L5:
        LynxEnv.inst().nativeSetLocalEnv(r2, String.valueOf(r3));
    }

    public void setCDPDomainEnabled(String r2, boolean r3) {
        if (verifyCDPDomainKey(r2) == true) goto L5;
        return;
    L5:
        Set<String> r0 = getEnabledCDPDomains();
        if (r3 == false) goto L8;
        boolean r4 = r0.add(r2);
    L9:
        if (r4 == true) goto L11;
        return;
    L11:
        setPersistedStringSet("activated_cdp_domains", r0);
        syncToNativeEnabledCDPDomains(r0);
        return;
    L8:
        r4 = r0.remove(r2);
        goto L9
    }

    public void setErrorTypeIgnored(int r2, boolean r3) {
        Set<String> r0 = getIgnoredErrorTypes();
        String r4 = String.valueOf(r2);
        if (r3 == false) goto L5;
        boolean r5 = r0.add(r4);
    L6:
        if (r5 == true) goto L8;
        return;
    L8:
        setPersistedStringSet("ignore_error_types", r0);
        return;
    L5:
        r5 = r0.remove(r4);
        goto L6
    }

    private static int findFirstNonSkippedFrameIndex(StackTraceElement[] r1, int r2, String... r3) {
        return findFirstNonSkippedFrameIndex(r1, r2, r3, false);
    }

    private void reportEnableEventIfNeeded(String r1, String r2, boolean r3) {
        if (r3 == true) goto L4;
        return;
    L4:
        final String r4 = getEnableCaller(r1);
        LynxEventReporter.onEvent(r2, -1, new a(r4));
    }

    private static int findFirstNonSkippedFrameIndex(StackTraceElement[] r3, int r4, String[] r5, boolean r6) {
        if (r3 != null) goto L5;
        return -1;
    L5:
        int r7 = Math.max(r4, 0);
    L7:
        if (r7 >= r3.length) goto L17;
        String r1 = r3[r7].getClassName();
        if (r6 == false) goto L14;
        if (VM_STACK_CLASS_NAME.equals(r1) == false) goto L14;
    L16:
        r7 = r7 + 1;
    L14:
        if (matchesAnyClassName(r1, r5) == true) goto L16;
        return r7;
    L17:
        return -1;
    }

    public static String getCallerBacktrace(String r1, String r2, String[] r3, String[] r4) {
        return getCallerBacktrace(ThreadMethodProxy.currentThread().getStackTrace(), r1, r2, r3, r4);
    }

    public static String getCallerBacktrace(StackTraceElement[] r4, String r5, String r6, String[] r7, String[] r8) {
        if (r4 != null) goto L5;
    L24:
        return "Unknown caller";
    L5:
        if (r4.length == 0) goto L24;
        int r1 = 0;
    L9:
        if (r1 >= r4.length) goto L20;
        StackTraceElement r2 = r4[r1];
        if (r6.equals(r2.getMethodName()) == false) goto L19;
        if (r5.equals(r2.getClassName()) == false) goto L19;
        int r9 = findFirstNonSkippedFrameIndex(r4, r1 + 1, r7);
        if (r9 < 0) goto L20;
        return buildBacktrace(r4, r9);
    L19:
        r1 = r1 + 1;
    L20:
        int r10 = findFirstExternalFrameIndex(r4, r8);
        if (r10 < 0) goto L24;
        return buildBacktrace(r4, r10);
    }
}
