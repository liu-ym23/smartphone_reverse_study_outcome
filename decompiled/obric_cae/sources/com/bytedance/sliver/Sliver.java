package com.bytedance.sliver;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class Sliver {
    private static final int SUPPORT_API_MAX = 31;
    private static final int SUPPORT_API_MIN = 19;
    private static final String TAG = "SLIVER";
    private static final Map<Thread, f> cache = null;
    private static final boolean isArt = false;
    private static volatile boolean isInit = false;
    private static final Map<String, Long> mark = null;
    private static final g sDefaultExecutor = null;
    private static final h sDefaultLogger = null;
    private static g sExecutor;
    private static h sLogger;
    private static boolean sLoggerEnable;
    private static final Field threadPeerField = null;
    private static final Field threadPeerFieldDalvik = null;

    public static class a implements h {
    }

    public static class b implements g {
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f4045b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f4046m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ Thread f4047n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ boolean f4048o;

        public c(String r8, f r10, String r11, Thread r12, boolean r13) {
            this.f4044a = r8;
            this.f4045b = r10;
            this.f4046m = r11;
            this.f4047n = r12;
            this.f4048o = r13;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r8 = this.f4044a;
            if (TextUtils.isEmpty(r8) == true) goto L7;
            Long r10 = (Long) Sliver.access$100().get(r8);
            if (r10 == null) goto L7;
            long r11 = r10.longValue();
        L8:
            Sliver.access$200(this.f4045b.f4054a, this.f4046m, r11);
            StringBuilder r12 = new StringBuilder();
            r12.append(this.f4047n);
            r12.append(" dump ");
            if (this.f4048o == false) goto L11;
            String r13 = QesdkUtils.TAGS.TAG_SYNC;
        L12:
            r12.append(r13);
            r12.append(" success");
            Sliver.onStep(r12.toString());
            return;
        L11:
            r13 = QesdkUtils.TAGS.TAG_ASYNC;
        L7:
            r11 = -1;
            goto L8
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f4049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Thread f4050b;

        public d(f r8, Thread r10) {
            this.f4049a = r8;
            this.f4050b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Sliver.access$300(this.f4049a.f4054a);
            Sliver.onStep(this.f4050b + " clear success");
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f4051a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f4052b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ e[] f4053m = null;

        static {
            e r8 = new e("RING", 0);
            f4051a = r8;
            e r10 = new e("NORMAL", 1);
            f4052b = r10;
            f4053m = new e[]{r8, r10};
        }

        public e(String r8, int r10) {
            super(r8, r10);
        }

        public static e valueOf(String r8) {
            return (e) Enum.valueOf(e.class, r8);
        }

        public static e[] values() {
            return (e[]) f4053m.clone();
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f4054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4055b;

        public f() {
        }
    }

    public interface g {
    }

    public interface h {
    }

    public interface i {
    }

    static {
        cache = new ConcurrentHashMap(16);
        mark = new ConcurrentHashMap(16);
        a r8 = new a();
        sDefaultLogger = r8;
        sLogger = r8;
        sLoggerEnable = false;
        b r10 = new b();
        sDefaultExecutor = r10;
        sExecutor = r10;
        isArt = isArt();
        Field r11 = null;
    L14:
        Field r12 = null;
    L15:
        threadPeerField = r11;
        threadPeerFieldDalvik = r12;
        return;
    L5:
        if (isArt() == false) goto L8;
        Field r13 = Thread.class.getDeclaredField("nativePeer");     // Catch: Throwable -> L14
    L7:
        Field r14 = r13;
        r12 = r11;
        r11 = r14;
        r11.setAccessible(true);     // Catch: Throwable -> L17
        goto L15
    L8:
        r13 = Thread.class.getDeclaredField("vmThread");     // Catch: Throwable -> L14
        r11 = Class.forName("java.lang.VMThread").getDeclaredField("vmData");     // Catch: Throwable -> L13
        r11.setAccessible(true);     // Catch: Throwable -> L13
    L13:
        r12 = r11;
        r11 = r13;
        goto L15
    }

    public Sliver() {
    }

    public static /* synthetic */ Map access$100() {
        return mark;
    }

    public static /* synthetic */ void access$200(long r8, String r10, long r11) {
        nDump(r8, r10, r11);
    }

    public static /* synthetic */ void access$300(long r8) {
        nClear(r8);
    }

    public static boolean clear() {
        return clear(Thread.currentThread());
    }

    public static synchronized boolean clearAll() {
        monitor-enter(Sliver.class);
        boolean r8 = SliverAllThreadSupport.clearAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r8;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean dump(String r8) {
        return dump(Thread.currentThread(), r8);
    }

    public static synchronized boolean dumpAll(String r8) {
        monitor-enter(Sliver.class);
        boolean r10 = dumpAll(r8, false);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    public static void enableLog() {
        sLoggerEnable = true;
    }

    public static synchronized long[] getMethodStackTrace(Thread r8) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == true) goto L10;
        long[] r10 = new long[0];     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r10;
    L10:
        long r11 = getThreadPeer(r8);     // Catch: Throwable -> L18
        if (r11 != 0) goto L15;
        long[] r12 = new long[0];     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r12;
    L15:
        long[] r13 = nGetMethodStackTrace(r8, r11);     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r13;
    }

    public static synchronized String getStackTrace(Thread r8) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == false) goto L8;
        long r10 = getThreadPeer(r8);     // Catch: Throwable -> L18
        if (r10 == 0) goto L13;
        String r11 = nGetStackTrace(r8, r10);     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r11;
    L13:
        monitor-exit(Sliver.class);
        return "";
    L8:
        monitor-exit(Sliver.class);
        return "";
    }

    public static long getThreadPeer(Thread r8) {
        if (isArt() == false) goto L11;
        Field r10 = threadPeerField;
        if (r10 == null) goto L24;
        Object r11 = r10.get(r8);     // Catch: Throwable -> L21
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
        Object r14 = r13.get(r12.get(r8));     // Catch: Throwable -> L21
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

    public static synchronized boolean init(boolean r8) {
        monitor-enter(Sliver.class);
        int r10 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L29
        if (r10 <= 31) goto L10;
        onError("not support api : " + r10 + ", sliver support 19-31", new Throwable());     // Catch: Throwable -> L29
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (isInit == false) goto L15;
        onStep("sliver already init");     // Catch: Throwable -> L29
        monitor-exit(Sliver.class);
        return true;
    L15:
        if (loadLibrary() == true) goto L33;
        monitor-exit(Sliver.class);
        return false;
    L33:
        Method r11 = Looper.class.getMethod("loop", new Class[0]);     // Catch: Throwable -> L20
    L22:
        if (nInit(r10, r11, r8, isArt) == true) goto L26;
        onError("sliver init failed, because native init error", new Throwable());     // Catch: Throwable -> L29
        monitor-exit(Sliver.class);
        return false;
    L26:
        isInit = true;     // Catch: Throwable -> L29
        onStep("sliver init success, protect is " + r8);     // Catch: Throwable -> L29
        monitor-exit(Sliver.class);
        return true;
    L20:
        r11 = null;
    L29:
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

    public static void mark(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        mark.put(r8, Long.valueOf(System.nanoTime()));
    }

    public static int mode2Int(e r8) {
        if (r8 != e.f4051a) goto L6;
        return 0;
    L6:
        if (r8 != e.f4052b) goto L9;
        return 1;
    L9:
        return 0;
    }

    private static native void nClear(long r8);

    private static native void nDump(long r8, String r10, long r11);

    private static native long[] nGetMethodStackTrace(Thread r8, long r10);

    private static native String nGetStackTrace(Thread r8, long r10);

    private static native String nGetStackTrace(long[] r8);

    private static native boolean nInit(int r8, Method r10, boolean r11, boolean r12);

    private static native void nPause(long r8);

    private static native void nResetSamplingMs(long r8, int r10);

    private static native void nResume(long r8);

    private static native long nStart(Thread r8, long r10, int r11, int r12, int r13);

    private static native void nStop(long r8);

    public static void onError(String r8, Throwable r10) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        ((a) sLogger).getClass();
        Log.e(TAG, r8, r10);
    }

    public static void onStep(String r8) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        ((a) sLogger).getClass();
        Log.i(TAG, r8);
    }

    public static boolean pause() {
        return pause(Thread.currentThread());
    }

    public static synchronized boolean pauseAll() {
        monitor-enter(Sliver.class);
        boolean r8 = SliverAllThreadSupport.pauseAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r8;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(int r8) {
        monitor-enter(Sliver.class);
        boolean r10 = resetSamplingMs(Thread.currentThread(), r8);     // Catch: Throwable -> L7
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
        boolean r8 = SliverAllThreadSupport.resumeAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r8;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setExecutor(g r8) {
        if (r8 == null) goto L5;
        sExecutor = r8;
        return;
    }

    public static void setLogger(h r8) {
        if (r8 == null) goto L5;
        enableLog();
        sLogger = r8;
        return;
    }

    public static boolean start(int r8) {
        return start(Thread.currentThread(), r8, 100000, e.f4051a);
    }

    public static boolean startAll(int r8, int r10) {
        return startAll(r8, r10, 50000, e.f4051a, null);
    }

    public static boolean stop() {
        return stop(Thread.currentThread());
    }

    public static synchronized boolean stopAll() {
        monitor-enter(Sliver.class);
        boolean r8 = SliverAllThreadSupport.stopAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r8;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean clear(Thread r8) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r8 + " clear failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L9:
        f r10 = cache.get(r8);     // Catch: Throwable -> L18
        if (r10 != null) goto L14;
        onError(r8 + " clear failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L14:
        g r11 = sExecutor;     // Catch: Throwable -> L18
        d r12 = new d(r10, r8);     // Catch: Throwable -> L18
        ((b) r11).getClass();     // Catch: Throwable -> L18
        AsyncTask.execute(r12);     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean dump(String r8, String r10) {
        return dump(Thread.currentThread(), r8, r10);
    }

    public static synchronized boolean dumpAll(String r8, boolean r10) {
        monitor-enter(Sliver.class);
        boolean r11 = SliverAllThreadSupport.dumpAll(r8, r10);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized String getStackTrace(long[] r8) {
        monitor-enter(Sliver.class);
        if (r8 == null) goto L12;
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r8.length == 0) goto L12;
        String r10 = nGetStackTrace(r8);     // Catch: Throwable -> L14
        monitor-exit(Sliver.class);
        return r10;
    L12:
        monitor-exit(Sliver.class);
        return "";
    }

    public static synchronized boolean pause(Thread r8) {
        monitor-enter(Sliver.class);
        f r10 = cache.get(r8);     // Catch: Throwable -> L17
        if (r10 != null) goto L10;
        onError(r8 + " pause failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (r10.f4055b == true) goto L14;
        onStep(r8 + " already pause");     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return true;
    L14:
        nPause(r10.f4054a);     // Catch: Throwable -> L17
        r10.f4055b = false;     // Catch: Throwable -> L17
        onStep(r8 + " pause success");     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return true;
    L17:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(Thread r8, int r10) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r8 + " reset sampling ms  failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L9:
        f r11 = cache.get(r8);     // Catch: Throwable -> L18
        if (r11 != null) goto L14;
        onError(r8 + " reset sampling ms  failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L14:
        nResetSamplingMs(r11.f4054a, r10);     // Catch: Throwable -> L18
        onStep(r8 + " reset sampling ms success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean resume(Thread r8) {
        monitor-enter(Sliver.class);
        f r10 = cache.get(r8);     // Catch: Throwable -> L18
        if (r10 != null) goto L11;
        onError(r8 + " resume failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L11:
        if (r10.f4055b == false) goto L15;
        onStep(r8 + " already resume");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L15:
        nResume(r10.f4054a);     // Catch: Throwable -> L18
        r10.f4055b = true;     // Catch: Throwable -> L18
        onStep(r8 + " resume success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean start(Thread r13, int r14, int r15, e r16) {
        monitor-enter(Sliver.class);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (SliverAllThreadSupport.isStart() == false) goto L10;
        onError("sliver start failed , because sliver all thread was started", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (init(false) == true) goto L14;
        onError("sliver start failed , because sliver init failed", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L14:
        Map<Thread, f> r10 = cache;     // Catch: Throwable -> L32
        if (r10.containsKey(r13) == false) goto L19;
        onStep(r13 + " already sampling by sliver");     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return true;
    L19:
        long r8 = getThreadPeer(r13);     // Catch: Throwable -> L32
        if (r8 != 0) goto L24;
        onError("sliver start failed , because can't get thread peer", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L24:
        long r11 = nStart(r13, r8, r14, r15, mode2Int(r16));     // Catch: Throwable -> L32
        if (r11 != 0) goto L29;
        onError("sliver start failed , because can't get native peer", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L29:
        f r12 = new f();     // Catch: Throwable -> L32
        r12.f4054a = r11;     // Catch: Throwable -> L32
        r12.f4055b = true;     // Catch: Throwable -> L32
        r10.put(r13, r12);     // Catch: Throwable -> L32
        onStep(r13 + " sampling by sliver success");     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean startAll(int r8, int r10, int r11, e r12, i r13) {
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
        boolean r14 = SliverAllThreadSupport.startAll(r8, r10, r11, r12, r13);     // Catch: Throwable -> L16
        monitor-exit(Sliver.class);
        return r14;
    }

    public static synchronized boolean stop(Thread r8) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L10;
        onError(r8 + " stop failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L10:
        f r10 = cache.remove(r8);     // Catch: Throwable -> L18
        if (r10 != null) goto L15;
        onError(r8 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L15:
        nStop(r10.f4054a);     // Catch: Throwable -> L18
        onStep(r8 + " stop success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean dump(Thread r8, String r10) {
        return dump(r8, r10, false);
    }

    public static boolean dump(Thread r8, String r10, String r11) {
        return dump(r8, r10, false, r11);
    }

    public static synchronized boolean dump(Thread r8, String r10, boolean r11) {
        monitor-enter(Sliver.class);
        boolean r12 = dump(r8, r10, r11, null);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean dump(Thread r10, String r11, boolean r12, String r13) {
        monitor-enter(Sliver.class);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r10 + " dump failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L25
        monitor-exit(Sliver.class);
        return false;
    L9:
        f r8 = cache.get(r10);     // Catch: Throwable -> L25
        if (r8 != null) goto L14;
        onError(r10 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L25
        monitor-exit(Sliver.class);
        return false;
    L14:
        c r14 = new c(r13, r8, r11, r10, r12);     // Catch: Throwable -> L25
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L25
        r15.append(r10);     // Catch: Throwable -> L25
        r15.append(" dump ");     // Catch: Throwable -> L25
        if (r12 == false) goto L17;
        String r16 = QesdkUtils.TAGS.TAG_SYNC;
    L18:
        r15.append(r16);     // Catch: Throwable -> L25
        r15.append(" start");     // Catch: Throwable -> L25
        onStep(r15.toString());     // Catch: Throwable -> L25
        if (r12 == false) goto L21;
        r14.run();     // Catch: Throwable -> L25
    L22:
        monitor-exit(Sliver.class);
        return true;
    L21:
        ((b) sExecutor).getClass();     // Catch: Throwable -> L25
        AsyncTask.execute(r14);     // Catch: Throwable -> L25
        goto L22
    L17:
        r16 = QesdkUtils.TAGS.TAG_ASYNC;
        goto L18
    }
}
