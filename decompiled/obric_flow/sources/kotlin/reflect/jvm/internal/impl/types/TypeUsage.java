package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: classes3.dex */
public final enum TypeUsage extends Enum<TypeUsage> {
    private static final /* synthetic */ TypeUsage[] $VALUES = null;
    public static final TypeUsage COMMON = null;
    public static final TypeUsage SUPERTYPE = null;

    private static final /* synthetic */ TypeUsage[] $values() {
        return new TypeUsage[]{SUPERTYPE, COMMON};
    }

    static {
        SUPERTYPE = new TypeUsage("SUPERTYPE", 0);
        COMMON = new TypeUsage("COMMON", 1);
        $VALUES = $values();
    }

    private TypeUsage(String r5, int r10) {
        super(r5, r10);
    }

    public static TypeUsage valueOf(String r5) {
        return (TypeUsage) Enum.valueOf(TypeUsage.class, r5);
    }

    public static TypeUsage[] values() {
        return (TypeUsage[]) $VALUES.clone();
    }
}
