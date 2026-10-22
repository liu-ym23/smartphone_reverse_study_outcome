package com.larus.avlink.gallery.coordinator;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
@DebugMetadata(c = "com.larus.avlink.gallery.coordinator.MediaSyncCoordinator$disconnectWifi$1", f = "MediaSyncCoordinator.kt", i = {}, l = {530, 531}, m = "invokeSuspend", n = {}, s = {})
public final class MediaSyncCoordinator$disconnectWifi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public MediaSyncCoordinator$disconnectWifi$1(Continuation<? super MediaSyncCoordinator$disconnectWifi$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new MediaSyncCoordinator$disconnectWifi$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L17:
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L25;
        IDoraService.j r7 = r6.S();
        if (r7 == null) goto L25;
        this.label = 2;
        if (r7.disconnect("ALBUM_SILENT") != r0) goto L25;
        return r0;
    L10:
        ResultKt.throwOnFailure(r5);
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L17;
        IDoraService.j r9 = r8.S();
        if (r9 == null) goto L17;
        this.label = 1;
        if (r9.disconnect("ALBUM") != r0) goto L17;
        return r0;
    }
}
