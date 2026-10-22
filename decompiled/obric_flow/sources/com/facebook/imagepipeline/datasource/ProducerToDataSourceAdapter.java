package com.facebook.imagepipeline.datasource;

import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;

/* JADX INFO: loaded from: classes2.dex */
public class ProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<T> {
    public ProducerToDataSourceAdapter(Producer r5, SettableProducerContext r10, InternalRequestListener r11) {
        super(r5, r10, r11);
    }
}
