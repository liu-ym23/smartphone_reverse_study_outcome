package com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UserType;
import com.larus.platform.service.o;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.DocApplyPermissionSceneHandler$onShow$1", f = "DocApplyPermissionSceneHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DocApplyPermissionSceneHandler$onShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a $vmData;
    int label;
    final /* synthetic */ DocApplyPermissionSceneHandler this$0;

    public DocApplyPermissionSceneHandler$onShow$1(DocApplyPermissionSceneHandler r1, com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r2, Continuation<? super DocApplyPermissionSceneHandler$onShow$1> r3) {
        this.this$0 = r1;
        this.$vmData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocApplyPermissionSceneHandler$onShow$1(this.this$0, this.$vmData, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r9);
        String r10 = DocApplyPermissionSceneHandler.i(this.this$0, this.$vmData.i);
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r2 = this.$vmData;
        DocApplyPermissionSceneHandler r3 = this.this$0;
        r1.put("current_page", "chat");
        Message r4 = r2.i;
        String r5 = null;
        if (r4 == null) goto L7;
        String r6 = r4.getConversationId();
    L8:
        String r7 = "";
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r1.put(MusicAppletPage.KEY_CONVERSATION_ID, r6);
        r1.put("chat_type", r10);
        Message r11 = r2.i;
        if (r11 == null) goto L16;
        r3.getClass();
        if (r11.getUserType() != UserType.AIBOT.value) goto L16;
        String r12 = r11.getSenderId();
    L17:
        r1.put("bot_id", r12);
        Message r13 = r2.i;
        if (r13 == null) goto L20;
        r5 = r13.getMessageId();
    L20:
        if (r5 != null) goto L22;
        r5 = "";
    L22:
        r1.put(MusicAppletPage.KEY_MESSAGE_ID, r5);
        String r14 = r2.j;
        if (r14 == null) goto L26;
        r7 = r14;
    L26:
        r1.put("previous_page", r7);
        Unit r15 = Unit.INSTANCE;
        r0.reportEvent("msg_doc_apply_permission_entry_show", r1);
        return Unit.INSTANCE;
    L16:
        r12 = null;
        goto L17
    L7:
        r6 = null;
        goto L8
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
