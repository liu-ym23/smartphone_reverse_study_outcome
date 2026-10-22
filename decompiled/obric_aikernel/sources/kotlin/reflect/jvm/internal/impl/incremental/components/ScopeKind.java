package kotlin.reflect.jvm.internal.impl.incremental.components;

/* JADX INFO: loaded from: classes3.dex */
public final enum ScopeKind extends Enum<ScopeKind> {
    private static final /* synthetic */ ScopeKind[] $VALUES = null;
    public static final ScopeKind CLASSIFIER = null;
    public static final ScopeKind PACKAGE = null;

    private static final /* synthetic */ ScopeKind[] $values() {
        return new ScopeKind[]{PACKAGE, CLASSIFIER};
    }

    static {
        PACKAGE = new ScopeKind("PACKAGE", 0);
        CLASSIFIER = new ScopeKind("CLASSIFIER", 1);
        $VALUES = $values();
    }

    private ScopeKind(String r10, int r11) {
        super(r10, r11);
    }

    public static ScopeKind valueOf(String r10) {
        return (ScopeKind) Enum.valueOf(ScopeKind.class, r10);
    }

    public static ScopeKind[] values() {
        return (ScopeKind[]) $VALUES.clone();
    }
}
