package kotlin.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
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

    public static EnumEntries<RegexOption> getEntries() {
        return $ENTRIES;
    }

    public static RegexOption valueOf(String r1) {
        return (RegexOption) a.a(RegexOption.class, r1);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) $VALUES.clone();
    }

    static {
        int r3 = 2;
        IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, r3, 0, 2, null);
        int r12 = 0;
        int r13 = 2;
        DefaultConstructorMarker r14 = null;
        MULTILINE = new RegexOption("MULTILINE", 1, 8, r12, r13, r14);
        int r5 = 0;
        int r6 = 2;
        DefaultConstructorMarker r7 = null;
        LITERAL = new RegexOption("LITERAL", r3, 16, r5, r6, r7);
        UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, r12, r13, r14);
        COMMENTS = new RegexOption("COMMENTS", 4, 4, r5, r6, r7);
        DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, r12, r13, r14);
        CANON_EQ = new RegexOption("CANON_EQ", 6, 128, r5, r6, r7);
        RegexOption[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    @Override // kotlin.text.FlagEnum
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.FlagEnum
    public int getValue() {
        return this.value;
    }

    private RegexOption(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.value = r3;
        this.mask = r4;
    }

    public /* synthetic */ RegexOption(String r1, int r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = r3;
    L5:
        this(r1, r2, r3, r4);
    }
}
