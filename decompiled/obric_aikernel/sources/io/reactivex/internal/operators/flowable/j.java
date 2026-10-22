package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes2.dex */
final class j<T> implements xb.g<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final FlowableSamplePublisher$SamplePublisherSubscriber<T> f9516c;

    j(FlowableSamplePublisher$SamplePublisherSubscriber<T> r10) {
        this.f9516c = r10;
    }

    @Override // tc.c
    public void onComplete() {
        this.f9516c.complete();
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        this.f9516c.error(r10);
    }

    @Override // tc.c
    public void onNext(Object r10) {
        this.f9516c.run();
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        this.f9516c.setOther(r10);
    }
}
