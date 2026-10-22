package com.larus.bmhome.chat.model.strategy;

import android.os.SystemClock;
import com.larus.bmhome.chat.api.AppletPayloadProviderDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatSendUtils$preloadAppletPayload$1", f = "ChatSendUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSendUtils$preloadAppletPayload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $localMessageId;
    int label;

    public ChatSendUtils$preloadAppletPayload$1(String r1, String r2, String r3, Continuation<? super ChatSendUtils$preloadAppletPayload$1> r4) {
        this.$conversationId = r1;
        this.$botId = r2;
        this.$localMessageId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatSendUtils$preloadAppletPayload$1(this.$conversationId, this.$botId, this.$localMessageId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r6);
        String r0 = (String) ((LinkedHashMap) AppletPayloadProviderDelegate.a.b(this.$conversationId, this.$botId, this.$localMessageId)).get("client_system_permission");     // Catch: Throwable -> L8
        ChatSendUtils r1 = ChatSendUtils.a;     // Catch: Throwable -> L8
        ChatSendUtils.d = new ChatSendUtils.a(r0, SystemClock.elapsedRealtime(), this.$localMessageId);     // Catch: Throwable -> L8
        FLogger.a.i("SendMsgPerf", "preloadAppletPayload success");     // Catch: Throwable -> L8
        ChatSendUtils.c.set(false);
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        ChatSendUtils.c.set(false);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
