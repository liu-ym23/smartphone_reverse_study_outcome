package com.larus.dora.impl.offline.record;

import com.larus.dora.api.offline.record.b;
import g49.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.offline.record.DoraOfflineRecordSyncServiceImpl$configureStorage$2", f = "DoraOfflineRecordSyncServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraOfflineRecordSyncServiceImpl$configureStorage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ b $config;
    int label;
    final /* synthetic */ DoraOfflineRecordSyncServiceImpl this$0;

    public DoraOfflineRecordSyncServiceImpl$configureStorage$2(DoraOfflineRecordSyncServiceImpl r1, b r2, Continuation<? super DoraOfflineRecordSyncServiceImpl$configureStorage$2> r3) {
        this.this$0 = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraOfflineRecordSyncServiceImpl$configureStorage$2(this.this$0, null, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r3);
        DoraOfflineRecordSyncServiceImpl r4 = this.this$0;
        int r0 = DoraOfflineRecordSyncServiceImpl.g;
        if (r4.h() == true) goto L27;
        d.d("DoraOfflineRecordSyncService", "Configure offline record storage skipped because ability is unsupported");
        boolean r5 = false;
    L20:
        return Boxing.boxBoolean(r5);
    L27:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        throw null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isSuccess-impl(r6) == false) goto L14;
        ((Boolean) r6).booleanValue();
        throw null;
    L14:
        if (Result.exceptionOrNull-impl(r6) != null) goto L22;
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L18;
        r6 = r7;
    L18:
        r5 = ((Boolean) r6).booleanValue();
        goto L20
    L22:
        throw null;
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
