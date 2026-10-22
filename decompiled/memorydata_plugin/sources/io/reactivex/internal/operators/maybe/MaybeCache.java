package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeCache<T> extends k<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final CacheDisposable[] f16815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final CacheDisposable[] f16816b = null;
    final AtomicReference<o<T>> c;
    final AtomicReference<CacheDisposable<T>[]> d;
    T e;
    Throwable f;

    static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -5791853038359966195L;
        final m<? super T> downstream;

        CacheDisposable(m<? super T> r3, MaybeCache<T> r4) {
            m<? super T> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            super(r4);
            this.downstream = r5;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            MaybeCache r0 = (MaybeCache) ZeusTransformUtils.preCheckCast(getAndSet(null), MaybeCache.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L6;
            r0.b(this);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f16815a = new CacheDisposable[0];
        f16816b = new CacheDisposable[0];
    }

    boolean a(CacheDisposable<T> r5) {
    L2:
        CacheDisposable<T>[] r0 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.d.get(), CacheDisposable[].class, "com.obric.memorydata.plugin");
        if (r0 == f16816b) goto L4;
        int r1 = r0.length;
        CacheDisposable<T>[] r3 = new CacheDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.d.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void b(CacheDisposable<T> r7) {
    L2:
        CacheDisposable<T>[] r0 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.d.get(), CacheDisposable[].class, "com.obric.memorydata.plugin");
        int r1 = r0.length;
        if (r1 == 0) goto L4;
        int r2 = -1;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L11;
        if (r0[r4] == r7) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        r2 = r4;
    L11:
        if (r2 < 0) goto L12;
        if (r1 != 1) goto L16;
        CacheDisposable<T>[] r3 = f16815a;
    L18:
        if (this.d.compareAndSet(r0, r3) == false) goto L2;
        return;
    L16:
        CacheDisposable<T>[] r5 = new CacheDisposable[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        r3 = r5;
        goto L18
    L12:
        return;
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin");
        CacheDisposable<T> r0 = new CacheDisposable(r5, this);
        r5.onSubscribe(r0);
        if (a(r0) == false) goto L13;
        if (r0.isDisposed() == false) goto L8;
        b(r0);
        return;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(this.c.getAndSet(null), o.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L22;
        r6.a(this);
        return;
    L22:
        return;
    L13:
        if (r0.isDisposed() == true) goto L23;
        Throwable r1 = this.f;
        if (r1 == null) goto L17;
        r5.onError(r1);
        return;
    L17:
        T r3 = this.e;
        if (r3 == null) goto L20;
        r5.onSuccess(r3);
        return;
    L20:
        r5.onComplete();
        return;
    }

    @Override // io.reactivex.m
    public void onComplete() {
        CacheDisposable[] r4 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(f16816b), CacheDisposable[].class, "com.obric.memorydata.plugin");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        CacheDisposable r2 = r4[r1];
        if (r2.isDisposed() == true) goto L7;
        r2.downstream.onComplete();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // io.reactivex.m
    public void onError(Throwable r5) {
        this.f = r5;
        CacheDisposable[] r4 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(f16816b), CacheDisposable[].class, "com.obric.memorydata.plugin");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        CacheDisposable r2 = r4[r1];
        if (r2.isDisposed() == true) goto L7;
        r2.downstream.onError(r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // io.reactivex.m
    public void onSubscribe(io.reactivex.disposables.b r2) {
        io.reactivex.disposables.b r1 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r2, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.m
    public void onSuccess(T r5) {
        this.e = r5;
        CacheDisposable[] r4 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(f16816b), CacheDisposable[].class, "com.obric.memorydata.plugin");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        CacheDisposable r2 = r4[r1];
        if (r2.isDisposed() == true) goto L7;
        r2.downstream.onSuccess(r5);
    L7:
        r1 = r1 + 1;
        goto L3
    }
}
