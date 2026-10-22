package com.bytedance.android.ec.core.imagex;

import android.graphics.Bitmap;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Proxy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SimpleFrescoLoaderKt {
    public static final void a(GenericDraweeView r10, String r11, ImageRequest[] r12, ImageRequest r13, r r14, ControllerListener r15, boolean r16, Function1 r17) {
        dm.a.a("FirstScreenStatistic").a("SimpleFrescoLoad failed, fallback to Normal Fresco " + r11);
        r10.post(new v0(r10, r12, r13, r14, r15, r16, r17));
    }

    public static final void b(final GenericDraweeView r17, final String r18, final String r19, final Map<String, String> r20, final ImageRequest[] r21, final ImageRequest r22, final r r23, final ControllerListener<? super ImageInfo> r24, final boolean r25, final Function1<? super DraweeController, Unit> r26) {
        Intrinsics.checkNotNullParameter(r17, "$this$simpleFrescoLoad");
        Intrinsics.checkNotNullParameter(r18, "cleanUrl");
        Intrinsics.checkNotNullParameter(r19, "sceneTag");
        Intrinsics.checkNotNullParameter(r20, "extra");
        Intrinsics.checkNotNullParameter(r21, "imageRequests");
        Intrinsics.checkNotNullParameter(r23, "callerContext");
        m0.c("GenericDraweeView.simpleFrescoLoad");
        if (m0.b() == true) goto L5;
        return;
    L5:
        dm.a.a("FirstScreenStatistic").a(ThreadMethodProxy.currentThread().getName() + " SimpleFrescoLoad " + r18);
        FirstScreenStatistic.S.getClass();
        FirstScreenStatistic.j(r18);
        Lazy r1 = SimpleFrescoLoaderReflector.a;
        Function3<Boolean, CloseableImage, String, Unit> r10 = new SimpleFrescoLoaderKt$simpleFrescoLoad$simpleLoaderStarted$1(r17, r20, r18, r24, r19, r21, r22, r23, r25, r26);
        Intrinsics.checkNotNullParameter(r18, "cleanUrl");
        Intrinsics.checkNotNullParameter(r10, "decodeResult");
        SimpleFrescoLoaderReflector.a r11 = (SimpleFrescoLoaderReflector.a) SimpleFrescoLoaderReflector.a.getValue();
        boolean r12 = false;
        if (r11 == null) goto L12;
        Intrinsics.checkNotNullParameter(r18, "cleanUrl");
        Intrinsics.checkNotNullParameter(r10, "decodeResult");
        r11.c.invoke(r11.a, new Object[]{r18, null, 2, null, Priority.IMMEDIATE, Boolean.TRUE, Proxy.newProxyInstance(r11.b.getClassLoader(), new Class[]{r11.b}, new x0(r10))});     // Catch: Throwable -> L10
        r12 = true;
    L10:
        th = move-exception;
        dm.a.a("FirstScreenStatistic").b("SimpleFrescoLoad reflection invoke failed, fallback to Normal Fresco " + r18 + ", error " + th, null);
    L12:
        if (r12 == true) goto L26;
        Function2<Boolean, Bitmap, Unit> r14 = new SimpleFrescoLoaderKt$simpleFrescoLoad$1(r17, r20, r18, r24, r19, r21, r22, r23, r25, r26);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        ImageRequestBuilder r13 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r18));     // Catch: Throwable -> L16
        r13.setRequestPriority(Priority.IMMEDIATE);     // Catch: Throwable -> L16
        Fresco.getImagePipeline().fetchDecodedImage(r13.build(), null).subscribe(new w0(r18, r20, r14), SimpleFrescoLoaderKt$SIMPLE_FRESCO_LOAD_EXECUTOR$1.a);     // Catch: Throwable -> L16
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L27;
        dm.a.a("FirstScreenStatistic").b("fetchBitmapByUrl submit failed " + r16, null);
        FirstScreenStatistic.S.getClass();
        FirstScreenStatistic.n("fetchBitmapByUrl", "submit failed", r16, r20);
        r14.invoke(Boolean.FALSE, null);
        return;
    L27:
        return;
    L16:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
