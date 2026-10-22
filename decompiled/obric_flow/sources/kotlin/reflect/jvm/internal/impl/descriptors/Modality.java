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
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final Modality convertFromFlags(boolean r5, boolean r10, boolean r11) {
            if (r5 == true) goto L10;
            if (r10 == true) goto L11;
            if (r11 == false) goto L9;
            return Modality.OPEN;
        L9:
            return Modality.FINAL;
        L11:
            return Modality.ABSTRACT;
        L10:
            return Modality.SEALED;
        }

        private Companion() {
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

    private Modality(String r5, int r10) {
        super(r5, r10);
    }

    public static Modality valueOf(String r5) {
        return (Modality) Enum.valueOf(Modality.class, r5);
    }

    public static Modality[] values() {
        return (Modality[]) $VALUES.clone();
    }
}
