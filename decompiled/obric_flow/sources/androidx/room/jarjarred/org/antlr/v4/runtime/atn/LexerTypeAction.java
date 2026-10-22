package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;

/* JADX INFO: loaded from: classes.dex */
public class LexerTypeAction implements LexerAction {
    private final int type;

    public LexerTypeAction(int r5) {
        this.type = r5;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof LexerTypeAction) == true) goto L9;
        return false;
    L9:
        if (this.type != ((LexerTypeAction) r5).type) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public void execute(Lexer r5) {
        r5.setType(this.type);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public LexerActionType getActionType() {
        return LexerActionType.TYPE;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(), getActionType().ordinal()), this.type), 2);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public boolean isPositionDependent() {
        return false;
    }

    public String toString() {
        return String.format("type(%d)", new Object[]{Integer.valueOf(this.type)});
    }
}
