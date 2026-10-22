package io.reactivex.internal.subscribers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements j<T>, d {
    static final long COMPLETE_MASK = Long.MIN_VALUE;
    static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    protected final org.a.c<? super R> downstream;
    protected long produced;
    protected d upstream;
    protected R value;

    public SinglePostCompleteSubscriber(org.a.c<? super R> r3) {
        this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public final void complete(R r9) {
        long r0 = this.produced;
        if (r0 == 0) goto L5;
        io.reactivex.internal.util.b.c(this, r0);
    L5:
        long r1 = get();
        if ((r1 & Long.MIN_VALUE) != 0) goto L7;
        if ((r1 & Long.MAX_VALUE) != 0) goto L11;
        this.value = r9;
        if (compareAndSet(0, Long.MIN_VALUE) == true) goto L15;
        this.value = null;
        goto L5
    L15:
        return;
    L11:
        lazySet(-9223372036854775807L);
        this.downstream.onNext(r9);
        this.downstream.onComplete();
        return;
    L7:
        onDrop(r9);
    }

    public void onDrop(R r1) {
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
        this.upstream = r4;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // org.a.d
    public final void request(long r9) {
        if (SubscriptionHelper.validate(r9) == false) goto L16;
    L4:
        long r0 = get();
        if ((r0 & Long.MIN_VALUE) != 0) goto L7;
        if (compareAndSet(r0, io.reactivex.internal.util.b.a(r0, r9)) == false) goto L4;
        this.upstream.request(r9);
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
