package androidx.room.jarjarred.org.antlr.v4.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface TokenSource {
    int getCharPositionInLine();

    CharStream getInputStream();

    int getLine();

    String getSourceName();

    TokenFactory<?> getTokenFactory();

    Token nextToken();

    void setTokenFactory(TokenFactory<?> r5);
}
