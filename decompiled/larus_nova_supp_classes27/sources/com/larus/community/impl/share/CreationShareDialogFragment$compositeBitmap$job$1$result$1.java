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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.share.CreationShareDialogFragment$compositeBitmap$job$1$result$1", f = "CreationShareDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationShareDialogFragment$compositeBitmap$job$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Bitmap $downloadBitmap;
    final /* synthetic */ Bitmap $refBitmap;
    int label;

    public CreationShareDialogFragment$compositeBitmap$job$1$result$1(Bitmap r1, Bitmap r2, Continuation<? super CreationShareDialogFragment$compositeBitmap$job$1$result$1> r3) {
        this.$downloadBitmap = r1;
        this.$refBitmap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationShareDialogFragment$compositeBitmap$job$1$result$1(this.$downloadBitmap, this.$refBitmap, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r5);
        if (this.$downloadBitmap.getWidth() < this.$downloadBitmap.getHeight()) goto L7;
        p r6 = p.a;
        Bitmap r0 = this.$refBitmap;
        Bitmap r3 = this.$downloadBitmap;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "refBitmap");
        Intrinsics.checkNotNullParameter(r3, "rawBitmap");
        return p.c(new n(r0, r3), r3.getWidth(), r3.getHeight(), r3);
    L7:
        p r7 = p.a;
        Bitmap r1 = this.$refBitmap;
        Bitmap r4 = this.$downloadBitmap;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "refBitmap");
        Intrinsics.checkNotNullParameter(r4, "rawBitmap");
        return p.c(new o(r1, r4), r4.getWidth(), r4.getHeight(), r4);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
