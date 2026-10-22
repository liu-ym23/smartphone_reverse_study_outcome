package com.larus.avlink.gallery.executor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
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
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1", f = "MediaAdditionReconciler.kt", i = {}, l = {MessageCellStateTransformerType.DOWNLOAD_APP_ENTITY}, m = "invokeSuspend", n = {}, s = {})
public final class MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1(Continuation<? super MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new MediaAdditionReconciler$reconcileAllFromPublicAlbumAsync$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        ResultKt.throwOnFailure(r4);     // Catch: Exception -> L7 CancellationException -> L9
    L21:
    L19:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r4);
        MediaAdditionReconciler r5 = MediaAdditionReconciler.a;     // Catch: Exception -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Exception -> L7 CancellationException -> L9
        if (MediaAdditionReconciler.b(r5, this) != r0) goto L21;
        return r0;
    L9:
        e = move-exception;
        throw e;
    L7:
        e = move-exception;
        FLogger.a.e("MediaAdditionReconciler", "Full reconcile failed: " + e.getMessage(), e);
        goto L19
    }
}
