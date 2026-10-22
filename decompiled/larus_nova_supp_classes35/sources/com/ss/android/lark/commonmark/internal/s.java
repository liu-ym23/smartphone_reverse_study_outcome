package com.ss.android.lark.commonmark.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s implements z7b.a {
    public final char a;
    public int b;
    public final LinkedList<z7b.a> c;

    @Override // z7b.a
    public final int a() {
        return this.b;
    }

    @Override // z7b.a
    public final char b() {
        return this.a;
    }

    @Override // z7b.a
    public final char c() {
        return this.a;
    }

    public s(char r2) {
        this.b = 0;
        this.c = new LinkedList();
        this.a = r2;
    }

    public final void e(z7b.a r6) {
        int r0 = r6.a();
        ListIterator<z7b.a> r1 = this.c.listIterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        z7b.a r2 = r1.next();
        int r3 = r2.a();
        if (r0 > r3) goto L7;
        if (r0 != r3) goto L4;
        throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.a + "' and minimum length " + r0 + "; conflicting processors: " + r2 + ", " + r6);
    L7:
        r1.previous();
        r1.add(r6);
        boolean r4 = true;
    L13:
        if (r4 == true) goto L20;
        this.c.add(r6);
        this.b = r0;
        return;
    L20:
        return;
    L12:
        r4 = false;
        goto L13
    }

    @Override // z7b.a
    public final int d(f r5, f r6) {
        int r0 = r5.c();
        Iterator<z7b.a> r1 = this.c.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        z7b.a r2 = r1.next();
        if (r2.a() > r0) goto L4;
    L10:
        return r2.d(r5, r6);
    L8:
        r2 = this.c.getFirst();
        goto L10
    }
}
