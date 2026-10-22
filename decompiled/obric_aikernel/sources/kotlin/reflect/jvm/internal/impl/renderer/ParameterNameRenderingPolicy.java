package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX INFO: loaded from: classes3.dex */
public final enum ParameterNameRenderingPolicy extends Enum<ParameterNameRenderingPolicy> {
    private static final /* synthetic */ ParameterNameRenderingPolicy[] $VALUES = null;
    public static final ParameterNameRenderingPolicy ALL = null;
    public static final ParameterNameRenderingPolicy NONE = null;
    public static final ParameterNameRenderingPolicy ONLY_NON_SYNTHESIZED = null;

    private static final /* synthetic */ ParameterNameRenderingPolicy[] $values() {
        return new ParameterNameRenderingPolicy[]{ALL, ONLY_NON_SYNTHESIZED, NONE};
    }

    static {
        ALL = new ParameterNameRenderingPolicy("ALL", 0);
        ONLY_NON_SYNTHESIZED = new ParameterNameRenderingPolicy("ONLY_NON_SYNTHESIZED", 1);
        NONE = new ParameterNameRenderingPolicy("NONE", 2);
        $VALUES = $values();
    }

    private ParameterNameRenderingPolicy(String r10, int r11) {
        super(r10, r11);
    }

    public static ParameterNameRenderingPolicy valueOf(String r10) {
        return (ParameterNameRenderingPolicy) Enum.valueOf(ParameterNameRenderingPolicy.class, r10);
    }

    public static ParameterNameRenderingPolicy[] values() {
        return (ParameterNameRenderingPolicy[]) $VALUES.clone();
    }
}
