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
        FIELD = new AnnotationUseSiteTarget("FIELD", 0, null, 1, null);
        FILE = new AnnotationUseSiteTarget("FILE", 1, null, 1, null);
        PROPERTY = new AnnotationUseSiteTarget("PROPERTY", 2, null, 1, null);
        PROPERTY_GETTER = new AnnotationUseSiteTarget("PROPERTY_GETTER", 3, "get");
        PROPERTY_SETTER = new AnnotationUseSiteTarget("PROPERTY_SETTER", 4, "set");
        RECEIVER = new AnnotationUseSiteTarget("RECEIVER", 5, null, 1, null);
        CONSTRUCTOR_PARAMETER = new AnnotationUseSiteTarget("CONSTRUCTOR_PARAMETER", 6, "param");
        SETTER_PARAMETER = new AnnotationUseSiteTarget("SETTER_PARAMETER", 7, "setparam");
        PROPERTY_DELEGATE_FIELD = new AnnotationUseSiteTarget("PROPERTY_DELEGATE_FIELD", 8, "delegate");
        $VALUES = $values();
    }

    private AnnotationUseSiteTarget(String r10, int r11, String r12) {
        super(r10, r11);
        if (r12 != null) goto L5;
        r12 = CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(name());
    L5:
        this.renderName = r12;
    }

    /* synthetic */ AnnotationUseSiteTarget(String r10, int r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        r12 = null;
    L5:
        this(r10, r11, r12);
    }

    public static AnnotationUseSiteTarget valueOf(String r10) {
        return (AnnotationUseSiteTarget) Enum.valueOf(AnnotationUseSiteTarget.class, r10);
    }

    public static AnnotationUseSiteTarget[] values() {
        return (AnnotationUseSiteTarget[]) $VALUES.clone();
    }

    public final String getRenderName() {
        return this.renderName;
    }
}
