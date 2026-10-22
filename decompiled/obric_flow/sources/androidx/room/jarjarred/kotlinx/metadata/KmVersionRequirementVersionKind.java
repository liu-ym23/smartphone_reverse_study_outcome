package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVersionKind;", "", "(Ljava/lang/String;I)V", "LANGUAGE_VERSION", "COMPILER_VERSION", "API_VERSION", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KmVersionRequirementVersionKind extends Enum<KmVersionRequirementVersionKind> {
    private static final /* synthetic */ KmVersionRequirementVersionKind[] $VALUES = null;
    public static final KmVersionRequirementVersionKind API_VERSION = null;
    public static final KmVersionRequirementVersionKind COMPILER_VERSION = null;
    public static final KmVersionRequirementVersionKind LANGUAGE_VERSION = null;

    private static final /* synthetic */ KmVersionRequirementVersionKind[] $values() {
        return new KmVersionRequirementVersionKind[]{LANGUAGE_VERSION, COMPILER_VERSION, API_VERSION};
    }

    static {
        LANGUAGE_VERSION = new KmVersionRequirementVersionKind("LANGUAGE_VERSION", 0);
        COMPILER_VERSION = new KmVersionRequirementVersionKind("COMPILER_VERSION", 1);
        API_VERSION = new KmVersionRequirementVersionKind("API_VERSION", 2);
        $VALUES = $values();
    }

    private KmVersionRequirementVersionKind(String r5, int r10) {
        super(r5, r10);
    }

    public static KmVersionRequirementVersionKind valueOf(String r5) {
        return (KmVersionRequirementVersionKind) Enum.valueOf(KmVersionRequirementVersionKind.class, r5);
    }

    public static KmVersionRequirementVersionKind[] values() {
        return (KmVersionRequirementVersionKind[]) $VALUES.clone();
    }
}
