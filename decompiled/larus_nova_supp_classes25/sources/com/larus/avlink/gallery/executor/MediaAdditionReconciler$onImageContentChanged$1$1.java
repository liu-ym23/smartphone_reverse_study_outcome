package com.larus.avlink.gallery.executor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaAdditionReconciler$onImageContentChanged$1$1", f = "MediaAdditionReconciler.kt", i = {}, l = {79, 86}, m = "invokeSuspend", n = {}, s = {})
final class MediaAdditionReconciler$onImageContentChanged$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public MediaAdditionReconciler$onImageContentChanged$1$1(Continuation<? super MediaAdditionReconciler$onImageContentChanged$1$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new MediaAdditionReconciler$onImageContentChanged$1$1(r2);
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
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L12
    L37:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L12
    L18:
        Object r7 = MediaAdditionReconciler.e;     // Catch: Exception -> L12
        monitor-enter(r7);     // Catch: Exception -> L12
        Set<Long> r2 = MediaAdditionReconciler.d;     // Catch: Throwable -> L29
        List r3 = CollectionsKt.toList(r2);     // Catch: Throwable -> L29
        r2.clear();     // Catch: Throwable -> L29
        monitor-exit(r7);     // Catch: Exception -> L12
        if (r3.isEmpty() == true) goto L25;
        MediaAdditionReconciler r8 = MediaAdditionReconciler.a;     // Catch: Exception -> L12
        this.label = 2;     // Catch: Exception -> L12
        if (MediaAdditionReconciler.a(r8, r3, this) != r0) goto L37;
        return r0;
    L25:
        return Unit.INSTANCE;
    L29:
        th = move-exception;
        throw th;     // Catch: Exception -> L12
    L14:
        ResultKt.throwOnFailure(r6);
        this.label = 1;     // Catch: Exception -> L12
        if (DelayKt.delay(300, this) != r0) goto L18;
        return r0;
    L12:
        e = move-exception;
        if ((e instanceof CancellationException) == false) goto L35;
        FLogger.a.d("MediaAdditionReconciler", "Debounce job cancelled (new change event received)");
        goto L37
    L35:
        FLogger.a.e("MediaAdditionReconciler", "Error reconciling added media: " + e.getMessage(), e);
        goto L37
    }
}
