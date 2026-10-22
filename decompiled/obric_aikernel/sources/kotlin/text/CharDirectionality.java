package kotlin.text;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final enum CharDirectionality extends Enum<CharDirectionality> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CharDirectionality[] $VALUES = null;
    public static final CharDirectionality ARABIC_NUMBER = null;
    public static final CharDirectionality BOUNDARY_NEUTRAL = null;
    public static final CharDirectionality COMMON_NUMBER_SEPARATOR = null;
    public static final Companion Companion = null;
    public static final CharDirectionality EUROPEAN_NUMBER = null;
    public static final CharDirectionality EUROPEAN_NUMBER_SEPARATOR = null;
    public static final CharDirectionality EUROPEAN_NUMBER_TERMINATOR = null;
    public static final CharDirectionality LEFT_TO_RIGHT = null;
    public static final CharDirectionality LEFT_TO_RIGHT_EMBEDDING = null;
    public static final CharDirectionality LEFT_TO_RIGHT_OVERRIDE = null;
    public static final CharDirectionality NONSPACING_MARK = null;
    public static final CharDirectionality OTHER_NEUTRALS = null;
    public static final CharDirectionality PARAGRAPH_SEPARATOR = null;
    public static final CharDirectionality POP_DIRECTIONAL_FORMAT = null;
    public static final CharDirectionality RIGHT_TO_LEFT = null;
    public static final CharDirectionality RIGHT_TO_LEFT_ARABIC = null;
    public static final CharDirectionality RIGHT_TO_LEFT_EMBEDDING = null;
    public static final CharDirectionality RIGHT_TO_LEFT_OVERRIDE = null;
    public static final CharDirectionality SEGMENT_SEPARATOR = null;
    public static final CharDirectionality UNDEFINED = null;
    public static final CharDirectionality WHITESPACE = null;
    private static final Lazy<Map<Integer, CharDirectionality>> directionalityMap$delegate = null;
    private final int value;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private final Map<Integer, CharDirectionality> getDirectionalityMap() {
            return (Map) CharDirectionality.access$getDirectionalityMap$delegate$cp().getValue();
        }

        public final CharDirectionality valueOf(int r10) {
            CharDirectionality r11 = getDirectionalityMap().get(Integer.valueOf(r10));
            if (r11 == null) goto L6;
            return r11;
        L6:
            throw new IllegalArgumentException("Directionality #" + r10 + " is not defined.");
        }
    }

    private static final /* synthetic */ CharDirectionality[] $values() {
        return new CharDirectionality[]{UNDEFINED, LEFT_TO_RIGHT, RIGHT_TO_LEFT, RIGHT_TO_LEFT_ARABIC, EUROPEAN_NUMBER, EUROPEAN_NUMBER_SEPARATOR, EUROPEAN_NUMBER_TERMINATOR, ARABIC_NUMBER, COMMON_NUMBER_SEPARATOR, NONSPACING_MARK, BOUNDARY_NEUTRAL, PARAGRAPH_SEPARATOR, SEGMENT_SEPARATOR, WHITESPACE, OTHER_NEUTRALS, LEFT_TO_RIGHT_EMBEDDING, LEFT_TO_RIGHT_OVERRIDE, RIGHT_TO_LEFT_EMBEDDING, RIGHT_TO_LEFT_OVERRIDE, POP_DIRECTIONAL_FORMAT};
    }

    static {
        UNDEFINED = new CharDirectionality("UNDEFINED", 0, -1);
        LEFT_TO_RIGHT = new CharDirectionality("LEFT_TO_RIGHT", 1, 0);
        RIGHT_TO_LEFT = new CharDirectionality("RIGHT_TO_LEFT", 2, 1);
        RIGHT_TO_LEFT_ARABIC = new CharDirectionality("RIGHT_TO_LEFT_ARABIC", 3, 2);
        EUROPEAN_NUMBER = new CharDirectionality("EUROPEAN_NUMBER", 4, 3);
        EUROPEAN_NUMBER_SEPARATOR = new CharDirectionality("EUROPEAN_NUMBER_SEPARATOR", 5, 4);
        EUROPEAN_NUMBER_TERMINATOR = new CharDirectionality("EUROPEAN_NUMBER_TERMINATOR", 6, 5);
        ARABIC_NUMBER = new CharDirectionality("ARABIC_NUMBER", 7, 6);
        COMMON_NUMBER_SEPARATOR = new CharDirectionality("COMMON_NUMBER_SEPARATOR", 8, 7);
        NONSPACING_MARK = new CharDirectionality("NONSPACING_MARK", 9, 8);
        BOUNDARY_NEUTRAL = new CharDirectionality("BOUNDARY_NEUTRAL", 10, 9);
        PARAGRAPH_SEPARATOR = new CharDirectionality("PARAGRAPH_SEPARATOR", 11, 10);
        SEGMENT_SEPARATOR = new CharDirectionality("SEGMENT_SEPARATOR", 12, 11);
        WHITESPACE = new CharDirectionality("WHITESPACE", 13, 12);
        OTHER_NEUTRALS = new CharDirectionality("OTHER_NEUTRALS", 14, 13);
        LEFT_TO_RIGHT_EMBEDDING = new CharDirectionality("LEFT_TO_RIGHT_EMBEDDING", 15, 14);
        LEFT_TO_RIGHT_OVERRIDE = new CharDirectionality("LEFT_TO_RIGHT_OVERRIDE", 16, 15);
        RIGHT_TO_LEFT_EMBEDDING = new CharDirectionality("RIGHT_TO_LEFT_EMBEDDING", 17, 16);
        RIGHT_TO_LEFT_OVERRIDE = new CharDirectionality("RIGHT_TO_LEFT_OVERRIDE", 18, 17);
        POP_DIRECTIONAL_FORMAT = new CharDirectionality("POP_DIRECTIONAL_FORMAT", 19, 18);
        CharDirectionality[] r10 = $values();
        $VALUES = r10;
        Companion = new Companion(null);
        directionalityMap$delegate = LazyKt.lazy(CharDirectionality$Companion$directionalityMap$2.INSTANCE);
        $ENTRIES = EnumEntriesKt.enumEntries(r10);
    }

    private CharDirectionality(String r10, int r11, int r12) {
        super(r10, r11);
        this.value = r12;
    }

    public static final /* synthetic */ Lazy access$getDirectionalityMap$delegate$cp() {
        return directionalityMap$delegate;
    }

    public static EnumEntries<CharDirectionality> getEntries() {
        return $ENTRIES;
    }

    public static CharDirectionality valueOf(String r10) {
        return (CharDirectionality) Enum.valueOf(CharDirectionality.class, r10);
    }

    public static CharDirectionality[] values() {
        return (CharDirectionality[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
