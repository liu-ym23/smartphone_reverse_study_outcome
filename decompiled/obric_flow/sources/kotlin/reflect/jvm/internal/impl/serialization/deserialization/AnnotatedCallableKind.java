package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: loaded from: classes3.dex */
public final enum AnnotatedCallableKind extends Enum<AnnotatedCallableKind> {
    private static final /* synthetic */ AnnotatedCallableKind[] $VALUES = null;
    public static final AnnotatedCallableKind FUNCTION = null;
    public static final AnnotatedCallableKind PROPERTY = null;
    public static final AnnotatedCallableKind PROPERTY_GETTER = null;
    public static final AnnotatedCallableKind PROPERTY_SETTER = null;

    static {
        AnnotatedCallableKind r5 = new AnnotatedCallableKind("FUNCTION", 0);
        FUNCTION = r5;
        AnnotatedCallableKind r10 = new AnnotatedCallableKind("PROPERTY", 1);
        PROPERTY = r10;
        AnnotatedCallableKind r11 = new AnnotatedCallableKind("PROPERTY_GETTER", 2);
        PROPERTY_GETTER = r11;
        AnnotatedCallableKind r12 = new AnnotatedCallableKind("PROPERTY_SETTER", 3);
        PROPERTY_SETTER = r12;
        $VALUES = new AnnotatedCallableKind[]{r5, r10, r11, r12};
    }

    private AnnotatedCallableKind(String r5, int r10) {
        super(r5, r10);
    }

    public static AnnotatedCallableKind valueOf(String r5) {
        return (AnnotatedCallableKind) Enum.valueOf(AnnotatedCallableKind.class, r5);
    }

    public static AnnotatedCallableKind[] values() {
        return (AnnotatedCallableKind[]) $VALUES.clone();
    }
}
