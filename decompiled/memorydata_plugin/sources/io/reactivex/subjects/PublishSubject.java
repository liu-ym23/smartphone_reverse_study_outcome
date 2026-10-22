package io.reactivex.subjects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class PublishSubject<T> extends b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final PublishDisposable[] f17174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final PublishDisposable[] f17175b = null;
    final AtomicReference<PublishDisposable<T>[]> c;
    Throwable d;

    static final class PublishDisposable<T> extends AtomicBoolean implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 3562861878281475070L;
        final t<? super T> downstream;
        final PublishSubject<T> parent;

        PublishDisposable(t<? super T> r3, PublishSubject<T> r4) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
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

        public void onComplete() {
            if (get() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r2) {
            if (get() == false) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            this.downstream.onError(r2);
        }

        public void onNext(T r2) {
            if (get() == true) goto L6;
            this.downstream.onNext(r2);
            return;
        }
    }

    static {
        f17174a = new PublishDisposable[0];
        f17175b = new PublishDisposable[0];
    }

    PublishSubject() {
        this.c = new AtomicReference(f17175b);
    }

    public static <T> PublishSubject<T> b() {
        return new PublishSubject();
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        PublishDisposable<T> r0 = new PublishDisposable(r4, this);
        r4.onSubscribe(r0);
        if (a(r0) == true) goto L5;
        Throwable r2 = this.d;
        if (r2 == null) goto L10;
        r4.onError(r2);
        return;
    L10:
        r4.onComplete();
        return;
    L5:
        if (r0.isDisposed() == false) goto L12;
        b(r0);
        return;
    }

    boolean a(PublishDisposable<T> r5) {
    L2:
        PublishDisposable<T>[] r0 = (PublishDisposable[]) ZeusTransformUtils.preCheckCast(this.c.get(), PublishDisposable[].class, "com.obric.memorydata.plugin");
        if (r0 == f17174a) goto L4;
        int r1 = r0.length;
        PublishDisposable<T>[] r3 = new PublishDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.c.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void b(PublishDisposable<T> r7) {
    L2:
        PublishDisposable<T>[] r0 = (PublishDisposable[]) ZeusTransformUtils.preCheckCast(this.c.get(), PublishDisposable[].class, "com.obric.memorydata.plugin");
        if (r0 == f17174a) goto L21;
        if (r0 == f17175b) goto L29;
        int r1 = r0.length;
        int r2 = -1;
        int r4 = 0;
    L8:
        if (r4 >= r1) goto L13;
        if (r0[r4] == r7) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        r2 = r4;
    L13:
        if (r2 < 0) goto L14;
        if (r1 != 1) goto L18;
        PublishDisposable<T>[] r3 = f17175b;
    L20:
        if (this.c.compareAndSet(r0, r3) == false) goto L2;
        return;
    L18:
        PublishDisposable<T>[] r5 = new PublishDisposable[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        r3 = r5;
        goto L20
    L14:
        return;
    L29:
        return;
    }

    @Override // io.reactivex.t
    public void onComplete() {
        PublishDisposable<T>[] r0 = this.c.get();
        PublishDisposable<T>[] r1 = f17174a;
        if (r0 != r1) goto L5;
        return;
    L5:
        PublishDisposable[] r3 = (PublishDisposable[]) ZeusTransformUtils.preCheckCast(this.c.getAndSet(r1), PublishDisposable[].class, "com.obric.memorydata.plugin");
        int r2 = r3.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L8;
        r3[r4].onComplete();
        r4 = r4 + 1;
        goto L6
    }

    @Override // io.reactivex.t
    public void onError(Throwable r4) {
        io.reactivex.internal.functions.a.a(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] r0 = this.c.get();
        PublishDisposable<T>[] r1 = f17174a;
        if (r0 != r1) goto L6;
        io.reactivex.d.a.a(r4);
        return;
    L6:
        this.d = r4;
        PublishDisposable[] r3 = (PublishDisposable[]) ZeusTransformUtils.preCheckCast(this.c.getAndSet(r1), PublishDisposable[].class, "com.obric.memorydata.plugin");
        int r2 = r3.length;
        int r5 = 0;
    L7:
        if (r5 >= r2) goto L9;
        r3[r5].onError(r4);
        r5 = r5 + 1;
        goto L7
    }

    @Override // io.reactivex.t
    public void onNext(T r4) {
        io.reactivex.internal.functions.a.a(r4, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable[] r3 = (PublishDisposable[]) ZeusTransformUtils.preCheckCast(this.c.get(), PublishDisposable[].class, "com.obric.memorydata.plugin");
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].onNext(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (this.c.get() != f17174a) goto L6;
        r4.dispose();
        return;
    }
}
