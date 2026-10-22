package com.bytedance.crash;

/* JADX INFO: loaded from: classes2.dex */
public final enum CrashType extends Enum<CrashType> {
    private static final /* synthetic */ CrashType[] $VALUES = null;
    public static final CrashType ALL = null;
    public static final CrashType ANR = null;
    public static final CrashType ASAN = null;
    public static final CrashType BLOCK = null;
    public static final CrashType CJAVA = null;
    public static final CrashType CUSTOM_JAVA = null;
    public static final CrashType CUSTOM_NATIVE = null;
    public static final CrashType DART = null;
    public static final CrashType ENSURE = null;
    public static final CrashType EVENT = null;
    public static final CrashType GAME = null;
    public static final CrashType JAVA = null;
    public static final CrashType LAUNCH = null;
    public static final CrashType NATIVE = null;
    public static final CrashType OOM = null;
    public static final CrashType TSAN = null;
    private final String mName;

    static {
        CrashType r5 = new CrashType("LAUNCH", 0, "launch");
        LAUNCH = r5;
        CrashType r10 = new CrashType("JAVA", 1, "java");
        JAVA = r10;
        CrashType r11 = new CrashType("NATIVE", 2, "native");
        NATIVE = r11;
        CrashType r12 = new CrashType("ASAN", 3, "asan");
        ASAN = r12;
        CrashType r13 = new CrashType("TSAN", 4, "tsan");
        TSAN = r13;
        CrashType r14 = new CrashType("ANR", 5, "anr");
        ANR = r14;
        CrashType r15 = new CrashType("BLOCK", 6, "block");
        BLOCK = r15;
        CrashType r16 = new CrashType("ENSURE", 7, "ensure");
        ENSURE = r16;
        CrashType r17 = new CrashType("DART", 8, "dart");
        DART = r17;
        CrashType r18 = new CrashType("GAME", 9, "game");
        GAME = r18;
        CrashType r19 = new CrashType("CUSTOM_JAVA", 10, "custom_java");
        CUSTOM_JAVA = r19;
        CrashType r110 = new CrashType("OOM", 11, "oom");
        OOM = r110;
        CrashType r111 = new CrashType("CJAVA", 12, "cjava");
        CJAVA = r111;
        CrashType r112 = new CrashType("CUSTOM_NATIVE", 13, "custom_native");
        CUSTOM_NATIVE = r112;
        CrashType r113 = new CrashType("EVENT", 14, "event");
        EVENT = r113;
        CrashType r114 = new CrashType("ALL", 15, "all");
        ALL = r114;
        $VALUES = new CrashType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114};
    }

    private CrashType(String r5, int r10, String r11) {
        super(r5, r10);
        this.mName = r11;
    }

    public static CrashType valueOf(String r5) {
        return (CrashType) Enum.valueOf(CrashType.class, r5);
    }

    public static CrashType[] values() {
        return (CrashType[]) $VALUES.clone();
    }

    public String getName() {
        return this.mName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }
}
