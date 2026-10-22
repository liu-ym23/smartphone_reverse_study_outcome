package com.obric.oui.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes3.dex */
public final enum ConstraintWidget$DimensionBehaviour extends Enum<ConstraintWidget$DimensionBehaviour> {
    public static final ConstraintWidget$DimensionBehaviour FIXED = null;
    public static final ConstraintWidget$DimensionBehaviour MATCH_CONSTRAINT = null;
    public static final ConstraintWidget$DimensionBehaviour MATCH_PARENT = null;
    public static final ConstraintWidget$DimensionBehaviour WRAP_CONTENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConstraintWidget$DimensionBehaviour[] f12556a = null;

    static {
        ConstraintWidget$DimensionBehaviour r5 = new ConstraintWidget$DimensionBehaviour("FIXED", 0);
        FIXED = r5;
        ConstraintWidget$DimensionBehaviour r10 = new ConstraintWidget$DimensionBehaviour("WRAP_CONTENT", 1);
        WRAP_CONTENT = r10;
        ConstraintWidget$DimensionBehaviour r11 = new ConstraintWidget$DimensionBehaviour("MATCH_CONSTRAINT", 2);
        MATCH_CONSTRAINT = r11;
        ConstraintWidget$DimensionBehaviour r12 = new ConstraintWidget$DimensionBehaviour("MATCH_PARENT", 3);
        MATCH_PARENT = r12;
        f12556a = new ConstraintWidget$DimensionBehaviour[]{r5, r10, r11, r12};
    }

    public static ConstraintWidget$DimensionBehaviour valueOf(String r5) {
        return (ConstraintWidget$DimensionBehaviour) Enum.valueOf(ConstraintWidget$DimensionBehaviour.class, r5);
    }

    public static ConstraintWidget$DimensionBehaviour[] values() {
        return (ConstraintWidget$DimensionBehaviour[]) f12556a.clone();
    }
}
