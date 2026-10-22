package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;

/* JADX INFO: loaded from: classes2.dex */
public class CloseableProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<CloseableReference<T>> {
    public CloseableProducerToDataSourceAdapter(Producer r5, SettableProducerContext r10, InternalRequestListener r11) {
        super(r5, r10, r11);
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public final void a(Object r5) {
        CloseableReference.a((CloseableReference) r5);
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public final Object getResult() {
        monitor-enter(this);
        Object r5 = this.d;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        CloseableReference r10 = (CloseableReference) r5;
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.b();
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter
    public final void a(Object r5, int r10, ProducerContext r11) {
        CloseableReference r12 = (CloseableReference) r5;
        if (r12 == null) goto L5;
        CloseableReference r13 = r12.b();
    L6:
        super.a(r13, r10, r11);
        return;
    L5:
        r13 = null;
        goto L6
    }
}
