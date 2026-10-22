package com.bytedance.android.ec.core.imagex.opt;

import android.net.Uri;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements com.bytedance.android.ec.core.imagex.common.m {
    public Function0<? extends ImageRequest> a;
    public final /* synthetic */ AsyncLoadImage.AsyncLoadImageDataSourceHandler b;

    public final Object get() {
        ArrayList r0 = new ArrayList();
        t0.b r1 = this.b.c;
        if (r1 == null) goto L25;
        Uri[] r10 = r1.c;
        boolean r11 = true;
        if (r10 != null) goto L7;
    L13:
        if (r11 == true) goto L22;
        ArrayList r12 = new ArrayList(r10.length);
        int r13 = r10.length;
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L17;
        Uri r15 = r10[r14];
        Intrinsics.checkNotNullParameter(r15, "uri");
        r12.add(r1.a.setSource(r15).build());
        r14 = r14 + 1;
        goto L15
    L17:
        Object[] r16 = r12.toArray(new ImageRequest[0]);
        if (r16 == null) goto L21;
        ImageRequest[] r17 = (ImageRequest[]) r16;
    L23:
        if (r17 == null) goto L25;
        CollectionsKt.addAll(r0, r17);
        goto L25
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L22:
        r17 = null;
        goto L23
    L7:
        if (r10.length != 0) goto L9;
        boolean r18 = true;
    L10:
        if (r18 == true) goto L13;
        r11 = false;
        goto L13
    L9:
        r18 = false;
    L25:
        Object r19 = this.b.e.b;
        if ((r19 instanceof com.bytedance.android.ec.core.imagex.r) == true) goto L28;
        r19 = null;
    L28:
        com.bytedance.android.ec.core.imagex.r r20 = (com.bytedance.android.ec.core.imagex.r) r19;
        if (r20 == null) goto L39;
        KProperty[] r21 = ImageExtensionsKt.a;
        Intrinsics.checkNotNullParameter(r20, "$this$tryGetDomainBackupUrls");
        com.bytedance.android.shopping.api.image.r r22 = s.d(r20);
        if (r22 == null) goto L39;
        if (r22.n() == null) goto L39;
        cj.b r23 = (cj.b) ImageExtensionsKt.b.getValue(null, ImageExtensionsKt.a[0]);
        if (r23 == null) goto L39;
        r23.b();
    L39:
        if (r0.isEmpty() == false) goto L45;
        ImageRequest[] r24 = this.b.a;
        if (r24 == null) goto L45;
        ImageRequest r25 = (ImageRequest) ArraysKt.lastOrNull(r24);
        if (r25 == null) goto L45;
        r0.add(r25);
    L45:
        AsyncLoadImage.AsyncLoadImageDataSourceHandler r26 = this.b;
        Object[] r27 = r0.toArray(new ImageRequest[0]);
        if (r27 == null) goto L50;
        DataSource r28 = (DataSource) r26.c((ImageRequest[]) r27, null).get();
        this.b.getClass();
        this.a = new AsyncLoadImage$AsyncLoadImageDataSourceHandler$getImageRequestGetter$1(r28);
        return r28;
    L50:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
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
        r1 = (ImageRequest) ArraysKt.lastOrNull(r10);
    L10:
        Intrinsics.checkNotNull(r1);
        goto L11
    L9:
        r1 = null;
        goto L10
    }

    public b(AsyncLoadImage.AsyncLoadImageDataSourceHandler r1) {
        this.b = r1;
    }
}
