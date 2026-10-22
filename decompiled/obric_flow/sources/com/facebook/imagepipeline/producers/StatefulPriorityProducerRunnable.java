package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StatefulPriorityProducerRunnable<T> extends StatefulProducerRunnable<T> implements Runnable {
    public StatefulPriorityProducerRunnable(Consumer r5, InternalRequestListener r10, ProducerContext r11) {
        super(r5, r10, r11, "WebpTranscodeProducer");
    }
}
