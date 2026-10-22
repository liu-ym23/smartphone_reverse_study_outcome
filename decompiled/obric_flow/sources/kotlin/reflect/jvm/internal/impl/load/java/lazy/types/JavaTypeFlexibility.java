package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

/* JADX INFO: loaded from: classes3.dex */
public final enum JavaTypeFlexibility extends Enum<JavaTypeFlexibility> {
    private static final /* synthetic */ JavaTypeFlexibility[] $VALUES = null;
    public static final JavaTypeFlexibility FLEXIBLE_LOWER_BOUND = null;
    public static final JavaTypeFlexibility FLEXIBLE_UPPER_BOUND = null;
    public static final JavaTypeFlexibility INFLEXIBLE = null;

    private static final /* synthetic */ JavaTypeFlexibility[] $values() {
        return new JavaTypeFlexibility[]{INFLEXIBLE, FLEXIBLE_UPPER_BOUND, FLEXIBLE_LOWER_BOUND};
    }

    static {
        INFLEXIBLE = new JavaTypeFlexibility("INFLEXIBLE", 0);
        FLEXIBLE_UPPER_BOUND = new JavaTypeFlexibility("FLEXIBLE_UPPER_BOUND", 1);
        FLEXIBLE_LOWER_BOUND = new JavaTypeFlexibility("FLEXIBLE_LOWER_BOUND", 2);
        $VALUES = $values();
    }

    private JavaTypeFlexibility(String r5, int r10) {
        super(r5, r10);
    }

    public static JavaTypeFlexibility valueOf(String r5) {
        return (JavaTypeFlexibility) Enum.valueOf(JavaTypeFlexibility.class, r5);
    }

    public static JavaTypeFlexibility[] values() {
        return (JavaTypeFlexibility[]) $VALUES.clone();
    }
}
