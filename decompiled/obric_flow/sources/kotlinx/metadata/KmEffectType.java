package kotlinx.metadata;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/metadata/KmEffectType;", "", "RETURNS_CONSTANT", "CALLS", "RETURNS_NOT_NULL", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KmEffectType extends Enum<KmEffectType> {
    public static final KmEffectType CALLS = null;
    public static final KmEffectType RETURNS_CONSTANT = null;
    public static final KmEffectType RETURNS_NOT_NULL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmEffectType[] f19034a = null;

    static {
        KmEffectType r5 = new KmEffectType("RETURNS_CONSTANT", 0);
        RETURNS_CONSTANT = r5;
        KmEffectType r10 = new KmEffectType("CALLS", 1);
        CALLS = r10;
        KmEffectType r11 = new KmEffectType("RETURNS_NOT_NULL", 2);
        RETURNS_NOT_NULL = r11;
        f19034a = new KmEffectType[]{r5, r10, r11};
    }

    public static KmEffectType valueOf(String r5) {
        return (KmEffectType) Enum.valueOf(KmEffectType.class, r5);
    }

    public static KmEffectType[] values() {
        return (KmEffectType[]) f19034a.clone();
    }
}
