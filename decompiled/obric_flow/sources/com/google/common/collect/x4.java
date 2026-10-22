package com.google.common.collect;

import java.util.Comparator;
import java.util.Spliterators;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class x4 extends Spliterators.AbstractSpliterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ga f9222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImmutableSortedSet f9223b;

    public x4(ImmutableSortedSet r5, long r10) {
        this.f9223b = r5;
        super(r10, 1365);
        this.f9222a = r5.iterator();
    }

    @Override // java.util.Spliterator
    public final Comparator getComparator() {
        return this.f9223b.comparator;
    }

    @Override // java.util.Spliterator
    public final boolean tryAdvance(Consumer r5) {
        ga r10 = this.f9222a;
        if (r10.hasNext() == false) goto L6;
        r5.accept(r10.next());
        return true;
    L6:
        return false;
    }
}
