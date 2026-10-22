package io.reactivex.internal.subscribers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.a.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b<T, R> implements d<R>, j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final org.a.c<? super R> f17149b;
    protected org.a.d c;
    protected d<T> d;
    protected boolean e;
    protected int f;

    public b(org.a.c<? super R> r3) {
        this.f17149b = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
    }

    public final int a(int r3) {
        d<T> r0 = this.d;
        if (r0 != null) goto L5;
        return 0;
    L5:
        if ((r3 & 4) != 0) goto L12;
        int r4 = r0.requestFusion(r3);
        if (r4 == 0) goto L9;
        this.f = r4;
    L9:
        return r4;
    L12:
        return 0;
    }

    public final void a(Throwable r2) {
        io.reactivex.exceptions.a.a(r2);
        this.c.cancel();
        onError(r2);
    }

    public boolean a() {
        return true;
    }

    public void b() {
    }

    @Override // org.a.d
    public void cancel() {
        this.c.cancel();
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
        this.d.clear();
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return this.d.isEmpty();
    }

    @Override // io.reactivex.internal.a.f
    public final boolean offer(R r1) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // org.a.c
    public void onComplete() {
        if (this.e == false) goto L5;
        return;
    L5:
        this.e = true;
        this.f17149b.onComplete();
    }

    @Override // org.a.c
    public void onError(Throwable r2) {
        if (this.e == false) goto L6;
        io.reactivex.d.a.a(r2);
        return;
    L6:
        this.e = true;
        this.f17149b.onError(r2);
    }

    @Override // io.reactivex.j, org.a.c
    public final void onSubscribe(org.a.d r3) {
        org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
        if (SubscriptionHelper.validate(this.c, r4) == false) goto L11;
        this.c = r4;
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L8;
        this.d = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin");
    L8:
        if (a() == false) goto L12;
        this.f17149b.onSubscribe(this);
        b();
        return;
    L12:
        return;
    }

    @Override // org.a.d
    public void request(long r1) {
        this.c.request(r1);
    }
}
