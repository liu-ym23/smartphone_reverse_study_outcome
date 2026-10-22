package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmEffectInvocationKind;", "", "(Ljava/lang/String;I)V", "AT_MOST_ONCE", "EXACTLY_ONCE", "AT_LEAST_ONCE", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KmEffectInvocationKind extends Enum<KmEffectInvocationKind> {
    private static final /* synthetic */ KmEffectInvocationKind[] $VALUES = null;
    public static final KmEffectInvocationKind AT_LEAST_ONCE = null;
    public static final KmEffectInvocationKind AT_MOST_ONCE = null;
    public static final KmEffectInvocationKind EXACTLY_ONCE = null;

    private static final /* synthetic */ KmEffectInvocationKind[] $values() {
        return new KmEffectInvocationKind[]{AT_MOST_ONCE, EXACTLY_ONCE, AT_LEAST_ONCE};
    }

    static {
        AT_MOST_ONCE = new KmEffectInvocationKind("AT_MOST_ONCE", 0);
        EXACTLY_ONCE = new KmEffectInvocationKind("EXACTLY_ONCE", 1);
        AT_LEAST_ONCE = new KmEffectInvocationKind("AT_LEAST_ONCE", 2);
        $VALUES = $values();
    }

    private KmEffectInvocationKind(String r5, int r10) {
        super(r5, r10);
    }

    public static KmEffectInvocationKind valueOf(String r5) {
        return (KmEffectInvocationKind) Enum.valueOf(KmEffectInvocationKind.class, r5);
    }

    public static KmEffectInvocationKind[] values() {
        return (KmEffectInvocationKind[]) $VALUES.clone();
    }
}
