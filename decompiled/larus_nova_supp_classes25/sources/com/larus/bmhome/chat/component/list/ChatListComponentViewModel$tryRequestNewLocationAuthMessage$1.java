package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.stop.PendingAppletActionCancellation;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import hq9.y2;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$tryRequestNewLocationAuthMessage$1", f = "ChatListComponentViewModel.kt", i = {}, l = {1094}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponentViewModel$tryRequestNewLocationAuthMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    int label;

    public ChatListComponentViewModel$tryRequestNewLocationAuthMessage$1(Message r1, Continuation<? super ChatListComponentViewModel$tryRequestNewLocationAuthMessage$1> r2) {
        this.$message = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatListComponentViewModel$tryRequestNewLocationAuthMessage$1(this.$message, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L15:
        Message r9 = (Message) r8;
        if (r9 != null) goto L20;
        return Unit.INSTANCE;
    L20:
        if (PendingAppletActionCancellation.a.c(this.$message, r9) == true) goto L22;
        com.larus.platform.service.l1 r2 = com.larus.platform.service.l1.a;
        String r3 = r9.getMessageId();
        String r4 = "";
        if (r3 != null) goto L26;
        r3 = "";
    L26:
        String r5 = r9.getLocalMessageId();
        if (r5 == null) goto L30;
        r4 = r5;
    L30:
        String r10 = r9.getConversationId();
        Map r6 = this.$message.getExt();
        if (r6 == null) goto L40;
        String r7 = (String) r6.get("fpa_common_param");
        if (r7 == null) goto L40;
        String r11 = new JSONObject(r7).optString("location_trace_info");     // Catch: JSONException -> L38
        Intrinsics.checkNotNull(r11);     // Catch: JSONException -> L38
        if ((true ^ StringsKt.isBlank(r11)) == false) goto L40;
        JSONObject r12 = new JSONObject(r11);     // Catch: JSONException -> L38
    L41:
        r2.b(new y2(r3, r4, r10, r12));
        return Unit.INSTANCE;
    L38:
        e = move-exception;
        FLogger.a.e("ChatListComponentViewModel", "messageNeedLocation ext plugin_scene error", e);
    L40:
        r12 = null;
        goto L41
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        PendingAppletActionCancellation r13 = PendingAppletActionCancellation.a;
        Message r14 = this.$message;
        r13.getClass();
        if (PendingAppletActionCancellation.b(r14) == true) goto L11;
        RepoDispatcher.a.getClass();
        ChatRepo r15 = RepoDispatcher.d;
        Message r16 = this.$message;
        this.label = 1;
        r8 = r15.y1(r16, this);
        if (r8 != r0) goto L15;
        return r0;
    L11:
        return Unit.INSTANCE;
    }
}
