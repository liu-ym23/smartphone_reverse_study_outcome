package com.ss.android.lark.flow.chat.message.system;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.lark.pb.basic.v1.Content;
import com.bytedance.lark.pb.im.v1.GetMessageActionPayloadRequest;
import com.bytedance.lark.pb.im.v1.GetMessageActionPayloadResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageAction;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import w4b.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.system.FlowExecuteActionSystemActionHandler$onActionClick$1", f = "FlowExecuteActionSystemActionHandler.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
final class FlowExecuteActionSystemActionHandler$onActionClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.biz.im.api.extension.message.system.a $actionContext;
    final /* synthetic */ SystemMessageAction.ActType $actionType;
    final /* synthetic */ SystemContent $systemContent;
    int label;
    final /* synthetic */ FlowExecuteActionSystemActionHandler this$0;

    public FlowExecuteActionSystemActionHandler$onActionClick$1(com.ss.android.lark.biz.im.api.extension.message.system.a r1, SystemMessageAction.ActType r2, FlowExecuteActionSystemActionHandler r3, SystemContent r4, Continuation<? super FlowExecuteActionSystemActionHandler$onActionClick$1> r5) {
        this.$actionContext = r1;
        this.$actionType = r2;
        this.this$0 = r3;
        this.$systemContent = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new FlowExecuteActionSystemActionHandler$onActionClick$1(this.$actionContext, this.$actionType, this.this$0, this.$systemContent, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        com.larksuite.rucket.job.base.b.c r6 = (com.larksuite.rucket.job.base.b) r5;
        boolean r2 = r6 instanceof com.larksuite.rucket.job.base.b.c;
        if (r2 == true) goto L14;
    L16:
        if (r2 == false) goto L21;
        if (this.$actionType != SystemMessageAction.ActType.URL) goto L21;
        v r3 = ChatCoreModule.a().getMainDependency();
        this.$actionContext.context();
        String r7 = ((GetMessageActionPayloadResponse) r6.b).url;
        r3.a();
    L28:
        return Unit.INSTANCE;
    L21:
        if ((r6 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L28;
        StringBuilder r4 = new StringBuilder("click action failed, type=");
        r4.append(this.$systemContent.getType());
        r4.append(", actionType=");
        r4.append(this.$actionType);
        r4.append(", error=");
        ErrorResult r8 = ((com.larksuite.rucket.job.base.b.b) r6).a();
        if (r8 == null) goto L25;
        String r9 = r8.getDebugMsg();
    L26:
        r4.append(r9);
        Log.e("System_ActionHandler", r4.toString());
        goto L28
    L25:
        r9 = null;
        goto L26
    L14:
        if (this.$actionType != SystemMessageAction.ActType.INVITE_AT_CHATTERS) goto L16;
        FlowExecuteActionSystemActionHandler r10 = this.this$0;
        FragmentActivity r11 = this.$actionContext.context();
        com.ss.android.lark.biz.im.api.extension.message.system.a r12 = this.$actionContext;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        String r13 = r12.message().getChatId();
        List r14 = ((GetMessageActionPayloadResponse) r6.b).at_chatter_ids;
        int r15 = FlowExecuteActionSystemActionHandler.d;
        r10.c(r11, r13, r14);
        goto L28
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        GetMessageActionPayloadRequest.Builder r16 = new GetMessageActionPayloadRequest.Builder();
        com.ss.android.lark.biz.im.api.extension.message.system.a r17 = this.$actionContext;
        Intrinsics.checkNotNullParameter(r17, "<this>");
        GetMessageActionPayloadRequest.Builder r18 = r16.message_id(r17.message().getId()).action_type(Content.SystemMessageAction.ActType.fromValue(this.$actionType.getValue()));
        RucketJob<GetMessageActionPayloadResponse> r19 = ((FlowExecuteActionSystemActionHandler.a) this.this$0.c.getValue()).executeRequestAction(r18.build());
        this.label = 1;
        r5 = r19.awaitGet(this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
