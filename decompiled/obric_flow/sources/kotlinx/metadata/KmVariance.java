package kotlinx.metadata;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/metadata/KmVariance;", "", "INVARIANT", "IN", "OUT", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KmVariance extends Enum<KmVariance> {
    public static final KmVariance IN = null;
    public static final KmVariance INVARIANT = null;
    public static final KmVariance OUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmVariance[] f19035a = null;

    static {
        KmVariance r5 = new KmVariance("INVARIANT", 0);
        INVARIANT = r5;
        KmVariance r10 = new KmVariance("IN", 1);
        IN = r10;
        KmVariance r11 = new KmVariance("OUT", 2);
        OUT = r11;
        f19035a = new KmVariance[]{r5, r10, r11};
    }

    public static KmVariance valueOf(String r5) {
        return (KmVariance) Enum.valueOf(KmVariance.class, r5);
    }

    public static KmVariance[] values() {
        return (KmVariance[]) f19035a.clone();
    }
}
