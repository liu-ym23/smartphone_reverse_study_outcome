package kotlin.reflect.jvm.internal.impl.types.model;

/* JADX INFO: loaded from: classes3.dex */
public final enum TypeVariance extends Enum<TypeVariance> {
    private static final /* synthetic */ TypeVariance[] $VALUES = null;
    public static final TypeVariance IN = null;
    public static final TypeVariance INV = null;
    public static final TypeVariance OUT = null;
    private final String presentation;

    private static final /* synthetic */ TypeVariance[] $values() {
        return new TypeVariance[]{IN, OUT, INV};
    }

    static {
        IN = new TypeVariance("IN", 0, "in");
        OUT = new TypeVariance("OUT", 1, "out");
        INV = new TypeVariance("INV", 2, "");
        $VALUES = $values();
    }

    private TypeVariance(String r5, int r10, String r11) {
        super(r5, r10);
        this.presentation = r11;
    }

    public static TypeVariance valueOf(String r5) {
        return (TypeVariance) Enum.valueOf(TypeVariance.class, r5);
    }

    public static TypeVariance[] values() {
        return (TypeVariance[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.presentation;
    }
}
