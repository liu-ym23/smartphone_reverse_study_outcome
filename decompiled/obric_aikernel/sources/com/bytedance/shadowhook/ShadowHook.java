package com.bytedance.shadowhook;

/* JADX INFO: loaded from: classes.dex */
public final class ShadowHook {
    private static final int ERRNO_INIT_EXCEPTION = 101;
    private static final int ERRNO_LOAD_LIBRARY_EXCEPTION = 100;
    private static final int ERRNO_OK = 0;
    private static final int ERRNO_PENDING = 1;
    private static final int ERRNO_UNINIT = 2;
    private static final boolean defaultDebuggable = false;
    private static final d defaultLibLoader = null;
    private static final int defaultMode = 0;
    private static final boolean defaultRecordable = false;
    private static long initCostMs = -1;
    private static int initErrno = 2;
    private static boolean inited = false;
    private static final String libName = "shadowhook";
    private static final int recordItemAll = 1023;
    private static final int recordItemBackupLen = 128;
    private static final int recordItemCallerLibName = 2;
    private static final int recordItemErrno = 256;
    private static final int recordItemLibName = 8;
    private static final int recordItemNewAddr = 64;
    private static final int recordItemOp = 4;
    private static final int recordItemStub = 512;
    private static final int recordItemSymAddr = 32;
    private static final int recordItemSymName = 16;
    private static final int recordItemTimestamp = 1;

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode SHARED = null;
        public static final Mode UNIQUE = null;
        private final int value;

        static {
            Mode r10 = new Mode("SHARED", 0, 0);
            SHARED = r10;
            Mode r11 = new Mode("UNIQUE", 1, 1);
            UNIQUE = r11;
            $VALUES = new Mode[]{r10, r11};
        }

