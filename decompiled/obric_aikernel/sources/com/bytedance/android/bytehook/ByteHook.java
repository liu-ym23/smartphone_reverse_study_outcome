package com.bytedance.android.bytehook;

import com.bytedance.shadowhook.ShadowHook;

/* JADX INFO: loaded from: classes.dex */
public class ByteHook {
    private static final int ERRNO_INIT_EXCEPTION = 101;
    private static final int ERRNO_LOAD_LIBRARY_EXCEPTION = 100;
    private static final int ERRNO_OK = 0;
    private static final int ERRNO_UNINIT = 1;
    private static final boolean defaultDebug = false;
    private static final com.bytedance.android.bytehook.a defaultLibLoader = null;
    private static final int defaultMode = 0;
    private static final boolean defaultRecordable = false;
    private static final boolean defaultShadowhookDebug = false;
    private static final ShadowHook.d defaultShadowhookLibLoader = null;
    private static final ShadowHook.Mode defaultShadowhookMode = null;
    private static final boolean defaultShadowhookRecordable = false;
    private static long initCostMs = -1;
    private static int initStatus = 1;
    private static boolean inited = false;
    private static final String libName = "bytehook";
    private static final int recordItemAll = 255;
    private static final int recordItemCallerLibName = 2;
    private static final int recordItemErrno = 64;
    private static final int recordItemLibName = 8;
    private static final int recordItemNewAddr = 32;
    private static final int recordItemOp = 4;
    private static final int recordItemStub = 128;
    private static final int recordItemSymName = 16;
    private static final int recordItemTimestamp = 1;

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode AUTOMATIC = null;
        public static final Mode MANUAL = null;
        private final int value;

