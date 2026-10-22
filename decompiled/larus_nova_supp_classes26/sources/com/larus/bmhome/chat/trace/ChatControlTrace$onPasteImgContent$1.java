package com.larus.bmhome.chat.trace;

import com.larus.im.bean.message.Message;
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
import tx9.r2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatControlTrace$onPasteImgContent$1", f = "ChatControlTrace.kt", i = {}, l = {5118}, m = "invokeSuspend", n = {}, s = {})
final class ChatControlTrace$onPasteImgContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $chatType;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Integer $fileCnt;
    final /* synthetic */ Integer $isMultiFile;
    final /* synthetic */ Message $lastShownMsg;
    final /* synthetic */ String $messageType;
    final /* synthetic */ Integer $picCnt;
    final /* synthetic */ by7.e $trackNode;
    int label;

    public ChatControlTrace$onPasteImgContent$1(String r1, Message r2, String r3, Integer r4, Integer r5, Integer r6, String r7, String r8, by7.e r9, Continuation<? super ChatControlTrace$onPasteImgContent$1> r10) {
        this.$conversationId = r1;
        this.$lastShownMsg = r2;
        this.$botId = r3;
        this.$fileCnt = r4;
        this.$picCnt = r5;
        this.$isMultiFile = r6;
        this.$chatType = r7;
        this.$messageType = r8;
        this.$trackNode = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new ChatControlTrace$onPasteImgContent$1(this.$conversationId, this.$lastShownMsg, this.$botId, this.$fileCnt, this.$picCnt, this.$isMultiFile, this.$chatType, this.$messageType, this.$trackNode, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L14:
        String r2 = this.$botId;
        Integer r3 = this.$fileCnt;
        Integer r4 = this.$picCnt;
        Integer r5 = this.$isMultiFile;
        String r6 = this.$chatType;
        String r7 = this.$conversationId;
        String r8 = this.$messageType;
        r2.a(r2, r3, r4, r5, r6, r7, r8, (JSONObject) r11, this.$trackNode, 3968);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        ChatControlTrace r12 = ChatControlTrace.b;
        String r9 = this.$conversationId;
        if (r9 != null) goto L11;
        r9 = "";
    L11:
        Message r10 = this.$lastShownMsg;
        this.label = 1;
        r11 = r12.Ob(r9, r10, this);
        if (r11 != r0) goto L14;
        return r0;
    }
}
