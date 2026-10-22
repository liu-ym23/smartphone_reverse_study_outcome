package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes2.dex */
public class ThreadHandoffProducer<T> implements Producer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Producer f8392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadHandoffProducerQueue f8393b;

    public ThreadHandoffProducer(Producer r5, ThreadHandoffProducerQueue r10) {
        r5.getClass();
        this.f8392a = r5;
        this.f8393b = r10;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(final Consumer r11, final ProducerContext r12) {
        BaseProducerContext r5 = (BaseProducerContext) r12;
        final InternalRequestListener r10 = r5.f8259c;
        final StatefulHandoffProducerRunnable<Object> r13 = new AnonymousClass1(this, r11, r10, r12, r10, r12, r11);
        r5.a(new AnonymousClass2(this, r13));
        ((ThreadHandoffProducerQueueImpl) this.f8393b).a(r13);
    }
}
