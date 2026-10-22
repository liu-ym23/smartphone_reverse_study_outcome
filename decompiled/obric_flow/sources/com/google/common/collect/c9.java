package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c9 extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8929c;
    public Object d;
    public final Iterator e;
    public Object f;

    public c9(b4 r5, Comparator r10) {
        this.f8929c = 1;
        this.e = r5;
        this.f = r10;
    }

    @Override // com.google.common.collect.g
    public final Object a() {
        switch(this.f8929c) {
            case 0: goto L23;
            case 1: goto L12;
            default: goto L4;
        };
    L4:
        Iterator r5 = this.e;
        if (r5.hasNext() == true) goto L7;
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L7:
        Range r10 = (Range) r5.next();
        Object r11 = r10.lowerBound;
        if (((Cut) this.d).isLessThan(r11) == false) goto L10;
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L10:
        Range r12 = r10.intersection(((fa) this.f).f8979b);
        return new ImmutableEntry(r12.lowerBound, r12);
    L12:
        b4 r13 = (b4) this.e;
        if (r13.hasNext() == false) goto L20;
        Object r14 = r13.next();
        Object r15 = this.d;
        if (r15 == null) goto L19;
        if (((Comparator) this.f).compare(r14, r15) == 0) goto L12;
    L19:
        this.d = r14;
        return r14;
    L20:
        this.d = null;
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L23:
        if (((Iterator) this.f).hasNext() == true) goto L24;
        Iterator r16 = this.e;
        if (r16.hasNext() == false) goto L30;
        this.f = ((Map) r16.next()).entrySet().iterator();
        goto L23
    L30:
        this.f8981a = AbstractIterator$State.DONE;
        return null;
    L24:
        Map.Entry r17 = (Map.Entry) ((Iterator) this.f).next();
        Object r18 = r17.getKey();
        Map r19 = (Map) this.d;
        if (r19.containsKey(r18) == true) goto L23;
        r19.put(r17.getKey(), r17.getValue());
        return r17.getKey();
    }

    public c9(StandardTable r5) {
        this.f8929c = 0;
        this.d = (Map) r5.factory.get();
        this.e = r5.backingMap.values().iterator();
        this.f = g5.d;
    }

    public c9(fa r5, Iterator r10, Cut r11) {
        this.f8929c = 2;
        this.f = r5;
        this.e = r10;
        this.d = r11;
    }
}
