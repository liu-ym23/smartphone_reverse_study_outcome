package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;

/* JADX INFO: loaded from: classes.dex */
public final class LexerCustomAction implements LexerAction {
    private final int actionIndex;
    private final int ruleIndex;

    public LexerCustomAction(int r5, int r10) {
        this.ruleIndex = r5;
        this.actionIndex = r10;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof LexerCustomAction) == true) goto L8;
        return false;
    L8:
        LexerCustomAction r10 = (LexerCustomAction) r5;
        if (this.ruleIndex != r10.ruleIndex) goto L14;
        if (this.actionIndex != r10.actionIndex) goto L14;
        return true;
    L14:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public void execute(Lexer r5) {
        r5.action(null, this.ruleIndex, this.actionIndex);
    }

    public int getActionIndex() {
        return this.actionIndex;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public LexerActionType getActionType() {
        return LexerActionType.CUSTOM;
    }

    public int getRuleIndex() {
        return this.ruleIndex;
    }

    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(), getActionType().ordinal()), this.ruleIndex), this.actionIndex), 3);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public boolean isPositionDependent() {
        return true;
    }
}
