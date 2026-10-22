package com.ss.android.lark.chat.cot;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static ToolCallListResultArea a(JSONArray r15) {
        if (r15 != null) goto L5;
        return null;
    L5:
        if (r15.length() == 0) goto L82;
        ArrayList r1 = new ArrayList(r15.length());
        int r2 = r15.length();
        int r4 = 0;
    L8:
        boolean r5 = true;
        if (r4 >= r2) goto L71;
        Object r6 = r15.opt(r4);
        if ((r6 instanceof JSONObject) == false) goto L55;
        JSONObject r7 = (JSONObject) r6;
        String r8 = c(r7, new String[]{"text", "title", IPortraitService.NAME, "content"});
        if (r8.length() <= 0) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L18;
        String r10 = r8;
    L19:
        String r11 = c(r7, new String[]{"link", "url", "href"});
        if (r11.length() <= 0) goto L22;
        boolean r12 = true;
    L23:
        if (r12 == false) goto L25;
        String r13 = r11;
    L26:
        String r14 = r7.optString("icon");
        Intrinsics.checkNotNull(r14);
        if (r14.length() <= 0) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == false) goto L32;
        String r17 = r14;
    L33:
        String r18 = c(r7, new String[]{"imageKey", "image_key"});
        if (r18.length() <= 0) goto L36;
        boolean r19 = true;
    L37:
        if (r19 == false) goto L39;
        String r110 = r18;
    L40:
        String r20 = c(r7, new String[]{"iconUrl", "icon_url"});
        if (r20.length() > 0) goto L44;
        r5 = false;
    L44:
        if (r5 == false) goto L46;
        String r111 = r20;
    L47:
        if (r10 != null) goto L53;
        if (r13 != null) goto L53;
        if (r17 != null) goto L53;
        if (r110 != null) goto L53;
        if (r111 != null) goto L53;
    L66:
        ToolCallResultAreaListItem r21 = null;
    L67:
        if (r21 == null) goto L69;
        r1.add(r21);
    L69:
        r4 = r4 + 1;
    L53:
        r21 = new ToolCallResultAreaListItem(r10, r13, r17, r110, r111);
        goto L67
    L46:
        r111 = null;
        goto L47
    L39:
        r110 = null;
        goto L40
    L36:
        r19 = false;
        goto L37
    L32:
        r17 = null;
        goto L33
    L29:
        r16 = false;
        goto L30
    L25:
        r13 = null;
        goto L26
    L22:
        r12 = false;
        goto L23
    L18:
        r10 = null;
        goto L19
    L15:
        r9 = false;
        goto L16
    L55:
        if ((r6 instanceof String) == false) goto L66;
        if (((String) r6).length() > 0) goto L60;
        r5 = false;
    L60:
        if (r5 == true) goto L63;
        r6 = null;
    L63:
        String r22 = (String) r6;
        if (r22 == null) goto L66;
        r21 = new ToolCallResultAreaListItem(r22, null, null, null, null);
        goto L67
    L71:
        if ((!r1.isEmpty()) == true) goto L74;
        r1 = null;
    L74:
        if (r1 != null) goto L76;
        return null;
    L76:
        return new ToolCallListResultArea(r1);
    L82:
        return null;
    }

    public static ToolCallResultArea b(JSONObject r8) {
        String r0 = r8.optString(IPortraitService.TYPE);
        String r1 = null;
        if (r0 == null) goto L46;
        int r2 = r0.hashCode();
        boolean r3 = false;
        if (r2 == 3059181) goto L28;
        if (r2 == 3322014) goto L24;
        if (r2 == 3556653) goto L12;
        return null;
    L12:
        if (r0.equals("text") == false) goto L50;
        String r9 = c(r8, new String[]{"text", "content", "value"});
        if (r9.length() <= 0) goto L17;
        r3 = true;
    L17:
        if (r3 == true) goto L20;
        r9 = null;
    L20:
        if (r9 != null) goto L47;
        return null;
    L47:
        return new ToolCallTextResultArea(r9);
    L50:
        return null;
    L24:
        if (r0.equals("list") == true) goto L48;
        return null;
    L48:
        return a(r8.optJSONArray("items"));
    L28:
        if (r0.equals("code") == false) goto L53;
        String r4 = c(r8, new String[]{"code", "content", "value"});
        if (r4.length() <= 0) goto L33;
        boolean r5 = true;
    L34:
        if (r5 == true) goto L37;
        r4 = null;
    L37:
        if (r4 == null) goto L54;
        String r10 = c(r8, new String[]{"language", "lang"});
        if (r10.length() <= 0) goto L42;
        r3 = true;
    L42:
        if (r3 == false) goto L45;
        r1 = r10;
    L45:
        return new ToolCallCodeResultArea(r4, r1);
    L54:
        return null;
    L33:
        r5 = false;
        goto L34
    L53:
        return null;
    L46:
        return null;
    }

    public static String c(JSONObject r4, String... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        String r2 = r5[r1];
        if (r4.has(r2) == false) goto L10;
        if (r4.isNull(r2) == true) goto L10;
        return r4.optString(r2);
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        return BuildConfig.FLAVOR;
    }
}
