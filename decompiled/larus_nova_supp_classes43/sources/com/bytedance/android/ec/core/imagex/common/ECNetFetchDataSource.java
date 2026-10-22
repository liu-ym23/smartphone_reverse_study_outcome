package com.bytedance.android.ec.core.imagex.common;

import com.bytedance.android.ec.core.imagex.ECImageXCompact;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECNetFetchDataSource {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;

    public ECNetFetchDataSource() {
    }

    static {
        a = a(ECNetFetchDataSource$mImagePipelineFactory$2.INSTANCE);
        b = a(ECNetFetchDataSource$mProducerSequenceFactory$2.INSTANCE);
        c = a(ECNetFetchDataSource$mProducerFactory$2.INSTANCE);
        d = a(ECNetFetchDataSource$mPostprocessorProducer$2.INSTANCE);
        e = a(ECNetFetchDataSource$mCommonNetworkFetchToEncodedMemorySequence$2.INSTANCE);
        f = a(ECNetFetchDataSource$mNetworkFetchToEncodedMemoryPrefetchSequence$2.INSTANCE);
        g = a(ECNetFetchDataSource$mDecodedImagePrefetchProducerSequence$2.INSTANCE);
        h = a(ECNetFetchDataSource$mBitmapProducer$2.INSTANCE);
        i = a(ECNetFetchDataSource$enableOpt$2.INSTANCE);
    }

    public static Lazy a(Function0 r1) {
        return LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, r1);
    }

    public static DataSource b(Producer r10, ImageRequest r11, ImageRequest.RequestLevel r12, Object r13, RequestListener r14, Priority r15) {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
    L5:
        RequestListener r16 = Fresco.getImagePipeline().getRequestListenerForRequest(r11, r14);
        ImageRequest.RequestLevel r17 = ImageRequest.RequestLevel.getMax(r11.getLowestPermittedRequestLevel(), r12);     // Catch: Throwable -> L20 Exception -> L22
        String r18 = ECImageX.b();     // Catch: Throwable -> L20 Exception -> L22
        ECImageXCompact.c.getClass();     // Catch: Throwable -> L20 Exception -> L22
        boolean r19 = ECImageXCompact.b(r11);     // Catch: Throwable -> L20 Exception -> L22
        if (r11.getProgressiveRenderingEnabled() == false) goto L9;
    L14:
        boolean r20 = true;
    L15:
        DataSource r110 = CloseableProducerToDataSourceAdapter.create(r10, new SettableProducerContext(r11, r18, r16, r13, r17, r19, r20, r15), r16);     // Catch: Throwable -> L20 Exception -> L22
    L17:
        if (FrescoSystrace.isTracing() == false) goto L19;
        FrescoSystrace.endSection();
    L19:
        return r110;
    L9:
        if (r11.getProgressiveRenderingAnimatedEnabled() == true) goto L14;
        if (UriUtil.isNetworkUri(r11.getSourceUri()) == false) goto L14;
        r20 = false;
    L22:
        e = move-exception;
        DataSource r111 = DataSources.immediateFailedDataSource(e);     // Catch: Throwable -> L20
        if (FrescoSystrace.isTracing() == false) goto L27;
        FrescoSystrace.endSection();
    L27:
        return r111;
    L20:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L31;
        FrescoSystrace.endSection();
    L31:
        throw th;
    }
}
