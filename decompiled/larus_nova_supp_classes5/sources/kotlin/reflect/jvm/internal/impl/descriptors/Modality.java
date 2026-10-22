package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum Modality extends Enum<Modality> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Modality[] $VALUES = null;
    public static final Modality ABSTRACT = null;
    public static final Companion Companion = null;
    public static final Modality FINAL = null;
    public static final Modality OPEN = null;
    public static final Modality SEALED = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Modality convertFromFlags(boolean r1, boolean r2, boolean r3) {
            if (r1 == true) goto L10;
            if (r2 == true) goto L11;
            if (r3 == false) goto L9;
            return Modality.OPEN;
        L9:
            return Modality.FINAL;
        L11:
            return Modality.ABSTRACT;
        L10:
            return Modality.SEALED;
        }
    }

    private static final /* synthetic */ Modality[] $values() {
        return new Modality[]{FINAL, SEALED, OPEN, ABSTRACT};
    }

    static {
        FINAL = new Modality("FINAL", 0);
        SEALED = new Modality("SEALED", 1);
        OPEN = new Modality("OPEN", 2);
        ABSTRACT = new Modality("ABSTRACT", 3);
        Modality[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new Companion(null);
    }

    public static Modality[] values() {
        return (Modality[]) $VALUES.clone();
    }

    public static Modality valueOf(String r1) {
        return (Modality) a.a(Modality.class, r1);
    }

    private Modality(String r1, int r2) {
        super(r1, r2);
    }
}
