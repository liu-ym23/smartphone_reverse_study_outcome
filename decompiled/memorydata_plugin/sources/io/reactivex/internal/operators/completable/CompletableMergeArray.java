package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableMergeArray extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e[] f16740a;

    static final class InnerCompletableObserver extends AtomicInteger implements c {
        private static final long serialVersionUID = -8360547806504310570L;
        final c downstream;
        final AtomicBoolean once;
        final io.reactivex.disposables.a set;

        InnerCompletableObserver(c r3, AtomicBoolean r4, io.reactivex.disposables.a r5, int r6) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.once = r4;
            this.set = r5;
            lazySet(r6);
        }

        @Override // io.reactivex.c
        public void onComplete() {
            if (decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (this.once.compareAndSet(false, true) == false) goto L9;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.c
        public void onError(Throwable r4) {
            this.set.dispose();
            if (this.once.compareAndSet(false, true) == false) goto L5;
            this.downstream.onError(r4);
            return;
        L5:
            io.reactivex.d.a.a(r4);
        }

        @Override // io.reactivex.c
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            this.set.a(r4);
        }
    }

    @Override // io.reactivex.a
    public void b(c r6) {
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.memorydata.plugin");
        io.reactivex.disposables.a r0 = new io.reactivex.disposables.a();
        InnerCompletableObserver r2 = new InnerCompletableObserver(r7, new AtomicBoolean(), r0, this.f16740a.length + 1);
        r7.onSubscribe(r0);
        e[] r5 = this.f16740a;
        int r8 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L11;
        e r3 = r5[r1];
        if (r0.isDisposed() == true) goto L6;
        if (r3 == null) goto L8;
        r3.a(r2);
        r1 = r1 + 1;
        goto L3
    L8:
        r0.dispose();
        r2.onError(new NullPointerException("A completable source is null"));
        return;
    L6:
        return;
    L11:
        r2.onComplete();
    }
}
