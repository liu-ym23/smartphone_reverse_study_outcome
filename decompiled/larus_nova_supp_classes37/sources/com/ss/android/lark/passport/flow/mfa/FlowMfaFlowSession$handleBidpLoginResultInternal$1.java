package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.passport.PassportApmEvent;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession$handleBidpLoginResultInternal$1", f = "FlowMfaFlowRegistry.kt", i = {0, 0, 1, 1}, l = {781, 788}, m = "invokeSuspend", n = {"reportInfo", "startTime", "reportInfo", "startTime"}, s = {"L$0", "J$0", "L$0", "J$0"})
public final class FlowMfaFlowSession$handleBidpLoginResultInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $source;
    final /* synthetic */ String $state;
    final /* synthetic */ String $verifier;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FlowMfaFlowSession this$0;

    public FlowMfaFlowSession$handleBidpLoginResultInternal$1(FlowMfaFlowSession r1, String r2, String r3, String r4, Continuation<? super FlowMfaFlowSession$handleBidpLoginResultInternal$1> r5) {
        this.this$0 = r1;
        this.$source = r2;
        this.$state = r3;
        this.$verifier = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        FlowMfaFlowSession$handleBidpLoginResultInternal$1 r6 = new FlowMfaFlowSession$handleBidpLoginResultInternal$1(this.this$0, this.$source, this.$state, this.$verifier, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        final long r2 = this.J$0;
        String r3 = (String) this.L$2;
        FlowMfaFlowSession r5 = (FlowMfaFlowSession) this.L$1;
        z r6 = (z) this.L$0;
        ResultKt.throwOnFailure(r14);
        final z r7 = r6;
    L26:
        j r15 = (j) r14;
        boolean r8 = r15 instanceof j.c;
        final boolean r9 = !r8;
        List<String> r10 = FlowMfaFlowSession.x;
        r5.getClass();
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportBidpDispatchResult$1(r7, r9, r2));
        if (r8 == false) goto L29;
        StringBuilder r4 = new StringBuilder("dispatch BIDP login result failed: source=");
        r4.append(r3);
        r4.append(", category=");
        j.c r11 = (j.c) r15;
        r4.append(r11.a.getCategory());
        r4.append(", serverCode=");
        r4.append(r11.a.getServerCode());
        PassportLog.b("FlowMfaSession", r4.toString());
        r5.w(r11.a);
    L31:
        this.this$0.r(r15);
        return Unit.INSTANCE;
    L29:
        PassportLog.d("FlowMfaSession", "dispatch BIDP login result success: source=" + r3 + ", result=" + r15.getClass().getSimpleName());
        goto L31
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        final long r12 = this.J$0;
        z r13 = (z) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L18
        r1 = r13;
    L16:
        Object r16 = Result.constructor-impl((FlowStep) r14);     // Catch: Throwable -> L18
        final z r17 = r1;
    L20:
        FlowMfaFlowSession r18 = this.this$0;
        String r19 = this.$source;
        Throwable r110 = Result.exceptionOrNull-impl(r16);
        if (r110 != null) goto L30;
        this.L$0 = r17;
        this.L$1 = r18;
        this.L$2 = r19;
        this.J$0 = r12;
        this.label = 2;
        r14 = r18.o((FlowStep) r16);
        if (r14 != r0) goto L25;
        return r0;
    L25:
        r5 = r18;
        r3 = r19;
        long r111 = r12;
        r7 = r17;
        r2 = r111;
        goto L26
    L30:
        PassportLog.b("FlowMfaSession", "dispatch BIDP login result failed: source=" + r19 + ", error=" + r110.getClass().getSimpleName());
        List<String> r112 = FlowMfaFlowSession.x;
        r18.getClass();
        FlowMfaError r113 = FlowMfaFlowSession.C(r110);
        final boolean r20 = false;
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportBidpDispatchResult$1(r17, r20, r12));
        r18.h(r113);
        r15 = new j.c(r113, true);
        goto L31
    L12:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r114 = (CoroutineScope) this.L$0;
        FlowMfaFlowSession r115 = this.this$0;
        List<String> r21 = FlowMfaFlowSession.x;
        final z r22 = r115.f();
        r12 = System.currentTimeMillis();
        PassportLog.d("FlowMfaSession", "dispatch BIDP login result start: source=" + this.$source);
        this.this$0.getClass();
        PassportApmEvent.a.q(new FlowMfaFlowSession$reportBidpDispatchStart$1(r22));
        FlowMfaFlowSession r116 = this.this$0;
        String r23 = this.$state;
        String r24 = this.$verifier;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L18
        FlowMfaRepository r118 = r116.d;     // Catch: Throwable -> L18
        String r119 = r116.b;     // Catch: Throwable -> L18
        this.L$0 = r22;     // Catch: Throwable -> L18
        this.J$0 = r12;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        r14 = r118.e(r119, r23, r24, this);     // Catch: Throwable -> L18
        r1 = r22;
        if (r14 != r0) goto L16;
        return r0;
    L18:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        r17 = r1;
        goto L20
    }
}
