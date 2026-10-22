package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession$scheduleExternalBidpCallbackTimeout$1", f = "FlowMfaFlowRegistry.kt", i = {}, l = {858}, m = "invokeSuspend", n = {}, s = {})
final class FlowMfaFlowSession$scheduleExternalBidpCallbackTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $status;
    int label;
    final /* synthetic */ FlowMfaFlowSession this$0;

    public FlowMfaFlowSession$scheduleExternalBidpCallbackTimeout$1(FlowMfaFlowSession r1, a r2, Continuation<? super FlowMfaFlowSession$scheduleExternalBidpCallbackTimeout$1> r3) {
        this.this$0 = r1;
        this.$status = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowMfaFlowSession$scheduleExternalBidpCallbackTimeout$1(this.this$0, this.$status, r4);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        a r8 = this.this$0.v.get();
        if (r8.b != this.$status.b) goto L29;
        if (r8.a != ExternalBidpCallbackPhase.RESUMED_WAITING_CALLBACK) goto L29;
        a r3 = a.a(r8, ExternalBidpCallbackPhase.TIMED_OUT);
        AtomicReference<a> r4 = this.this$0.v;
    L18:
        if (r4.compareAndSet(r8, r3) == true) goto L23;
        if (r4.get() == r8) goto L18;
        r2 = false;
    L23:
        if (r2 == false) goto L25;
        PassportLog.b("FlowMfaSession", "wait external BIDP callback timed out: attempt=" + r8.b);
        this.this$0.i(g.b("External browser IdP callback timed out", null));
        return Unit.INSTANCE;
    L25:
        return Unit.INSTANCE;
    L29:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        this.label = 1;
        if (DelayKt.delay(5000, this) != r0) goto L11;
        return r0;
    }
}
