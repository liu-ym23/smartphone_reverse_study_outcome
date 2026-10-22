package com.larus.reach.impl;

import com.larus.network.bean.BizResponse;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/reach/impl/ReachActionResponse;", "Lcom/larus/reach/impl/ReachActionApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.reach.impl.ReachActionExecutor$sendRequest$result$1", f = "ReachActionExecutor.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
final class ReachActionExecutor$sendRequest$result$1 extends SuspendLambda implements Function2<ReachActionApi, Continuation<? super BizResponse<ReachActionResponse>>, Object> {
    final /* synthetic */ String $bizReqId;
    final /* synthetic */ String $bizReqPsm;
    final /* synthetic */ Map<String, String> $data;
    private /* synthetic */ Object L$0;
    int label;

    public ReachActionExecutor$sendRequest$result$1(String r1, String r2, Map<String, String> r3, Continuation<? super ReachActionExecutor$sendRequest$result$1> r4) {
        this.$bizReqPsm = r1;
        this.$bizReqId = r2;
        this.$data = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ReachActionExecutor$sendRequest$result$1 r0 = new ReachActionExecutor$sendRequest$result$1(this.$bizReqPsm, this.$bizReqId, this.$data, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(ReachActionApi r1, Continuation<? super BizResponse<ReachActionResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ReachActionApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L27:
        return r12;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        ReachActionApi r13 = (ReachActionApi) this.L$0;
        String r4 = this.$bizReqPsm;
        String r2 = this.$bizReqId;
        if (r4 != null) goto L11;
        boolean r3 = true;
    L13:
        if (r3 == true) goto L16;
        r2 = null;
    L16:
        Map<String, String> r5 = this.$data;
        if (r5 == null) goto L23;
        String r6 = r5.get("params");
        if (r6 == null) goto L23;
        if ((!StringsKt.isBlank(r6)) == false) goto L23;
        String r7 = r6;
    L24:
        ReachActionRequest r10 = new ReachActionRequest(r4, r2, 0, r7, 4, null);
        this.label = 1;
        r12 = r13.sendCommonRequest(r10, this);
        if (r12 != r0) goto L27;
        return r0;
    L23:
        r7 = null;
        goto L24
    L11:
        r3 = false;
        goto L13
    }
}
