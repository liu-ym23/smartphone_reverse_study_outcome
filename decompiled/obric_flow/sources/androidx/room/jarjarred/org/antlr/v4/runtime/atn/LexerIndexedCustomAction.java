package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;

/* JADX INFO: loaded from: classes.dex */
public final class LexerIndexedCustomAction implements LexerAction {
    private final LexerAction action;
    private final int offset;

    public LexerIndexedCustomAction(int r5, LexerAction r10) {
        this.offset = r5;
        this.action = r10;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof LexerIndexedCustomAction) == true) goto L8;
        return false;
    L8:
        LexerIndexedCustomAction r10 = (LexerIndexedCustomAction) r5;
        if (this.offset != r10.offset) goto L14;
        if (this.action.equals(r10.action) == false) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public void execute(Lexer r5) {
        this.action.execute(r5);
    }

    public LexerAction getAction() {
        return this.action;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public LexerActionType getActionType() {
        return this.action.getActionType();
    }

    public int getOffset() {
        return this.offset;
    }

    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(), this.offset), this.action), 2);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public boolean isPositionDependent() {
        return true;
    }
}
