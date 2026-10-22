package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum PropertyAccessorRenderingPolicy extends Enum<PropertyAccessorRenderingPolicy> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
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
        PropertyAccessorRenderingPolicy[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static PropertyAccessorRenderingPolicy[] values() {
        return (PropertyAccessorRenderingPolicy[]) $VALUES.clone();
    }

    public static PropertyAccessorRenderingPolicy valueOf(String r1) {
        return (PropertyAccessorRenderingPolicy) a.a(PropertyAccessorRenderingPolicy.class, r1);
    }

    private PropertyAccessorRenderingPolicy(String r1, int r2) {
        super(r1, r2);
    }
}
