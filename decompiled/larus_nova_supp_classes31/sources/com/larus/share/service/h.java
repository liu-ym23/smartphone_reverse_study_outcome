package com.larus.share.service;

import com.larus.bmhome.share.ShareScene;
import java.net.URI;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h {
    public static final h a = null;
    public static final Set<String> b = null;
    public static final Set<String> c = null;

    public h() {
    }

    static {
        a = new h();
        b = SetsKt.setOf(new String[]{"ecommerce_product", "local_life_poi", "local_life_product", "live_room", "local_life_live_room"});
        c = SetsKt.setOf(new String[]{"current_page", "bot_id", "is_immersive_background", "previous_page", "chat_type", "share_scene", "share_url", "share_title", "share_panel_style", "share_channel_type", "message_id", "conversation_id", "is_search_card", "is_general_agent", "chat_id", "canvas_type", "record_scene", "spreadsheet_id", "position", "share_extra_params", "rich_media", "result", "success", "fail_reason", "click_from", "show_from"});
    }

    public static String a(String... r6) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        String r3 = null;
        if (r2 >= r0) goto L17;
        String r4 = r6[r2];
        if (r4 == null) goto L15;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 == null) goto L15;
        if (r5.length() <= 0) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        r3 = r5;
        goto L15
    L12:
        r7 = false;
    L15:
        if (r3 != null) goto L17;
        r2 = r2 + 1;
    L17:
        return r3;
    }

    public static boolean b(String r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        URI r1 = new URI(r3);     // Catch: Throwable -> L21
        String r4 = r1.getScheme();     // Catch: Throwable -> L21
        if (r4 == null) goto L5;
        String r5 = r4.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L21
    L6:
        boolean r2 = false;
        if (Intrinsics.areEqual(r5, "http") == false) goto L9;
    L10:
        String r6 = r1.getHost();     // Catch: Throwable -> L21
        if (r6 != null) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == true) goto L19;
        r2 = true;
    L19:
        Object r8 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L21
    L23:
        Boolean r9 = Boolean.FALSE;
        if (Result.isFailure-impl(r8) == false) goto L27;
        r8 = r9;
    L27:
        return ((Boolean) r8).booleanValue();
    L13:
        if (StringsKt.isBlank(r6) == true) goto L16;
        r7 = false;
        goto L17
    L9:
        if (Intrinsics.areEqual(r5, "https") == false) goto L19;
    L5:
        r5 = null;
    L21:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    public static g c(f r91) {
        Intrinsics.checkNotNullParameter(r91, "request");
        String r1 = r91.a;
        if (r1 == null) goto L5;
        String r2 = StringsKt.trim(r1).toString();
    L6:
        String r3 = "";
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        String[] r5 = {r91.c, r91.b};
        int r6 = 0;
    L10:
        if (r6 >= 2) goto L22;
        String r9 = r5[r6];
        if (r9 == null) goto L18;
        String r10 = StringsKt.trim(r9).toString();
        if (r10 == null) goto L18;
        a.getClass();
        if (b(r10) == false) goto L18;
    L19:
        if (r10 != null) goto L21;
        r6 = r6 + 1;
        goto L10
    L21:
        String r12 = r10;
    L23:
        if (r12 == null) goto L25;
        String r7 = r91.f;
        if (r7 == null) goto L33;
        String r8 = StringsKt.trim(r7).toString();
        if (r8 == null) goto L33;
        a.getClass();
        if (b(r8) == false) goto L33;
        String r13 = r8;
    L34:
        String r11 = d.d(r91.j, r12);
        String r14 = d(r2);
        String r85 = e(r2);
        JSONObject r15 = new JSONObject();
        JSONObject r16 = r91.j;
        if (r16 == null) goto L42;
        Iterator<String> r17 = r16.keys();
    L38:
        if (r17.hasNext() == false) goto L42;
        String r18 = r17.next();
        if (c.contains(r18) == true) goto L38;
        r15.put(r18, r16.opt(r18));
    L42:
        String r19 = r91.a;
        if (r19 == null) goto L45;
        String r110 = StringsKt.trim(r19).toString();
    L46:
        if (r110 != null) goto L48;
        r110 = "";
    L48:
        r15.put("saas_scene", r110);
        r15.put("saas_share_url", r12);
        r15.put("share_id", r11);
        String r111 = r91.a;
        if (r111 == null) goto L51;
        String r112 = StringsKt.trim(r111).toString();
    L52:
        if (r112 == null) goto L55;
        r3 = r112;
    L55:
        String r113 = d(r3);
        if (r113 == null) goto L58;
        r15.put("share_scene", r113);
    L58:
        String r4 = e(r3);
        if (r4 == null) goto L61;
        r15.put("share_content", r4);
    L61:
        String[] r114 = new String[4];
        r114[0] = r91.g;
        if (r16 == null) goto L64;
        String r115 = r16.optString("product_id");
    L65:
        r114[1] = r115;
        if (r16 == null) goto L68;
        String r116 = r16.optString("activity_id");
    L69:
        r114[2] = r116;
        if (r16 == null) goto L72;
        String r117 = r16.optString("content_id");
    L73:
        r114[3] = r117;
        String r118 = a(r114);
        String[] r20 = new String[2];
        r20[0] = r91.h;
        if (r16 == null) goto L76;
        String r119 = r16.optString("poi_id");
    L77:
        r20[1] = r119;
        String r21 = a(r20);
        String[] r22 = new String[3];
        r22[0] = r91.i;
        if (r16 == null) goto L80;
        String r120 = r16.optString("room_id");
        char r23 = 1;
    L81:
        r22[r23] = r120;
        if (r16 == null) goto L84;
        String r121 = r16.optString("live_room_id");
        char r122 = 2;
    L85:
        r22[r122] = r121;
        String r24 = a(r22);
        String r90 = r13;
        String[] r123 = new String[1];
        if (r16 == null) goto L88;
        String r124 = r16.optString("shop_id");
    L89:
        r123[0] = r124;
        String r125 = a(r123);
        if (r118 == null) goto L92;
        r15.put("product_id", r118);
        r15.put("content_id", r118);
    L92:
        if (r21 == null) goto L94;
        r15.put("poi_id", r21);
    L94:
        if (r24 == null) goto L96;
        r15.put("room_id", r24);
        r15.put("live_room_id", r24);
    L96:
        if (r125 == null) goto L98;
        r15.put("shop_id", r125);
    L98:
        if (r14 != null) goto L100;
        r14 = "saas_share";
    L100:
        String r52 = r14;
        if (b.contains(r2) == true) goto L103;
        Map r80 = null;
    L104:
        com.larus.bmhome.share.panel.h r25 = new com.larus.bmhome.share.panel.h(null, null, null, null, null, null, null, r15, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r52, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r80, false, null, null, null, r85, -257, -129, 495);
        ShareScene r26 = ShareScene.SAAS_SHARE;
        String r27 = r91.d;
        if (r27 == null) goto L107;
        String r126 = StringsKt.trim(r27).toString();
    L108:
        String r0 = r91.e;
        if (r0 == null) goto L111;
        String r127 = StringsKt.trim(r0).toString();
    L113:
        return new g(true, new e(r26, new com.larus.bmhome.share.panel.b(null, null, r12, r90, null, null, null, r126, r127, null, r11, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67107443), r25), null, 4);
    L111:
        r127 = null;
        goto L113
    L107:
        r126 = null;
        goto L108
    L103:
        r80 = MapsKt.mapOf(new Pair[]{TuplesKt.to("copy_link", "copy_link"), TuplesKt.to("wechat", "wechat"), TuplesKt.to("moments", "moments"), TuplesKt.to("aweme", "aweme_friend")});
        goto L104
    L88:
        r124 = null;
        goto L89
    L84:
        r122 = 2;
        r121 = null;
        goto L85
    L80:
        r23 = 1;
        r120 = null;
        goto L81
    L76:
        r119 = null;
        goto L77
    L72:
        r117 = null;
        goto L73
    L68:
        r116 = null;
        goto L69
    L64:
        r115 = null;
        goto L65
    L51:
        r112 = null;
        goto L52
    L45:
        r110 = null;
    L33:
        r13 = null;
        goto L34
    L25:
        return new g(false, null, "share url is invalid", 2);
    L18:
        r10 = null;
        goto L19
    L22:
        r12 = null;
        goto L23
    L5:
        r2 = null;
        goto L6
    }

    public static String d(String r1) {
        switch(r1.hashCode()) {
            case -2042959376: goto L19;
            case -1710319872: goto L15;
            case -879114721: goto L12;
            case 1008942158: goto L9;
            case 1716792539: goto L6;
            default: goto L22;
        };
    L22:
        return null;
    L6:
        if (r1.equals("local_life_poi") == false) goto L22;
    L17:
        return "locallife";
    L9:
        if (r1.equals("live_room") == false) goto L22;
    L21:
        return "ecom";
    L12:
        if (r1.equals("local_life_live_room") == true) goto L17;
    L15:
        if (r1.equals("local_life_product") == true) goto L17;
    L19:
        if (r1.equals("ecommerce_product") == true) goto L21;
        goto L21
    }

    public static String e(String r1) {
        switch(r1.hashCode()) {
            case -2042959376: goto L20;
            case -1710319872: goto L17;
            case -879114721: goto L13;
            case 1008942158: goto L10;
            case 1716792539: goto L6;
            default: goto L23;
        };
    L23:
        return null;
    L6:
        if (r1.equals("local_life_poi") == false) goto L23;
        return "poi";
    L10:
        if (r1.equals("live_room") == false) goto L23;
    L15:
        return "room";
    L13:
        if (r1.equals("local_life_live_room") == true) goto L15;
    L17:
        if (r1.equals("local_life_product") == false) goto L23;
    L22:
        return "product";
    L20:
        if (r1.equals("ecommerce_product") == true) goto L22;
        goto L22
    }
}
