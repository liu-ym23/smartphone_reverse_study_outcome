package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.image.loader.ImageLoaderKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$bitmap$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {}, l = {875}, m = "invokeSuspend", n = {}, s = {})
public final class SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $url;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

    public SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$bitmap$1(String r1, SpringMultiAttachmentSelectorComponent r2, Continuation<? super SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$bitmap$1> r3) {
        this.$url = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$bitmap$1(this.$url, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        SpringMultiAttachmentSelectorComponent r2 = (SpringMultiAttachmentSelectorComponent) this.L$1;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L26
    L15:
        CloseableReference<CloseableImage> r8 = (CloseableReference) r7;     // Catch: Throwable -> L26
        if (r8 == null) goto L23;
        int r4 = SpringMultiAttachmentSelectorComponent.L;     // Catch: Throwable -> L26
        ((c) r2.G.getValue()).a(r3, r8);     // Catch: Throwable -> L26
        Object r9 = r8.get();     // Catch: Throwable -> L26
        if ((r9 instanceof CloseableStaticBitmap) == false) goto L20;
        CloseableStaticBitmap r10 = (CloseableStaticBitmap) r9;     // Catch: Throwable -> L26
    L21:
        if (r10 == null) goto L23;
        Bitmap r11 = r10.getUnderlyingBitmap();     // Catch: Throwable -> L26
    L24:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r12) == false) goto L32;
        return null;
    L32:
        return r12;
    L20:
        r10 = null;
    L23:
        r11 = null;
        goto L24
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r7);
        r3 = this.$url;
        SpringMultiAttachmentSelectorComponent r13 = this.this$0;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L26
        Function1 r6 = new x4();     // Catch: Throwable -> L26
        this.L$0 = r3;     // Catch: Throwable -> L26
        this.L$1 = r13;     // Catch: Throwable -> L26
        this.label = 1;     // Catch: Throwable -> L26
        Object r14 = ImageLoaderKt.i(r3, "instruction_multi_attachment_selector", r6, this, 28);     // Catch: Throwable -> L26
        if (r14 != r0) goto L14;
        return r0;
    L14:
        r2 = r13;
        r7 = r14;
    L26:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }
}
