package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KmVariance extends Enum<KmVariance> {
    private static final /* synthetic */ KmVariance[] $VALUES = null;
    public static final KmVariance IN = null;
    public static final KmVariance INVARIANT = null;
    public static final KmVariance OUT = null;

    private static final /* synthetic */ KmVariance[] $values() {
        return new KmVariance[]{INVARIANT, IN, OUT};
    }

    static {
        INVARIANT = new KmVariance("INVARIANT", 0);
        IN = new KmVariance("IN", 1);
        OUT = new KmVariance("OUT", 2);
        $VALUES = $values();
    }

    private KmVariance(String r5, int r10) {
        super(r5, r10);
    }

    public static KmVariance valueOf(String r5) {
        return (KmVariance) Enum.valueOf(KmVariance.class, r5);
    }

    public static KmVariance[] values() {
        return (KmVariance[]) $VALUES.clone();
    }
}
