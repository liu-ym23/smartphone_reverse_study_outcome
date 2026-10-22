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
@DebugMetadata(c = "com.larus.avlink.activeSummary.ProactiveSummaryModel$fetchInfoFromPush$1", f = "ProactiveSummaryModel.kt", i = {0}, l = {157}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class ProactiveSummaryModel$fetchInfoFromPush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $title;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProactiveSummaryModel this$0;

    public ProactiveSummaryModel$fetchInfoFromPush$1(String r1, String r2, ProactiveSummaryModel r3, Continuation<? super ProactiveSummaryModel$fetchInfoFromPush$1> r4) {
        this.$title = r1;
        this.$content = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ProactiveSummaryModel$fetchInfoFromPush$1 r0 = new ProactiveSummaryModel$fetchInfoFromPush$1(this.$title, this.$content, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);
    L11:
        dm9.a.b r16 = (dm9.a) r15;
        if ((r16 instanceof dm9.a.b) == false) goto L33;
        f r17 = (f) r16.a.getData();
        if (r17 == null) goto L31;
        ProactiveSummaryModel r3 = this.this$0;
        Integer r4 = r17.e;
        int r5 = ProactiveMethods.Frontier.getValue();
        if (r4 != null) goto L19;
    L22:
        k<f> r6 = n.a;
        String r7 = r17.a;
        String r8 = String.valueOf(r17.b);
        String r9 = r17.c;
        ProactiveSummarySource r10 = ProactiveSummarySource.PUSH;
        n.f(r7, r8, r9, r10, "success", r17.b(), r17.d(), r17.m, r17.c());
        if (ProactiveSummaryModel.b(r3, r17, r10) == false) goto L27;
        return Unit.INSTANCE;
    L27:
        if (n.c() == false) goto L30;
        n1.d("ProactiveSummaryRecords", "Abandon this proactive summary due to current is not disturb mode or audio through phone speaker. summaryId is " + r17.a + ", scene is " + r17.b);
        n.h(r17.a, String.valueOf(r17.b), r17.c, r10.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.ON_NOT_DISTURB, r17.b());
        return Unit.INSTANCE;
    L30:
        ProactiveSummaryModel.a(r3, r17, r10);
    L36:
        return Unit.INSTANCE;
    L19:
        if (r4.intValue() != r5) goto L22;
        n1.d("ProactiveSummaryRecords", "Abandon this proactive push summary because it is only used for reminders. summaryId is " + r17.a + ", scene is " + r17.b);
        return Unit.INSTANCE;
    L31:
        n1.d("ProactiveSummaryRecords", "Abandon this push because not proactive summary push, title is " + this.$title + ", content is " + this.$content);
        goto L36
    L33:
        if ((r16 instanceof dm9.a.a) == false) goto L36;
        n1.d("ProactiveSummaryRecords", "Abandon this proactive summary due summary request is failed in " + ((dm9.a.a) r16).b + ", title is " + this.$title + ", content is " + this.$content);
        k<f> r19 = n.a;
        ProactiveSummarySource r110 = ProactiveSummarySource.PUSH;
        n.g(null, r110, 487);
        n.i(null, null, null, r110.getValue(), ProactiveSummaryStartVuiStatus.FAIL, FailReason.SUMMARY_REQUEST_FAIL, null, 71);
        goto L36
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        ProactiveSummaryApi.a r11 = ProactiveSummaryApi.a;
        ProactiveSummaryModel$fetchInfoFromPush$1$result$1 r12 = new ProactiveSummaryModel$fetchInfoFromPush$1$result$1(this.$title, this.$content, null);
        this.L$0 = r111;
        this.label = 1;
        r11.getClass();
        FlowHttpConnection r112 = FlowHttpConnection.a;
        r15 = FlowHttpConnection.g("Audio", ProactiveSummaryApi.class, r12, false, null, null, null, this, 248);
        if (r15 != r0) goto L11;
        return r0;
    }
}
