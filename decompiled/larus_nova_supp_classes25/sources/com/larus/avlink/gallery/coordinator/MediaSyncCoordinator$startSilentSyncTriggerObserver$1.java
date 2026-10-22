package com.larus.avlink.gallery.coordinator;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.coordinator.MediaSyncCoordinator$startSilentSyncTriggerObserver$1", f = "MediaSyncCoordinator.kt", i = {}, l = {305}, m = "invokeSuspend", n = {}, s = {})
final class MediaSyncCoordinator$startSilentSyncTriggerObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public MediaSyncCoordinator$startSilentSyncTriggerObserver$1(Continuation<? super MediaSyncCoordinator$startSilentSyncTriggerObserver$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new MediaSyncCoordinator$startSilentSyncTriggerObserver$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:13:0x0039). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ChannelIterator r2 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r8);
        ChannelIterator r3 = r2;
        Object r4 = r0;
        MediaSyncCoordinator$startSilentSyncTriggerObserver$1 r5 = this;
    L14:
        if (((Boolean) r8).booleanValue() == false) goto L17;
        r3.next();
        FLogger.a.i("MediaSyncCoordinator", "Silent sync triggered when last sync completed");
        MediaSyncCoordinator r9 = MediaSyncCoordinator.a;
        MediaSyncCoordinator.t();
        MediaSyncCoordinator$startSilentSyncTriggerObserver$1 r10 = r5;
        r0 = r4;
        ChannelIterator r6 = r3;
    L9:
        r10.L$0 = r6;
        r10.label = 1;
        Object r7 = r6.hasNext(r10);
        if (r7 != r0) goto L12;
        return r0;
    L12:
        Object r11 = r0;
        r5 = r10;
        r8 = r7;
        r3 = r6;
        r4 = r11;
        goto L14
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        r6 = MediaSyncCoordinator.l.iterator();
        r10 = this;
        goto L9
    }
}
