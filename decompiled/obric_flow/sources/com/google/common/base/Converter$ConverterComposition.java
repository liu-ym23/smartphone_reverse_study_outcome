package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Converter$ConverterComposition<A, B, C> extends m implements Serializable {
    private static final long serialVersionUID = 0;
    final m first;
    final m second;

    public Converter$ConverterComposition(m r5, m r10) {
        this.first = r5;
        this.second = r10;
    }

    @Override // com.google.common.base.m
    public A correctedDoBackward(C r5) {
        return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(r5));
    }

    @Override // com.google.common.base.m
    public C correctedDoForward(A r5) {
        return (C) this.second.correctedDoForward(this.first.correctedDoForward(r5));
    }

    @Override // com.google.common.base.m
    public A doBackward(C r5) {
        throw new AssertionError();
    }

    @Override // com.google.common.base.m
    public C doForward(A r5) {
        throw new AssertionError();
    }

    @Override // com.google.common.base.m, com.google.common.base.q
    public boolean equals(Object r5) {
        if ((r5 instanceof Converter$ConverterComposition) == false) goto L10;
        Converter$ConverterComposition r10 = (Converter$ConverterComposition) r5;
        if (this.first.equals(r10.first) == true) goto L7;
        return false;
    L7:
        if (this.second.equals(r10.second) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        int r5 = this.first.hashCode() * 31;
        return this.second.hashCode() + r5;
    }

    public String toString() {
        String r5 = String.valueOf(this.first);
        String r10 = String.valueOf(this.second);
        int r11 = r5.length() + 10;
        StringBuilder r12 = new StringBuilder(r10.length() + r11);
        r12.append(r5);
        r12.append(".andThen(");
        r12.append(r10);
        r12.append(")");
        return r12.toString();
    }
}
