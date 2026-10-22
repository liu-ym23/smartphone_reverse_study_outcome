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
@DebugMetadata(c = "com.larus.avlink.gallery.view.AlbumSyncBanner$handleEvent$1", f = "GallerySyncBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AlbumSyncBanner$handleEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ z98.a $event;
    final /* synthetic */ z98.b $newState;
    int label;
    final /* synthetic */ AlbumSyncBanner this$0;

    public AlbumSyncBanner$handleEvent$1(AlbumSyncBanner r1, z98.b r2, z98.a r3, Continuation<? super AlbumSyncBanner$handleEvent$1> r4) {
        this.this$0 = r1;
        this.$newState = r2;
        this.$event = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AlbumSyncBanner$handleEvent$1(this.this$0, this.$newState, this.$event, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        AlbumSyncBanner r5 = this.this$0;
        z98.b r0 = this.$newState;
        z98.a r1 = this.$event;
        int r2 = AlbumSyncBanner.n;
        r5.n6(r0, r1);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
