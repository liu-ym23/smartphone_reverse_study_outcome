package kotlin.reflect;

import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public interface KParameter extends KAnnotatedElement {

    public static final class DefaultImpls {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isVararg$annotations() {
        }
    }

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind EXTENSION_RECEIVER = null;
        public static final Kind INSTANCE = null;
        public static final Kind VALUE = null;

        private static final /* synthetic */ Kind[] $values() {
            return new Kind[]{INSTANCE, EXTENSION_RECEIVER, VALUE};
        }

        static {
            INSTANCE = new Kind("INSTANCE", 0);
            EXTENSION_RECEIVER = new Kind("EXTENSION_RECEIVER", 1);
            VALUE = new Kind("VALUE", 2);
            Kind[] r10 = $values();
            $VALUES = r10;
            $ENTRIES = EnumEntriesKt.enumEntries(r10);
        }

        private Kind(String r10, int r11) {
            super(r10, r11);
        }

        public static EnumEntries<Kind> getEntries() {
            return $ENTRIES;
        }

        public static Kind valueOf(String r10) {
            return (Kind) Enum.valueOf(Kind.class, r10);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    int getIndex();

    Kind getKind();

    String getName();

    KType getType();

    boolean isOptional();

    boolean isVararg();
}
