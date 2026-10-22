package io.reactivex.internal.subscriptions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.disposables.b;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<d> implements b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int r1) {
        super(r1);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        int r0 = 0;
        if (get(0) == SubscriptionHelper.CANCELLED) goto L13;
        int r1 = length();
    L5:
        if (r0 >= r1) goto L19;
        if (((d) ZeusTransformUtils.preCheckCast(get(r0), d.class, "com.obric.memorydata.plugin")) == SubscriptionHelper.CANCELLED) goto L12;
        d r2 = (d) ZeusTransformUtils.preCheckCast(getAndSet(r0, SubscriptionHelper.CANCELLED), d.class, "com.obric.memorydata.plugin");
        if (r2 == SubscriptionHelper.CANCELLED) goto L12;
        if (r2 == null) goto L12;
        r2.cancel();
    L12:
        r0 = r0 + 1;
        goto L5
    L19:
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (get(0) != SubscriptionHelper.CANCELLED) goto L6;
        return true;
    L6:
        return false;
    }

    public d replaceResource(int r4, d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
    L3:
        d r0 = (d) ZeusTransformUtils.preCheckCast(get(r4), d.class, "com.obric.memorydata.plugin");
        if (r0 == SubscriptionHelper.CANCELLED) goto L5;
        if (compareAndSet(r4, r0, r6) == false) goto L3;
        return r0;
    L5:
        if (r6 == null) goto L15;
        r6.cancel();
        return null;
    L15:
        return null;
    }

    public boolean setResource(int r4, d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
    L3:
        d r0 = (d) ZeusTransformUtils.preCheckCast(get(r4), d.class, "com.obric.memorydata.plugin");
        if (r0 == SubscriptionHelper.CANCELLED) goto L5;
        if (compareAndSet(r4, r0, r6) == false) goto L3;
        if (r0 == null) goto L19;
        r0.cancel();
        return true;
    L19:
        return true;
    L5:
        if (r6 == null) goto L18;
        r6.cancel();
        return false;
    L18:
        return false;
    }
}
