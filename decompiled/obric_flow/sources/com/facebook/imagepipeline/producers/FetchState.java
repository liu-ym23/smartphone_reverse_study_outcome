package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FetchState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Consumer f8305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProducerContext f8306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8307c;

    public FetchState(Consumer r5, ProducerContext r10) {
        this.f8305a = r5;
        this.f8306b = r10;
        this.f8307c = 0;
    }

    public final ProducerListener2 a() {
        return ((BaseProducerContext) this.f8306b).f8259c;
    }
}
