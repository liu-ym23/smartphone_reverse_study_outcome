package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementLevel;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "HIDDEN", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KmVersionRequirementLevel extends Enum<KmVersionRequirementLevel> {
    private static final /* synthetic */ KmVersionRequirementLevel[] $VALUES = null;
    public static final KmVersionRequirementLevel ERROR = null;
    public static final KmVersionRequirementLevel HIDDEN = null;
    public static final KmVersionRequirementLevel WARNING = null;

    private static final /* synthetic */ KmVersionRequirementLevel[] $values() {
        return new KmVersionRequirementLevel[]{WARNING, ERROR, HIDDEN};
    }

    static {
        WARNING = new KmVersionRequirementLevel("WARNING", 0);
        ERROR = new KmVersionRequirementLevel("ERROR", 1);
        HIDDEN = new KmVersionRequirementLevel("HIDDEN", 2);
        $VALUES = $values();
    }

    private KmVersionRequirementLevel(String r5, int r10) {
        super(r5, r10);
    }

    public static KmVersionRequirementLevel valueOf(String r5) {
        return (KmVersionRequirementLevel) Enum.valueOf(KmVersionRequirementLevel.class, r5);
    }

    public static KmVersionRequirementLevel[] values() {
        return (KmVersionRequirementLevel[]) $VALUES.clone();
    }
}
