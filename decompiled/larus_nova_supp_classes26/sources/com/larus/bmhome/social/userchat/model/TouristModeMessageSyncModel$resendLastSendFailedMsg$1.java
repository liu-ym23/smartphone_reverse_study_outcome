package com.larus.bmhome.social.userchat.model;

import com.bytedance.keva.Keva;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.TouristModeMessageSyncModel$resendLastSendFailedMsg$1", f = "TouristModeMessageSyncModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TouristModeMessageSyncModel$resendLastSendFailedMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ g0 this$0;

    public TouristModeMessageSyncModel$resendLastSendFailedMsg$1(g0 r1, String r2, Continuation<? super TouristModeMessageSyncModel$resendLastSendFailedMsg$1> r3) {
        this.this$0 = r1;
        this.$conversationId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TouristModeMessageSyncModel$resendLastSendFailedMsg$1(this.this$0, this.$conversationId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L62;
        ResultKt.throwOnFailure(r8);
        g0 r9 = this.this$0;
        int r0 = g0.i;
        r9.getClass();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L29
        String r10 = ((Keva) r9.e.getValue()).getString("last_send_msg_of_tourist_mode", "");     // Catch: Throwable -> L29
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L29
        if (r10.length() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L26;
        zd9.h r4 = zd9.h.a;     // Catch: Throwable -> L29
        if (StringsKt.isBlank(r10) == false) goto L65;
    L23:
        Object r11 = null;
    L24:
        MessageWithBotId r12 = (MessageWithBotId) r11;     // Catch: Throwable -> L29
        if (r12 == null) goto L26;
    L27:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r13) == false) goto L34;
        r13 = null;
    L34:
        MessageWithBotId r14 = (MessageWithBotId) r13;
        if (r14 == null) goto L60;
        g0 r1 = this.this$0;
        String r5 = this.$conversationId;
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("resendLastSendFailedMsg retry current botId ");
        r7.append(r1.c);
        r7.append("  cache info botId:");
        r7.append(r14.getBotId());
        r7.append("  localMsgId ");
        Message r15 = r14.getMsg();
        if (r15 == null) goto L39;
        String r16 = r15.getLocalMessageId();
    L40:
        r7.append(r16);
        r6.i("TouristModeMessageSyncModel", r7.toString());
        if (Intrinsics.areEqual(r14.getBotId(), r1.c) == false) goto L60;
        if (g0.a(r1, r14.getMsg()) == false) goto L60;
        Message r17 = r14.getMsg();
        if (r17 == null) goto L47;
        String r18 = com.larus.bmhome.chat.bean.d.r(r17);
    L49:
        if (o0.d(r18) == false) goto L60;
        r6.i("TouristModeMessageSyncModel", "resendLastSendFailedMsg retryMsgBlock invoke");
        Message r19 = r14.getMsg();
        if (r19 == null) goto L58;
        String r20 = com.larus.bmhome.chat.bean.d.r(r19);
        if (r20 == null) goto L58;
        Function3 r21 = r1.b;
        MessageStatus r22 = r14.getMsg().getMessageStatus();
        if (r22 != null) goto L57;
        r22 = MessageStatus.MessageStatus_AVAILABLE;
    L57:
        r21.invoke(r5, r20, r22);
    L58:
        g0.b(r1, null);
        goto L60
    L47:
        r18 = null;
        goto L49
    L39:
        r16 = null;
    L60:
        return Unit.INSTANCE;
    L65:
        r4.getClass();     // Catch: Throwable -> L16
        r11 = Result.constructor-impl(zd9.h.b.fromJson(r10, new h0().getType()));     // Catch: Throwable -> L16
    L18:
        Throwable r23 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L29
        if (r23 == null) goto L22;
        com.larus.im.internal.delegate.c0 r24 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L29
        StringBuilder r25 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r23, "<this>");     // Catch: Throwable -> L29
        r25.append(ExceptionsKt.stackTraceToString(r23));     // Catch: Throwable -> L29
        r24.e("GsonHolder", r25.toString());     // Catch: Throwable -> L29
    L22:
        if (Result.isFailure-impl(r11) == false) goto L24;
    L16:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L29
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L29
    L26:
        r12 = null;
        goto L27
    L8:
        r3 = false;
    L29:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L62:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
