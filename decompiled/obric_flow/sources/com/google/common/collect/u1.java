package com.google.common.collect;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class u1 implements Spliterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Spliterator f9176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Spliterator f9177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function f9178c;
    public final com.bytedance.ai.resource.core.net.a d;
    public int e;
    public long f;

    public u1(Spliterator r5, Spliterator r10, Function r11, int r12, long r13) {
        com.bytedance.ai.resource.core.net.a r14 = new com.bytedance.ai.resource.core.net.a(19);
        this.f9176a = r5;
        this.f9177b = r10;
        this.f9178c = r11;
        this.d = r14;
        this.e = r12;
        this.f = r13;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.e;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        Spliterator r5 = this.f9176a;
        if (r5 == null) goto L6;
        this.f = Math.max(this.f, r5.estimateSize());
    L6:
        return Math.max(this.f, 0);
    }

    @Override // java.util.Spliterator
    public final void forEachRemaining(Consumer r5) {
        Spliterator r10 = this.f9176a;
        if (r10 == null) goto L5;
        r10.forEachRemaining(r5);
        this.f9176a = null;
    L5:
        t1 r11 = new t1(this, r5, 0);
        this.f9177b.forEachRemaining(r11);
        this.f = 0;
    }

    @Override // java.util.Spliterator
    public final boolean tryAdvance(Consumer r5) {
    L2:
        Spliterator r10 = this.f9176a;
        if (r10 != null) goto L5;
    L11:
        this.f9176a = null;
        m1 r11 = new m1(this, 1);
        if (this.f9177b.tryAdvance(r11) == true) goto L2;
        return false;
    L5:
        if (r10.tryAdvance(r5) == false) goto L11;
        long r12 = this.f;
        if (r12 == Long.MAX_VALUE) goto L18;
        this.f = r12 - 1;
        return true;
    L18:
        return true;
    }

    @Override // java.util.Spliterator
    public final Spliterator trySplit() {
        Spliterator r5 = this.f9177b.trySplit();
        if (r5 == null) goto L9;
        int r10 = this.e & (-65);
        long r11 = estimateSize();
        if (r11 >= Long.MAX_VALUE) goto L7;
        r11 = r11 / 2;
        this.f -= r11;
        this.e = r10;
    L7:
        Spliterator r12 = this.f9176a;
        this.d.getClass();
        u1 r13 = new u1(r12, r5, this.f9178c, r10, r11);
        this.f9176a = null;
        return r13;
    L9:
        Spliterator r14 = this.f9176a;
        if (r14 == null) goto L13;
        this.f9176a = null;
        return r14;
    L13:
        return null;
    }
}
