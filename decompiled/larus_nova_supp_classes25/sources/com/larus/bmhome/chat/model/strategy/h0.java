package com.larus.bmhome.chat.model.strategy;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h0 {
    static {
    }

    public static List a(String r20) {
        Intrinsics.checkNotNullParameter(r20, "selectorListJson");
        ArrayList r1 = new ArrayList();
        if (StringsKt.isBlank(r20) == false) goto L61;
        FLogger.a.e("PPTMessageRequestParser", "parseInstructionItemsTemplate: empty input");
        return r1;
    L61:
        JSONArray r2 = new JSONObject(r20).optJSONArray("selector_list");
        if (r2 != null) goto L10;
        return r1;
    L10:
        int r4 = r2.length();
        int r6 = 0;
    L11:
        if (r6 >= r4) goto L57;
        String r0 = JSONArrayProtectorUtils.getJSONObject(r2, r6).optString("template");
        boolean r7 = true;
        if (r0 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == true) goto L56;
        JSONObject r9 = new JSONObject(r0);     // Catch: Exception -> L54
        String r3 = r9.optString("label");
        if (r3 == null) goto L28;
        if (r3.length() == 0) goto L28;
        r7 = false;
    L28:
        if (r7 == false) goto L30;
        r3 = r9.optString("display_text");
    L30:
        JSONArray r10 = r9.optJSONArray("option_list");
        if (r10 == null) goto L56;
        int r11 = r10.length();
        int r15 = 0;
    L34:
        if (r15 >= r11) goto L56;
        JSONObject r12 = JSONArrayProtectorUtils.getJSONObject(r10, r15);
        JSONObject r13 = r12.optJSONObject("extra");
        if (r13 == null) goto L53;
        String r14 = r13.optString("page_size_id");
        String r16 = r12.optString("display_text");
        String r17 = r13.optString("selected_id");
        String r18 = r13.optString("selected_type");
        String r19 = r13.optString("selected_result_from");
        if (o0.d(r14) == false) goto L43;
        int r110 = PPTOptionType.PAGE_SIZE.getType();
    L41:
        int r111 = r110;
        String r112 = null;
        if (o0.d(r14) == false) goto L49;
        String r113 = r16;
    L50:
        if (r17 == null) goto L52;
        r112 = r16;
    L52:
        r1.add(new i0(r3, r14, r113, r17, r18, r112, r111));
        goto L53
    L49:
        r113 = null;
        goto L50
    L43:
        if (Intrinsics.areEqual(r19, "selected_result_from_action_bar_button_router") == false) goto L45;
        r110 = PPTOptionType.TEMPLATE.getType();
        goto L41
    L45:
        r110 = PPTOptionType.UNKNOWN.getType();
    L53:
        r15 = r15 + 1;
    L54:
        e = move-exception;
        FLogger.a.e("PPTMessageRequestParser", "parseInstructionItemsTemplate: template json parse error=" + e.getMessage());
    L56:
        r6 = r6 + 1;
        goto L11
    L15:
        if (StringsKt.isBlank(r0) == true) goto L18;
        r8 = false;
        goto L19
    L57:
        return r1;
    L58:
        e = move-exception;
        FLogger.a.e("PPTMessageRequestParser", "parseInstructionItemsTemplate: root json parse error=" + e.getMessage());
        return r1;
    }
}
