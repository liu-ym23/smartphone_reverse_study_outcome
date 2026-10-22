package com.larus.camera.impl.ui.component.result.general;

import android.graphics.Bitmap;
import com.larus.image.loader.ImageLoaderKt;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent$onViewCreated$3$rawBitmap$1", f = "ResultPreviewComponent.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
public final class ResultPreviewComponent$onViewCreated$3$rawBitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $rawImageUri;
    int label;

    public ResultPreviewComponent$onViewCreated$3$rawBitmap$1(String r1, Continuation<? super ResultPreviewComponent$onViewCreated$3$rawBitmap$1> r2) {
        this.$rawImageUri = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ResultPreviewComponent$onViewCreated$3$rawBitmap$1(this.$rawImageUri, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15
    L13:
        Object r9 = Result.constructor-impl((Bitmap) r8);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r9) == false) goto L23;
        return null;
    L23:
        return r9;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        String r2 = this.$rawImageUri;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r8 = ImageLoaderKt.n(r2, "camera_result_raw", null, null, this, 124);     // Catch: Throwable -> L15
        if (r8 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
