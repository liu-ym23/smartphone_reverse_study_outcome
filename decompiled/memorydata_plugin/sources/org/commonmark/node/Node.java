package org.commonmark.node;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Node {
    public Map<String, Object> extraInfoMap;
    public Node firstChild;
    public Node lastChild;
    public Node next;
    public String originText;
    public Node parent;
    public Node prev;

    public Node() {
        this.parent = null;
        this.firstChild = null;
        this.lastChild = null;
        this.prev = null;
        this.next = null;
        this.originText = null;
        this.extraInfoMap = new HashMap();
    }

    public abstract void accept(Visitor r1);

    public void appendChild(Node r2) {
        r2.unlink();
        r2.setParent(this);
        Node r0 = this.lastChild;
        if (r0 == null) goto L5;
        r0.next = r2;
        r2.prev = r0;
    L6:
        this.lastChild = r2;
        return;
    L5:
        this.firstChild = r2;
        goto L6
    }

    public Node getFirstChild() {
        return this.firstChild;
    }

    public Node getLastChild() {
        return this.lastChild;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getParent() {
        return this.parent;
    }

    public Node getPrevious() {
        return this.prev;
    }

    public void insertAfter(Node r2) {
        r2.unlink();
        Node r0 = this.next;
        r2.next = r0;
        if (r0 == null) goto L5;
        r0.prev = r2;
    L5:
        r2.prev = this;
        this.next = r2;
        Node r1 = this.parent;
        r2.parent = r1;
        if (r2.next != null) goto L9;
        r1.lastChild = r2;
        return;
    }

    public void insertBefore(Node r2) {
        r2.unlink();
        Node r0 = this.prev;
        r2.prev = r0;
        if (r0 == null) goto L5;
        r0.next = r2;
    L5:
        r2.next = this;
        this.prev = r2;
        Node r1 = this.parent;
        r2.parent = r1;
        if (r2.prev != null) goto L9;
        r1.firstChild = r2;
        return;
    }

    public void setParent(Node r1) {
        this.parent = r1;
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + toStringAttributes() + "}";
    }

    public String toStringAttributes() {
        return "";
    }

    public void unlink() {
        Node r0 = this.prev;
        if (r0 == null) goto L5;
        r0.next = this.next;
    L8:
        Node r1 = this.next;
        if (r1 == null) goto L11;
        r1.prev = r0;
    L14:
        this.parent = null;
        this.next = null;
        this.prev = null;
        return;
    L11:
        Node r2 = this.parent;
        if (r2 == null) goto L14;
        r2.lastChild = r0;
        goto L14
    L5:
        Node r3 = this.parent;
        if (r3 == null) goto L8;
        r3.firstChild = this.next;
        goto L8
    }
}
