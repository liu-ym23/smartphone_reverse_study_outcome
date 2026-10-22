package io.reactivex.internal.subscribers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class LambdaSubscriber<T> extends AtomicReference<d> implements io.reactivex.disposables.b, j<T>, d {
    private static final long serialVersionUID = -7251123623727029452L;
    final io.reactivex.b.a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onNext;
    final g<? super d> onSubscribe;

    public LambdaSubscriber(g<? super T> r3, g<? super Throwable> r4, io.reactivex.b.a r5, g<? super d> r6) {
        g<? super T> r7 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        g<? super Throwable> r8 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        io.reactivex.b.a r9 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
        g<? super d> r10 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
        this.onNext = r7;
        this.onError = r8;
        this.onComplete = r9;
        this.onSubscribe = r10;
    }

    @Override // org.a.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        if (this.onError == Functions.f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.a.c
    public void onComplete() {
        if (get() == SubscriptionHelper.CANCELLED) goto L12;
        lazySet(SubscriptionHelper.CANCELLED);
        this.onComplete.a();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
        return;
    }

    @Override // org.a.c
    public void onError(Throwable r4) {
        if (get() == SubscriptionHelper.CANCELLED) goto L9;
        lazySet(SubscriptionHelper.CANCELLED);
        this.onError.accept(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(new CompositeException(new Throwable[]{r4, th}));
        return;
    L9:
        io.reactivex.d.a.a(r4);
    }

    @Override // org.a.c
    public void onNext(T r4) {
        if (isDisposed() == true) goto L11;
        this.onNext.accept(r4);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        ((d) ZeusTransformUtils.preCheckCast(get(), d.class, "com.obric.memorydata.plugin")).cancel();
        onError(th);
        return;
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (SubscriptionHelper.setOnce(this, r4) == false) goto L11;
        this.onSubscribe.accept(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r4.cancel();
        onError(th);
        return;
    }

    @Override // org.a.d
    public void request(long r3) {
        ((d) ZeusTransformUtils.preCheckCast(get(), d.class, "com.obric.memorydata.plugin")).request(r3);
    }
}
