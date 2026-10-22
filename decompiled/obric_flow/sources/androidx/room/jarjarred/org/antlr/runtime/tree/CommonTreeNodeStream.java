package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.misc.IntArray;
import androidx.room.jarjarred.org.antlr.runtime.misc.LookaheadStream;

/* JADX INFO: loaded from: classes.dex */
public class CommonTreeNodeStream extends LookaheadStream<Object> implements TreeNodeStream, PositionTrackingStream<Object> {
    public static final int DEFAULT_INITIAL_BUFFER_SIZE = 100;
    public static final int INITIAL_CALL_STACK_SIZE = 10;
    TreeAdaptor adaptor;
    protected IntArray calls;
    protected boolean hasNilRoot;
    protected TreeIterator it;
    protected int level;
    protected Object previousLocationElement;
    protected Object root;
    protected TokenStream tokens;

    public CommonTreeNodeStream(Object r5) {
        this(new CommonTreeAdaptor(), r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int LA(int r5) {
        return this.adaptor.getType(LT(r5));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public Object get(int r5) {
        throw new UnsupportedOperationException("Absolute node indexes are meaningless in an unbuffered stream");
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.PositionTrackingStream
    public Object getKnownPositionElement(boolean r5) {
        Object r10 = this.data.get(this.f631p);
        if (hasPositionInformation(r10) == false) goto L5;
        return r10;
    L5:
        if (r5 == true) goto L8;
        return null;
    L8:
        int r11 = this.f631p - 1;
    L9:
        if (r11 < 0) goto L15;
        Object r12 = this.data.get(r11);
        if (hasPositionInformation(r12) == true) goto L12;
        r11 = r11 - 1;
        goto L9
    L12:
        return r12;
    L15:
        return this.previousLocationElement;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public String getSourceName() {
        return getTokenStream().getSourceName();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public TokenStream getTokenStream() {
        return this.tokens;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public TreeAdaptor getTreeAdaptor() {
        return this.adaptor;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public Object getTreeSource() {
        return this.root;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.PositionTrackingStream
    public boolean hasPositionInformation(Object r5) {
        Token r10 = this.adaptor.getToken(r5);
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.getLine() > 0) goto L8;
        return false;
    L8:
        return true;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.misc.LookaheadStream
    public boolean isEOF(Object r5) {
        if (this.adaptor.getType(r5) != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.misc.LookaheadStream
    public Object nextElement() {
        Object r5 = this.it.next();
        TreeIterator r10 = this.it;
        if (r5 != r10.f636up) goto L11;
        int r11 = this.level - 1;
        this.level = r11;
        if (r11 != 0) goto L14;
        if (this.hasNilRoot == false) goto L14;
        return r10.next();
    L14:
        if (this.level == 0) goto L16;
        return r5;
    L16:
        if (this.adaptor.isNil(r5) == false) goto L20;
        this.hasNilRoot = true;
        this.it.next();
        this.level++;
        return this.it.next();
    L20:
        return r5;
    L11:
        if (r5 != r10.down) goto L14;
        this.level++;
        goto L14
    }

    public int pop() {
        int r5 = this.calls.pop();
        seek(r5);
        return r5;
    }

    public void push(int r5) {
        if (this.calls != null) goto L5;
        this.calls = new IntArray();
    L5:
        this.calls.push(this.f631p);
        seek(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.misc.LookaheadStream, androidx.room.jarjarred.org.antlr.runtime.misc.FastQueue
    public Object remove() {
        Object r5 = super.remove();
        if (this.f631p == 0) goto L5;
    L7:
        return r5;
    L5:
        if (hasPositionInformation(this.prevElement) == false) goto L7;
        this.previousLocationElement = this.prevElement;
        goto L7
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public void replaceChildren(Object r5, int r10, int r11, Object r12) {
        if (r5 == null) goto L5;
        this.adaptor.replaceChildren(r5, r10, r11, r12);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.misc.LookaheadStream, androidx.room.jarjarred.org.antlr.runtime.misc.FastQueue
    public void reset() {
        super.reset();
        this.it.reset();
        this.hasNilRoot = false;
        this.level = 0;
        this.previousLocationElement = null;
        IntArray r5 = this.calls;
        if (r5 == null) goto L6;
        r5.clear();
        return;
    }

    public void setTokenStream(TokenStream r5) {
        this.tokens = r5;
    }

    public void setTreeAdaptor(TreeAdaptor r5) {
        this.adaptor = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public void setUniqueNavigationNodes(boolean r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public String toString(Object r5, Object r10) {
        return "n/a";
    }

    public String toTokenTypeString() {
        reset();
        StringBuilder r5 = new StringBuilder();
        Object r10 = LT(1);
        int r11 = this.adaptor.getType(r10);
    L4:
        if (r11 == (-1)) goto L7;
        r5.append(" ");
        r5.append(r11);
        consume();
        Object r12 = LT(1);
        r11 = this.adaptor.getType(r12);
        goto L4
    L7:
        return r5.toString();
    }

    public CommonTreeNodeStream(TreeAdaptor r5, Object r10) {
        this.hasNilRoot = false;
        this.level = 0;
        this.root = r10;
        this.adaptor = r5;
        this.it = new TreeIterator(r5, r10);
    }
}
