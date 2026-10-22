package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;

/* JADX INFO: loaded from: classes.dex */
public interface TokenFactory<Symbol extends Token> {
    Symbol create(int r5, String r10);

    Symbol create(Pair<TokenSource, CharStream> r5, int r10, String r11, int r12, int r13, int r14, int r15, int r16);
}
