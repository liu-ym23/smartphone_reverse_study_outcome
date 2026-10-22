package kotlin.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lkotlin/text/RegexOption;", "", "Lkotlin/text/FlagEnum;", "value", "", "mask", "(Ljava/lang/String;III)V", "getMask", "()I", "getValue", "IGNORE_CASE", "MULTILINE", "LITERAL", "UNIX_LINES", "COMMENTS", "DOT_MATCHES_ALL", "CANON_EQ", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        String r5 = "IGNORE_CASE";
        int r10 = 0;
        int r11 = 2;
        int r12 = 0;
        IGNORE_CASE = new RegexOption(r5, r10, r11, r12, 2, null);
        int r13 = 2;
        DefaultConstructorMarker r14 = null;
        int r15 = 0;
        MULTILINE = new RegexOption("MULTILINE", 1, 8, r15, r13, r14);
        int r16 = 2;
        DefaultConstructorMarker r17 = null;
        int r18 = 0;
        LITERAL = new RegexOption("LITERAL", r11, 16, r18, r16, r17);
        UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, r15, r13, r14);
        COMMENTS = new RegexOption("COMMENTS", 4, 4, r18, r16, r17);
        DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, r15, r13, r14);
        CANON_EQ = new RegexOption("CANON_EQ", 6, 128, r18, r16, r17);
        RegexOption[] r19 = $values();
        $VALUES = r19;
        $ENTRIES = EnumEntriesKt.enumEntries(r19);
    }

    private RegexOption(String r5, int r10, int r11, int r12) {
        super(r5, r10);
        this.value = r11;
        this.mask = r12;
    }

    public static EnumEntries<RegexOption> getEntries() {
        return $ENTRIES;
    }

    public static RegexOption valueOf(String r5) {
        return (RegexOption) Enum.valueOf(RegexOption.class, r5);
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

    public /* synthetic */ RegexOption(String r5, int r10, int r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = r11;
    L5:
        this(r5, r10, r11, r12);
    }
}
