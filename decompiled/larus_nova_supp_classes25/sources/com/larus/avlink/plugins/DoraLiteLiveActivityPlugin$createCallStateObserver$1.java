package com.larus.avlink.plugins;

import com.larus.audio.call.InstanceCallState;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraLiteLiveActivityPlugin$createCallStateObserver$1", f = "DoraLiteLiveActivityPlugin.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
public final class DoraLiteLiveActivityPlugin$createCallStateObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraLiteLiveActivityPlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DoraLiteLiveActivityPlugin a;

        public a(DoraLiteLiveActivityPlugin r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            int r5 = ((Number) r3).intValue();
            DoraLiteLiveActivityPlugin r6 = this.a;
            r6.getClass();
            if (BaseDoraLiteLiveAiPlugin.l == false) goto L22;
            InstanceCallState.Companion.getClass();
            com.larus.avlink.n1.d("DoraLiveActivityPlugin", "duplex → instance: ".concat(InstanceCallState.a.a(r5)));
            if (r5 != 3) goto L11;
            if (com.larus.audio.call.arch.b.a(r6.getContext()).a0() == true) goto L22;
        L11:
            if (r5 == 4) goto L22;
            if (r5 == 9) goto L22;
            String r0 = r6.j3(r5, r6.f);
            if (r0.length() != 0) goto L17;
            boolean r1 = true;
        L18:
            if (r1 == true) goto L22;
            r6.k3(r0, r5);
            goto L22
        L17:
            r1 = false;
        L22:
            return Unit.INSTANCE;
        }
    }

    public DoraLiteLiveActivityPlugin$createCallStateObserver$1(DoraLiteLiveActivityPlugin r1, Continuation<? super DoraLiteLiveActivityPlugin$createCallStateObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraLiteLiveActivityPlugin$createCallStateObserver$1(this.this$0, r3);
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
        final kotlinx.coroutines.flow.i1 r6 = d3a.a.c(this.this$0.getContext()).y();
        Flow r7 = kotlinx.coroutines.flow.e.n(new DoraLiteLiveActivityPlugin$createCallStateObserver$1$invokeSuspend$$inlined$map$1(r6));
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
