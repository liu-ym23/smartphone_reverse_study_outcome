package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.IntStream;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedTokenException;
import androidx.room.jarjarred.org.antlr.runtime.MissingTokenException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.UnwantedTokenException;

/* JADX INFO: loaded from: classes.dex */
public class CommonErrorNode extends CommonTree {
    public IntStream input;
    public Token start;
    public Token stop;
    public RecognitionException trappedException;

    public CommonErrorNode(TokenStream r5, Token r10, Token r11, RecognitionException r12) {
        if (r11 != null) goto L5;
    L8:
        r11 = r10;
    L9:
        this.input = r5;
        this.start = r10;
        this.stop = r11;
        this.trappedException = r12;
        return;
    L5:
        if (r11.getTokenIndex() >= r10.getTokenIndex()) goto L9;
        if (r11.getType() == (-1)) goto L9;
        goto L8
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public String getText() {
        if (this.start == null) goto L8;
        int r5 = this.start.getTokenIndex();
        int r10 = this.stop.getTokenIndex();
        if (this.stop.getType() != (-1)) goto L13;
        r10 = ((TokenStream) this.input).size();
    L13:
        return ((TokenStream) this.input).toString(r5, r10);
    L8:
        Token r11 = this.start;
        if ((r11 instanceof Tree) == true) goto L14;
        return androidx.room.jarjarred.org.antlr.v4.runtime.IntStream.UNKNOWN_SOURCE_NAME;
    L14:
        return ((TreeNodeStream) this.input).toString(r11, this.stop);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getType() {
        return 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public boolean isNil() {
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public String toString() {
        RecognitionException r5 = this.trappedException;
        if ((r5 instanceof MissingTokenException) == false) goto L7;
        return "<missing type: " + ((MissingTokenException) this.trappedException).getMissingType() + ">";
    L7:
        if ((r5 instanceof UnwantedTokenException) == false) goto L11;
        return "<extraneous: " + ((UnwantedTokenException) this.trappedException).getUnexpectedToken() + ", resync=" + getText() + ">";
    L11:
        if ((r5 instanceof MismatchedTokenException) == false) goto L15;
        return "<mismatched token: " + this.trappedException.token + ", resync=" + getText() + ">";
    L15:
        if ((r5 instanceof NoViableAltException) == false) goto L19;
        return "<unexpected: " + this.trappedException.token + ", resync=" + getText() + ">";
    L19:
        return "<error: " + getText() + ">";
    }
}
