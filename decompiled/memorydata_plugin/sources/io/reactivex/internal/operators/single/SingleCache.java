package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.disposables.b;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleCache<T> extends v<T> implements x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final CacheDisposable[] f17051a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final CacheDisposable[] f17052b = null;
    final z<? extends T> c;
    final AtomicInteger d;
    final AtomicReference<CacheDisposable<T>[]> e;
    T f;
    Throwable g;

    static final class CacheDisposable<T> extends AtomicBoolean implements b {
        private static final long serialVersionUID = 7514387411091976596L;
        final x<? super T> downstream;
        final SingleCache<T> parent;

        CacheDisposable(x<? super T> r3, SingleCache<T> r4) {
            this.downstream = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            this.parent = r4;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true) == false) goto L6;
            this.parent.b(this);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }
    }

    static {
        f17051a = new CacheDisposable[0];
        f17052b = new CacheDisposable[0];
    }

    boolean a(CacheDisposable<T> r5) {
    L2:
        CacheDisposable<T>[] r0 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.e.get(), CacheDisposable[].class, "com.obric.memorydata.plugin");
        if (r0 == f17052b) goto L4;
        int r1 = r0.length;
        CacheDisposable<T>[] r3 = new CacheDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.e.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void b(CacheDisposable<T> r7) {
    L2:
        CacheDisposable<T>[] r0 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.e.get(), CacheDisposable[].class, "com.obric.memorydata.plugin");
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
        CacheDisposable<T>[] r3 = f17051a;
    L18:
        if (this.e.compareAndSet(r0, r3) == false) goto L2;
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

    @Override // io.reactivex.v
    public void b(x<? super T> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        CacheDisposable<T> r0 = new CacheDisposable(r4, this);
        r4.onSubscribe(r0);
        if (a(r0) == true) goto L5;
        Throwable r1 = this.g;
        if (r1 == null) goto L14;
        r4.onError(r1);
        return;
    L14:
        r4.onSuccess(this.f);
        return;
    L5:
        if (r0.isDisposed() == false) goto L8;
        b(r0);
    L8:
        if (this.d.getAndIncrement() != 0) goto L16;
        this.c.a(this);
        return;
    }

    @Override // io.reactivex.x
    public void onError(Throwable r5) {
        this.g = r5;
        CacheDisposable[] r4 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.e.getAndSet(f17052b), CacheDisposable[].class, "com.obric.memorydata.plugin");
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

    @Override // io.reactivex.x
    public void onSubscribe(b r2) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.x
    public void onSuccess(T r5) {
        this.f = r5;
        CacheDisposable[] r4 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.e.getAndSet(f17052b), CacheDisposable[].class, "com.obric.memorydata.plugin");
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
