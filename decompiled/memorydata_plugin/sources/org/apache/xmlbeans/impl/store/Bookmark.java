package org.apache.xmlbeans.impl.store;

/* JADX INFO: loaded from: classes7.dex */
class Bookmark {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    Object _key;
    Bookmark _next;
    int _pos;
    Bookmark _prev;
    Object _value;
    Xobj _xobj;

    static {
    }

    Bookmark() {
    }

    boolean isOnList(Bookmark r1) {
    L2:
        if (r1 == null) goto L7;
        if (r1 == this) goto L4;
        r1 = r1._next;
        goto L2
    L4:
        return true;
    L7:
        return false;
    }

    Bookmark listInsert(Bookmark r2) {
        if (r2 != null) goto L4;
        this._prev = this;
        return this;
    L4:
        this._prev = r2._prev;
        r2._prev._next = this;
        r2._prev = this;
        return r2;
    }

    Bookmark listRemove(Bookmark r4) {
        Bookmark r0 = this._prev;
        if (r0 != this) goto L5;
        r4 = null;
    L13:
        this._prev = null;
        return r4;
    L5:
        if (r4 != this) goto L7;
        r4 = this._next;
    L8:
        Bookmark r2 = this._next;
        if (r2 != null) goto L12;
        if (r4 == null) goto L13;
        r4._prev = r0;
        goto L13
    L12:
        r2._prev = r0;
        this._next = null;
        goto L13
    L7:
        r0._next = this._next;
        goto L8
    }

    void moveTo(Xobj r3, int r4) {
        Xobj r0 = this._xobj;
        if (r0 == r3) goto L5;
        r0._bookmarks = listRemove(r0._bookmarks);
        r3._bookmarks = listInsert(r3._bookmarks);
        this._xobj = r3;
    L5:
        this._pos = r4;
    }
}
