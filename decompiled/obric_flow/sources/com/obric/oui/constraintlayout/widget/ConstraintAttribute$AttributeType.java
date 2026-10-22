package com.obric.oui.constraintlayout.widget;

/* JADX INFO: loaded from: classes3.dex */
public final enum ConstraintAttribute$AttributeType extends Enum<ConstraintAttribute$AttributeType> {
    public static final ConstraintAttribute$AttributeType BOOLEAN_TYPE = null;
    public static final ConstraintAttribute$AttributeType COLOR_DRAWABLE_TYPE = null;
    public static final ConstraintAttribute$AttributeType COLOR_TYPE = null;
    public static final ConstraintAttribute$AttributeType DIMENSION_TYPE = null;
    public static final ConstraintAttribute$AttributeType FLOAT_TYPE = null;
    public static final ConstraintAttribute$AttributeType INT_TYPE = null;
    public static final ConstraintAttribute$AttributeType REFERENCE_TYPE = null;
    public static final ConstraintAttribute$AttributeType STRING_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConstraintAttribute$AttributeType[] f12983a = null;

    static {
        ConstraintAttribute$AttributeType r5 = new ConstraintAttribute$AttributeType("INT_TYPE", 0);
        INT_TYPE = r5;
        ConstraintAttribute$AttributeType r10 = new ConstraintAttribute$AttributeType("FLOAT_TYPE", 1);
        FLOAT_TYPE = r10;
        ConstraintAttribute$AttributeType r11 = new ConstraintAttribute$AttributeType("COLOR_TYPE", 2);
        COLOR_TYPE = r11;
        ConstraintAttribute$AttributeType r12 = new ConstraintAttribute$AttributeType("COLOR_DRAWABLE_TYPE", 3);
        COLOR_DRAWABLE_TYPE = r12;
        ConstraintAttribute$AttributeType r13 = new ConstraintAttribute$AttributeType("STRING_TYPE", 4);
        STRING_TYPE = r13;
        ConstraintAttribute$AttributeType r14 = new ConstraintAttribute$AttributeType("BOOLEAN_TYPE", 5);
        BOOLEAN_TYPE = r14;
        ConstraintAttribute$AttributeType r15 = new ConstraintAttribute$AttributeType("DIMENSION_TYPE", 6);
        DIMENSION_TYPE = r15;
        ConstraintAttribute$AttributeType r16 = new ConstraintAttribute$AttributeType("REFERENCE_TYPE", 7);
        REFERENCE_TYPE = r16;
        f12983a = new ConstraintAttribute$AttributeType[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    public static ConstraintAttribute$AttributeType valueOf(String r5) {
        return (ConstraintAttribute$AttributeType) Enum.valueOf(ConstraintAttribute$AttributeType.class, r5);
    }

    public static ConstraintAttribute$AttributeType[] values() {
        return (ConstraintAttribute$AttributeType[]) f12983a.clone();
    }
}
