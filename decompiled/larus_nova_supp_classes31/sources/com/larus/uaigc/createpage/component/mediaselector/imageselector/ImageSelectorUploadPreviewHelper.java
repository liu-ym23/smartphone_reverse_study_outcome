package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ImageSelectorUploadPreviewHelper {
    public static final /* synthetic */ int d = 0;
    public final ImageSelectorView a;
    public final c b;
    public final Function0<Boolean> c;

    public static final class a {
    }

    static {
    }

    public final void c(Bitmap r4) {
        this.a.V5(new sy9.b.C0075b(r4, ((Boolean) this.c.invoke()).booleanValue()));
    }

    public final Object a(String r6, Continuation<? super Bitmap> r7) {
        if ((r7 instanceof ImageSelectorUploadPreviewHelper$fetchPreviewBitmap$1) == false) goto L7;
        ImageSelectorUploadPreviewHelper$fetchPreviewBitmap$1 r0 = (ImageSelectorUploadPreviewHelper$fetchPreviewBitmap$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L31
    L20:
        CloseableReference<CloseableImage> r9 = (CloseableReference) r8;     // Catch: Throwable -> L31
        if (r9 == null) goto L28;
        this.b.a(r6, r9);     // Catch: Throwable -> L31
        Object r10 = r9.get();     // Catch: Throwable -> L31
        if ((r10 instanceof CloseableStaticBitmap) == false) goto L25;
        CloseableStaticBitmap r11 = (CloseableStaticBitmap) r10;     // Catch: Throwable -> L31
    L26:
        if (r11 == null) goto L28;
        Bitmap r12 = r11.getUnderlyingBitmap();     // Catch: Throwable -> L31
    L29:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L31
    L33:
        Throwable r4 = Result.exceptionOrNull-impl(r13);
        if (r4 == null) goto L37;
        FLogger.a.e("ImageSelectorUploadPreviewHelper", "[fetchPreviewBitmap] failed, imageUri=" + r6, r4);
    L37:
        if (Result.isFailure-impl(r13) == false) goto L40;
        return null;
    L40:
        return r13;
    L25:
        r11 = null;
    L28:
        r12 = null;
        goto L29
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L31
        Function1 r5 = new e1();     // Catch: Throwable -> L31
        r0.L$0 = r6;     // Catch: Throwable -> L31
        r0.label = 1;     // Catch: Throwable -> L31
        r8 = ImageLoaderKt.i(r6, "instruction_image_selector", r5, r0, 28);     // Catch: Throwable -> L31
        if (r8 != r2) goto L20;
        return r2;
    L31:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new ImageSelectorUploadPreviewHelper$fetchPreviewBitmap$1(this, r7);
        goto L8
    }

    public final Object b(String r2, Continuation<? super Bitmap> r3) {
        Intrinsics.checkNotNullParameter(r2, "localPath");
        if (com.larus.uaigc.helper.g.b(r2) == true) goto L9;
        r2 = com.larus.utils.y0.k(Uri.fromFile(new PolarisFileWrapper(r2)));
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        return a(r2, r3);
    }

    public final void d(Bitmap r5, Pair<Integer, Integer> r6) {
        this.a.V5(new sy9.b.e(r5, ((Boolean) this.c.invoke()).booleanValue(), r6, 8));
    }

    public ImageSelectorUploadPreviewHelper(ImageSelectorView r2, c r3, Function0<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "imageSelectorView");
        Intrinsics.checkNotNullParameter(r3, "frescoCloseableHolder");
        Intrinsics.checkNotNullParameter(r4, "showFullProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
