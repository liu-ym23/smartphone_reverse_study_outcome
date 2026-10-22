package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Converter$ReverseConverter<A, B> extends m implements Serializable {
    private static final long serialVersionUID = 0;
    final m original;

    public Converter$ReverseConverter(m r5) {
        this.original = r5;
    }

    @Override // com.google.common.base.m
    public B correctedDoBackward(A r5) {
        return (B) this.original.correctedDoForward(r5);
    }

    @Override // com.google.common.base.m
    public A correctedDoForward(B r5) {
        return (A) this.original.correctedDoBackward(r5);
    }

    @Override // com.google.common.base.m
    public B doBackward(A r5) {
        throw new AssertionError();
    }

    @Override // com.google.common.base.m
    public A doForward(B r5) {
        throw new AssertionError();
    }

    @Override // com.google.common.base.m, com.google.common.base.q
    public boolean equals(Object r5) {
        if ((r5 instanceof Converter$ReverseConverter) == true) goto L5;
        return false;
    L5:
        return this.original.equals(((Converter$ReverseConverter) r5).original);
    }

    public int hashCode() {
        return ~this.original.hashCode();
    }

    @Override // com.google.common.base.m
    public m reverse() {
        return this.original;
    }

    public String toString() {
        String r5 = String.valueOf(this.original);
        return androidx.room.jarjarred.org.antlr.runtime.a.l(r5.length() + 10, r5, ".reverse()");
    }
}
