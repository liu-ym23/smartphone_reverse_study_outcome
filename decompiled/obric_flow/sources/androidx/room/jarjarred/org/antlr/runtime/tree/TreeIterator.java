package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.misc.FastQueue;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TreeIterator implements Iterator<Object> {
    protected TreeAdaptor adaptor;
    public Object down;
    public Object eof;
    protected boolean firstTime;
    protected FastQueue<Object> nodes;
    protected Object root;
    protected Object tree;

    /* JADX INFO: renamed from: up, reason: collision with root package name */
    public Object f636up;

    public TreeIterator(Object r5) {
        this(new CommonTreeAdaptor(), r5);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.firstTime == true) goto L5;
        FastQueue<Object> r5 = this.nodes;
        if (r5 != null) goto L11;
    L13:
        Object r10 = this.tree;
        if (r10 != null) goto L17;
        return false;
    L17:
        if (this.adaptor.getChildCount(r10) <= 0) goto L20;
        return true;
    L20:
        if (this.adaptor.getParent(this.tree) != null) goto L22;
        return false;
    L22:
        return true;
    L11:
        if (r5.size() <= 0) goto L13;
        return true;
    L5:
        if (this.root != null) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (this.firstTime == false) goto L10;
        this.firstTime = false;
        if (this.adaptor.getChildCount(this.tree) != 0) goto L9;
        this.nodes.add(this.eof);
        return this.tree;
    L9:
        return this.tree;
    L10:
        FastQueue<Object> r5 = this.nodes;
        if (r5 != null) goto L13;
    L16:
        Object r10 = this.tree;
        if (r10 != null) goto L21;
        return this.eof;
    L21:
        if (this.adaptor.getChildCount(r10) <= 0) goto L24;
        Object r11 = this.adaptor.getChild(this.tree, 0);
        this.tree = r11;
        this.nodes.add(r11);
        return this.down;
    L24:
        Object r12 = this.adaptor.getParent(this.tree);
    L25:
        if (r12 == null) goto L29;
        if ((this.adaptor.getChildIndex(this.tree) + 1) < this.adaptor.getChildCount(r12)) goto L29;
        this.nodes.add(this.f636up);
        this.tree = r12;
        r12 = this.adaptor.getParent(r12);
    L29:
        if (r12 != null) goto L32;
        this.tree = null;
        this.nodes.add(this.eof);
        return this.nodes.remove();
    L32:
        int r13 = this.adaptor.getChildIndex(this.tree) + 1;
        Object r14 = this.adaptor.getChild(r12, r13);
        this.tree = r14;
        this.nodes.add(r14);
        return this.nodes.remove();
    L13:
        if (r5.size() <= 0) goto L16;
        return this.nodes.remove();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void reset() {
        this.firstTime = true;
        this.tree = this.root;
        this.nodes.clear();
    }

    public TreeIterator(TreeAdaptor r5, Object r10) {
        this.firstTime = true;
        this.adaptor = r5;
        this.tree = r10;
        this.root = r10;
        this.nodes = new FastQueue();
        this.down = r5.create(2, "DOWN");
        this.f636up = r5.create(3, "UP");
        this.eof = r5.create(-1, "EOF");
    }
}
