package com.larus.bmhome.chat.list.cell.test;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.test.CrowdTestSelectionCell$getReportTask$1$5", f = "CrowdTestSelectionCell.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CrowdTestSelectionCell$getReportTask$1$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MsgFeedbackType $feedbackType;
    final /* synthetic */ Integer $selectedGroupIndex;
    int label;
    final /* synthetic */ CrowdTestSelectionCell this$0;

    public CrowdTestSelectionCell$getReportTask$1$5(CrowdTestSelectionCell r1, Integer r2, MsgFeedbackType r3, Continuation<? super CrowdTestSelectionCell$getReportTask$1$5> r4) {
        this.this$0 = r1;
        this.$selectedGroupIndex = r2;
        this.$feedbackType = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CrowdTestSelectionCell$getReportTask$1$5(this.this$0, this.$selectedGroupIndex, this.$feedbackType, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r23);
        CrowdTestSelectionCell r1 = this.this$0;
        Integer r2 = this.$selectedGroupIndex;
        MsgFeedbackType r15 = this.$feedbackType;
        String r3 = r1.f;
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        String r5 = r3;
        if (r2 == null) goto L10;
        int r4 = r2.intValue();
        JSONObject r6 = new JSONObject();
        r6.put("crowd_test_message_group_selected", r4);
        String r7 = r6.toString();
    L11:
        yc9.m r14 = new yc9.m(null, r5, r15, 0, null, null, 0, null, null, null, null, false, r7, 4025);
        FLogger.a.i("CrowdTestSelectionCell", "doCrowdTestUserSelection: messageId=" + r1.f + ", feedbackType=" + r15 + ", selectedGroupIndex=" + r2);
        CrowdTestSelectionCell.o(r14, "CrowdTestSelectionCell");
        return Unit.INSTANCE;
    L10:
        r7 = null;
        goto L11
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
