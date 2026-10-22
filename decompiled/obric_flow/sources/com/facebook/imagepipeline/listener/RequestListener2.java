package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener2;
import com.facebook.imagepipeline.producers.SettableProducerContext;

/* JADX INFO: loaded from: classes2.dex */
public interface RequestListener2 extends ProducerListener2 {
    void a(ProducerContext r5);

    void a(ProducerContext r5, Throwable r10);

    void a(SettableProducerContext r5);

    void c(ProducerContext r5);
}
