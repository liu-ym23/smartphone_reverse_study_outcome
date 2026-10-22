package com.bytedance.android.ec.common.api.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.ec.core.event.a;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\fH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0002H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\fH&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0002H&J¯\u0001\u0010'\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0012\b\u0002\u0010\u001f\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u001e\u0018\u00010\u001d2\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\n\u0018\u00010$H&¢\u0006\u0004\b'\u0010(J©\u0001\u0010'\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0012\b\u0002\u0010\u001f\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u001e\u0018\u00010\u001d2\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\n\u0018\u00010$H&¢\u0006\u0004\b'\u0010*Je\u0010-\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0004\u0012\u00020\n\u0018\u00010$H&¢\u0006\u0004\b-\u0010.J,\u00101\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010/2\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0004\u0012\u00020\n\u0018\u00010$H&J_\u0010-\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0004\u0012\u00020\n\u0018\u00010$H&¢\u0006\u0004\b-\u00102J]\u00106\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u00104\u001a\u0004\u0018\u0001032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u00105\u001a\u00020 H&¢\u0006\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/bytedance/android/ec/common/api/image/IECImageService;", "", "", "bizTag", "sceneTag", "Lcom/bytedance/android/shopping/api/image/l;", "generateCallerContext", "Lcom/facebook/drawee/view/GenericDraweeView;", "genericDraweeView", "callerContext", "", "bindCallerContext", "Landroid/content/Context;", "context", "registerCallerContext", "id", "getCallerContext", "unregisterCallerContext", "", "urlList", "Lcom/facebook/imagepipeline/request/ImageRequest;", "lowResImageRequest", "", "resizeWidth", "resizeHeight", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "Lcom/facebook/imagepipeline/request/Postprocessor;", "postprocessor", "Lcom/facebook/drawee/controller/ControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "controllerListener", "", "autoPlayAnimations", "Lcom/facebook/imagepipeline/common/Priority;", "priority", "Lkotlin/Function1;", "Lcom/facebook/drawee/interfaces/DraweeController;", "controllerInterceptor", "bindImage", "(Lcom/facebook/drawee/view/GenericDraweeView;Ljava/util/List;Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/bytedance/android/shopping/api/image/l;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/Bitmap$Config;Lcom/facebook/imagepipeline/request/Postprocessor;Lcom/facebook/drawee/controller/ControllerListener;ZLcom/facebook/imagepipeline/common/Priority;Lkotlin/jvm/functions/Function1;)V", a.KEY_URL, "(Lcom/facebook/drawee/view/GenericDraweeView;Ljava/lang/String;Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/bytedance/android/shopping/api/image/l;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/Bitmap$Config;Lcom/facebook/imagepipeline/request/Postprocessor;Lcom/facebook/drawee/controller/ControllerListener;ZLcom/facebook/imagepipeline/common/Priority;Lkotlin/jvm/functions/Function1;)V", "Landroid/graphics/Bitmap;", "consumer", "fetchImage", "(Ljava/util/List;Lcom/bytedance/android/shopping/api/image/l;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/facebook/imagepipeline/request/Postprocessor;Lkotlin/jvm/functions/Function1;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "urlModel", "fetchImageByUrl", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/image/l;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/facebook/imagepipeline/request/Postprocessor;Lkotlin/jvm/functions/Function1;)V", "Lcom/facebook/imagepipeline/listener/RequestListener;", "requestListener", "prefetchToMemoryCache", "prefetchImageToCache", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/image/l;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/facebook/imagepipeline/common/Priority;Lcom/facebook/imagepipeline/listener/RequestListener;Lcom/facebook/imagepipeline/request/Postprocessor;Z)V", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IECImageService {
    void bindCallerContext(GenericDraweeView r1, l r10);

    void bindImage(GenericDraweeView r1, String r10, ImageRequest r11, l r12, Integer r13, Integer r14, Bitmap.Config r15, Postprocessor r16, ControllerListener<? super ImageInfo> r17, boolean r18, Priority r19, Function1<? super DraweeController, Unit> r110);

    void bindImage(GenericDraweeView r1, List<String> r10, ImageRequest r11, l r12, Integer r13, Integer r14, Bitmap.Config r15, Postprocessor r16, ControllerListener<? super ImageInfo> r17, boolean r18, Priority r19, Function1<? super DraweeController, Unit> r110);

    void fetchImage(String r1, l r10, Integer r11, Integer r12, Postprocessor r13, Function1<? super Bitmap, Unit> r14);

    void fetchImage(List<String> r1, l r10, Integer r11, Integer r12, Postprocessor r13, Function1<? super Bitmap, Unit> r14);

    void fetchImageByUrl(ECUrlModel r1, Function1<? super Bitmap, Unit> r10);

    l generateCallerContext(String r1, String r10);

    l getCallerContext(Context r1);

    l getCallerContext(String r1);

    void prefetchImageToCache(String r1, l r10, Integer r11, Integer r12, Priority r13, RequestListener r14, Postprocessor r15, boolean r16);

    void registerCallerContext(Context r1, l r10);

    void registerCallerContext(String r1, l r10);

    l unregisterCallerContext(Context r1);

    l unregisterCallerContext(String r1);
}
