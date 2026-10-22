package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;

/* JADX INFO: loaded from: classes.dex */
public final class LexerMoreAction implements LexerAction {
    public static final LexerMoreAction INSTANCE = null;

    static {
        INSTANCE = new LexerMoreAction();
    }

    private LexerMoreAction() {
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public void execute(Lexer r5) {
        r5.more();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public LexerActionType getActionType() {
        return LexerActionType.MORE;
    }

    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.initialize(), getActionType().ordinal()), 1);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public boolean isPositionDependent() {
        return false;
    }

    public String toString() {
        return "more";
    }
}
