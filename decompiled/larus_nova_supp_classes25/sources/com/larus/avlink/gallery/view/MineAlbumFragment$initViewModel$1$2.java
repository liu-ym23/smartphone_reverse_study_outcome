package com.larus.avlink.gallery.view;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.List;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.MineAlbumFragment$initViewModel$1$2", f = "MineAlbumFragment.kt", i = {}, l = {500, 502}, m = "invokeSuspend", n = {}, s = {})
final class MineAlbumFragment$initViewModel$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<com.larus.bmhome.bigimg.t1> $mediaList;
    int label;
    final /* synthetic */ MineAlbumFragment this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MineAlbumFragment$initViewModel$1$2(MineAlbumFragment r1, List<? extends com.larus.bmhome.bigimg.t1> r2, Continuation<? super MineAlbumFragment$initViewModel$1$2> r3) {
        this.this$0 = r1;
        this.$mediaList = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MineAlbumFragment$initViewModel$1$2(this.this$0, this.$mediaList, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L13:
        FLogger.a.i("MineAlbumFragment", "checkAndSyncUnsynchronizedMedia");
        MineAlbumFragment r7 = this.this$0;
        List<com.larus.bmhome.bigimg.t1> r2 = this.$mediaList;
        Intrinsics.checkNotNull(r2);
        this.label = 2;
        if (MineAlbumFragment.Z90(r7, r2, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L13;
        return r0;
    }
}
