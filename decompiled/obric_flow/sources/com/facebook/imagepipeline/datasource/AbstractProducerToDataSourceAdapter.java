package com.facebook.imagepipeline.datasource;

import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.BaseProducerContext;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SettableProducerContext f8156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InternalRequestListener f8157i;

    public AbstractProducerToDataSourceAdapter(Producer r5, SettableProducerContext r10, InternalRequestListener r11) {
        FrescoSystrace.a().getClass();
        this.f8156h = r10;
        this.f8157i = r11;
        this.f7703a = r10.g;
        FrescoSystrace.a().getClass();
        r11.a(r10);
        FrescoSystrace.a().getClass();
        FrescoSystrace.a().getClass();
        r5.a(new AnonymousClass1(this), r10);
        FrescoSystrace.a().getClass();
        FrescoSystrace.a().getClass();
    }

    public void a(Object r5, int r10, ProducerContext r11) {
        boolean r12 = BaseConsumer.a(r10);
        if (a(r5, r12, ((BaseProducerContext) r11).g) == false) goto L7;
        if (r12 == false) goto L8;
        this.f8157i.c(this.f8156h);
        return;
    L8:
        return;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public final boolean close() {
        if (super.close() == true) goto L7;
        return false;
    L7:
        if (f() == true) goto L11;
        this.f8157i.a(this.f8156h);
        this.f8156h.a();
        return true;
    L11:
        return true;
    }
}
