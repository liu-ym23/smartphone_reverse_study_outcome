package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.core.imagex.ECImageXCompact;
import com.bytedance.android.ec.core.imagex.ECImageXCompact$DataSourceSupplierObtain$Companion$dataSourceSupplierObtain$2;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements com.bytedance.android.ec.core.imagex.common.m {
    public final /* synthetic */ AsyncLoadImage.AsyncLoadImageDataSourceHandler a;
    public final /* synthetic */ ImageRequest b;

    public final Object get() {
        ECImageXCompact r0 = ECImageXCompact.c;
        PipelineDraweeController r1 = this.a.e.a;
        if (r1 == null) goto L5;
        String r10 = r1.getId();
    L6:
        ImageRequest r11 = this.b;
        r0.getClass();
        com.bytedance.android.ec.core.imagex.m0.c("ECImageXCompact.getDataSourceSupplierForRequest");
        if (com.bytedance.android.ec.core.imagex.m0.b() == false) goto L9;
        ECImageXCompact.DataSourceSupplierObtain.b.getClass();
        ECImageXCompact.DataSourceSupplierObtain r12 = ((ECImageXCompact$DataSourceSupplierObtain$Companion$dataSourceSupplierObtain$2.a) ECImageXCompact.DataSourceSupplierObtain.a.getValue()).get();
        if (r12 != null) goto L18;
        r12 = new ECImageXCompact.DataSourceSupplierObtain();
    L18:
        Supplier r13 = r12.getDataSourceSupplierForRequest(r1, r10, r11);
    L20:
        return (DataSource) r13.get();
    L9:
        if ((r1 instanceof PipelineDraweeController) == true) goto L11;
        r1 = null;
    L11:
        if (r11 == null) goto L13;
        ImageRequest[] r14 = {r11};
    L14:
        r13 = ECImageXCompact.c(r1, r14, null);
        goto L20
    L13:
        r14 = null;
        goto L14
    L5:
        r10 = null;
        goto L6
    }

    @Override // com.bytedance.android.ec.core.imagex.common.m
    public final ImageRequest getImageRequest() {
        return this.b;
    }

    public d(AsyncLoadImage.AsyncLoadImageDataSourceHandler r1, ImageRequest r10) {
        this.a = r1;
        this.b = r10;
    }
}
