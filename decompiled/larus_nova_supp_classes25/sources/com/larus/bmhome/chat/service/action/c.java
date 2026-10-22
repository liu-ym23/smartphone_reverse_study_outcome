package com.larus.bmhome.chat.service.action;

import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(wh8.a r1) {
        if (r1 == null) goto L8;
        BotModel r2 = r1.b;
        if (r2 == null) goto L8;
        BotCreatorInfo r3 = r2.getBotCreatorInfo();
        if (r3 == null) goto L8;
        String r4 = r3.getId();
    L10:
        return Intrinsics.areEqual(r4, AccountService.a.getUserId());
    L8:
        r4 = null;
        goto L10
    }

    public static Integer b(wh8.a r0) {
        if (r0 == null) goto L6;
        BotModel r1 = r0.b;
        if (r1 == null) goto L6;
        return r1.getBotType();
    L6:
        return null;
    }

    public static JSONObject c(wc9.e r4, wh8.a r5, String r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "data");
        JSONObject r0 = new JSONObject();
        BotModel r1 = r5.b;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getBotId();
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.put("bot_id", r3);
        if (r4 == null) goto L11;
        String r9 = r4.a;
    L12:
        r0.put("conversation_id", r9);
        r0.put("object_type", "chat");
        if (r4 == null) goto L24;
        String r10 = r4.I;
        if (r10 == null) goto L24;
        if (r10.length() <= 0) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == true) goto L23;
        r10 = null;
    L23:
        if (r10 == null) goto L24;
    L25:
        r0.put("project_id", r10);
        ChatControlTrace r12 = ChatControlTrace.b;
        if (r4 == null) goto L28;
        Integer r13 = r4.v;
    L29:
        BotModel r14 = r5.b;
        if (r14 == null) goto L32;
        Integer r15 = r14.getBotType();
    L33:
        BotModel r16 = r5.b;
        if (r16 == null) goto L38;
        BotCreatorInfo r17 = r16.getBotCreatorInfo();
        if (r17 == null) goto L38;
        r2 = r17.getId();
    L38:
        r0.put("chat_type", r12.g(r13, r15, Intrinsics.areEqual(r2, AccountService.a.getUserId())));
        if (r6 == null) goto L41;
        r0.put("click_from", r6);
    L41:
        if (r8 == null) goto L43;
        r0.put("current_page", r8);
    L43:
        if (r7 == false) goto L45;
        String r18 = "1";
    L46:
        r0.put("is_navigation_sidebar", r18);
        return r0;
    L45:
        r18 = "0";
        goto L46
    L32:
        r15 = null;
        goto L33
    L28:
        r13 = null;
        goto L29
    L19:
        r11 = false;
    L24:
        r10 = "-";
        goto L25
    L11:
        r9 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }
}
