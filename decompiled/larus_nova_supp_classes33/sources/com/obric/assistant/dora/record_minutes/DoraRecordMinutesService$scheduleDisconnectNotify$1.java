package com.obric.assistant.dora.record_minutes;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraConnectState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.dora.record_minutes.DoraRecordMinutesService$scheduleDisconnectNotify$1", f = "DoraRecordMinutesService.kt", i = {}, l = {442}, m = "invokeSuspend", n = {}, s = {})
final class DoraRecordMinutesService$scheduleDisconnectNotify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    public DoraRecordMinutesService$scheduleDisconnectNotify$1(Context r1, Continuation<? super DoraRecordMinutesService$scheduleDisconnectNotify$1> r2) {
        this.$context = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraRecordMinutesService$scheduleDisconnectNotify$1(this.$context, r3);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        if (DoraRecordMinutesService.f == DoraConnectState.CONNECTED) goto L28;
        Job r7 = DoraRecordMinutesService.d;
        if (r7 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == false) goto L28;
        if (DoraRecordMinutesService.g == null) goto L28;
        DoraRecordMinutesService.a.getClass();
        if (DoraRecordMinutesService.i("dora_disconnected", false) == false) goto L26;
        DoraRecordMinutesService.e(this.$context);
    L26:
        DoraRecordMinutesService.j();
        return Unit.INSTANCE;
    L16:
        if (r7.isActive() != true) goto L18;
        r8 = true;
    L28:
        FLogger r9 = FLogger.a;
        StringBuilder r3 = new StringBuilder("scheduleDisconnectNotify skipped after delay, lastConnectState=");
        r3.append(DoraRecordMinutesService.f);
        r3.append(", isObserving=");
        Job r4 = DoraRecordMinutesService.d;
        if (r4 != null) goto L31;
    L33:
        boolean r5 = false;
    L34:
        r3.append(r5);
        r3.append(", hasPcmSession=");
        if (DoraRecordMinutesService.g != null) goto L38;
        r2 = false;
    L38:
        r3.append(r2);
        r9.i("DoraRecordMinutesService", r3.toString());
        return Unit.INSTANCE;
    L31:
        if (r4.isActive() != true) goto L33;
        r5 = true;
        goto L34
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L12;
        return r0;
    }
}
