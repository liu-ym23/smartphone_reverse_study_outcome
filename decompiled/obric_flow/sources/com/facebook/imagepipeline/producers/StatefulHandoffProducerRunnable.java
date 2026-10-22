package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StatefulHandoffProducerRunnable<T> extends StatefulProducerRunnable<T> {
    public StatefulHandoffProducerRunnable(Consumer r5, InternalRequestListener r10, ProducerContext r11) {
        super(r5, r10, r11, "BackgroundThreadHandoffProducer");
    }
}
