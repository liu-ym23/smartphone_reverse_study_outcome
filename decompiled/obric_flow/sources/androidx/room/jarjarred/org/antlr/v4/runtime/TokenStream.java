package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;

/* JADX INFO: loaded from: classes.dex */
public interface TokenStream extends IntStream {
    Token LT(int r5);

    Token get(int r5);

    String getText();

    String getText(RuleContext r5);

    String getText(Token r5, Token r10);

    String getText(Interval r5);

    TokenSource getTokenSource();
}
