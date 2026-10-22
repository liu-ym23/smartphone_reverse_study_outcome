package org.checkerframework.framework.qual;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum TypeUseLocation extends Enum<TypeUseLocation> {
    private static final /* synthetic */ TypeUseLocation[] $VALUES = null;
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

    private static /* synthetic */ TypeUseLocation[] $values() {
        return new TypeUseLocation[]{FIELD, LOCAL_VARIABLE, RESOURCE_VARIABLE, EXCEPTION_PARAMETER, RECEIVER, PARAMETER, RETURN, CONSTRUCTOR_RESULT, LOWER_BOUND, EXPLICIT_LOWER_BOUND, IMPLICIT_LOWER_BOUND, UPPER_BOUND, EXPLICIT_UPPER_BOUND, IMPLICIT_UPPER_BOUND, OTHERWISE, ALL};
    }

    static {
        FIELD = new TypeUseLocation("FIELD", 0);
        LOCAL_VARIABLE = new TypeUseLocation("LOCAL_VARIABLE", 1);
        RESOURCE_VARIABLE = new TypeUseLocation("RESOURCE_VARIABLE", 2);
        EXCEPTION_PARAMETER = new TypeUseLocation("EXCEPTION_PARAMETER", 3);
        RECEIVER = new TypeUseLocation("RECEIVER", 4);
        PARAMETER = new TypeUseLocation("PARAMETER", 5);
        RETURN = new TypeUseLocation("RETURN", 6);
        CONSTRUCTOR_RESULT = new TypeUseLocation("CONSTRUCTOR_RESULT", 7);
        LOWER_BOUND = new TypeUseLocation("LOWER_BOUND", 8);
        EXPLICIT_LOWER_BOUND = new TypeUseLocation("EXPLICIT_LOWER_BOUND", 9);
        IMPLICIT_LOWER_BOUND = new TypeUseLocation("IMPLICIT_LOWER_BOUND", 10);
        UPPER_BOUND = new TypeUseLocation("UPPER_BOUND", 11);
        EXPLICIT_UPPER_BOUND = new TypeUseLocation("EXPLICIT_UPPER_BOUND", 12);
        IMPLICIT_UPPER_BOUND = new TypeUseLocation("IMPLICIT_UPPER_BOUND", 13);
        OTHERWISE = new TypeUseLocation("OTHERWISE", 14);
        ALL = new TypeUseLocation("ALL", 15);
        $VALUES = $values();
    }

    private TypeUseLocation(String r1, int r2) {
        super(r1, r2);
    }

    public static TypeUseLocation valueOf(String r2) {
        return (TypeUseLocation) ZeusTransformUtils.preCheckCast(Enum.valueOf(TypeUseLocation.class, r2), TypeUseLocation.class, "com.obric.memorydata.plugin");
    }

    public static TypeUseLocation[] values() {
        return (TypeUseLocation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TypeUseLocation[].class, "com.obric.memorydata.plugin");
    }
}
