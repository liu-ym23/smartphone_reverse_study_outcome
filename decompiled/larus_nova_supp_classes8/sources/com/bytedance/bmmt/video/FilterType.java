package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final enum FilterType extends Enum<FilterType> {
    private static final /* synthetic */ FilterType[] $VALUES = null;
    public static final FilterType BOX = null;
    public static final FilterType Bicubic = null;
    public static final FilterType Bilinear = null;
    public static final FilterType Origin = null;
    private final int value;

    private static /* synthetic */ FilterType[] $values() {
        return new FilterType[]{Origin, Bilinear, Bicubic, BOX};
    }

    static {
        Origin = new FilterType("Origin", 0, 9);
        Bilinear = new FilterType("Bilinear", 1, 10);
        Bicubic = new FilterType("Bicubic", 2, 11);
        BOX = new FilterType("BOX", 3, 12);
        $VALUES = $values();
    }

    public static FilterType[] values() {
        return (FilterType[]) $VALUES.clone();
    }

    public int toInt() {
        return this.value;
    }

    public static FilterType fromValue(int r0) {
        switch(r0) {
            case 10: goto L10;
            case 11: goto L8;
            case 12: goto L6;
            default: goto L4;
        };
    L4:
        return Origin;
    L6:
        return BOX;
    L8:
        return Bicubic;
    L10:
        return Bilinear;
    }

    public static FilterType valueOf(String r1) {
        return (FilterType) r27.a.a(FilterType.class, r1);
    }

    private FilterType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
