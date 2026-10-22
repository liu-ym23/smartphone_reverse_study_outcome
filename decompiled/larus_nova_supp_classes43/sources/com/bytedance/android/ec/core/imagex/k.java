package com.bytedance.android.ec.core.imagex;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k extends AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo>.CustomSupplier<DataSource<CloseableReference<CloseableImage>>> {
    public final /* synthetic */ com.bytedance.android.ec.core.imagex.common.m a;

    public final Object get() {
        return (DataSource) this.a.get();
    }

    public final Object getRequest() {
        return this.a.getImageRequest();
    }

    public k(ECImageXCompact.DataSourceSupplierObtain r1, com.bytedance.android.ec.core.imagex.common.m r10) {
        this.a = r10;
        super(r1);
    }
}
