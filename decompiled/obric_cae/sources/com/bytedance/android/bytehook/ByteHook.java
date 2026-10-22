package com.bytedance.android.bytehook;

/* JADX INFO: loaded from: classes.dex */
public class ByteHook {
    private static final boolean defaultDebug = false;
    private static final y1.a defaultLibLoader = null;
    private static final int defaultMode = 0;
    private static int initStatus = 1;
    private static boolean inited = false;
    private static final String libName = "bytehook";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3724b;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3725a;

        public b() {
            ByteHook.access$000();
            this.f3725a = ByteHook.access$100();
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ c[] f3726a = null;

        static {
            f3726a = new c[]{new c("AUTOMATIC", 0, 0), new c("MANUAL", 1, 1)};
        }

        public c(String r8, int r10, int r11) {
            super(r8, r10);
        }

        public static c valueOf(String r8) {
            return (c) Enum.valueOf(c.class, r8);
        }

        public static c[] values() {
            return (c[]) f3726a.clone();
        }
    }

    static {
        c[] r8 = c.f3726a;
        defaultMode = 0;
    }

    public ByteHook() {
    }

    public static /* synthetic */ y1.a access$000() {
        return null;
    }

    public static /* synthetic */ int access$100() {
        return defaultMode;
    }

    public static String getRecords() {
        if (initStatus == 0) goto L5;
        return null;
    L5:
        return nativeGetRecords();
    }

    public static int init() {
        if (inited == true) goto L5;
        b r8 = new b();
        a r10 = new a();
        r10.f3723a = r8.f3725a;
        r10.f3724b = false;
        return init(r10);
    L5:
        return initStatus;
    }

    private static native String nativeGetRecords();

    private static native int nativeInit(int r8, boolean r10);

    private static native void nativeSetDebug(boolean r8);

    public static void setDebug(boolean r8) {
        if (initStatus != 0) goto L6;
        nativeSetDebug(r8);
        return;
    }

    public static synchronized int init(a r8) {
        monitor-enter(ByteHook.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L10;
        int r10 = initStatus;     // Catch: Throwable -> L23
        monitor-exit(ByteHook.class);
        return r10;
    L10:
        inited = true;     // Catch: Throwable -> L23
        r8.getClass();     // Catch: Throwable -> L19
        System.loadLibrary(libName);     // Catch: Throwable -> L19
        initStatus = nativeInit(r8.f3723a, r8.f3724b);     // Catch: Throwable -> L14
    L16:
        int r11 = initStatus;     // Catch: Throwable -> L23
        monitor-exit(ByteHook.class);
        return r11;
    L15:
        initStatus = 101;     // Catch: Throwable -> L23
        goto L16
    L20:
        initStatus = 100;     // Catch: Throwable -> L23
        return 100;
    }
}
