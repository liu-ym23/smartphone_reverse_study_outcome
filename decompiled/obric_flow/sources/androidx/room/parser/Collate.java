package androidx.room.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Landroidx/room/parser/Collate;", "", "(Ljava/lang/String;I)V", "BINARY", "NOCASE", "RTRIM", "LOCALIZED", "UNICODE", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum Collate extends Enum<Collate> {
    private static final /* synthetic */ Collate[] $VALUES = null;
    public static final Collate BINARY = null;
    public static final Companion Companion = null;
    public static final Collate LOCALIZED = null;
    public static final Collate NOCASE = null;
    public static final Collate RTRIM = null;
    public static final Collate UNICODE = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/room/parser/Collate$Companion;", "", "()V", "fromAnnotationValue", "Landroidx/room/parser/Collate;", "value", "", "(Ljava/lang/Integer;)Landroidx/room/parser/Collate;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final Collate fromAnnotationValue(Integer r5) {
            if (r5 != null) goto L5;
        L7:
            if (r5 != null) goto L10;
        L12:
            if (r5 != null) goto L15;
        L17:
            if (r5 != null) goto L20;
        L22:
            if (r5 != null) goto L25;
        L27:
            return null;
        L25:
            if (r5.intValue() != 6) goto L27;
            return Collate.UNICODE;
        L20:
            if (r5.intValue() != 5) goto L22;
            return Collate.LOCALIZED;
        L15:
            if (r5.intValue() != 4) goto L17;
            return Collate.RTRIM;
        L10:
            if (r5.intValue() != 3) goto L12;
            return Collate.NOCASE;
        L5:
            if (r5.intValue() != 2) goto L7;
            return Collate.BINARY;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ Collate[] $values() {
        return new Collate[]{BINARY, NOCASE, RTRIM, LOCALIZED, UNICODE};
    }

    static {
        BINARY = new Collate("BINARY", 0);
        NOCASE = new Collate("NOCASE", 1);
        RTRIM = new Collate("RTRIM", 2);
        LOCALIZED = new Collate("LOCALIZED", 3);
        UNICODE = new Collate("UNICODE", 4);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    private Collate(String r5, int r10) {
        super(r5, r10);
    }

    public static Collate valueOf(String r5) {
        return (Collate) Enum.valueOf(Collate.class, r5);
    }

    public static Collate[] values() {
        return (Collate[]) $VALUES.clone();
    }
}
