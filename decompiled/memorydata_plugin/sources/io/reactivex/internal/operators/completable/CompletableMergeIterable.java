package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableMergeIterable extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterable<? extends e> f16741a;

    static final class MergeCompletableObserver extends AtomicBoolean implements c {
        private static final long serialVersionUID = -7730517613164279224L;
        final c downstream;
        final io.reactivex.disposables.a set;
        final AtomicInteger wip;

        MergeCompletableObserver(c r3, io.reactivex.disposables.a r4, AtomicInteger r5) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.set = r4;
            this.wip = r5;
        }

        @Override // io.reactivex.c
        public void onComplete() {
            if (this.wip.decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (compareAndSet(false, true) == false) goto L9;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.c
        public void onError(Throwable r3) {
            this.set.dispose();
            if (compareAndSet(false, true) == false) goto L5;
            this.downstream.onError(r3);
            return;
        L5:
            io.reactivex.d.a.a(r3);
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
        r7.onSubscribe(r0);
        Iterator r5 = (Iterator) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.f16741a.iterator(), "The source iterator returned is null"), Iterator.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        AtomicInteger r2 = new AtomicInteger(1);
        MergeCompletableObserver r3 = new MergeCompletableObserver(r7, r0, r2);
    L6:
        if (r0.isDisposed() == true) goto L7;
        if (r5.hasNext() == false) goto L10;
        if (r0.isDisposed() == true) goto L14;
        e r8 = (e) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(r5.next(), "The iterator returned a null CompletableSource"), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r0.isDisposed() == true) goto L18;
        r2.getAndIncrement();
        r8.a(r3);
        goto L6
    L18:
        return;
    L20:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r0.dispose();
        r3.onError(th);
        return;
    L14:
        return;
    L10:
        r3.onComplete();
        return;
    L23:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r0.dispose();
        r3.onError(th);
        return;
    L7:
        return;
    L26:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r7.onError(th);
    }
}
