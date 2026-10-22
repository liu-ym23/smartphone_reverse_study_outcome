package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;

/* JADX INFO: loaded from: classes.dex */
public final class LexerChannelAction implements LexerAction {
    private final int channel;

    public LexerChannelAction(int r5) {
        this.channel = r5;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof LexerChannelAction) == true) goto L9;
        return false;
    L9:
        if (this.channel != ((LexerChannelAction) r5).channel) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public void execute(Lexer r5) {
        r5.setChannel(this.channel);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public LexerActionType getActionType() {
        return LexerActionType.CHANNEL;
    }

    public int getChannel() {
        return this.channel;
    }

    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(), getActionType().ordinal()), this.channel), 2);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction
    public boolean isPositionDependent() {
        return false;
    }

    public String toString() {
        return String.format("channel(%d)", new Object[]{Integer.valueOf(this.channel)});
    }
}
