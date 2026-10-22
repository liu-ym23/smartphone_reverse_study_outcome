package com.larus.community.impl.share;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.share.CreationShareDialogFragment$compositeBitmap$job$1$downloadBitmapDeferred$1", f = "CreationShareDialogFragment.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
public final class CreationShareDialogFragment$compositeBitmap$job$1$downloadBitmapDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ sq9.j $imageShareModel;
    final /* synthetic */ int $resizeThreshold;
    int label;
    final /* synthetic */ CreationShareDialogFragment this$0;

    public CreationShareDialogFragment$compositeBitmap$job$1$downloadBitmapDeferred$1(sq9.j r1, int r2, CreationShareDialogFragment r3, Continuation<? super CreationShareDialogFragment$compositeBitmap$job$1$downloadBitmapDeferred$1> r4) {
        this.$imageShareModel = r1;
        this.$resizeThreshold = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationShareDialogFragment$compositeBitmap$job$1$downloadBitmapDeferred$1(this.$imageShareModel, this.$resizeThreshold, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        CloseableReference<CloseableImage> r6 = (CloseableReference) r5;
        if (r6 == null) goto L20;
        CreationShareDialogFragment r2 = this.this$0;
        sq9.j r3 = this.$imageShareModel;
        int r4 = CreationShareDialogFragment.m;
        ((m) r2.k.getValue()).a(r3.c, r6);
        Object r7 = r6.get();
        if ((r7 instanceof CloseableStaticBitmap) == false) goto L16;
        CloseableStaticBitmap r8 = (CloseableStaticBitmap) r7;
    L17:
        if (r8 != null) goto L19;
        return null;
    L19:
        return r8.getUnderlyingBitmap();
    L16:
        r8 = null;
        goto L17
    L20:
        return null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        String r9 = this.$imageShareModel.c;
        final int r10 = this.$resizeThreshold;
        Function1 r11 = new g(r10);
        this.label = 1;
        r5 = ImageLoaderKt.i(r9, "creation_share", r11, this, 28);
        if (r5 != r0) goto L11;
        return r0;
    }
}
