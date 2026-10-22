package com.larus.avlink.gallery.coordinator;

import com.larus.avlink.gallery.executor.MediaDownloadExecutor;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.coordinator.MediaSyncCoordinator$recoverIncompleteTasks$1", f = "MediaSyncCoordinator.kt", i = {}, l = {551, 561, 564}, m = "invokeSuspend", n = {}, s = {})
final class MediaSyncCoordinator$recoverIncompleteTasks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, Continuation<? super Unit>, Object> $onFinish;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MediaSyncCoordinator$recoverIncompleteTasks$1(Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super MediaSyncCoordinator$recoverIncompleteTasks$1> r2) {
        this.$onFinish = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MediaSyncCoordinator$recoverIncompleteTasks$1(this.$onFinish, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L13;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r9);
    L45:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L40
        goto L45
    L11:
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L40
    L19:
        List r10 = (List) r9;     // Catch: Exception -> L40
        if (r10 != null) goto L23;
    L21:
        r10 = CollectionsKt.emptyList();     // Catch: Exception -> L40
    L23:
        if ((!r10.isEmpty()) == false) goto L36;
        FLogger.a.i("MediaSyncCoordinator", "Recovered " + r10.size() + " incomplete tasks");     // Catch: Exception -> L40
        MediaSyncCoordinator r0 = MediaSyncCoordinator.a;     // Catch: Exception -> L40
        int r11 = r10.size();     // Catch: Exception -> L40
        List<u98.a> r3 = MediaSyncCoordinator.b;     // Catch: Exception -> L40
        monitor-enter(r3);     // Catch: Exception -> L40
        Iterator r4 = ((ArrayList) r3).iterator();     // Catch: Throwable -> L33
    L28:
        if (r4.hasNext() == false) goto L30;
        ((u98.a) r4.next()).VD(r11);     // Catch: Throwable -> L33
        goto L28
    L30:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r3);     // Catch: Exception -> L40
        MediaSyncCoordinator.a();     // Catch: Exception -> L40
    L37:
        Function2<Boolean, Continuation<? super Unit>, Object> r13 = this.$onFinish;     // Catch: Exception -> L40
        Boolean r5 = Boxing.boxBoolean(true);     // Catch: Exception -> L40
        this.label = 2;     // Catch: Exception -> L40
        if (r13.invoke(r5, this) != r1) goto L45;
        return r1;
    L33:
        th = move-exception;
        throw th;     // Catch: Exception -> L40
    L36:
        FLogger.a.i("MediaSyncCoordinator", "No incomplete tasks found");     // Catch: Exception -> L40
        goto L37
    L13:
        ResultKt.throwOnFailure(r9);
        FLogger.a.i("MediaSyncCoordinator", "Starting recovery of incomplete tasks");     // Catch: Exception -> L40
        MediaSyncCoordinator r14 = MediaSyncCoordinator.a;     // Catch: Exception -> L40
        MediaSyncCoordinator.d();     // Catch: Exception -> L40
        MediaDownloadExecutor r15 = MediaSyncCoordinator.g;     // Catch: Exception -> L40
        if (r15 == null) goto L21;
        this.label = 1;     // Catch: Exception -> L40
        r9 = r15.l(this);     // Catch: Exception -> L40
        if (r9 != r1) goto L19;
        return r1;
    L40:
        e = move-exception;
        FLogger.a.e("MediaSyncCoordinator", "Error during recovery: " + e.getMessage(), e);
        Function2<Boolean, Continuation<? super Unit>, Object> r16 = this.$onFinish;
        Boolean r6 = Boxing.boxBoolean(false);
        this.label = 3;
        if (r16.invoke(r6, this) != r1) goto L45;
        return r1;
    }
}
