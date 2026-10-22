package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final enum Modality extends Enum<Modality> {
    private static final /* synthetic */ Modality[] $VALUES = null;
    public static final Modality ABSTRACT = null;
    public static final Companion Companion = null;
    public static final Modality FINAL = null;
    public static final Modality OPEN = null;
    public static final Modality SEALED = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final Modality convertFromFlags(boolean r10, boolean r11, boolean r12) {
            if (r10 == true) goto L10;
            if (r11 == true) goto L11;
            if (r12 == false) goto L9;
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
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private Modality(String r10, int r11) {
        super(r10, r11);
    }

    public static Modality valueOf(String r10) {
        return (Modality) Enum.valueOf(Modality.class, r10);
    }

    public static Modality[] values() {
        return (Modality[]) $VALUES.clone();
    }
}
