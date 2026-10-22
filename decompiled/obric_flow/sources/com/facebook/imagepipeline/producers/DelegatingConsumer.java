package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DelegatingConsumer<I, O> extends BaseConsumer<I> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Consumer f8287b;

    public DelegatingConsumer(Consumer r5) {
        this.f8287b = r5;
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void b(Throwable r5) {
        ((BaseConsumer) this.f8287b).a(r5);
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void b() {
        ((BaseConsumer) this.f8287b).a();
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void b(float r5) {
        ((BaseConsumer) this.f8287b).a(r5);
    }
}
