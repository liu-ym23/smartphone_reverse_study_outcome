package com.larus.bmhome.chat.feedback;

import android.os.Bundle;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.feedback.TtsFeedbackDialogFragment$initButton$1$2$1", f = "TtsFeedbackDialogFragment.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
final class TtsFeedbackDialogFragment$initButton$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Integer> $list;
    int label;
    final /* synthetic */ TtsFeedbackDialogFragment this$0;

    public TtsFeedbackDialogFragment$initButton$1$2$1(TtsFeedbackDialogFragment r1, List<Integer> r2, Continuation<? super TtsFeedbackDialogFragment$initButton$1$2$1> r3) {
        this.this$0 = r1;
        this.$list = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TtsFeedbackDialogFragment$initButton$1$2$1(this.this$0, this.$list, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
    L32:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        TtsFeedbackDialogFragment r4 = this.this$0;
        List<Integer> r5 = this.$list;
        if (r4.f == false) goto L19;
        JSONObject r6 = new JSONObject();
        Bundle r7 = r4.g;
        if (r7 == null) goto L13;
        String r8 = r7.getString("call_id");
    L14:
        r6.put("call_id", r8);
        Bundle r1 = r4.g;
        if (r1 == null) goto L17;
        String r9 = r1.getString("task_id");
    L18:
        r6.put("task_id", r9);
        r6.put("feedback_type", 2);
        r6.put("feedback_status", 2);
        r6.put("feedback_item_code_list", new JSONArray(r5));
        r6.put("bot_id", r4.h);
    L28:
        this.label = 1;
        if (HttpExtKt.k("Audio", Object.class, "/alice/audio/voice_feedback", r6, null, null, false, null, null, null, this, 1008) != r13) goto L32;
        return r13;
    L17:
        r9 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L19:
        JSONObject r2 = new JSONObject();
        Bundle r10 = r4.g;
        if (r10 == null) goto L22;
        String r11 = r10.getString("message_id");
    L23:
        r2.put("message_id", r11);
        Bundle r12 = r4.g;
        if (r12 == null) goto L26;
        String r14 = r12.getString("task_id");
    L27:
        r2.put("task_id", r14);
        r2.put("feedback_type", 1);
        r2.put("feedback_status", 2);
        r2.put("feedback_item_code_list", new JSONArray(r5));
        r2.put("bot_id", r4.h);
        r6 = r2;
        goto L28
    L26:
        r14 = null;
        goto L27
    L22:
        r11 = null;
        goto L23
    }
}
