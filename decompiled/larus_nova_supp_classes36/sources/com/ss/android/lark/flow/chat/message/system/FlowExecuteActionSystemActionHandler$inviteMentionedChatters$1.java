package com.ss.android.lark.flow.chat.message.system;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.compat.CallbackCompatRucketJob;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.system.FlowExecuteActionSystemActionHandler$inviteMentionedChatters$1", f = "FlowExecuteActionSystemActionHandler.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
final class FlowExecuteActionSystemActionHandler$inviteMentionedChatters$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ List<String> $chatterIds;
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ FlowExecuteActionSystemActionHandler this$0;

    public FlowExecuteActionSystemActionHandler$inviteMentionedChatters$1(Context r1, FlowExecuteActionSystemActionHandler r2, String r3, List<String> r4, Continuation<? super FlowExecuteActionSystemActionHandler$inviteMentionedChatters$1> r5) {
        this.$context = r1;
        this.this$0 = r2;
        this.$chatId = r3;
        this.$chatterIds = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new FlowExecuteActionSystemActionHandler$inviteMentionedChatters$1(this.$context, this.this$0, this.$chatId, this.$chatterIds, r8);
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
        com.larksuite.rucket.job.base.b.b r14 = (com.larksuite.rucket.job.base.b) r13;
        if ((r14 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L19;
        StringBuilder r2 = new StringBuilder("click action: invite mentioned chatters failed, error=");
        ErrorResult r15 = r14.a();
        if (r15 == null) goto L16;
        String r16 = r15.getDisplayMsg();
    L17:
        r2.append(r16);
        Log.e("System_ActionHandler", r2.toString());
        return Unit.INSTANCE;
    L16:
        r16 = null;
        goto L17
    L19:
        Map r17 = (Map) r14.b();
        if (r17 != null) goto L22;
    L25:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        UDToast.show(this.$context, 2131890792);
        return Unit.INSTANCE;
    L30:
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r18 = r17.entrySet().iterator();
    L32:
        if (r18.hasNext() == false) goto L36;
        Map.Entry r5 = (Map.Entry) r18.next();
        if ((!((Boolean) r5.getValue()).booleanValue()) == false) goto L32;
        r4.put(r5.getKey(), r5.getValue());
        goto L32
    L36:
        ArrayList r9 = new ArrayList(r4.size());
        Iterator r19 = r4.entrySet().iterator();
    L38:
        if (r19.hasNext() == false) goto L41;
        r9.add((String) ((Map.Entry) r19.next()).getKey());
        goto L38
    L41:
        if (r9.isEmpty() == false) goto L44;
        UDToast.show(this.$context, 2131890792);
        return Unit.INSTANCE;
    L44:
        FlowExecuteActionSystemActionHandler r10 = this.this$0;
        BuildersKt.launch$default(r10.b, null, null, new FlowExecuteActionSystemActionHandler$addGroupChatMember$1(this.$context, r10.a, this.$chatId, r9, r10, null), 3, null);
        return Unit.INSTANCE;
    L22:
        if (r17.isEmpty() == true) goto L25;
        r3 = false;
        goto L27
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        final List<String> r6 = this.$chatterIds;
        final String r7 = this.$chatId;
        CallbackCompatRucketJob r110 = com.larksuite.rucket.job.compat.f.a(new FlowExecuteActionSystemActionHandler$inviteMentionedChatters$1$response$1(r6, r7));
        this.label = 1;
        r13 = r110.awaitGet(this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
