package com.larus.community.impl.share;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.share.SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1", f = "SharePuzzleImageItemViewHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Bitmap $rawBitmap;
    final /* synthetic */ Bitmap $refBitmap;
    private /* synthetic */ Object L$0;
    int label;

    public SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1(Bitmap r1, Bitmap r2, Continuation<? super SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1> r3) {
        this.$rawBitmap = r1;
        this.$refBitmap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1 r0 = new SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1(this.$rawBitmap, this.$refBitmap, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        Bitmap r8 = this.$rawBitmap;
        Bitmap r0 = this.$refBitmap;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        if (r8.getWidth() < r8.getHeight()) goto L9;
        p.a.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r0, "refBitmap");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r8, "rawBitmap");     // Catch: Throwable -> L12
        Bitmap r9 = p.c(new n(r0, r8), r8.getWidth(), r8.getHeight(), r8);     // Catch: Throwable -> L12
    L10:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r10) == false) goto L22;
        return null;
    L22:
        return r10;
    L9:
        p.a.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r0, "refBitmap");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r8, "rawBitmap");     // Catch: Throwable -> L12
        r9 = p.c(new o(r0, r8), r8.getWidth(), r8.getHeight(), r8);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
