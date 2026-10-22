package com.bytedance.sliver;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes2.dex */
public final class Sliver {
    private static final int SUPPORT_API_MAX = 34;
    private static final int SUPPORT_API_MIN = 19;
    private static final String TAG = "SLIVER";
    private static final Map<Thread, a> cache = null;
    private static final boolean isArt = false;
    private static volatile boolean isInit = false;
    private static final Map<String, Long> mark = null;
    private static final c sDefaultExecutor = null;
    private static final d sDefaultLogger = null;
    private static c sExecutor;
    private static final List<b> sListenerList = null;
    private static d sLogger;
    private static boolean sLoggerEnable;
    private static final Field threadPeerField = null;
    private static final Field threadPeerFieldDalvik = null;

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode NORMAL = null;
        public static final Mode RING = null;

        static {
            Mode r0 = new Mode("RING", 0);
            RING = r0;
            Mode r1 = new Mode("NORMAL", 1);
            NORMAL = r1;
            $VALUES = new Mode[]{r0, r1};
        }

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String r2) {
            return (Mode) ZeusTransformUtils.preCheckCast(Enum.valueOf(Mode.class, r2), Mode.class, "com.obric.memorydata.plugin");
        }

        public static Mode[] values() {
            return (Mode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Mode[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f3186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Thread f3187b;
        int c;
        int d;
        boolean e;
        int f;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    public interface b {
        void a(Thread r1, long[] r2, long r3);
    }

    public interface c {
        void a(Runnable r1);
    }

    public interface d {
        void a(String r1);

        void a(String r1, Throwable r2);
    }

    public interface e {
        boolean a(Thread r1);
    }

    static {
        cache = new ConcurrentHashMap(16);
        mark = new ConcurrentHashMap(16);
        sListenerList = new CopyOnWriteArrayList();
        d r0 = new AnonymousClass1();
        sDefaultLogger = r0;
        sLogger = r0;
        sLoggerEnable = false;
        c r1 = new AnonymousClass2();
        sDefaultExecutor = r1;
        sExecutor = r1;
        boolean r2 = isArt();
        isArt = r2;
        Field r3 = null;
        if (r2 == false) goto L6;
        Field r4 = Thread.class.getDeclaredField("nativePeer");     // Catch: Throwable -> L12
    L5:
        Field r5 = r3;
        r3 = r4;
        Field r6 = r5;
        r3.setAccessible(true);     // Catch: Throwable -> L15
    L13:
        threadPeerField = r3;
        threadPeerFieldDalvik = r6;
        return;
    L6:
        r4 = Thread.class.getDeclaredField("vmThread");     // Catch: Throwable -> L12
        r3 = ZeusTransformUtils.forName("java.lang.VMThread", "com.obric.memorydata.plugin").getDeclaredField("vmData");     // Catch: Throwable -> L11
        r3.setAccessible(true);     // Catch: Throwable -> L11
    L11:
        Field r7 = r3;
        r3 = r4;
        r6 = r7;
    L12:
        r6 = r3;
        goto L13
    }

    public Sliver() {
    }

    static /* synthetic */ Map access$100() {
        return mark;
    }

    static /* synthetic */ void access$200(long r0, String r2, long r3) {
        nDump(r0, r2, r3);
    }

    static /* synthetic */ void access$300(long r0) {
        nClear(r0);
    }

    public static boolean clear() {
        return clear(Thread.currentThread());
    }

    public static synchronized boolean clear(final Thread r5) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r5 + " clear failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L9:
        final a r1 = (a) ZeusTransformUtils.preCheckCast(cache.get(r5), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r1 != null) goto L14;
        onError(r5 + " clear failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L14:
        sExecutor.a(new AnonymousClass4(r1, r5));     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean clearAll() {
        monitor-enter(Sliver.class);
        boolean r1 = SliverAllThreadSupport.clearAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean dump(String r1) {
        return dump(Thread.currentThread(), r1);
    }

    public static boolean dump(String r1, String r2) {
        return dump(Thread.currentThread(), r1, r2);
    }

    public static boolean dump(Thread r1, String r2) {
        return dump(r1, r2, false);
    }

    public static boolean dump(Thread r1, String r2, String r3) {
        return dump(r1, r2, false, r3);
    }

    public static synchronized boolean dump(Thread r2, String r3, boolean r4) {
        monitor-enter(Sliver.class);
        boolean r5 = dump(r2, r3, r4, null);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r5;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean dump(final Thread r9, final String r10, final boolean r11, final String r12) {
        monitor-enter(Sliver.class);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r9 + " dump failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L25
        monitor-exit(Sliver.class);
        return false;
    L9:
        final a r5 = (a) ZeusTransformUtils.preCheckCast(cache.get(r9), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r5 != null) goto L14;
        onError(r9 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L25
        monitor-exit(Sliver.class);
        return false;
    L14:
        Runnable r1 = new AnonymousClass3(r12, r5, r10, r9, r11);     // Catch: Throwable -> L25
        StringBuilder r13 = new StringBuilder().append(r9).append(" dump ");     // Catch: Throwable -> L25
        if (r11 == false) goto L17;
        String r14 = "sync";
    L18:
        onStep(r13.append(r14).append(" start").toString());     // Catch: Throwable -> L25
        if (r11 == false) goto L21;
        r1.run();     // Catch: Throwable -> L25
    L23:
        monitor-exit(Sliver.class);
        return true;
    L21:
        sExecutor.a(r1);     // Catch: Throwable -> L25
        goto L23
    L17:
        r14 = "async";
        goto L18
    }

    public static synchronized boolean dumpAll(String r2) {
        monitor-enter(Sliver.class);
        boolean r3 = dumpAll(r2, false);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r3;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean dumpAll(String r1, boolean r2) {
        monitor-enter(Sliver.class);
        boolean r3 = SliverAllThreadSupport.dumpAll(r1, r2);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static void enableLog() {
        sLoggerEnable = true;
    }

    public static synchronized long[] getMethodStackTrace(Thread r6) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == true) goto L10;
        long[] r7 = new long[0];     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r7;
    L10:
        long r2 = getThreadPeer(r6);     // Catch: Throwable -> L18
        if (r2 != 0) goto L15;
        long[] r8 = new long[0];     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r8;
    L15:
        long[] r9 = nGetMethodStackTrace(r6, r2);     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r9;
    }

    public static synchronized String getStackTrace(Thread r5) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == false) goto L8;
        long r1 = getThreadPeer(r5);     // Catch: Throwable -> L18
        if (r1 == 0) goto L13;
        String r6 = nGetStackTrace(r5, r1);     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return r6;
    L13:
        monitor-exit(Sliver.class);
        return "";
    L8:
        monitor-exit(Sliver.class);
        return "";
    }

    public static synchronized String getStackTrace(long[] r2) {
        monitor-enter(Sliver.class);
        if (r2 == null) goto L12;
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r2.length == 0) goto L12;
        String r3 = nGetStackTrace(r2);     // Catch: Throwable -> L14
        monitor-exit(Sliver.class);
        return r3;
    L12:
        monitor-exit(Sliver.class);
        return "";
    }

    public static synchronized String[] getStackTraceArray(long[] r2) {
        monitor-enter(Sliver.class);
        if (r2 == null) goto L15;
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r2.length == 0) goto L15;
        String[] r3 = nGetStackTrace3(r2);     // Catch: Throwable -> L11
        monitor-exit(Sliver.class);
        return r3;
    L15:
        monitor-exit(Sliver.class);
        return null;
    }

    static long getThreadPeer(Thread r5) {
        if (isArt == false) goto L11;
        Field r0 = threadPeerField;
        if (r0 == null) goto L24;
        Object r6 = r0.get(r5);     // Catch: Throwable -> L21
        if (r6 != null) goto L10;
        return 0;
    L10:
        return ((Long) ZeusTransformUtils.preCheckCast(r6, Long.class, "com.obric.memorydata.plugin")).longValue();
    L24:
        return 0;
    L11:
        Field r1 = threadPeerField;
        if (r1 == null) goto L25;
        Field r4 = threadPeerFieldDalvik;
        if (r4 == null) goto L26;
        Object r7 = r4.get(r1.get(r5));     // Catch: Throwable -> L21
        if (r7 != null) goto L20;
        return 0;
    L20:
        return ((Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L26:
        return 0;
    L25:
        return 0;
    L28:
        return 0;
    }

    public static synchronized boolean init(boolean r8) {
        monitor-enter(Sliver.class);
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L30
        if (r1 < 19) goto L27;
        if (r1 > 34) goto L27;
        if (isInit == false) goto L14;
        onStep("sliver already init");     // Catch: Throwable -> L30
        monitor-exit(Sliver.class);
        return true;
    L14:
        if (loadLibrary() == true) goto L17;
        monitor-exit(Sliver.class);
        return false;
    L17:
        Method r2 = null;
        r2 = Looper.class.getMethod("loop", new Class[0]);     // Catch: Throwable -> L33
    L20:
        if (nInit(r1, r2, r8, isArt) == true) goto L24;
        onError("sliver init failed, because native init error", new Throwable());     // Catch: Throwable -> L30
        monitor-exit(Sliver.class);
        return false;
    L24:
        isInit = true;     // Catch: Throwable -> L30
        onStep("sliver init success, protect is " + r8);     // Catch: Throwable -> L30
        monitor-exit(Sliver.class);
        return true;
    L27:
        onError("not support api : " + r1 + ", sliver support 19-34", new Throwable());     // Catch: Throwable -> L30
        monitor-exit(Sliver.class);
        return false;
    L30:
        th = move-exception;
        throw th;
    }

    private static boolean isArt() {
        if (Build.VERSION.SDK_INT >= 21) goto L18;
        String r0 = System.getProperty("java.vm.version");
        if (r0 == null) goto L19;
        Matcher r1 = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(r0);
        if (r1.matches() == false) goto L20;
        int r2 = Integer.parseInt(r1.group(1));     // Catch: Throwable -> L15
        int r3 = Integer.parseInt(r1.group(2));     // Catch: Throwable -> L15
        if (r2 > 2) goto L21;
        if (r2 != 2) goto L14;
        if (r3 < 1) goto L14;
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

    public static void mark(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        mark.put(r3, Long.valueOf(System.nanoTime()));
    }

    static int mode2Int(Mode r2) {
        if (r2 != Mode.RING) goto L6;
        return 0;
    L6:
        if (r2 != Mode.NORMAL) goto L9;
        return 1;
    L9:
        return 0;
    }

    private static native void nClear(long r0);

    private static native void nDump(long r0, String r2, long r3);

    private static native long[] nGetMethodStackTrace(Thread r0, long r1);

    private static native String nGetStackTrace(Thread r0, long r1);

    private static native String nGetStackTrace(long[] r0);

    private static native String[] nGetStackTrace3(long[] r0);

    private static native boolean nInit(int r0, Method r1, boolean r2, boolean r3);

    private static native void nPause(long r0);

    private static native void nResetSamplingMs(long r0, int r2);

    private static native void nResume(long r0);

    private static native long nStart(Thread r0, long r1, int r3, int r4, int r5);

    private static native void nStop(long r0);

    static void onError(String r1, Throwable r2) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        sLogger.a(r1, r2);
    }

    static void onStep(String r1) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        sLogger.a(r1);
    }

    public static boolean pause() {
        return pause(Thread.currentThread());
    }

    public static synchronized boolean pause(Thread r7) {
        monitor-enter(Sliver.class);
        a r1 = (a) ZeusTransformUtils.preCheckCast(cache.get(r7), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r1 != null) goto L10;
        onError(r7 + " pause failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (r1.e == true) goto L14;
        onStep(r7 + " already pause");     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return true;
    L14:
        nPause(r1.f3186a);     // Catch: Throwable -> L17
        r1.e = false;     // Catch: Throwable -> L17
        onStep(r7 + " pause success");     // Catch: Throwable -> L17
        monitor-exit(Sliver.class);
        return true;
    L17:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean pauseAll() {
        monitor-enter(Sliver.class);
        boolean r1 = SliverAllThreadSupport.pauseAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void registerSamplingListener(b r2) {
        b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        List<b> r0 = sListenerList;
        if (r0.contains(r3) == false) goto L5;
        return;
    L5:
        r0.add(r3);
    }

    public static synchronized void reportStack(Thread r5, long[] r6, long r7) {
        monitor-enter(Sliver.class);
        int r1 = 0;
    L14:
        List<b> r2 = sListenerList;     // Catch: Throwable -> L11
        if (r1 >= r2.size()) goto L9;
        ((b) ZeusTransformUtils.preCheckCast(r2.get(r1), b.class, "com.obric.memorydata.plugin")).a(r5, r6, r7);     // Catch: Throwable -> L11
        r1 = r1 + 1;
        goto L14
    L9:
        monitor-exit(Sliver.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(int r2) {
        monitor-enter(Sliver.class);
        boolean r3 = resetSamplingMs(Thread.currentThread(), r2);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(Thread r5, int r6) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L9;
        onError(r5 + " reset sampling ms  failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L9:
        a r1 = (a) ZeusTransformUtils.preCheckCast(cache.get(r5), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r1 != null) goto L14;
        onError(r5 + " reset sampling ms  failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L14:
        nResetSamplingMs(r1.f3186a, r6);     // Catch: Throwable -> L18
        onStep(r5 + " reset sampling ms success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean resume() {
        return resume(Thread.currentThread());
    }

    public static synchronized boolean resume(Thread r6) {
        monitor-enter(Sliver.class);
        a r1 = (a) ZeusTransformUtils.preCheckCast(cache.get(r6), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r1 != null) goto L11;
        onError(r6 + " resume failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L11:
        if (r1.e == false) goto L15;
        onStep(r6 + " already resume");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L15:
        nResume(r1.f3186a);     // Catch: Throwable -> L18
        r1.e = true;     // Catch: Throwable -> L18
        onStep(r6 + " resume success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resumeAll() {
        monitor-enter(Sliver.class);
        boolean r1 = SliverAllThreadSupport.resumeAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setExecutor(c r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        sExecutor = r3;
        return;
    }

    public static void setLogger(d r2) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        enableLog();
        sLogger = r3;
        return;
    }

    public static boolean start(int r3) {
        return start(Thread.currentThread(), r3, 100000, Mode.RING);
    }

    public static synchronized boolean start(Thread r14, int r15, int r16, Mode r17) {
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
        Map<Thread, a> r9 = cache;     // Catch: Throwable -> L32
        if (r9.containsKey(r14) == false) goto L19;
        onStep(r14 + " already sampling by sliver");     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return true;
    L19:
        long r2 = getThreadPeer(r14);     // Catch: Throwable -> L32
        if (r2 != 0) goto L24;
        onError("sliver start failed , because can't get thread peer", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L24:
        int r13 = mode2Int(r17);     // Catch: Throwable -> L32
        long r1 = nStart(r14, r2, r15, r16, r13);     // Catch: Throwable -> L32
        if (r1 != 0) goto L29;
        onError("sliver start failed , because can't get native peer", new Throwable());     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return false;
    L29:
        a r3 = new a(null);     // Catch: Throwable -> L32
        r3.f3186a = r1;     // Catch: Throwable -> L32
        r3.f3187b = r14;     // Catch: Throwable -> L32
        r3.c = r15;     // Catch: Throwable -> L32
        r3.d = r16;     // Catch: Throwable -> L32
        r3.e = true;     // Catch: Throwable -> L32
        r3.f = r13;     // Catch: Throwable -> L32
        r9.put(r14, r3);     // Catch: Throwable -> L32
        onStep(r14 + " sampling by sliver success");     // Catch: Throwable -> L32
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean startAll(int r3, int r4) {
        return startAll(r3, r4, SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, Mode.RING, null);
    }

    public static synchronized boolean startAll(int r3, int r4, int r5, Mode r6, e r7) {
        monitor-enter(Sliver.class);
        e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r7, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (cache.isEmpty() == true) goto L10;
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (init(false) == true) goto L13;
        monitor-exit(Sliver.class);
        return false;
    L13:
        boolean r9 = SliverAllThreadSupport.startAll(r3, r4, r5, r6, r8);     // Catch: Throwable -> L16
        monitor-exit(Sliver.class);
        return r9;
    L16:
        th = move-exception;
        throw th;
    }

    public static boolean stop() {
        return stop(Thread.currentThread());
    }

    public static synchronized boolean stop(Thread r5) {
        monitor-enter(Sliver.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L10;
        onError(r5 + " stop failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return false;
    L10:
        a r1 = (a) ZeusTransformUtils.preCheckCast(cache.remove(r5), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r1 != null) goto L15;
        onError(r5 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    L15:
        nStop(r1.f3186a);     // Catch: Throwable -> L18
        onStep(r5 + " stop success");     // Catch: Throwable -> L18
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean stopAll() {
        monitor-enter(Sliver.class);
        boolean r1 = SliverAllThreadSupport.stopAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static void unRegisterSamplingListener(b r2) {
        b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        sListenerList.remove(r3);
    }
}
