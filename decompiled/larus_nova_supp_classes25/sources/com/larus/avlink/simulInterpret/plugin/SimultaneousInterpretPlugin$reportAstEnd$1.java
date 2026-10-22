package com.larus.avlink.simulInterpret.plugin;

import com.larus.avlink.n1;
import com.larus.avlink.plugins.n4;
import com.larus.avlink.simulInterpret.api.SimultaneousInterpretEndReportApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.FlowHttpConnection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.simulInterpret.plugin.SimultaneousInterpretPlugin$reportAstEnd$1", f = "SimultaneousInterpretPlugin.kt", i = {}, l = {502}, m = "invokeSuspend", n = {}, s = {})
final class SimultaneousInterpretPlugin$reportAstEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SimultaneousInterpretPlugin this$0;

    public SimultaneousInterpretPlugin$reportAstEnd$1(SimultaneousInterpretPlugin r1, Continuation<? super SimultaneousInterpretPlugin$reportAstEnd$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SimultaneousInterpretPlugin$reportAstEnd$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        dm9.a.a r15 = (dm9.a) r14;
        if ((r15 instanceof dm9.a.b) == false) goto L15;
        n1.d(this.this$0.f, "reportAstEnd success");
    L18:
        return Unit.INSTANCE;
    L15:
        if ((r15 instanceof dm9.a.a) == false) goto L20;
        n1.b(this.this$0.f, "reportAstEnd failed: " + r15.b);
        goto L18
    L20:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        String r16 = ((n4) this.this$0.getContext()).params().o.h;
        String r2 = ((n4) this.this$0.getContext()).params().o.c;
        long r5 = 1000;
        long r3 = ((n4) this.this$0.getContext()).params().n.j / r5;
        long r7 = System.currentTimeMillis() / r5;
        ca8.a r6 = new ca8.a(Boxing.boxLong(r3), Boxing.boxLong(r7));
        n1.d(this.this$0.f, "start time is " + r3 + ", end time is " + r7);
        ca8.b r4 = new ca8.b(r16, r2, Boxing.boxInt(1), r6);
        SimultaneousInterpretEndReportApi.a r17 = SimultaneousInterpretEndReportApi.a;
        SimultaneousInterpretPlugin$reportAstEnd$1$result$1 r8 = new SimultaneousInterpretPlugin$reportAstEnd$1$result$1(r4, null);
        this.label = 1;
        r17.getClass();
        FlowHttpConnection r18 = FlowHttpConnection.a;
        r14 = FlowHttpConnection.g("Audio", SimultaneousInterpretEndReportApi.class, r8, false, null, null, null, this, 248);
        if (r14 != r0) goto L11;
        return r0;
    }
}
