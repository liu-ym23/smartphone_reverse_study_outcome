package com.ss.android.lark.passport.flow.verify.viewmodel;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession;
import com.ss.android.lark.passport.flow.mfa.j;
import com.ss.android.lark.passport.flow.mfa.y;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaFlowUiResult;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaFlowSession;", "factorData", "Lcom/ss/android/lark/passport/flow/mfa/FlowVerifyFactorData;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyFlowMfaBridge$submitFactor$2", f = "VerifyFlowMfaBridge.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
final class VerifyFlowMfaBridge$submitFactor$2 extends SuspendLambda implements Function3<FlowMfaFlowSession, y, Continuation<? super j>, Object> {
    final /* synthetic */ String $value;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public VerifyFlowMfaBridge$submitFactor$2(String r1, Continuation<? super VerifyFlowMfaBridge$submitFactor$2> r2) {
        this.$value = r1;
        super(3, r2);
    }

    public final Object invoke(FlowMfaFlowSession r3, y r4, Continuation<? super j> r5) {
        VerifyFlowMfaBridge$submitFactor$2 r0 = new VerifyFlowMfaBridge$submitFactor$2(this.$value, r5);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((FlowMfaFlowSession) r1, (y) r2, (Continuation) r3);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FlowMfaFlowSession r7 = (FlowMfaFlowSession) this.L$0;
        y r2 = (y) this.L$1;
        String r3 = this.$value;
        this.L$0 = null;
        this.label = 1;
        r6 = r7.B(r2, r3, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
