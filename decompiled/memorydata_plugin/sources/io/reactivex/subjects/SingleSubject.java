package io.reactivex.subjects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.v;
import io.reactivex.x;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleSubject<T> extends v<T> implements x<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final SingleDisposable[] f17178b = null;
    static final SingleDisposable[] c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference<SingleDisposable<T>[]> f17179a;
    final AtomicBoolean d;
    T e;
    Throwable f;

    static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -7650903191002190468L;
        final x<? super T> downstream;

        SingleDisposable(x<? super T> r3, SingleSubject<T> r4) {
            this.downstream = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            lazySet(r4);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SingleSubject r0 = (SingleSubject) ZeusTransformUtils.preCheckCast(getAndSet(null), SingleSubject.class, "com.obric.memorydata.plugin");
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
        f17178b = new SingleDisposable[0];
        c = new SingleDisposable[0];
    }

    SingleSubject() {
        this.d = new AtomicBoolean();
        this.f17179a = new AtomicReference(f17178b);
    }

    boolean a(SingleDisposable<T> r5) {
    L2:
        SingleDisposable<T>[] r0 = (SingleDisposable[]) ZeusTransformUtils.preCheckCast(this.f17179a.get(), SingleDisposable[].class, "com.obric.memorydata.plugin");
        if (r0 == c) goto L4;
        int r1 = r0.length;
        SingleDisposable<T>[] r3 = new SingleDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.f17179a.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void b(SingleDisposable<T> r7) {
    L2:
        SingleDisposable<T>[] r0 = (SingleDisposable[]) ZeusTransformUtils.preCheckCast(this.f17179a.get(), SingleDisposable[].class, "com.obric.memorydata.plugin");
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
        SingleDisposable<T>[] r3 = f17178b;
    L18:
        if (this.f17179a.compareAndSet(r0, r3) == false) goto L2;
        return;
    L16:
        SingleDisposable<T>[] r5 = new SingleDisposable[r1 - 1];
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
        SingleDisposable<T> r0 = new SingleDisposable(r4, this);
        r4.onSubscribe(r0);
        if (a(r0) == true) goto L5;
        Throwable r1 = this.f;
        if (r1 == null) goto L10;
        r4.onError(r1);
        return;
    L10:
        r4.onSuccess(this.e);
        return;
    L5:
        if (r0.isDisposed() == false) goto L12;
        b(r0);
        return;
    }

    @Override // io.reactivex.x
    public void onError(Throwable r4) {
        io.reactivex.internal.functions.a.a(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r1 = 0;
        if (this.d.compareAndSet(false, true) == false) goto L7;
        this.f = r4;
        SingleDisposable[] r3 = (SingleDisposable[]) ZeusTransformUtils.preCheckCast(this.f17179a.getAndSet(c), SingleDisposable[].class, "com.obric.memorydata.plugin");
        int r0 = r3.length;
    L5:
        if (r1 >= r0) goto L10;
        r3[r1].downstream.onError(r4);
        r1 = r1 + 1;
        goto L5
    L10:
        return;
    L7:
        io.reactivex.d.a.a(r4);
    }

    @Override // io.reactivex.x
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (this.f17179a.get() != c) goto L6;
        r4.dispose();
        return;
    }

    @Override // io.reactivex.x
    public void onSuccess(T r4) {
        io.reactivex.internal.functions.a.a(r4, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r1 = 0;
        if (this.d.compareAndSet(false, true) == false) goto L7;
        this.e = r4;
        SingleDisposable[] r3 = (SingleDisposable[]) ZeusTransformUtils.preCheckCast(this.f17179a.getAndSet(c), SingleDisposable[].class, "com.obric.memorydata.plugin");
        int r0 = r3.length;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].downstream.onSuccess(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }
}
