package androidx.room.jarjarred.org.antlr.runtime.debug;

import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream;

/* JADX INFO: loaded from: classes.dex */
public class DebugTreeNodeStream implements TreeNodeStream {
    protected TreeAdaptor adaptor;
    protected DebugEventListener dbg;
    protected boolean initialStreamState;
    protected TreeNodeStream input;
    protected int lastMarker;

    public DebugTreeNodeStream(TreeNodeStream r5, DebugEventListener r10) {
        this.initialStreamState = true;
        this.input = r5;
        this.adaptor = r5.getTreeAdaptor();
        this.input.setUniqueNavigationNodes(true);
        setDebugListener(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int LA(int r5) {
        Object r10 = this.input.LT(r5);
        this.adaptor.getUniqueID(r10);
        this.adaptor.getText(r10);
        int r11 = this.adaptor.getType(r10);
        this.dbg.LT(r5, r10);
        return r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public Object LT(int r5) {
        Object r10 = this.input.LT(r5);
        this.adaptor.getUniqueID(r10);
        this.adaptor.getText(r10);
        this.adaptor.getType(r10);
        this.dbg.LT(r5, r10);
        return r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void consume() {
        Object r5 = this.input.LT(1);
        this.input.consume();
        this.dbg.consumeNode(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public Object get(int r5) {
        return this.input.get(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public String getSourceName() {
        return getTokenStream().getSourceName();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public TokenStream getTokenStream() {
        return this.input.getTokenStream();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public TreeAdaptor getTreeAdaptor() {
        return this.adaptor;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public Object getTreeSource() {
        return this.input;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int index() {
        return this.input.index();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int mark() {
        int r5 = this.input.mark();
        this.lastMarker = r5;
        this.dbg.mark(r5);
        return this.lastMarker;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void release(int r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public void replaceChildren(Object r5, int r10, int r11, Object r12) {
        this.input.replaceChildren(r5, r10, r11, r12);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public void reset() {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void rewind(int r5) {
        this.dbg.rewind(r5);
        this.input.rewind(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void seek(int r5) {
        this.input.seek(r5);
    }

    public void setDebugListener(DebugEventListener r5) {
        this.dbg = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public void setUniqueNavigationNodes(boolean r5) {
        this.input.setUniqueNavigationNodes(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int size() {
        return this.input.size();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream
    public String toString(Object r5, Object r10) {
        return this.input.toString(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void rewind() {
        this.dbg.rewind();
        this.input.rewind(this.lastMarker);
    }
}
