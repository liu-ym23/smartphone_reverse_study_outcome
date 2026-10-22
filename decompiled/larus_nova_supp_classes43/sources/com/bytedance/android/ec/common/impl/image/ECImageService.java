package com.bytedance.android.ec.common.impl.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.common.api.image.IECImageService;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.imagex.t;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.api.image.l;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u009b\u0001\u0010'\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0010\u0010\u001f\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\n\u0018\u00010$H\u0016¢\u0006\u0004\b'\u0010(J\u0095\u0001\u0010'\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0010\u0010\u001f\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\n\u0018\u00010$H\u0016¢\u0006\u0004\b'\u0010*J]\u0010-\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010,\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0004\u0012\u00020\n\u0018\u00010$H\u0016¢\u0006\u0004\b-\u0010.JW\u0010-\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\u0010,\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0004\u0012\u00020\n\u0018\u00010$H\u0016¢\u0006\u0004\b-\u0010/J*\u00102\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u0001002\u0016\u0010,\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0004\u0012\u00020\n\u0018\u00010$H\u0016J[\u00106\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u00104\u001a\u0004\u0018\u0001032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u00105\u001a\u00020 H\u0016¢\u0006\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/bytedance/android/ec/common/impl/image/ECImageService;", "Lcom/bytedance/android/ec/common/api/image/IECImageService;", "", "bizTag", "sceneTag", "Lcom/bytedance/android/shopping/api/image/l;", "generateCallerContext", "Lcom/facebook/drawee/view/GenericDraweeView;", "genericDraweeView", "callerContext", "", "bindCallerContext", "Landroid/content/Context;", "context", "registerCallerContext", "id", "getCallerContext", "unregisterCallerContext", "", "urlList", "Lcom/facebook/imagepipeline/request/ImageRequest;", "lowResImageRequest", "", "resizeWidth", "resizeHeight", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "Lcom/facebook/imagepipeline/request/Postprocessor;", "postprocessor", "Lcom/facebook/drawee/controller/ControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "controllerListener", "", "autoPlayAnimations", "Lcom/facebook/imagepipeline/common/Priority;", "priority", "Lkotlin/Function1;", "Lcom/facebook/drawee/interfaces/DraweeController;", "controllerInterceptor", "bindImage", "(Lcom/facebook/drawee/view/GenericDraweeView;Ljava/util/List;Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/bytedance/android/shopping/api/image/l;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/Bitmap$Config;Lcom/facebook/imagepipeline/request/Postprocessor;Lcom/facebook/drawee/controller/ControllerListener;ZLcom/facebook/imagepipeline/common/Priority;Lkotlin/jvm/functions/Function1;)V", a.KEY_URL, "(Lcom/facebook/drawee/view/GenericDraweeView;Ljava/lang/String;Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/bytedance/android/shopping/api/image/l;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/Bitmap$Config;Lcom/facebook/imagepipeline/request/Postprocessor;Lcom/facebook/drawee/controller/ControllerListener;ZLcom/facebook/imagepipeline/common/Priority;Lkotlin/jvm/functions/Function1;)V", "Landroid/graphics/Bitmap;", "consumer", "fetchImage", "(Ljava/util/List;Lcom/bytedance/android/shopping/api/image/l;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/facebook/imagepipeline/request/Postprocessor;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/image/l;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/facebook/imagepipeline/request/Postprocessor;Lkotlin/jvm/functions/Function1;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "urlModel", "fetchImageByUrl", "Lcom/facebook/imagepipeline/listener/RequestListener;", "requestListener", "prefetchToMemoryCache", "prefetchImageToCache", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/image/l;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/facebook/imagepipeline/common/Priority;Lcom/facebook/imagepipeline/listener/RequestListener;Lcom/facebook/imagepipeline/request/Postprocessor;Z)V", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECImageService implements IECImageService {
    public ECImageService() {
        boolean r0 = ECServiceManager.a;
        ECServiceManager.e(IECImageService.class, this);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public l getCallerContext(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        r r1 = t.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        Map<String, r> r0 = t.b;
        Activity r11 = l0.b(r10);
        if (r11 == null) goto L5;
        r10 = r11;
    L5:
        ConcurrentHashMap r12 = (ConcurrentHashMap) r0;
        return (r) r12.get(String.valueOf(r10.hashCode()));
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public l unregisterCallerContext(String r10) {
        Intrinsics.checkNotNullParameter(r10, "id");
        r r1 = t.a;
        Intrinsics.checkNotNullParameter(r10, "id");
        return (r) ((ConcurrentHashMap) t.b).remove(r10);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public l getCallerContext(String r10) {
        Intrinsics.checkNotNullParameter(r10, "id");
        r r1 = t.a;
        Intrinsics.checkNotNullParameter(r10, "id");
        return (r) ((ConcurrentHashMap) t.b).get(r10);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public l unregisterCallerContext(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return t.c(r10);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public void bindCallerContext(GenericDraweeView r10, l r11) {
        Intrinsics.checkNotNullParameter(r10, "genericDraweeView");
        if ((r11 instanceof r) == true) goto L5;
        r11 = null;
    L5:
        ImageExtensionsKt.D(r10, (r) r11);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public void fetchImageByUrl(ECUrlModel r10, Function1<? super Bitmap, Unit> r11) {
        h0.g(r10, null, r11);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public l generateCallerContext(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "bizTag");
        Intrinsics.checkNotNullParameter(r11, "sceneTag");
        return new r(r10, r11);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public void registerCallerContext(String r10, l r11) {
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        if ((r11 instanceof r) == true) goto L5;
        return;
    L5:
        r r12 = (r) r11;
        r r13 = t.a;
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r12, "callerContext");
        if (StringsKt.isBlank(r10) == true) goto L10;
        ((ConcurrentHashMap) t.b).put(r10, r12);
        return;
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public void registerCallerContext(Context r10, l r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        if ((r11 instanceof r) == true) goto L5;
        return;
    L5:
        t.b(r10, (r) r11);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public void fetchImage(String r10, l r11, Integer r12, Integer r13, Postprocessor r14, Function1<? super Bitmap, Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, a.KEY_URL);
        if ((r11 instanceof r) == true) goto L5;
        r11 = null;
    L5:
        ImageExtensionsKt.f(r10, (r) r11, r12, r13, r14, r15, 96);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public void fetchImage(List<String> r10, l r11, Integer r12, Integer r13, Postprocessor r14, Function1<? super Bitmap, Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, "urlList");
        if ((r11 instanceof r) == true) goto L5;
        r11 = null;
    L5:
        ImageExtensionsKt.g(r10, (r) r11, r12, r13, r14, r15);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public void prefetchImageToCache(String r11, l r12, Integer r13, Integer r14, Priority r15, RequestListener r16, Postprocessor r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r11, a.KEY_URL);
        l r0 = r12;
        if ((r0 instanceof r) == true) goto L5;
        r0 = null;
    L5:
        ImageExtensionsKt.B(r11, (r) r0, r13, r14, r15, r16, r17, r18, 128);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public void bindImage(GenericDraweeView r16, List<String> r17, ImageRequest r18, l r19, Integer r20, Integer r21, Bitmap.Config r22, Postprocessor r23, ControllerListener<? super ImageInfo> r24, boolean r25, Priority r26, Function1<? super DraweeController, Unit> r27) {
        Intrinsics.checkNotNullParameter(r16, "genericDraweeView");
        Intrinsics.checkNotNullParameter(r17, "urlList");
        l r0 = r19;
        if ((r0 instanceof r) == true) goto L5;
        r0 = null;
    L5:
        ImageExtensionsKt.x(r16, r17, r18, (r) r0, r20, r21, r22, r23, r24, r25, r26, r27, null, 6144);
    }

    @Override // com.bytedance.android.ec.common.api.image.IECImageService
    public void bindImage(GenericDraweeView r15, String r16, ImageRequest r17, l r18, Integer r19, Integer r20, Bitmap.Config r21, Postprocessor r22, ControllerListener<? super ImageInfo> r23, boolean r24, Priority r25, Function1<? super DraweeController, Unit> r26) {
        Intrinsics.checkNotNullParameter(r15, "genericDraweeView");
        Intrinsics.checkNotNullParameter(r16, a.KEY_URL);
        l r0 = r18;
        if ((r0 instanceof r) == true) goto L5;
        r0 = null;
    L5:
        ImageExtensionsKt.w(r15, r16, r17, (r) r0, r19, r20, r21, r22, r23, r24, r25, r26, 2048);
    }
}
