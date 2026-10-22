package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: loaded from: classes3.dex */
public final enum AnnotationQualifierApplicabilityType extends Enum<AnnotationQualifierApplicabilityType> {
    private static final /* synthetic */ AnnotationQualifierApplicabilityType[] $VALUES = null;
    public static final AnnotationQualifierApplicabilityType FIELD = null;
    public static final AnnotationQualifierApplicabilityType METHOD_RETURN_TYPE = null;
    public static final AnnotationQualifierApplicabilityType TYPE_PARAMETER = null;
    public static final AnnotationQualifierApplicabilityType TYPE_PARAMETER_BOUNDS = null;
    public static final AnnotationQualifierApplicabilityType TYPE_USE = null;
    public static final AnnotationQualifierApplicabilityType VALUE_PARAMETER = null;
    private final String javaTarget;

    private static final /* synthetic */ AnnotationQualifierApplicabilityType[] $values() {
        return new AnnotationQualifierApplicabilityType[]{METHOD_RETURN_TYPE, VALUE_PARAMETER, FIELD, TYPE_USE, TYPE_PARAMETER_BOUNDS, TYPE_PARAMETER};
    }

    static {
        METHOD_RETURN_TYPE = new AnnotationQualifierApplicabilityType("METHOD_RETURN_TYPE", 0, "METHOD");
        VALUE_PARAMETER = new AnnotationQualifierApplicabilityType("VALUE_PARAMETER", 1, "PARAMETER");
        FIELD = new AnnotationQualifierApplicabilityType("FIELD", 2, "FIELD");
        TYPE_USE = new AnnotationQualifierApplicabilityType("TYPE_USE", 3, "TYPE_USE");
        TYPE_PARAMETER_BOUNDS = new AnnotationQualifierApplicabilityType("TYPE_PARAMETER_BOUNDS", 4, "TYPE_USE");
        TYPE_PARAMETER = new AnnotationQualifierApplicabilityType("TYPE_PARAMETER", 5, "TYPE_PARAMETER");
        $VALUES = $values();
    }

    private AnnotationQualifierApplicabilityType(String r5, int r10, String r11) {
        super(r5, r10);
        this.javaTarget = r11;
    }

    public static AnnotationQualifierApplicabilityType valueOf(String r5) {
        return (AnnotationQualifierApplicabilityType) Enum.valueOf(AnnotationQualifierApplicabilityType.class, r5);
    }

    public static AnnotationQualifierApplicabilityType[] values() {
        return (AnnotationQualifierApplicabilityType[]) $VALUES.clone();
    }

    public final String getJavaTarget() {
        return this.javaTarget;
    }
}
