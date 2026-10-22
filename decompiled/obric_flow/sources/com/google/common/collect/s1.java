package com.google.common.collect;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes2.dex */
public final class s1 implements Spliterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Spliterator.OfInt f9152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IntFunction f9153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9154c;
    public final /* synthetic */ Comparator d;

    public s1(Spliterator.OfInt r5, IntFunction r10, int r11, Comparator r12) {
        this.f9153b = r10;
        this.f9154c = r11;
        this.d = r12;
        this.f9152a = r5;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.f9154c | 16464;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return this.f9152a.estimateSize();
    }

    @Override // java.util.Spliterator
    public final void forEachRemaining(Consumer r5) {
        r1 r10 = new r1(r5, this.f9153b, 0);
        this.f9152a.forEachRemaining(r10);
    }

    @Override // java.util.Spliterator
    public final Comparator getComparator() {
        if (hasCharacteristics(4) == false) goto L7;
        return this.d;
    L7:
        throw new IllegalStateException();
    }

    @Override // java.util.Spliterator
    public final boolean tryAdvance(Consumer r5) {
        r1 r10 = new r1(r5, this.f9153b, 1);
        return this.f9152a.tryAdvance(r10);
    }

    @Override // java.util.Spliterator
    public final Spliterator trySplit() {
        Spliterator.OfInt r5 = this.f9152a.trySplit();
        if (r5 != null) goto L6;
        return null;
    L6:
        return new s1(r5, this.f9153b, this.f9154c, this.d);
    }
}
