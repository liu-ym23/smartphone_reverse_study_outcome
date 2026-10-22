package org.checkerframework.framework.qual;

/* JADX INFO: loaded from: classes3.dex */
public final enum TypeUseLocation extends Enum<TypeUseLocation> {
    public static final TypeUseLocation ALL = null;
    public static final TypeUseLocation CONSTRUCTOR_RESULT = null;
    public static final TypeUseLocation EXCEPTION_PARAMETER = null;
    public static final TypeUseLocation EXPLICIT_LOWER_BOUND = null;
    public static final TypeUseLocation EXPLICIT_UPPER_BOUND = null;
    public static final TypeUseLocation FIELD = null;
    public static final TypeUseLocation IMPLICIT_LOWER_BOUND = null;
    public static final TypeUseLocation IMPLICIT_UPPER_BOUND = null;
    public static final TypeUseLocation LOCAL_VARIABLE = null;
    public static final TypeUseLocation LOWER_BOUND = null;
    public static final TypeUseLocation OTHERWISE = null;
    public static final TypeUseLocation PARAMETER = null;
    public static final TypeUseLocation RECEIVER = null;
    public static final TypeUseLocation RESOURCE_VARIABLE = null;
    public static final TypeUseLocation RETURN = null;
    public static final TypeUseLocation UPPER_BOUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TypeUseLocation[] f20988a = null;

    static {
        TypeUseLocation r5 = new TypeUseLocation("FIELD", 0);
        FIELD = r5;
        TypeUseLocation r10 = new TypeUseLocation("LOCAL_VARIABLE", 1);
        LOCAL_VARIABLE = r10;
        TypeUseLocation r11 = new TypeUseLocation("RESOURCE_VARIABLE", 2);
        RESOURCE_VARIABLE = r11;
        TypeUseLocation r12 = new TypeUseLocation("EXCEPTION_PARAMETER", 3);
        EXCEPTION_PARAMETER = r12;
        TypeUseLocation r13 = new TypeUseLocation("RECEIVER", 4);
        RECEIVER = r13;
        TypeUseLocation r14 = new TypeUseLocation("PARAMETER", 5);
        PARAMETER = r14;
        TypeUseLocation r15 = new TypeUseLocation("RETURN", 6);
        RETURN = r15;
        TypeUseLocation r16 = new TypeUseLocation("CONSTRUCTOR_RESULT", 7);
        CONSTRUCTOR_RESULT = r16;
        TypeUseLocation r17 = new TypeUseLocation("LOWER_BOUND", 8);
        LOWER_BOUND = r17;
        TypeUseLocation r18 = new TypeUseLocation("EXPLICIT_LOWER_BOUND", 9);
        EXPLICIT_LOWER_BOUND = r18;
        TypeUseLocation r19 = new TypeUseLocation("IMPLICIT_LOWER_BOUND", 10);
        IMPLICIT_LOWER_BOUND = r19;
        TypeUseLocation r110 = new TypeUseLocation("UPPER_BOUND", 11);
        UPPER_BOUND = r110;
        TypeUseLocation r111 = new TypeUseLocation("EXPLICIT_UPPER_BOUND", 12);
        EXPLICIT_UPPER_BOUND = r111;
        TypeUseLocation r112 = new TypeUseLocation("IMPLICIT_UPPER_BOUND", 13);
        IMPLICIT_UPPER_BOUND = r112;
        TypeUseLocation r113 = new TypeUseLocation("OTHERWISE", 14);
        OTHERWISE = r113;
        TypeUseLocation r114 = new TypeUseLocation("ALL", 15);
        ALL = r114;
        f20988a = new TypeUseLocation[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114};
    }

    public static TypeUseLocation valueOf(String r5) {
        return (TypeUseLocation) Enum.valueOf(TypeUseLocation.class, r5);
    }

    public static TypeUseLocation[] values() {
        return (TypeUseLocation[]) f20988a.clone();
    }
}
