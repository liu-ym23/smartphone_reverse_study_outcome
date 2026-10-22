package com.larus.voicecall.impl.ui;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.MajorState;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallFragment$listenOnCallStateChange$1", f = "RealtimeCallFragment.kt", i = {}, l = {347}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallFragment$listenOnCallStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ RealtimeCallFragment a;

        public a(RealtimeCallFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            com.larus.voicecall.impl.c r6 = (com.larus.voicecall.impl.c) r4;
            RealtimeCallFragment r7 = this.a;
            boolean r0 = r7.o;
            r7.o = r6.b;
            e3a.b r8 = r7.W90();
            ((h88.b) r8).n = r6.b;
            if (((h88.b) this.a.W90()).m == r6.a) goto L9;
            e3a.b r9 = this.a.W90();
            boolean r1 = r6.a;
            ((h88.b) r9).m = r1;
            ObricInteractDelegate.b.updateMuteStatus(r1);
            RealtimeCallFragment r10 = this.a;
            MajorState r2 = ((h88.b) r10.W90()).l;
            if (r6.a == false) goto L7;
            int r3 = 14;
        L8:
            RealtimeCallFragment.S90(r10, r2, r3);
            goto L9
        L7:
            r3 = 15;
        L9:
            if (r0 == false) goto L16;
            if (r6.b == true) goto L16;
            if ((this.a.U90().i().getUpState() instanceof AVKitCoreStates.Listening) == false) goto L16;
            RealtimeCallFragment r11 = this.a;
            RealtimeCallFragment.S90(r11, p.a(r11.U90().i()), 8);
        L16:
            return Unit.INSTANCE;
        }
    }

    public RealtimeCallFragment$listenOnCallStateChange$1(RealtimeCallFragment r1, Continuation<? super RealtimeCallFragment$listenOnCallStateChange$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallFragment$listenOnCallStateChange$1(this.this$0, r3);
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
        RealtimeCallFragment r6 = this.this$0;
        int r2 = RealtimeCallFragment.r;
        Flow<com.larus.voicecall.impl.c> r7 = r6.U90().m();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
