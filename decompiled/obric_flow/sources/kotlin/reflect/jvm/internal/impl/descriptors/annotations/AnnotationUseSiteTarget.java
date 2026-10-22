package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;

/* JADX INFO: loaded from: classes3.dex */
public final enum AnnotationUseSiteTarget extends Enum<AnnotationUseSiteTarget> {
    private static final /* synthetic */ AnnotationUseSiteTarget[] $VALUES = null;
    public static final AnnotationUseSiteTarget CONSTRUCTOR_PARAMETER = null;
    public static final AnnotationUseSiteTarget FIELD = null;
    public static final AnnotationUseSiteTarget FILE = null;
    public static final AnnotationUseSiteTarget PROPERTY = null;
    public static final AnnotationUseSiteTarget PROPERTY_DELEGATE_FIELD = null;
    public static final AnnotationUseSiteTarget PROPERTY_GETTER = null;
    public static final AnnotationUseSiteTarget PROPERTY_SETTER = null;
    public static final AnnotationUseSiteTarget RECEIVER = null;
    public static final AnnotationUseSiteTarget SETTER_PARAMETER = null;
    private final String renderName;

    private static final /* synthetic */ AnnotationUseSiteTarget[] $values() {
        return new AnnotationUseSiteTarget[]{FIELD, FILE, PROPERTY, PROPERTY_GETTER, PROPERTY_SETTER, RECEIVER, CONSTRUCTOR_PARAMETER, SETTER_PARAMETER, PROPERTY_DELEGATE_FIELD};
    }

    static {
        String r5 = "FIELD";
        int r10 = 0;
        String r11 = null;
        FIELD = new AnnotationUseSiteTarget(r5, r10, r11, 1, null);
        String r12 = "FILE";
        int r13 = 1;
        String r14 = null;
        FILE = new AnnotationUseSiteTarget(r12, r13, r14, 1, null);
        String r15 = "PROPERTY";
        int r16 = 2;
        String r17 = null;
        PROPERTY = new AnnotationUseSiteTarget(r15, r16, r17, 1, null);
        PROPERTY_GETTER = new AnnotationUseSiteTarget("PROPERTY_GETTER", 3, "get");
        PROPERTY_SETTER = new AnnotationUseSiteTarget("PROPERTY_SETTER", 4, "set");
        String r18 = "RECEIVER";
        int r19 = 5;
        String r20 = null;
        RECEIVER = new AnnotationUseSiteTarget(r18, r19, r20, 1, null);
        CONSTRUCTOR_PARAMETER = new AnnotationUseSiteTarget("CONSTRUCTOR_PARAMETER", 6, "param");
        SETTER_PARAMETER = new AnnotationUseSiteTarget("SETTER_PARAMETER", 7, "setparam");
        PROPERTY_DELEGATE_FIELD = new AnnotationUseSiteTarget("PROPERTY_DELEGATE_FIELD", 8, "delegate");
        $VALUES = $values();
    }

    private AnnotationUseSiteTarget(String r5, int r10, String r11) {
        super(r5, r10);
        if (r11 != null) goto L5;
        r11 = CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(name());
    L5:
        this.renderName = r11;
    }

    public static AnnotationUseSiteTarget valueOf(String r5) {
        return (AnnotationUseSiteTarget) Enum.valueOf(AnnotationUseSiteTarget.class, r5);
    }

    public static AnnotationUseSiteTarget[] values() {
        return (AnnotationUseSiteTarget[]) $VALUES.clone();
    }

    public final String getRenderName() {
        return this.renderName;
    }

    public /* synthetic */ AnnotationUseSiteTarget(String r5, int r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = null;
    L5:
        this(r5, r10, r11);
    }
}
