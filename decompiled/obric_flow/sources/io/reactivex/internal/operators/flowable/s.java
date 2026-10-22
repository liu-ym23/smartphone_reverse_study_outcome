package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements mt.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowableSamplePublisher$SamplePublisherSubscriber f17668a;

    public s(FlowableSamplePublisher$SamplePublisherSubscriber r5) {
        this.f17668a = r5;
    }

    @Override // zu.c
    public final void onComplete() {
        this.f17668a.complete();
    }

    @Override // zu.c
    public final void onError(Throwable r5) {
        this.f17668a.error(r5);
    }

    @Override // zu.c
    public final void onNext(Object r5) {
        this.f17668a.run();
    }

    @Override // zu.c
    public final void onSubscribe(zu.d r5) {
        this.f17668a.setOther(r5);
    }
}
