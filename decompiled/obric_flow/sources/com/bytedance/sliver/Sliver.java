package com.bytedance.sliver;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class Sliver {
    private static final int SUPPORT_API_MAX = 31;
    private static final int SUPPORT_API_MIN = 19;
    private static final String TAG = "SLIVER";
    private static final Map<Thread, b> cache = null;
    private static final boolean isArt = false;
    private static volatile boolean isInit = false;
    private static final Map<String, Long> mark = null;
    private static final c sDefaultExecutor = null;
    private static final d sDefaultLogger = null;
    private static c sExecutor;
    private static d sLogger;
    private static boolean sLoggerEnable;
    private static final Field threadPeerField = null;
    private static final Field threadPeerFieldDalvik = null;

    public static final enum Mode extends Enum<Mode> {
        public static final Mode NORMAL = null;
        public static final Mode RING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f7510a = null;

        static {
            Mode r5 = new Mode("RING", 0);
            RING = r5;
            Mode r10 = new Mode("NORMAL", 1);
            NORMAL = r10;
            f7510a = new Mode[]{r5, r10};
        }

        public static Mode valueOf(String r5) {
            return (Mode) Enum.valueOf(Mode.class, r5);
        }

        public static Mode[] values() {
            return (Mode[]) f7510a.clone();
        }
    }

    static {
        cache = new ConcurrentHashMap(16);
        mark = new ConcurrentHashMap(16);
        sj.e r5 = new sj.e();
        sDefaultLogger = r5;
        sLogger = r5;
        sLoggerEnable = false;
        t9.a r10 = new t9.a();
        sDefaultExecutor = r10;
        sExecutor = r10;
        isArt = isArt();
        Field r11 = null;
    L8:
        Field r12 = null;
    L13:
        threadPeerField = r11;
        threadPeerFieldDalvik = r12;
        return;
    L5:
        if (isArt() == false) goto L9;
        Field r13 = Thread.class.getDeclaredField("nativePeer");     // Catch: Throwable -> L8
    L7:
        Field r14 = r13;
        r12 = r11;
        r11 = r14;
        r11.setAccessible(true);     // Catch: Throwable -> L16
        goto L13
    L9:
        r13 = Thread.class.getDeclaredField("vmThread");     // Catch: Throwable -> L8
        r11 = Class.forName("java.lang.VMThread").getDeclaredField("vmData");     // Catch: Throwable -> L14
        r11.setAccessible(true);     // Catch: Throwable -> L14
    L14:
        r12 = r11;
        r11 = r13;
        goto L13
    }

    public Sliver() {
    }

    public static /* synthetic */ Map access$100() {
        return mark;
    }

    public static /* synthetic */ void access$200(long r5, String r10, long r11) {
        nDump(r5, r10, r11);
    }

    public static /* synthetic */ void access$300(long r5) {
        nClear(r5);
    }

    public static boolean clear() {
        return clear(Thread.currentThread());
    }

    public static synchronized boolean clearAll() {
        monitor-enter(Sliver.class);
        boolean r5 = SliverAllThreadSupport.clearAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean dump(String r5) {
        return dump(Thread.currentThread(), r5);
    }

    public static synchronized boolean dumpAll(String r5) {
        monitor-enter(Sliver.class);
        boolean r10 = dumpAll(r5, false);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    public static void enableLog() {
        sLoggerEnable = true;
    }

    public static synchronized long[] getMethodStackTrace(Thread r10) {
        monitor-enter(Sliver.class);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == true) goto L12;
        long[] r11 = new long[0];     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return r11;
    L12:
        long r5 = getThreadPeer(r10);     // Catch: Throwable -> L10
        if (r5 != 0) goto L17;
        long[] r12 = new long[0];     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return r12;
    L17:
        long[] r13 = nGetMethodStackTrace(r10, r5);     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return r13;
    }

    public static synchronized String getStackTrace(long[] r5) {
        monitor-enter(Sliver.class);
        if (r5 == null) goto L14;
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r5.length == 0) goto L14;
        String r10 = nGetStackTrace(r5);     // Catch: Throwable -> L11
        monitor-exit(Sliver.class);
        return r10;
    L14:
        monitor-exit(Sliver.class);
        return "";
    }

    public static long getThreadPeer(Thread r5) {
        if (isArt() == false) goto L11;
        Field r10 = threadPeerField;
        if (r10 == null) goto L24;
        Object r11 = r10.get(r5);     // Catch: Throwable -> L21
        if (r11 != null) goto L10;
        return 0;
    L10:
        return ((Long) r11).longValue();
    L24:
        return 0;
    L11:
        Field r12 = threadPeerField;
        if (r12 == null) goto L25;
        Field r13 = threadPeerFieldDalvik;
        if (r13 == null) goto L26;
        Object r14 = r13.get(r12.get(r5));     // Catch: Throwable -> L21
        if (r14 != null) goto L20;
        return 0;
    L20:
        return ((Integer) r14).intValue();
    L26:
        return 0;
    L25:
        return 0;
    L28:
        return 0;
    }

    public static synchronized boolean init(boolean r10) {
        monitor-enter(Sliver.class);
        int r5 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L9
        if (r5 <= 31) goto L12;
        onError("not support api : " + r5 + ", sliver support 19-31", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L12:
        if (isInit == false) goto L17;
        onStep("sliver already init");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L17:
        if (loadLibrary() == true) goto L20;
        monitor-exit(Sliver.class);
        return false;
    L20:
        Method r11 = null;
        r11 = Looper.class.getMethod("loop", null);     // Catch: Throwable -> L32
    L23:
        if (nInit(r5, r11, r10, isArt) == true) goto L27;
        onError("sliver init failed, because native init error", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L27:
        isInit = true;     // Catch: Throwable -> L9
        onStep("sliver init success, protect is " + r10);     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L9:
        th = move-exception;
        throw th;
    }

    private static boolean isArt() {
        return true;
    }

    private static boolean loadLibrary() {
        System.loadLibrary("sliver");     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        onError("sliver so load failed", th);
        return false;
    }

    public static void mark(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        mark.put(r5, Long.valueOf(System.nanoTime()));
    }

    public static int mode2Int(Mode r5) {
        if (r5 != Mode.RING) goto L6;
        return 0;
    L6:
        if (r5 != Mode.NORMAL) goto L9;
        return 1;
    L9:
        return 0;
    }

    private static native void nClear(long r5);

    private static native void nDump(long r5, String r10, long r11);

    private static native long[] nGetMethodStackTrace(Thread r5, long r10);

    private static native String nGetStackTrace(Thread r5, long r10);

    private static native String nGetStackTrace(long[] r5);

    private static native boolean nInit(int r5, Method r10, boolean r11, boolean r12);

    private static native void nPause(long r5);

    private static native void nResetSamplingMs(long r5, int r10);

    private static native void nResume(long r5);

    private static native long nStart(Thread r5, long r10, int r11, int r12, int r13);

    private static native void nStop(long r5);

    public static void onError(String r5, Throwable r10) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        ((sj.e) sLogger).getClass();
        Log.e(TAG, r5, r10);
    }

    public static void onStep(String r5) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        ((sj.e) sLogger).getClass();
        Log.i(TAG, r5);
    }

    public static boolean pause() {
        return pause(Thread.currentThread());
    }

    public static synchronized boolean pauseAll() {
        monitor-enter(Sliver.class);
        boolean r5 = SliverAllThreadSupport.pauseAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(int r5) {
        monitor-enter(Sliver.class);
        boolean r10 = resetSamplingMs(Thread.currentThread(), r5);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean resume() {
        return resume(Thread.currentThread());
    }

    public static synchronized boolean resumeAll() {
        monitor-enter(Sliver.class);
        boolean r5 = SliverAllThreadSupport.resumeAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setExecutor(c r5) {
        if (r5 == null) goto L5;
        sExecutor = r5;
        return;
    }

    public static void setLogger(d r5) {
        if (r5 == null) goto L5;
        enableLog();
        sLogger = r5;
        return;
    }

    public static boolean start(int r5) {
        return start(Thread.currentThread(), r5, 100000, Mode.RING);
    }

    public static boolean startAll(int r5, int r10) {
        return startAll(r5, r10, 50000, Mode.RING, null);
    }

    public static boolean stop() {
        return stop(Thread.currentThread());
    }

    public static synchronized boolean stopAll() {
        monitor-enter(Sliver.class);
        boolean r5 = SliverAllThreadSupport.stopAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean clear(Thread r5) {
        monitor-enter(Sliver.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L11;
        onError(r5 + " clear failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L11:
        b r10 = cache.get(r5);     // Catch: Throwable -> L9
        if (r10 != null) goto L16;
        onError(r5 + " clear failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L16:
        c r11 = sExecutor;     // Catch: Throwable -> L9
        ab.b r12 = new ab.b(17, r10, r5);     // Catch: Throwable -> L9
        ((t9.a) r11).getClass();     // Catch: Throwable -> L9
        AsyncTask.execute(r12);     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean dump(String r5, String r10) {
        return dump(Thread.currentThread(), r5, r10);
    }

    public static synchronized boolean dumpAll(String r5, boolean r10) {
        monitor-enter(Sliver.class);
        boolean r11 = SliverAllThreadSupport.dumpAll(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean pause(Thread r10) {
        monitor-enter(Sliver.class);
        b r5 = cache.get(r10);     // Catch: Throwable -> L9
        if (r5 != null) goto L12;
        onError(r10 + " pause failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L12:
        if (r5.f7515b == true) goto L16;
        onStep(r10 + " already pause");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L16:
        nPause(r5.f7514a);     // Catch: Throwable -> L9
        r5.f7515b = false;     // Catch: Throwable -> L9
        onStep(r10 + " pause success");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L9:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(Thread r5, int r10) {
        monitor-enter(Sliver.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L11;
        onError(r5 + " reset sampling ms  failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L11:
        b r11 = cache.get(r5);     // Catch: Throwable -> L9
        if (r11 != null) goto L16;
        onError(r5 + " reset sampling ms  failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L16:
        nResetSamplingMs(r11.f7514a, r10);     // Catch: Throwable -> L9
        onStep(r5 + " reset sampling ms success");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean resume(Thread r10) {
        monitor-enter(Sliver.class);
        b r5 = cache.get(r10);     // Catch: Throwable -> L10
        if (r5 != null) goto L13;
        onError(r10 + " resume failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return false;
    L13:
        if (r5.f7515b == false) goto L17;
        onStep(r10 + " already resume");     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return true;
    L17:
        nResume(r5.f7514a);     // Catch: Throwable -> L10
        r5.f7515b = true;     // Catch: Throwable -> L10
        onStep(r10 + " resume success");     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return true;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean start(Thread r13, int r14, int r15, Mode r16) {
        monitor-enter(Sliver.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (SliverAllThreadSupport.isStart() == false) goto L12;
        onError("sliver start failed , because sliver all thread was started", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L12:
        if (init(false) == true) goto L16;
        onError("sliver start failed , because sliver init failed", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L16:
        Map<Thread, b> r10 = cache;     // Catch: Throwable -> L9
        if (r10.containsKey(r13) == false) goto L21;
        onStep(r13 + " already sampling by sliver");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L21:
        long r5 = getThreadPeer(r13);     // Catch: Throwable -> L9
        if (r5 != 0) goto L26;
        onError("sliver start failed , because can't get thread peer", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L26:
        long r11 = nStart(r13, r5, r14, r15, mode2Int(r16));     // Catch: Throwable -> L9
        if (r11 != 0) goto L31;
        onError("sliver start failed , because can't get native peer", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L31:
        b r12 = new b();     // Catch: Throwable -> L9
        r12.f7514a = r11;     // Catch: Throwable -> L9
        r12.f7515b = true;     // Catch: Throwable -> L9
        r10.put(r13, r12);     // Catch: Throwable -> L9
        onStep(r13 + " sampling by sliver success");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean startAll(int r5, int r10, int r11, Mode r12, e r13) {
        monitor-enter(Sliver.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (cache.isEmpty() == true) goto L10;
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (init(false) == true) goto L13;
        monitor-exit(Sliver.class);
        return false;
    L13:
        boolean r14 = SliverAllThreadSupport.startAll(r5, r10, r11, r12, r13);     // Catch: Throwable -> L16
        monitor-exit(Sliver.class);
        return r14;
    }

    public static synchronized boolean stop(Thread r5) {
        monitor-enter(Sliver.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L12;
        onError(r5 + " stop failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return false;
    L12:
        b r10 = cache.remove(r5);     // Catch: Throwable -> L10
        if (r10 != null) goto L17;
        onError(r5 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return true;
    L17:
        nStop(r10.f7514a);     // Catch: Throwable -> L10
        onStep(r5 + " stop success");     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean dump(Thread r5, String r10) {
        return dump(r5, r10, false);
    }

    public static boolean dump(Thread r5, String r10, String r11) {
        return dump(r5, r10, false, r11);
    }

    public static synchronized String getStackTrace(Thread r5) {
        monitor-enter(Sliver.class);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == false) goto L8;
        long r10 = getThreadPeer(r5);     // Catch: Throwable -> L10
        if (r10 == 0) goto L15;
        String r11 = nGetStackTrace(r5, r10);     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return r11;
    L15:
        monitor-exit(Sliver.class);
        return "";
    L8:
        monitor-exit(Sliver.class);
        return "";
    }

    public static synchronized boolean dump(Thread r5, String r10, boolean r11) {
        monitor-enter(Sliver.class);
        boolean r12 = dump(r5, r10, r11, null);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean dump(Thread r10, String r11, boolean r12, String r13) {
        monitor-enter(Sliver.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L11;
        onError(r10 + " dump failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L11:
        b r5 = cache.get(r10);     // Catch: Throwable -> L9
        if (r5 != null) goto L16;
        onError(r10 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L16:
        a r14 = new a(r13, r5, r11, r10, r12);     // Catch: Throwable -> L9
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L9
        r15.append(r10);     // Catch: Throwable -> L9
        r15.append(" dump ");     // Catch: Throwable -> L9
        if (r12 == false) goto L19;
        String r16 = "sync";
    L20:
        r15.append(r16);     // Catch: Throwable -> L9
        r15.append(" start");     // Catch: Throwable -> L9
        onStep(r15.toString());     // Catch: Throwable -> L9
        if (r12 == false) goto L23;
        r14.run();     // Catch: Throwable -> L9
    L24:
        monitor-exit(Sliver.class);
        return true;
    L23:
        ((t9.a) sExecutor).getClass();     // Catch: Throwable -> L9
        AsyncTask.execute(r14);     // Catch: Throwable -> L9
        goto L24
    L19:
        r16 = "async";
        goto L20
    }
}
