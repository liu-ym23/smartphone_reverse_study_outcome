package com.larus.bmhome.chat.list.cell.prompt;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s implements Function1 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ PromptCell b;

    public /* synthetic */ s(Message r1, PromptCell r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r9) {
        Message r0 = this.a;
        PromptCell r1 = this.b;
        PromptContent.SuggestItem r10 = (PromptContent.SuggestItem) r9;
        Keva r2 = PromptCell.Y;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("on prompt menu click, id=");
        String r5 = null;
        if (r10 == null) goto L5;
        String r6 = r10.getItemId();
    L6:
        r4.append(r6);
        r4.append(" suggest=");
        if (r10 == null) goto L9;
        String r7 = r10.getSuggest();
    L10:
        r4.append(r7);
        r4.append(", msg=");
        r4.append(r0);
        r3.i("WcbSugPromptCell", r4.toString());
        fx9.a r8 = r1.C();
        if (r8 == null) goto L16;
        if (r10 == null) goto L14;
        String r11 = r10.getItemId();
    L15:
        r8.KX(r0, r11);
        goto L16
    L14:
        r11 = null;
    L16:
        i1 r12 = r1.U;
        if (r12 == null) goto L47;
        Intrinsics.checkNotNullParameter(r0, "message");
        String r13 = r0.getSectionId();
        String r14 = "";
        if (r13 != null) goto L22;
        r13 = "";
    L22:
        if (r13.length() != 0) goto L24;
        boolean r15 = true;
    L25:
        if (r15 == false) goto L32;
        com.larus.bmhome.chat.component.cvs.y r16 = r12.b;
        if (r16 == null) goto L31;
        wc9.e r17 = r16.h();
        if (r17 == null) goto L31;
        r13 = r17.B;
    L31:
        r13 = null;
    L32:
        com.larus.platform.service.o r18 = com.larus.platform.service.o.a;
        JSONObject r19 = new JSONObject();
        if (r10 == null) goto L35;
        String r20 = r10.getItemId();
    L36:
        if (r20 != null) goto L38;
        r20 = "";
    L38:
        r19.put("item_id", r20);
        String r21 = com.larus.im.bean.message.a.x(r0);
        if (r21 == null) goto L42;
        r14 = r21;
    L42:
        r19.put("reco_request_id", r14);
        r19.put("section_id", r13);
        r19.put("click_from", "long_press_onboarding");
        r19.put("show_from", "new_topic");
        r19.put("current_page", "chat");
        de8.c r22 = r12.a;
        if (r22 == null) goto L45;
        r5 = r22.p();
    L45:
        r19.put("previous_page", r5);
        Unit r23 = Unit.INSTANCE;
        r18.reportEvent("click_uninterested", r19);
        goto L47
    L35:
        r20 = null;
        goto L36
    L24:
        r15 = false;
    L47:
        return Unit.INSTANCE;
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }
}
