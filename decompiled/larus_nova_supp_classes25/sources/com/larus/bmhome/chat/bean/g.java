package com.larus.bmhome.chat.bean;

import com.larus.bmhome.chat.model.ChatDraftItem;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public static final PromptContent.SuggestV2ExtraForMultiAction a(PromptContent.SuggestItem r21) {
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Map<String, String> r2 = r21.getExtra();
        if (r2 == null) goto L5;
        String r4 = r2.get("suggest_action_type");
    L6:
        Map<String, String> r3 = r21.getExtra();
        if (r3 == null) goto L9;
        String r5 = r3.get("actionbar_item_id");
    L10:
        Map<String, String> r6 = r21.getExtra();
        if (r6 == null) goto L13;
        String r7 = r6.get("actionbar_template_id");
    L14:
        Map<String, String> r8 = r21.getExtra();
        if (r8 == null) goto L17;
        String r9 = r8.get("actionbar_key");
    L18:
        Map<String, String> r10 = r21.getExtra();
        if (r10 == null) goto L21;
        String r11 = r10.get("is_font_bold");
    L22:
        Map<String, String> r12 = r21.getExtra();
        if (r12 == null) goto L25;
        String r13 = r12.get(ChatDraftItem.TYPE_MSG_EXT);
    L26:
        Map<String, String> r14 = r21.getExtra();
        if (r14 == null) goto L29;
        String r15 = r14.get("cursor_pos");
    L30:
        Map<String, String> r16 = r21.getExtra();
        if (r16 == null) goto L33;
        String r17 = r16.get("user_prompt");
    L34:
        Map<String, String> r18 = r21.getExtra();
        if (r18 == null) goto L37;
        String r19 = r18.get("schema_url");
    L38:
        Map<String, String> r20 = r21.getExtra();
        if (r20 == null) goto L41;
        String r110 = r20.get("speech_key");
    L42:
        Map<String, String> r22 = r21.getExtra();
        if (r22 == null) goto L45;
        String r111 = r22.get("actionbar_default_selection_cfg");
    L46:
        Map<String, String> r23 = r21.getExtra();
        if (r23 == null) goto L49;
        String r112 = r23.get("bot_info");
    L50:
        Map<String, String> r24 = r21.getExtra();
        if (r24 == null) goto L53;
        String r25 = r24.get("show_from");
    L55:
        return new PromptContent.SuggestV2ExtraForMultiAction(r4, r5, r7, r9, r11, r13, r15, r17, r19, r110, r111, r112, r25, null, r21.getItemId(), 8192, null);
    L53:
        r25 = null;
        goto L55
    L49:
        r112 = null;
        goto L50
    L45:
        r111 = null;
        goto L46
    L41:
        r110 = null;
        goto L42
    L37:
        r19 = null;
        goto L38
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = null;
        goto L30
    L25:
        r13 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
