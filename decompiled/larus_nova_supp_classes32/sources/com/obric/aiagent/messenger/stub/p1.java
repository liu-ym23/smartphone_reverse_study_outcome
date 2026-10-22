package com.obric.aiagent.messenger.stub;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatContextService;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r4.put("is_obric_continuous_talk", "1");
        String r0 = (String) r4.remove("inner_log_id");
        if (r0 == null) goto L5;
        FLogger.a.i("SemanticAudioHelper", "getContinuousExt called, first query logId=".concat(r0));
        String r1 = (String) r4.put("o_semantic_screen_qa_first_logid", r0);
    L5:
        r4.remove("reply_unique_key");
    }

    public static void b(List r7) {
        Intrinsics.checkNotNullParameter(r7, "messages");
        FLogger.a.i("SemanticAudioHelper", "handleObricContinuousTalk called, messages=" + r7);
        Iterator r8 = r7.iterator();
    L3:
        boolean r1 = false;
        com.obric.audio.continuous_talk.b r4 = null;
        if (r8.hasNext() == false) goto L11;
        Object r0 = r8.next();
        if (((Message) r0).getContentType() != 1) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L3;
    L12:
        Message r2 = (Message) r0;
        if (r2 == null) goto L32;
        String r9 = r2.getMessageId();
        if (r9 != null) goto L17;
        return;
    L17:
        FLogger r3 = FLogger.a;
        r3.i("SemanticAudioHelper", "requestChat called, messageId=".concat(r9));
        t1a.b r6 = IObricChatContextService.a.a(ObricChatContextServiceDelegate.b);
        if (r6 == null) goto L20;
        r4 = (com.obric.audio.continuous_talk.b) r6.getAbility(com.obric.audio.continuous_talk.b.class);
    L20:
        StringBuilder r10 = new StringBuilder("requestChat: hasContinuousTalk=");
        if (r4 == null) goto L23;
        r1 = true;
    L23:
        r10.append(r1);
        r3.i("SemanticAudioHelper", r10.toString());
        if (r4 == null) goto L33;
        JSONObject r11 = new JSONObject();
        r11.put("question_id", r9);
        r4.I0(r11);
        return;
    L33:
        return;
    L32:
        return;
    L8:
        r5 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }
}
