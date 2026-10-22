package com.bytedance.shadowhook;

/* JADX INFO: loaded from: classes2.dex */
public final class ShadowHook {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f7506a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f7507b = 0;

    public static final enum Mode extends Enum<Mode> {
        public static final Mode SHARED = null;
        public static final Mode UNIQUE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f7508a = null;
        private final int value;

        static {
            Mode r5 = new Mode("SHARED", 0, 0);
            SHARED = r5;
            Mode r10 = new Mode("UNIQUE", 1, 1);
            UNIQUE = r10;
            f7508a = new Mode[]{r5, r10};
        }

        public Mode(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static Mode valueOf(String r5) {
            return (Mode) Enum.valueOf(Mode.class, r5);
        }

        public static Mode[] values() {
            return (Mode[]) f7508a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum RecordItem extends Enum<RecordItem> {
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RecordItem[] f7509a = null;

        static {
            RecordItem r5 = new RecordItem("TIMESTAMP", 0);
            TIMESTAMP = r5;
            RecordItem r10 = new RecordItem("CALLER_LIB_NAME", 1);
            CALLER_LIB_NAME = r10;
            RecordItem r11 = new RecordItem("OP", 2);
            OP = r11;
            RecordItem r12 = new RecordItem("LIB_NAME", 3);
            LIB_NAME = r12;
            RecordItem r13 = new RecordItem("SYM_NAME", 4);
            SYM_NAME = r13;
            RecordItem r14 = new RecordItem("SYM_ADDR", 5);
            SYM_ADDR = r14;
            RecordItem r15 = new RecordItem("NEW_ADDR", 6);
            NEW_ADDR = r15;
            RecordItem r16 = new RecordItem("BACKUP_LEN", 7);
            BACKUP_LEN = r16;
            RecordItem r17 = new RecordItem("ERRNO", 8);
            ERRNO = r17;
            RecordItem r18 = new RecordItem("STUB", 9);
            STUB = r18;
            f7509a = new RecordItem[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18};
        }

        public static RecordItem valueOf(String r5) {
            return (RecordItem) Enum.valueOf(RecordItem.class, r5);
        }

        public static RecordItem[] values() {
            return (RecordItem[]) f7509a.clone();
        }
    }

    static {
        f7507b = Mode.SHARED.getValue();
    }

    public static void a() {
        if (f7506a == false) goto L5;
        return;
    L5:
        int r5 = f7507b;
        monitor-enter(ShadowHook.class);
    L19:
        th = move-exception;
        throw th;
    L8:
        if (f7506a == false) goto L12;
        monitor-exit(ShadowHook.class);
        return;
    L12:
        f7506a = true;     // Catch: Throwable -> L19
        System.currentTimeMillis();     // Catch: Throwable -> L19
        System.loadLibrary("shadowhook");     // Catch: Throwable -> L21
    L27:
        nativeInit(r5, false);     // Catch: Throwable -> L26
    L16:
        System.currentTimeMillis();     // Catch: Throwable -> L19
        monitor-exit(ShadowHook.class);
        return;
    L21:
        System.currentTimeMillis();     // Catch: Throwable -> L19
    }

    private static native String nativeGetArch();

    private static native int nativeGetInitErrno();

    private static native String nativeGetRecords(int r5);

    private static native int nativeInit(int r5, boolean r10);

    private static native void nativeSetDebuggable(boolean r5);

    private static native String nativeToErrmsg(int r5);
}