        static {
            Mode r10 = new Mode("AUTOMATIC", 0, 0);
            AUTOMATIC = r10;
            Mode r11 = new Mode("MANUAL", 1, 1);
            MANUAL = r11;
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
        public static final RecordItem CALLER_LIB_NAME = null;
        public static final RecordItem ERRNO = null;
        public static final RecordItem LIB_NAME = null;
        public static final RecordItem NEW_ADDR = null;
        public static final RecordItem OP = null;
        public static final RecordItem STUB = null;
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
            RecordItem r15 = new RecordItem("NEW_ADDR", 5);
            NEW_ADDR = r15;
            RecordItem r16 = new RecordItem("ERRNO", 6);
            ERRNO = r16;
            RecordItem r17 = new RecordItem("STUB", 7);
            STUB = r17;
            $VALUES = new RecordItem[]{r10, r11, r12, r13, r14, r15, r16, r17};
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
        static final /* synthetic */ int[] f699a = null;

        static {
            int[] r10 = new int[RecordItem.values().length];
            f699a = r10;
            r10[RecordItem.TIMESTAMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f699a[RecordItem.CALLER_LIB_NAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f699a[RecordItem.OP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f699a[RecordItem.LIB_NAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f699a[RecordItem.SYM_NAME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f699a[RecordItem.NEW_ADDR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f699a[RecordItem.ERRNO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f699a[RecordItem.STUB.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.android.bytehook.a f700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ShadowHook.d f704e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ShadowHook.Mode f705f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f706g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f707h;

        public b() {
        }

        public boolean a() {
            return this.f702c;
        }

        public com.bytedance.android.bytehook.a b() {
            return this.f700a;
        }

        public int c() {
            return this.f701b;
        }

        public boolean d() {
            return this.f703d;
        }

        public boolean e() {
            return this.f706g;
        }

        public ShadowHook.d f() {
            return this.f704e;
        }

        public ShadowHook.Mode g() {
            return this.f705f;
        }

        public boolean h() {
            return this.f707h;
        }

        public void i(boolean r10) {
            this.f702c = r10;
        }

        public void j(com.bytedance.android.bytehook.a r10) {
            this.f700a = r10;
        }

        public void k(int r10) {
            this.f701b = r10;
        }

        public void l(boolean r10) {
            this.f703d = r10;
        }

        public void m(boolean r10) {
            this.f706g = r10;
        }

        public void n(ShadowHook.d r10) {
            this.f704e = r10;
        }

        public void o(ShadowHook.Mode r10) {
            this.f705f = r10;
        }

        public void p(boolean r10) {
            this.f707h = r10;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.android.bytehook.a f708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f711d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ShadowHook.d f712e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ShadowHook.Mode f713f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f714g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f715h;

        public c() {
            this.f708a = ByteHook.access$000();
            this.f709b = ByteHook.access$100();
            this.f710c = false;
            this.f711d = false;
            this.f712e = ByteHook.access$200();
            this.f713f = ByteHook.access$300();
            this.f714g = false;
            this.f715h = false;
        }

        public b a() {
            b r10 = new b();
            r10.j(this.f708a);
            r10.k(this.f709b);
            r10.i(this.f710c);
            r10.l(this.f711d);
            r10.n(this.f712e);
            r10.o(this.f713f);
            r10.m(this.f714g);
            r10.p(this.f715h);
            return r10;
        }
    }

    static {
        defaultMode = Mode.AUTOMATIC.getValue();
        defaultShadowhookLibLoader = null;
        defaultShadowhookMode = ShadowHook.Mode.SHARED;
    }

    public ByteHook() {
    }

    static /* synthetic */ com.bytedance.android.bytehook.a access$000() {
        return defaultLibLoader;
    }

    static /* synthetic */ int access$100() {
        return defaultMode;
    }

    static /* synthetic */ ShadowHook.d access$200() {
        return defaultShadowhookLibLoader;
    }

    static /* synthetic */ ShadowHook.Mode access$300() {
        return defaultShadowhookMode;
    }

    public static int addIgnore(String r10) {
        int r11 = initStatus;
        if (r11 == 0) goto L5;
        return r11;
    L5:
        return nativeAddIgnore(r10);
    }

    public static String getArch() {
        if (initStatus == 0) goto L5;
        return "unknown";
    L5:
        return nativeGetArch();
    }

    public static boolean getDebug() {
        if (initStatus == 0) goto L5;
        return false;
    L5:
        return nativeGetDebug();
    }

    public static long getInitCostMs() {
        return initCostMs;
    }

    public static int getInitErrno() {
        return initStatus;
    }

    public static Mode getMode() {
        if (initStatus != 0) goto L10;
        Mode r10 = Mode.AUTOMATIC;
        if (r10.getValue() != nativeGetMode()) goto L8;
        return r10;
    L8:
        return Mode.MANUAL;
    L10:
        return Mode.AUTOMATIC;
    }

    public static boolean getRecordable() {
        if (initStatus == 0) goto L5;
        return false;
    L5:
        return nativeGetRecordable();
    }

    public static String getRecords(RecordItem... r10) {
        if (initStatus != 0) goto L22;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L5:
        if (r12 >= r11) goto L18;
        switch(a.f699a[r10[r12].ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L17;
        };
    L9:
        r13 = r13 | 128;
        goto L17
    L10:
        r13 = r13 | 64;
        goto L17
    L11:
        r13 = r13 | 32;
        goto L17
    L12:
        r13 = r13 | 16;
        goto L17
    L13:
        r13 = r13 | 8;
        goto L17
    L14:
        r13 = r13 | 4;
        goto L17
    L15:
        r13 = r13 | 2;
        goto L17
    L16:
        r13 = r13 | 1;
    L17:
        r12 = r12 + 1;
        goto L5
    L18:
        if (r13 != 0) goto L21;
        r13 = 255;
    L21:
        return nativeGetRecords(r13);
    L22:
        return null;
    }

    public static String getVersion() {
        return nativeGetVersion();
    }

    public static int init() {
        return init(null);
    }

    public static synchronized int init(b r10) {
        monitor-enter(ByteHook.class);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L10;
        int r11 = initStatus;     // Catch: Throwable -> L34
        monitor-exit(ByteHook.class);
        return r11;
    L10:
        inited = true;     // Catch: Throwable -> L34
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L34
        if (r10 != null) goto L13;
        r10 = new c().a();     // Catch: Throwable -> L34
    L13:
        ShadowHook.init(new ShadowHook.c().c(r10.f()).d(r10.g()).b(r10.e()).e(r10.h()).a());     // Catch: Throwable -> L34
        if (r10.b() != null) goto L17;
        System.loadLibrary(libName);     // Catch: Throwable -> L30
    L41:
        initStatus = nativeInit(r10.c(), r10.a());     // Catch: Throwable -> L21
    L23:
        if (r10.d() == true) goto L39;
    L27:
        initCostMs = System.currentTimeMillis() - r12;     // Catch: Throwable -> L34
        int r13 = initStatus;     // Catch: Throwable -> L34
        monitor-exit(ByteHook.class);
        return r13;
    L39:
        nativeSetRecordable(r10.d());     // Catch: Throwable -> L26
    L26:
        initStatus = 101;     // Catch: Throwable -> L34
    L21:
        initStatus = 101;     // Catch: Throwable -> L34
        goto L23
    L17:
        r10.b().loadLibrary(libName);     // Catch: Throwable -> L30
        goto L41
    L31:
        initStatus = 100;     // Catch: Throwable -> L34
        initCostMs = System.currentTimeMillis() - r12;     // Catch: Throwable -> L34
        return initStatus;
    }

    private static native int nativeAddIgnore(String r10);

    private static native String nativeGetArch();

    private static native boolean nativeGetDebug();

    private static native int nativeGetMode();

    private static native boolean nativeGetRecordable();

    private static native String nativeGetRecords(int r10);

    private static native String nativeGetVersion();

    private static native int nativeInit(int r10, boolean r11);

    private static native void nativeSetDebug(boolean r10);

    private static native void nativeSetRecordable(boolean r10);

    public static void setDebug(boolean r10) {
        if (initStatus != 0) goto L6;
        nativeSetDebug(r10);
        return;
    }

    public static void setRecordable(boolean r10) {
        if (initStatus != 0) goto L6;
        nativeSetRecordable(r10);
        return;
    }
}
