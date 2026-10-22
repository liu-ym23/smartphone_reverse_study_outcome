package com.larus.avlink.gallery.view;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.MediaAlbumViewHelper$albumNotifyListener$1$onAlbumNotifyArrived$1", f = "MediaAlbumViewHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MediaAlbumViewHelper$albumNotifyListener$1$onAlbumNotifyArrived$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b49.a $albumCount;
    final /* synthetic */ int $photoCount;
    final /* synthetic */ int $videoCount;
    int label;
    final /* synthetic */ MediaAlbumViewHelper this$0;

    public MediaAlbumViewHelper$albumNotifyListener$1$onAlbumNotifyArrived$1(MediaAlbumViewHelper r1, b49.a r2, int r3, int r4, Continuation<? super MediaAlbumViewHelper$albumNotifyListener$1$onAlbumNotifyArrived$1> r5) {
        this.this$0 = r1;
        this.$albumCount = r2;
        this.$photoCount = r3;
        this.$videoCount = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MediaAlbumViewHelper$albumNotifyListener$1$onAlbumNotifyArrived$1(this.this$0, this.$albumCount, this.$photoCount, this.$videoCount, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r3);
        if (this.this$0.n == false) goto L11;
        if (this.$albumCount != null) goto L9;
        this.this$0.c();
        goto L11
    L9:
        MediaAlbumViewHelper r4 = this.this$0;
        int r0 = this.$photoCount;
        int r1 = this.$videoCount;
        r4.h(r0, r1);
        r4.i(r0, r1);
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
