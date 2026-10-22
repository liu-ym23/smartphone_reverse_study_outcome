package kotlin.text;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
public final enum CharCategory extends Enum<CharCategory> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CharCategory[] $VALUES = null;
    public static final CharCategory COMBINING_SPACING_MARK = null;
    public static final CharCategory CONNECTOR_PUNCTUATION = null;
    public static final CharCategory CONTROL = null;
    public static final CharCategory CURRENCY_SYMBOL = null;
    public static final Companion Companion = null;
    public static final CharCategory DASH_PUNCTUATION = null;
    public static final CharCategory DECIMAL_DIGIT_NUMBER = null;
    public static final CharCategory ENCLOSING_MARK = null;
    public static final CharCategory END_PUNCTUATION = null;
    public static final CharCategory FINAL_QUOTE_PUNCTUATION = null;
    public static final CharCategory FORMAT = null;
    public static final CharCategory INITIAL_QUOTE_PUNCTUATION = null;
    public static final CharCategory LETTER_NUMBER = null;
    public static final CharCategory LINE_SEPARATOR = null;
    public static final CharCategory LOWERCASE_LETTER = null;
    public static final CharCategory MATH_SYMBOL = null;
    public static final CharCategory MODIFIER_LETTER = null;
    public static final CharCategory MODIFIER_SYMBOL = null;
    public static final CharCategory NON_SPACING_MARK = null;
    public static final CharCategory OTHER_LETTER = null;
    public static final CharCategory OTHER_NUMBER = null;
    public static final CharCategory OTHER_PUNCTUATION = null;
    public static final CharCategory OTHER_SYMBOL = null;
    public static final CharCategory PARAGRAPH_SEPARATOR = null;
    public static final CharCategory PRIVATE_USE = null;
    public static final CharCategory SPACE_SEPARATOR = null;
    public static final CharCategory START_PUNCTUATION = null;
    public static final CharCategory SURROGATE = null;
    public static final CharCategory TITLECASE_LETTER = null;
    public static final CharCategory UNASSIGNED = null;
    public static final CharCategory UPPERCASE_LETTER = null;
    private final String code;
    private final int value;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final CharCategory valueOf(int r10) {
            if (new IntRange(0, 16).contains(r10) == false) goto L6;
            return CharCategory.values()[r10];
        L6:
            if (new IntRange(18, 30).contains(r10) == false) goto L10;
            return CharCategory.values()[r10 - 1];
        L10:
            throw new IllegalArgumentException("Category #" + r10 + " is not defined.");
        }
    }

    private static final /* synthetic */ CharCategory[] $values() {
        return new CharCategory[]{UNASSIGNED, UPPERCASE_LETTER, LOWERCASE_LETTER, TITLECASE_LETTER, MODIFIER_LETTER, OTHER_LETTER, NON_SPACING_MARK, ENCLOSING_MARK, COMBINING_SPACING_MARK, DECIMAL_DIGIT_NUMBER, LETTER_NUMBER, OTHER_NUMBER, SPACE_SEPARATOR, LINE_SEPARATOR, PARAGRAPH_SEPARATOR, CONTROL, FORMAT, PRIVATE_USE, SURROGATE, DASH_PUNCTUATION, START_PUNCTUATION, END_PUNCTUATION, CONNECTOR_PUNCTUATION, OTHER_PUNCTUATION, MATH_SYMBOL, CURRENCY_SYMBOL, MODIFIER_SYMBOL, OTHER_SYMBOL, INITIAL_QUOTE_PUNCTUATION, FINAL_QUOTE_PUNCTUATION};
    }

    static {
        UNASSIGNED = new CharCategory("UNASSIGNED", 0, 0, "Cn");
        UPPERCASE_LETTER = new CharCategory("UPPERCASE_LETTER", 1, 1, "Lu");
        LOWERCASE_LETTER = new CharCategory("LOWERCASE_LETTER", 2, 2, "Ll");
        TITLECASE_LETTER = new CharCategory("TITLECASE_LETTER", 3, 3, "Lt");
        MODIFIER_LETTER = new CharCategory("MODIFIER_LETTER", 4, 4, "Lm");
        OTHER_LETTER = new CharCategory("OTHER_LETTER", 5, 5, "Lo");
        NON_SPACING_MARK = new CharCategory("NON_SPACING_MARK", 6, 6, "Mn");
        ENCLOSING_MARK = new CharCategory("ENCLOSING_MARK", 7, 7, "Me");
        COMBINING_SPACING_MARK = new CharCategory("COMBINING_SPACING_MARK", 8, 8, "Mc");
        DECIMAL_DIGIT_NUMBER = new CharCategory("DECIMAL_DIGIT_NUMBER", 9, 9, "Nd");
        LETTER_NUMBER = new CharCategory("LETTER_NUMBER", 10, 10, "Nl");
        OTHER_NUMBER = new CharCategory("OTHER_NUMBER", 11, 11, "No");
        SPACE_SEPARATOR = new CharCategory("SPACE_SEPARATOR", 12, 12, "Zs");
        LINE_SEPARATOR = new CharCategory("LINE_SEPARATOR", 13, 13, "Zl");
        PARAGRAPH_SEPARATOR = new CharCategory("PARAGRAPH_SEPARATOR", 14, 14, "Zp");
        CONTROL = new CharCategory("CONTROL", 15, 15, "Cc");
        FORMAT = new CharCategory("FORMAT", 16, 16, "Cf");
        PRIVATE_USE = new CharCategory("PRIVATE_USE", 17, 18, "Co");
        SURROGATE = new CharCategory("SURROGATE", 18, 19, "Cs");
        DASH_PUNCTUATION = new CharCategory("DASH_PUNCTUATION", 19, 20, "Pd");
        START_PUNCTUATION = new CharCategory("START_PUNCTUATION", 20, 21, "Ps");
        END_PUNCTUATION = new CharCategory("END_PUNCTUATION", 21, 22, "Pe");
        CONNECTOR_PUNCTUATION = new CharCategory("CONNECTOR_PUNCTUATION", 22, 23, "Pc");
        OTHER_PUNCTUATION = new CharCategory("OTHER_PUNCTUATION", 23, 24, "Po");
        MATH_SYMBOL = new CharCategory("MATH_SYMBOL", 24, 25, "Sm");
        CURRENCY_SYMBOL = new CharCategory("CURRENCY_SYMBOL", 25, 26, "Sc");
        MODIFIER_SYMBOL = new CharCategory("MODIFIER_SYMBOL", 26, 27, "Sk");
        OTHER_SYMBOL = new CharCategory("OTHER_SYMBOL", 27, 28, "So");
        INITIAL_QUOTE_PUNCTUATION = new CharCategory("INITIAL_QUOTE_PUNCTUATION", 28, 29, "Pi");
        FINAL_QUOTE_PUNCTUATION = new CharCategory("FINAL_QUOTE_PUNCTUATION", 29, 30, "Pf");
        CharCategory[] r10 = $values();
        $VALUES = r10;
        Companion = new Companion(null);
        $ENTRIES = EnumEntriesKt.enumEntries(r10);
    }

    private CharCategory(String r10, int r11, int r12, String r13) {
        super(r10, r11);
        this.value = r12;
        this.code = r13;
    }

    public static EnumEntries<CharCategory> getEntries() {
        return $ENTRIES;
    }

    public static CharCategory valueOf(String r10) {
        return (CharCategory) Enum.valueOf(CharCategory.class, r10);
    }

    public static CharCategory[] values() {
        return (CharCategory[]) $VALUES.clone();
    }

    public final boolean contains(char r10) {
        if (Character.getType(r10) != this.value) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}
