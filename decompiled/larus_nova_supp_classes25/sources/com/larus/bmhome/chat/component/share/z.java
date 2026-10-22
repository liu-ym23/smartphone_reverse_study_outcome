package com.larus.bmhome.chat.component.share;

import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z implements Function0 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ ChatShareBottomComponent b;
    public final /* synthetic */ List c;

    public /* synthetic */ z(Message r1, ChatShareBottomComponent r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        Message r1 = this.a;
        ChatShareBottomComponent r2 = this.b;
        List r3 = this.c;
        int r4 = ChatShareBottomComponent.R;
        ChatControlTrace r5 = ChatControlTrace.b;
        JSONObject r6 = r5.Ua(r1, null);
        if (r6 != null) goto L5;
        r6 = new JSONObject();
    L5:
        r6.put("message_id_list", r2.d4());
        r6.put("is_general_agent", r2.c4());
        if (r1 == null) goto L9;
        r6.put("agent_id", r5.tb(r1));
        r6.put("trigger_message_id", r1.getMessageId());
        r6.putOpt("is_deep_thinking", l3.f(Boolean.valueOf(com.larus.im.bean.message.a.C0(r1))));
        r6.putOpt("ai_create_show_mode", tz9.a.a(r1));
    L9:
        if (r2.l4() == false) goto L11;
        String r7 = "1";
    L12:
        r6.put("is_ai_podcast", r7);
        ConcurrentHashMap r8 = tx9.v0.a;
        if (r1 == null) goto L15;
        String r9 = r1.getMessageId();
    L16:
        Intrinsics.checkNotNullParameter(r3, "messageIds");
        ArrayList r10 = new ArrayList();
        Iterator r11 = r3.iterator();
    L18:
        if (r11.hasNext() == false) goto L22;
        Object r12 = r11.next();
        if ((!StringsKt.isBlank((String) r12)) == false) goto L18;
        r10.add(r12);
        goto L18
    L22:
        JSONObject r13 = new JSONObject();
        r13.put("message_id_list", CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, null, 62, null));
        if (r9 == null) goto L31;
        if ((!StringsKt.isBlank(r9)) == true) goto L28;
        r9 = null;
    L28:
        if (r9 == null) goto L31;
        r13.put("trigger_message_id", r9);
    L31:
        if (r10.size() != 1) goto L33;
        r13.put("message_id", CollectionsKt.first(r10));
    L33:
        Iterator<String> r14 = r13.keys();
    L35:
        if (r14.hasNext() == false) goto L37;
        String r15 = r14.next();
        r6.put(r15, r13.opt(r15));
        goto L35
    L37:
        return r6;
    L15:
        r9 = null;
        goto L16
    L11:
        r7 = "0";
        goto L12
    }
}
