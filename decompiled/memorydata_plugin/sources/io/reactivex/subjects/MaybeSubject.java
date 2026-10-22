package io.reactivex.subjects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.k;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeSubject<T> extends k<T> implements m<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final MaybeDisposable[] f17172b = null;
    static final MaybeDisposable[] c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference<MaybeDisposable<T>[]> f17173a;
    final AtomicBoolean d;
    T e;
    Throwable f;

    static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -7650903191002190468L;
        final m<? super T> downstream;

        MaybeDisposable(m<? super T> r3, MaybeSubject<T> r4) {
            this.downstream = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            lazySet(r4);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            MaybeSubject r0 = (MaybeSubject) ZeusTransformUtils.preCheckCast(getAndSet(null), MaybeSubject.class, "com.obric.memorydata.plugin");
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
        f17172b = new MaybeDisposable[0];
        c = new MaybeDisposable[0];
    }

    MaybeSubject() {
        this.d = new AtomicBoolean();
        this.f17173a = new AtomicReference(f17172b);
    }

    boolean a(MaybeDisposable<T> r5) {
    L2:
        MaybeDisposable<T>[] r0 = (MaybeDisposable[]) ZeusTransformUtils.preCheckCast(this.f17173a.get(), MaybeDisposable[].class, "com.obric.memorydata.plugin");
        if (r0 == c) goto L4;
        int r1 = r0.length;
        MaybeDisposable<T>[] r3 = new MaybeDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.f17173a.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        MaybeDisposable<T> r0 = new MaybeDisposable(r4, this);
        r4.onSubscribe(r0);
        if (a(r0) == true) goto L5;
        Throwable r1 = this.f;
        if (r1 == null) goto L10;
        r4.onError(r1);
        return;
    L10:
        T r2 = this.e;
        if (r2 != null) goto L13;
        r4.onComplete();
        return;
    L13:
        r4.onSuccess(r2);
        return;
    L5:
        if (r0.isDisposed() == false) goto L15;
        b(r0);
        return;
    }

    void b(MaybeDisposable<T> r7) {
    L2:
        MaybeDisposable<T>[] r0 = (MaybeDisposable[]) ZeusTransformUtils.preCheckCast(this.f17173a.get(), MaybeDisposable[].class, "com.obric.memorydata.plugin");
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
        MaybeDisposable<T>[] r3 = f17172b;
    L18:
        if (this.f17173a.compareAndSet(r0, r3) == false) goto L2;
        return;
    L16:
        MaybeDisposable<T>[] r5 = new MaybeDisposable[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        r3 = r5;
        goto L18
    L12:
        return;
    }

    @Override // io.reactivex.m
    public void onComplete() {
        int r1 = 0;
        if (this.d.compareAndSet(false, true) == false) goto L7;
        MaybeDisposable[] r3 = (MaybeDisposable[]) ZeusTransformUtils.preCheckCast(this.f17173a.getAndSet(c), MaybeDisposable[].class, "com.obric.memorydata.plugin");
        int r0 = r3.length;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].downstream.onComplete();
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    @Override // io.reactivex.m
    public void onError(Throwable r4) {
        io.reactivex.internal.functions.a.a(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r1 = 0;
        if (this.d.compareAndSet(false, true) == false) goto L7;
        this.f = r4;
        MaybeDisposable[] r3 = (MaybeDisposable[]) ZeusTransformUtils.preCheckCast(this.f17173a.getAndSet(c), MaybeDisposable[].class, "com.obric.memorydata.plugin");
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

    @Override // io.reactivex.m
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (this.f17173a.get() != c) goto L6;
        r4.dispose();
        return;
    }

    @Override // io.reactivex.m
    public void onSuccess(T r4) {
        io.reactivex.internal.functions.a.a(r4, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r1 = 0;
        if (this.d.compareAndSet(false, true) == false) goto L7;
        this.e = r4;
        MaybeDisposable[] r3 = (MaybeDisposable[]) ZeusTransformUtils.preCheckCast(this.f17173a.getAndSet(c), MaybeDisposable[].class, "com.obric.memorydata.plugin");
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
