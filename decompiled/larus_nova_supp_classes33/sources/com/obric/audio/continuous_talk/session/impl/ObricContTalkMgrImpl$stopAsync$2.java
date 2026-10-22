package com.obric.audio.continuous_talk.session.impl;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.AVKitDuplexState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.session.impl.ObricContTalkMgrImpl$stopAsync$2", f = "ObricContTalkMgrImpl.kt", i = {}, l = {344}, m = "invokeSuspend", n = {}, s = {})
final class ObricContTalkMgrImpl$stopAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Boolean> $checkNotSpeaking;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricContTalkMgrImpl this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function0<Boolean> a;
        public final /* synthetic */ ObricContTalkMgrImpl b;
        public final /* synthetic */ CoroutineScope c;

        public a(Function0<Boolean> r1, ObricContTalkMgrImpl r2, CoroutineScope r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r2, Continuation r3) {
            AVKitDuplexState r4 = (AVKitDuplexState) r2;
            if (((Boolean) this.a.invoke()).booleanValue() == false) goto L6;
            com.larus.audio.call.util.e.a.i(this.b.v, "stopAsync result: SUCCESS State Not Speaking in Flow");
            CoroutineScopeKt.cancel$default(this.c, null, 1, null);
        L6:
            return Unit.INSTANCE;
        }
    }

    public ObricContTalkMgrImpl$stopAsync$2(ObricContTalkMgrImpl r1, Function0<Boolean> r2, Continuation<? super ObricContTalkMgrImpl$stopAsync$2> r3) {
        this.this$0 = r1;
        this.$checkNotSpeaking = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ObricContTalkMgrImpl$stopAsync$2 r0 = new ObricContTalkMgrImpl$stopAsync$2(this.this$0, this.$checkNotSpeaking, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r7);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        RealtimeCallParam r2 = new RealtimeCallParam();
        this.this$0.G(r2);
        if (((Boolean) this.$checkNotSpeaking.invoke()).booleanValue() == false) goto L12;
        com.larus.audio.call.util.e.a.i(this.this$0.v, "stopAsync result: SUCCESS State Not Speaking in Coroutine");
        return Unit.INSTANCE;
    L12:
        i1<AVKitDuplexState> r3 = this.this$0.h();
        a r4 = new a(this.$checkNotSpeaking, this.this$0, r8);
        this.label = 1;
        if (r3.collect(r4, this) != r0) goto L16;
        return r0;
    }
}
