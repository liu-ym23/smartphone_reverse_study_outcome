package com.larus.dora.impl.offline.record;

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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.offline.record.DoraOfflineRecordSyncServiceImpl$deleteSyncedRecording$2", f = "DoraOfflineRecordSyncServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraOfflineRecordSyncServiceImpl$deleteSyncedRecording$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $vuiId;
    int label;
    final /* synthetic */ DoraOfflineRecordSyncServiceImpl this$0;

    public DoraOfflineRecordSyncServiceImpl$deleteSyncedRecording$2(DoraOfflineRecordSyncServiceImpl r1, String r2, Continuation<? super DoraOfflineRecordSyncServiceImpl$deleteSyncedRecording$2> r3) {
        this.this$0 = r1;
        this.$vuiId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraOfflineRecordSyncServiceImpl$deleteSyncedRecording$2(this.this$0, this.$vuiId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r6);
        DoraOfflineRecordSyncServiceImpl r7 = this.this$0;
        String r0 = this.$vuiId;
        int r2 = DoraOfflineRecordSyncServiceImpl.g;
        if (r7.h() == true) goto L8;
        d.d("DoraOfflineRecordSyncService", "Delete app offline record skipped because ability is unsupported");
    L10:
        boolean r8 = false;
    L23:
        return Boxing.boxBoolean(r8);
    L8:
        if (StringsKt.isBlank(r0) == false) goto L26;
        d.d("DoraOfflineRecordSyncService", "Delete app offline record skipped, empty vuiId, reason=partner_notify_delete");
        goto L10
    L26:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        Object r9 = Result.constructor-impl(Boolean.valueOf(r7.c.deleteSyncedRecord(r0, "partner_notify_delete")));     // Catch: Throwable -> L13
    L15:
        Throwable r1 = Result.exceptionOrNull-impl(r9);
        if (r1 == null) goto L18;
        d.c("DoraOfflineRecordSyncService", "Delete app offline record failed, vuiId=" + r0 + ", reason=partner_notify_delete", r1);
    L18:
        Boolean r4 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L21;
        r9 = r4;
    L21:
        r8 = ((Boolean) r9).booleanValue();
        d.d("DoraOfflineRecordSyncService", "Delete app offline record finished, vuiId=" + r0 + ", reason=partner_notify_delete, deleted=" + r8);
    L13:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
