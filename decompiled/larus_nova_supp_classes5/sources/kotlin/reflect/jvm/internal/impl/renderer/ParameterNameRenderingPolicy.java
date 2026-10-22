package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum ParameterNameRenderingPolicy extends Enum<ParameterNameRenderingPolicy> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
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
        ParameterNameRenderingPolicy[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static ParameterNameRenderingPolicy[] values() {
        return (ParameterNameRenderingPolicy[]) $VALUES.clone();
    }

    public static ParameterNameRenderingPolicy valueOf(String r1) {
        return (ParameterNameRenderingPolicy) a.a(ParameterNameRenderingPolicy.class, r1);
    }

    private ParameterNameRenderingPolicy(String r1, int r2) {
        super(r1, r2);
    }
}
