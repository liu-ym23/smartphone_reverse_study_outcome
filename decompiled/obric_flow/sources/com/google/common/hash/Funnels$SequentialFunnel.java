package com.google.common.hash;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class Funnels$SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
    private final Funnel<E> elementFunnel;

    public Funnels$SequentialFunnel(Funnel<E> r5) {
        r5.getClass();
        this.elementFunnel = r5;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Funnels$SequentialFunnel) == true) goto L5;
        return false;
    L5:
        return this.elementFunnel.equals(((Funnels$SequentialFunnel) r5).elementFunnel);
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(Object r5, z r10) {
        funnel((Iterable) r5, r10);
    }

    public int hashCode() {
        int r5 = Funnels$SequentialFunnel.class.hashCode();
        return this.elementFunnel.hashCode() ^ r5;
    }

    public String toString() {
        String r5 = String.valueOf(this.elementFunnel);
        return androidx.room.jarjarred.org.antlr.runtime.a.m(r5.length() + 26, "Funnels.sequentialFunnel(", r5, ")");
    }

    public void funnel(Iterable<? extends E> r5, z r10) {
        Iterator<? extends E> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        E r12 = r11.next();
        this.elementFunnel.funnel(r12, r10);
        goto L4
    }
}
