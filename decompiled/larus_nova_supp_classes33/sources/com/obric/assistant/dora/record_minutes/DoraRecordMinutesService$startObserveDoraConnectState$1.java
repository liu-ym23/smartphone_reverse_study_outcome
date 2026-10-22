package com.obric.assistant.dora.record_minutes;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraConnectState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.dora.record_minutes.DoraRecordMinutesService$startObserveDoraConnectState$1", f = "DoraRecordMinutesService.kt", i = {}, l = {407}, m = "invokeSuspend", n = {}, s = {})
public final class DoraRecordMinutesService$startObserveDoraConnectState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Context a;

        public a(Context r1) {
            this.a = r1;
        }

        public final Object emit(Object r11, Continuation r12) {
            vha.a.a r13 = (vha.a) r11;
            if ((r13 instanceof vha.a.a) == false) goto L14;
            DoraRecordMinutesService r14 = DoraRecordMinutesService.a;
            Context r0 = this.a;
            DoraConnectState r15 = r13.b;
            r14.getClass();
            DoraConnectState r16 = DoraRecordMinutesService.f;
            DoraRecordMinutesService.f = r15;
            FLogger r1 = FLogger.a;
            r1.i("DoraRecordMinutesService", "handleDoraConnectStateChanged previousState=" + r16 + ", connectState=" + r15);
            DoraConnectState r2 = DoraConnectState.CONNECTED;
            if (r15 != r2) goto L7;
            DoraRecordMinutesService.b();
            goto L14
        L7:
            if (r16 != r2) goto L14;
            if (r15 == r2) goto L14;
            Job r17 = DoraRecordMinutesService.e;
            if (r17 == null) goto L12;
            Job.DefaultImpls.cancel$default(r17, null, 1, null);
        L12:
            r1.i("DoraRecordMinutesService", "scheduleDisconnectNotify delayMs=500");
            DoraRecordMinutesService.e = BuildersKt.launch$default(DoraRecordMinutesService.c, null, null, new DoraRecordMinutesService$scheduleDisconnectNotify$1(r0, null), 3, null);
        L14:
            return Unit.INSTANCE;
        }
    }

    public DoraRecordMinutesService$startObserveDoraConnectState$1(Context r1, Continuation<? super DoraRecordMinutesService$startObserveDoraConnectState$1> r2) {
        this.$context = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraRecordMinutesService$startObserveDoraConnectState$1(this.$context, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoWakeupApi r6 = uha.a.a();
        if (r6 == null) goto L17;
        MutableSharedFlow r7 = r6.d();
        if (r7 == null) goto L17;
        a r2 = new a(this.$context);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L17:
        FLogger.a.i("DoraRecordMinutesService", "startObserveDoraConnectState skipped, coWakeupApiDelegate is null");
        return Unit.INSTANCE;
    }
}
