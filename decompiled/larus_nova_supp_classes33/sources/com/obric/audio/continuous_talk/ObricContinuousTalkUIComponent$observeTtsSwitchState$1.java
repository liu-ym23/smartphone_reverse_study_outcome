package com.obric.audio.continuous_talk;

import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.ObricContinuousTalkUIComponent$observeTtsSwitchState$1", f = "ObricContinuousTalkUIComponent.kt", i = {}, l = {705}, m = "invokeSuspend", n = {}, s = {})
final class ObricContinuousTalkUIComponent$observeTtsSwitchState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ z0<Boolean> $ttsFlow;
    int label;
    final /* synthetic */ ObricContinuousTalkUIComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricContinuousTalkUIComponent a;

        public a(ObricContinuousTalkUIComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            boolean r5 = ((Boolean) r3).booleanValue();
            FLogger.a.i("ObricContinuousTalkUIComponent", "TTS switch state changed, isTtsOn=" + r5);
            this.a.D3(r5 ^ true);
            return Unit.INSTANCE;
        }
    }

    public ObricContinuousTalkUIComponent$observeTtsSwitchState$1(z0<Boolean> r1, ObricContinuousTalkUIComponent r2, Continuation<? super ObricContinuousTalkUIComponent$observeTtsSwitchState$1> r3) {
        this.$ttsFlow = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricContinuousTalkUIComponent$observeTtsSwitchState$1(this.$ttsFlow, this.this$0, r4);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.flow.v r6 = e.p(this.$ttsFlow, 1);
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
