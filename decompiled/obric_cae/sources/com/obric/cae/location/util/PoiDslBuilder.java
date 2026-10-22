package com.obric.cae.location.util;

import ha.j;
import ha.m;
import ha.s;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PoiDslBuilder {
    private final m conds;
    private String op;

    public PoiDslBuilder() {
        this.conds = new m();
        this.op = "and";
    }

    public PoiDslBuilder addTerm(String r8, String r10) {
        if (r8 == null) goto L6;
        if (r10 == null) goto L6;
        m r11 = new m();
        r11.m(r10);
        s r12 = new s();
        r12.k("conds", r11);
        r12.n("field", r8);
        r12.n("op", "terms");
        this.conds.k(r12);
    L6:
        return this;
    }

    public PoiDslBuilder addTerms(String r8, List<String> r10) {
        if (r8 == null) goto L12;
        if (r10 == null) goto L12;
        if (r10.isEmpty() == true) goto L12;
        m r11 = new m();
        Iterator<String> r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        r11.m(r12.next());
        goto L9
    L11:
        s r13 = new s();
        r13.k("conds", r11);
        r13.n("field", r8);
        r13.n("op", "terms");
        this.conds.k(r13);
    L12:
        return this;
    }

    public String build() {
        return new j().i(buildJson());
    }

    public s buildJson() {
        s r8 = new s();
        r8.k("conds", this.conds);
        r8.n("op", this.op);
        s r10 = new s();
        r10.k("filter", r8);
        return r10;
    }

    public PoiDslBuilder setOp(String r8) {
        if (r8 != null) goto L4;
    L6:
        return this;
    L4:
        if (r8.isEmpty() == true) goto L6;
        this.op = r8;
        goto L6
    }
}
