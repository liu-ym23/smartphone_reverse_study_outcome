package com.ss.android.socialbase.downloader.logger;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import el9.a;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class Logger {
    public static final boolean DEBUG = false;
    private static final String DOWNLOAD_TAG_PREFIX = "MNetDownloader-";
    private static final String KEY_GLOBAL_REPORT = "GlobalReport";
    private static final String KEY_TASK_REPORT = "TaskReport";
    private static final String TAG = "DownloaderLogger";
    private static final String TAG_GLOBAL_FORMAT = "[MNetDownloader|Global|%s]";
    private static final String TAG_TASK_FORMAT = "[MNetDownloader|%d|%s]";
    private static Object mAlogLock;
    private static Set mAlogTaskSceneList;
    private static boolean mEnableALogWritter;
    private static boolean mEnableGlobalReport;
    private static int mLevel;
    private static ILogReport mLogReport;
    private static Set mTaskReportSceneList;
    private static ILogWritter sLogWritter;

    public static class ALogHolder {
        private static Method mAlogMethod;

        private ALogHolder() {
        }

        public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
            return Class.forName(r0);
        }

        private static Method getAlogMethod() {
            return INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger$ALogHolder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.agilelogger.ALog").getMethod("e", new Class[]{String.class, String.class});
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }

        static {
            mAlogMethod = getAlogMethod();
        }

        public static /* synthetic */ Method access$000() {
            return mAlogMethod;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_ss_android_socialbase_downloader_logger_Logger$ALogHolder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r2 = access$001(r3);     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r3);
        L12:
            throw th;
        L34:
            Class r4 = access$001(r3);     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
        L16:
            return r4;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r3);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r3);
        }
    }

    public Logger() {
    }

    private static boolean isLoggerParamsValid(String r0, String r1, String r2) {
        if (r0 == null) goto L6;
        if (r1 == null) goto L6;
        if (r2 == null) goto L6;
        return true;
    L6:
        return false;
    }

    static {
        mAlogLock = new Object();
        mEnableALogWritter = false;
        mLevel = 6;
        mTaskReportSceneList = new CopyOnWriteArraySet();
        mAlogTaskSceneList = new CopyOnWriteArraySet();
    }

    public static boolean alog() {
        if (mLevel > 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean debug() {
        if (mLevel > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getLogLevel() {
        return mLevel;
    }

    public static void alertErrorInfo(String r1) {
        if (debug() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r1);
    }

    public static void d(String r1) {
        d(TAG, r1);
    }

    public static boolean debugScene(String r3) {
        if (mAlogTaskSceneList.isEmpty() == true) goto L13;
        if (mAlogTaskSceneList.contains(r3) == false) goto L13;
        if (mLevel <= 4) goto L17;
        return false;
    L17:
        return true;
    L13:
        if (mLevel <= 3) goto L18;
        return false;
    L18:
        return true;
    }

    public static String downloaderTag(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return TAG;
    L5:
        return DOWNLOAD_TAG_PREFIX + r2;
    }

    public static void e(String r1) {
        e(TAG, r1);
    }

    private static String getSimpleClassName(String r1) {
        int r0 = r1.lastIndexOf(46);
        if (r0 >= 0) goto L6;
        return r1;
    L6:
        return r1.substring(r0 + 1);
    }

    public static void i(String r1) {
        i(TAG, r1);
    }

    public static void k(String r1) {
        k(TAG, r1);
    }

    public static void registerLogHandler(ILogWritter r2) {
        Object r0 = mAlogLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (mEnableALogWritter == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        sLogWritter = r2;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public static void registerLogReport(ILogReport r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        mLogReport = r0;
    }

    public static void setLogLevel(int r2) {
        Object r0 = mAlogLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (mEnableALogWritter == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        mLevel = r2;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public static void throwException(Throwable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.printStackTrace();
        if (debug() == true) goto L8;
        return;
    L8:
        throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", r2);
    }

    public static void v(String r1) {
        v(TAG, r1);
    }

    public static void w(String r1) {
        w(TAG, r1);
    }

    public static boolean debugScene(DownloadInfo r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return debugScene(r0.getMonitorScene());
    }

    public static void alogE(String r3, String r4) {
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (ALogHolder.access$000() == null) goto L11;
        ALogHolder.access$000().invoke(null, new Object[]{r3, r4});     // Catch: Throwable -> L6
        return;
    }

    public static void d(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 3) goto L7;
        downloaderTag(r2);
    L7:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L11;
        r0.logD(downloaderTag(r2), r3);
        return;
    }

    public static void e(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 6) goto L7;
        downloaderTag(r2);
    L7:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L11;
        r0.logE(downloaderTag(r2), r3);
        return;
    }

    public static void i(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 4) goto L7;
        downloaderTag(r2);
    L7:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L11;
        r0.logI(downloaderTag(r2), r3);
        return;
    }

    public static void k(String r2, String r3) {
        if (mLevel > 3) goto L5;
        downloaderTag(r2);
    L5:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L9;
        r0.logK(downloaderTag(r2), r3);
        return;
    }

    public static void st(String r5, int r6) {
    L4:
        e = move-exception;
        StackTraceElement[] r0 = e.getStackTrace();
        StringBuilder r1 = new StringBuilder();
        int r3 = 1;
    L7:
        if (r3 >= Math.min(r6, r0.length)) goto L11;
        if (r3 <= 1) goto L10;
        r1.append("\n");
    L10:
        r1.append(getSimpleClassName(r0[r3].getClassName()));
        r1.append(".");
        r1.append(r0[r3].getMethodName());
        r3 = r3 + 1;
        goto L7
    L11:
        v(downloaderTag(r5), r1.toString());
        return;
    L3:
        throw new Exception();     // Catch: Exception -> L4
    }

    public static void v(String r1, String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L8;
        r0.logV(downloaderTag(r1), r2);
        return;
    }

    public static void w(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (mLevel > 5) goto L7;
        downloaderTag(r2);
    L7:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L11;
        r0.logW(downloaderTag(r2), r3);
        return;
    }

    public static void d(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 3) goto L8;
        downloaderTag(r2);
    L8:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L12;
        r0.logD(downloaderTag(r2), r3 + r4);
        return;
    }

    public static void e(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 6) goto L8;
        downloaderTag(r2);
    L8:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L12;
        r0.logE(downloaderTag(r2), r3, r4);
        return;
    }

    private static void globalAlog(String r2, String r3, String r4) {
        if (isLoggerParamsValid(r2, r3, r4) == true) goto L5;
        return;
    L5:
        if (mLevel > 4) goto L13;
        String r5 = String.format(TAG_GLOBAL_FORMAT, new Object[]{r2});
        String r6 = r3 + "|" + r4;
        ILogWritter r7 = sLogWritter;
        if (r7 == null) goto L12;
        r7.logE(r5, r6);
        return;
    L12:
        return;
    }

    public static void globalDebug(String r2, String r3, String r4) {
        if (isLoggerParamsValid(r2, r3, r4) == true) goto L6;
        return;
    L6:
        if (alog() == false) goto L10;
        globalAlog(r2, r3, r4);
        return;
    L10:
        if (mLevel <= 3) goto L12;
        return;
    L12:
        String r5 = String.format(TAG_GLOBAL_FORMAT, new Object[]{r2});
        String r6 = r3 + "|" + r4;
        ILogWritter r7 = sLogWritter;
        if (r7 == null) goto L16;
        r7.logD(r5, r6);
        return;
    }

    public static void globalError(String r2, String r3, String r4) {
        if (isLoggerParamsValid(r2, r3, r4) == true) goto L5;
        return;
    L5:
        globalReport(r2, r3, r4);
        if (alog() == false) goto L10;
        globalAlog(r2, r3, r4);
        return;
    L10:
        if (mLevel <= 6) goto L12;
        return;
    L12:
        String r5 = String.format(TAG_GLOBAL_FORMAT, new Object[]{r2});
        String r6 = r3 + "|" + r4;
        ILogWritter r7 = sLogWritter;
        if (r7 == null) goto L16;
        r7.logE(r5, r6);
        return;
    }

    private static void globalReport(String r2, String r3, String r4) {
        if (mEnableGlobalReport == true) goto L5;
        return;
    L5:
        if (isLoggerParamsValid(r2, r3, r4) == false) goto L13;
        ILogReport r0 = mLogReport;
        if (r0 == null) goto L12;
        r0.monitorEvent(KEY_GLOBAL_REPORT, r2 + "|" + r3 + "|" + r4);
        return;
    L12:
        return;
    }

    public static void i(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 4) goto L8;
        downloaderTag(r2);
    L8:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L12;
        r0.logI(downloaderTag(r2), r3, r4);
        return;
    }

    public static void v(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L5;
        if (r4 != null) goto L5;
        return;
    L5:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L9;
        r0.logV(downloaderTag(r2), r3 + r4);
        return;
    }

    public static void w(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (mLevel > 5) goto L8;
        downloaderTag(r2);
    L8:
        ILogWritter r0 = sLogWritter;
        if (r0 == null) goto L12;
        r0.logW(downloaderTag(r2), r3, r4);
        return;
    }

    public static void setLogReportParams(int r2, boolean r3, List<String> r4, List<String> r5) {
        Object r0 = mAlogLock;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (mEnableALogWritter == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L8:
        mEnableALogWritter = true;     // Catch: Throwable -> L25
        mLevel = r2;     // Catch: Throwable -> L25
        sLogWritter = new AlogHandler(null);     // Catch: Throwable -> L25
        mEnableGlobalReport = r3;     // Catch: Throwable -> L25
        if (r4 != null) goto L11;
    L16:
        if (r5 != null) goto L18;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L18:
        if (r5.isEmpty() == true) goto L23;
        Iterator<String> r6 = r5.iterator();     // Catch: Throwable -> L25
    L21:
        if (r6.hasNext() == false) goto L23;
        String r7 = r6.next();     // Catch: Throwable -> L25
        mAlogTaskSceneList.add(r7);     // Catch: Throwable -> L25
        goto L21
    L11:
        if (r4.isEmpty() == true) goto L16;
        Iterator<String> r8 = r4.iterator();     // Catch: Throwable -> L25
    L14:
        if (r8.hasNext() == false) goto L16;
        String r9 = r8.next();     // Catch: Throwable -> L25
        mTaskReportSceneList.add(r9);     // Catch: Throwable -> L25
        goto L14
    }

    private static void taskAlog(String r2, int r3, String r4, String r5) {
        if (isLoggerParamsValid(r2, r4, r5) == true) goto L5;
        return;
    L5:
        String r6 = String.format(TAG_TASK_FORMAT, new Object[]{Integer.valueOf(r3), r2});
        String r7 = r4 + "|" + r5;
        ILogWritter r8 = sLogWritter;
        if (r8 == null) goto L9;
        r8.logE(r6, r7);
        return;
    }

    public static void taskDebug(String r6, DownloadInfo r7, String r8, String r9) {
        taskDebug(r6, r7.getId(), r7.getMonitorScene(), r8, r9, false);
    }

    public static void taskError(String r3, int r4, String r5, String r6) {
        if (isLoggerParamsValid(r3, r5, r6) == true) goto L5;
        return;
    L5:
        globalReport(r3, r5, r4 + "|" + r6);
        if (alog() == false) goto L10;
        taskAlog(r3, r4, r5, r6);
        return;
    L10:
        if (mLevel <= 6) goto L12;
        return;
    L12:
        String r7 = String.format(TAG_TASK_FORMAT, new Object[]{Integer.valueOf(r4), r3});
        String r8 = r5 + "|" + r6;
        ILogWritter r9 = sLogWritter;
        if (r9 == null) goto L16;
        r9.logE(r7, r8);
        return;
    }

    public static void taskDebug(String r6, int r7, String r8, String r9) {
        taskDebug(r6, r7, null, r8, r9, false);
    }

    public static void taskDebug(String r6, DownloadInfo r7, String r8, String r9, boolean r10) {
        taskDebug(r6, r7.getId(), r7.getMonitorScene(), r8, r9, r10);
    }

    private static void taskReport(String r2, int r3, String r4, String r5, String r6) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (mTaskReportSceneList.isEmpty() == false) goto L7;
        return;
    L7:
        if (mTaskReportSceneList.contains(r4) == true) goto L9;
        return;
    L9:
        if (isLoggerParamsValid(r2, r5, r6) == false) goto L19;
        ILogReport r0 = mLogReport;
        if (r0 == null) goto L18;
        r0.monitorEvent(KEY_TASK_REPORT, r2 + "|" + r3 + "|" + r4 + "|" + r5 + "|" + r6);
        return;
    L18:
        return;
    }

    public static void taskDebug(String r1, int r2, String r3, String r4, String r5, boolean r6) {
        if (isLoggerParamsValid(r1, r4, r5) == true) goto L5;
        return;
    L5:
        if (r6 == false) goto L8;
        taskReport(r1, r2, r3, r4, r5);
    L8:
        if (alog() == false) goto L14;
        if (TextUtils.isEmpty(r3) == true) goto L14;
        taskAlog(r1, r2, r4, r5);
        return;
    L14:
        if (mLevel <= 3) goto L16;
        return;
    L16:
        String r7 = String.format(TAG_TASK_FORMAT, new Object[]{Integer.valueOf(r2), r1});
        String r8 = r4 + "|" + r5;
        ILogWritter r9 = sLogWritter;
        if (r9 == null) goto L20;
        r9.logD(r7, r8);
        return;
    }
}
