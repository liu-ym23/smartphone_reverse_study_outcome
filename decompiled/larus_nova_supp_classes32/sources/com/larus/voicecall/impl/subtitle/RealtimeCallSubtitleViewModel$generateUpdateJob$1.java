package com.larus.voicecall.impl.subtitle;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleViewModel$generateUpdateJob$1", f = "RealtimeCallSubtitleViewModel.kt", i = {0, 0, 1, 1}, l = {446, 454}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u245", "judgeBlock", "$this$invokeSuspend_u24lambda_u245", "judgeBlock"}, s = {"L$1", "L$2", "L$1", "L$2"})
final class RealtimeCallSubtitleViewModel$generateUpdateJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ q0 this$0;

    public RealtimeCallSubtitleViewModel$generateUpdateJob$1(q0 r1, Continuation<? super RealtimeCallSubtitleViewModel$generateUpdateJob$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RealtimeCallSubtitleViewModel$generateUpdateJob$1 r0 = new RealtimeCallSubtitleViewModel$generateUpdateJob$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L10;
        Function0 r0 = (Function0) this.L$2;
        CoroutineScope r3 = (CoroutineScope) this.L$1;
        final q0 r6 = (q0) this.L$0;
    L7:
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L43
    L18:
        if (((Boolean) r0.invoke()).booleanValue() == false) goto L39;
        if (CoroutineScopeKt.isActive(r3) == false) goto L22;
        if (r6.z.get() == false) goto L25;
        FLogger.a.i("RealtimeCallSubtitleViewModel", "generateUpdateJob, current is paused. so cancel it.");     // Catch: Throwable -> L43
        r6.a("current call is paused. so cancel it.");     // Catch: Throwable -> L43
        goto L18
    L25:
        final Ref.BooleanRef r7 = new Ref.BooleanRef();     // Catch: Throwable -> L43
        r6.o(new s0(r6, r7));     // Catch: Throwable -> L43
        if (r7.element == true) goto L27;
        if (r6.D == false) goto L18;
        if (r6.q == 3) goto L34;
        this.L$0 = r6;     // Catch: Throwable -> L43
        this.L$1 = r3;     // Catch: Throwable -> L43
        this.L$2 = r0;     // Catch: Throwable -> L43
        this.label = 2;     // Catch: Throwable -> L43
        if (DelayKt.delay(100, this) != r1) goto L18;
        return r1;
    L34:
        FLogger.a.w("RealtimeCallSubtitleViewModel", "generateUpdateJob break, currentState is listening.");     // Catch: Throwable -> L43
        goto L39
    L27:
        this.L$0 = r6;     // Catch: Throwable -> L43
        this.L$1 = r3;     // Catch: Throwable -> L43
        this.L$2 = r0;     // Catch: Throwable -> L43
        this.label = 1;     // Catch: Throwable -> L43
        if (DelayKt.delay(20, this) != r1) goto L18;
        return r1;
    L22:
        return Unit.INSTANCE;
    L39:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L43
    L45:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L50;
        FLogger.a.e("RealtimeCallSubtitleViewModel", "generateUpdateJob failed:" + r12);
    L50:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r0 = (Function0) this.L$2;
        r3 = (CoroutineScope) this.L$1;
        r6 = (q0) this.L$0;
        goto L7
    L12:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        final q0 r4 = this.this$0;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L43
        FLogger r9 = FLogger.a;     // Catch: Throwable -> L43
        StringBuilder r14 = new StringBuilder("generateUpdateJob, size:");     // Catch: Throwable -> L43
        int r5 = q0.F;     // Catch: Throwable -> L43
        ReentrantLock r15 = r4.e;     // Catch: Throwable -> L43
        r15.lock();     // Catch: Throwable -> L43
        Integer r16 = Integer.valueOf(r4.f.size());     // Catch: Throwable -> L40
        r15.unlock();     // Catch: Throwable -> L43
        r14.append(r16.intValue());     // Catch: Throwable -> L43
        r9.i("RealtimeCallSubtitleViewModel", r14.toString());     // Catch: Throwable -> L43
        r0 = new r0(r4);     // Catch: Throwable -> L43
        r6 = r4;
        r3 = r13;
        goto L18
    L40:
        th = move-exception;
        r15.unlock();     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    }
}
