package io.reactivex.internal.queue;

import bc.e;
import io.reactivex.internal.util.g;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements e<T> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f9600n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Object f9601o = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicLong f9602c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f9603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f9604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f9605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    AtomicReferenceArray<Object> f9606j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final int f9607k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    AtomicReferenceArray<Object> f9608l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final AtomicLong f9609m;

    static {
        f9600n = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        f9601o = new Object();
    }

    public a(int r10) {
        this.f9602c = new AtomicLong();
        this.f9609m = new AtomicLong();
        int r11 = g.a(Math.max(8, r10));
        int r12 = r11 - 1;
        AtomicReferenceArray<Object> r13 = new AtomicReferenceArray(r11 + 1);
        this.f9606j = r13;
        this.f9605i = r12;
        a(r11);
        this.f9608l = r13;
        this.f9607k = r12;
        this.f9604h = r12 - 1;
        r(0);
    }

    private void a(int r10) {
        this.f9603g = Math.min(r10 / 4, f9600n);
    }

    private static int b(int r10) {
        return r10;
    }

    private static int c(long r10, int r11) {
        return b(((int) r10) & r11);
    }

    private long d() {
        return this.f9609m.get();
    }

    private long e() {
        return this.f9602c.get();
    }

    private long f() {
        return this.f9609m.get();
    }

    private static <E> Object g(AtomicReferenceArray<Object> r10, int r11) {
        return r10.get(r11);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> r10, int r11) {
        int r12 = b(r11);
        AtomicReferenceArray<Object> r13 = (AtomicReferenceArray) g(r10, r12);
        p(r10, r12, null);
        return r13;
    }

    private long i() {
        return this.f9602c.get();
    }

    private T j(AtomicReferenceArray<Object> r10, long r11, int r12) {
        this.f9608l = r10;
        return (T) g(r10, c(r11, r12));
    }

    private T k(AtomicReferenceArray<Object> r10, long r11, int r12) {
        this.f9608l = r10;
        int r13 = c(r11, r12);
        T r14 = (T) g(r10, r13);
        if (r14 == null) goto L5;
        p(r10, r13, null);
        o(r11 + 1);
    L5:
        return r14;
    }

    private void m(AtomicReferenceArray<Object> r10, long r11, int r12, T r13, long r14) {
        AtomicReferenceArray<Object> r15 = new AtomicReferenceArray(r10.length());
        this.f9606j = r15;
        this.f9604h = (r14 + r11) - 1;
        p(r15, r12, r13);
        q(r10, r15);
        p(r10, r12, f9601o);
        r(r11 + 1);
    }

    private void o(long r10) {
        this.f9609m.lazySet(r10);
    }

    private static void p(AtomicReferenceArray<Object> r10, int r11, Object r12) {
        r10.lazySet(r11, r12);
    }

    private void q(AtomicReferenceArray<Object> r10, AtomicReferenceArray<Object> r11) {
        p(r10, b(r10.length() - 1), r11);
    }

    private void r(long r10) {
        this.f9602c.lazySet(r10);
    }

    private boolean s(AtomicReferenceArray<Object> r10, T r11, long r12, int r13) {
        p(r10, r13, r11);
        r(r12 + 1);
        return true;
    }

    @Override // bc.f
    public void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    @Override // bc.f
    public boolean isEmpty() {
        if (i() != f()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l(T r10, T r11) {
        AtomicReferenceArray<Object> r12 = this.f9606j;
        long r13 = i();
        int r14 = this.f9605i;
        long r15 = 2 + r13;
        if (g(r12, c(r15, r14)) != null) goto L5;
        int r16 = c(r13, r14);
        p(r12, r16 + 1, r11);
    L6:
        p(r12, r16, r10);
        r(r15);
        return true;
    L5:
        AtomicReferenceArray<Object> r17 = new AtomicReferenceArray(r12.length());
        this.f9606j = r17;
        r16 = c(r13, r14);
        p(r17, r16 + 1, r11);
        p(r17, r16, r10);
        q(r12, r17);
        r10 = (T) f9601o;
        goto L6
    }

    public int n() {
        long r10 = f();
    L3:
        long r11 = i();
        long r12 = f();
        if (r10 == r12) goto L6;
        r10 = r12;
        goto L3
    L6:
        return (int) (r11 - r12);
    }

    @Override // bc.f
    public boolean offer(T r12) {
        Objects.requireNonNull(r12, "Null is not a valid element");
        AtomicReferenceArray<Object> r10 = this.f9606j;
        long r11 = e();
        int r13 = this.f9605i;
        int r14 = c(r11, r13);
        if (r11 < this.f9604h) goto L5;
        long r15 = ((long) this.f9603g) + r11;
        if (g(r10, c(r15, r13)) != null) goto L11;
        this.f9604h = r15 - 1;
        return s(r10, r12, r11, r14);
    L11:
        if (g(r10, c(1 + r11, r13)) == null) goto L13;
        m(r10, r11, r14, r12, r13);
        return true;
    L13:
        return s(r10, r12, r11, r14);
    L5:
        return s(r10, r12, r11, r14);
    }

    public T peek() {
        AtomicReferenceArray<Object> r10 = this.f9608l;
        long r11 = d();
        int r12 = this.f9607k;
        T r13 = (T) g(r10, c(r11, r12));
        if (r13 == f9601o) goto L5;
        return r13;
    L5:
        return j(h(r10, r12 + 1), r11, r12);
    }

    @Override // bc.e, bc.f
    public T poll() {
        AtomicReferenceArray<Object> r10 = this.f9608l;
        long r11 = d();
        int r12 = this.f9607k;
        int r13 = c(r11, r12);
        T r14 = (T) g(r10, r13);
        if (r14 != f9601o) goto L5;
        boolean r15 = true;
    L7:
        if (r14 == null) goto L11;
        if (r15 == true) goto L11;
        p(r10, r13, null);
        o(r11 + 1);
        return r14;
    L11:
        if (r15 == true) goto L13;
        return null;
    L13:
        return k(h(r10, r12 + 1), r11, r12);
    L5:
        r15 = false;
        goto L7
    }
}
