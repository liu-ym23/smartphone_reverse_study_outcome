package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: loaded from: classes3.dex */
public final enum TypeComponentPosition extends Enum<TypeComponentPosition> {
    private static final /* synthetic */ TypeComponentPosition[] $VALUES = null;
    public static final TypeComponentPosition FLEXIBLE_LOWER = null;
    public static final TypeComponentPosition FLEXIBLE_UPPER = null;
    public static final TypeComponentPosition INFLEXIBLE = null;

    private static final /* synthetic */ TypeComponentPosition[] $values() {
        return new TypeComponentPosition[]{FLEXIBLE_LOWER, FLEXIBLE_UPPER, INFLEXIBLE};
    }

    static {
        FLEXIBLE_LOWER = new TypeComponentPosition("FLEXIBLE_LOWER", 0);
        FLEXIBLE_UPPER = new TypeComponentPosition("FLEXIBLE_UPPER", 1);
        INFLEXIBLE = new TypeComponentPosition("INFLEXIBLE", 2);
        $VALUES = $values();
    }

    private TypeComponentPosition(String r10, int r11) {
        super(r10, r11);
    }

    public static TypeComponentPosition valueOf(String r10) {
        return (TypeComponentPosition) Enum.valueOf(TypeComponentPosition.class, r10);
    }

    public static TypeComponentPosition[] values() {
        return (TypeComponentPosition[]) $VALUES.clone();
    }
}
