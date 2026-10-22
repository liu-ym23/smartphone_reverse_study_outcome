package kotlin.reflect.jvm.internal.impl.types;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum Variance extends Enum<Variance> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Variance[] $VALUES = null;
    public static final Variance INVARIANT = null;
    public static final Variance IN_VARIANCE = null;
    public static final Variance OUT_VARIANCE = null;
    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    private final String label;
    private final int superpositionFactor;

    private static final /* synthetic */ Variance[] $values() {
        return new Variance[]{INVARIANT, IN_VARIANCE, OUT_VARIANCE};
    }

    static {
        INVARIANT = new Variance("INVARIANT", 0, "", true, true, 0);
        IN_VARIANCE = new Variance("IN_VARIANCE", 1, "in", true, false, -1);
        OUT_VARIANCE = new Variance("OUT_VARIANCE", 2, "out", false, true, 1);
        Variance[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static Variance[] values() {
        return (Variance[]) $VALUES.clone();
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    public final String getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.label;
    }

    public static Variance valueOf(String r1) {
        return (Variance) a.a(Variance.class, r1);
    }

    private Variance(String r1, int r2, String r3, boolean r4, boolean r5, int r6) {
        super(r1, r2);
        this.label = r3;
        this.allowsInPosition = r4;
        this.allowsOutPosition = r5;
        this.superpositionFactor = r6;
    }
}
