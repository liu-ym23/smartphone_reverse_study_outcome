package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;

/* JADX INFO: loaded from: classes.dex */
public interface LexerAction {
    void execute(Lexer r5);

    LexerActionType getActionType();

    boolean isPositionDependent();
}
