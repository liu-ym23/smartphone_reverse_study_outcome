package com.obric.audio.continuous_talk.session.impl;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
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
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.session.impl.ObricContTalkMgrImpl$startContinuousTtsIslandStateObserver$1", f = "ObricContTalkMgrImpl.kt", i = {}, l = {426}, m = "invokeSuspend", n = {}, s = {})
final class ObricContTalkMgrImpl$startContinuousTtsIslandStateObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricContTalkMgrImpl this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricContTalkMgrImpl a;

        public a(ObricContTalkMgrImpl r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            ObricContTalkMgrImpl r3 = this.a;
            if ((((AVKitDuplexState) r1).getDownState() instanceof AVKitCoreStates.Speaking) == true) goto L5;
        L7:
            boolean r4 = false;
        L8:
            r3.V(r4);
            return Unit.INSTANCE;
        L5:
            if (this.a.J == true) goto L7;
            r4 = true;
            goto L8
        }
    }

    public ObricContTalkMgrImpl$startContinuousTtsIslandStateObserver$1(ObricContTalkMgrImpl r1, Continuation<? super ObricContTalkMgrImpl$startContinuousTtsIslandStateObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricContTalkMgrImpl$startContinuousTtsIslandStateObserver$1(this.this$0, r3);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        i1<AVKitDuplexState> r6 = this.this$0.h();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
