package com.obric.cae.libs.location.poi;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final enum AoiBoard$ConfidenceSource extends Enum<AoiBoard$ConfidenceSource> {
    public static final AoiBoard$ConfidenceSource DEFAULT = null;
    public static final AoiBoard$ConfidenceSource DISTANCE = null;
    public static final AoiBoard$ConfidenceSource RETRY = null;
    public static final /* synthetic */ AoiBoard$ConfidenceSource[] b = null;
    public final int a;

    static {
        AoiBoard$ConfidenceSource r0 = new AoiBoard$ConfidenceSource(0, 0, "DEFAULT");
        DEFAULT = r0;
        AoiBoard$ConfidenceSource r1 = new AoiBoard$ConfidenceSource(1, 1, "DISTANCE");
        DISTANCE = r1;
        AoiBoard$ConfidenceSource r3 = new AoiBoard$ConfidenceSource(2, 2, "RETRY");
        RETRY = r3;
        b = new AoiBoard$ConfidenceSource[]{r0, r1, r3};
    }

    public static AoiBoard$ConfidenceSource[] values() {
        return (AoiBoard$ConfidenceSource[]) b.clone();
    }

    public int getValue() {
        return this.a;
    }

    public static AoiBoard$ConfidenceSource valueOf(String r1) {
        return (AoiBoard$ConfidenceSource) a.a(AoiBoard$ConfidenceSource.class, r1);
    }

    public AoiBoard$ConfidenceSource(int r1, int r2, String r3) {
        super(r3, r1);
        this.a = r2;
    }
}
