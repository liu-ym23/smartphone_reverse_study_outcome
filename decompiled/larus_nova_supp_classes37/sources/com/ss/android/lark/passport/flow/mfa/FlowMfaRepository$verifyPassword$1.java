package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.mfa.FlowMfaRepository", f = "FlowMfaRepository.kt", i = {}, l = {125}, m = "verifyPassword", n = {}, s = {})
final class FlowMfaRepository$verifyPassword$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMfaRepository this$0;

    public FlowMfaRepository$verifyPassword$1(FlowMfaRepository r1, Continuation<? super FlowMfaRepository$verifyPassword$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        FlowMfaRepository r5 = this.this$0;
        r5.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        FlowMfaRepository$verifyPassword$1 r0 = this;
    L6:
        Object r2 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 != 0) goto L9;
        ResultKt.throwOnFailure(r2);
        throw null;
    L9:
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r2);
        com.ss.android.lark.passport.flow.core.network.f r6 = (com.ss.android.lark.passport.flow.core.network.f) r2;
        r6.c();
        return r5.j(r6);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r0 = new FlowMfaRepository$verifyPassword$1(r5, this);
        goto L6
    }
}
