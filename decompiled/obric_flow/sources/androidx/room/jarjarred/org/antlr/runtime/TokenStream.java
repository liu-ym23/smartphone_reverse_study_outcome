package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface TokenStream extends IntStream {
    Token LT(int r5);

    Token get(int r5);

    TokenSource getTokenSource();

    int range();

    String toString(int r5, int r10);

    String toString(Token r5, Token r10);
}
