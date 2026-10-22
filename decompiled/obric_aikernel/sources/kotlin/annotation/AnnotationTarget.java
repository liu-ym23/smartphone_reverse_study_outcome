package kotlin.annotation;

import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
public final enum AnnotationTarget extends Enum<AnnotationTarget> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AnnotationTarget[] $VALUES = null;
    public static final AnnotationTarget ANNOTATION_CLASS = null;
    public static final AnnotationTarget CLASS = null;
    public static final AnnotationTarget CONSTRUCTOR = null;
    public static final AnnotationTarget EXPRESSION = null;
    public static final AnnotationTarget FIELD = null;
    public static final AnnotationTarget FILE = null;
    public static final AnnotationTarget FUNCTION = null;
    public static final AnnotationTarget LOCAL_VARIABLE = null;
    public static final AnnotationTarget PROPERTY = null;
    public static final AnnotationTarget PROPERTY_GETTER = null;
    public static final AnnotationTarget PROPERTY_SETTER = null;
    public static final AnnotationTarget TYPE = null;

    @SinceKotlin(version = "1.1")
    public static final AnnotationTarget TYPEALIAS = null;
    public static final AnnotationTarget TYPE_PARAMETER = null;
    public static final AnnotationTarget VALUE_PARAMETER = null;

    private static final /* synthetic */ AnnotationTarget[] $values() {
        return new AnnotationTarget[]{CLASS, ANNOTATION_CLASS, TYPE_PARAMETER, PROPERTY, FIELD, LOCAL_VARIABLE, VALUE_PARAMETER, CONSTRUCTOR, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER, TYPE, EXPRESSION, FILE, TYPEALIAS};
    }

    static {
        CLASS = new AnnotationTarget("CLASS", 0);
        ANNOTATION_CLASS = new AnnotationTarget("ANNOTATION_CLASS", 1);
        TYPE_PARAMETER = new AnnotationTarget("TYPE_PARAMETER", 2);
        PROPERTY = new AnnotationTarget("PROPERTY", 3);
        FIELD = new AnnotationTarget("FIELD", 4);
        LOCAL_VARIABLE = new AnnotationTarget("LOCAL_VARIABLE", 5);
        VALUE_PARAMETER = new AnnotationTarget("VALUE_PARAMETER", 6);
        CONSTRUCTOR = new AnnotationTarget("CONSTRUCTOR", 7);
        FUNCTION = new AnnotationTarget("FUNCTION", 8);
        PROPERTY_GETTER = new AnnotationTarget("PROPERTY_GETTER", 9);
        PROPERTY_SETTER = new AnnotationTarget("PROPERTY_SETTER", 10);
        TYPE = new AnnotationTarget("TYPE", 11);
        EXPRESSION = new AnnotationTarget("EXPRESSION", 12);
        FILE = new AnnotationTarget("FILE", 13);
        TYPEALIAS = new AnnotationTarget("TYPEALIAS", 14);
        AnnotationTarget[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = EnumEntriesKt.enumEntries(r10);
    }

    private AnnotationTarget(String r10, int r11) {
        super(r10, r11);
    }

    public static EnumEntries<AnnotationTarget> getEntries() {
        return $ENTRIES;
    }

    public static AnnotationTarget valueOf(String r10) {
        return (AnnotationTarget) Enum.valueOf(AnnotationTarget.class, r10);
    }

    public static AnnotationTarget[] values() {
        return (AnnotationTarget[]) $VALUES.clone();
    }
}
