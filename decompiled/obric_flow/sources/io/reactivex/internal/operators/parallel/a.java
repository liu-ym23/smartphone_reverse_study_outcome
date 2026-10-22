package io.reactivex.internal.operators.parallel;

import com.lynx.tasm.behavior.v0;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLongArray;
import zu.d;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ParallelFromPublisher$ParallelDispatcher f18103c;

    public a(ParallelFromPublisher$ParallelDispatcher r5, int r10, int r11) {
        this.f18103c = r5;
        this.f18101a = r10;
        this.f18102b = r11;
    }

    @Override // zu.d
    public final void cancel() {
        ParallelFromPublisher$ParallelDispatcher r5 = this.f18103c;
        AtomicLongArray r10 = r5.requests;
        int r11 = this.f18101a;
        int r12 = this.f18102b;
        if (r10.compareAndSet(r11 + r12, 0, 1) == false) goto L6;
        r5.cancel(r12 + r12);
        return;
    }

    @Override // zu.d
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L17;
        ParallelFromPublisher$ParallelDispatcher r5 = this.f18103c;
        AtomicLongArray r11 = r5.requests;
    L5:
        long r12 = r11.get(this.f18101a);
        if (r12 == Long.MAX_VALUE) goto L7;
        long r13 = v0.t(r12, r10);
        if (r11.compareAndSet(this.f18101a, r12, r13) == false) goto L5;
        if (r5.subscriberCount.get() != this.f18102b) goto L18;
        r5.drain();
        return;
    L18:
        return;
    L7:
        return;
    }
}
