package com.larus.doc.impl.crowdtest;

import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import q99.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.crowdtest.DocCrowdTestHelper$trySubmitCrowdTestSelectionOnDocCreate$1", f = "DocCrowdTestHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DocCrowdTestHelper$trySubmitCrowdTestSelectionOnDocCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    final /* synthetic */ int $selectedGroupIndex;
    int label;

    public DocCrowdTestHelper$trySubmitCrowdTestSelectionOnDocCreate$1(Message r1, int r2, Continuation<? super DocCrowdTestHelper$trySubmitCrowdTestSelectionOnDocCreate$1> r3) {
        this.$message = r1;
        this.$selectedGroupIndex = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocCrowdTestHelper$trySubmitCrowdTestSelectionOnDocCreate$1(this.$message, this.$selectedGroupIndex, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r27) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r27);
        int r1 = DocCrowdTestHelper.a;
        String r2 = com.larus.im.bean.message.a.D(this.$message);
        String r3 = "";
        if (r2 != null) goto L7;
        String r5 = "";
    L8:
        Integer r4 = Boxing.boxInt(this.$selectedGroupIndex);
        FLogger.a.i("DocCrowdTestHelper", "doCrowdTestUserSelection: messageId=" + r5 + ", selectedGroupIndex=" + r4);
        MsgFeedbackType r6 = MsgFeedbackType.MsgFeedbackTypeBetter;
        if (r4 == null) goto L11;
        int r7 = r4.intValue();
        JSONObject r8 = new JSONObject();
        r8.put("crowd_test_message_group_selected", r7);
        String r9 = r8.toString();
    L13:
        if ((4025 & 1) != 0) goto L17;
        r3 = null;
    L17:
        if ((4025 & 4) == 0) goto L19;
        r6 = MsgFeedbackType.MsgFeedbackTypeDefault;
    L19:
        MsgFeedbackType r10 = r6;
        if ((4025 & 64) == 0) goto L22;
        Integer r11 = 0;
    L24:
        if ((4025 & 4096) == 0) goto L26;
        String r16 = null;
    L27:
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "messageId");
        Intrinsics.checkNotNullParameter(r10, "feedbackType");
        FlowFeedbackServiceDelegate r13 = FlowFeedbackServiceDelegate.a;
        List r12 = CollectionsKt.listOf(0);
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "messageId");
        Intrinsics.checkNotNullParameter(r10, "feedbackType");
        r13.g(new m(new yc9.m(r3, r5, r10, 0, r12, null, r11, null, null, null, null, false, r16), null, null, null, null, null, null, 126), new a());
        return Unit.INSTANCE;
    L26:
        r16 = r9;
        goto L27
    L22:
        r11 = 0;
        goto L24
    L11:
        r9 = null;
        goto L13
    L7:
        r5 = r2;
        goto L8
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
