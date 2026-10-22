package com.obric.oui.constraintlayout.core.motion;

/* JADX INFO: loaded from: classes3.dex */
public final enum CustomAttribute$AttributeType extends Enum<CustomAttribute$AttributeType> {
    public static final CustomAttribute$AttributeType BOOLEAN_TYPE = null;
    public static final CustomAttribute$AttributeType COLOR_DRAWABLE_TYPE = null;
    public static final CustomAttribute$AttributeType COLOR_TYPE = null;
    public static final CustomAttribute$AttributeType DIMENSION_TYPE = null;
    public static final CustomAttribute$AttributeType FLOAT_TYPE = null;
    public static final CustomAttribute$AttributeType INT_TYPE = null;
    public static final CustomAttribute$AttributeType REFERENCE_TYPE = null;
    public static final CustomAttribute$AttributeType STRING_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CustomAttribute$AttributeType[] f12545a = null;

    static {
        CustomAttribute$AttributeType r5 = new CustomAttribute$AttributeType("INT_TYPE", 0);
        INT_TYPE = r5;
        CustomAttribute$AttributeType r10 = new CustomAttribute$AttributeType("FLOAT_TYPE", 1);
        FLOAT_TYPE = r10;
        CustomAttribute$AttributeType r11 = new CustomAttribute$AttributeType("COLOR_TYPE", 2);
        COLOR_TYPE = r11;
        CustomAttribute$AttributeType r12 = new CustomAttribute$AttributeType("COLOR_DRAWABLE_TYPE", 3);
        COLOR_DRAWABLE_TYPE = r12;
        CustomAttribute$AttributeType r13 = new CustomAttribute$AttributeType("STRING_TYPE", 4);
        STRING_TYPE = r13;
        CustomAttribute$AttributeType r14 = new CustomAttribute$AttributeType("BOOLEAN_TYPE", 5);
        BOOLEAN_TYPE = r14;
        CustomAttribute$AttributeType r15 = new CustomAttribute$AttributeType("DIMENSION_TYPE", 6);
        DIMENSION_TYPE = r15;
        CustomAttribute$AttributeType r16 = new CustomAttribute$AttributeType("REFERENCE_TYPE", 7);
        REFERENCE_TYPE = r16;
        f12545a = new CustomAttribute$AttributeType[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    public static CustomAttribute$AttributeType valueOf(String r5) {
        return (CustomAttribute$AttributeType) Enum.valueOf(CustomAttribute$AttributeType.class, r5);
    }

    public static CustomAttribute$AttributeType[] values() {
        return (CustomAttribute$AttributeType[]) f12545a.clone();
    }
}
