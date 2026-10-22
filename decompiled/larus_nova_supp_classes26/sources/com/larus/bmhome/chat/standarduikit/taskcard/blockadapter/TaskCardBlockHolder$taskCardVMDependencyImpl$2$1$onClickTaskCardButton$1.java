package com.larus.bmhome.chat.standarduikit.taskcard.blockadapter;

import android.content.Context;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.chat.standarduikit.taskcard.view.GeneralTaskSource;
import com.larus.bmhome.chat.standarduikit.taskcard.view.TaskCardBtnAction;
import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.block.TaskCardBlock;
import java.util.Map;
import java.util.UUID;
import kc8.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.taskcard.blockadapter.TaskCardBlockHolder$taskCardVMDependencyImpl$2$1$onClickTaskCardButton$1", f = "TaskCardBlockHolder.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
public final class TaskCardBlockHolder$taskCardVMDependencyImpl$2$1$onClickTaskCardButton$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Message $msg;
    final /* synthetic */ vn8.a $vmData;
    int label;
    final /* synthetic */ TaskCardBlockHolder this$0;

    public TaskCardBlockHolder$taskCardVMDependencyImpl$2$1$onClickTaskCardButton$1(Message r1, Context r2, TaskCardBlockHolder r3, vn8.a r4, Continuation<? super TaskCardBlockHolder$taskCardVMDependencyImpl$2$1$onClickTaskCardButton$1> r5) {
        this.$msg = r1;
        this.$context = r2;
        this.this$0 = r3;
        this.$vmData = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new TaskCardBlockHolder$taskCardVMDependencyImpl$2$1$onClickTaskCardButton$1(this.$msg, this.$context, this.this$0, this.$vmData, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        Object r3 = r20;
    L11:
        ReferenceMessage r4 = (ReferenceMessage) r3;
        u1 r5 = zh8.a.a.getSender();
        String r6 = this.$context.getString(2131910378);
        String r7 = this.$msg.getConversationId();
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        String r8 = r7;
        String r10 = UUID.randomUUID().toString();
        ReferenceInfo r12 = r4.getReferenceInfo();
        JSONObject r9 = new JSONObject();
        vn8.a r11 = this.$vmData;
        r9.put("action", TaskCardBtnAction.DIRECT_ANSWER.getValue());
        TaskCardBlock r13 = r11.d;
        if (r13 == null) goto L17;
        String r14 = r13.threadId;
    L18:
        r9.put("thread_id", r14);
        r9.put("source_type", GeneralTaskSource.MAIN_CONVERSATION.getValue());
        Map r15 = MapsKt.mapOf(TuplesKt.to("general_task_param", r9.toString()));
        kc8.b r16 = this.this$0.d;
        if (r16 == null) goto L25;
        y r17 = r16.a;
        if (r17 == null) goto L25;
        Function0 r18 = r17.n;
        if (r18 == null) goto L25;
        ChatPageContext r19 = (ChatPageContext) r18.invoke();
    L26:
        u1.a.f(r5, r6, r8, "task_card", r15, null, null, r10, false, r12, "TaskCardBlockButton", null, r19, null, false, 26984);
        return Unit.INSTANCE;
    L25:
        r19 = null;
        goto L26
    L17:
        r14 = null;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        ReferenceMessage.Companion r21 = ReferenceMessage.Companion;
        Message r22 = this.$msg;
        Map<String, String> r23 = MapsKt.mapOf(TuplesKt.to("ref_icon_key", "task"));
        this.label = 1;
        r3 = r21.b(r22, r23, this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
