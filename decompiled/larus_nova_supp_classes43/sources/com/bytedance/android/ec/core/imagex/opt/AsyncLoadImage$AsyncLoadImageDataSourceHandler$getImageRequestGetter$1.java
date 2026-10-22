package com.bytedance.android.ec.core.imagex.opt;

import com.facebook.datasource.DataSource;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/facebook/imagepipeline/request/ImageRequest;", "invoke"}, k = 3, mv = {1, 4, 3})
final class AsyncLoadImage$AsyncLoadImageDataSourceHandler$getImageRequestGetter$1 extends Lambda implements Function0<ImageRequest> {
    final /* synthetic */ DataSource $dataSource;

    public AsyncLoadImage$AsyncLoadImageDataSourceHandler$getImageRequestGetter$1(DataSource r1) {
        this.$dataSource = r1;
        super(0);
    }

    public final ImageRequest invoke() {
        FirstAvailableDataSourceSupplier.FirstAvailableDataSource r0 = this.$dataSource;
        Object r10 = null;
        if ((r0 instanceof FirstAvailableDataSourceSupplier.FirstAvailableDataSource) == false) goto L12;
        AbstractDraweeControllerBuilder.CustomSupplier r1 = r0.getCurrentSupplier();
        if ((r1 instanceof AbstractDraweeControllerBuilder.CustomSupplier) == false) goto L13;
        Object r11 = r1.getRequest();
        if ((r11 instanceof ImageRequest) == false) goto L11;
        r10 = r11;
    L11:
        return (ImageRequest) r10;
    L13:
        return null;
    L12:
        return null;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1302invoke() {
        return invoke();
    }
}
