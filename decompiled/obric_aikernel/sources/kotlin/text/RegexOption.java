package kotlin.text;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final enum RegexOption extends Enum<RegexOption> implements FlagEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RegexOption[] $VALUES = null;
    public static final RegexOption CANON_EQ = null;
    public static final RegexOption COMMENTS = null;
    public static final RegexOption DOT_MATCHES_ALL = null;
    public static final RegexOption IGNORE_CASE = null;
    public static final RegexOption LITERAL = null;
    public static final RegexOption MULTILINE = null;
    public static final RegexOption UNIX_LINES = null;
    private final int mask;
    private final int value;

    private static final /* synthetic */ RegexOption[] $values() {
        return new RegexOption[]{IGNORE_CASE, MULTILINE, LITERAL, UNIX_LINES, COMMENTS, DOT_MATCHES_ALL, CANON_EQ};
    }

    static {
        int r10 = 2;
        IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, r10, 0, 2, null);
        int r12 = 0;
        int r13 = 2;
        DefaultConstructorMarker r14 = null;
        MULTILINE = new RegexOption("MULTILINE", 1, 8, r12, r13, r14);
        int r11 = 0;
        int r15 = 2;
        DefaultConstructorMarker r16 = null;
        LITERAL = new RegexOption("LITERAL", r10, 16, r11, r15, r16);
        UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, r12, r13, r14);
        COMMENTS = new RegexOption("COMMENTS", 4, 4, r11, r15, r16);
        DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, r12, r13, r14);
        CANON_EQ = new RegexOption("CANON_EQ", 6, 128, r11, r15, r16);
        RegexOption[] r17 = $values();
        $VALUES = r17;
        $ENTRIES = EnumEntriesKt.enumEntries(r17);
    }

    private RegexOption(String r10, int r11, int r12, int r13) {
        super(r10, r11);
        this.value = r12;
        this.mask = r13;
    }

    /* synthetic */ RegexOption(String r10, int r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r13 = r12;
    L5:
        this(r10, r11, r12, r13);
    }

    public static EnumEntries<RegexOption> getEntries() {
        return $ENTRIES;
    }

    public static RegexOption valueOf(String r10) {
        return (RegexOption) Enum.valueOf(RegexOption.class, r10);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) $VALUES.clone();
    }

    @Override // kotlin.text.FlagEnum
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.FlagEnum
    public int getValue() {
        return this.value;
    }
}
