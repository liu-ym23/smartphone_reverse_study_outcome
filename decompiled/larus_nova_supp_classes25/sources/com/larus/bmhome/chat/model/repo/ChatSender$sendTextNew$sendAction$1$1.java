package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.manager.Gpt4SwitchManager;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.im.callback.IIMError;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$sendTextNew$sendAction$1$1", f = "ChatSender.kt", i = {}, l = {384}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSender$sendTextNew$sendAction$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Message, IIMError, Unit> $callback;
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ String $content;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ String $localMessageId;
    final /* synthetic */ boolean $needInterrupt;
    final /* synthetic */ ReferenceInfo $referenceInfo;
    final /* synthetic */ String $scene;
    final /* synthetic */ Long $sendClickTimestamp;
    final /* synthetic */ String $sendFuncChannel;
    final /* synthetic */ MessageStatus $status;
    final /* synthetic */ List<TextTagInfo> $textTags;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$sendTextNew$sendAction$1$1(Map<String, String> r1, String r2, ChatSender r3, String r4, String r5, String r6, List<TextTagInfo> r7, MessageStatus r8, Function2<? super Message, ? super IIMError, Unit> r9, boolean r10, ReferenceInfo r11, String r12, ChatPageContext r13, Long r14, Continuation<? super ChatSender$sendTextNew$sendAction$1$1> r15) {
        this.$ext = r1;
        this.$localMessageId = r2;
        this.this$0 = r3;
        this.$content = r4;
        this.$cvsId = r5;
        this.$scene = r6;
        this.$textTags = r7;
        this.$status = r8;
        this.$callback = r9;
        this.$needInterrupt = r10;
        this.$referenceInfo = r11;
        this.$sendFuncChannel = r12;
        this.$chatPageContext = r13;
        this.$sendClickTimestamp = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r19, Continuation<?> r20) {
        return new ChatSender$sendTextNew$sendAction$1$1(this.$ext, this.$localMessageId, this.this$0, this.$content, this.$cvsId, this.$scene, this.$textTags, this.$status, this.$callback, this.$needInterrupt, this.$referenceInfo, this.$sendFuncChannel, this.$chatPageContext, this.$sendClickTimestamp, r20);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        Map<String, String> r1 = this.$ext;
        if (r1 == null) goto L15;
        String r2 = r1.get("model_type");
        if (r2 == null) goto L15;
        Integer r3 = StringsKt.toIntOrNull(r2);
        if (r3 == null) goto L15;
        int r4 = r3.intValue();
    L17:
        if (r4 != 2) goto L19;
        CoroutineScope r5 = Gpt4SwitchManager.a;
        Gpt4SwitchManager.b(this.$localMessageId);
    L19:
        ChatSender r6 = this.this$0;
        String r8 = this.$localMessageId;
        String r9 = this.$content;
        String r10 = this.$cvsId;
        String r11 = this.$scene;
        List<TextTagInfo> r12 = this.$textTags;
        Map<String, String> r13 = this.$ext;
        MessageStatus r14 = this.$status;
        Function2<Message, IIMError, Unit> r15 = this.$callback;
        boolean r16 = this.$needInterrupt;
        ReferenceInfo r17 = this.$referenceInfo;
        String r18 = this.$sendFuncChannel;
        ChatPageContext r19 = this.$chatPageContext;
        Long r110 = this.$sendClickTimestamp;
        this.label = 1;
        if (ChatSender.L(r6, r8, r9, r10, r11, r12, r13, false, r14, r15, r16, r17, r18, r19, r110, this, 64) != r7) goto L23;
        return r7;
    L15:
        r4 = 0;
        goto L17
    }
}
