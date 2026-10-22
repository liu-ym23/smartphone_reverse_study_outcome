package kotlinx.metadata;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/metadata/KmVersionRequirementVersionKind;", "", "LANGUAGE_VERSION", "COMPILER_VERSION", "API_VERSION", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KmVersionRequirementVersionKind extends Enum<KmVersionRequirementVersionKind> {
    public static final KmVersionRequirementVersionKind API_VERSION = null;
    public static final KmVersionRequirementVersionKind COMPILER_VERSION = null;
    public static final KmVersionRequirementVersionKind LANGUAGE_VERSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmVersionRequirementVersionKind[] f19037a = null;

    static {
        KmVersionRequirementVersionKind r5 = new KmVersionRequirementVersionKind("LANGUAGE_VERSION", 0);
        LANGUAGE_VERSION = r5;
        KmVersionRequirementVersionKind r10 = new KmVersionRequirementVersionKind("COMPILER_VERSION", 1);
        COMPILER_VERSION = r10;
        KmVersionRequirementVersionKind r11 = new KmVersionRequirementVersionKind("API_VERSION", 2);
        API_VERSION = r11;
        f19037a = new KmVersionRequirementVersionKind[]{r5, r10, r11};
    }

    public static KmVersionRequirementVersionKind valueOf(String r5) {
        return (KmVersionRequirementVersionKind) Enum.valueOf(KmVersionRequirementVersionKind.class, r5);
    }

    public static KmVersionRequirementVersionKind[] values() {
        return (KmVersionRequirementVersionKind[]) f19037a.clone();
    }
}
