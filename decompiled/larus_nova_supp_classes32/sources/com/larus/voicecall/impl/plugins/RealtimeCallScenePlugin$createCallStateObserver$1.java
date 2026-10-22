package com.larus.voicecall.impl.plugins;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.plugins.RealtimeCallScenePlugin$createCallStateObserver$1", f = "RealtimeCallScenePlugin.kt", i = {}, l = {301}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallScenePlugin$createCallStateObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallScenePlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ RealtimeCallScenePlugin a;

        public a(RealtimeCallScenePlugin r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            Pair r7 = (Pair) r5;
            AVKitDuplexState r8 = (AVKitDuplexState) r7.component1();
            AVKitDuplexState r9 = (AVKitDuplexState) r7.component2();
            RealtimeCallScenePlugin r0 = this.a;
            r0.getClass();
            AVKitDuplexState.UpState r1 = r9.getUpState();
            AVKitDuplexState.DownState r10 = r9.getDownState();
            if ((r1 instanceof AVKitCoreStates.Listening) == true) goto L7;
            if ((r1 instanceof AVKitCoreStates.Recognizing) == true) goto L7;
        L9:
            boolean r11 = false;
        L10:
            if (r11 == true) goto L12;
            r0.j.tryEmit(3);
        L30:
            return Unit.INSTANCE;
        L12:
            if (r8 == null) goto L14;
            AVKitDuplexState.DownState r12 = r8.getDownState();
        L16:
            if ((r12 instanceof AVKitCoreStates.Speaking) == false) goto L19;
            r0.j.tryEmit(1);
            goto L30
        L19:
            if (r12 == null) goto L25;
            if ((r12 instanceof AVKitCoreStates.Connecting) == true) goto L25;
            r0.j.tryEmit(2);
        L25:
            if (((r) r0.getContext()).params().A == true) goto L30;
            if (r0.U() == true) goto L30;
            r0.j.tryEmit(2);
            goto L30
        L14:
            r12 = null;
        L7:
            if ((r10 instanceof AVKitCoreStates.DownWaiting) == false) goto L9;
            r11 = true;
            goto L10
        }
    }

    public RealtimeCallScenePlugin$createCallStateObserver$1(RealtimeCallScenePlugin r1, Continuation<? super RealtimeCallScenePlugin$createCallStateObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallScenePlugin$createCallStateObserver$1(this.this$0, r3);
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
        kotlinx.coroutines.flow.c1 r6 = com.larus.audio.call.util.g.a(((r) this.this$0.getContext()).a().y());
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
