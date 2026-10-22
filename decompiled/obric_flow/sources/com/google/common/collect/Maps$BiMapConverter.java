package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Maps$BiMapConverter<A, B> extends com.google.common.base.m implements Serializable {
    private static final long serialVersionUID = 0;
    private final c1 bimap;

    public Maps$BiMapConverter(c1 r5) {
        r5.getClass();
        this.bimap = r5;
    }

    @Override // com.google.common.base.m
    public A doBackward(B r5) {
        A r10 = (A) this.bimap.inverse().get(r5);
        if (r10 == null) goto L5;
        boolean r11 = true;
    L6:
        com.google.common.base.b0.h("No non-null mapping present for input: %s", r11, r5);
        return r10;
    L5:
        r11 = false;
        goto L6
    }

    @Override // com.google.common.base.m
    public B doForward(A r5) {
        B r10 = (B) this.bimap.get(r5);
        if (r10 == null) goto L5;
        boolean r11 = true;
    L6:
        com.google.common.base.b0.h("No non-null mapping present for input: %s", r11, r5);
        return r10;
    L5:
        r11 = false;
        goto L6
    }

    @Override // com.google.common.base.m, com.google.common.base.q
    public boolean equals(Object r5) {
        if ((r5 instanceof Maps$BiMapConverter) == true) goto L5;
        return false;
    L5:
        return this.bimap.equals(((Maps$BiMapConverter) r5).bimap);
    }

    public int hashCode() {
        return this.bimap.hashCode();
    }

    public String toString() {
        String r5 = String.valueOf(this.bimap);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 18, "Maps.asConverter(", r5, ")");
    }
}
