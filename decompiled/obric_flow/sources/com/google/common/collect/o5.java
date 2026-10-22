package com.google.common.collect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class o5 extends j6 implements p5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedHashMultimap.ValueEntry[] f9103c;
    public int d;
    public int e;
    public p5 f;
    public p5 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMultimap f9104h;

    public o5(LinkedHashMultimap r5, Object r10, int r11) {
        this.f9104h = r5;
        super(1);
        this.d = 0;
        this.e = 0;
        this.f9102b = r10;
        this.f = this;
        this.g = this;
        this.f9103c = new LinkedHashMultimap.ValueEntry[p7.v(1.0d, r11)];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object r11) {
        int r5 = p7.o0(r11);
        LinkedHashMultimap.ValueEntry[] r10 = this.f9103c;
        int r12 = (r10.length - 1) & r5;
        LinkedHashMultimap.ValueEntry r13 = r10[r12];
        LinkedHashMultimap.ValueEntry r14 = r13;
    L3:
        if (r14 == null) goto L9;
        if (r14.matchesValue(r11, r5) == true) goto L6;
        r14 = r14.nextInValueBucket;
        goto L3
    L6:
        return false;
    L9:
        LinkedHashMultimap.ValueEntry r15 = new LinkedHashMultimap.ValueEntry(this.f9102b, r11, r5, r13);
        LinkedHashMultimap.access$200(this.g, r15);
        LinkedHashMultimap.access$200(r15, this);
        LinkedHashMultimap r16 = this.f9104h;
        LinkedHashMultimap.access$400(LinkedHashMultimap.access$300(r16).getPredecessorInMultimap(), r15);
        LinkedHashMultimap.access$400(r15, LinkedHashMultimap.access$300(r16));
        LinkedHashMultimap.ValueEntry[] r17 = this.f9103c;
        r17[r12] = r15;
        int r18 = this.d + 1;
        this.d = r18;
        this.e++;
        int r19 = r17.length;
        if (r18 > (1.0d * ((double) r19))) goto L12;
    L16:
        return true;
    L12:
        if (r19 >= 1073741824) goto L16;
        int r110 = r17.length * 2;
        LinkedHashMultimap.ValueEntry[] r20 = new LinkedHashMultimap.ValueEntry[r110];
        this.f9103c = r20;
        int r111 = r110 - 1;
        p5 r21 = this.f;
    L14:
        if (r21 == this) goto L16;
        LinkedHashMultimap.ValueEntry r22 = (LinkedHashMultimap.ValueEntry) r21;
        int r23 = r22.smearedValueHash & r111;
        r22.nextInValueBucket = r20[r23];
        r20[r23] = r22;
        r21 = r21.getSuccessorInValueSet();
        goto L14
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        Arrays.fill(this.f9103c, null);
        this.d = 0;
        p5 r5 = this.f;
    L3:
        if (r5 == this) goto L5;
        LinkedHashMultimap.access$600((LinkedHashMultimap.ValueEntry) r5);
        r5 = r5.getSuccessorInValueSet();
        goto L3
    L5:
        LinkedHashMultimap.access$200(this, this);
        this.e++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object r5) {
        int r10 = p7.o0(r5);
        LinkedHashMultimap.ValueEntry[] r11 = this.f9103c;
        LinkedHashMultimap.ValueEntry r12 = r11[(r11.length - 1) & r10];
    L3:
        if (r12 == null) goto L8;
        if (r12.matchesValue(r5, r10) == true) goto L6;
        r12 = r12.nextInValueBucket;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    @Override // java.lang.Iterable
    public final void forEach(Consumer r5) {
        r5.getClass();
        p5 r10 = this.f;
    L3:
        if (r10 == this) goto L5;
        r5.accept(((LinkedHashMultimap.ValueEntry) r10).getValue());
        r10 = r10.getSuccessorInValueSet();
        goto L3
    }

    @Override // com.google.common.collect.p5
    public final p5 getPredecessorInValueSet() {
        return this.g;
    }

    @Override // com.google.common.collect.p5
    public final p5 getSuccessorInValueSet() {
        return this.f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new n5(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object r10) {
        int r5 = p7.o0(r10);
        LinkedHashMultimap.ValueEntry[] r11 = this.f9103c;
        int r12 = (r11.length - 1) & r5;
        LinkedHashMultimap.ValueEntry r13 = r11[r12];
        LinkedHashMultimap.ValueEntry r14 = null;
    L3:
        if (r13 == null) goto L12;
        if (r13.matchesValue(r10, r5) == true) goto L6;
        r14 = r13;
        r13 = r13.nextInValueBucket;
        goto L3
    L6:
        if (r14 != null) goto L8;
        this.f9103c[r12] = r13.nextInValueBucket;
    L9:
        LinkedHashMultimap.access$500(r13);
        LinkedHashMultimap.access$600(r13);
        this.d--;
        this.e++;
        return true;
    L8:
        r14.nextInValueBucket = r13.nextInValueBucket;
        goto L9
    L12:
        return false;
    }

    @Override // com.google.common.collect.p5
    public final void setPredecessorInValueSet(p5 r5) {
        this.g = r5;
    }

    @Override // com.google.common.collect.p5
    public final void setSuccessorInValueSet(p5 r5) {
        this.f = r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.d;
    }
}
