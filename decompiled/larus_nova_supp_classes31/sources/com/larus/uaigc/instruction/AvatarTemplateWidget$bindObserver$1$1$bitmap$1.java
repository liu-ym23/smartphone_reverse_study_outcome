package com.larus.uaigc.instruction;

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
@DebugMetadata(c = "com.larus.uaigc.instruction.AvatarTemplateWidget$bindObserver$1$1$bitmap$1", f = "AvatarTemplateWidget.kt", i = {}, l = {317}, m = "invokeSuspend", n = {}, s = {})
public final class AvatarTemplateWidget$bindObserver$1$1$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AvatarTemplateWidget this$0;

    public AvatarTemplateWidget$bindObserver$1$1$bitmap$1(AvatarTemplateWidget r1, Continuation<? super AvatarTemplateWidget$bindObserver$1$1$bitmap$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AvatarTemplateWidget$bindObserver$1$1$bitmap$1(this.this$0, r3);
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
        AvatarTemplateWidget r2 = (AvatarTemplateWidget) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L29
    L15:
        CloseableReference<CloseableImage> r8 = (CloseableReference) r7;     // Catch: Throwable -> L29
        if (r8 == null) goto L26;
        com.larus.uaigc.createpage.component.mediaselector.imageselector.c r3 = AvatarTemplateWidget.n6(r2);     // Catch: Throwable -> L29
        String r4 = (String) AvatarTemplateWidget.i6(r2).getValue();     // Catch: Throwable -> L29
        if (r4 != null) goto L20;
        r4 = "";
    L20:
        r3.a(r4, r8);     // Catch: Throwable -> L29
        Object r9 = r8.get();     // Catch: Throwable -> L29
        if ((r9 instanceof CloseableStaticBitmap) == false) goto L23;
        CloseableStaticBitmap r10 = (CloseableStaticBitmap) r9;     // Catch: Throwable -> L29
    L24:
        if (r10 == null) goto L26;
        Bitmap r11 = r10.getUnderlyingBitmap();     // Catch: Throwable -> L29
    L27:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r12) == false) goto L35;
        return null;
    L35:
        return r12;
    L23:
        r10 = null;
    L26:
        r11 = null;
        goto L27
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r7);
        AvatarTemplateWidget r13 = this.this$0;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L29
        String r6 = (String) AvatarTemplateWidget.i6(r13).getValue();     // Catch: Throwable -> L29
        Function1 r14 = new h();     // Catch: Throwable -> L29
        this.L$0 = r13;     // Catch: Throwable -> L29
        this.label = 1;     // Catch: Throwable -> L29
        Object r15 = ImageLoaderKt.i(r6, "digital_avatar_white_t", r14, this, 28);     // Catch: Throwable -> L29
        if (r15 != r0) goto L14;
        return r0;
    L14:
        r2 = r13;
        r7 = r15;
    L29:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }
}
