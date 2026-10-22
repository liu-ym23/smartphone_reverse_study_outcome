package com.larus.avlink.gallery.coordinator;

import com.larus.avlink.gallery.executor.MediaAdditionReconciler;
import com.larus.avlink.gallery.executor.MediaDownloadExecutor;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.coordinator.MediaSyncCoordinator$init$1", f = "MediaSyncCoordinator.kt", i = {}, l = {DoraCallStateCode.DOUBAO_STOP_RECORD_BY_GUI}, m = "invokeSuspend", n = {}, s = {})
public final class MediaSyncCoordinator$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public MediaSyncCoordinator$init$1(Continuation<? super MediaSyncCoordinator$init$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new MediaSyncCoordinator$init$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L24
    L15:
        List r7 = (List) r6;     // Catch: Exception -> L24
        if (r7 != null) goto L19;
    L17:
        r7 = CollectionsKt.emptyList();     // Catch: Exception -> L24
    L19:
        if ((!r7.isEmpty()) == false) goto L21;
        FLogger.a.i("MediaSyncCoordinator", "[Init] Recovered " + r7.size() + " incomplete tasks");     // Catch: Exception -> L24
    L22:
        MediaAdditionReconciler r8 = MediaAdditionReconciler.a;     // Catch: Exception -> L24
        MediaAdditionReconciler.j();     // Catch: Exception -> L24
    L27:
        return Unit.INSTANCE;
    L21:
        FLogger.a.d("MediaSyncCoordinator", "[Init] No incomplete tasks found");     // Catch: Exception -> L24
        goto L22
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        FLogger.a.i("MediaSyncCoordinator", "[Init] Starting recovery of incomplete tasks");     // Catch: Exception -> L24
        MediaSyncCoordinator r9 = MediaSyncCoordinator.a;     // Catch: Exception -> L24
        MediaSyncCoordinator.d();     // Catch: Exception -> L24
        MediaDownloadExecutor r10 = MediaSyncCoordinator.g;     // Catch: Exception -> L24
        if (r10 == null) goto L17;
        this.label = 1;     // Catch: Exception -> L24
        r6 = r10.l(this);     // Catch: Exception -> L24
        if (r6 != r1) goto L15;
        return r1;
    L24:
        e = move-exception;
        FLogger.a.e("MediaSyncCoordinator", "[Init] Error during recovery: " + e.getMessage(), e);
        goto L27
    }
}
