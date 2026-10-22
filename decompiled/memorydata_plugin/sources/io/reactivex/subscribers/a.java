package io.reactivex.subscribers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a<T> implements io.reactivex.disposables.b, j<T> {
    final AtomicReference<d> f;

    public a() {
        this.f = new AtomicReference();
    }

    public void b() {
        ((d) ZeusTransformUtils.preCheckCast(this.f.get(), d.class, "com.obric.memorydata.plugin")).request(Long.MAX_VALUE);
    }

    public final void c() {
        dispose();
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        SubscriptionHelper.cancel(this.f);
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        if (this.f.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.j, org.a.c
    public final void onSubscribe(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (io.reactivex.internal.util.d.a(this.f, r4, getClass()) == false) goto L6;
        b();
        return;
    }
}
