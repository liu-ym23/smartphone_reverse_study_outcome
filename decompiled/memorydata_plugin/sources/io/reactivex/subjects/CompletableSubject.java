package io.reactivex.subjects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableSubject extends io.reactivex.a implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final CompletableDisposable[] f17170b = null;
    static final CompletableDisposable[] c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference<CompletableDisposable[]> f17171a;
    final AtomicBoolean d;
    Throwable e;

    static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -7650903191002190468L;
        final c downstream;

        CompletableDisposable(c r3, CompletableSubject r4) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            lazySet(r4);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            CompletableSubject r0 = (CompletableSubject) ZeusTransformUtils.preCheckCast(getAndSet(null), CompletableSubject.class, "com.obric.memorydata.plugin");
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
        f17170b = new CompletableDisposable[0];
        c = new CompletableDisposable[0];
    }

    CompletableSubject() {
        this.d = new AtomicBoolean();
        this.f17171a = new AtomicReference(f17170b);
    }

    boolean a(CompletableDisposable r5) {
    L2:
        CompletableDisposable[] r0 = (CompletableDisposable[]) ZeusTransformUtils.preCheckCast(this.f17171a.get(), CompletableDisposable[].class, "com.obric.memorydata.plugin");
        if (r0 == c) goto L4;
        int r1 = r0.length;
        CompletableDisposable[] r3 = new CompletableDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.f17171a.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    @Override // io.reactivex.a
    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        CompletableDisposable r0 = new CompletableDisposable(r4, this);
        r4.onSubscribe(r0);
        if (a(r0) == true) goto L5;
        Throwable r2 = this.e;
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

    void b(CompletableDisposable r7) {
    L2:
        CompletableDisposable[] r0 = (CompletableDisposable[]) ZeusTransformUtils.preCheckCast(this.f17171a.get(), CompletableDisposable[].class, "com.obric.memorydata.plugin");
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
        CompletableDisposable[] r3 = f17170b;
    L18:
        if (this.f17171a.compareAndSet(r0, r3) == false) goto L2;
        return;
    L16:
        CompletableDisposable[] r5 = new CompletableDisposable[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        r3 = r5;
        goto L18
    L12:
        return;
    }

    @Override // io.reactivex.c
    public void onComplete() {
        int r1 = 0;
        if (this.d.compareAndSet(false, true) == false) goto L7;
        CompletableDisposable[] r3 = (CompletableDisposable[]) ZeusTransformUtils.preCheckCast(this.f17171a.getAndSet(c), CompletableDisposable[].class, "com.obric.memorydata.plugin");
        int r0 = r3.length;
    L5:
        if (r1 >= r0) goto L9;
        r3[r1].downstream.onComplete();
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    @Override // io.reactivex.c
    public void onError(Throwable r4) {
        io.reactivex.internal.functions.a.a(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r1 = 0;
        if (this.d.compareAndSet(false, true) == false) goto L7;
        this.e = r4;
        CompletableDisposable[] r3 = (CompletableDisposable[]) ZeusTransformUtils.preCheckCast(this.f17171a.getAndSet(c), CompletableDisposable[].class, "com.obric.memorydata.plugin");
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

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (this.f17171a.get() != c) goto L6;
        r4.dispose();
        return;
    }
}
