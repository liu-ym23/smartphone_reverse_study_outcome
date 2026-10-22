package com.larus.community.impl.share;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.share.SharePuzzleImageItemViewHolder$bind$1$refBitmapDeferred$1", f = "SharePuzzleImageItemViewHolder.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
public final class SharePuzzleImageItemViewHolder$bind$1$refBitmapDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ m $closeableHolder;
    final /* synthetic */ q $shareImagePuzzleItem;
    int label;
    final /* synthetic */ SharePuzzleImageItemViewHolder this$0;

    public SharePuzzleImageItemViewHolder$bind$1$refBitmapDeferred$1(SharePuzzleImageItemViewHolder r1, q r2, m r3, Continuation<? super SharePuzzleImageItemViewHolder$bind$1$refBitmapDeferred$1> r4) {
        this.this$0 = r1;
        this.$shareImagePuzzleItem = r2;
        this.$closeableHolder = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SharePuzzleImageItemViewHolder$bind$1$refBitmapDeferred$1(this.this$0, this.$shareImagePuzzleItem, this.$closeableHolder, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        SharePuzzleImageItemViewHolder r7 = this.this$0;
        String r2 = this.$shareImagePuzzleItem.b;
        String r3 = "ref:" + this.$shareImagePuzzleItem.b;
        m r4 = this.$closeableHolder;
        this.label = 1;
        r6 = SharePuzzleImageItemViewHolder.T3(r7, r2, r3, r4, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
