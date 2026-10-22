package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX INFO: loaded from: classes3.dex */
public final enum OverrideRenderingPolicy extends Enum<OverrideRenderingPolicy> {
    private static final /* synthetic */ OverrideRenderingPolicy[] $VALUES = null;
    public static final OverrideRenderingPolicy RENDER_OPEN = null;
    public static final OverrideRenderingPolicy RENDER_OPEN_OVERRIDE = null;
    public static final OverrideRenderingPolicy RENDER_OVERRIDE = null;

    private static final /* synthetic */ OverrideRenderingPolicy[] $values() {
        return new OverrideRenderingPolicy[]{RENDER_OVERRIDE, RENDER_OPEN, RENDER_OPEN_OVERRIDE};
    }

    static {
        RENDER_OVERRIDE = new OverrideRenderingPolicy("RENDER_OVERRIDE", 0);
        RENDER_OPEN = new OverrideRenderingPolicy("RENDER_OPEN", 1);
        RENDER_OPEN_OVERRIDE = new OverrideRenderingPolicy("RENDER_OPEN_OVERRIDE", 2);
        $VALUES = $values();
    }

    private OverrideRenderingPolicy(String r10, int r11) {
        super(r10, r11);
    }

    public static OverrideRenderingPolicy valueOf(String r10) {
        return (OverrideRenderingPolicy) Enum.valueOf(OverrideRenderingPolicy.class, r10);
    }

    public static OverrideRenderingPolicy[] values() {
        return (OverrideRenderingPolicy[]) $VALUES.clone();
    }
}
