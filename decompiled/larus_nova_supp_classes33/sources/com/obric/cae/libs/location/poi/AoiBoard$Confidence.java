package com.obric.cae.libs.location.poi;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final enum AoiBoard$Confidence extends Enum<AoiBoard$Confidence> {
    public static final AoiBoard$Confidence HIGH = null;
    public static final AoiBoard$Confidence LOW = null;
    public static final AoiBoard$Confidence MAX = null;
    public static final AoiBoard$Confidence MEDIUM = null;
    public static final AoiBoard$Confidence MIN = null;
    public static final /* synthetic */ AoiBoard$Confidence[] b = null;
    public final int a;

    static {
        AoiBoard$Confidence r0 = new AoiBoard$Confidence(0, 0, "MIN");
        MIN = r0;
        AoiBoard$Confidence r1 = new AoiBoard$Confidence(1, 1, "LOW");
        LOW = r1;
        AoiBoard$Confidence r3 = new AoiBoard$Confidence(2, 2, "MEDIUM");
        MEDIUM = r3;
        AoiBoard$Confidence r5 = new AoiBoard$Confidence(3, 3, "HIGH");
        HIGH = r5;
        AoiBoard$Confidence r7 = new AoiBoard$Confidence(4, 4, "MAX");
        MAX = r7;
        b = new AoiBoard$Confidence[]{r0, r1, r3, r5, r7};
    }

    public static AoiBoard$Confidence[] values() {
        return (AoiBoard$Confidence[]) b.clone();
    }

    public int getValue() {
        return this.a;
    }

    public static AoiBoard$Confidence valueOf(String r1) {
        return (AoiBoard$Confidence) a.a(AoiBoard$Confidence.class, r1);
    }

    public AoiBoard$Confidence(int r1, int r2, String r3) {
        super(r3, r1);
        this.a = r2;
    }
}
