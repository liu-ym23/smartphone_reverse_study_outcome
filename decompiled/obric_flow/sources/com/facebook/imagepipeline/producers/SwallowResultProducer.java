package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes2.dex */
public class SwallowResultProducer<T> implements Producer<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Producer f8391a;

    public SwallowResultProducer(Producer r5) {
        this.f8391a = r5;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void a(final Consumer r5, ProducerContext r10) {
        DelegatingConsumer<Object, Void> r11 = new AnonymousClass1(r5);
        this.f8391a.a(r11, r10);
    }
}
