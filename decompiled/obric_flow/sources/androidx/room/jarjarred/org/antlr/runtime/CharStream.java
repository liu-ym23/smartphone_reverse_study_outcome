package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface CharStream extends IntStream {
    public static final int EOF = -1;

    int LT(int r5);

    int getCharPositionInLine();

    int getLine();

    void setCharPositionInLine(int r5);

    void setLine(int r5);

    String substring(int r5, int r10);
}
