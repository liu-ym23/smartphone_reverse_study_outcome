package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowableUnsubscribeOn$UnsubscribeSubscriber f17671a;

    public x(FlowableUnsubscribeOn$UnsubscribeSubscriber r5) {
        this.f17671a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17671a.upstream.cancel();
    }
}
