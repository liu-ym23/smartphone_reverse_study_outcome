package com.bytedance.ttnet.tnc;

/* JADX INFO: loaded from: classes2.dex */
public final enum TNCManager$TNCUpdateSource extends Enum<TNCManager$TNCUpdateSource> {
    public static final TNCManager$TNCUpdateSource PORTRETRY = null;
    public static final TNCManager$TNCUpdateSource TTCACHE = null;
    public static final TNCManager$TNCUpdateSource TTCRONET = null;
    public static final TNCManager$TNCUpdateSource TTERROR = null;
    public static final TNCManager$TNCUpdateSource TTHardCode = null;
    public static final TNCManager$TNCUpdateSource TTPOLL = null;
    public static final TNCManager$TNCUpdateSource TTREGION = null;
    public static final TNCManager$TNCUpdateSource TTRESUME = null;
    public static final TNCManager$TNCUpdateSource TTSERVER = null;
    public static final TNCManager$TNCUpdateSource TTTNC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TNCManager$TNCUpdateSource[] f7534a = null;
    public final int mValue;

    static {
        TNCManager$TNCUpdateSource r5 = new TNCManager$TNCUpdateSource("TTRESUME", 0, -2);
        TTRESUME = r5;
        TNCManager$TNCUpdateSource r10 = new TNCManager$TNCUpdateSource("TTHardCode", 1, -1);
        TTHardCode = r10;
        TNCManager$TNCUpdateSource r11 = new TNCManager$TNCUpdateSource("TTCACHE", 2, 0);
        TTCACHE = r11;
        TNCManager$TNCUpdateSource r12 = new TNCManager$TNCUpdateSource("TTSERVER", 3, 1);
        TTSERVER = r12;
        TNCManager$TNCUpdateSource r13 = new TNCManager$TNCUpdateSource("TTERROR", 4, 2);
        TTERROR = r13;
        TNCManager$TNCUpdateSource r14 = new TNCManager$TNCUpdateSource("TTPOLL", 5, 3);
        TTPOLL = r14;
        TNCManager$TNCUpdateSource r15 = new TNCManager$TNCUpdateSource("TTTNC", 6, 4);
        TTTNC = r15;
        TNCManager$TNCUpdateSource r16 = new TNCManager$TNCUpdateSource("PORTRETRY", 7, 7);
        PORTRETRY = r16;
        TNCManager$TNCUpdateSource r17 = new TNCManager$TNCUpdateSource("TTREGION", 8, 10);
        TTREGION = r17;
        TNCManager$TNCUpdateSource r18 = new TNCManager$TNCUpdateSource("TTCRONET", 9, 20);
        TTCRONET = r18;
        f7534a = new TNCManager$TNCUpdateSource[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    public TNCManager$TNCUpdateSource(String r5, int r10, int r11) {
        super(r5, r10);
        this.mValue = r11;
    }

    public static TNCManager$TNCUpdateSource valueOf(String r5) {
        return (TNCManager$TNCUpdateSource) Enum.valueOf(TNCManager$TNCUpdateSource.class, r5);
    }

    public static TNCManager$TNCUpdateSource[] values() {
        return (TNCManager$TNCUpdateSource[]) f7534a.clone();
    }
}
