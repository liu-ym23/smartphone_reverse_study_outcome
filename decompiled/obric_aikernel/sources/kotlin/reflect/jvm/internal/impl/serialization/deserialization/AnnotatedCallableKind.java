package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: loaded from: classes3.dex */
public final enum AnnotatedCallableKind extends Enum<AnnotatedCallableKind> {
    private static final /* synthetic */ AnnotatedCallableKind[] $VALUES = null;
    public static final AnnotatedCallableKind FUNCTION = null;
    public static final AnnotatedCallableKind PROPERTY = null;
    public static final AnnotatedCallableKind PROPERTY_GETTER = null;
    public static final AnnotatedCallableKind PROPERTY_SETTER = null;

    static {
        AnnotatedCallableKind r10 = new AnnotatedCallableKind("FUNCTION", 0);
        FUNCTION = r10;
        AnnotatedCallableKind r11 = new AnnotatedCallableKind("PROPERTY", 1);
        PROPERTY = r11;
        AnnotatedCallableKind r12 = new AnnotatedCallableKind("PROPERTY_GETTER", 2);
        PROPERTY_GETTER = r12;
        AnnotatedCallableKind r13 = new AnnotatedCallableKind("PROPERTY_SETTER", 3);
        PROPERTY_SETTER = r13;
        $VALUES = new AnnotatedCallableKind[]{r10, r11, r12, r13};
    }

    private AnnotatedCallableKind(String r10, int r11) {
        super(r10, r11);
    }

    public static AnnotatedCallableKind valueOf(String r10) {
        return (AnnotatedCallableKind) Enum.valueOf(AnnotatedCallableKind.class, r10);
    }

    public static AnnotatedCallableKind[] values() {
        return (AnnotatedCallableKind[]) $VALUES.clone();
    }
}
