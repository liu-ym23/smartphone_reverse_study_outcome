package com.bytedance.android.alog;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class Alog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3100a;

    public static final enum AsymCrypt extends Enum<AsymCrypt> {
        public static final AsymCrypt EC_SECP256K1 = null;
        public static final AsymCrypt EC_SECP256R1 = null;
        public static final AsymCrypt NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AsymCrypt[] f3101a = null;
        private final int value;

        static {
            AsymCrypt r5 = new AsymCrypt("NONE", 0, 0);
            NONE = r5;
            AsymCrypt r10 = new AsymCrypt("EC_SECP256K1", 1, 1);
            EC_SECP256K1 = r10;
            AsymCrypt r11 = new AsymCrypt("EC_SECP256R1", 2, 2);
            EC_SECP256R1 = r11;
            f3101a = new AsymCrypt[]{r5, r10, r11};
        }

        public AsymCrypt(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static AsymCrypt valueOf(String r5) {
            return (AsymCrypt) Enum.valueOf(AsymCrypt.class, r5);
        }

        public static AsymCrypt[] values() {
            return (AsymCrypt[]) f3101a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum Compress extends Enum<Compress> {
        public static final Compress NONE = null;
        public static final Compress ZLIB = null;
        public static final Compress ZSTD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Compress[] f3102a = null;
        private final int value;

        static {
            Compress r5 = new Compress("NONE", 0, 0);
            NONE = r5;
            Compress r10 = new Compress("ZLIB", 1, 1);
            ZLIB = r10;
            Compress r11 = new Compress("ZSTD", 2, 2);
            ZSTD = r11;
            f3102a = new Compress[]{r5, r10, r11};
        }

        public Compress(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static Compress valueOf(String r5) {
            return (Compress) Enum.valueOf(Compress.class, r5);
        }

        public static Compress[] values() {
            return (Compress[]) f3102a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum Mode extends Enum<Mode> {
        public static final Mode SAFE = null;
        public static final Mode SPEED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f3103a = null;
        private final int value;

        static {
            Mode r5 = new Mode("SPEED", 0, 0);
            SPEED = r5;
            Mode r10 = new Mode("SAFE", 1, 1);
            SAFE = r10;
            f3103a = new Mode[]{r5, r10};
        }

        public Mode(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static Mode valueOf(String r5) {
            return (Mode) Enum.valueOf(Mode.class, r5);
        }

        public static Mode[] values() {
            return (Mode[]) f3103a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum PrefixFormat extends Enum<PrefixFormat> {
        public static final PrefixFormat DEFAULT = null;
        public static final PrefixFormat LEGACY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PrefixFormat[] f3104a = null;
        private final int value;

        static {
            PrefixFormat r5 = new PrefixFormat("DEFAULT", 0, 0);
            DEFAULT = r5;
            PrefixFormat r10 = new PrefixFormat("LEGACY", 1, 1);
            LEGACY = r10;
            f3104a = new PrefixFormat[]{r5, r10};
        }

        public PrefixFormat(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static PrefixFormat valueOf(String r5) {
            return (PrefixFormat) Enum.valueOf(PrefixFormat.class, r5);
        }

        public static PrefixFormat[] values() {
            return (PrefixFormat[]) f3104a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum SymCrypt extends Enum<SymCrypt> {
        public static final SymCrypt NONE = null;
        public static final SymCrypt TEA_16 = null;
        public static final SymCrypt TEA_32 = null;
        public static final SymCrypt TEA_64 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SymCrypt[] f3105a = null;
        private final int value;

        static {
            SymCrypt r5 = new SymCrypt("NONE", 0, 0);
            NONE = r5;
            SymCrypt r10 = new SymCrypt("TEA_16", 1, 1);
            TEA_16 = r10;
            SymCrypt r11 = new SymCrypt("TEA_32", 2, 2);
            TEA_32 = r11;
            SymCrypt r12 = new SymCrypt("TEA_64", 3, 3);
            TEA_64 = r12;
            f3105a = new SymCrypt[]{r5, r10, r11, r12};
        }

        public SymCrypt(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static SymCrypt valueOf(String r5) {
            return (SymCrypt) Enum.valueOf(SymCrypt.class, r5);
        }

        public static SymCrypt[] values() {
            return (SymCrypt[]) f3105a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum TimeFormat extends Enum<TimeFormat> {
        public static final TimeFormat ISO_8601 = null;
        public static final TimeFormat RAW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TimeFormat[] f3106a = null;
        private final int value;

        static {
            TimeFormat r5 = new TimeFormat("RAW", 0, 0);
            RAW = r5;
            TimeFormat r10 = new TimeFormat("ISO_8601", 1, 1);
            ISO_8601 = r10;
            f3106a = new TimeFormat[]{r5, r10};
        }

        public TimeFormat(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static TimeFormat valueOf(String r5) {
            return (TimeFormat) Enum.valueOf(TimeFormat.class, r5);
        }

        public static TimeFormat[] values() {
            return (TimeFormat[]) f3106a.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    static {
        Mode.SAFE.getValue();
        TimeFormat.RAW.getValue();
        PrefixFormat.DEFAULT.getValue();
        Compress.ZSTD.getValue();
        SymCrypt.TEA_16.getValue();
        AsymCrypt.EC_SECP256K1.getValue();
        new ArrayList();
    }

    private static native void nativeAsyncFlush(long r5);

    private static native long nativeCreate(int r5, boolean r10, String r11, String r12, int r13, int r14, int r15, String r16, int r17, int r18, String r19, int r110, int r111, int r112, int r113, int r114, int r115, String r116);

    private static native void nativeDestroy(long r5);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native void nativeSetLevel(long r5, int r10);

    private static native void nativeSetSyslog(long r5, boolean r10);

    private static native void nativeSyncFlush(long r5);

    private static native void nativeTimedSyncFlush(long r5, int r10);

    private static native void nativeWrite(long r5, int r10, String r11, String r12);

    public final void a() {
        long r5 = this.f3100a;
        if (r5 <= 0) goto L6;
        nativeAsyncFlush(r5);
        return;
    }

    public final void b() {
        monitor-enter(this);
        long r5 = this.f3100a;     // Catch: Throwable -> L6
        if (r5 <= 0) goto L8;
        nativeDestroy(r5);     // Catch: Throwable -> L6
        this.f3100a = 0;     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void c(int r5) {
        long r10 = this.f3100a;
        if (r10 <= 0) goto L6;
        nativeSetLevel(r10, r5);
        return;
    }

    public final void d(boolean r5) {
        long r10 = this.f3100a;
        if (r10 <= 0) goto L6;
        nativeSetSyslog(r10, r5);
        return;
    }

    public final void e() {
        long r5 = this.f3100a;
        if (r5 <= 0) goto L6;
        nativeSyncFlush(r5);
        return;
    }

    public final void f(int r5) {
        long r10 = this.f3100a;
        if (r10 <= 0) goto L6;
        nativeTimedSyncFlush(r10, r5);
        return;
    }

    public final void finalize() {
        super.finalize();     // Catch: Throwable -> L5
        b();
        return;
    L5:
        th = move-exception;
        b();
        throw th;
    }

    public final void g(int r5, String r10, String r11) {
        long r12 = this.f3100a;
        if (r12 > 0) goto L5;
        return;
    L5:
        if (r5 < 6) goto L11;
        if (r10 == null) goto L12;
        if (r11 == null) goto L13;
        nativeWrite(r12, r5, r10, r11);
        return;
    L13:
        return;
    L12:
        return;
    }
}
