package androidx.room.jarjarred.org.antlr.v4.tool;

/* JADX INFO: loaded from: classes.dex */
public final enum LabelType extends Enum<LabelType> {
    private static final /* synthetic */ LabelType[] $VALUES = null;
    public static final LabelType LEXER_STRING_LABEL = null;
    public static final LabelType RULE_LABEL = null;
    public static final LabelType RULE_LIST_LABEL = null;
    public static final LabelType TOKEN_LABEL = null;
    public static final LabelType TOKEN_LIST_LABEL = null;

    static {
        LabelType r5 = new LabelType("RULE_LABEL", 0);
        RULE_LABEL = r5;
        LabelType r10 = new LabelType("TOKEN_LABEL", 1);
        TOKEN_LABEL = r10;
        LabelType r11 = new LabelType("RULE_LIST_LABEL", 2);
        RULE_LIST_LABEL = r11;
        LabelType r12 = new LabelType("TOKEN_LIST_LABEL", 3);
        TOKEN_LIST_LABEL = r12;
        LabelType r13 = new LabelType("LEXER_STRING_LABEL", 4);
        LEXER_STRING_LABEL = r13;
        $VALUES = new LabelType[]{r5, r10, r11, r12, r13};
    }

    private LabelType(String r5, int r10) {
        super(r5, r10);
    }

    public static LabelType valueOf(String r5) {
        return (LabelType) Enum.valueOf(LabelType.class, r5);
    }

    public static LabelType[] values() {
        return (LabelType[]) $VALUES.clone();
    }
}
