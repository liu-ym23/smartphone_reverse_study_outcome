package com.larus.dora.impl.offline.record;

import com.larus.dora.api.offline.record.c;
import com.larus.dora.api.offline.record.e;
import g49.d;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.offline.record.DoraOfflineRecordSyncServiceImpl$dispatchTransferCompleted$1", f = "DoraOfflineRecordSyncServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraOfflineRecordSyncServiceImpl$dispatchTransferCompleted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $recording;
    int label;
    final /* synthetic */ DoraOfflineRecordSyncServiceImpl this$0;

    public DoraOfflineRecordSyncServiceImpl$dispatchTransferCompleted$1(DoraOfflineRecordSyncServiceImpl r1, e r2, Continuation<? super DoraOfflineRecordSyncServiceImpl$dispatchTransferCompleted$1> r3) {
        this.this$0 = r1;
        this.$recording = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraOfflineRecordSyncServiceImpl$dispatchTransferCompleted$1(this.this$0, this.$recording, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r7);
        DoraOfflineRecordSyncServiceImpl r8 = this.this$0;
        CopyOnWriteArraySet<c> r0 = r8.b;
        e r1 = this.$recording;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L20;
        c r3 = (c) r2.next();
        Intrinsics.checkNotNull(r3);
        if (r8.h() == false) goto L6;
        if (r8.b.contains(r3) == false) goto L6;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L14
        r3.b(r1);     // Catch: Throwable -> L14
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L6;
        d.c("DoraOfflineRecordSyncService", "Dispatch offline record transfer completed failed, listener=" + r3.getClass().getName() + ", vuiId=" + r1.a, r6);
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L20:
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
