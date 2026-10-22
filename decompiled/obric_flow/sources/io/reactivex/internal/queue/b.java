package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rt.g;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f18113i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f18114j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f18115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f18117c;
    public final int d;
    public AtomicReferenceArray e;
    public final int f;
    public AtomicReferenceArray g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f18118h;

    static {
        f18113i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        f18114j = new Object();
    }

    public b(int r10) {
        AtomicLong r5 = new AtomicLong();
        this.f18115a = r5;
        this.f18118h = new AtomicLong();
        int r11 = 1 << (32 - Integer.numberOfLeadingZeros(Math.max(8, r10) - 1));
        int r12 = r11 - 1;
        AtomicReferenceArray r13 = new AtomicReferenceArray(r11 + 1);
        this.e = r13;
        this.d = r12;
        this.f18116b = Math.min(r11 / 4, f18113i);
        this.g = r13;
        this.f = r12;
        this.f18117c = r11 - 2;
        r5.lazySet(0);
    }

    public final boolean a(Object r11, Object r12) {
        AtomicReferenceArray r5 = this.e;
        AtomicLong r10 = this.f18115a;
        long r13 = r10.get();
        long r14 = 2 + r13;
        int r15 = this.d;
        if (r5.get(((int) r14) & r15) != null) goto L5;
        int r16 = ((int) r13) & r15;
        r5.lazySet(r16 + 1, r12);
        r5.lazySet(r16, r11);
        r10.lazySet(r14);
    L6:
        return true;
    L5:
        AtomicReferenceArray r17 = new AtomicReferenceArray(r5.length());
        this.e = r17;
        int r18 = ((int) r13) & r15;
        r17.lazySet(r18 + 1, r12);
        r17.lazySet(r18, r11);
        r5.lazySet(r5.length() - 1, r17);
        r5.lazySet(r18, f18114j);
        r10.lazySet(r14);
        goto L6
    }

    @Override // rt.h
    public final void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    @Override // rt.h
    public final boolean isEmpty() {
        if (this.f18115a.get() != this.f18118h.get()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // rt.h
    public final boolean offer(Object r15) {
        if (r15 == null) goto L18;
        AtomicReferenceArray r5 = this.e;
        AtomicLong r10 = this.f18115a;
        long r11 = r10.get();
        int r12 = this.d;
        int r13 = ((int) r11) & r12;
        if (r11 >= this.f18117c) goto L7;
        r5.lazySet(r13, r15);
        r10.lazySet(r11 + 1);
        return true;
    L7:
        long r14 = ((long) this.f18116b) + r11;
        if (r5.get(((int) r14) & r12) != null) goto L11;
        this.f18117c = r14 - 1;
        r5.lazySet(r13, r15);
        r10.lazySet(r11 + 1);
        return true;
    L11:
        long r16 = r11 + 1;
        if (r5.get(((int) r16) & r12) != null) goto L15;
        r5.lazySet(r13, r15);
        r10.lazySet(r16);
        return true;
    L15:
        AtomicReferenceArray r17 = new AtomicReferenceArray(r5.length());
        this.e = r17;
        this.f18117c = (r11 + ((long) r12)) - 1;
        r17.lazySet(r13, r15);
        r5.lazySet(r5.length() - 1, r17);
        r5.lazySet(r13, f18114j);
        r10.lazySet(r16);
        return true;
    L18:
        throw new NullPointerException("Null is not a valid element");
    }

    public final Object peek() {
        AtomicReferenceArray r5 = this.g;
        int r10 = (int) this.f18118h.get();
        int r11 = this.f;
        int r12 = r10 & r11;
        Object r13 = r5.get(r12);
        if (r13 != f18114j) goto L6;
        int r14 = r11 + 1;
        AtomicReferenceArray r15 = (AtomicReferenceArray) r5.get(r14);
        r5.lazySet(r14, null);
        this.g = r15;
        return r15.get(r12);
    L6:
        return r13;
    }

    @Override // rt.h
    public final Object poll() {
        AtomicReferenceArray r5 = this.g;
        AtomicLong r10 = this.f18118h;
        long r11 = r10.get();
        int r12 = this.f;
        int r13 = ((int) r11) & r12;
        Object r14 = r5.get(r13);
        if (r14 != f18114j) goto L5;
        boolean r15 = true;
    L7:
        if (r14 == null) goto L11;
        if (r15 == true) goto L11;
        r5.lazySet(r13, null);
        r10.lazySet(r11 + 1);
        return r14;
    L11:
        if (r15 == false) goto L16;
        int r16 = r12 + 1;
        AtomicReferenceArray r17 = (AtomicReferenceArray) r5.get(r16);
        r5.lazySet(r16, null);
        this.g = r17;
        Object r18 = r17.get(r13);
        if (r18 == null) goto L15;
        r17.lazySet(r13, null);
        r10.lazySet(r11 + 1);
    L15:
        return r18;
    L16:
        return null;
    L5:
        r15 = false;
        goto L7
    }
}
