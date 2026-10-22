package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface Token {
    public static final int DEFAULT_CHANNEL = 0;
    public static final int DOWN = 2;
    public static final int EOF = -1;
    public static final int EOR_TOKEN_TYPE = 1;
    public static final int HIDDEN_CHANNEL = 99;
    public static final Token INVALID_TOKEN = null;
    public static final int INVALID_TOKEN_TYPE = 0;
    public static final int MIN_TOKEN_TYPE = 4;
    public static final Token SKIP_TOKEN = null;
    public static final int UP = 3;

    static {
        INVALID_TOKEN = new CommonToken(0);
        SKIP_TOKEN = new CommonToken(0);
    }

    int getChannel();

    int getCharPositionInLine();

    CharStream getInputStream();

    int getLine();

    String getText();

    int getTokenIndex();

    int getType();

    void setChannel(int r5);

    void setCharPositionInLine(int r5);

    void setInputStream(CharStream r5);

    void setLine(int r5);

    void setText(String r5);

    void setTokenIndex(int r5);

    void setType(int r5);
}
