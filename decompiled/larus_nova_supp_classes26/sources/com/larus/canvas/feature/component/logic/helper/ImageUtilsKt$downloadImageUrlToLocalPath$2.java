package com.larus.canvas.feature.component.logic.helper;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.service.IUgcAIGCService;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.helper.ImageUtilsKt$downloadImageUrlToLocalPath$2", f = "ImageUtils.kt", i = {}, l = {83, 87}, m = "invokeSuspend", n = {}, s = {})
final class ImageUtilsKt$downloadImageUrlToLocalPath$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $url;
    int label;

    public ImageUtilsKt$downloadImageUrlToLocalPath$2(String r1, Context r2, Continuation<? super ImageUtilsKt$downloadImageUrlToLocalPath$2> r3) {
        this.$url = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImageUtilsKt$downloadImageUrlToLocalPath$2(this.$url, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super File> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        Object r5 = null;
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L12;
        if (r2 != 2) goto L11;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L8
    L30:
        File r9 = (File) r8;     // Catch: Throwable -> L8
    L32:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L8
    L36:
        if (Result.isFailure-impl(r10) == true) goto L40;
        r5 = r10;
    L40:
        return (File) r5;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r8);
    L16:
        CloseableReference r11 = (CloseableReference) r8;
        if (r11 == null) goto L43;
        Context r3 = this.$context;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        Object r12 = r11.get();     // Catch: Throwable -> L8
        if ((r12 instanceof CloseableStaticBitmap) == false) goto L22;
        CloseableStaticBitmap r13 = (CloseableStaticBitmap) r12;     // Catch: Throwable -> L8
    L23:
        if (r13 == null) goto L25;
        Bitmap r14 = r13.getUnderlyingBitmap();     // Catch: Throwable -> L8
    L26:
        if (r14 == null) goto L31;
        IUgcAIGCService.Companion r6 = IUgcAIGCService.a;     // Catch: Throwable -> L8
        String r0 = "canvas_" + UUID.randomUUID() + ".jpeg";     // Catch: Throwable -> L8
        this.label = 2;     // Catch: Throwable -> L8
        r8 = r6.m(r3, r14, r0, this);     // Catch: Throwable -> L8
        if (r8 != r1) goto L30;
        return r1;
    L31:
        r9 = null;
        goto L32
    L25:
        r14 = null;
        goto L26
    L22:
        r13 = null;
        goto L23
    L43:
        return null;
    L13:
        ResultKt.throwOnFailure(r8);
        String r15 = this.$url;
        this.label = 1;
        r8 = ImageLoaderKt.i(r15, "bitmap_downloader", null, this, 60);
        if (r8 != r1) goto L16;
        return r1;
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    }
}
