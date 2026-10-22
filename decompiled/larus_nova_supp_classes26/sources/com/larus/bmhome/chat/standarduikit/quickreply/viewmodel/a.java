package com.larus.bmhome.chat.standarduikit.quickreply.viewmodel;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.im.bean.message.block.QuickReplyScene;
import com.larus.platform.service.o;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(b r1) {
        Map<String, String> r2 = r1.f;
        if (r2 == null) goto L14;
        String r3 = r2.get("diversion_scene");
        if (r3 == null) goto L14;
        String r4 = StringsKt.trim(r3).toString();
        if (r4 == null) goto L14;
        if (r4.length() <= 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L14;
        return r4;
    L11:
        r0 = false;
    L14:
        return null;
    }

    public static void b(b r4) {
        Intrinsics.checkNotNullParameter(r4, "vmData");
        JSONObject r0 = new JSONObject();
        String r1 = r4.b;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put(MusicAppletPage.KEY_MESSAGE_ID, r1);
        String r3 = r4.c;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.put("bot_id", r3);
        r0.put("sug_card_type", "inner_message_button");
        QuickReplyBlock r5 = r4.i;
        if (r5 == null) goto L13;
        List r6 = r5.getItems();
        if (r6 == null) goto L13;
        String r7 = Integer.valueOf(r6.size()).toString();
    L14:
        if (r7 == null) goto L17;
        r2 = r7;
    L17:
        r0.put("prompt_cnt", r2);
        QuickReplyBlock r8 = r4.i;
        if (r8 == null) goto L25;
        Integer r9 = r8.getScene();
        int r10 = QuickReplyScene.SCENE_SMART_REPLY_SUGGEST.getValue();
        if (r9 == null) goto L25;
        if (r9.intValue() != r10) goto L25;
        boolean r11 = true;
    L26:
        if (r11 == false) goto L28;
        r0.put("suggested_type", "social_chat");
    L28:
        o.a.reportEvent("show_suggested_prompt", r0);
        return;
    L25:
        r11 = false;
    L13:
        r7 = null;
        goto L14
    }

    public static void c(b r12, QuickReplyItem r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "vmData");
        Intrinsics.checkNotNullParameter(r13, "item");
        JSONObject r0 = new JSONObject();
        String r1 = r12.b;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put(MusicAppletPage.KEY_MESSAGE_ID, r1);
        String r3 = r12.c;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.put("bot_id", r3);
        r0.put("sug_card_type", "inner_message_button");
        Map r4 = r13.getExtraParams();
        if (r4 == null) goto L11;
        String r5 = (String) r4.get("item_id");
    L12:
        r0.put("item_id", r5);
        String r6 = r13.getText();
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        r0.put("item_content", r6);
        r0.put("click_position", r14);
        String r15 = r12.d;
        if (r15 == null) goto L19;
        r2 = r15;
    L19:
        boolean r7 = false;
        if (r2.length() != 0) goto L22;
        boolean r16 = true;
    L23:
        if (r16 == false) goto L25;
        r2 = "chat";
    L25:
        r0.put("current_page", r2);
        Map r17 = r13.getExtraParams();
        if (r17 == null) goto L40;
        String r18 = (String) r17.get(MusicAppletPage.KEY_SOURCE);
        if (r18 == null) goto L40;
        String r19 = StringsKt.trim(r18).toString();
        if (r19 == null) goto L40;
        if (r19.length() <= 0) goto L34;
        boolean r8 = true;
    L35:
        if (r8 == true) goto L38;
        r19 = null;
    L38:
        if (r19 == null) goto L40;
        r0.put("suggested_type", r19);
        goto L40
    L34:
        r8 = false;
    L40:
        o.a.reportEvent("click_suggested_prompt", r0);
        String r9 = a(r12);
        if (r9 == null) goto L55;
        String r110 = r13.getText();
        if (r110 == null) goto L52;
        String r111 = StringsKt.trim(r110).toString();
        if (r111 == null) goto L52;
        if (r111.length() <= 0) goto L50;
        r7 = true;
    L50:
        if (r7 == false) goto L52;
        String r10 = r111;
    L53:
        x1.e(r9, "query_suggest", "query_suggest_button", r10, null, null, 112);
        return;
    L52:
        r10 = null;
        goto L53
    L55:
        return;
    L22:
        r16 = false;
        goto L23
    L11:
        r5 = null;
        goto L12
    }
}
