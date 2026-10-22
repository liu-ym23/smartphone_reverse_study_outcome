package com.obric.matrix.platform.sdk.ones.region;

/* JADX INFO: loaded from: classes2.dex */
public final enum Region extends Enum<Region> {
    private static final /* synthetic */ Region[] $VALUES = null;
    public static final Region CN = null;
    public static final Region HK = null;

    private static final /* synthetic */ Region[] $values() {
        return new Region[]{HK, CN};
    }

    static {
        HK = new Region("HK", 0);
        CN = new Region("CN", 1);
        $VALUES = $values();
    }

    private Region(String r10, int r11) {
        super(r10, r11);
    }

    public static Region valueOf(String r10) {
        return (Region) Enum.valueOf(Region.class, r10);
    }

    public static Region[] values() {
        return (Region[]) $VALUES.clone();
    }
}
