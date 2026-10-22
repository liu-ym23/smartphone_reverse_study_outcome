package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class a9 extends j6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f8898c;

    public /* synthetic */ a9(Object r5, int r10) {
        this.f8897b = r10;
        this.f8898c = r5;
        super(1);
    }

    public Map b() {
        return (Map) this.f8898c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch(this.f8897b) {
            case 0: goto L8;
            case 1: goto L4;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        super.clear();
        return;
    L6:
        b().clear();
        return;
    L8:
        ((b9) this.f8898c).d(com.google.common.base.b0.b());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        switch(this.f8897b) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return b().containsKey(r5);
    L7:
        return ((LinkedListMultimap) this.f8898c).containsKey(r5);
    L9:
        if ((r5 instanceof Map.Entry) == false) goto L11;
        Map.Entry r10 = (Map.Entry) r5;
        b9 r11 = (b9) this.f8898c;
        return StandardTable.access$300(r11.e, r10.getKey(), r11.d, r10.getValue());
    L11:
        return false;
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer r5) {
        switch(this.f8897b) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        super.forEach(r5);
        return;
    L6:
        r5.getClass();
        a4 r10 = new a4(r5, 2);
        ((Map) this.f8898c).forEach(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        switch(this.f8897b) {
            case 0: goto L8;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L8:
        b9 r5 = (b9) this.f8898c;
        return !r5.e.containsColumn(r5.d);
    L5:
        return super.isEmpty();
    L7:
        return b().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        switch(this.f8897b) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return new c7(b().entrySet().iterator());
    L7:
        return new s5((LinkedListMultimap) this.f8898c);
    L9:
        return new e5((b9) this.f8898c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r5) {
        switch(this.f8897b) {
            case 0: goto L12;
            case 1: goto L10;
            default: goto L5;
        };
    L5:
        if (contains(r5) == false) goto L7;
        b().remove(r5);
        return true;
    L7:
        return false;
    L10:
        return !((LinkedListMultimap) this.f8898c).removeAll(r5).isEmpty();
    L12:
        if ((r5 instanceof Map.Entry) == false) goto L14;
        Map.Entry r10 = (Map.Entry) r5;
        b9 r11 = (b9) this.f8898c;
        return StandardTable.access$400(r11.e, r10.getKey(), r11.d, r10.getValue());
    L14:
        return false;
    }

    @Override // com.google.common.collect.j6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection r5) {
        switch(this.f8897b) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        com.google.common.base.z r10 = com.google.common.base.b0.B(com.google.common.base.b0.z(r5));
        return ((b9) this.f8898c).d(r10);
    L5:
        return super.retainAll(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch(this.f8897b) {
            case 0: goto L8;
            case 1: goto L7;
            default: goto L5;
        };
    L8:
        b9 r5 = (b9) this.f8898c;
        Iterator r10 = r5.e.backingMap.values().iterator();
        int r11 = 0;
    L10:
        if (r10.hasNext() == false) goto L14;
        if (((Map) r10.next()).containsKey(r5.d) == false) goto L10;
        r11 = r11 + 1;
        goto L10
    L14:
        return r11;
    L5:
        return b().size();
    L7:
        return LinkedListMultimap.access$500((LinkedListMultimap) this.f8898c).size();
    }

    public a9(Map r5) {
        this.f8897b = 2;
        super(1);
        r5.getClass();
        this.f8898c = r5;
    }
}
