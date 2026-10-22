package com.bytedance.android.ec.core.imagex.opt;

import android.net.Uri;
import com.bytedance.android.ec.core.imagex.ECImageXCompact;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.blurhash.BlurHashMapUtils;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AsyncLoadImage$AsyncLoadImageDataSourceHandler$cacheOrWithAsyncSupplier$1$get$settableProducerContext$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public AsyncLoadImage$AsyncLoadImageDataSourceHandler$cacheOrWithAsyncSupplier$1$get$settableProducerContext$2(AsyncLoadImage.AsyncLoadImageDataSourceHandler r10) {
        super(0, r10, AsyncLoadImage.AsyncLoadImageDataSourceHandler.class, "onBuildImageRequest", "onBuildImageRequest()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1301invoke() {
        AsyncLoadImage.AsyncLoadImageDataSourceHandler r0 = (AsyncLoadImage.AsyncLoadImageDataSourceHandler) ((CallableReference) this).receiver;
        t0.d r1 = r0.e.e;
        ImageRequest[] r10 = r0.a;
        ImageRequest r11 = r0.e.d;
        t0.b r12 = r1.a;
        ImageRequest r13 = null;
        if (r12 != null) goto L55;
        t0 r14 = r1.c;
        t0.c r15 = new t0.c(r10, r11);
        int r16 = t0.d;
        r14.getClass();
        ArrayList r17 = new ArrayList();
        ArrayList r18 = new ArrayList();
        List<Uri> r19 = r14.c();
        r14.a = r19;
        ImageRequestBuilder r20 = r14.a();
        if (r20 != null) goto L7;
        r20 = ImageRequestBuilder.newBuilderWithSource((Uri) CollectionsKt.firstOrNull(r19));
    L7:
        boolean r110 = true;
        if ((!r19.isEmpty()) == false) goto L10;
        r20.setSource((Uri) CollectionsKt.firstOrNull(r19));
    L10:
        int r21 = r19.size();
        int r111 = 1;
    L11:
        if (r111 >= r21) goto L16;
        Uri r112 = (Uri) CollectionsKt.getOrNull(r19, r111);
        if (r112 == null) goto L15;
        r18.add(r112);
    L15:
        r111 = r111 + 1;
        goto L11
    L16:
        r14.b(r20);
        r17.add(r20.build());
        Object[] r22 = r17.toArray(new ImageRequest[0]);
        if (r22 == null) goto L54;
        r15.a = (ImageRequest[]) r22;
        Object[] r23 = r18.toArray(new Uri[0]);
        if (r23 == null) goto L52;
        r15.c = (Uri[]) r23;
        ImageRequest r24 = r15.b;
        r14.d(r15);
        if (r24 != r15.b) goto L23;
        r15.b = null;
    L23:
        ImageRequest[] r25 = r15.a;
        if (r14.c.compareAndSet(true, false) == false) goto L26;
        r14.e();
    L26:
        if (r25 != null) goto L28;
    L34:
        boolean r26 = true;
    L35:
        if (r26 == false) goto L38;
        r25 = null;
    L38:
        Uri[] r27 = r15.c;
        if (r27 != null) goto L41;
    L47:
        if (r110 == false) goto L50;
        r27 = null;
    L50:
        t0.b r28 = new t0.b(r20, r25, r27, r15.b);
        r1.a = r28;
        r12 = r28;
        goto L55
    L41:
        if (r27.length != 0) goto L43;
        boolean r29 = true;
    L44:
        if (r29 == true) goto L47;
        r110 = false;
        goto L47
    L43:
        r29 = false;
        goto L44
    L28:
        if (r25.length != 0) goto L30;
        boolean r30 = true;
    L31:
        if (r30 == true) goto L34;
        r26 = false;
        goto L35
    L30:
        r30 = false;
        goto L31
    L52:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L54:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L55:
        r0.c = r12;
        ImageRequest[] r31 = r12.b;
        if (r31 == null) goto L58;
        r0.a = r31;
    L58:
        t0.b r32 = r0.c;
        if (r32 == null) goto L63;
        ImageRequest r33 = r32.d;
        if (r33 == null) goto L63;
        r0.b = r33;
    L63:
        ImageRequest[] r34 = r0.a;
        if (r34 == null) goto L91;
        ImageRequest r35 = (ImageRequest) ArraysKt.firstOrNull(r34);
        if (r35 == null) goto L91;
        PipelineDraweeController r36 = r0.e.a;
        if (r36 == null) goto L70;
        r13 = r36.getImageRequest();
    L70:
        if (r13 == null) goto L74;
        SizeDeterminer r37 = r13.getSizeDeterminer();
        if (r37 == null) goto L74;
        r35.setSizeDeterminer(r37);
    L74:
        PipelineDraweeController r38 = r0.e.a;
        if (r38 == null) goto L77;
        r38.setImageRequest(r35);
    L77:
        ECImageXCompact r39 = ECImageXCompact.c;
        PipelineDraweeController r40 = r0.e.a;
        r39.getClass();
        Intrinsics.checkNotNullParameter(r35, "imageRequest");
        com.bytedance.android.ec.core.imagex.m0.c("ECImageXCompact.updateBlurHashMap");
        if (com.bytedance.android.ec.core.imagex.m0.b() == false) goto L91;
        if (BlurHashMapUtils.isEnableBlurHash() == true) goto L85;
        if (r35.isUseSingleHeaderBlurhash() == false) goto L91;
    L85:
        if (r35.getSourceUri() == null) goto L91;
        if (r13 == null) goto L90;
        Uri r41 = r13.getSourceUri();
        if (r41 == null) goto L90;
        BlurHashMapUtils.removeListener(r41);
    L90:
        BlurHashMapUtils.putListener(r35.getSourceUri(), new WeakReference(r40));
    L91:
        ImageRequest[] r42 = r0.a;
        if (r42 == null) goto L94;
        Intrinsics.checkNotNullParameter(r42, "imageRequests");
        AsyncLoadImage.b r43 = r0.e;
        r43.getClass();
        Intrinsics.checkNotNullParameter(r42, "imageRequests");
        r43.c = r42;
    L94:
        ImageRequest r44 = r0.b;
        if (r44 == null) goto L101;
        r0.e.d = r44;
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1301invoke();
        return Unit.INSTANCE;
    }
}
