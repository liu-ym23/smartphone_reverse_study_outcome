package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;

/* JADX INFO: loaded from: classes.dex */
public final class LexerSkipAction implements LexerAction {
    public static final LexerSkipAction INSTANCE = null;

    static {
        INSTANCE = new LexerSkipAction();
    }

    private LexerSkipAction() {
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public void execute(Lexer r5) {
        r5.skip();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public LexerActionType getActionType() {
        return LexerActionType.SKIP;
    }

    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.initialize(), getActionType().ordinal()), 1);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public boolean isPositionDependent() {
        return false;
    }

    public String toString() {
        return "skip";
    }
}
