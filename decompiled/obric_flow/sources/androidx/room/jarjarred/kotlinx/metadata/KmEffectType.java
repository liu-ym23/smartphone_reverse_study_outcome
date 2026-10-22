package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmEffectType;", "", "(Ljava/lang/String;I)V", "RETURNS_CONSTANT", "CALLS", "RETURNS_NOT_NULL", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KmEffectType extends Enum<KmEffectType> {
    private static final /* synthetic */ KmEffectType[] $VALUES = null;
    public static final KmEffectType CALLS = null;
    public static final KmEffectType RETURNS_CONSTANT = null;
    public static final KmEffectType RETURNS_NOT_NULL = null;

    private static final /* synthetic */ KmEffectType[] $values() {
        return new KmEffectType[]{RETURNS_CONSTANT, CALLS, RETURNS_NOT_NULL};
    }

    static {
        RETURNS_CONSTANT = new KmEffectType("RETURNS_CONSTANT", 0);
        CALLS = new KmEffectType("CALLS", 1);
        RETURNS_NOT_NULL = new KmEffectType("RETURNS_NOT_NULL", 2);
        $VALUES = $values();
    }

    private KmEffectType(String r5, int r10) {
        super(r5, r10);
    }

    public static KmEffectType valueOf(String r5) {
        return (KmEffectType) Enum.valueOf(KmEffectType.class, r5);
    }

    public static KmEffectType[] values() {
        return (KmEffectType[]) $VALUES.clone();
    }
}
