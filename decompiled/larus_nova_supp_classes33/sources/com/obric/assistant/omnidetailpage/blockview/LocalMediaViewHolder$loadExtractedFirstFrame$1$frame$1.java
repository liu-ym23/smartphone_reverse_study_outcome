package com.obric.assistant.omnidetailpage.blockview;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.blockview.LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1", f = "TaskLocalMediaPreviewView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ ifa.c.b $item;
    int label;
    final /* synthetic */ j this$0;

    public LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1(j r1, ifa.c.b r2, Continuation<? super LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1> r3) {
        this.this$0 = r1;
        this.$item = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1(this.this$0, this.$item, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r4);
        j r5 = this.this$0;
        String r0 = this.$item.c;
        int r1 = j.q;
        r5.getClass();
        MediaMetadataRetriever r6 = new MediaMetadataRetriever();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        r6.setDataSource(r0);     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl(r6.getFrameAtTime(0, 2));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == false) goto L12;
        r3 = null;
    L12:
        Bitmap r7 = (Bitmap) r3;
        r6.release();     // Catch: Throwable -> L15
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        return r7;
    L15:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
