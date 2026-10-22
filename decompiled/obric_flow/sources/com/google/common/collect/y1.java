package com.google.common.collect;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class y1 extends q6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9228c;
    public final /* synthetic */ AbstractMap d;

    public /* synthetic */ y1(AbstractMap r5, int r10) {
        this.f9228c = r10;
        this.d = r5;
        super(r5);
    }

    @Override // com.google.common.collect.q6, java.lang.Iterable
    public void forEach(Consumer r5) {
        switch(this.f9228c) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.forEach(r5);
        return;
    L6:
        r5.getClass();
        CompactHashMap r10 = (CompactHashMap) this.d;
        Map r11 = r10.delegateOrNull();
        if (r11 == null) goto L9;
        r11.values().forEach(r5);
        return;
    L9:
        int r12 = r10.firstEntryIndex();
    L10:
        if (r12 < 0) goto L14;
        r5.accept(CompactHashMap.access$800(r10, r12));
        r12 = r10.getSuccessor(r12);
        goto L10
    }

    @Override // com.google.common.collect.q6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        switch(this.f9228c) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.iterator();
    L7:
        return ((CompactHashMap) this.d).valuesIterator();
    }

    @Override // com.google.common.collect.q6, java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object r5) {
        switch(this.f9228c) {
            case 1: goto L14;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        f9 r10 = (f9) this.d;
        Iterator r11 = r10.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (((Map) r12.getValue()).equals(r5) == false) goto L8;
        StandardTable.access$900((StandardTable) r10.e, r12.getKey());
        return true;
    L12:
        return false;
    L14:
        if (r5 == null) goto L18;
        com.google.common.base.z r13 = com.google.common.base.b0.v(com.google.common.base.b0.x(r5), Maps$EntryFunction.VALUE);
        if (((b9) this.d).d(r13) == false) goto L18;
        return true;
    L18:
        return false;
    L5:
        return super.remove(r5);
    }

    @Override // com.google.common.collect.q6, java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection r5) {
        switch(this.f9228c) {
            case 1: goto L13;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        r5.getClass();
        f9 r10 = (f9) this.d;
        Iterator r11 = p7.V(((StandardTable) r10.e).columnKeySet().iterator()).iterator();
        boolean r12 = false;
    L8:
        if (r11.hasNext() == false) goto L12;
        Object r13 = r11.next();
        if (r5.contains(((StandardTable) r10.e).column(r13)) == false) goto L8;
        StandardTable.access$900((StandardTable) r10.e, r13);
        r12 = true;
        goto L8
    L12:
        return r12;
    L13:
        com.google.common.base.z r14 = com.google.common.base.b0.v(com.google.common.base.b0.z(r5), Maps$EntryFunction.VALUE);
        return ((b9) this.d).d(r14);
    L5:
        return super.removeAll(r5);
    }

    @Override // com.google.common.collect.q6, java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection r5) {
        switch(this.f9228c) {
            case 1: goto L13;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        r5.getClass();
        f9 r10 = (f9) this.d;
        Iterator r11 = p7.V(((StandardTable) r10.e).columnKeySet().iterator()).iterator();
        boolean r12 = false;
    L8:
        if (r11.hasNext() == false) goto L12;
        Object r13 = r11.next();
        if (r5.contains(((StandardTable) r10.e).column(r13)) == true) goto L8;
        StandardTable.access$900((StandardTable) r10.e, r13);
        r12 = true;
        goto L8
    L12:
        return r12;
    L13:
        com.google.common.base.z r14 = com.google.common.base.b0.v(com.google.common.base.b0.B(com.google.common.base.b0.z(r5)), Maps$EntryFunction.VALUE);
        return ((b9) this.d).d(r14);
    L5:
        return super.retainAll(r5);
    }

    @Override // com.google.common.collect.q6, java.util.Collection, java.lang.Iterable
    public Spliterator spliterator() {
        switch(this.f9228c) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        CompactHashMap r5 = (CompactHashMap) this.d;
        if (r5.needsAllocArrays() == true) goto L14;
        Map r10 = r5.delegateOrNull();
        if (r10 == null) goto L13;
        return r10.values().spliterator();
    L13:
        return Spliterators.spliterator(CompactHashMap.access$1200(r5), 0, CompactHashMap.access$300(r5), 16);
    L14:
        return Spliterators.spliterator(new Object[0], 16);
    L5:
        return super.spliterator();
    }

    @Override // com.google.common.collect.q6, java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        switch(this.f9228c) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        CompactHashMap r5 = (CompactHashMap) this.d;
        if (r5.needsAllocArrays() == true) goto L17;
        Map r10 = r5.delegateOrNull();
        if (r10 != null) goto L18;
        Object[] r11 = CompactHashMap.access$1200(r5);
        int r12 = CompactHashMap.access$300(r5);
        com.google.common.base.b0.p(0, r12, r11.length);
        if (r12 == 0) goto L19;
        Object[] r13 = new Object[r12];
        System.arraycopy(r11, 0, r13, 0, r12);
        return r13;
    L19:
        return new Object[0];
    L18:
        return r10.values().toArray();
    L17:
        return new Object[0];
    L5:
        return super.toArray();
    }

    @Override // com.google.common.collect.q6, java.util.AbstractCollection, java.util.Collection
    public Object[] toArray(Object[] r5) {
        switch(this.f9228c) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        CompactHashMap r10 = (CompactHashMap) this.d;
        if (r10.needsAllocArrays() == true) goto L9;
        Map r11 = r10.delegateOrNull();
        if (r11 == null) goto L15;
        Object[] r12 = r11.values().toArray(r5);
    L18:
        return r12;
    L15:
        r12 = p7.t0(CompactHashMap.access$1200(r10), CompactHashMap.access$300(r10), r5);
        goto L18
    L9:
        if (r5.length <= 0) goto L16;
        r5[0] = null;
        return r5;
    L16:
        return r5;
    L5:
        return super.toArray(r5);
    }
}
