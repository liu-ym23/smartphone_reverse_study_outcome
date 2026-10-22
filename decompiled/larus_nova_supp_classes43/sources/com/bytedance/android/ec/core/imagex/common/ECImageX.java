package com.bytedance.android.ec.core.imagex.common;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.android.ec.core.imagex.ECImageXCompact;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.ImageSettings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECImageX {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(ECImageX$mIdCounter$2.INSTANCE);
    }

    public static String b() {
        return "ec_" + ((AtomicLong) a.getValue()).getAndIncrement();
    }

    public static Map a(ImageRequestBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        Map r0 = r10.getCustomParam();
        if (r0 != null) goto L6;
        r0 = new LinkedHashMap();
        r10.setCustomParam(r0);
        Unit r1 = Unit.INSTANCE;
    L6:
        if ((r0 instanceof HashMap) == true) goto L11;
        r0 = new LinkedHashMap();
        Map r11 = r10.getCustomParam();
        if (r11 == null) goto L10;
        r0.putAll(r11);
    L10:
        r10.setCustomParam(r0);
    L11:
        return r0;
    }

    public static void c(GenericDraweeView r18, List r19, ImageRequest r20, com.bytedance.android.ec.core.imagex.u r21, ResizeOptions r22, Bitmap.Config r23, Postprocessor r24, ControllerListener r25, boolean r26, Priority r27, Function1 r28, String r29) {
        Intrinsics.checkNotNullParameter(r18, "imageView");
        Intrinsics.checkNotNullParameter(r19, "originList");
        ArrayList r10 = new ArrayList();
        List r1 = r19;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r12 = r1.iterator();
    L4:
        if (r12.hasNext() == false) goto L31;
        Uri r13 = UriProtector.parse((String) r12.next());
        Iterator r17 = r12;
        Set r14 = UriProtector.getQueryParameterNames(r13);
        Uri.Builder r15 = r13.buildUpon();
        String r16 = r21.f;
        if (r16 != null) goto L8;
    L11:
        boolean r30 = true;
    L12:
        if (r30 == false) goto L14;
    L16:
        String r0 = r21.g;
        if (r0 != null) goto L19;
    L22:
        boolean r110 = true;
    L23:
        if (r110 == true) goto L28;
        if (r14.contains("scene_tag") == true) goto L28;
        r15.appendQueryParameter("scene_tag", r21.g);
    L28:
        if (r14.contains("from_ec_image_loaded") == true) goto L30;
        r15.appendQueryParameter("from_ec_image_loaded", "1");
    L30:
        r11.add(r15.build().toString());
        r12 = r17;
        goto L4
    L19:
        if (r0.length() == 0) goto L22;
        r110 = false;
        goto L23
    L14:
        if (r14.contains("biz_tag") == true) goto L16;
        r15.appendQueryParameter("biz_tag", r21.f);
        goto L16
    L8:
        if (r16.length() == 0) goto L11;
        r30 = false;
        goto L12
    L31:
        Iterator r31 = r11.iterator();
    L32:
        ControllerListener r111 = null;
        if (r31.hasNext() == false) goto L73;
        String r32 = (String) r31.next();
        if (r32 != null) goto L37;
    L40:
        boolean r112 = true;
    L41:
        if (r112 == true) goto L70;
        final ImageRequestBuilder r33 = ImageRequestBuilder.newBuilderWithSource(ImageExtensionsKt.c(r32));
        if (r22 == null) goto L46;
        r33.setResizeOptions(r22);
    L46:
        if (r24 == null) goto L48;
        r33.setPostprocessor(r24);
    L48:
        if (r27 != null) goto L50;
        Priority r113 = Priority.MEDIUM;
    L51:
        Intrinsics.checkNotNullParameter(r113, "requestPriority");
        r21.l = Integer.valueOf(r113.ordinal());
        Unit r114 = Unit.INSTANCE;
        r33.setRequestPriority(r113);
        if (r23 == null) goto L54;
        ImageDecodeOptionsBuilder r115 = new ImageDecodeOptionsBuilder();
        r115.setBitmapConfig(r23);
        r33.setImageDecodeOptions(new ImageDecodeOptions(r115));
    L55:
        if (r29 != null) goto L57;
    L60:
        boolean r116 = true;
    L61:
        if (r116 == true) goto L64;
        r33.setCacheChoice(ImageRequest.CacheChoice.CUSTOM);
        r33.setCustomCacheName(r29);
    L64:
        if (((Boolean) ImageSettings.p.getValue()).booleanValue() == false) goto L66;
        r33.setRotationOptions(RotationOptions.autoRotateAtRenderTime());
    L66:
        Map r117 = r33.getCustomParam();
        if (r117 != null) goto L69;
        r117 = new LinkedHashMap();
        r33.setCustomParam(r117);
    L69:
        r117.put("biz_tag", r21.f);
        r117.put("scene_tag", r21.g);
        r117.put("from_ec_image_loaded", "1");
        r111 = r33.build();
        goto L70
    L57:
        if (StringsKt.isBlank(r29) == true) goto L60;
        r116 = false;
        goto L61
    L54:
        new ECImageX$innerToImageRequestOrNull$6(r33);
        goto L55
    L50:
        r113 = r27;
    L70:
        if (r111 == null) goto L32;
        r10.add(r111);
        goto L32
    L37:
        if (StringsKt.isBlank(r32) == true) goto L40;
        r112 = false;
        goto L41
    L73:
        if (r10.isEmpty() == false) goto L75;
        return;
    L75:
        PipelineDraweeControllerBuilder r34 = Fresco.newDraweeControllerBuilder().setOldController(r18.getController());
        if (r10.size() != 1) goto L79;
        r34.setImageRequest(CollectionsKt.firstOrNull(r10));
    L85:
        if (r20 == null) goto L87;
        r34.setLowResImageRequest(r20);
    L87:
        r34.setCallerContext(r21);
        if (r25 != null) goto L90;
    L94:
        r34.setAutoPlayAnimations(r26);
        AbstractDraweeController r35 = r34.build();
        r21.k();
        if (r28 == null) goto L97;
        Unit r36 = (Unit) r28.invoke(r35);
    L97:
        r18.setController(r35);
        return;
    L90:
        if ((r25 instanceof com.bytedance.android.ec.core.imagex.n) == false) goto L93;
        r111 = r25;
    L93:
        com.bytedance.android.ec.core.imagex.n r118 = (com.bytedance.android.ec.core.imagex.n) r111;
        r34.setControllerListener(r25);
        goto L94
    L79:
        if ((!r10.isEmpty()) == false) goto L85;
        ECImageXCompact r37 = ECImageXCompact.c;
        Object[] r38 = r10.toArray(new ImageRequest[0]);
        if (r38 == null) goto L84;
        r37.getClass();
        ECImageXCompact.a(r34, (ImageRequest[]) r38);
        goto L85
    L84:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
