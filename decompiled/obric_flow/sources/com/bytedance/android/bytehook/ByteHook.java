package com.bytedance.android.bytehook;

import p4.a;
import p4.b;

/* JADX INFO: loaded from: classes2.dex */
public class ByteHook {
    private static final boolean defaultDebug = false;
    private static final b defaultLibLoader = null;
    private static final int defaultMode = 0;
    private static int initStatus = 1;
    private static boolean inited = false;
    private static final String libName = "bytehook";

    public static final enum Mode extends Enum<Mode> {
        public static final Mode AUTOMATIC = null;
        public static final Mode MANUAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f3507a = null;
        private final int value;

        static {
            Mode r5 = new Mode("AUTOMATIC", 0, 0);
            AUTOMATIC = r5;
            Mode r10 = new Mode("MANUAL", 1, 1);
            MANUAL = r10;
            f3507a = new Mode[]{r5, r10};
        }

        public Mode(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static Mode valueOf(String r5) {
            return (Mode) Enum.valueOf(Mode.class, r5);
        }

        public static Mode[] values() {
            return (Mode[]) f3507a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    static {
        defaultMode = Mode.AUTOMATIC.getValue();
    }

    public ByteHook() {
    }

    public static /* synthetic */ b access$000() {
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
        access$000();
        int r5 = access$100();
        a r10 = new a();
        r10.f21318a = r5;
        return init(r10);
    L5:
        return initStatus;
    }

    private static native String nativeGetRecords();

    private static native int nativeInit(int r5, boolean r10);

    private static native void nativeSetDebug(boolean r5);

    public static void setDebug(boolean r5) {
        if (initStatus != 0) goto L6;
        nativeSetDebug(r5);
        return;
    }

    public static synchronized int init(a r5) {
        monitor-enter(ByteHook.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L12;
        int r10 = initStatus;     // Catch: Throwable -> L9
        monitor-exit(ByteHook.class);
        return r10;
    L12:
        inited = true;     // Catch: Throwable -> L9
        r5.getClass();     // Catch: Throwable -> L21
        System.loadLibrary(libName);     // Catch: Throwable -> L21
        initStatus = nativeInit(r5.f21318a, false);     // Catch: Throwable -> L16
    L18:
        int r11 = initStatus;     // Catch: Throwable -> L9
        monitor-exit(ByteHook.class);
        return r11;
    L17:
        initStatus = 101;     // Catch: Throwable -> L9
        goto L18
    L22:
        initStatus = 100;     // Catch: Throwable -> L9
        return 100;
    }
}
