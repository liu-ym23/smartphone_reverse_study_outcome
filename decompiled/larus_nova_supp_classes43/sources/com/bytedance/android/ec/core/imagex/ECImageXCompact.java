package com.bytedance.android.ec.core.imagex;

import android.net.Uri;
import com.bytedance.android.ec.core.imagex.common.ECNetFetchDataSource;
import com.bytedance.android.ec.core.imagex.opt.ECImageBitmapPrepareToDraw;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BitmapPrepareProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECImageXCompact {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final ECImageXCompact c = null;

    public static final class DataSourceSupplierObtain extends PipelineDraweeControllerBuilder {
        public static final Lazy a = null;
        public static final a b = null;

        public static final class a {
            public a() {
            }
        }

        static {
            b = new a();
            a = LazyKt.lazy(ECImageXCompact$DataSourceSupplierObtain$Companion$dataSourceSupplierObtain$2.INSTANCE);
        }

        public DataSourceSupplierObtain() {
            super(uf4.a.a(), new PipelineDraweeControllerFactory(), Fresco.getImagePipelineFactory().getImagePipeline(), null);
        }

        public final DataSource<CloseableReference<CloseableImage>> getDataSourceForRequest(DraweeController r15, String r16, ImageRequest r17, Object r18, AbstractDraweeControllerBuilder.CacheLevel r19) {
            boolean r0 = r15 instanceof AbstractDraweeController;
            DataSource<CloseableReference<CloseableImage>> r1 = null;
            if (r0 == true) goto L5;
            DraweeController r10 = null;
        L6:
            AbstractDraweeController r11 = (AbstractDraweeController) r10;
            if (r11 == null) goto L9;
            Object r12 = r11.getCallerContext();
        L10:
            if (r0 == true) goto L12;
            DraweeController r13 = null;
        L13:
            AbstractDraweeController r14 = (AbstractDraweeController) r13;
            if (r14 == null) goto L16;
            String r110 = r14.getId();
        L17:
            Lazy r20 = ECNetFetchDataSource.a;
            if (r17 == null) goto L20;
            Uri r21 = r17.getSourceUri();
        L21:
            int r22 = 0;
            if (((Boolean) ECNetFetchDataSource.i.getValue()).booleanValue() == true) goto L25;
        L37:
            boolean r23 = false;
        L38:
            if (r23 == false) goto L114;
            if (r17 == null) goto L111;
            ImageRequest.RequestLevel r24 = PipelineDraweeControllerBuilder.convertCacheLevelToRequestLevel(r19);
            if ((r15 instanceof PipelineDraweeController) == false) goto L44;
            RequestListener r25 = ((PipelineDraweeController) r15).getRequestListener();
        L45:
            Priority r26 = Priority.getHigherPriority(Priority.HIGH, r17.getPriority());
            if (r17.getPostprocessor() == null) goto L48;
            Producer r27 = (Producer) ECNetFetchDataSource.d.getValue();
        L49:
            Producer r28 = r27;
            if (r28 == null) goto L103;
            ECImageBitmapPrepareToDraw r29 = ECImageBitmapPrepareToDraw.f;
            r29.getClass();
            Lazy r30 = ECImageBitmapPrepareToDraw.d;
            if (((Boolean) r30.getValue()).booleanValue() == true) goto L55;
            boolean r111 = false;
        L69:
            if (r111 == false) goto L104;
            Intrinsics.checkNotNullParameter(r28, "inputProducer");
            if (((Boolean) r30.getValue()).booleanValue() == false) goto L104;
            ReadOnlyProperty r31 = ECImageBitmapPrepareToDraw.e;
            KProperty[] r112 = ECImageBitmapPrepareToDraw.a;
            if (((com.bytedance.android.shopping.api.image.a) r31.getValue(r29, r112[0])) != null) goto L76;
            HashMap<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> r113 = ECImageBitmapPrepareToDraw.c;
        L80:
            if (r113 == null) goto L104;
            Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L101
            Producer r115 = r113.get(r28);     // Catch: Throwable -> L101
            if (r115 != null) goto L100;
            com.bytedance.android.shopping.api.image.a r32 = (com.bytedance.android.shopping.api.image.a) r31.getValue(r29, r112[0]);     // Catch: Throwable -> L101
            if (r32 == null) goto L86;
            Integer r33 = r32.b();     // Catch: Throwable -> L101
        L87:
            if (r33 != null) goto L89;
        L98:
            int r34 = 10485760;
        L99:
            r115 = new BitmapPrepareProducer(r28, r22, r34, true);     // Catch: Throwable -> L101
            r113.put(r28, r115);     // Catch: Throwable -> L101
            goto L100
        L89:
            if (r32.a() == null) goto L98;
            Integer r35 = r32.b();     // Catch: Throwable -> L101
            if (r35 == null) goto L93;
            int r36 = r35.intValue();     // Catch: Throwable -> L101
        L94:
            Integer r37 = r32.a();     // Catch: Throwable -> L101
            if (r37 == null) goto L97;
            r22 = r37.intValue();     // Catch: Throwable -> L101
        L97:
            r34 = r22;
            r22 = r36;
            goto L99
        L93:
            r36 = 0;
            goto L94
        L86:
            r33 = null;
        L100:
            r28 = r115;
        L101:
            th = move-exception;
            Result.Companion r38 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L104
        L76:
            if (ECImageBitmapPrepareToDraw.c == null) goto L78;
            ECImageBitmapPrepareToDraw.c = null;
        L78:
            r113 = ECImageBitmapPrepareToDraw.b;
        L104:
            if (r28 == null) goto L111;
            DataSource<CloseableReference<CloseableImage>> r39 = ECNetFetchDataSource.b(r28, r17, r24, r12, r25, r26);     // Catch: Throwable -> L109
        L108:
            r1 = r39;
        L109:
            th = move-exception;
            r39 = DataSources.immediateFailedDataSource(th);
            goto L108
        L55:
            if ((r12 instanceof r) == true) goto L57;
            Object r116 = null;
        L58:
            r r117 = (r) r116;
            if (r117 == null) goto L67;
            com.bytedance.android.shopping.api.image.a r118 = (com.bytedance.android.shopping.api.image.a) ECImageBitmapPrepareToDraw.e.getValue(r29, ECImageBitmapPrepareToDraw.a[0]);
            if (r118 == null) goto L67;
            u r119 = s.a(r117);
            if (r119 == null) goto L65;
            com.bytedance.android.shopping.api.image.q r120 = r119.n();
        L66:
            Boolean r121 = Boolean.valueOf(com.bytedance.android.ec.core.imagex.common.l.b(r118, r117, r120));
        L68:
            r111 = Intrinsics.areEqual(r121, Boolean.TRUE);
            goto L69
        L65:
            r120 = null;
        L67:
            r121 = null;
            goto L68
        L57:
            r116 = r12;
            goto L58
        L103:
            r28 = null;
            goto L104
        L48:
            r27 = (Producer) ECNetFetchDataSource.h.getValue();
            goto L49
        L44:
            r25 = null;
        L111:
            if (r1 == null) goto L114;
            return r1;
        L114:
            return super.getDataSourceForRequest(r15, r110, r17, r12, r19);
        L25:
            if (UriUtil.isLocalResourceUri(r21) == true) goto L37;
            if (UriUtil.isQualifiedResourceUri(r21) == true) goto L37;
            if (UriUtil.isNetworkUri(r21) == false) goto L37;
            if (r17 == null) goto L35;
            Map r40 = r17.getCustomParam();
            if (r40 == null) goto L35;
            String r41 = (String) r40.get("ec_custom_fetch_opt");
        L36:
            r23 = Intrinsics.areEqual(r41, "1");
        L35:
            r41 = null;
            goto L36
        L20:
            r21 = null;
            goto L21
        L16:
            r110 = null;
            goto L17
        L12:
            r13 = r15;
            goto L13
        L9:
            r12 = null;
            goto L10
        L5:
            r10 = r15;
            goto L6
        }

        public final /* bridge */ /* synthetic */ DataSource getDataSourceForRequest(DraweeController r1, String r10, Object r11, Object r12, AbstractDraweeControllerBuilder.CacheLevel r13) {
            return getDataSourceForRequest(r1, r10, (ImageRequest) r11, r12, r13);
        }
    }

    public ECImageXCompact() {
    }

    static {
        c = new ECImageXCompact();
        a = LazyKt.lazy(ECImageXCompact$imageRequestEnableNetworkPriorityGetter$2.INSTANCE);
        b = LazyKt.lazy(ECImageXCompact$imageRequestBuilderEnableNetworkPrioritySetter$2.INSTANCE);
    }

    public static boolean b(ImageRequest r10) {
        Intrinsics.checkNotNullParameter(r10, "imageRequest");
        m0.c("ECImageXCompact.isPrefetch");
        if (m0.b() == true) goto L7;
        Intrinsics.checkNotNullParameter(r10, "imageRequest");
        return false;
    L7:
        return r10.isPrefetch();
    }

    public static void d(ImageRequestBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "imageRequestBuilder");
        m0.c("ECImageXCompact.setEnableNetworkPriority");
        if (m0.b() == true) goto L14;
        return;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Method r1 = (Method) b.getValue();     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        Object r11 = r1.invoke(r10, new Object[]{Boolean.TRUE});     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(r11);     // Catch: Throwable -> L11
        return;
    L8:
        r11 = null;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static Supplier e(com.bytedance.android.ec.core.imagex.common.m r10) {
        Intrinsics.checkNotNullParameter(r10, "supplier");
        m0.c("ECImageXCompact.transformSupplier");
        if (m0.b() == true) goto L5;
        return r10;
    L5:
        DataSourceSupplierObtain.b.getClass();
        Intrinsics.checkNotNullParameter(r10, "supplier");
        DataSourceSupplierObtain r1 = ((ECImageXCompact$DataSourceSupplierObtain$Companion$dataSourceSupplierObtain$2.a) DataSourceSupplierObtain.a.getValue()).get();
        if (r1 != null) goto L8;
        r1 = new DataSourceSupplierObtain();
    L8:
        Intrinsics.checkNotNullParameter(r10, "supplier");
        return new k(r1, r10);
    }

    public static void a(PipelineDraweeControllerBuilder r1, ImageRequest[] r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$compactSetFirstAvailableImageRequests");
        Intrinsics.checkNotNullParameter(r10, "imageRequests");
        m0.c("ECImageXCompact.compactSetFirstAvailableImageRequests");
        if (m0.b() == true) goto L6;
        r1.setFirstAvailableImageRequests(r10);
        return;
    L6:
        r1.setKeepFirstAvailableRequest(true);
        r1.setFirstAvailableImageRequests(r10, false);
    }

    public static Supplier c(PipelineDraweeController r1, ImageRequest[] r10, ImageRequest r11) {
        m0.c("ECImageXCompact.obtainDataSourceSupplier");
        if (m0.b() == false) goto L5;
        DataSourceSupplierObtain.b.getClass();
        DataSourceSupplierObtain r0 = ((ECImageXCompact$DataSourceSupplierObtain$Companion$dataSourceSupplierObtain$2.a) DataSourceSupplierObtain.a.getValue()).get();
        if (r0 != null) goto L9;
        r0 = new DataSourceSupplierObtain();
    L9:
        ImageExtensionsKt.d(r0, r10, r11);
        if (r1 == null) goto L12;
        String r12 = r1.getId();
    L14:
        return r0.obtainDataSourceSupplier(r1, r12);
    L12:
        r12 = null;
        goto L14
    L5:
        return DataSources.getFailedDataSourceSupplier(new NullPointerException("not support sass"));
    }
}
