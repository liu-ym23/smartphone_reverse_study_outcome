package com.ss.android.lark.flow.chat.message.system;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.lark.pb.basic.v1.SendLarkCommandPayloadRequest;
import com.bytedance.lark.pb.basic.v1.SendLarkCommandPayloadResponse;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.system.FlowExecuteActionSystemActionHandler$onActionClickNew$1", f = "FlowExecuteActionSystemActionHandler.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
final class FlowExecuteActionSystemActionHandler$onActionClickNew$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.biz.im.api.extension.message.system.a $actionContext;
    final /* synthetic */ com.ss.android.lark.chat.export.entity.message.content.d $locationAction;
    int label;
    final /* synthetic */ FlowExecuteActionSystemActionHandler this$0;

    public FlowExecuteActionSystemActionHandler$onActionClickNew$1(com.ss.android.lark.chat.export.entity.message.content.d r1, FlowExecuteActionSystemActionHandler r2, com.ss.android.lark.biz.im.api.extension.message.system.a r3, Continuation<? super FlowExecuteActionSystemActionHandler$onActionClickNew$1> r4) {
        this.$locationAction = r1;
        this.this$0 = r2;
        this.$actionContext = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowExecuteActionSystemActionHandler$onActionClickNew$1(this.$locationAction, this.this$0, this.$actionContext, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        com.larksuite.rucket.job.base.b.b r5 = (com.larksuite.rucket.job.base.b) r4;
        if ((r5 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L26;
        ErrorResult r6 = r5.a();
        if (r6 == null) goto L17;
        String r7 = r6.getDisplayMsg();
        if (r7 == null) goto L17;
    L18:
        com.ss.android.lark.biz.im.api.extension.message.system.a r3 = this.$actionContext;
        if (r7.length() == 0) goto L22;
        r2 = false;
    L22:
        if (r2 == false) goto L24;
        r7 = UIUtils.getString(r3.context(), 2131891714);
    L24:
        FragmentActivity r8 = this.$actionContext.context();
        Intrinsics.checkNotNull(r7);
        UDToast.show(r8, r7);
    L17:
        r7 = "";
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        SendLarkCommandPayloadRequest r9 = new SendLarkCommandPayloadRequest.Builder().cmd(Boxing.boxInt(this.$locationAction.c)).payload(this.$locationAction.d).build();
        FlowExecuteActionSystemActionHandler.a r10 = (FlowExecuteActionSystemActionHandler.a) this.this$0.c.getValue();
        Intrinsics.checkNotNull(r9);
        RucketJob<SendLarkCommandPayloadResponse> r11 = r10.executeRequestActionNew(r9);
        this.label = 1;
        r4 = r11.awaitGet(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
