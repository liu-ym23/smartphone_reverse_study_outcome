package com.lynx.clay.embedding.engine.plugins.platformview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum MeasureMode extends Enum<MeasureMode> {
    public static final MeasureMode AT_MOST = null;
    public static final MeasureMode EXACTLY = null;
    public static final MeasureMode UNDEFINED = null;
    public static final /* synthetic */ MeasureMode[] a = null;
    private final int mIntValue;

    static {
        MeasureMode r0 = new MeasureMode("UNDEFINED", 0, 0);
        UNDEFINED = r0;
        MeasureMode r1 = new MeasureMode("EXACTLY", 1, 1);
        EXACTLY = r1;
        MeasureMode r3 = new MeasureMode("AT_MOST", 2, 2);
        AT_MOST = r3;
        a = new MeasureMode[]{r0, r1, r3};
    }

    public static MeasureMode[] values() {
        return (MeasureMode[]) a.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static MeasureMode fromInt(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L10;
        return AT_MOST;
    L10:
        throw new IllegalArgumentException("Unknown measureMode");
    L12:
        return EXACTLY;
    L14:
        return UNDEFINED;
    }

    public static MeasureMode valueOf(String r1) {
        return (MeasureMode) r27.a.a(MeasureMode.class, r1);
    }

    public MeasureMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.mIntValue = r3;
    }
}
