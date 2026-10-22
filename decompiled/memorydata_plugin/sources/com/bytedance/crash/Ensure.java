package com.bytedance.crash;

import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.CustomJavaHandler;
import com.bytedance.crash.event.SLIExceptionManager;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Map;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class Ensure {
    public static final String ENSURE_NOT_NULL = "EnsureNotNull";
    private static final int JAVA_CRASH_MAX_SIZE = 3;
    private static final int STACKTRACE_NORMAL_DEPTH = 4;
    private static int customJavaCrashCount;
    public static boolean isEnableUploadCustomJavaCrash;
    private static EventMonitor sAppMonitor;

    @Deprecated
    private static final EnsureImpl sInstance = null;

    static {
        sInstance = new EnsureImpl();
        customJavaCrashCount = 0;
    }

    public Ensure() {
    }

    @Deprecated
    public static boolean ensureFalse(boolean r0) {
        return false;
    }

    @Deprecated
    public static boolean ensureFalse(boolean r0, String r1) {
        return false;
    }

    @Deprecated
    public static boolean ensureFalse(boolean r0, String r1, Map<String, String> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        return false;
    }

    public static void ensureNativeNotReachHere(String r7, String r8, String r9, String r10, String r11) {
        MonitorManager.getAppEnsureManager().reportNativeEnsure(r7, r8, r9, r10, null, r11);
    }

    public static void ensureNativeStack(String r7, String r8, String r9, String r10, Map<String, String> r11) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        MonitorManager.getAppEnsureManager().reportNativeEnsure(r7, r8, r9, r10, r5, null);
    }

    public static void ensureNativeStack(String r7, String r8, String r9, String r10, Map<String, String> r11, String r12) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        MonitorManager.getAppEnsureManager().reportNativeEnsure(r7, r8, r9, r10, r5, r12);
    }

    public static void ensureNativeStackWithLogTypeDirect(String r7, String r8, String r9, String r10, String r11, Map<String, String> r12) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        MonitorManager.getAppEnsureManager().reportNativeEnsure(r8, r9, r10, r11, r5, r7);
    }

    @Deprecated
    public static boolean ensureNotEmpty(Collection r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        return false;
    }

    @Deprecated
    public static boolean ensureNotNull(Object r0) {
        return false;
    }

    @Deprecated
    public static boolean ensureNotNull(Object r0, String r1) {
        return false;
    }

    public static void ensureNotReachHere() {
        MonitorManager.getAppEnsureManager().reportMessage(4);
    }

    public static void ensureNotReachHere(String r2) {
        MonitorManager.getAppEnsureManager().reportMessage(r2, 4);
    }

    public static void ensureNotReachHere(String r9, Throwable r10, String r11, Map<String, String> r12) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        if (filterException(r10) == false) goto L5;
        return;
    L5:
        MonitorManager.getAppEnsureManager().reportJavaEnsure(r10, null, r11, r4, Thread.currentThread().getName(), r9, r9, true);
    }

    public static void ensureNotReachHere(String r2, Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        MonitorManager.getAppEnsureManager().reportMessage(r2, r4, 4);
    }

    public static void ensureNotReachHere(Throwable r1) {
        if (filterException(r1) == false) goto L5;
        return;
    L5:
        MonitorManager.getAppEnsureManager().reportThrowable(r1);
    }

    public static void ensureNotReachHere(Throwable r1, String r2) {
        if (filterException(r1) == false) goto L5;
        return;
    L5:
        MonitorManager.getAppEnsureManager().reportThrowable(r1, r2);
    }

    public static void ensureNotReachHere(Throwable r10, String r11, String r12, String r13) {
        if (filterException(r10) == false) goto L5;
        return;
    L5:
        MonitorManager.getAppEnsureManager().reportJavaEnsure(r10, null, r12, null, r11, r13, r13, true);
    }

    public static void ensureNotReachHere(Throwable r2, String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (filterException(r2) == false) goto L5;
        return;
    L5:
        MonitorManager.getAppEnsureManager().reportThrowable(r2, r3, r5);
    }

    public static void ensureNotReachHereWithLogType(String r1, Throwable r2, String r3) {
        if (filterException(r2) == false) goto L5;
        return;
    L5:
        MonitorManager.getAppEnsureManager().reportThrowable(r2, r3, r1);
    }

    public static void ensureNotReachHereWithLogTypeDirect(String r1, Throwable r2, String r3) {
        if (filterException(r2) == false) goto L5;
        return;
    L5:
        MonitorManager.getAppEnsureManager().reportThrowable(r2, r3, r1);
    }

    @Deprecated
    public static boolean ensureTrue(boolean r0) {
        return false;
    }

    @Deprecated
    public static boolean ensureTrue(boolean r0, String r1) {
        return false;
    }

    @Deprecated
    public static boolean ensureTrue(boolean r0, String r1, Map<String, String> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        return false;
    }

    public static boolean filterException(Throwable r2) {
        if (r2 != null) goto L39;
        return true;
    L39:
    L35:
        th = move-exception;
        th.printStackTrace();
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, ConnectTimeoutException.class) == false) goto L9;
        return true;
    L9:
        if (ZeusTransformUtils.instanceOf(r2, SocketTimeoutException.class) == false) goto L12;
        return true;
    L12:
        if (ZeusTransformUtils.instanceOf(r2, BindException.class) == false) goto L15;
        return true;
    L15:
        if (ZeusTransformUtils.instanceOf(r2, ConnectException.class) == false) goto L18;
        return true;
    L18:
        if (ZeusTransformUtils.instanceOf(r2, NoRouteToHostException.class) == false) goto L21;
        return true;
    L21:
        if (ZeusTransformUtils.instanceOf(r2, PortUnreachableException.class) == false) goto L24;
        return true;
    L24:
        if (ZeusTransformUtils.instanceOf(r2, SocketException.class) == false) goto L27;
        return true;
    L27:
        if (ZeusTransformUtils.instanceOf(r2, UnknownHostException.class) == false) goto L30;
        return true;
    L30:
        if (ZeusTransformUtils.instanceOf(r2, ProtocolException.class) == false) goto L32;
        return true;
    L32:
        if (ZeusTransformUtils.instanceOf(r2, SSLException.class) == false) goto L41;
        return true;
    L41:
        return false;
    }

    @Deprecated
    public static EnsureImpl getInstance() {
        return sInstance;
    }

    private static EventMonitor getMonitor() {
        if (sAppMonitor != null) goto L6;
        sAppMonitor = MonitorManager.getAppMonitor();
    L6:
        return sAppMonitor;
    }

    public static void reportCustomExceptionReasonDirect(String r9, Throwable r10, String r11, String r12, Map<String, String> r13, String r14, File r15) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        if (filterException(r10) == false) goto L5;
        return;
    L5:
        if (r14 == null) goto L9;
        if (r15 == null) goto L10;
        SLIExceptionManager.getInstance().reportException(r10, r11, r12, true, r5, r14, r9, r15);
        return;
    L10:
        return;
    }

    public static void reportCustomJavaCrash(Thread r1, Throwable r2) {
        CrashManager.getCustomJavaHandler().handleCustomException(r1, r2);
    }

    public static void reportJavaCrash(Thread r2, Throwable r3) {
        if (NpthCore.isInit() == true) goto L7;
        NpthLog.d("reportJavaCrash: npth is not init, dispose");
        return;
    L7:
        if (NpthCore.isStopUpload() == false) goto L11;
        NpthLog.d("reportJavaCrash: stop upload, dispose");
        return;
    L11:
        if (customJavaCrashCount < 3) goto L15;
        NpthLog.d("reportJavaCrash: > 3 times, dispose");
        return;
    L15:
        if (isEnableUploadCustomJavaCrash == true) goto L18;
        NpthLog.d("reportJavaCrash: discard because config");
        return;
    L18:
        CustomJavaHandler r0 = CrashManager.getCustomJavaHandler();
        if (r0 != null) goto L21;
        return;
    L21:
        customJavaCrashCount++;
        r0.handleCustomException(r2, r3);
    }

    public static void setUploadCustomJavaCrashEnable(boolean r0) {
        isEnableUploadCustomJavaCrash = r0;
    }
}
