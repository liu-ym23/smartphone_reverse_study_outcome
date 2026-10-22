package androidx.room.jarjarred.org.antlr.runtime.tree;

/* JADX INFO: loaded from: classes.dex */
public class TreeVisitor {
    protected TreeAdaptor adaptor;

    public TreeVisitor(TreeAdaptor r5) {
        this.adaptor = r5;
    }

    public Object visit(Object r5, TreeVisitorAction r10) {
        boolean r11 = this.adaptor.isNil(r5);
        if (r10 == null) goto L6;
        if (r11 == true) goto L6;
        r5 = r10.pre(r5);
    L6:
        int r12 = 0;
    L8:
        if (r12 >= this.adaptor.getChildCount(r5)) goto L13;
        Object r13 = visit(this.adaptor.getChild(r5, r12), r10);
        if (r13 == this.adaptor.getChild(r5, r12)) goto L12;
        this.adaptor.setChild(r5, r12, r13);
    L12:
        r12 = r12 + 1;
        goto L8
    L13:
        if (r10 == null) goto L20;
        if (r11 == false) goto L16;
        return r5;
    L16:
        return r10.post(r5);
    L20:
        return r5;
    }

    public TreeVisitor() {
        this(new CommonTreeAdaptor());
    }
}