        private Mode(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static Mode valueOf(String r10) {
            return (Mode) Enum.valueOf(Mode.class, r10);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        int getValue() {
            return this.value;
        }
    }

    public static final enum RecordItem extends Enum<RecordItem> {
        private static final /* synthetic */ RecordItem[] $VALUES = null;
        public static final RecordItem BACKUP_LEN = null;
        public static final RecordItem CALLER_LIB_NAME = null;
        public static final RecordItem ERRNO = null;
        public static final RecordItem LIB_NAME = null;
        public static final RecordItem NEW_ADDR = null;
        public static final RecordItem OP = null;
        public static final RecordItem STUB = null;
        public static final RecordItem SYM_ADDR = null;
        public static final RecordItem SYM_NAME = null;
        public static final RecordItem TIMESTAMP = null;

        static {
            RecordItem r10 = new RecordItem("TIMESTAMP", 0);
            TIMESTAMP = r10;
            RecordItem r11 = new RecordItem("CALLER_LIB_NAME", 1);
            CALLER_LIB_NAME = r11;
            RecordItem r12 = new RecordItem("OP", 2);
            OP = r12;
            RecordItem r13 = new RecordItem("LIB_NAME", 3);
            LIB_NAME = r13;
            RecordItem r14 = new RecordItem("SYM_NAME", 4);
            SYM_NAME = r14;
            RecordItem r15 = new RecordItem("SYM_ADDR", 5);
            SYM_ADDR = r15;
            RecordItem r16 = new RecordItem("NEW_ADDR", 6);
            NEW_ADDR = r16;
            RecordItem r17 = new RecordItem("BACKUP_LEN", 7);
            BACKUP_LEN = r17;
            RecordItem r18 = new RecordItem("ERRNO", 8);
            ERRNO = r18;
            RecordItem r19 = new RecordItem("STUB", 9);
            STUB = r19;
            $VALUES = new RecordItem[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
        }

        private RecordItem(String r10, int r11) {
            super(r10, r11);
        }

        public static RecordItem valueOf(String r10) {
            return (RecordItem) Enum.valueOf(RecordItem.class, r10);
        }

        public static RecordItem[] values() {
            return (RecordItem[]) $VALUES.clone();
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2742a = null;

        static {
            int[] r10 = new int[RecordItem.values().length];
            f2742a = r10;
            r10[RecordItem.TIMESTAMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            f2742a[RecordItem.CALLER_LIB_NAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            f2742a[RecordItem.OP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            f2742a[RecordItem.LIB_NAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            f2742a[RecordItem.SYM_NAME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            f2742a[RecordItem.SYM_ADDR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            f2742a[RecordItem.NEW_ADDR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            f2742a[RecordItem.BACKUP_LEN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            f2742a[RecordItem.ERRNO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            f2742a[RecordItem.STUB.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f2743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2746d;

        public b() {
        }

        public boolean a() {
            return this.f2745c;
        }

        public d b() {
            return this.f2743a;
        }

        public int c() {
            return this.f2744b;
        }

        public boolean d() {
            return this.f2746d;
        }

        public void e(boolean r10) {
            this.f2745c = r10;
        }

        public void f(d r10) {
            this.f2743a = r10;
        }

        public void g(int r10) {
            this.f2744b = r10;
        }

        public void h(boolean r10) {
            this.f2746d = r10;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private d f2747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2749c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2750d;

        public c() {
            this.f2747a = ShadowHook.access$000();
            this.f2748b = ShadowHook.access$100();
            this.f2749c = false;
            this.f2750d = false;
        }

        public b a() {
            b r10 = new b();
            r10.f(this.f2747a);
            r10.g(this.f2748b);
            r10.e(this.f2749c);
            r10.h(this.f2750d);
            return r10;
        }

        public c b(boolean r10) {
            this.f2749c = r10;
            return this;
        }

        public c c(d r10) {
            this.f2747a = r10;
            return this;
        }

        public c d(Mode r10) {
            this.f2748b = r10.getValue();
            return this;
        }

        public c e(boolean r10) {
            this.f2750d = r10;
            return this;
        }
    }

    public interface d {
        void loadLibrary(String r10);
    }

    static {
        defaultMode = Mode.SHARED.getValue();
    }

    public ShadowHook() {
    }

    static /* synthetic */ d access$000() {
        return defaultLibLoader;
    }

    static /* synthetic */ int access$100() {
        return defaultMode;
    }

    public static String getArch() {
        if (isInitedOk() == true) goto L5;
        return "unknown";
    L5:
        return nativeGetArch();
    }

    public static boolean getDebuggable() {
        if (isInitedOk() == true) goto L5;
        return false;
    L5:
        return nativeGetDebuggable();
    }

    public static long getInitCostMs() {
        return initCostMs;
    }

    public static int getInitErrno() {
        return initErrno;
    }

    public static Mode getMode() {
        if (isInitedOk() == false) goto L10;
        Mode r10 = Mode.SHARED;
        if (r10.getValue() != nativeGetMode()) goto L8;
        return r10;
    L8:
        return Mode.UNIQUE;
    L10:
        return Mode.SHARED;
    }

    public static boolean getRecordable() {
        if (isInitedOk() == true) goto L5;
        return false;
    L5:
        return nativeGetRecordable();
    }

    public static String getRecords(RecordItem... r10) {
        if (isInitedOk() == false) goto L24;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L5:
        if (r12 >= r11) goto L20;
        switch(a.f2742a[r10[r12].ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            default: goto L19;
        };
    L9:
        r13 = r13 | 512;
        goto L19
    L10:
        r13 = r13 | 256;
        goto L19
    L11:
        r13 = r13 | 128;
        goto L19
    L12:
        r13 = r13 | 64;
        goto L19
    L13:
        r13 = r13 | 32;
        goto L19
    L14:
        r13 = r13 | 16;
        goto L19
    L15:
        r13 = r13 | 8;
        goto L19
    L16:
        r13 = r13 | 4;
        goto L19
    L17:
        r13 = r13 | 2;
        goto L19
    L18:
        r13 = r13 | 1;
    L19:
        r12 = r12 + 1;
        goto L5
    L20:
        if (r13 != 0) goto L23;
        r13 = recordItemAll;
    L23:
        return nativeGetRecords(r13);
    L24:
        return null;
    }

    public static String getVersion() {
        return nativeGetVersion();
    }

    public static int init() {
        return init(null);
    }

    public static synchronized int init(b r10) {
        monitor-enter(ShadowHook.class);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L10;
        int r11 = initErrno;     // Catch: Throwable -> L30
        monitor-exit(ShadowHook.class);
        return r11;
    L10:
        inited = true;     // Catch: Throwable -> L30
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L30
        if (r10 != null) goto L14;
        r10 = new c().a();     // Catch: Throwable -> L30
    L14:
        if (loadLibrary(r10) == true) goto L36;
        initErrno = 100;     // Catch: Throwable -> L30
        initCostMs = System.currentTimeMillis() - r12;     // Catch: Throwable -> L30
        int r13 = initErrno;     // Catch: Throwable -> L30
        monitor-exit(ShadowHook.class);
        return r13;
    L36:
        initErrno = nativeInit(r10.c(), r10.a());     // Catch: Throwable -> L21
    L23:
        if (r10.d() == true) goto L34;
    L27:
        initCostMs = System.currentTimeMillis() - r12;     // Catch: Throwable -> L30
        int r14 = initErrno;     // Catch: Throwable -> L30
        monitor-exit(ShadowHook.class);
        return r14;
    L34:
        nativeSetRecordable(r10.d());     // Catch: Throwable -> L26
    L26:
        initErrno = 101;     // Catch: Throwable -> L30
    L21:
        initErrno = 101;     // Catch: Throwable -> L30
        goto L23
    }

    private static boolean isInitedOk() {
        if (inited == false) goto L10;
        if (initErrno != 0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (loadLibrary() == true) goto L20;
        return false;
    L20:
        int r10 = nativeGetInitErrno();     // Catch: Throwable -> L19
        if (r10 == 2) goto L15;
        initErrno = r10;     // Catch: Throwable -> L19
        inited = true;     // Catch: Throwable -> L19
    L15:
        if (r10 != 0) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    private static boolean loadLibrary() {
        return loadLibrary(null);
    }

    private static boolean loadLibrary(b r10) {
        if (r10 != null) goto L13;
    L8:
        System.loadLibrary(libName);     // Catch: Throwable -> L11
        return true;
    L11:
        return false;
    L13:
        if (r10.b() == null) goto L8;
        r10.b().loadLibrary(libName);     // Catch: Throwable -> L11
        return true;
    }

    private static native String nativeGetArch();

    private static native boolean nativeGetDebuggable();

    private static native int nativeGetInitErrno();

    private static native int nativeGetMode();

    private static native boolean nativeGetRecordable();

    private static native String nativeGetRecords(int r10);

    private static native String nativeGetVersion();

    private static native int nativeInit(int r10, boolean r11);

    private static native void nativeSetDebuggable(boolean r10);

    private static native void nativeSetRecordable(boolean r10);

    private static native String nativeToErrmsg(int r10);

    public static void setDebuggable(boolean r10) {
        if (isInitedOk() == false) goto L6;
        nativeSetDebuggable(r10);
        return;
    }

    public static void setRecordable(boolean r10) {
        if (isInitedOk() == false) goto L6;
        nativeSetRecordable(r10);
        return;
    }

    public static String toErrmsg(int r10) {
        if (r10 != 0) goto L6;
        return "OK";
    L6:
        if (r10 != 1) goto L10;
        return "Pending task";
    L10:
        if (r10 != 2) goto L14;
        return "Not initialized";
    L14:
        if (r10 != 100) goto L18;
        return "Load libshadowhook.so failed";
    L18:
        if (r10 != 101) goto L22;
        return "Init exception";
    L22:
        if (isInitedOk() == true) goto L24;
        return "Unknown";
    L24:
        return nativeToErrmsg(r10);
    }
}
