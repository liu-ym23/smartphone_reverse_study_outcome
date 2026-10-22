package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;

/* JADX INFO: loaded from: classes.dex */
public final class LexerModeAction implements LexerAction {
    private final int mode;

    public LexerModeAction(int r5) {
        this.mode = r5;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof LexerModeAction) == true) goto L9;
        return false;
    L9:
        if (this.mode != ((LexerModeAction) r5).mode) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public void execute(Lexer r5) {
        r5.mode(this.mode);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public LexerActionType getActionType() {
        return LexerActionType.MODE;
    }

    public int getMode() {
        return this.mode;
    }

    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(), getActionType().ordinal()), this.mode), 2);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public boolean isPositionDependent() {
        return false;
    }

    public String toString() {
        return String.format("mode(%d)", new Object[]{Integer.valueOf(this.mode)});
    }
}
