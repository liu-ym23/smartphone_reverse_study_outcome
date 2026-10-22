package com.larus.dora.impl.offline.record;

import com.larus.dora.api.offline.record.e;
import fk4.c;
import g49.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/dora/api/offline/record/DoraOfflineSyncedRecording;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.offline.record.DoraOfflineRecordSyncServiceImpl$getSyncedRecordings$2", f = "DoraOfflineRecordSyncServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraOfflineRecordSyncServiceImpl$getSyncedRecordings$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends e>>, Object> {
    int label;
    final /* synthetic */ DoraOfflineRecordSyncServiceImpl this$0;

    public DoraOfflineRecordSyncServiceImpl$getSyncedRecordings$2(DoraOfflineRecordSyncServiceImpl r1, Continuation<? super DoraOfflineRecordSyncServiceImpl$getSyncedRecordings$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraOfflineRecordSyncServiceImpl$getSyncedRecordings$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<e>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r5);
        DoraOfflineRecordSyncServiceImpl r6 = this.this$0;
        int r0 = DoraOfflineRecordSyncServiceImpl.g;
        if (r6.h() == true) goto L25;
        d.d("DoraOfflineRecordSyncService", "Get synced offline records skipped because ability is unsupported");
        return CollectionsKt.emptyList();
    L25:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        List r7 = r6.c.getSyncedRecords();     // Catch: Throwable -> L13
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));     // Catch: Throwable -> L13
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L13
    L9:
        if (r8.hasNext() == false) goto L11;
        c r3 = (c) r8.next();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L13
        r2.add(DoraOfflineRecordSyncServiceImpl.i(r3));     // Catch: Throwable -> L13
        goto L9
    L11:
        Object r9 = Result.constructor-impl(r2);     // Catch: Throwable -> L13
    L15:
        Throwable r4 = Result.exceptionOrNull-impl(r9);
        if (r4 == null) goto L18;
        d.d("DoraOfflineRecordSyncService", "Get synced offline records from SDK failed, msg=" + r4.getMessage());
    L18:
        List r10 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r9) == false) goto L22;
        r9 = r10;
    L22:
        return (List) r9;
    L13:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
