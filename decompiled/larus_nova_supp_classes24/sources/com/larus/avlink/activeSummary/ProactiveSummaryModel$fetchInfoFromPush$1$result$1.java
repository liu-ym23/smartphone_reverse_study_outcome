package com.larus.avlink.activeSummary;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/activeSummary/ProactiveSummaryInfoResponse;", "Lcom/larus/avlink/activeSummary/ProactiveSummaryApi;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.activeSummary.ProactiveSummaryModel$fetchInfoFromPush$1$result$1", f = "ProactiveSummaryModel.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
public final class ProactiveSummaryModel$fetchInfoFromPush$1$result$1 extends SuspendLambda implements Function2<ProactiveSummaryApi, Continuation<? super BizResponse<f>>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $title;
    private /* synthetic */ Object L$0;
    int label;

    public ProactiveSummaryModel$fetchInfoFromPush$1$result$1(String r1, String r2, Continuation<? super ProactiveSummaryModel$fetchInfoFromPush$1$result$1> r3) {
        this.$title = r1;
        this.$content = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ProactiveSummaryModel$fetchInfoFromPush$1$result$1 r0 = new ProactiveSummaryModel$fetchInfoFromPush$1$result$1(this.$title, this.$content, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(ProactiveSummaryApi r1, Continuation<? super BizResponse<f>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ProactiveSummaryApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        ProactiveSummaryApi r8 = (ProactiveSummaryApi) this.L$0;
        c r2 = new c(null, new o(this.$title, this.$content), null, 5);
        this.label = 1;
        r7 = r8.createActiveSummaryInfoRequest(r2, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
