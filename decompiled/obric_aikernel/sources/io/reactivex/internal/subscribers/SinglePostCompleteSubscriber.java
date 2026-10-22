package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import java.util.concurrent.atomic.AtomicLong;
import tc.c;
import tc.d;
import xb.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements g<T>, d {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final c<? super R> downstream;
    protected long produced;
    protected d upstream;
    protected R value;

    public SinglePostCompleteSubscriber(c<? super R> r10) {
        this.downstream = r10;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    protected final void complete(R r10) {
        long r11 = this.produced;
        if (r11 == 0) goto L5;
        b.e(this, r11);
    L5:
        long r12 = get();
        if ((r12 & Long.MIN_VALUE) != 0) goto L7;
        if ((r12 & Long.MAX_VALUE) != 0) goto L11;
        this.value = r10;
        if (compareAndSet(0, Long.MIN_VALUE) == true) goto L15;
        this.value = null;
        goto L5
    L15:
        return;
    L11:
        lazySet(-9223372036854775807L);
        this.downstream.onNext(r10);
        this.downstream.onComplete();
        return;
    L7:
        onDrop(r10);
    }

    public abstract /* synthetic */ void onComplete();

    protected void onDrop(R r10) {
    }

    public abstract /* synthetic */ void onError(Throwable r10);

    public abstract /* synthetic */ void onNext(T r10);

    @Override // xb.g, tc.c
    public void onSubscribe(d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // tc.d
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L16;
    L4:
        long r11 = get();
        if ((r11 & Long.MIN_VALUE) != 0) goto L7;
        if (compareAndSet(r11, b.c(r11, r10)) == false) goto L4;
        this.upstream.request(r10);
        return;
    L7:
        if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L) == false) goto L17;
        this.downstream.onNext(this.value);
        this.downstream.onComplete();
        return;
    L17:
        return;
    }
}
