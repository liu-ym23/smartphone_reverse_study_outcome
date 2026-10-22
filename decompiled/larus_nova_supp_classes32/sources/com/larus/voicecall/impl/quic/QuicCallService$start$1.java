package com.larus.voicecall.impl.quic;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.quic.QuicCallService$start$1", f = "QuicCallService.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
public final class QuicCallService$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ QuicCallService this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ QuicCallService a;

        public a(QuicCallService r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            AVKitDuplexState r7 = (AVKitDuplexState) r5;
            QuicCallService r8 = this.a;
            int r0 = QuicCallService.x;
            r8.getClass();
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("CallStateManager duplex, callId: ");
            RealtimeCallParam r3 = r8.t;
            String r4 = null;
            if (r3 == null) goto L5;
            String r9 = r3.e;
        L6:
            r2.append(r9);
            r2.append(", roomId: ");
            RealtimeCallParam r10 = r8.t;
            if (r10 == null) goto L9;
            r4 = r10.d;
        L9:
            r2.append(r4);
            r2.append(", state: ");
            r2.append(r7.toSimpleString());
            r1.i("QuicCallService", r2.toString());
            if ((r7.getUpState() instanceof AVKitCoreStates.Error) == false) goto L12;
        L13:
            r8.j();
        L15:
            return Unit.INSTANCE;
        L12:
            if ((r7.getDownState() instanceof AVKitCoreStates.Error) == false) goto L15;
        L5:
            r9 = null;
            goto L6
        }
    }

    public QuicCallService$start$1(QuicCallService r1, Continuation<? super QuicCallService$start$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new QuicCallService$start$1(this.this$0, r3);
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
        QuicCallService r6 = this.this$0;
        int r2 = QuicCallService.x;
        i1 r7 = r6.h().y();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
