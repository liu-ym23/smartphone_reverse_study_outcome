package com.larus.audio.call.plugins;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.mgr.AVKitCoreStates$Connecting;
import com.larus.audio.call.mgr.AVKitDuplexState;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.plugins.RealtimeCallConnectTimeoutPlugin$createCallStateObserver$1", f = "RealtimeCallConnectTimeoutPlugin.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallConnectTimeoutPlugin$createCallStateObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallConnectTimeoutPlugin this$0;

    public /* synthetic */ class a implements FlowCollector, FunctionAdapter {
        public final /* synthetic */ RealtimeCallConnectTimeoutPlugin a;

        public a(RealtimeCallConnectTimeoutPlugin r1) {
            this.a = r1;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof FlowCollector) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return new AdaptedFunctionReference(2, this.a, RealtimeCallConnectTimeoutPlugin.class, "handleUpState", "handleUpState(Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;)V", 4);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final Object emit(Object r2, Continuation r3) {
            RealtimeCallConnectTimeoutPlugin r0 = this.a;
            Object r4 = RealtimeCallConnectTimeoutPlugin$createCallStateObserver$1.access$invokeSuspend$handleUpState(r0, (AVKitDuplexState.UpState) r2, r3);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }
    }

    public RealtimeCallConnectTimeoutPlugin$createCallStateObserver$1(RealtimeCallConnectTimeoutPlugin r1, Continuation<? super RealtimeCallConnectTimeoutPlugin$createCallStateObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallConnectTimeoutPlugin$createCallStateObserver$1(this.this$0, r3);
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
        final kotlinx.coroutines.flow.i1<AVKitDuplexState> r6 = this.this$0.getContext().a().y();
        Flow r7 = kotlinx.coroutines.flow.e.n(new RealtimeCallConnectTimeoutPlugin$createCallStateObserver$1$invokeSuspend$$inlined$map$1(r6));
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }

    public static final Object access$invokeSuspend$handleUpState(RealtimeCallConnectTimeoutPlugin r0, AVKitDuplexState.UpState r1, Continuation r2) {
        if (r0.k3() == true) goto L10;
        if ((r1 instanceof AVKitCoreStates$Connecting) == false) goto L8;
        r0.l3();
        goto L10
    L8:
        r0.j3(null);
    L10:
        return Unit.INSTANCE;
    }
}
