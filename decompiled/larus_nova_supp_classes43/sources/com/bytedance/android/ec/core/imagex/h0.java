package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.model.ECUrlModel;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h0 {
    public static final h0 a = null;

    public h0() {
    }

    static {
        a = new h0();
    }

    @JvmStatic
    public static final IterativeBoxBlurPostProcessor h(Integer r10) {
        if (r10 != null) goto L6;
        return new IterativeBoxBlurPostProcessor(80);
    L6:
        return new IterativeBoxBlurPostProcessor(r10.intValue(), 80);
    }

    public static void a(SimpleDraweeView r0, int r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.setImageURI(ImageRequestBuilder.newBuilderWithResourceId(r1).build().getSourceUri());
    }

    public static void i(ECUrlModel r10, r r11) {
        if (r10 == null) goto L5;
        String r12 = r10.getFirstUrl();
    L6:
        String r0 = r12;
        if (r0 != null) goto L9;
    L12:
        boolean r13 = true;
    L13:
        if (r13 == true) goto L17;
        ImageExtensionsKt.B(r0, r11, null, null, null, null, null, false, 192);
        return;
    L17:
        return;
    L9:
        if (r0.length() == 0) goto L12;
        r13 = false;
        goto L13
    L5:
        r12 = null;
        goto L6
    }

    public static b g(ECUrlModel r10, r r11, Function1 r12) {
        if (r10 == null) goto L5;
        List r13 = r10.getUrlList();
    L6:
        List r1 = r13;
        if (r1 != null) goto L9;
    L12:
        boolean r14 = true;
    L13:
        if (r14 == false) goto L16;
        return null;
    L16:
        return ImageExtensionsKt.g(r13, r11, null, null, null, r12);
    L9:
        if (r1.isEmpty() == true) goto L12;
        r14 = false;
        goto L13
    L5:
        r13 = null;
        goto L6
    }

    public static void e(GenericDraweeView r15, String r16, r r17, Integer r18, Integer r19, int r20) {
        if ((r20 & 8) == 0) goto L5;
        Integer r10 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        Integer r11 = null;
    L10:
        Intrinsics.checkNotNullParameter(r15, "draweeView");
        if (r16 != null) goto L13;
    L16:
        boolean r0 = true;
    L17:
        if (r0 == true) goto L21;
        ImageExtensionsKt.w(r15, r16, null, r17, r10, r11, null, null, null, false, null, null, 3840);
        return;
    L21:
        return;
    L13:
        if (r16.length() == 0) goto L16;
        r0 = false;
        goto L17
    L9:
        r11 = r19;
        goto L10
    L5:
        r10 = r18;
        goto L7
    }

    public static /* synthetic */ void f(GenericDraweeView r10, List r11, r r12, Integer r13, Integer r14, int r15) {
        if ((r15 & 8) == 0) goto L5;
        Integer r16 = null;
    L7:
        if ((r15 & 16) == 0) goto L9;
        Integer r17 = null;
    L10:
        c(r10, r11, r12, r16, r17, null, null);
        return;
    L9:
        r17 = r14;
        goto L10
    L5:
        r16 = r13;
        goto L7
    }

    @JvmStatic
    public static final void b(GenericDraweeView r10, ECUrlModel r11, r r12, Integer r13, Integer r14, Postprocessor r15, ControllerListener<? super ImageInfo> r16) {
        Intrinsics.checkNotNullParameter(r10, "draweeView");
        if (r11 == null) goto L5;
        List r17 = r11.getUrlList();
    L6:
        c(r10, r17, r12, r13, r14, r15, r16);
        return;
    L5:
        r17 = null;
        goto L6
    }

    @JvmStatic
    public static final void c(GenericDraweeView r15, List<String> r16, r r17, Integer r18, Integer r19, Postprocessor r20, ControllerListener<? super ImageInfo> r21) {
        Intrinsics.checkNotNullParameter(r15, "draweeView");
        List<String> r0 = r16;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        ImageExtensionsKt.x(r15, r16, null, r17, r18, r19, null, r20, r21, false, null, null, null, 7936);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static /* synthetic */ void d(GenericDraweeView r10, ECUrlModel r11, r r12, Integer r13, Integer r14, Postprocessor r15, ControllerListener r16, int r17) {
        if ((r17 & 8) == 0) goto L5;
        Integer r18 = null;
    L7:
        if ((r17 & 16) == 0) goto L9;
        Integer r19 = null;
    L11:
        if ((r17 & 32) == 0) goto L13;
        Postprocessor r20 = null;
    L15:
        if ((r17 & 64) == 0) goto L17;
        ControllerListener r21 = null;
    L18:
        b(r10, r11, r12, r18, r19, r20, r21);
        return;
    L17:
        r21 = r16;
        goto L18
    L13:
        r20 = r15;
        goto L15
    L9:
        r19 = r14;
        goto L11
    L5:
        r18 = r13;
        goto L7
    }
}
