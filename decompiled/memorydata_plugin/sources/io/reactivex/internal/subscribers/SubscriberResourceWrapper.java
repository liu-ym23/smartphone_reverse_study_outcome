package io.reactivex.internal.subscribers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, j<T>, d {
    private static final long serialVersionUID = -8612022020200669122L;
    final org.a.c<? super T> downstream;
    final AtomicReference<d> upstream;

    public SubscriberResourceWrapper(org.a.c<? super T> r3) {
        org.a.c<? super T> r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.upstream = new AtomicReference();
        this.downstream = r4;
    }

    @Override // org.a.d
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (this.upstream.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.a.c
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    @Override // org.a.c
    public void onError(Throwable r1) {
        DisposableHelper.dispose(this);
        this.downstream.onError(r1);
    }

    @Override // org.a.c
    public void onNext(T r1) {
        this.downstream.onNext(r1);
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (SubscriptionHelper.setOnce(this.upstream, r4) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // org.a.d
    public void request(long r3) {
        if (SubscriptionHelper.validate(r3) == false) goto L6;
        ((d) ZeusTransformUtils.preCheckCast(this.upstream.get(), d.class, "com.obric.memorydata.plugin")).request(r3);
        return;
    }

    public void setResource(io.reactivex.disposables.b r3) {
        DisposableHelper.set(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
    }
}
