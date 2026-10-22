package com.larus.audio.call;

import android.os.SystemClock;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.SupportPauseCountDownTimer$startTimerInner$1", f = "CountDownTimerManager.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
final class SupportPauseCountDownTimer$startTimerInner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    int label;
    final /* synthetic */ p this$0;

    public SupportPauseCountDownTimer$startTimerInner$1(p r1, long r2, Continuation<? super SupportPauseCountDownTimer$startTimerInner$1> r4) {
        this.this$0 = r1;
        this.$delayMs = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SupportPauseCountDownTimer$startTimerInner$1(this.this$0, this.$delayMs, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        long r3 = 0;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L15:
        p r13 = this.this$0;
        long r2 = r13.a - r13.d;
        if (r2 <= 0) goto L18;
        long r5 = SystemClock.elapsedRealtime();
        this.this$0.c(r2);
        long r7 = SystemClock.elapsedRealtime() - r5;
        long r6 = this.this$0.b;
        if (r2 >= r6) goto L27;
        long r4 = r2 - r7;
        if (r4 < 0) goto L32;
        r3 = r4;
    L32:
        p r14 = this.this$0;
        r14.d += r7 + r3;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r14.f.plus(Dispatchers.getMain())), null, null, new SupportPauseCountDownTimer$startTimerInner$1(r14, r3, null), 3, null);
    L34:
        return Unit.INSTANCE;
    L27:
        long r8 = r6 - r7;
    L29:
        if (r8 >= 0) goto L31;
        r8 = r8 + this.this$0.b;
        goto L29
    L31:
        r3 = r8;
        goto L32
    L18:
        if (r13.c == true) goto L34;
        r13.b();
        goto L34
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        if (this.this$0.c == true) goto L36;
        long r9 = this.$delayMs;
        if (r9 == 0) goto L15;
        this.label = 1;
        if (DelayKt.delay(r9, this) != r0) goto L15;
        return r0;
    L36:
        return Unit.INSTANCE;
    }
}
