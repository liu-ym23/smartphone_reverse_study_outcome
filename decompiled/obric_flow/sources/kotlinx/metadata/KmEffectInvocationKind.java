package kotlinx.metadata;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/metadata/KmEffectInvocationKind;", "", "AT_MOST_ONCE", "EXACTLY_ONCE", "AT_LEAST_ONCE", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KmEffectInvocationKind extends Enum<KmEffectInvocationKind> {
    public static final KmEffectInvocationKind AT_LEAST_ONCE = null;
    public static final KmEffectInvocationKind AT_MOST_ONCE = null;
    public static final KmEffectInvocationKind EXACTLY_ONCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmEffectInvocationKind[] f19033a = null;

    static {
        KmEffectInvocationKind r5 = new KmEffectInvocationKind("AT_MOST_ONCE", 0);
        AT_MOST_ONCE = r5;
        KmEffectInvocationKind r10 = new KmEffectInvocationKind("EXACTLY_ONCE", 1);
        EXACTLY_ONCE = r10;
        KmEffectInvocationKind r11 = new KmEffectInvocationKind("AT_LEAST_ONCE", 2);
        AT_LEAST_ONCE = r11;
        f19033a = new KmEffectInvocationKind[]{r5, r10, r11};
    }

    public static KmEffectInvocationKind valueOf(String r5) {
        return (KmEffectInvocationKind) Enum.valueOf(KmEffectInvocationKind.class, r5);
    }

    public static KmEffectInvocationKind[] values() {
        return (KmEffectInvocationKind[]) f19033a.clone();
    }
}
