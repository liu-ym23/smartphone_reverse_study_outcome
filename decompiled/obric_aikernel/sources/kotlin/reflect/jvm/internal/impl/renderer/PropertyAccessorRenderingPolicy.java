package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX INFO: loaded from: classes3.dex */
public final enum PropertyAccessorRenderingPolicy extends Enum<PropertyAccessorRenderingPolicy> {
    private static final /* synthetic */ PropertyAccessorRenderingPolicy[] $VALUES = null;
    public static final PropertyAccessorRenderingPolicy DEBUG = null;
    public static final PropertyAccessorRenderingPolicy NONE = null;
    public static final PropertyAccessorRenderingPolicy PRETTY = null;

    private static final /* synthetic */ PropertyAccessorRenderingPolicy[] $values() {
        return new PropertyAccessorRenderingPolicy[]{PRETTY, DEBUG, NONE};
    }

    static {
        PRETTY = new PropertyAccessorRenderingPolicy("PRETTY", 0);
        DEBUG = new PropertyAccessorRenderingPolicy("DEBUG", 1);
        NONE = new PropertyAccessorRenderingPolicy("NONE", 2);
        $VALUES = $values();
    }

    private PropertyAccessorRenderingPolicy(String r10, int r11) {
        super(r10, r11);
    }

    public static PropertyAccessorRenderingPolicy valueOf(String r10) {
        return (PropertyAccessorRenderingPolicy) Enum.valueOf(PropertyAccessorRenderingPolicy.class, r10);
    }

    public static PropertyAccessorRenderingPolicy[] values() {
        return (PropertyAccessorRenderingPolicy[]) $VALUES.clone();
    }
}
