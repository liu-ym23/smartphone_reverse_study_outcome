package com.larus.voicecall.impl.ui;

import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.MajorState;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.plugins.k2;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallFragment$listenOnCallStateChange$2", f = "RealtimeCallFragment.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallFragment$listenOnCallStateChange$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallFragment this$0;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.ui.RealtimeCallFragment$listenOnCallStateChange$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Lcom/larus/audio/call/mgr/AVKitDuplexState;", "Lcom/larus/audio/call/mgr/MajorState;", NameKeys.UnloadStrategy_No_Strategy, "<destruct>", "Lkotlin/Pair;", "ending", NameKeys.UnloadStrategy_No_Strategy}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallFragment$listenOnCallStateChange$2$1", f = "RealtimeCallFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<Pair<? extends AVKitDuplexState, ? extends Integer>, Boolean, Continuation<? super Triple<? extends AVKitDuplexState, ? extends MajorState, ? extends Integer>>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(3, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((Pair) r1, ((Boolean) r2).booleanValue(), (Continuation) r3);
        }

        public final Object invoke(Pair<AVKitDuplexState, Integer> r2, boolean r3, Continuation<? super Triple<AVKitDuplexState, ? extends MajorState, Integer>> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(r4);
            r0.L$0 = r2;
            r0.Z$0 = r3;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L33;
            ResultKt.throwOnFailure(r7);
            Pair r8 = (Pair) this.L$0;
            boolean r0 = this.Z$0;
            AVKitDuplexState r1 = (AVKitDuplexState) r8.component1();
            int r9 = ((Number) r8.component2()).intValue();
            boolean r3 = false;
            if ((r1.getUpState() instanceof AVKitCoreStates.Listening) == false) goto L7;
        L10:
            boolean r2 = true;
        L12:
            if ((r1.getDownState() instanceof AVKitCoreStates.Speaking) == false) goto L14;
        L17:
            r3 = true;
        L18:
            if (r0 == false) goto L22;
            if (r2 == false) goto L22;
            if (r3 == false) goto L22;
            return new Triple(r1, MajorState.b.c, Boxing.boxInt(18));
        L22:
            MajorState r4 = p.a(r1);
            if (r9 != 8) goto L25;
        L29:
            r9 = r4.a;
        L31:
            return new Triple(r1, r4, Boxing.boxInt(r9));
        L25:
            if (r9 == 14) goto L29;
            if (r9 == 15) goto L29;
        L14:
            if ((r1.getDownState() instanceof AVKitCoreStates.Thinking) == true) goto L17;
            if ((r1.getDownState() instanceof AVKitCoreStates.DownWaiting) == false) goto L18;
        L7:
            if ((r1.getUpState() instanceof AVKitCoreStates.Recognizing) == true) goto L10;
            r2 = false;
            goto L12
        L33:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ RealtimeCallFragment a;

        public a(RealtimeCallFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            Triple r9 = (Triple) r7;
            AVKitDuplexState r10 = (AVKitDuplexState) r9.component1();
            MajorState r0 = (MajorState) r9.component2();
            int r11 = ((Number) r9.component3()).intValue();
            Pair<? extends MajorState, Integer> r1 = this.a.p;
            MajorState r2 = (MajorState) r1.component1();
            int r3 = ((Number) r1.component2()).intValue();
            FLogger.a.i("RealtimeCallFragment", "[CALL] Fragment state change(duplex→serial): (" + r2 + ", " + r3 + ") -> (" + r0 + ", " + r11 + ") duplex=" + r10.toSimpleString());
            this.a.p = TuplesKt.to(r0, Boxing.boxInt(r11));
            RealtimeCallFragment.S90(this.a, r0, r11);
            return Unit.INSTANCE;
        }
    }

    public RealtimeCallFragment$listenOnCallStateChange$2(RealtimeCallFragment r1, Continuation<? super RealtimeCallFragment$listenOnCallStateChange$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallFragment$listenOnCallStateChange$2(this.this$0, r3);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        RealtimeCallFragment r7 = this.this$0;
        int r2 = RealtimeCallFragment.r;
        Flow r8 = kotlinx.coroutines.flow.e.o(new v0(((com.larus.audio.call.a) r7.U90()).o, ((k2) LLMCallController.w(this.this$0.U90().u, Reflection.getOrCreateKotlinClass(k2.class))).S1(), new AnonymousClass1(null)), new o());
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
