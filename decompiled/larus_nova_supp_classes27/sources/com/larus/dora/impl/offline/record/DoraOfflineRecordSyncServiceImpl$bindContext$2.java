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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.offline.record.DoraOfflineRecordSyncServiceImpl$bindContext$2", f = "DoraOfflineRecordSyncServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraOfflineRecordSyncServiceImpl$bindContext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $businessType;
    final /* synthetic */ String $contextId;
    final /* synthetic */ int $contextType;
    final /* synthetic */ String $vuiId;
    int label;
    final /* synthetic */ DoraOfflineRecordSyncServiceImpl this$0;

    public DoraOfflineRecordSyncServiceImpl$bindContext$2(DoraOfflineRecordSyncServiceImpl r1, int r2, String r3, int r4, String r5, Continuation<? super DoraOfflineRecordSyncServiceImpl$bindContext$2> r6) {
        this.this$0 = r1;
        this.$businessType = r2;
        this.$vuiId = r3;
        this.$contextType = r4;
        this.$contextId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DoraOfflineRecordSyncServiceImpl$bindContext$2(this.this$0, this.$businessType, this.$vuiId, this.$contextType, this.$contextId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r14);
        DoraOfflineRecordSyncServiceImpl r15 = this.this$0;
        int r0 = this.$businessType;
        String r1 = this.$vuiId;
        int r2 = this.$contextType;
        String r3 = this.$contextId;
        int r4 = DoraOfflineRecordSyncServiceImpl.g;
        boolean r5 = false;
        if (r15.h() == true) goto L32;
        d.d("DoraOfflineRecordSyncService", "Bind offline record context skipped because ability is unsupported");
    L29:
        return Boxing.boxBoolean(r5);
    L32:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L9
        Object r16 = Result.constructor-impl(Boolean.valueOf(r15.c.bindContext(r0, r1, r2, r3)));     // Catch: Throwable -> L9
    L12:
        if (Result.isSuccess-impl(r16) == false) goto L18;
        boolean r7 = ((Boolean) r16).booleanValue();
        StringBuilder r11 = new StringBuilder("Bind offline record context finished, success=");
        r11.append(r7);
        r11.append(", businessType=");
        r11.append(r0);
        r11.append(", vuiId=");
        r11.append(r1);
        r11.append(", contextType=");
        r11.append(r2);
        r11.append(", contextIdPresent=");
        if (r3.length() <= 0) goto L16;
        boolean r8 = true;
    L17:
        r11.append(r8);
        d.d("DoraOfflineRecordSyncService", r11.toString());
        goto L18
    L16:
        r8 = false;
    L18:
        Throwable r9 = Result.exceptionOrNull-impl(r16);
        if (r9 == null) goto L24;
        StringBuilder r12 = new StringBuilder("Bind offline record context failed, businessType=");
        r12.append(r0);
        r12.append(", vuiId=");
        r12.append(r1);
        r12.append(", contextType=");
        r12.append(r2);
        r12.append(", contextIdPresent=");
        if (r3.length() <= 0) goto L23;
        r5 = true;
    L23:
        r12.append(r5);
        d.c("DoraOfflineRecordSyncService", r12.toString(), r9);
    L24:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r16) == false) goto L27;
        r16 = r10;
    L27:
        r5 = ((Boolean) r16).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
