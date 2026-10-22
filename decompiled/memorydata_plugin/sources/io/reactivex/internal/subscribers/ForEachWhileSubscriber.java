package io.reactivex.internal.subscribers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<d> implements io.reactivex.disposables.b, j<T> {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final io.reactivex.b.a onComplete;
    final g<? super Throwable> onError;
    final io.reactivex.b.j<? super T> onNext;

    public ForEachWhileSubscriber(io.reactivex.b.j<? super T> r3, g<? super Throwable> r4, io.reactivex.b.a r5) {
        io.reactivex.b.j<? super T> r6 = (io.reactivex.b.j) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.b.j.class, "com.obric.memorydata.plugin");
        g<? super Throwable> r7 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
        io.reactivex.b.a r8 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r5, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
        this.onNext = r6;
        this.onError = r7;
        this.onComplete = r8;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
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
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.onComplete.a();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
    }

    @Override // org.a.c
    public void onError(Throwable r5) {
        if (this.done == false) goto L6;
        io.reactivex.d.a.a(r5);
        return;
    L6:
        this.done = true;
        this.onError.accept(r5);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(new CompositeException(new Throwable[]{r5, th}));
    }

    @Override // org.a.c
    public void onNext(T r2) {
        if (this.done == false) goto L12;
        return;
    L12:
        if (this.onNext.test(r2) == true) goto L14;
        dispose();
        onComplete();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dispose();
        onError(th);
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r3) {
        SubscriptionHelper.setOnce(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
    }
}
