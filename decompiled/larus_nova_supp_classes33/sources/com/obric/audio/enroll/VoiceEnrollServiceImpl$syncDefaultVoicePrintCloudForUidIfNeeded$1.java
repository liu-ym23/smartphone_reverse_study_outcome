package com.obric.audio.enroll;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.utils.j;
import com.obric.audio.enroll.sami.SamiEnrollEngine;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.VoiceEnrollServiceImpl$syncDefaultVoicePrintCloudForUidIfNeeded$1", f = "VoiceEnrollServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceEnrollServiceImpl$syncDefaultVoicePrintCloudForUidIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $desired;
    final /* synthetic */ String $reason;
    final /* synthetic */ String $uid;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VoiceEnrollServiceImpl this$0;

    public VoiceEnrollServiceImpl$syncDefaultVoicePrintCloudForUidIfNeeded$1(VoiceEnrollServiceImpl r1, String r2, String r3, String r4, Continuation<? super VoiceEnrollServiceImpl$syncDefaultVoicePrintCloudForUidIfNeeded$1> r5) {
        this.this$0 = r1;
        this.$uid = r2;
        this.$desired = r3;
        this.$reason = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        VoiceEnrollServiceImpl$syncDefaultVoicePrintCloudForUidIfNeeded$1 r6 = new VoiceEnrollServiceImpl$syncDefaultVoicePrintCloudForUidIfNeeded$1(this.this$0, this.$uid, this.$desired, this.$reason, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L47;
        ResultKt.throwOnFailure(r14);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        VoiceEnrollServiceImpl r16 = this.this$0;
        Object r4 = r16.c;
        String r5 = this.$uid;
        String r6 = this.$desired;
        String r7 = this.$reason;
        monitor-enter(r4);
        String r8 = pia.d.d(r5);     // Catch: Throwable -> L43
        String r9 = pia.d.c(r5);     // Catch: Throwable -> L43
        if (Intrinsics.areEqual(r8, r6) == true) goto L9;
    L38:
        FLogger.a.i("VoiceEnrollServiceImpl", "sync per-uid skip in critical section uid=" + j.d(r5) + " desired=" + r6 + " lockedDesired=" + r8 + " lockedActual=" + r9 + " reason=" + r7);     // Catch: Throwable -> L43
        int r2 = 0;
    L40:
        monitor-exit(r4);
        FLogger.a.i("VoiceEnrollServiceImpl", "sync per-uid uid=" + j.d(this.$uid) + " desired=" + this.$desired + " ret=" + r2 + " reason=" + this.$reason);
        return Unit.INSTANCE;
    L9:
        if (Intrinsics.areEqual(r8, "none") == true) goto L38;
        if (Intrinsics.areEqual(r9, r8) == true) goto L38;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r8, "upload") == false) goto L20;
        SamiEnrollEngine.a.getClass();     // Catch: Throwable -> L17
        int r11 = SamiEnrollEngine.K(r5);     // Catch: Throwable -> L17
    L23:
        Object r12 = Result.constructor-impl(Boxing.boxInt(r11));     // Catch: Throwable -> L17
    L26:
        Throwable r13 = Result.exceptionOrNull-impl(r12);     // Catch: Throwable -> L43
        if (r13 == null) goto L29;
        FLogger.a.e("VoiceEnrollServiceImpl", "sync per-uid failed uid=" + j.d(r5) + " desired=" + r8 + ": " + r13.getMessage());     // Catch: Throwable -> L43
    L29:
        Integer r3 = Boxing.boxInt(Integer.MIN_VALUE);     // Catch: Throwable -> L43
        if (Result.isFailure-impl(r12) == false) goto L32;
        r12 = r3;
    L32:
        r2 = ((Number) r12).intValue();     // Catch: Throwable -> L43
        if (r2 != 0) goto L40;
        String r17 = pia.d.d(r5);     // Catch: Throwable -> L43
        if (Intrinsics.areEqual(r17, r8) == false) goto L37;
        VoiceEnrollServiceImpl.w(r16, r5, r8, "sync_success reason=" + r7);     // Catch: Throwable -> L43
        goto L40
    L37:
        FLogger.a.i("VoiceEnrollServiceImpl", "sync per-uid skip actual update uid=" + j.d(r5) + " lockedDesired=" + r8 + " latestDesired=" + r17 + " reason=" + r7);     // Catch: Throwable -> L43
        goto L40
    L20:
        if (Intrinsics.areEqual(r8, "delete") == false) goto L22;
        SamiEnrollEngine.a.getClass();     // Catch: Throwable -> L17
        r11 = SamiEnrollEngine.m(r5);     // Catch: Throwable -> L17
        goto L23
    L22:
        r11 = Integer.MIN_VALUE;
    L17:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L43
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L47:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
