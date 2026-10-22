package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

/* JADX INFO: loaded from: classes.dex */
public final enum LexerActionType extends Enum<LexerActionType> {
    private static final /* synthetic */ LexerActionType[] $VALUES = null;
    public static final LexerActionType CHANNEL = null;
    public static final LexerActionType CUSTOM = null;
    public static final LexerActionType MODE = null;
    public static final LexerActionType MORE = null;
    public static final LexerActionType POP_MODE = null;
    public static final LexerActionType PUSH_MODE = null;
    public static final LexerActionType SKIP = null;
    public static final LexerActionType TYPE = null;

    static {
        LexerActionType r5 = new LexerActionType("CHANNEL", 0);
        CHANNEL = r5;
        LexerActionType r10 = new LexerActionType("CUSTOM", 1);
        CUSTOM = r10;
        LexerActionType r11 = new LexerActionType("MODE", 2);
        MODE = r11;
        LexerActionType r12 = new LexerActionType("MORE", 3);
        MORE = r12;
        LexerActionType r13 = new LexerActionType("POP_MODE", 4);
        POP_MODE = r13;
        LexerActionType r14 = new LexerActionType("PUSH_MODE", 5);
        PUSH_MODE = r14;
        LexerActionType r15 = new LexerActionType("SKIP", 6);
        SKIP = r15;
        LexerActionType r16 = new LexerActionType("TYPE", 7);
        TYPE = r16;
        $VALUES = new LexerActionType[]{r5, r10, r11, r12, r13, r14, r15, r16};
    }

    private LexerActionType(String r5, int r10) {
        super(r5, r10);
    }

    public static LexerActionType valueOf(String r5) {
        return (LexerActionType) Enum.valueOf(LexerActionType.class, r5);
    }

    public static LexerActionType[] values() {
        return (LexerActionType[]) $VALUES.clone();
    }
}
