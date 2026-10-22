package com.google.common.hash;

import java.io.Serializable;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
class Funnels$StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
    private final Charset charset;

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String charsetCanonicalName;

        public SerializedForm(Charset r5) {
            this.charsetCanonicalName = r5.name();
        }

        private Object readResolve() {
            return new Funnels$StringCharsetFunnel(Charset.forName(this.charsetCanonicalName));
        }
    }

    public Funnels$StringCharsetFunnel(Charset r5) {
        r5.getClass();
        this.charset = r5;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Funnels$StringCharsetFunnel) == true) goto L5;
        return false;
    L5:
        return this.charset.equals(((Funnels$StringCharsetFunnel) r5).charset);
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(CharSequence r5, z r10) {
        funnel2(r5, r10);
    }

    public int hashCode() {
        int r5 = Funnels$StringCharsetFunnel.class.hashCode();
        return this.charset.hashCode() ^ r5;
    }

    public String toString() {
        String r5 = this.charset.name();
        return androidx.room.jarjarred.org.antlr.runtime.a.m(androidx.room.jarjarred.org.antlr.runtime.a.g(22, r5), "Funnels.stringFunnel(", r5, ")");
    }

    public Object writeReplace() {
        return new SerializedForm(this.charset);
    }

    /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
    public void funnel2(CharSequence r5, z r10) {
        r10.b(r5, this.charset);
    }
}
