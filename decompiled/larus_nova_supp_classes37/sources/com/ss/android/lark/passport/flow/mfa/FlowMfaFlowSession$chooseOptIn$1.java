package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession", f = "FlowMfaFlowRegistry.kt", i = {}, l = {580, 586}, m = "chooseOptIn", n = {}, s = {})
final class FlowMfaFlowSession$chooseOptIn$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMfaFlowSession this$0;

    public FlowMfaFlowSession$chooseOptIn$1(FlowMfaFlowSession r1, Continuation<? super FlowMfaFlowSession$chooseOptIn$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        FlowMfaFlowSession r8 = this.this$0;
        r8.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        FlowMfaFlowSession$chooseOptIn$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L15;
        if (r4 == 1) goto L13;
        if (r4 != 2) goto L12;
        ResultKt.throwOnFailure(r2);
    L30:
        j r5 = (j) r2;
        if ((r5 instanceof j.c) == false) goto L39;
        r8.w(((j.c) r5).a);
        return r5;
    L39:
        return r5;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L23
    L21:
        Object r6 = Result.constructor-impl((FlowStep) r2);     // Catch: Throwable -> L23
    L25:
        Throwable r9 = Result.exceptionOrNull-impl(r6);
        if (r9 != null) goto L33;
        r0.label = 2;
        r2 = r8.o((FlowStep) r6);
        if (r2 != r3) goto L30;
        return r3;
    L33:
        PassportLog.e("FlowMfaSession", "choose MFA opt-in failed: ".concat(r9.getClass().getSimpleName()));
        FlowMfaError r10 = FlowMfaFlowSession.C(r9);
        r8.w(r10);
        return new j.c(r10, false);
    L15:
        ResultKt.throwOnFailure(r2);
        if (r8.q() == true) goto L37;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L23
        FlowMfaRepository r12 = r8.d;     // Catch: Throwable -> L23
        String r13 = r8.b;     // Catch: Throwable -> L23
        r0.label = 1;     // Catch: Throwable -> L23
        r2 = r12.d(r13, r0);     // Catch: Throwable -> L23
        if (r2 != r3) goto L21;
        return r3;
    L37:
        return j.b.a;
    L23:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L5:
        r0 = new FlowMfaFlowSession$chooseOptIn$1(r8, this);
        goto L6
    }
}
