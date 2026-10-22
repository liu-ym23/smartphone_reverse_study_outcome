package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class l extends g7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9059c;
    public final /* synthetic */ Map d;

    public /* synthetic */ l(int r5, Map r10) {
        this.f9059c = r5;
        this.d = r10;
        super(0);
    }

    @Override // com.google.common.collect.g7
    public final Map b() {
        switch(this.f9059c) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            default: goto L5;
        };
    L5:
        return (f9) this.d;
    L7:
        return (h7) this.d;
    L9:
        return (k0) this.d;
    L11:
        return (CompactHashMap) this.d;
    L13:
        return (n) this.d;
    }

    @Override // com.google.common.collect.g7, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        switch(this.f9059c) {
            case 0: goto L18;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        CompactHashMap r10 = (CompactHashMap) this.d;
        Map r11 = r10.delegateOrNull();
        if (r11 == null) goto L10;
        return r11.entrySet().contains(r5);
    L10:
        if ((r5 instanceof Map.Entry) == false) goto L17;
        Map.Entry r12 = (Map.Entry) r5;
        int r13 = CompactHashMap.access$700(r10, r12.getKey());
        if (r13 == (-1)) goto L17;
        if (com.google.common.base.b0.w(CompactHashMap.access$800(r10, r13), r12.getValue()) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        Set r14 = ((n) this.d).d.entrySet();
        r14.getClass();
        return r14.contains(r5);
    L21:
        return false;
    L5:
        return super.contains(r5);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer r5) {
        switch(this.f9059c) {
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        super.forEach(r5);
        return;
    L6:
        ((h7) this.d).forEachEntry(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch(this.f9059c) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            default: goto L4;
        };
    L4:
        Set r5 = ((g0) ((f9) this.d).e).keySet();
        e9 r10 = new e9(this, 3);
        return new d7(r5.iterator(), r10, 0);
    L7:
        return ((h7) this.d).entryIterator();
    L9:
        return ((k0) this.d).d.a();
    L11:
        return ((CompactHashMap) this.d).entrySetIterator();
    L13:
        return new m((n) this.d);
    }

    @Override // com.google.common.collect.g7, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r10) {
        switch(this.f9059c) {
            case 0: goto L25;
            case 1: goto L11;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L7;
            default: goto L5;
        };
    L11:
        CompactHashMap r11 = (CompactHashMap) this.d;
        Map r5 = r11.delegateOrNull();
        if (r5 == null) goto L15;
        return r5.entrySet().remove(r10);
    L15:
        if ((r10 instanceof Map.Entry) == false) goto L31;
        Map.Entry r12 = (Map.Entry) r10;
        if (r11.needsAllocArrays() == true) goto L31;
        int r13 = CompactHashMap.access$900(r11);
        int r14 = p7.g0(r12.getKey(), r12.getValue(), r13, CompactHashMap.access$1000(r11), CompactHashMap.access$1100(r11), CompactHashMap.access$200(r11), CompactHashMap.access$1200(r11));
        if (r14 == (-1)) goto L31;
        r11.moveLastEntry(r14, r13);
        CompactHashMap.access$310(r11);
        r11.incrementModCount();
        return true;
    L31:
        return false;
    L5:
        return super.remove(r10);
    L7:
        if (contains(r10) == true) goto L9;
        return false;
    L9:
        Map.Entry r15 = (Map.Entry) r10;
        Objects.requireNonNull(r15);
        Object r16 = r15.getKey();
        ((g0) ((f9) this.d).e).keySet().remove(r16);
        return true;
    L25:
        if (contains(r10) == true) goto L27;
        return false;
    L27:
        Map.Entry r17 = (Map.Entry) r10;
        Objects.requireNonNull(r17);
        AbstractMapBasedMultimap.access$300(((n) this.d).e, r17.getKey());
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator spliterator() {
        switch(this.f9059c) {
            case 0: goto L13;
            case 1: goto L8;
            case 2: goto L5;
            case 3: goto L7;
            default: goto L5;
        };
    L8:
        CompactHashMap r5 = (CompactHashMap) this.d;
        Map r10 = r5.delegateOrNull();
        if (r10 == null) goto L12;
        return r10.entrySet().spliterator();
    L12:
        return p7.N(CompactHashMap.access$300(r5), 17, new w1(this, 0), null);
    L13:
        n r11 = (n) this.d;
        return p7.R(r11.d.entrySet().spliterator(), new z8(r11, 1));
    L5:
        return super.spliterator();
    L7:
        return ((h7) this.d).entrySpliterator();
    }
}
