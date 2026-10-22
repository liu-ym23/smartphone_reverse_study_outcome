package com.larus.bmhome.chat.list.cell.test;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import com.larus.im.bean.message.MsgFeedbackType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.test.CrowdTestTask$process$2", f = "CrowdTestTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CrowdTestTask$process$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $current;
    final /* synthetic */ int $selectedGroupIndex;
    int label;
    final /* synthetic */ CrowdTestTask this$0;

    public CrowdTestTask$process$2(b r1, CrowdTestTask r2, int r3, Continuation<? super CrowdTestTask$process$2> r4) {
        this.$current = r1;
        this.this$0 = r2;
        this.$selectedGroupIndex = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CrowdTestTask$process$2(this.$current, this.this$0, this.$selectedGroupIndex, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r29) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r29);
        String r1 = this.$current.getMessage().getMessageId();
        CrowdTestTask r2 = this.this$0;
        int r3 = this.$selectedGroupIndex;
        String r4 = "";
        if (r1 != null) goto L7;
        String r7 = "";
    L8:
        int r5 = CrowdTestTask.c;
        r2.getClass();
        MsgFeedbackType r6 = MsgFeedbackType.MsgFeedbackTypeBetter;
        JSONObject r8 = new JSONObject();
        r8.put("crowd_test_message_group_selected", r3);
        Unit r9 = Unit.INSTANCE;
        String r10 = r8.toString();
        if ((1 & 4025) != 0) goto L13;
        r4 = null;
    L13:
        if ((4025 & 4) == 0) goto L15;
        r6 = MsgFeedbackType.MsgFeedbackTypeDefault;
    L15:
        MsgFeedbackType r11 = r6;
        if ((4025 & 64) == 0) goto L18;
        Integer r12 = 0;
    L20:
        if ((4025 & 4096) == 0) goto L22;
        String r18 = null;
    L23:
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r7, "messageId");
        Intrinsics.checkNotNullParameter(r11, "feedbackType");
        FlowFeedbackServiceDelegate r15 = FlowFeedbackServiceDelegate.a;
        List r13 = CollectionsKt.listOf(0);
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r7, "messageId");
        Intrinsics.checkNotNullParameter(r11, "feedbackType");
        r15.g(new q99.m(new yc9.m(r4, r7, r11, 0, r13, null, r12, null, null, null, null, false, r18), null, null, null, null, null, null, 126), new a0());
        return Unit.INSTANCE;
    L22:
        r18 = r10;
        goto L23
    L18:
        r12 = 1;
        goto L20
    L7:
        r7 = r1;
        goto L8
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
