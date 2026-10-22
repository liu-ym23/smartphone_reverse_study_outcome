package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum LightClassOriginKind extends Enum<LightClassOriginKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LightClassOriginKind[] $VALUES = null;
    public static final LightClassOriginKind BINARY = null;
    public static final LightClassOriginKind SOURCE = null;

    private static final /* synthetic */ LightClassOriginKind[] $values() {
        return new LightClassOriginKind[]{SOURCE, BINARY};
    }

    static {
        SOURCE = new LightClassOriginKind("SOURCE", 0);
        BINARY = new LightClassOriginKind("BINARY", 1);
        LightClassOriginKind[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static LightClassOriginKind[] values() {
        return (LightClassOriginKind[]) $VALUES.clone();
    }

    public static LightClassOriginKind valueOf(String r1) {
        return (LightClassOriginKind) a.a(LightClassOriginKind.class, r1);
    }

    private LightClassOriginKind(String r1, int r2) {
        super(r1, r2);
    }
}
