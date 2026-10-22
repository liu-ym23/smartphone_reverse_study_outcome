package androidx.room.jarjarred.org.antlr.runtime;

import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.antlr.runtime.tree.PositionTrackingStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream;

/* JADX INFO: loaded from: classes.dex */
public class RecognitionException extends Exception {
    public boolean approximateLineInfo;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f626c;
    public int charPositionInLine;
    public int index;
    public transient IntStream input;
    public int line;
    public Object node;
    public Token token;

    public RecognitionException() {
    }

    public void extractInformationFromTreeNodeStream(IntStream r10) {
        TreeNodeStream r11 = (TreeNodeStream) r10;
        this.node = r11.LT(1);
        if ((r11 instanceof PositionTrackingStream) == false) goto L10;
        PositionTrackingStream r5 = (PositionTrackingStream) r11;
        boolean r12 = false;
        Object r13 = r5.getKnownPositionElement(false);
        if (r13 != null) goto L11;
        r13 = r5.getKnownPositionElement(true);
        if (r13 == null) goto L9;
        r12 = true;
    L9:
        this.approximateLineInfo = r12;
    L11:
        TreeAdaptor r14 = r11.getTreeAdaptor();
        if (r13 != null) goto L15;
        r13 = this.node;
    L15:
        Token r15 = r14.getToken(r13);
        if (r15 == null) goto L31;
        this.token = r15;
        if (r15.getLine() > 0) goto L30;
        Object r16 = r11.LT(-1);
        int r17 = -1;
    L20:
        if (r16 == null) goto L49;
        Token r18 = r14.getToken(r16);
        if (r18 != null) goto L24;
    L26:
        r17 = r17 - 1;
        r16 = r11.LT(r17);     // Catch: UnsupportedOperationException -> L29
    L29:
        r16 = null;
        goto L20
    L24:
        if (r18.getLine() <= 0) goto L26;
        this.line = r18.getLine();
        this.charPositionInLine = r18.getCharPositionInLine();
        this.approximateLineInfo = true;
        return;
    L49:
        return;
    L30:
        this.line = r15.getLine();
        this.charPositionInLine = r15.getCharPositionInLine();
        return;
    L31:
        Object r19 = this.node;
        if ((r19 instanceof Tree) == false) goto L36;
        this.line = ((Tree) r19).getLine();
        this.charPositionInLine = ((Tree) this.node).getCharPositionInLine();
        Object r20 = this.node;
        if ((r20 instanceof CommonTree) == false) goto L47;
        this.token = ((CommonTree) r20).token;
        return;
    L47:
        return;
    L36:
        this.token = new CommonToken(r14.getType(r19), r14.getText(this.node));
        return;
    L10:
        r13 = null;
        goto L11
    }

    public int getUnexpectedType() {
        IntStream r5 = this.input;
        if ((r5 instanceof TokenStream) == false) goto L7;
        return this.token.getType();
    L7:
        if ((r5 instanceof TreeNodeStream) == false) goto L11;
        return ((TreeNodeStream) r5).getTreeAdaptor().getType(this.node);
    L11:
        return this.f626c;
    }

    public RecognitionException(IntStream r5) {
        this.input = r5;
        this.index = r5.index();
        if ((r5 instanceof TokenStream) == false) goto L6;
        Token r10 = ((TokenStream) r5).LT(1);
        this.token = r10;
        this.line = r10.getLine();
        this.charPositionInLine = this.token.getCharPositionInLine();
    L6:
        if ((r5 instanceof TreeNodeStream) == false) goto L9;
        extractInformationFromTreeNodeStream(r5);
        return;
    L9:
        if ((r5 instanceof CharStream) == false) goto L11;
        this.f626c = r5.LA(1);
        CharStream r11 = (CharStream) r5;
        this.line = r11.getLine();
        this.charPositionInLine = r11.getCharPositionInLine();
        return;
    L11:
        this.f626c = r5.LA(1);
    }
}
