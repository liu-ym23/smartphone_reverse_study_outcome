package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class b4 extends ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8905b;

    public b4(ImmutableMapValues r5) {
        this.f8904a = 0;
        this.f8905b = ImmutableMapValues.access$000(r5).entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch(this.f8904a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return !((PriorityQueue) this.f8905b).isEmpty();
    L7:
        return ((ga) this.f8905b).hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch(this.f8904a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        PriorityQueue r5 = (PriorityQueue) this.f8905b;
        j5 r10 = (j5) r5.remove();
        Object r11 = r10.next();
        if (r10.hasNext() == false) goto L7;
        r5.add(r10);
    L7:
        return r11;
    L9:
        return ((Map.Entry) ((ga) this.f8905b).next()).getValue();
    }

    public b4(a5 r5, final Comparator r10) {
        this.f8904a = 1;
        this.f8905b = new PriorityQueue(2, new i5(r10));
        Iterator r11 = r5.iterator();
    L3:
        s9 r12 = (s9) r11;
        if (r12.f9159a.hasNext() == false) goto L8;
        Iterator r13 = (Iterator) r12.next();
        if (r13.hasNext() == false) goto L3;
        ((PriorityQueue) this.f8905b).add(p7.b0(r13));
        goto L3
    }
}
