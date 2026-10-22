package com.larus.bmhome.chat.component.ext;

import com.larus.bmhome.chat.bean.ChatMsgDeleteScene;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.ext.ChatFragmentDelegateDialogExtKt$showDeleteMessagesDialog$1$confirm$4", f = "ChatFragmentDelegateDialogExt.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
public final class ChatFragmentDelegateDialogExtKt$showDeleteMessagesDialog$1$confirm$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Integer $botType;
    final /* synthetic */ ChatMsgDeleteScene $deleteScene;
    final /* synthetic */ List<Message> $messages;
    final /* synthetic */ JSONObject $traceInfo;
    int label;

    public ChatFragmentDelegateDialogExtKt$showDeleteMessagesDialog$1$confirm$4(List<Message> r1, String r2, JSONObject r3, ChatMsgDeleteScene r4, Integer r5, Continuation<? super ChatFragmentDelegateDialogExtKt$showDeleteMessagesDialog$1$confirm$4> r6) {
        this.$messages = r1;
        this.$botId = r2;
        this.$traceInfo = r3;
        this.$deleteScene = r4;
        this.$botType = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatFragmentDelegateDialogExtKt$showDeleteMessagesDialog$1$confirm$4(this.$messages, this.$botId, this.$traceInfo, this.$deleteScene, this.$botType, r9);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        List<Message> r2 = this.$messages;
        String r9 = this.$botId;
        JSONObject r3 = this.$traceInfo;
        ChatMsgDeleteScene r4 = this.$deleteScene;
        Integer r5 = this.$botType;
        this.label = 1;
        if (ChatFragmentDelegateDialogExtKt.c(r2, r9, r3, r4, r5, this) != r0) goto L12;
        return r0;
    }
}
