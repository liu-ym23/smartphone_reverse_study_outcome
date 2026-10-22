package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.MarkAction$fetchMarkBitmap$localBitmap$1", f = "MarkAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MarkAction$fetchMarkBitmap$localBitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $localPath;
    private /* synthetic */ Object L$0;
    int label;

    public MarkAction$fetchMarkBitmap$localBitmap$1(String r1, Continuation<? super MarkAction$fetchMarkBitmap$localBitmap$1> r2) {
        this.$localPath = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MarkAction$fetchMarkBitmap$localBitmap$1 r0 = new MarkAction$fetchMarkBitmap$localBitmap$1(this.$localPath, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r2);
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        String r4 = this.$localPath;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl(BitmapFactory.decodeFile(r4));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r5) == false) goto L17;
        return null;
    L17:
        return r5;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
