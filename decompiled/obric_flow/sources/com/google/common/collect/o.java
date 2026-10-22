package com.google.common.collect;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class o extends a9 {
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ o(AbstractMap r5, int r10) {
        this.d = r10;
        this.e = r5;
        super(r5);
    }

    @Override // com.google.common.collect.a9, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch(this.d) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.clear();
        return;
    L6:
        p7.u(iterator());
    }

    @Override // com.google.common.collect.a9, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        switch(this.d) {
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        b9 r10 = (b9) this.e;
        return r10.e.contains(r5, r10.d);
    L5:
        return super.contains(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection r5) {
        switch(this.d) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.containsAll(r5);
    L7:
        return ((Map) this.f8898c).keySet().containsAll(r5);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object r5) {
        switch(this.d) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        if (this != r5) goto L8;
    L11:
        return true;
    L8:
        if (((Map) this.f8898c).keySet().equals(r5) == true) goto L11;
        return false;
    L5:
        return super.equals(r5);
    }

    @Override // com.google.common.collect.a9, java.lang.Iterable
    public void forEach(Consumer r5) {
        switch(this.d) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.forEach(r5);
        return;
    L6:
        r5.getClass();
        CompactHashMap r10 = (CompactHashMap) this.e;
        Map r11 = r10.delegateOrNull();
        if (r11 == null) goto L9;
        r11.keySet().forEach(r5);
        return;
    L9:
        int r12 = r10.firstEntryIndex();
    L10:
        if (r12 < 0) goto L14;
        r5.accept(CompactHashMap.access$100(r10, r12));
        r12 = r10.getSuccessor(r12);
        goto L10
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        switch(this.d) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.hashCode();
    L7:
        return ((Map) this.f8898c).keySet().hashCode();
    }

    @Override // com.google.common.collect.a9, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        switch(this.d) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.iterator();
    L7:
        return ((CompactHashMap) this.e).keySetIterator();
    L9:
        return new m(this, ((Map) this.f8898c).entrySet().iterator());
    }

    @Override // com.google.common.collect.a9, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r5) {
        switch(this.d) {
            case 0: goto L17;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        b9 r10 = (b9) this.e;
        if (r10.e.remove(r5, r10.d) == null) goto L7;
        return true;
    L7:
        return false;
    L9:
        CompactHashMap r11 = (CompactHashMap) this.e;
        Map r12 = r11.delegateOrNull();
        if (r12 == null) goto L13;
        return r12.keySet().remove(r5);
    L13:
        if (CompactHashMap.access$400(r11, r5) == CompactHashMap.access$500()) goto L15;
        return true;
    L15:
        return false;
    L17:
        Collection r13 = (Collection) ((Map) this.f8898c).remove(r5);
        if (r13 == null) goto L20;
        int r14 = r13.size();
        r13.clear();
        AbstractMapBasedMultimap.access$220((AbstractMapBasedMultimap) this.e, r14);
    L21:
        if (r14 <= 0) goto L27;
        return true;
    L27:
        return false;
    L20:
        r14 = 0;
        goto L21
    }

    @Override // com.google.common.collect.a9, com.google.common.collect.j6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection r5) {
        switch(this.d) {
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        com.google.common.base.z r10 = com.google.common.base.b0.v(com.google.common.base.b0.B(com.google.common.base.b0.z(r5)), Maps$EntryFunction.KEY);
        return ((b9) this.e).d(r10);
    L5:
        return super.retainAll(r5);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator spliterator() {
        switch(this.d) {
            case 0: goto L15;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        CompactHashMap r5 = (CompactHashMap) this.e;
        if (r5.needsAllocArrays() == true) goto L16;
        Map r10 = r5.delegateOrNull();
        if (r10 == null) goto L13;
        return r10.keySet().spliterator();
    L13:
        return Spliterators.spliterator(CompactHashMap.access$200(r5), 0, CompactHashMap.access$300(r5), 17);
    L16:
        return Spliterators.spliterator(new Object[0], 17);
    L5:
        return super.spliterator();
    L15:
        return ((Map) this.f8898c).keySet().spliterator();
    }

    @Override // com.google.common.collect.j6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        switch(this.d) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        CompactHashMap r5 = (CompactHashMap) this.e;
        if (r5.needsAllocArrays() == true) goto L17;
        Map r10 = r5.delegateOrNull();
        if (r10 != null) goto L18;
        Object[] r11 = CompactHashMap.access$200(r5);
        int r12 = CompactHashMap.access$300(r5);
        com.google.common.base.b0.p(0, r12, r11.length);
        if (r12 == 0) goto L19;
        Object[] r13 = new Object[r12];
        System.arraycopy(r11, 0, r13, 0, r12);
        return r13;
    L19:
        return new Object[0];
    L18:
        return r10.keySet().toArray();
    L17:
        return new Object[0];
    L5:
        return super.toArray();
    }

    public o(AbstractMapBasedMultimap r5, Map r10) {
        this.d = 0;
        this.e = r5;
        super(r10);
    }

    @Override // com.google.common.collect.j6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] r5) {
        switch(this.d) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        CompactHashMap r10 = (CompactHashMap) this.e;
        if (r10.needsAllocArrays() == true) goto L9;
        Map r11 = r10.delegateOrNull();
        if (r11 == null) goto L15;
        Object[] r12 = r11.keySet().toArray(r5);
    L18:
        return r12;
    L15:
        r12 = p7.t0(CompactHashMap.access$200(r10), CompactHashMap.access$300(r10), r5);
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
