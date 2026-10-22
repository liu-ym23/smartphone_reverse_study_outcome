package kotlin.reflect.jvm.internal.impl.resolve;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum OverridingUtil$OverrideCompatibilityInfo$Result extends Enum<OverridingUtil$OverrideCompatibilityInfo$Result> {
    private static final /* synthetic */ OverridingUtil$OverrideCompatibilityInfo$Result[] $VALUES = null;
    public static final OverridingUtil$OverrideCompatibilityInfo$Result CONFLICT = null;
    public static final OverridingUtil$OverrideCompatibilityInfo$Result INCOMPATIBLE = null;
    public static final OverridingUtil$OverrideCompatibilityInfo$Result OVERRIDABLE = null;

    static {
        OverridingUtil$OverrideCompatibilityInfo$Result r0 = new OverridingUtil$OverrideCompatibilityInfo$Result("OVERRIDABLE", 0);
        OVERRIDABLE = r0;
        OverridingUtil$OverrideCompatibilityInfo$Result r1 = new OverridingUtil$OverrideCompatibilityInfo$Result("INCOMPATIBLE", 1);
        INCOMPATIBLE = r1;
        OverridingUtil$OverrideCompatibilityInfo$Result r3 = new OverridingUtil$OverrideCompatibilityInfo$Result("CONFLICT", 2);
        CONFLICT = r3;
        $VALUES = new OverridingUtil$OverrideCompatibilityInfo$Result[]{r0, r1, r3};
    }

    public static OverridingUtil$OverrideCompatibilityInfo$Result[] values() {
        return (OverridingUtil$OverrideCompatibilityInfo$Result[]) $VALUES.clone();
    }

    public static OverridingUtil$OverrideCompatibilityInfo$Result valueOf(String r1) {
        return (OverridingUtil$OverrideCompatibilityInfo$Result) a.a(OverridingUtil$OverrideCompatibilityInfo$Result.class, r1);
    }

    private OverridingUtil$OverrideCompatibilityInfo$Result(String r1, int r2) {
        super(r1, r2);
    }
}
