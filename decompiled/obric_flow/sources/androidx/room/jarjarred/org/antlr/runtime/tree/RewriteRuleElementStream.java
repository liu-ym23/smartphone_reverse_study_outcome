package androidx.room.jarjarred.org.antlr.runtime.tree;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class RewriteRuleElementStream {
    protected TreeAdaptor adaptor;
    protected int cursor;
    protected boolean dirty;
    protected String elementDescription;
    protected List<Object> elements;
    protected Object singleElement;

    public RewriteRuleElementStream(TreeAdaptor r5, String r10) {
        this.cursor = 0;
        this.dirty = false;
        this.elementDescription = r10;
        this.adaptor = r5;
    }

    public Object _next() {
        int r5 = size();
        if (r5 == 0) goto L18;
        int r10 = this.cursor;
        if (r10 < r5) goto L11;
        if (r5 != 1) goto L10;
        return toTree(this.singleElement);
    L10:
        throw new RewriteCardinalityException(this.elementDescription);
    L11:
        Object r11 = this.singleElement;
        if (r11 == null) goto L15;
        this.cursor = r10 + 1;
        return toTree(r11);
    L15:
        Object r12 = toTree(this.elements.get(r10));
        this.cursor++;
        return r12;
    L18:
        throw new RewriteEmptyStreamException(this.elementDescription);
    }

    public void add(Object r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        List<Object> r10 = this.elements;
        if (r10 == null) goto L9;
        r10.add(r5);
        return;
    L9:
        if (this.singleElement != null) goto L12;
        this.singleElement = r5;
        return;
    L12:
        ArrayList r11 = new ArrayList(5);
        this.elements = r11;
        r11.add(this.singleElement);
        this.singleElement = null;
        this.elements.add(r5);
    }

    public abstract Object dup(Object r5);

    public String getDescription() {
        return this.elementDescription;
    }

    public boolean hasNext() {
        if (this.singleElement != null) goto L5;
    L6:
        List<Object> r5 = this.elements;
        if (r5 != null) goto L9;
    L11:
        return false;
    L9:
        if (this.cursor >= r5.size()) goto L11;
        return true;
    L5:
        if (this.cursor >= 1) goto L6;
        return true;
    }

    public Object nextTree() {
        int r5 = size();
        if (this.dirty == true) goto L12;
        if (this.cursor < r5) goto L10;
        if (r5 == 1) goto L12;
    L10:
        return _next();
    L12:
        return dup(_next());
    }

    public void reset() {
        this.cursor = 0;
        this.dirty = true;
    }

    public int size() {
        if (this.singleElement == null) goto L5;
        int r5 = 1;
    L6:
        List<Object> r10 = this.elements;
        if (r10 != null) goto L9;
        return r5;
    L9:
        return r10.size();
    L5:
        r5 = 0;
        goto L6
    }

    public Object toTree(Object r5) {
        return r5;
    }

    public RewriteRuleElementStream(TreeAdaptor r5, String r10, Object r11) {
        this(r5, r10);
        add(r11);
    }

    public RewriteRuleElementStream(TreeAdaptor r5, String r10, List<Object> r11) {
        this(r5, r10);
        this.singleElement = null;
        this.elements = r11;
    }
}
