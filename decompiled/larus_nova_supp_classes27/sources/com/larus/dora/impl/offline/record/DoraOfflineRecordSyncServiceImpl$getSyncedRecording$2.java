package com.larus.dora.impl.offline.record;

import com.larus.dora.api.offline.record.e;
import fk4.c;
import g49.d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/api/offline/record/DoraOfflineSyncedRecording;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.offline.record.DoraOfflineRecordSyncServiceImpl$getSyncedRecording$2", f = "DoraOfflineRecordSyncServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraOfflineRecordSyncServiceImpl$getSyncedRecording$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e>, Object> {
    final /* synthetic */ String $vuiId;
    int label;
    final /* synthetic */ DoraOfflineRecordSyncServiceImpl this$0;

    public DoraOfflineRecordSyncServiceImpl$getSyncedRecording$2(String r1, DoraOfflineRecordSyncServiceImpl r2, Continuation<? super DoraOfflineRecordSyncServiceImpl$getSyncedRecording$2> r3) {
        this.$vuiId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraOfflineRecordSyncServiceImpl$getSyncedRecording$2(this.$vuiId, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super e> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r7);
        Object r0 = null;
        if (StringsKt.isBlank(this.$vuiId) == false) goto L8;
        d.d("DoraOfflineRecordSyncService", "Get synced offline recording skipped, empty vuiId");
        return null;
    L8:
        DoraOfflineRecordSyncServiceImpl r8 = this.this$0;
        String r2 = this.$vuiId;
        int r3 = DoraOfflineRecordSyncServiceImpl.g;
        if (r8.h() == true) goto L30;
        d.d("DoraOfflineRecordSyncService", "Get synced offline record skipped because ability is unsupported");
        return null;
    L30:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        c r9 = r8.c.getSyncedRecord(r2);     // Catch: Throwable -> L17
        if (r9 == null) goto L14;
        e r10 = DoraOfflineRecordSyncServiceImpl.i(r9);     // Catch: Throwable -> L17
    L15:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L17
    L19:
        Throwable r5 = Result.exceptionOrNull-impl(r11);
        if (r5 == null) goto L23;
        d.d("DoraOfflineRecordSyncService", "Get synced offline record from SDK failed, vuiId=" + r2 + ", msg=" + r5.getMessage());
    L23:
        if (Result.isFailure-impl(r11) == true) goto L27;
        r0 = r11;
    L27:
        return (e) r0;
    L14:
        r10 = null;
    L17:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
