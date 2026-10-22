package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class d9 extends j6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StandardTable f8944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8945c;
    public final /* synthetic */ Object d;

    public d9(StandardTable r5, byte r10) {
        this.f8944b = r5;
        super(1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f8944b.backingMap.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r5) {
        switch(this.f8945c) {
            case 0: goto L29;
            case 1: goto L18;
            default: goto L5;
        };
    L5:
        if ((r5 instanceof Map.Entry) == false) goto L32;
        Map.Entry r10 = (Map.Entry) r5;
        if (r10.getKey() != null) goto L9;
        return false;
    L9:
        if ((r10.getValue() instanceof Map) == false) goto L34;
        Set r11 = ((StandardTable) ((f9) this.d).e).backingMap.entrySet();
        r11.getClass();
        boolean r12 = r11.contains(r10);     // Catch: Throwable -> L13
    L14:
        if (r12 == false) goto L35;
        return true;
    L35:
        return false;
    L13:
        r12 = false;
        goto L14
    L34:
        return false;
    L32:
        return false;
    L18:
        if ((r5 instanceof Map.Entry) == false) goto L26;
        Map.Entry r13 = (Map.Entry) r5;
        f9 r14 = (f9) this.d;
        if (((StandardTable) r14.e).containsColumn(r13.getKey()) == false) goto L26;
        Object r15 = r13.getKey();
        StandardTable r16 = (StandardTable) r14.e;
        if (r16.containsColumn(r15) == false) goto L24;
        Objects.requireNonNull(r15);
        Map r17 = r16.column(r15);
    L25:
        Objects.requireNonNull(r17);
        return r17.equals(r13.getValue());
    L24:
        r17 = null;
    L26:
        return false;
    L29:
        return ((StandardTable) this.d).containsColumn(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f8944b.backingMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch(this.f8945c) {
            case 0: goto L9;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Set r5 = ((StandardTable) ((f9) this.d).e).backingMap.keySet();
        e9 r10 = new e9(this, 1);
        return new d7(r5.iterator(), r10, 0);
    L6:
        Set r11 = ((StandardTable) ((f9) this.d).e).columnKeySet();
        e9 r12 = new e9(this, 0);
        return new d7(r11.iterator(), r12, 0);
    L9:
        return ((StandardTable) this.d).createColumnKeyIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r5) {
        switch(this.f8945c) {
            case 0: goto L21;
            case 1: goto L15;
            default: goto L5;
        };
    L21:
        boolean r10 = false;
        if (r5 == null) goto L33;
        Iterator r11 = ((StandardTable) this.d).backingMap.values().iterator();
    L26:
        if (r11.hasNext() == false) goto L33;
        Map r12 = (Map) r11.next();
        if (r12.keySet().remove(r5) == false) goto L26;
        if (r12.isEmpty() == false) goto L32;
        r11.remove();
    L32:
        r10 = true;
    L33:
        return r10;
    L5:
        if ((r5 instanceof Map.Entry) == false) goto L39;
        Map.Entry r13 = (Map.Entry) r5;
        if (r13.getKey() != null) goto L9;
        return false;
    L9:
        if ((r13.getValue() instanceof Map) == true) goto L11;
        return false;
    L11:
        if (((StandardTable) ((f9) this.d).e).backingMap.entrySet().remove(r13) == false) goto L42;
        return true;
    L42:
        return false;
    L39:
        return false;
    L15:
        if (contains(r5) == true) goto L17;
    L19:
        return false;
    L17:
        if ((r5 instanceof Map.Entry) == false) goto L19;
        StandardTable.access$900((StandardTable) ((f9) this.d).e, ((Map.Entry) r5).getKey());
        return true;
    }

    @Override // com.google.common.collect.j6, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection r5) {
        switch(this.f8945c) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        r5.getClass();
        return p7.j0(this, r5.iterator());
    L8:
        r5.getClass();
        Iterator r10 = ((StandardTable) this.d).backingMap.values().iterator();
        boolean r11 = false;
    L10:
        if (r10.hasNext() == false) goto L17;
        Map r12 = (Map) r10.next();
        if (p7.h0(r5, r12.keySet().iterator()) == false) goto L10;
        if (r12.isEmpty() == false) goto L16;
        r10.remove();
    L16:
        r11 = true;
        goto L10
    L17:
        return r11;
    L5:
        return super.removeAll(r5);
    }

    @Override // com.google.common.collect.j6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection r10) {
        switch(this.f8945c) {
            case 0: goto L13;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        r10.getClass();
        f9 r5 = (f9) this.d;
        Iterator r11 = p7.V(((StandardTable) r5.e).columnKeySet().iterator()).iterator();
        boolean r12 = false;
    L8:
        if (r11.hasNext() == false) goto L12;
        Object r13 = r11.next();
        if (r10.contains(new ImmutableEntry(r13, ((StandardTable) r5.e).column(r13))) == true) goto L8;
        StandardTable.access$900((StandardTable) r5.e, r13);
        r12 = true;
        goto L8
    L12:
        return r12;
    L13:
        r10.getClass();
        Iterator r14 = ((StandardTable) this.d).backingMap.values().iterator();
        boolean r15 = false;
    L15:
        if (r14.hasNext() == false) goto L22;
        Map r16 = (Map) r14.next();
        if (r16.keySet().retainAll(r10) == false) goto L15;
        if (r16.isEmpty() == false) goto L21;
        r14.remove();
    L21:
        r15 = true;
        goto L15
    L22:
        return r15;
    L5:
        return super.retainAll(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch(this.f8945c) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return ((StandardTable) ((f9) this.d).e).backingMap.size();
    L7:
        return ((StandardTable) ((f9) this.d).e).columnKeySet().size();
    L9:
        return p7.m0(((StandardTable) this.d).createColumnKeyIterator());
    }

    public d9(StandardTable r5) {
        this.f8945c = 0;
        this.d = r5;
        this(r5, (byte) 0);
    }

    public d9(f9 r5, byte r10) {
        this.f8945c = 2;
        this.d = r5;
        this((StandardTable) r5.e, (byte) 0);
    }

    public d9(f9 r5) {
        this.f8945c = 1;
        this.d = r5;
        this((StandardTable) r5.e, (byte) 0);
    }
}
