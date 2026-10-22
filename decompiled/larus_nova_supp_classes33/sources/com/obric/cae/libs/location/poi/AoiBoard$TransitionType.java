package com.obric.cae.libs.location.poi;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final enum AoiBoard$TransitionType extends Enum<AoiBoard$TransitionType> {
    public static final AoiBoard$TransitionType ENTERED_AND_EXITED = null;
    public static final AoiBoard$TransitionType ENTERED_ONLY = null;
    public static final AoiBoard$TransitionType EXITED_ONLY = null;
    public static final AoiBoard$TransitionType UNKNOWN = null;
    public static final /* synthetic */ AoiBoard$TransitionType[] b = null;
    public final int a;

    static {
        AoiBoard$TransitionType r0 = new AoiBoard$TransitionType(0, 0, "UNKNOWN");
        UNKNOWN = r0;
        AoiBoard$TransitionType r1 = new AoiBoard$TransitionType(1, 1, "ENTERED_ONLY");
        ENTERED_ONLY = r1;
        AoiBoard$TransitionType r3 = new AoiBoard$TransitionType(2, 2, "EXITED_ONLY");
        EXITED_ONLY = r3;
        AoiBoard$TransitionType r5 = new AoiBoard$TransitionType(3, 3, "ENTERED_AND_EXITED");
        ENTERED_AND_EXITED = r5;
        b = new AoiBoard$TransitionType[]{r0, r1, r3, r5};
    }

    public static AoiBoard$TransitionType[] values() {
        return (AoiBoard$TransitionType[]) b.clone();
    }

    public int getValue() {
        return this.a;
    }

    public static AoiBoard$TransitionType valueOf(String r1) {
        return (AoiBoard$TransitionType) a.a(AoiBoard$TransitionType.class, r1);
    }

    public AoiBoard$TransitionType(int r1, int r2, String r3) {
        super(r3, r1);
        this.a = r2;
    }
}
