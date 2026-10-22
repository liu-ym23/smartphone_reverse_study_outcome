package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.core.imagex.common.ECNetFetchDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements com.bytedance.android.ec.core.imagex.common.m {
    public Function0<? extends ImageRequest> a;
    public final /* synthetic */ AsyncLoadImage.AsyncLoadImageDataSourceHandler b;

    public final Object get() {
        ImageRequest[] r0 = this.b.a;
        ImageRequest r1 = null;
        if (r0 == null) goto L14;
        ImageRequest r10 = (ImageRequest) ArraysKt.firstOrNull(r0);
        if (r10 == null) goto L14;
        Lazy r11 = ECNetFetchDataSource.a;
        Intrinsics.checkNotNullParameter(r10, "imageRequest");
        if (((Boolean) ECNetFetchDataSource.i.getValue()).booleanValue() == false) goto L14;
        Map r12 = r10.getCustomParam();
        if ((r12 instanceof HashMap) == true) goto L11;
        r12 = null;
    L11:
        HashMap r13 = (HashMap) r12;
        if (r13 == null) goto L14;
        r13.put("ec_custom_fetch_opt", "1");
    L14:
        AsyncLoadImage.AsyncLoadImageDataSourceHandler r14 = this.b;
        ImageRequest[] r15 = r14.a;
        AsyncLoadImage.AsyncLoadImageDataSourceHandler r16 = this.b;
        if ((!Intrinsics.areEqual(r16.b, r16.e.d)) == false) goto L17;
        r1 = this.b.b;
    L17:
        DataSource r17 = (DataSource) r14.c(r15, r1).get();
        this.b.getClass();
        this.a = new AsyncLoadImage$AsyncLoadImageDataSourceHandler$getImageRequestGetter$1(r17);
        return r17;
    }

    @Override // com.bytedance.android.ec.core.imagex.common.m
    public final ImageRequest getImageRequest() {
        Function0<? extends ImageRequest> r0 = this.a;
        if (r0 == null) goto L6;
        ImageRequest r1 = (ImageRequest) r0.invoke();
        if (r1 == null) goto L6;
    L11:
        return r1;
    L6:
        ImageRequest[] r10 = this.b.a;
        if (r10 == null) goto L9;
        r1 = (ImageRequest) ArraysKt.firstOrNull(r10);
    L10:
        Intrinsics.checkNotNull(r1);
        goto L11
    L9:
        r1 = null;
        goto L10
    }

    public e(AsyncLoadImage.AsyncLoadImageDataSourceHandler r1) {
        this.b = r1;
    }
}
