package com.larus.dora.impl.offline.record;

import com.larus.dora.api.offline.record.c;
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
@DebugMetadata(c = "com.larus.dora.impl.offline.record.DoraOfflineRecordSyncServiceImpl$dispatchRecordFileReadyNotify$1", f = "DoraOfflineRecordSyncServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraOfflineRecordSyncServiceImpl$dispatchRecordFileReadyNotify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.dora.api.offline.record.a $notify;
    int label;
    final /* synthetic */ DoraOfflineRecordSyncServiceImpl this$0;

    public DoraOfflineRecordSyncServiceImpl$dispatchRecordFileReadyNotify$1(DoraOfflineRecordSyncServiceImpl r1, com.larus.dora.api.offline.record.a r2, Continuation<? super DoraOfflineRecordSyncServiceImpl$dispatchRecordFileReadyNotify$1> r3) {
        this.this$0 = r1;
        this.$notify = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraOfflineRecordSyncServiceImpl$dispatchRecordFileReadyNotify$1(this.this$0, this.$notify, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r8);
        DoraOfflineRecordSyncServiceImpl r9 = this.this$0;
        CopyOnWriteArraySet<c> r0 = r9.b;
        com.larus.dora.api.offline.record.a r1 = this.$notify;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L18;
        c r3 = (c) r2.next();
        Intrinsics.checkNotNull(r3);
        if (r9.b.contains(r3) == false) goto L9;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
        d.d("DoraOfflineRecordSyncService", "Invoke offline record file ready listener, listener=".concat(r3.getClass().getName()));     // Catch: Throwable -> L12
        r3.a(r1);     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L6;
        d.c("DoraOfflineRecordSyncService", "Dispatch offline record file ready notify failed, listener=" + r3.getClass().getName() + ", businessType=" + r1.b + ", vuiId=" + r1.c + ", fileType=" + r1.f, r6);
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L9:
        d.d("DoraOfflineRecordSyncService", "Skip offline record file ready notify, listener unregistered");
        goto L6
    L18:
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
