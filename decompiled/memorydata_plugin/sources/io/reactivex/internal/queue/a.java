package io.reactivex.internal.queue;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.a.e;
import io.reactivex.internal.util.g;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes6.dex */
public final class a<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f17107a = 0;
    private static final Object j = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicLong f17108b;
    int c;
    long d;
    final int e;
    AtomicReferenceArray<Object> f;
    final int g;
    AtomicReferenceArray<Object> h;
    final AtomicLong i;

    static {
        f17107a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        j = new Object();
    }

    public a(int r4) {
        this.f17108b = new AtomicLong();
        this.i = new AtomicLong();
        int r5 = g.a(Math.max(8, r4));
        int r0 = r5 - 1;
        AtomicReferenceArray<Object> r1 = new AtomicReferenceArray(r5 + 1);
        this.f = r1;
        this.e = r0;
        a(r5);
        this.h = r1;
        this.g = r0;
        this.d = r0 - 1;
        a(0);
    }

    private static int a(long r0, int r2) {
        return b(((int) r0) & r2);
    }

    private T a(AtomicReferenceArray<Object> r4, long r5, int r7) {
        this.h = r4;
        int r8 = a(r5, r7);
        T r0 = (T) b(r4, r8);
        if (r0 == null) goto L5;
        a(r4, r8, null);
        b(r5 + 1);
    L5:
        return r0;
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> r3, int r4) {
        int r2 = b(r4);
        AtomicReferenceArray<Object> r5 = (AtomicReferenceArray) ZeusTransformUtils.preCheckCast(b(r3, r2), AtomicReferenceArray.class, "com.obric.memorydata.plugin");
        a(r3, r2, null);
        return r5;
    }

    private void a(int r2) {
        this.c = Math.min(r2 / 4, f17107a);
    }

    private void a(long r1) {
        this.f17108b.lazySet(r1);
    }

    private static void a(AtomicReferenceArray<Object> r0, int r1, Object r2) {
        r0.lazySet(r1, r2);
    }

    private void a(AtomicReferenceArray<Object> r5, long r6, int r8, T r9, long r10) {
        AtomicReferenceArray<Object> r1 = new AtomicReferenceArray(r5.length());
        this.f = r1;
        this.d = (r10 + r6) - 1;
        a(r1, r8, r9);
        a(r5, r1);
        a(r5, r8, j);
        a(r6 + 1);
    }

    private void a(AtomicReferenceArray<Object> r1, AtomicReferenceArray<Object> r2) {
        a(r1, b(r1.length() - 1), r2);
    }

    private boolean a(AtomicReferenceArray<Object> r1, T r2, long r3, int r5) {
        a(r1, r5, r2);
        a(r3 + 1);
        return true;
    }

    private static int b(int r0) {
        return r0;
    }

    private static <E> Object b(AtomicReferenceArray<Object> r0, int r1) {
        return r0.get(r1);
    }

    private T b(AtomicReferenceArray<Object> r1, long r2, int r4) {
        this.h = r1;
        return (T) b(r1, a(r2, r4));
    }

    private void b(long r1) {
        this.i.lazySet(r1);
    }

    private long c() {
        return this.f17108b.get();
    }

    private long d() {
        return this.i.get();
    }

    private long e() {
        return this.f17108b.get();
    }

    private long f() {
        return this.i.get();
    }

    public T a() {
        AtomicReferenceArray<Object> r0 = this.h;
        long r1 = f();
        int r3 = this.g;
        T r4 = (T) b(r0, a(r1, r3));
        if (r4 == j) goto L5;
        return r4;
    L5:
        return b(a(r0, r3 + 1), r1, r3);
    }

    public boolean a(T r9, T r10) {
        AtomicReferenceArray<Object> r0 = this.f;
        long r1 = c();
        int r3 = this.e;
        long r4 = 2 + r1;
        if (b(r0, a(r4, r3)) != null) goto L5;
        int r2 = a(r1, r3);
        a(r0, r2 + 1, r10);
    L6:
        a(r0, r2, r9);
        a(r4);
        return true;
    L5:
        AtomicReferenceArray<Object> r7 = new AtomicReferenceArray(r0.length());
        this.f = r7;
        r2 = a(r1, r3);
        a(r7, r2 + 1, r10);
        a(r7, r2, r9);
        a(r0, r7);
        r9 = (T) j;
        goto L6
    }

    public int b() {
        long r0 = d();
    L3:
        long r2 = c();
        long r4 = d();
        if (r0 == r4) goto L6;
        r0 = r4;
        goto L3
    L6:
        return (int) (r2 - r4);
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        if (c() != d()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(T r12) {
        Objects.requireNonNull(r12, "Null is not a valid element");
        AtomicReferenceArray<Object> r2 = this.f;
        long r4 = e();
        int r0 = this.e;
        int r6 = a(r4, r0);
        if (r4 < this.d) goto L5;
        long r7 = ((long) this.c) + r4;
        if (b(r2, a(r7, r0)) != null) goto L11;
        this.d = r7 - 1;
        return a(r2, r12, r4, r6);
    L11:
        if (b(r2, a(1 + r4, r0)) == null) goto L13;
        a(r2, r4, r6, r12, r0);
        return true;
    L13:
        return a(r2, r12, r4, r6);
    L5:
        return a(r2, r12, r4, r6);
    }

    @Override // io.reactivex.internal.a.e, io.reactivex.internal.a.f
    public T poll() {
        AtomicReferenceArray<Object> r0 = this.h;
        long r1 = f();
        int r3 = this.g;
        int r4 = a(r1, r3);
        T r5 = (T) b(r0, r4);
        if (r5 != j) goto L5;
        boolean r6 = true;
    L7:
        if (r5 == null) goto L11;
        if (r6 == true) goto L11;
        a(r0, r4, null);
        b(r1 + 1);
        return r5;
    L11:
        if (r6 == true) goto L13;
        return null;
    L13:
        return a(a(r0, r3 + 1), r1, r3);
    L5:
        r6 = false;
        goto L7
    }
}
