package com.bytedance.sliver;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class Sliver {
    private static final int SUPPORT_API_MAX = 34;
    private static final int SUPPORT_API_MIN = 19;
    private static final String TAG = "SLIVER";
    private static final Map<Thread, e> cache = null;
    private static final boolean isArt = false;
    private static volatile boolean isInit = false;
    private static final Map<String, Long> mark = null;
    private static final g sDefaultExecutor = null;
    private static final h sDefaultLogger = null;
    private static g sExecutor;
    private static final List<f> sListenerList = null;
    private static h sLogger;
    private static boolean sLoggerEnable;
    private static final Field threadPeerField = null;
    private static final Field threadPeerFieldDalvik = null;

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode NORMAL = null;
        public static final Mode RING = null;

        static {
            Mode r10 = new Mode("RING", 0);
            RING = r10;
            Mode r11 = new Mode("NORMAL", 1);
            NORMAL = r11;
            $VALUES = new Mode[]{r10, r11};
        }

        private Mode(String r10, int r11) {
            super(r10, r11);
        }

        public static Mode valueOf(String r10) {
            return (Mode) Enum.valueOf(Mode.class, r10);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    static class a implements h {
        a() {
        }

        @Override // com.bytedance.sliver.Sliver.h
        public void a(String r10) {
            Log.i(Sliver.TAG, r10);
        }

        @Override // com.bytedance.sliver.Sliver.h
        public void b(String r10, Throwable r11) {
            Log.e(Sliver.TAG, r10, r11);
        }
    }

    static class b implements g {
        b() {
        }

        @Override // com.bytedance.sliver.Sliver.g
        public void execute(Runnable r10) {
            AsyncTask.execute(r10);
        }
    }

    static class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f2751c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f2752g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f2753h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Thread f2754i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f2755j;

        c(String r10, e r11, String r12, Thread r13, boolean r14) {
            this.f2751c = r10;
            this.f2752g = r11;
            this.f2753h = r12;
            this.f2754i = r13;
            this.f2755j = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.f2751c) == true) goto L7;
            Long r10 = (Long) Sliver.access$100().get(this.f2751c);
            if (r10 == null) goto L7;
            long r11 = r10.longValue();
        L8:
            Sliver.access$200(this.f2752g.f2758a, this.f2753h, r11);
            StringBuilder r12 = new StringBuilder();
            r12.append(this.f2754i);
            r12.append(" dump ");
            if (this.f2755j == false) goto L11;
            String r13 = "sync";
        L12:
            r12.append(r13);
            r12.append(" success");
            Sliver.onStep(r12.toString());
            return;
        L11:
            r13 = "async";
        L7:
            r11 = -1;
            goto L8
        }
    }

    static class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f2756c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Thread f2757g;

        d(e r10, Thread r11) {
            this.f2756c = r10;
            this.f2757g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sliver.access$300(this.f2756c.f2758a);
            Sliver.onStep(this.f2757g + " clear success");
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f2758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f2759b;

        private e() {
        }

        /* synthetic */ e(a r10) {
            this();
        }
    }

    public interface f {
        void a(Thread r10, long[] r11, long r12);
    }

    public interface g {
        void execute(Runnable r10);
    }

    public interface h {
        void a(String r10);

        void b(String r10, Throwable r11);
    }

    public interface i {
        boolean a(Thread r10);
    }

    static {
        cache = new ConcurrentHashMap(16);
        mark = new ConcurrentHashMap(16);
        sListenerList = new CopyOnWriteArrayList();
        a r10 = new a();
        sDefaultLogger = r10;
        sLogger = r10;
        sLoggerEnable = false;
        b r11 = new b();
        sDefaultExecutor = r11;
        sExecutor = r11;
        boolean r12 = isArt();
        isArt = r12;
        Field r13 = null;
        if (r12 == false) goto L6;
        Field r14 = Thread.class.getDeclaredField("nativePeer");     // Catch: Throwable -> L12
    L5:
        Field r15 = r13;
        r13 = r14;
        Field r16 = r15;
        r13.setAccessible(true);     // Catch: Throwable -> L15
    L13:
        threadPeerField = r13;
        threadPeerFieldDalvik = r16;
        return;
    L6:
        r14 = Thread.class.getDeclaredField("vmThread");     // Catch: Throwable -> L12
        r13 = Class.forName("java.lang.VMThread").getDeclaredField("vmData");     // Catch: Throwable -> L11
        r13.setAccessible(true);     // Catch: Throwable -> L11
    L11:
        Field r17 = r13;
        r13 = r14;
        r16 = r17;
    L12:
        r16 = r13;
        goto L13
    }

    public Sliver() {
    }

    static /* synthetic */ Map access$100() {
        return mark;
    }

    static /* synthetic */ void access$200(long r10, String r11, long r12) {
        nDump(r10, r11, r12);
    }

    static /* synthetic */ void access$300(long r10) {
        nClear(r10);
    }

    public static boolean clear() {
        return clear(Thread.currentThread());
    }

    public static synchronized boolean clear(Thread r10) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r10 + " clear failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L9:
        e r11 = cache.get(r10);     // Catch: Throwable -> L18
        if (r11 != null) goto L14;
        onError(r10 + " clear failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L14:
        sExecutor.execute(new d(r11, r10));     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean clearAll() {
        monitor-enter(Sliver.class);
        boolean r10 = SliverAllThreadSupport.clearAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean dump(String r10) {
        return dump(Thread.currentThread(), r10);
    }

    public static boolean dump(String r10, String r11) {
        return dump(Thread.currentThread(), r10, r11);
    }

    public static boolean dump(Thread r10, String r11) {
        return dump(r10, r11, false);
    }

    public static boolean dump(Thread r10, String r11, String r12) {
        return dump(r10, r11, false, r12);
    }

    public static synchronized boolean dump(Thread r10, String r11, boolean r12) {
        monitor-enter(Sliver.class);
        boolean r13 = dump(r10, r11, r12, null);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r13;
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
        e r14 = cache.get(r10);     // Catch: Throwable -> L25
        if (r14 != null) goto L14;
        onError(r10 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L25
        monitor-exit(Sliver.class);
        return false;
    L14:
        c r15 = new c(r13, r14, r11, r10, r12);     // Catch: Throwable -> L25
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L25
        r16.append(r10);     // Catch: Throwable -> L25
        r16.append(" dump ");     // Catch: Throwable -> L25
        if (r12 == false) goto L17;
        String r17 = "sync";
    L18:
        r16.append(r17);     // Catch: Throwable -> L25
        r16.append(" start");     // Catch: Throwable -> L25
        onStep(r16.toString());     // Catch: Throwable -> L25
        if (r12 == false) goto L21;
        r15.run();     // Catch: Throwable -> L25
    L23:
        monitor-exit(Sliver.class);
        return true;
    L21:
        sExecutor.execute(r15);     // Catch: Throwable -> L25
        goto L23
    L17:
        r17 = "async";
        goto L18
    }

    public static synchronized boolean dumpAll(String r10) {
        monitor-enter(Sliver.class);
        boolean r11 = dumpAll(r10, false);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r11;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean dumpAll(String r10, boolean r11) {
        monitor-enter(Sliver.class);
        boolean r12 = SliverAllThreadSupport.dumpAll(r10, r11);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public static void enableLog() {
        sLoggerEnable = true;
    }

    public static synchronized long[] getMethodStackTrace(Thread r10) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == true) goto L10;
        long[] r11 = new long[0];     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r11;
    L10:
        long r12 = getThreadPeer(r10);     // Catch: Throwable -> L18
        if (r12 != 0) goto L15;
        long[] r13 = new long[0];     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r13;
    L15:
        long[] r14 = nGetMethodStackTrace(r10, r12);     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r14;
    }

    public static synchronized String getStackTrace(Thread r10) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == false) goto L8;
        long r11 = getThreadPeer(r10);     // Catch: Throwable -> L18
        if (r11 == 0) goto L13;
        String r12 = nGetStackTrace(r10, r11);     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r12;
    L13:
        monitor-exit(Sliver.class);
        return "";
    L8:
        monitor-exit(Sliver.class);
        return "";
    }

    public static synchronized String getStackTrace(long[] r10) {
        monitor-enter(Sliver.class);
        if (r10 == null) goto L12;
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r10.length == 0) goto L12;
        String r11 = nGetStackTrace(r10);     // Catch: Throwable -> L14
        monitor-exit(Sliver.class);
        return r11;
    L12:
        monitor-exit(Sliver.class);
        return "";
    }

    public static synchronized String[] getStackTraceArray(long[] r10) {
        monitor-enter(Sliver.class);
        if (r10 == null) goto L15;
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r10.length == 0) goto L15;
        String[] r11 = nGetStackTrace3(r10);     // Catch: Throwable -> L11
        monitor-exit(Sliver.class);
        return r11;
    L15:
        monitor-exit(Sliver.class);
        return null;
    }

    static long getThreadPeer(Thread r10) {
        if (isArt == false) goto L11;
        Field r11 = threadPeerField;
        if (r11 == null) goto L24;
        Object r12 = r11.get(r10);     // Catch: Throwable -> L21
        if (r12 != null) goto L10;
        return 0;
    L10:
        return ((Long) r12).longValue();
    L24:
        return 0;
    L11:
        Field r13 = threadPeerField;
        if (r13 == null) goto L25;
        Field r14 = threadPeerFieldDalvik;
        if (r14 == null) goto L26;
        Object r15 = r14.get(r13.get(r10));     // Catch: Throwable -> L21
        if (r15 != null) goto L20;
        return 0;
    L20:
        return ((Integer) r15).intValue();
    L26:
        return 0;
    L25:
        return 0;
    L28:
        return 0;
    }

    public static synchronized boolean init(boolean r10) {
        monitor-enter(Sliver.class);
        int r11 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L30
        if (r11 < 19) goto L27;
        if (r11 > 34) goto L27;
        if (isInit == false) goto L14;
        onStep("sliver already init");     // Catch: Throwable -> L30
        monitor-exit(Sliver.class);
        return true;
    L14:
        if (loadLibrary() == true) goto L17;
        monitor-exit(Sliver.class);
        return false;
    L17:
        Method r12 = null;
        r12 = Looper.class.getMethod("loop", new Class[0]);     // Catch: Throwable -> L33
    L20:
        if (nInit(r11, r12, r10, isArt) == true) goto L24;
        onError("sliver init failed, because native init error", new Throwable());     // Catch: Throwable -> L30
        monitor-exit(Sliver.class);
        return false;
    L24:
        isInit = true;     // Catch: Throwable -> L30
        onStep("sliver init success, protect is " + r10);     // Catch: Throwable -> L30
        monitor-exit(Sliver.class);
        return true;
    L27:
        onError("not support api : " + r11 + ", sliver support 19-34", new Throwable());     // Catch: Throwable -> L30
        monitor-exit(Sliver.class);
        return false;
    L30:
        th = move-exception;
        throw th;
    }

    private static boolean isArt() {
        if (Build.VERSION.SDK_INT >= 21) goto L18;
        String r10 = System.getProperty("java.vm.version");
        if (r10 == null) goto L19;
        Matcher r11 = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(r10);
        if (r11.matches() == false) goto L20;
        int r12 = Integer.parseInt(r11.group(1));     // Catch: Throwable -> L15
        int r13 = Integer.parseInt(r11.group(2));     // Catch: Throwable -> L15
        if (r12 > 2) goto L21;
        if (r12 != 2) goto L14;
        if (r13 < 1) goto L14;
        return true;
    L14:
        return false;
    L21:
        return true;
    L23:
        return true;
    L20:
        return true;
    L19:
        return true;
    L18:
        return true;
    }

    public static boolean isInit() {
        return isInit;
    }

    private static boolean loadLibrary() {
        System.loadLibrary("sliver");     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        onError("sliver so load failed", th);
        return false;
    }

    public static void mark(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        mark.put(r10, Long.valueOf(System.nanoTime()));
    }

    static int mode2Int(Mode r10) {
        if (r10 != Mode.RING) goto L6;
        return 0;
    L6:
        if (r10 != Mode.NORMAL) goto L9;
        return 1;
    L9:
        return 0;
    }

    private static native void nClear(long r10);

    private static native void nDump(long r10, String r11, long r12);

    private static native long[] nGetMethodStackTrace(Thread r10, long r11);

    private static native String nGetStackTrace(Thread r10, long r11);

    private static native String nGetStackTrace(long[] r10);

    private static native String[] nGetStackTrace3(long[] r10);

    private static native boolean nInit(int r10, Method r11, boolean r12, boolean r13);

    private static native void nPause(long r10);

    private static native void nResetSamplingMs(long r10, int r11);

    private static native void nResume(long r10);

    private static native long nStart(Thread r10, long r11, int r12, int r13, int r14);

    private static native void nStop(long r10);

    static void onError(String r10, Throwable r11) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        sLogger.b(r10, r11);
    }

    static void onStep(String r10) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        sLogger.a(r10);
    }

    public static boolean pause() {
        return pause(Thread.currentThread());
    }

    public static synchronized boolean pause(Thread r10) {
        monitor-enter(Sliver.class);
        e r11 = cache.get(r10);     // Catch: Throwable -> L17
        if (r11 != null) goto L10;
        onError(r10 + " pause failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (r11.f2759b == true) goto L14;
        onStep(r10 + " already pause");     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return true;
    L14:
        nPause(r11.f2758a);     // Catch: Throwable -> L17
        r11.f2759b = false;     // Catch: Throwable -> L17
        onStep(r10 + " pause success");     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return true;
    L17:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean pauseAll() {
        monitor-enter(Sliver.class);
        boolean r10 = SliverAllThreadSupport.pauseAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static void registerSamplingListener(f r10) {
        List<f> r11 = sListenerList;
        if (r11.contains(r10) == false) goto L5;
        return;
    L5:
        r11.add(r10);
    }

    public static synchronized void reportStack(Thread r10, long[] r11, long r12) {
        monitor-enter(Sliver.class);
        int r13 = 0;
    L14:
        List<f> r14 = sListenerList;     // Catch: Throwable -> L11
        if (r13 >= r14.size()) goto L9;
        r14.get(r13).a(r10, r11, r12);     // Catch: Throwable -> L11
        r13 = r13 + 1;
        goto L14
    L9:
        monitor-exit(Sliver.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(int r10) {
        monitor-enter(Sliver.class);
        boolean r11 = resetSamplingMs(Thread.currentThread(), r10);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(Thread r10, int r11) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r10 + " reset sampling ms  failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L9:
        e r12 = cache.get(r10);     // Catch: Throwable -> L18
        if (r12 != null) goto L14;
        onError(r10 + " reset sampling ms  failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L14:
        nResetSamplingMs(r12.f2758a, r11);     // Catch: Throwable -> L18
        onStep(r10 + " reset sampling ms success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean resume() {
        return resume(Thread.currentThread());
    }

    public static synchronized boolean resume(Thread r10) {
        monitor-enter(Sliver.class);
        e r11 = cache.get(r10);     // Catch: Throwable -> L18
        if (r11 != null) goto L11;
        onError(r10 + " resume failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L11:
        if (r11.f2759b == false) goto L15;
        onStep(r10 + " already resume");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L15:
        nResume(r11.f2758a);     // Catch: Throwable -> L18
        r11.f2759b = true;     // Catch: Throwable -> L18
        onStep(r10 + " resume success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resumeAll() {
        monitor-enter(Sliver.class);
        boolean r10 = SliverAllThreadSupport.resumeAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setExecutor(g r10) {
        if (r10 == null) goto L5;
        sExecutor = r10;
        return;
    }

    public static void setLogger(h r10) {
        if (r10 == null) goto L5;
        enableLog();
        sLogger = r10;
        return;
    }

    public static boolean start(int r10) {
        return start(Thread.currentThread(), r10, 100000, Mode.RING);
    }

    public static synchronized boolean start(Thread r13, int r14, int r15, Mode r16) {
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
        Map<Thread, e> r10 = cache;     // Catch: Throwable -> L32
        if (r10.containsKey(r13) == false) goto L19;
        onStep(r13 + " already sampling by sliver");     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return true;
    L19:
        long r11 = getThreadPeer(r13);     // Catch: Throwable -> L32
        if (r11 != 0) goto L24;
        onError("sliver start failed , because can't get thread peer", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L24:
        long r12 = nStart(r13, r11, r14, r15, mode2Int(r16));     // Catch: Throwable -> L32
        if (r12 != 0) goto L29;
        onError("sliver start failed , because can't get native peer", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L29:
        e r17 = new e(null);     // Catch: Throwable -> L32
        r17.f2758a = r12;     // Catch: Throwable -> L32
        r17.f2759b = true;     // Catch: Throwable -> L32
        r10.put(r13, r17);     // Catch: Throwable -> L32
        onStep(r13 + " sampling by sliver success");     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean startAll(int r10, int r11) {
        return startAll(r10, r11, 50000, Mode.RING, null);
    }

    public static synchronized boolean startAll(int r10, int r11, int r12, Mode r13, i r14) {
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
        boolean r15 = SliverAllThreadSupport.startAll(r10, r11, r12, r13, r14);     // Catch: Throwable -> L16
        monitor-exit(Sliver.class);
        return r15;
    }

    public static boolean stop() {
        return stop(Thread.currentThread());
    }

    public static synchronized boolean stop(Thread r10) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L10;
        onError(r10 + " stop failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L10:
        e r11 = cache.remove(r10);     // Catch: Throwable -> L18
        if (r11 != null) goto L15;
        onError(r10 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L15:
        nStop(r11.f2758a);     // Catch: Throwable -> L18
        onStep(r10 + " stop success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean stopAll() {
        monitor-enter(Sliver.class);
        boolean r10 = SliverAllThreadSupport.stopAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static void unRegisterSamplingListener(f r10) {
        sListenerList.remove(r10);
    }
}
