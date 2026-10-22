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

    private TypeVariance(String r10, int r11, String r12) {
        super(r10, r11);
        this.presentation = r12;
    }

    public static TypeVariance valueOf(String r10) {
        return (TypeVariance) Enum.valueOf(TypeVariance.class, r10);
    }

    public static TypeVariance[] values() {
        return (TypeVariance[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.presentation;
    }
}
