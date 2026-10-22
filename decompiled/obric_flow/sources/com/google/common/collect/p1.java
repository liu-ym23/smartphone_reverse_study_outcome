package com.google.common.collect;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 implements Spliterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spliterator f9114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function f9115b;

    public p1(Spliterator r5, Function r10) {
        this.f9114a = r5;
        this.f9115b = r10;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.f9114a.characteristics() & (-262);
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return this.f9114a.estimateSize();
    }

    @Override // java.util.Spliterator
    public final void forEachRemaining(Consumer r5) {
        o1 r10 = new o1(r5, this.f9115b, 0);
        this.f9114a.forEachRemaining(r10);
    }

    @Override // java.util.Spliterator
    public final boolean tryAdvance(Consumer r5) {
        o1 r10 = new o1(r5, this.f9115b, 1);
        return this.f9114a.tryAdvance(r10);
    }

    @Override // java.util.Spliterator
    public final Spliterator trySplit() {
        Spliterator r5 = this.f9114a.trySplit();
        if (r5 != null) goto L7;
        return null;
    L7:
        return new p1(r5, this.f9115b);
    }
}
