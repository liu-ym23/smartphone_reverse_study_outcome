package androidx.room.jarjarred.org.antlr.runtime.tree;

import ai.j0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseTree implements Tree {
    protected List<Object> children;

    public BaseTree() {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public void addChild(Tree r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        BaseTree r10 = (BaseTree) r5;
        if (r10.isNil() == false) goto L21;
        List<Object> r11 = this.children;
        if (r11 != null) goto L9;
    L13:
        List<Object> r12 = r10.children;
        if (r12 == null) goto L26;
        if (r11 == null) goto L19;
        int r13 = r12.size();
        int r14 = 0;
    L17:
        if (r14 >= r13) goto L28;
        Tree r15 = (Tree) r10.children.get(r14);
        this.children.add(r15);
        r15.setParent(this);
        r15.setChildIndex(this.children.size() - 1);
        r14 = r14 + 1;
        goto L17
    L28:
        return;
    L19:
        this.children = r12;
        freshenParentAndChildIndexes();
        return;
    L26:
        return;
    L9:
        if (r11 != r10.children) goto L13;
        throw new RuntimeException("attempt to add child list to itself");
    L21:
        if (this.children != null) goto L23;
        this.children = createChildrenList();
    L23:
        this.children.add(r5);
        r10.setParent(this);
        r10.setChildIndex(this.children.size() - 1);
    }

    public void addChildren(List<? extends Tree> r5) {
        int r10 = 0;
    L4:
        if (r10 >= r5.size()) goto L6;
        addChild(r5.get(r10));
        r10 = r10 + 1;
        goto L4
    }

    public List<Object> createChildrenList() {
        return new ArrayList();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public Object deleteChild(int r5) {
        List<Object> r10 = this.children;
        if (r10 != null) goto L6;
        return null;
    L6:
        Tree r11 = (Tree) r10.remove(r5);
        freshenParentAndChildIndexes(r5);
        return r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public void freshenParentAndChildIndexes() {
        freshenParentAndChildIndexes(0);
    }

    public void freshenParentAndChildIndexesDeeply() {
        freshenParentAndChildIndexesDeeply(0);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public Tree getAncestor(int r5) {
        Tree r10 = getParent();
    L3:
        if (r10 == null) goto L8;
        if (r10.getType() == r5) goto L6;
        r10 = r10.getParent();
        goto L3
    L6:
        return r10;
    L8:
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public List<? extends Tree> getAncestors() {
        if (getParent() != null) goto L6;
        return null;
    L6:
        ArrayList r5 = new ArrayList();
        Tree r10 = getParent();
    L7:
        if (r10 == null) goto L9;
        r5.add(0, r10);
        r10 = r10.getParent();
        goto L7
    L9:
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getCharPositionInLine() {
        return 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public Tree getChild(int r5) {
        List<Object> r10 = this.children;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r5 < r10.size()) goto L8;
        return null;
    L8:
        return (Tree) this.children.get(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getChildCount() {
        List<Object> r5 = this.children;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.size();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getChildIndex() {
        return 0;
    }

    public List<? extends Object> getChildren() {
        return this.children;
    }

    public Tree getFirstChildWithType(int r5) {
        int r10 = 0;
    L3:
        List<Object> r11 = this.children;
        if (r11 == null) goto L11;
        if (r10 >= r11.size()) goto L16;
        Tree r12 = (Tree) this.children.get(r10);
        if (r12.getType() == r5) goto L9;
        r10 = r10 + 1;
        goto L3
    L9:
        return r12;
    L16:
        return null;
    L11:
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getLine() {
        return 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public Tree getParent() {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public boolean hasAncestor(int r5) {
        if (getAncestor(r5) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void insertChild(int r5, Object r10) {
        if (r5 < 0) goto L11;
        if (r5 > getChildCount()) goto L11;
        if (this.children != null) goto L8;
        this.children = createChildrenList();
    L8:
        this.children.add(r5, r10);
        freshenParentAndChildIndexes(r5);
        return;
    L11:
        throw new IndexOutOfBoundsException(r5 + " out or range");
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public boolean isNil() {
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public void replaceChildren(int r10, int r11, Object r12) {
        if (this.children == null) goto L26;
        int r5 = (r11 - r10) + 1;
        BaseTree r13 = (BaseTree) r12;
        if (r13.isNil() == false) goto L7;
        List<Object> r14 = r13.children;
    L8:
        int r15 = r14.size();
        int r16 = r14.size();
        int r17 = r5 - r15;
        int r18 = 0;
        if (r17 != 0) goto L12;
    L10:
        if (r10 > r11) goto L33;
        BaseTree r19 = (BaseTree) r14.get(r18);
        this.children.set(r10, r19);
        r19.setParent(this);
        r19.setChildIndex(r10);
        r18 = r18 + 1;
        r10 = r10 + 1;
        goto L10
    L33:
        return;
    L12:
        if (r17 <= 0) goto L19;
    L13:
        if (r18 >= r16) goto L15;
        this.children.set(r10 + r18, r14.get(r18));
        r18 = r18 + 1;
        goto L13
    L15:
        int r20 = r16 + r10;
        int r21 = r20;
    L16:
        if (r21 > r11) goto L18;
        this.children.remove(r20);
        r21 = r21 + 1;
        goto L16
    L18:
        freshenParentAndChildIndexes(r10);
        return;
    L19:
        if (r18 >= r5) goto L21;
        this.children.set(r10 + r18, r14.get(r18));
        r18 = r18 + 1;
    L21:
        if (r5 >= r15) goto L23;
        this.children.add(r10 + r5, r14.get(r5));
        r5 = r5 + 1;
        goto L21
    L23:
        freshenParentAndChildIndexes(r10);
        return;
    L7:
        ArrayList r22 = new ArrayList(1);
        r22.add(r13);
        r14 = r22;
        goto L8
    L26:
        throw new IllegalArgumentException("indexes invalid; no children in list");
    }

    public void sanityCheckParentAndChildIndexes() {
        sanityCheckParentAndChildIndexes(null, -1);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public void setChild(int r5, Tree r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isNil() == true) goto L12;
        if (this.children != null) goto L9;
        this.children = createChildrenList();
    L9:
        this.children.set(r5, r10);
        r10.setParent(this);
        r10.setChildIndex(r5);
        return;
    L12:
        throw new IllegalArgumentException("Can't set single child to a list");
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public void setChildIndex(int r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public void setParent(Tree r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public abstract String toString();

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public String toStringTree() {
        List<Object> r5 = this.children;
        if (r5 == null) goto L25;
        if (r5.isEmpty() == true) goto L25;
        StringBuilder r10 = new StringBuilder();
        if (isNil() == true) goto L10;
        r10.append("(");
        r10.append(toString());
        r10.append(' ');
    L10:
        int r11 = 0;
    L11:
        List<Object> r12 = this.children;
        if (r12 == null) goto L20;
        if (r11 >= r12.size()) goto L20;
        Tree r13 = (Tree) this.children.get(r11);
        if (r11 <= 0) goto L18;
        r10.append(' ');
    L18:
        r10.append(r13.toStringTree());
        r11 = r11 + 1;
    L20:
        if (isNil() == true) goto L23;
        r10.append(")");
    L23:
        return r10.toString();
    L25:
        return toString();
    }

    public BaseTree(Tree r5) {
    }

    public void freshenParentAndChildIndexes(int r5) {
        int r10 = getChildCount();
    L3:
        if (r5 >= r10) goto L5;
        Tree r11 = getChild(r5);
        r11.setChildIndex(r5);
        r11.setParent(this);
        r5 = r5 + 1;
        goto L3
    }

    public void freshenParentAndChildIndexesDeeply(int r5) {
        int r10 = getChildCount();
    L3:
        if (r5 >= r10) goto L5;
        BaseTree r11 = (BaseTree) getChild(r5);
        r11.setChildIndex(r5);
        r11.setParent(this);
        r11.freshenParentAndChildIndexesDeeply();
        r5 = r5 + 1;
        goto L3
    }

    public void sanityCheckParentAndChildIndexes(Tree r5, int r10) {
        if (r5 != getParent()) goto L13;
        if (r10 != getChildIndex()) goto L10;
        int r11 = getChildCount();
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L9;
        ((CommonTree) getChild(r12)).sanityCheckParentAndChildIndexes(this, r12);
        r12 = r12 + 1;
        goto L7
    L9:
        return;
    L10:
        StringBuilder r13 = j0.s(r10, "child indexes don't match; expected ", " found ");
        r13.append(getChildIndex());
        throw new IllegalStateException(r13.toString());
    L13:
        throw new IllegalStateException("parents don't match; expected " + r5 + " found " + getParent());
    }
}
