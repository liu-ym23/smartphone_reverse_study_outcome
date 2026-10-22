package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class Functions$FunctionComposition<A, B, C> implements q, Serializable {
    private static final long serialVersionUID = 0;
    private final q f;
    private final q g;

    public Functions$FunctionComposition(q r5, q r10) {
        r5.getClass();
        this.g = r5;
        r10.getClass();
        this.f = r10;
    }

    @Override // java.util.function.Function
    public C apply(A r5) {
        return (C) this.g.apply(this.f.apply(r5));
    }

    @Override // com.google.common.base.q
    public boolean equals(Object r5) {
        if ((r5 instanceof Functions$FunctionComposition) == false) goto L10;
        Functions$FunctionComposition r10 = (Functions$FunctionComposition) r5;
        if (this.f.equals(r10.f) == true) goto L7;
        return false;
    L7:
        if (this.g.equals(r10.g) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        int r5 = this.f.hashCode();
        return this.g.hashCode() ^ r5;
    }

    public String toString() {
        String r5 = String.valueOf(this.g);
        String r10 = String.valueOf(this.f);
        int r11 = r5.length() + 2;
        StringBuilder r12 = new StringBuilder(r10.length() + r11);
        r12.append(r5);
        r12.append("(");
        r12.append(r10);
        r12.append(")");
        return r12.toString();
    }
}
