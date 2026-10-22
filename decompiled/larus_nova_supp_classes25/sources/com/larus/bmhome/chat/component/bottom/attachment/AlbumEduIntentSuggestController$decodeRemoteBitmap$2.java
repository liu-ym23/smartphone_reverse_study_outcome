package com.larus.bmhome.chat.component.bottom.attachment;

import android.graphics.Bitmap;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AlbumEduIntentSuggestController$decodeRemoteBitmap$2", f = "AlbumEduIntentSuggestController.kt", i = {}, l = {428}, m = "invokeSuspend", n = {}, s = {})
public final class AlbumEduIntentSuggestController$decodeRemoteBitmap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ int $resize;
    final /* synthetic */ String $url;
    int label;

    public AlbumEduIntentSuggestController$decodeRemoteBitmap$2(String r1, int r2, Continuation<? super AlbumEduIntentSuggestController$decodeRemoteBitmap$2> r3) {
        this.$url = r1;
        this.$resize = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AlbumEduIntentSuggestController$decodeRemoteBitmap$2(this.$url, this.$resize, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        String r2 = this.$url;
        Bitmap.Config r3 = Bitmap.Config.ARGB_8888;
        final int r4 = this.$resize;
        Function1 r5 = new e(r4);
        this.label = 1;
        r8 = ImageLoaderKt.n(r2, "album_edu_intent_detect", r3, r5, this, 28);
        if (r8 != r0) goto L11;
        return r0;
    }
}
