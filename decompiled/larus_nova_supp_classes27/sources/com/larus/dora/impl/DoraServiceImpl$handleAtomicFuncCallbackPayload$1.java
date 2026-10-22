package com.larus.dora.impl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.device.settings.sound.DoraAmbientVolumeSettingsNotifier;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl$handleAtomicFuncCallbackPayload$1", f = "DoraServiceImpl.kt", i = {}, l = {842}, m = "invokeSuspend", n = {}, s = {})
final class DoraServiceImpl$handleAtomicFuncCallbackPayload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $adaptiveVolumeRequestId;
    final /* synthetic */ DoraDevice $currentDevice;
    private /* synthetic */ Object L$0;
    int label;

    public DoraServiceImpl$handleAtomicFuncCallbackPayload$1(DoraDevice r1, Long r2, Continuation<? super DoraServiceImpl$handleAtomicFuncCallbackPayload$1> r3) {
        this.$currentDevice = r1;
        this.$adaptiveVolumeRequestId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DoraServiceImpl$handleAtomicFuncCallbackPayload$1 r0 = new DoraServiceImpl$handleAtomicFuncCallbackPayload$1(this.$currentDevice, this.$adaptiveVolumeRequestId, r5);
        r0.L$0 = r4;
        return r0;
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L15
    L13:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Long r2 = this.$adaptiveVolumeRequestId;
        if (Result.isSuccess-impl(r7) == false) goto L20;
        Unit r3 = (Unit) r7;
        FLogger.a.i("DoraServiceImpl", "atomicFuncCallback: adaptive-volume state notified, requestId=" + r2);
    L20:
        Long r4 = this.$adaptiveVolumeRequestId;
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L24;
        FLogger.a.e("DoraServiceImpl", "atomicFuncCallback: adaptive-volume state notification failed, requestId=" + r4, r8);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        DoraDevice r10 = this.$currentDevice;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        DoraAmbientVolumeSettingsNotifier r11 = DoraAmbientVolumeSettingsNotifier.a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r11.c(r10, this) != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
