package com.larus.avlink.activeSummary;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/avlink/activeSummary/ProactiveSummaryInfoResponse;", "Lcom/larus/avlink/activeSummary/ProactiveSummaryApi;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.activeSummary.ProactiveSummaryModel$fetchInfoFromId$1$result$1", f = "ProactiveSummaryModel.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
public final class ProactiveSummaryModel$fetchInfoFromId$1$result$1 extends SuspendLambda implements Function2<ProactiveSummaryApi, Continuation<? super BizResponse<f>>, Object> {
    final /* synthetic */ String $summaryId;
    private /* synthetic */ Object L$0;
    int label;

    public ProactiveSummaryModel$fetchInfoFromId$1$result$1(String r1, Continuation<? super ProactiveSummaryModel$fetchInfoFromId$1$result$1> r2) {
        this.$summaryId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ProactiveSummaryModel$fetchInfoFromId$1$result$1 r0 = new ProactiveSummaryModel$fetchInfoFromId$1$result$1(this.$summaryId, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(ProactiveSummaryApi r1, Continuation<? super BizResponse<f>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ProactiveSummaryApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        ProactiveSummaryApi r9 = (ProactiveSummaryApi) this.L$0;
        String r3 = this.$summaryId;
        FlowDoraSubBizType.Companion.getClass();
        c r2 = new c(r3, null, Boxing.boxInt(FlowDoraSubBizType.a.a()), 2);
        this.label = 1;
        r8 = r9.createActiveSummaryInfoRequest(r2, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
