package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

/* JADX INFO: loaded from: classes.dex */
public final enum ATNType extends Enum<ATNType> {
    private static final /* synthetic */ ATNType[] $VALUES = null;
    public static final ATNType LEXER = null;
    public static final ATNType PARSER = null;

    static {
        ATNType r5 = new ATNType("LEXER", 0);
        LEXER = r5;
        ATNType r10 = new ATNType("PARSER", 1);
        PARSER = r10;
        $VALUES = new ATNType[]{r5, r10};
    }

    private ATNType(String r5, int r10) {
        super(r5, r10);
    }

    public static ATNType valueOf(String r5) {
        return (ATNType) Enum.valueOf(ATNType.class, r5);
    }

    public static ATNType[] values() {
        return (ATNType[]) $VALUES.clone();
    }
}
