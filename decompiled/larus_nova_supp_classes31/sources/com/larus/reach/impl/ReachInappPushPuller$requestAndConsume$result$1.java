package com.larus.reach.impl;

import com.larus.network.bean.BizResponse;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/reach/impl/GetInappPushData;", "Lcom/larus/reach/impl/ReachInappPushApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.reach.impl.ReachInappPushPuller$requestAndConsume$result$1", f = "ReachInappPushPuller.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
public final class ReachInappPushPuller$requestAndConsume$result$1 extends SuspendLambda implements Function2<ReachInappPushApi, Continuation<? super BizResponse<GetInappPushData>>, Object> {
    final /* synthetic */ String $launchSchema;
    final /* synthetic */ String $scene;
    private /* synthetic */ Object L$0;
    int label;

    public ReachInappPushPuller$requestAndConsume$result$1(String r1, String r2, Continuation<? super ReachInappPushPuller$requestAndConsume$result$1> r3) {
        this.$scene = r1;
        this.$launchSchema = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ReachInappPushPuller$requestAndConsume$result$1 r0 = new ReachInappPushPuller$requestAndConsume$result$1(this.$scene, this.$launchSchema, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(ReachInappPushApi r1, Continuation<? super BizResponse<GetInappPushData>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ReachInappPushApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L14:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ReachInappPushApi r7 = (ReachInappPushApi) this.L$0;
        String r3 = this.$scene;
        String r4 = this.$launchSchema;
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        GetInappPushRequest r2 = new GetInappPushRequest(r3, r4);
        this.label = 1;
        r6 = r7.getPushBanner(r2, this);
        if (r6 != r0) goto L14;
        return r0;
    }
}
