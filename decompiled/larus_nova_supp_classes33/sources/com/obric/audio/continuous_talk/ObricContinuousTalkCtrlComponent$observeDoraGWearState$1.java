package com.obric.audio.continuous_talk;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraWearState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkCtrlComponent$observeDoraGWearState$1", f = "ObricContinuousTalkCtrlComponent.kt", i = {}, l = {1225}, m = "invokeSuspend", n = {}, s = {})
final class ObricContinuousTalkCtrlComponent$observeDoraGWearState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricContinuousTalkCtrlComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricContinuousTalkCtrlComponent a;

        public a(ObricContinuousTalkCtrlComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            vha.a.a r11 = (vha.a) r9;
            if ((r11 instanceof vha.a.a) == false) goto L18;
            FLogger r12 = FLogger.a;
            r12.i("ObricContinuousTalkCtrlComponent", "coWakeupEvent: " + r11);
            ObricContinuousTalkCtrlComponent r2 = this.a;
            DoraWearState r13 = r11.c;
            DoraWearState r0 = r2.m;
            r2.m = r13;
            DoraWearState r3 = DoraWearState.ON;
            if (r13 != r3) goto L18;
            if (r0 == r3) goto L18;
            CoWakeupApi r14 = uha.a.a();
            if (r14 == null) goto L12;
            boolean r1 = true;
            if (r14.c() != true) goto L12;
        L13:
            if (r1 == false) goto L18;
            if (r2.m0() == false) goto L18;
            r12.i("ObricContinuousTalkCtrlComponent", "DoraG wear on, close continuous talk");
            c.a.a(r2, ObricContinuousTalkEndType.MEDIA_INTERRUPT, null, false, false, 6);
        L12:
            r1 = false;
        L18:
            return Unit.INSTANCE;
        }
    }

    public ObricContinuousTalkCtrlComponent$observeDoraGWearState$1(ObricContinuousTalkCtrlComponent r1, Continuation<? super ObricContinuousTalkCtrlComponent$observeDoraGWearState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricContinuousTalkCtrlComponent$observeDoraGWearState$1(this.this$0, r3);
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
        if (r6 == null) goto L18;
        MutableSharedFlow r7 = r6.d();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
