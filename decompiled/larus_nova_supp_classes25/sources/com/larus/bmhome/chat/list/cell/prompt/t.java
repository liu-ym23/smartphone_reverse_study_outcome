package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t implements Function1 {
    public final /* synthetic */ PromptCell a;
    public final /* synthetic */ Message b;

    public /* synthetic */ t(PromptCell r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r18) {
        PromptCell r1 = this.a;
        Message r2 = this.b;
        PromptContent.SuggestItem r3 = (PromptContent.SuggestItem) r18;
        i1 r4 = r1.U;
        String r11 = null;
        String r12 = "";
        if (r4 == null) goto L33;
        Intrinsics.checkNotNullParameter(r2, "message");
        String r14 = r2.getSectionId();
        if (r14 != null) goto L8;
        r14 = "";
    L8:
        if (r14.length() != 0) goto L10;
        boolean r15 = true;
    L11:
        if (r15 == false) goto L18;
        com.larus.bmhome.chat.component.cvs.y r16 = r4.b;
        if (r16 == null) goto L17;
        wc9.e r17 = r16.h();
        if (r17 == null) goto L17;
        r14 = r17.B;
    L17:
        r14 = null;
    L18:
        com.larus.platform.service.o r19 = com.larus.platform.service.o.a;
        JSONObject r5 = new JSONObject();
        if (r3 == null) goto L21;
        String r110 = r3.getItemId();
    L22:
        if (r110 != null) goto L24;
        String r6 = "";
    L25:
        r5.put("item_id", r6);
        String r7 = com.larus.im.bean.message.a.x(r2);
        if (r7 != null) goto L28;
        r7 = "";
    L28:
        r5.put("reco_request_id", r7);
        r5.put("onboarding_type", "new_topic");
        r5.put("section_id", r14);
        r5.put("current_page", "chat");
        de8.c r8 = r4.a;
        if (r8 == null) goto L31;
        String r9 = r8.p();
    L32:
        r5.put("previous_page", r9);
        Unit r10 = Unit.INSTANCE;
        r19.reportEvent("long_press_onboarding", r5);
        goto L33
    L31:
        r9 = null;
        goto L32
    L24:
        r6 = r110;
        goto L25
    L21:
        r110 = null;
        goto L22
    L10:
        r15 = false;
    L33:
        i1 r13 = r1.U;
        if (r13 == null) goto L63;
        Intrinsics.checkNotNullParameter(r2, "message");
        String r20 = r2.getSectionId();
        if (r20 != null) goto L39;
        r20 = "";
    L39:
        if (r20.length() != 0) goto L41;
        boolean r21 = true;
    L42:
        if (r21 == false) goto L49;
        com.larus.bmhome.chat.component.cvs.y r22 = r13.b;
        if (r22 == null) goto L48;
        wc9.e r23 = r22.h();
        if (r23 == null) goto L48;
        r20 = r23.B;
    L48:
        r20 = null;
    L49:
        com.larus.platform.service.o r24 = com.larus.platform.service.o.a;
        JSONObject r25 = new JSONObject();
        if (r3 == null) goto L52;
        r11 = r3.getItemId();
    L52:
        if (r11 != null) goto L54;
        r11 = "";
    L54:
        r25.put("item_id", r11);
        String r26 = com.larus.im.bean.message.a.x(r2);
        if (r26 != null) goto L57;
        r26 = "";
    L57:
        r25.put("reco_request_id", r26);
        r25.put("section_id", r20);
        r25.put("button_name", "uninterested");
        String r27 = r2.getMessageId();
        if (r27 == null) goto L61;
        r12 = r27;
    L61:
        r25.put("message_id", r12);
        r25.put("show_from", "new_topic");
        Unit r28 = Unit.INSTANCE;
        r24.reportEvent("long_press_action_element_show", r25);
        goto L63
    L41:
        r21 = false;
    L63:
        return Unit.INSTANCE;
    }
}
