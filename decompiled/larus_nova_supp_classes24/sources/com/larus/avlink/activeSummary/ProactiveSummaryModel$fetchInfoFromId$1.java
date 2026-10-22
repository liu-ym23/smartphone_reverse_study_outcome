package com.larus.avlink.activeSummary;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.avlink.n1;
import com.larus.network.FlowHttpConnection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.activeSummary.ProactiveSummaryModel$fetchInfoFromId$1", f = "ProactiveSummaryModel.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
public final class ProactiveSummaryModel$fetchInfoFromId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProactiveSummarySource $source;
    final /* synthetic */ String $summaryId;
    int label;
    final /* synthetic */ ProactiveSummaryModel this$0;

    public ProactiveSummaryModel$fetchInfoFromId$1(String r1, ProactiveSummarySource r2, ProactiveSummaryModel r3, Continuation<? super ProactiveSummaryModel$fetchInfoFromId$1> r4) {
        this.$summaryId = r1;
        this.$source = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ProactiveSummaryModel$fetchInfoFromId$1(this.$summaryId, this.$source, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        dm9.a.b r14 = (dm9.a) r13;
        if ((r14 instanceof dm9.a.b) == false) goto L25;
        f r15 = (f) r14.a.getData();
        if (r15 == null) goto L28;
        ProactiveSummarySource r2 = this.$source;
        ProactiveSummaryModel r11 = this.this$0;
        k<f> r3 = n.a;
        n.f(r15.a, String.valueOf(r15.b), r15.c, r2, "success", r15.b(), r15.d(), r15.m, r15.c());
        if (ProactiveSummaryModel.b(r11, r15, r2) == false) goto L20;
        return Unit.INSTANCE;
    L20:
        if (n.c() == false) goto L23;
        n1.d("ProactiveSummaryRecords", "Abandon this proactive summary due to current is not disturb mode or audio through phone speaker. summaryId is " + r15.a + ", scene is " + r15.b);
        n.h(r15.a, String.valueOf(r15.b), r15.c, r2.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.ON_NOT_DISTURB, r15.b());
        return Unit.INSTANCE;
    L23:
        ProactiveSummaryModel.a(r11, r15, r2);
    L28:
        return Unit.INSTANCE;
    L25:
        if ((r14 instanceof dm9.a.a) == false) goto L28;
        n1.d("ProactiveSummaryRecords", "Abandon this proactive summary due summary request is failed in " + ((dm9.a.a) r14).b + ". summaryId is " + this.$summaryId);
        k<f> r16 = n.a;
        n.g(this.$summaryId, this.$source, 486);
        n.i(this.$summaryId, null, null, this.$source.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.SUMMARY_REQUEST_FAIL, null, 70);
        goto L28
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        ProactiveSummaryApi.a r17 = ProactiveSummaryApi.a;
        ProactiveSummaryModel$fetchInfoFromId$1$result$1 r5 = new ProactiveSummaryModel$fetchInfoFromId$1$result$1(this.$summaryId, null);
        this.label = 1;
        r17.getClass();
        FlowHttpConnection r19 = FlowHttpConnection.a;
        r13 = FlowHttpConnection.g("Audio", ProactiveSummaryApi.class, r5, false, null, null, null, this, 248);
        if (r13 != r0) goto L11;
        return r0;
    }
}
