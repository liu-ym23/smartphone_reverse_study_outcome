package kotlin.reflect.jvm.internal.impl.load.java.structure;

/* JADX INFO: loaded from: classes3.dex */
public final enum LightClassOriginKind extends Enum<LightClassOriginKind> {
    private static final /* synthetic */ LightClassOriginKind[] $VALUES = null;
    public static final LightClassOriginKind BINARY = null;
    public static final LightClassOriginKind SOURCE = null;

    private static final /* synthetic */ LightClassOriginKind[] $values() {
        return new LightClassOriginKind[]{SOURCE, BINARY};
    }

    static {
        SOURCE = new LightClassOriginKind("SOURCE", 0);
        BINARY = new LightClassOriginKind("BINARY", 1);
        $VALUES = $values();
    }

    private LightClassOriginKind(String r10, int r11) {
        super(r10, r11);
    }

    public static LightClassOriginKind valueOf(String r10) {
        return (LightClassOriginKind) Enum.valueOf(LightClassOriginKind.class, r10);
    }

    public static LightClassOriginKind[] values() {
        return (LightClassOriginKind[]) $VALUES.clone();
    }
}
