package kotlinx.metadata;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/metadata/KmVersionRequirementLevel;", "", "WARNING", "ERROR", "HIDDEN", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KmVersionRequirementLevel extends Enum<KmVersionRequirementLevel> {
    public static final KmVersionRequirementLevel ERROR = null;
    public static final KmVersionRequirementLevel HIDDEN = null;
    public static final KmVersionRequirementLevel WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmVersionRequirementLevel[] f19036a = null;

    static {
        KmVersionRequirementLevel r5 = new KmVersionRequirementLevel("WARNING", 0);
        WARNING = r5;
        KmVersionRequirementLevel r10 = new KmVersionRequirementLevel("ERROR", 1);
        ERROR = r10;
        KmVersionRequirementLevel r11 = new KmVersionRequirementLevel("HIDDEN", 2);
        HIDDEN = r11;
        f19036a = new KmVersionRequirementLevel[]{r5, r10, r11};
    }

    public static KmVersionRequirementLevel valueOf(String r5) {
        return (KmVersionRequirementLevel) Enum.valueOf(KmVersionRequirementLevel.class, r5);
    }

    public static KmVersionRequirementLevel[] values() {
        return (KmVersionRequirementLevel[]) f19036a.clone();
    }
}
