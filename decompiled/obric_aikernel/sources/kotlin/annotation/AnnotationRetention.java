package kotlin.annotation;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
public final enum AnnotationRetention extends Enum<AnnotationRetention> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AnnotationRetention[] $VALUES = null;
    public static final AnnotationRetention BINARY = null;
    public static final AnnotationRetention RUNTIME = null;
    public static final AnnotationRetention SOURCE = null;

    private static final /* synthetic */ AnnotationRetention[] $values() {
        return new AnnotationRetention[]{SOURCE, BINARY, RUNTIME};
    }

    static {
        SOURCE = new AnnotationRetention("SOURCE", 0);
        BINARY = new AnnotationRetention("BINARY", 1);
        RUNTIME = new AnnotationRetention("RUNTIME", 2);
        AnnotationRetention[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = EnumEntriesKt.enumEntries(r10);
    }

    private AnnotationRetention(String r10, int r11) {
        super(r10, r11);
    }

    public static EnumEntries<AnnotationRetention> getEntries() {
        return $ENTRIES;
    }

    public static AnnotationRetention valueOf(String r10) {
        return (AnnotationRetention) Enum.valueOf(AnnotationRetention.class, r10);
    }

    public static AnnotationRetention[] values() {
        return (AnnotationRetention[]) $VALUES.clone();
    }
}
