package com.larus.uaigc.createpage.component.instruction;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$handleMsgInstructionRedirectSchema$3$2$1$1", f = "CreationEditorComponent.kt", i = {}, l = {4103}, m = "invokeSuspend", n = {}, s = {})
public final class CreationEditorComponent$handleMsgInstructionRedirectSchema$3$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $it;
    int label;

    public CreationEditorComponent$handleMsgInstructionRedirectSchema$3$2$1$1(String r1, Continuation<? super CreationEditorComponent$handleMsgInstructionRedirectSchema$3$2$1$1> r2) {
        this.$it = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$handleMsgInstructionRedirectSchema$3$2$1$1(this.$it, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L24
    L13:
        CloseableReference r7 = (CloseableReference) r6;     // Catch: Throwable -> L24
        if (r7 == null) goto L21;
        Object r8 = r7.get();     // Catch: Throwable -> L24
        if ((r8 instanceof CloseableStaticBitmap) == false) goto L18;
        CloseableStaticBitmap r9 = (CloseableStaticBitmap) r8;     // Catch: Throwable -> L24
    L19:
        if (r9 == null) goto L21;
        Bitmap r10 = r9.getUnderlyingBitmap();     // Catch: Throwable -> L24
    L22:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r11) == false) goto L30;
        return null;
    L30:
        return r11;
    L18:
        r9 = null;
    L21:
        r10 = null;
        goto L22
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        String r12 = this.$it;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        Function1 r4 = new s1();     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        r6 = ImageLoaderKt.i(r12, "biz_multi_attachment_clean_bitmap", r4, this, 28);     // Catch: Throwable -> L24
        if (r6 != r0) goto L13;
        return r0;
    L24:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }
}
