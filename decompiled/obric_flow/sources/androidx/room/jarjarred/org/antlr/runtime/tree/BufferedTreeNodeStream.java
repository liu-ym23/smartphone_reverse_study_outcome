package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.misc.IntArray;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BufferedTreeNodeStream implements TreeNodeStream {
    public static final int DEFAULT_INITIAL_BUFFER_SIZE = 100;
    public static final int INITIAL_CALL_STACK_SIZE = 10;
    TreeAdaptor adaptor;
    protected IntArray calls;
    protected Object down;
    protected Object eof;
    protected int lastMarker;
    protected List<Object> nodes;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f633p;
    protected Object root;
    protected TokenStream tokens;
    protected boolean uniqueNavigationNodes;

    /* JADX INFO: renamed from: up, reason: collision with root package name */
    protected Object f634up;

    public class StreamIterator implements Iterator<Object> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f635i;
        final /* synthetic */ BufferedTreeNodeStream this$0;

        public StreamIterator(BufferedTreeNodeStream r5) {
            this.this$0 = r5;
            this.f635i = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f635i >= this.this$0.nodes.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            int r5 = this.f635i;
            this.f635i = r5 + 1;
            if (r5 >= this.this$0.nodes.size()) goto L7;
            return this.this$0.nodes.get(r5);
        L7:
            return this.this$0.eof;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new RuntimeException("cannot remove nodes from stream");
        }
    }

    public BufferedTreeNodeStream(Object r5) {
        this(new CommonTreeAdaptor(), r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int LA(int r5) {
        return this.adaptor.getType(LT(r5));
    }

    public Object LB(int r5) {
        if (r5 != 0) goto L5;
        return null;
    L5:
        int r10 = this.f633p;
        if ((r10 - r5) >= 0) goto L9;
        return null;
    L9:
        return this.nodes.get(r10 - r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public Object LT(int r5) {
        if (this.f633p != (-1)) goto L5;
        fillBuffer();
    L5:
        if (r5 != 0) goto L8;
        return null;
    L8:
        if (r5 >= 0) goto L12;
        return LB(-r5);
    L12:
        if (((this.f633p + r5) - 1) < this.nodes.size()) goto L16;
        return this.eof;
    L16:
        return this.nodes.get((this.f633p + r5) - 1);
    }

    public void addNavigationNode(int r5) {
        if (r5 != 2) goto L9;
        if (hasUniqueNavigationNodes() == false) goto L7;
        Object r10 = this.adaptor.create(2, "DOWN");
    L12:
        this.nodes.add(r10);
        return;
    L7:
        r10 = this.down;
        goto L12
    L9:
        if (hasUniqueNavigationNodes() == false) goto L11;
        r10 = this.adaptor.create(3, "UP");
        goto L12
    L11:
        r10 = this.f634up;
        goto L12
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void consume() {
        if (this.f633p != (-1)) goto L5;
        fillBuffer();
    L5:
        this.f633p++;
    }

    public void fillBuffer() {
        fillBuffer(this.root);
        this.f633p = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public Object get(int r5) {
        if (this.f633p != (-1)) goto L6;
        fillBuffer();
    L6:
        return this.nodes.get(r5);
    }

    public Object getCurrentSymbol() {
        return LT(1);
    }

    public int getNodeIndex(Object r5) {
        if (this.f633p != (-1)) goto L5;
        fillBuffer();
    L5:
        int r10 = 0;
    L7:
        if (r10 >= this.nodes.size()) goto L12;
        if (this.nodes.get(r10) == r5) goto L10;
        r10 = r10 + 1;
        goto L7
    L10:
        return r10;
    L12:
        return -1;
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

    public boolean hasUniqueNavigationNodes() {
        return this.uniqueNavigationNodes;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int index() {
        return this.f633p;
    }

    public Iterator<Object> iterator() {
        if (this.f633p != (-1)) goto L6;
        fillBuffer();
    L6:
        return new StreamIterator(this);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int mark() {
        if (this.f633p != (-1)) goto L5;
        fillBuffer();
    L5:
        int r5 = index();
        this.lastMarker = r5;
        return r5;
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
        this.calls.push(this.f633p);
        seek(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void release(int r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public void replaceChildren(Object r5, int r10, int r11, Object r12) {
        if (r5 == null) goto L5;
        this.adaptor.replaceChildren(r5, r10, r11, r12);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public void reset() {
        this.f633p = 0;
        this.lastMarker = 0;
        IntArray r5 = this.calls;
        if (r5 == null) goto L6;
        r5.clear();
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void rewind(int r5) {
        seek(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void seek(int r5) {
        if (this.f633p != (-1)) goto L5;
        fillBuffer();
    L5:
        this.f633p = r5;
    }

    public void setTokenStream(TokenStream r5) {
        this.tokens = r5;
    }

    public void setTreeAdaptor(TreeAdaptor r5) {
        this.adaptor = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public void setUniqueNavigationNodes(boolean r5) {
        this.uniqueNavigationNodes = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int size() {
        if (this.f633p != (-1)) goto L6;
        fillBuffer();
    L6:
        return this.nodes.size();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public String toString(Object r10, Object r11) {
        PrintStream r5 = System.out;
        r5.println("toString");
        if (r10 == null) goto L46;
        if (r11 != null) goto L7;
        return null;
    L7:
        if (this.f633p != (-1)) goto L10;
        fillBuffer();
    L10:
        if ((r10 instanceof CommonTree) == false) goto L12;
        r5.print("toString: " + ((CommonTree) r10).getToken() + ", ");
    L14:
        if ((r11 instanceof CommonTree) == false) goto L16;
        r5.println(((CommonTree) r11).getToken());
    L18:
        if (this.tokens == null) goto L27;
        int r12 = this.adaptor.getTokenStartIndex(r10);
        int r13 = this.adaptor.getTokenStopIndex(r11);
        if (this.adaptor.getType(r11) != 3) goto L23;
        r13 = this.adaptor.getTokenStopIndex(r10);
    L26:
        return this.tokens.toString(r12, r13);
    L23:
        if (this.adaptor.getType(r11) != (-1)) goto L26;
        r13 = size() - 2;
        goto L26
    L27:
        int r14 = 0;
    L29:
        if (r14 >= this.nodes.size()) goto L34;
        if (this.nodes.get(r14) == r10) goto L34;
        r14 = r14 + 1;
    L34:
        StringBuilder r15 = new StringBuilder();
        Object r16 = this.nodes.get(r14);
    L36:
        if (r16 == r11) goto L41;
        String r17 = this.adaptor.getText(r16);
        if (r17 != null) goto L40;
        r17 = " " + String.valueOf(this.adaptor.getType(r16));
    L40:
        r15.append(r17);
        r14 = r14 + 1;
        r16 = this.nodes.get(r14);
        goto L36
    L41:
        String r18 = this.adaptor.getText(r11);
        if (r18 != null) goto L44;
        r18 = " " + String.valueOf(this.adaptor.getType(r11));
    L44:
        r15.append(r18);
        return r15.toString();
    L16:
        r5.println(r11);
        goto L18
    L12:
        r5.println(r10);
        goto L14
    L46:
        return null;
    }

    public String toTokenString(int r5, int r10) {
        if (this.f633p != (-1)) goto L5;
        fillBuffer();
    L5:
        StringBuilder r11 = new StringBuilder();
    L7:
        if (r5 >= this.nodes.size()) goto L11;
        if (r5 > r10) goto L11;
        Object r12 = this.nodes.get(r5);
        r11.append(" ");
        r11.append(this.adaptor.getToken(r12));
        r5 = r5 + 1;
    L11:
        return r11.toString();
    }

    public String toTokenTypeString() {
        if (this.f633p != (-1)) goto L5;
        fillBuffer();
    L5:
        StringBuilder r5 = new StringBuilder();
        int r10 = 0;
    L7:
        if (r10 >= this.nodes.size()) goto L10;
        Object r11 = this.nodes.get(r10);
        r5.append(" ");
        r5.append(this.adaptor.getType(r11));
        r10 = r10 + 1;
        goto L7
    L10:
        return r5.toString();
    }

    public BufferedTreeNodeStream(TreeAdaptor r5, Object r10) {
        this(r5, r10, 100);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void rewind() {
        seek(this.lastMarker);
    }

    public BufferedTreeNodeStream(TreeAdaptor r5, Object r10, int r11) {
        this.uniqueNavigationNodes = false;
        this.f633p = -1;
        this.root = r10;
        this.adaptor = r5;
        this.nodes = new ArrayList(r11);
        this.down = r5.create(2, "DOWN");
        this.f634up = r5.create(3, "UP");
        this.eof = r5.create(-1, "EOF");
    }

    public void fillBuffer(Object r5) {
        boolean r10 = this.adaptor.isNil(r5);
        if (r10 == true) goto L5;
        this.nodes.add(r5);
    L5:
        int r11 = this.adaptor.getChildCount(r5);
        if (r10 == true) goto L9;
        if (r11 <= 0) goto L9;
        addNavigationNode(2);
    L9:
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L12;
        fillBuffer(this.adaptor.getChild(r5, r12));
        r12 = r12 + 1;
        goto L10
    L12:
        if (r10 == true) goto L17;
        if (r11 <= 0) goto L18;
        addNavigationNode(3);
        return;
    L18:
        return;
    }
}
