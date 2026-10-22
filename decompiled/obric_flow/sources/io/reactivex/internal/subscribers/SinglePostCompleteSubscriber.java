package io.reactivex.internal.subscribers;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import mt.g;
import zu.c;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements g, d {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final c downstream;
    protected long produced;
    protected d upstream;
    protected R value;

    public SinglePostCompleteSubscriber(c r5) {
        this.downstream = r5;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public final void complete(R r10) {
        long r5 = this.produced;
        if (r5 == 0) goto L5;
        v0.y(this, r5);
    L5:
        long r11 = get();
        if ((r11 & Long.MIN_VALUE) != 0) goto L7;
        if ((r11 & Long.MAX_VALUE) != 0) goto L11;
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

    public void onDrop(R r5) {
    }

    public abstract /* synthetic */ void onError(Throwable r5);

    public abstract /* synthetic */ void onNext(Object r5);

    @Override // zu.c
    public void onSubscribe(d r5) {
        if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // zu.d
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L16;
    L4:
        long r5 = get();
        if ((r5 & Long.MIN_VALUE) != 0) goto L7;
        if (compareAndSet(r5, v0.t(r5, r10)) == false) goto L4;
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
