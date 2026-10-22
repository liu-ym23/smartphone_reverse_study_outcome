package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Converter$FunctionBasedConverter<A, B> extends m implements Serializable {
    private final q backwardFunction;
    private final q forwardFunction;

    public Converter$FunctionBasedConverter(q r5, q r10, l r11) {
        r5.getClass();
        this.forwardFunction = r5;
        r10.getClass();
        this.backwardFunction = r10;
    }

    @Override // com.google.common.base.m
    public A doBackward(B r5) {
        return (A) this.backwardFunction.apply(r5);
    }

    @Override // com.google.common.base.m
    public B doForward(A r5) {
        return (B) this.forwardFunction.apply(r5);
    }

    @Override // com.google.common.base.m, com.google.common.base.q
    public boolean equals(Object r5) {
        if ((r5 instanceof Converter$FunctionBasedConverter) == false) goto L10;
        Converter$FunctionBasedConverter r10 = (Converter$FunctionBasedConverter) r5;
        if (this.forwardFunction.equals(r10.forwardFunction) == true) goto L7;
        return false;
    L7:
        if (this.backwardFunction.equals(r10.backwardFunction) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        int r5 = this.forwardFunction.hashCode() * 31;
        return this.backwardFunction.hashCode() + r5;
    }

    public String toString() {
        String r5 = String.valueOf(this.forwardFunction);
        String r10 = String.valueOf(this.backwardFunction);
        int r11 = r5.length() + 18;
        StringBuilder r12 = new StringBuilder(r10.length() + r11);
        r12.append("Converter.from(");
        r12.append(r5);
        r12.append(", ");
        r12.append(r10);
        r12.append(")");
        return r12.toString();
    }
}
