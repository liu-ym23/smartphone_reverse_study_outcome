package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageApiImpl;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class SemanticHelper {
    public static final SemanticHelper a = null;

    static {
        a = new SemanticHelper();
    }

    public SemanticHelper() {
    }

    public static void a(Map r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        r7.put("is_semantic_screen_qa", "1");
        String r3 = (String) r7.get("o_session");     // Catch: Exception -> L8
        if (r3 == null) goto L6;
        JSONObject r4 = new JSONObject(r3);     // Catch: Exception -> L8
    L12:
    L10:
        r4.put("is_semantic_screen_qa", "1");
        r7.put("o_session", r4.toString());
        return;
    L6:
        r4 = new JSONObject();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        FLogger.a.w("SemanticHelper", "Failed to parse o_session JSON, creating new", e);
        r4 = new JSONObject();
        goto L10
    }

    public static boolean b(Message r4, Message r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (com.larus.utils.o0.d(r4.getMessageId()) == false) goto L10;
        if (Intrinsics.areEqual(r5.getMessageId(), r4.getMessageId()) == false) goto L10;
    L13:
        boolean r1 = true;
    L16:
        if (com.larus.utils.o0.d(com.larus.im.bean.message.a.g(r4)) == true) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r1 == true) goto L23;
        if (r6 == true) goto L23;
        return false;
    L23:
        return true;
    L18:
        if (Intrinsics.areEqual(com.larus.im.bean.message.a.g(r5), com.larus.im.bean.message.a.g(r4)) == false) goto L20;
        r6 = true;
    L10:
        if (com.larus.utils.o0.d(r4.getLocalMessageId()) == true) goto L12;
    L14:
        r1 = false;
        goto L16
    L12:
        if (Intrinsics.areEqual(r5.getLocalMessageId(), r4.getLocalMessageId()) == false) goto L14;
        goto L13
    }

    public final Object c(Message r9, String r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof SemanticHelper$preCheck$1) == false) goto L7;
        SemanticHelper$preCheck$1 r0 = (SemanticHelper$preCheck$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r5 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Message r13 = (Message) r0.L$1;
        Message r14 = (Message) r0.L$0;
        ResultKt.throwOnFailure(r12);
        Message r15 = r13;
        r9 = r14;
        Object r16 = r12;
    L27:
        Message r17 = (Message) r16;
        boolean r4 = b(r9, r17);
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("preCheck called, compare (message to latestSendMessage/lastLocalMessage), msgId: (");
        r7.append(r9.getMessageId());
        r7.append(", ");
        if (r15 == null) goto L30;
        String r8 = r15.getMessageId();
    L31:
        r7.append(r8);
        r7.append(", ");
        if (r17 == null) goto L34;
        String r18 = r17.getMessageId();
    L35:
        r7.append(r18);
        r7.append("), localMsgId: (");
        r7.append(r9.getLocalMessageId());
        r7.append(", ");
        if (r15 == null) goto L38;
        String r19 = r15.getLocalMessageId();
    L39:
        r7.append(r19);
        r7.append(", ");
        if (r17 == null) goto L42;
        String r20 = r17.getLocalMessageId();
    L43:
        r7.append(r20);
        r7.append("), collectionId: (");
        r7.append(com.larus.im.bean.message.a.g(r9));
        r7.append(", ");
        if (r15 == null) goto L46;
        String r21 = com.larus.im.bean.message.a.g(r15);
    L47:
        r7.append(r21);
        r7.append(", ");
        if (r17 == null) goto L50;
        r5 = com.larus.im.bean.message.a.g(r17);
    L50:
        r7.append(r5);
        r7.append("), hitByDb: ");
        r7.append(r4);
        r6.i("SemanticHelper", r7.toString());
        return Boxing.boxBoolean(r4);
    L46:
        r21 = null;
        goto L47
    L42:
        r20 = null;
        goto L43
    L38:
        r19 = null;
        goto L39
    L34:
        r18 = null;
        goto L35
    L30:
        r8 = null;
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        IObricChatService.a.getClass();
        IObricChatService r110 = IObricChatService.a.a();
        if (r110 == null) goto L17;
        r110.g();
        r15 = MessageApiImpl.a.j(r10);
    L19:
        if (b(r9, r15) == false) goto L22;
        FLogger.a.i("SemanticHelper", "preCheck hit by cache, msgId: " + r9.getMessageId() + ", localMsgId: " + r9.getLocalMessageId());
        return Boxing.boxBoolean(true);
    L22:
        r0.L$0 = r9;
        r0.L$1 = r15;
        r0.label = 1;
        kotlinx.coroutines.j r22 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r22.C();
        com.larus.im.d.e().l(r10, new q1(r22));
        r16 = r22.B();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L25:
        if (r16 != r2) goto L27;
        return r2;
    L17:
        r15 = null;
    L7:
        r0 = new SemanticHelper$preCheck$1(this, r11);
        goto L8
    }
}
