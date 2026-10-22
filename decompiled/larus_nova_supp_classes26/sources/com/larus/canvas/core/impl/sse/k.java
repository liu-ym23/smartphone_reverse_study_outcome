package com.larus.canvas.core.impl.sse;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.bmhome.share.panel.ShareType;
import cy8.d;
import cy8.e;
import cy8.m;
import cy8.n;
import cy8.o;
import cy8.p;
import cy8.q;
import cy8.r;
import cy8.s;
import cy8.t;
import cy8.v;
import cy8.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ouc.d0;
import ouc.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public static d0 a(cy8.j r5) {
        e0 r0 = new e0();
        String r1 = r5.a;
        if (r1 == null) goto L5;
        ouc.j.c(r0, "uri", r1);
    L5:
        String r2 = r5.b;
        if (r2 == null) goto L8;
        ouc.j.c(r0, ShareType.URL, r2);
    L8:
        Integer r3 = r5.c;
        if (r3 == null) goto L11;
        ouc.j.b(r0, "width", Integer.valueOf(r3.intValue()));
    L11:
        Integer r4 = r5.d;
        if (r4 == null) goto L14;
        ouc.j.b(r0, "height", Integer.valueOf(r4.intValue()));
    L14:
        Map<String, String> r6 = r5.e;
        if (r6 == null) goto L21;
        e0 r7 = new e0();
        Iterator<Map.Entry<String, String>> r8 = r6.entrySet().iterator();
    L18:
        if (r8.hasNext() == false) goto L20;
        Map.Entry<String, String> r9 = r8.next();
        ouc.j.c(r7, r9.getKey(), r9.getValue());
        goto L18
    L20:
        Unit r10 = Unit.INSTANCE;
        r0.b("url_formats", r7.a());
    L21:
        Boolean r11 = r5.f;
        if (r11 == null) goto L25;
        ouc.j.a(r0, "ai_creation_image", Boolean.valueOf(r11.booleanValue()));
    L25:
        return r0.a();
    }

    public static d0 b(m r4) {
        e0 r0 = new e0();
        String r1 = r4.a;
        if (r1 == null) goto L5;
        ouc.j.c(r0, "uri", r1);
    L5:
        String r2 = r4.b;
        if (r2 == null) goto L8;
        ouc.j.c(r0, ShareType.URL, r2);
    L8:
        Long r3 = r4.c;
        if (r3 == null) goto L11;
        ouc.j.b(r0, "width", Long.valueOf(r3.longValue()));
    L11:
        Long r5 = r4.d;
        if (r5 == null) goto L14;
        ouc.j.b(r0, "height", Long.valueOf(r5.longValue()));
    L14:
        Long r6 = r4.e;
        if (r6 == null) goto L18;
        ouc.j.b(r0, "radius", Long.valueOf(r6.longValue()));
    L18:
        return r0.a();
    }

    public static d0 c(q r14) {
        e0 r0 = new e0();
        ouc.j.b(r0, "id", Long.valueOf(r14.a));
        String r1 = r14.b;
        if (r1 == null) goto L5;
        ouc.j.c(r0, "display_text", r1);
    L5:
        String r2 = r14.c;
        if (r2 == null) goto L8;
        ouc.j.c(r0, "message_text", r2);
    L8:
        m r3 = r14.d;
        if (r3 == null) goto L11;
        a.getClass();
        r0.b("icon", b(r3));
    L11:
        m r4 = r14.e;
        if (r4 == null) goto L14;
        a.getClass();
        r0.b("dark_mode_icon", b(r4));
    L14:
        p r5 = r14.f;
        if (r5 == null) goto L41;
        a.getClass();
        e0 r6 = new e0();
        Boolean r7 = r5.a;
        if (r7 == null) goto L19;
        ouc.j.a(r6, "is_preset_ref_image", Boolean.valueOf(r7.booleanValue()));
    L19:
        s r8 = r5.b;
        if (r8 == null) goto L28;
        LinkedHashMap r9 = new LinkedHashMap();
        m r10 = r8.a;
        if (r10 == null) goto L24;
        d0 r11 = b(r10);
        Intrinsics.checkNotNullParameter("image_thumb", "key");
        Intrinsics.checkNotNullParameter(r11, "element");
        ouc.i r12 = (ouc.i) r9.put("image_thumb", r11);
    L24:
        m r13 = r8.b;
        if (r13 == null) goto L27;
        d0 r15 = b(r13);
        Intrinsics.checkNotNullParameter("image_ori", "key");
        Intrinsics.checkNotNullParameter(r15, "element");
        ouc.i r16 = (ouc.i) r9.put("image_ori", r15);
    L27:
        r6.b("preset_ref_image", new d0(r9));
    L28:
        Boolean r17 = r5.c;
        if (r17 == null) goto L31;
        ouc.j.a(r6, "is_trending", Boolean.valueOf(r17.booleanValue()));
    L31:
        Integer r18 = r5.d;
        if (r18 == null) goto L34;
        ouc.j.b(r6, "detect_mode", Integer.valueOf(r18.intValue()));
    L34:
        String r19 = r5.e;
        if (r19 == null) goto L37;
        ouc.j.c(r6, "sub_display", r19);
    L37:
        String r20 = r5.f;
        if (r20 == null) goto L40;
        ouc.j.c(r6, "option_msg", r20);
    L40:
        r0.b("extra", r6.a());
    L41:
        String r21 = r14.g;
        if (r21 == null) goto L44;
        ouc.j.c(r0, "redirect_schema", r21);
    L44:
        m r22 = r14.h;
        if (r22 == null) goto L47;
        a.getClass();
        r0.b("mask_uri", b(r22));
    L47:
        r r23 = r14.i;
        if (r23 == null) goto L70;
        a.getClass();
        LinkedHashMap r24 = new LinkedHashMap();
        List<cy8.g> r25 = r23.a;
        if (r25 == null) goto L69;
        List<cy8.g> r26 = r25;
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator<T> r28 = r26.iterator();
    L53:
        if (r28.hasNext() == false) goto L68;
        cy8.g r29 = (cy8.g) r28.next();
        a.getClass();
        e0 r30 = new e0();
        String r110 = r29.a;
        if (r110 == null) goto L57;
        ouc.j.c(r30, "match_ui_id", r110);
    L57:
        List<Long> r111 = r29.b;
        if (r111 == null) goto L64;
        List<Long> r112 = r111;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r114 = r112.iterator();
    L61:
        if (r114.hasNext() == false) goto L63;
        r113.add(ouc.k.b(Long.valueOf(((Number) r114.next()).longValue())));
        goto L61
    L63:
        r30.b("option_list", new ouc.b(r113));
    L64:
        Long r31 = r29.c;
        if (r31 == null) goto L67;
        ouc.j.b(r30, "default_option_id", Long.valueOf(r31.longValue()));
    L67:
        r27.add(r30.a());
        goto L53
    L68:
        ouc.b r32 = new ouc.b(r27);
        Intrinsics.checkNotNullParameter("conf_list", "key");
        Intrinsics.checkNotNullParameter(r32, "element");
        ouc.i r33 = (ouc.i) r24.put("conf_list", r32);
    L69:
        r0.b("param_filter_conf", new d0(r24));
    L70:
        o r34 = r14.j;
        if (r34 == null) goto L95;
        a.getClass();
        e0 r35 = new e0();
        String r36 = r34.a;
        if (r36 == null) goto L75;
        ouc.j.c(r35, "placeholder", r36);
    L75:
        List<t> r37 = r34.b;
        if (r37 == null) goto L91;
        List<t> r38 = r37;
        ArrayList r39 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10));
        Iterator<T> r40 = r38.iterator();
    L79:
        if (r40.hasNext() == false) goto L90;
        t r41 = (t) r40.next();
        a.getClass();
        e0 r42 = new e0();
        String r43 = r41.a;
        if (r43 == null) goto L83;
        ouc.j.c(r42, "format", r43);
    L83:
        Integer r44 = r41.b;
        if (r44 == null) goto L86;
        ouc.j.b(r42, "format_type", Integer.valueOf(r44.intValue()));
    L86:
        String r45 = r41.c;
        if (r45 == null) goto L89;
        ouc.j.c(r42, "match_ui_id", r45);
    L89:
        r39.add(r42.a());
        goto L79
    L90:
        r35.b("prompt_list", new ouc.b(r39));
    L91:
        String r46 = r34.c;
        if (r46 == null) goto L94;
        ouc.j.c(r35, "no_limit_prompt_format", r46);
    L94:
        r0.b("msg_prompt_conf", r35.a());
    L95:
        m r47 = r14.k;
        if (r47 == null) goto L98;
        a.getClass();
        r0.b("icon_ori", b(r47));
    L98:
        m r48 = r14.l;
        if (r48 == null) goto L101;
        a.getClass();
        r0.b("preview_icon", b(r48));
    L101:
        String r49 = r14.m;
        if (r49 == null) goto L104;
        ouc.j.c(r0, "language", r49);
    L104:
        String r50 = r14.n;
        if (r50 == null) goto L107;
        ouc.j.c(r0, "source_message_text", r50);
    L107:
        String r115 = r14.o;
        if (r115 == null) goto L111;
        ouc.j.c(r0, "target_message_text", r115);
    L111:
        return r0.a();
    }

    public static ouc.b d(List r3) {
        List r4 = r3;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        q r1 = (q) r5.next();
        a.getClass();
        r0.add(c(r1));
        goto L4
    L7:
        return new ouc.b(r0);
    }

    public static String e(v r13) {
        Intrinsics.checkNotNullParameter(r13, "body");
        e0 r0 = new e0();
        Long r1 = r13.a;
        if (r1 == null) goto L5;
        ouc.j.b(r0, "canvas_id", Long.valueOf(r1.longValue()));
    L5:
        Long r2 = r13.b;
        if (r2 == null) goto L8;
        ouc.j.b(r0, "canvas_sub_id", Long.valueOf(r2.longValue()));
    L8:
        Integer r3 = r13.c;
        if (r3 == null) goto L11;
        ouc.j.b(r0, "canvas_type", Integer.valueOf(r3.intValue()));
    L11:
        Integer r4 = r13.d;
        if (r4 == null) goto L14;
        ouc.j.b(r0, "generate_type", Integer.valueOf(r4.intValue()));
    L14:
        String r5 = r13.e;
        if (r5 == null) goto L17;
        ouc.j.c(r0, "local_id", r5);
    L17:
        String r6 = r13.f;
        if (r6 == null) goto L20;
        ouc.j.c(r0, "send_msg_id", r6);
    L20:
        String r7 = r13.g;
        if (r7 == null) goto L23;
        ouc.j.c(r0, "reply_msg_id", r7);
    L23:
        String r8 = r13.h;
        if (r8 == null) goto L26;
        ouc.j.c(r0, MusicAppletPage.KEY_CONVERSATION_ID, r8);
    L26:
        Long r9 = r13.i;
        if (r9 == null) goto L29;
        ouc.j.b(r0, "seq_start", Long.valueOf(r9.longValue()));
    L29:
        List<cy8.l> r10 = r13.j;
        if (r10 == null) goto L85;
        a.getClass();
        List<cy8.l> r11 = r10;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r14 = r11.iterator();
    L33:
        if (r14.hasNext() == false) goto L84;
        cy8.l r15 = (cy8.l) r14.next();
        a.getClass();
        e0 r16 = new e0();
        String r17 = r15.a;
        if (r17 == null) goto L37;
        ouc.j.c(r16, "tab_label", r17);
    L37:
        String r18 = r15.b;
        if (r18 == null) goto L40;
        ouc.j.c(r16, "tab_name", r18);
    L40:
        Integer r19 = r15.c;
        if (r19 == null) goto L43;
        ouc.j.b(r16, "tab_type", Integer.valueOf(r19.intValue()));
    L43:
        y r20 = r15.d;
        if (r20 == null) goto L55;
        e0 r21 = new e0();
        Boolean r22 = r20.a;
        if (r22 == null) goto L48;
        ouc.j.a(r21, "is_support_ref_image", Boolean.valueOf(r22.booleanValue()));
    L48:
        Integer r23 = r20.b;
        if (r23 == null) goto L51;
        ouc.j.b(r21, "effect_mode", Integer.valueOf(r23.intValue()));
    L51:
        Integer r24 = r20.c;
        if (r24 == null) goto L54;
        ouc.j.b(r21, "ability_type", Integer.valueOf(r24.intValue()));
    L54:
        r16.b("extra", r21.a());
    L55:
        m r25 = r15.e;
        if (r25 == null) goto L58;
        r16.b("icon", b(r25));
    L58:
        m r26 = r15.f;
        if (r26 == null) goto L61;
        r16.b("dark_mode_icon", b(r26));
    L61:
        List<q> r27 = r15.g;
        if (r27 == null) goto L64;
        r16.b("option_list", d(r27));
    L64:
        q r28 = r15.h;
        if (r28 == null) goto L67;
        r16.b("single_option", c(r28));
    L67:
        List<cy8.f> r29 = r15.i;
        if (r29 == null) goto L83;
        List<cy8.f> r30 = r29;
        ArrayList r31 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
        Iterator<T> r32 = r30.iterator();
    L71:
        if (r32.hasNext() == false) goto L82;
        cy8.f r33 = (cy8.f) r32.next();
        a.getClass();
        e0 r34 = new e0();
        Long r110 = r33.a;
        if (r110 == null) goto L75;
        ouc.j.b(r34, "id", Long.valueOf(r110.longValue()));
    L75:
        String r111 = r33.b;
        if (r111 == null) goto L78;
        ouc.j.c(r34, "title", r111);
    L78:
        List<q> r35 = r33.c;
        if (r35 == null) goto L81;
        r34.b("option_list", d(r35));
    L81:
        r31.add(r34.a());
        goto L71
    L82:
        r16.b("feature_option_panel_list", new ouc.b(r31));
    L83:
        r12.add(r16.a());
        goto L33
    L84:
        r0.b("instruction_tab", new ouc.b(r12));
    L85:
        cy8.j r36 = r13.k;
        if (r36 == null) goto L88;
        a.getClass();
        r0.b("origin_image", a(r36));
    L88:
        String r37 = r13.l;
        if (r37 == null) goto L91;
        ouc.j.c(r0, "prompt", r37);
    L91:
        String r38 = r13.m;
        if (r38 == null) goto L94;
        ouc.j.c(r0, "display_prompt_per_round", r38);
    L94:
        List<cy8.j> r112 = r13.n;
        if (r112 == null) goto L102;
        List<cy8.j> r113 = r112;
        ArrayList r39 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator<T> r114 = r113.iterator();
    L98:
        if (r114.hasNext() == false) goto L100;
        cy8.j r40 = (cy8.j) r114.next();
        a.getClass();
        r39.add(a(r40));
        goto L98
    L100:
        r0.b("ref_images", new ouc.b(r39));
    L102:
        return r0.a().toString();
    }

    public static cy8.b f(d0 r33) {
        ouc.i r1 = (ouc.i) r33.get("block_type");
        if (r1 == null) goto L5;
        Integer r4 = ouc.k.l(ouc.k.o(r1));
    L6:
        ouc.i r2 = (ouc.i) r33.get("block_id");
        if (r2 == null) goto L9;
        String r5 = ouc.k.g(ouc.k.o(r2));
    L10:
        ouc.i r3 = (ouc.i) r33.get("idx");
        if (r3 == null) goto L13;
        Integer r6 = ouc.k.l(ouc.k.o(r3));
    L14:
        ouc.i r7 = (ouc.i) r33.get("is_finish");
        if (r7 == null) goto L19;
        Boolean r8 = ouc.k.f(ouc.k.o(r7));
        if (r8 == null) goto L19;
        boolean r9 = r8.booleanValue();
    L20:
        ouc.i r10 = (ouc.i) r33.get("content");
        if (r10 == null) goto L221;
        k r11 = a;
        d0 r12 = ouc.k.n(r10);
        r11.getClass();
        ouc.i r13 = (ouc.i) r12.get("canvas");
        if (r13 == null) goto L107;
        d0 r14 = ouc.k.n(r13);
        ouc.i r15 = (ouc.i) r14.get("canvas_id");
        if (r15 == null) goto L27;
        Long r16 = ouc.k.q(ouc.k.o(r15));
    L28:
        ouc.i r17 = (ouc.i) r14.get("canvas_sub_id");
        if (r17 == null) goto L31;
        Long r18 = ouc.k.q(ouc.k.o(r17));
    L32:
        ouc.i r19 = (ouc.i) r14.get("canvas_type");
        if (r19 == null) goto L35;
        Integer r110 = ouc.k.l(ouc.k.o(r19));
    L36:
        ouc.i r20 = (ouc.i) r14.get("canvas_status");
        if (r20 == null) goto L39;
        Integer r111 = ouc.k.l(ouc.k.o(r20));
    L40:
        ouc.i r21 = (ouc.i) r14.get("error_code");
        if (r21 == null) goto L43;
        Long r112 = ouc.k.q(ouc.k.o(r21));
    L44:
        ouc.i r22 = (ouc.i) r14.get("error_msg");
        if (r22 == null) goto L47;
        String r113 = ouc.k.g(ouc.k.o(r22));
    L48:
        ouc.i r23 = (ouc.i) r14.get("effect_mode");
        if (r23 == null) goto L51;
        Integer r114 = ouc.k.l(ouc.k.o(r23));
    L52:
        ouc.i r24 = (ouc.i) r14.get("reply_sub_id");
        if (r24 == null) goto L55;
        String r115 = ouc.k.g(ouc.k.o(r24));
    L56:
        ouc.i r25 = (ouc.i) r14.get("task_type");
        if (r25 == null) goto L59;
        Integer r116 = ouc.k.l(ouc.k.o(r25));
    L60:
        ouc.i r26 = (ouc.i) r14.get("cost_time");
        if (r26 == null) goto L87;
        d0 r27 = ouc.k.n(r26);
        ouc.i r28 = (ouc.i) r27.get("multimodal");
        if (r28 == null) goto L65;
        Long r29 = ouc.k.q(ouc.k.o(r28));
    L66:
        ouc.i r30 = (ouc.i) r27.get("llm");
        if (r30 == null) goto L69;
        Long r210 = ouc.k.q(ouc.k.o(r30));
    L70:
        ouc.i r31 = (ouc.i) r27.get("pre_prompt_review");
        if (r31 == null) goto L73;
        Long r211 = ouc.k.q(ouc.k.o(r31));
    L74:
        ouc.i r32 = (ouc.i) r27.get("pre_review");
        if (r32 == null) goto L77;
        Long r212 = ouc.k.q(ouc.k.o(r32));
    L78:
        ouc.i r34 = (ouc.i) r27.get("creation");
        if (r34 == null) goto L81;
        Long r213 = ouc.k.q(ouc.k.o(r34));
    L82:
        ouc.i r35 = (ouc.i) r27.get("block_cost_time");
        if (r35 == null) goto L85;
        Long r214 = ouc.k.q(ouc.k.o(r35));
    L86:
        d r215 = new d(r29, r210, r211, r212, r213, r214);
    L88:
        ouc.i r36 = (ouc.i) r14.get("prompt");
        if (r36 == null) goto L97;
        ouc.b r37 = ouc.k.m(r36);
        ArrayList r38 = new ArrayList();
        Iterator r39 = r37.iterator();
    L92:
        if (r39.hasNext() == false) goto L96;
        String r117 = ouc.k.g(ouc.k.o((ouc.i) r39.next()));
        if (r117 == null) goto L92;
        r38.add(r117);
        goto L92
    L96:
        ArrayList r216 = r38;
    L98:
        ouc.i r40 = (ouc.i) r14.get("parent_id");
        if (r40 == null) goto L101;
        Long r217 = ouc.k.q(ouc.k.o(r40));
    L102:
        ouc.i r41 = (ouc.i) r14.get("canvas_max_count");
        if (r41 == null) goto L105;
        Integer r218 = ouc.k.l(ouc.k.o(r41));
    L106:
        cy8.k r219 = new cy8.k(r16, r18, r110, r111, r112, r113, r114, r115, r116, r215, r216, r217, r218);
    L108:
        ouc.i r42 = (ouc.i) r12.get("image");
        if (r42 == null) goto L163;
        k r118 = a;
        d0 r43 = ouc.k.n(r42);
        r118.getClass();
        ouc.i r119 = (ouc.i) r43.get("key");
        if (r119 == null) goto L113;
        String r120 = ouc.k.g(ouc.k.o(r119));
    L114:
        ouc.i r121 = (ouc.i) r43.get("image_thumb");
        if (r121 == null) goto L117;
        cy8.j r122 = h(ouc.k.n(r121));
    L118:
        ouc.i r123 = (ouc.i) r43.get("image_ori");
        if (r123 == null) goto L121;
        cy8.j r124 = h(ouc.k.n(r123));
    L122:
        ouc.i r125 = (ouc.i) r43.get("image_preview");
        if (r125 == null) goto L125;
        cy8.j r126 = h(ouc.k.n(r125));
    L126:
        ouc.i r127 = (ouc.i) r43.get("image_thumb_raw");
        if (r127 == null) goto L129;
        cy8.j r128 = h(ouc.k.n(r127));
    L130:
        ouc.i r129 = (ouc.i) r43.get("image_ori_raw");
        if (r129 == null) goto L133;
        cy8.j r130 = h(ouc.k.n(r129));
    L134:
        ouc.i r131 = (ouc.i) r43.get("image_preview_resize");
        if (r131 == null) goto L137;
        cy8.j r132 = h(ouc.k.n(r131));
    L138:
        ouc.i r133 = (ouc.i) r43.get("status");
        if (r133 == null) goto L141;
        Integer r134 = ouc.k.l(ouc.k.o(r133));
    L142:
        ouc.i r135 = (ouc.i) r43.get("tips");
        if (r135 == null) goto L145;
        String r220 = ouc.k.g(ouc.k.o(r135));
    L146:
        ouc.i r136 = (ouc.i) r43.get(ShareChannel.FEEDBACK);
        if (r136 == null) goto L149;
        String r221 = ouc.k.g(ouc.k.o(r136));
    L150:
        ouc.i r137 = (ouc.i) r43.get("request_id");
        if (r137 == null) goto L153;
        String r222 = ouc.k.g(ouc.k.o(r137));
    L154:
        ouc.i r138 = (ouc.i) r43.get("task_id");
        if (r138 == null) goto L157;
        String r223 = ouc.k.g(ouc.k.o(r138));
    L158:
        ouc.i r44 = (ouc.i) r43.get("image_uri");
        if (r44 == null) goto L161;
        String r224 = ouc.k.g(ouc.k.o(r44));
    L162:
        cy8.i r225 = new cy8.i(r120, r122, r124, r126, r128, r130, r132, r134, r220, r221, r222, r223, r224);
    L164:
        ouc.i r45 = (ouc.i) r12.get("msg_info");
        if (r45 == null) goto L179;
        k r139 = a;
        d0 r46 = ouc.k.n(r45);
        r139.getClass();
        ouc.i r140 = (ouc.i) r46.get("send_msg_id");
        if (r140 == null) goto L169;
        String r141 = ouc.k.g(ouc.k.o(r140));
    L170:
        ouc.i r142 = (ouc.i) r46.get("reply_msg_id");
        if (r142 == null) goto L173;
        String r143 = ouc.k.g(ouc.k.o(r142));
    L174:
        ouc.i r47 = (ouc.i) r46.get("task_id");
        if (r47 == null) goto L177;
        String r48 = ouc.k.g(ouc.k.o(r47));
    L178:
        n r310 = new n(r141, r143, r48);
    L180:
        ouc.i r49 = (ouc.i) r12.get("generate_data");
        if (r49 == null) goto L207;
        k r50 = a;
        d0 r51 = ouc.k.n(r49);
        r50.getClass();
        ouc.i r52 = (ouc.i) r51.get("gene_prompt");
        if (r52 == null) goto L185;
        String r144 = ouc.k.g(ouc.k.o(r52));
    L186:
        ouc.i r53 = (ouc.i) r51.get("model_name");
        if (r53 == null) goto L189;
        String r145 = ouc.k.g(ouc.k.o(r53));
    L190:
        ouc.i r54 = (ouc.i) r51.get("ref_images");
        if (r54 == null) goto L197;
        ouc.b r55 = ouc.k.m(r54);
        ArrayList r146 = new ArrayList();
        Iterator r56 = r55.iterator();
    L194:
        if (r56.hasNext() == false) goto L196;
        ouc.i r147 = (ouc.i) r56.next();
        k r148 = a;
        d0 r149 = ouc.k.n(r147);
        r148.getClass();
        r146.add(h(r149));
        goto L194
    L196:
        ArrayList r150 = r146;
    L198:
        ouc.i r57 = (ouc.i) r51.get("image_ori_raw");
        if (r57 == null) goto L201;
        k r58 = a;
        d0 r59 = ouc.k.n(r57);
        r58.getClass();
        cy8.j r151 = h(r59);
    L202:
        ouc.i r60 = (ouc.i) r51.get("image_target_raw");
        if (r60 == null) goto L205;
        k r61 = a;
        d0 r62 = ouc.k.n(r60);
        r61.getClass();
        cy8.j r152 = h(r62);
    L206:
        cy8.h r311 = new cy8.h(r144, r145, r150, r151, r152);
    L208:
        ouc.i r63 = (ouc.i) r12.get("creation");
        if (r63 == null) goto L219;
        k r64 = a;
        d0 r65 = ouc.k.n(r63);
        r64.getClass();
        ouc.i r66 = (ouc.i) r65.get("creation_id");
        if (r66 == null) goto L213;
        String r67 = ouc.k.g(ouc.k.o(r66));
    L214:
        ouc.i r68 = (ouc.i) r65.get("creation_type");
        if (r68 == null) goto L217;
        Integer r69 = ouc.k.l(ouc.k.o(r68));
    L218:
        e r312 = new e(r67, r69);
    L220:
        cy8.a r70 = new cy8.a(r219, r225, r310, r311, r312);
    L222:
        ouc.i r0 = (ouc.i) r33.get("log_id");
        if (r0 == null) goto L225;
        String r71 = ouc.k.g(ouc.k.o(r0));
    L227:
        return new cy8.b(r4, r5, r6, r9, r70, r71);
    L225:
        r71 = null;
        goto L227
    L217:
        r69 = null;
        goto L218
    L213:
        r67 = null;
        goto L214
    L219:
        r312 = null;
        goto L220
    L205:
        r152 = null;
        goto L206
    L201:
        r151 = null;
        goto L202
    L197:
        r150 = null;
        goto L198
    L189:
        r145 = null;
        goto L190
    L185:
        r144 = null;
        goto L186
    L207:
        r311 = null;
        goto L208
    L177:
        r48 = null;
        goto L178
    L173:
        r143 = null;
        goto L174
    L169:
        r141 = null;
        goto L170
    L179:
        r310 = null;
        goto L180
    L161:
        r224 = null;
        goto L162
    L157:
        r223 = null;
        goto L158
    L153:
        r222 = null;
        goto L154
    L149:
        r221 = null;
        goto L150
    L145:
        r220 = null;
        goto L146
    L141:
        r134 = null;
        goto L142
    L137:
        r132 = null;
        goto L138
    L133:
        r130 = null;
        goto L134
    L129:
        r128 = null;
        goto L130
    L125:
        r126 = null;
        goto L126
    L121:
        r124 = null;
        goto L122
    L117:
        r122 = null;
        goto L118
    L113:
        r120 = null;
        goto L114
    L163:
        r225 = null;
        goto L164
    L105:
        r218 = null;
        goto L106
    L101:
        r217 = null;
        goto L102
    L97:
        r216 = null;
        goto L98
    L85:
        r214 = null;
        goto L86
    L81:
        r213 = null;
        goto L82
    L77:
        r212 = null;
        goto L78
    L73:
        r211 = null;
        goto L74
    L69:
        r210 = null;
        goto L70
    L65:
        r29 = null;
        goto L66
    L87:
        r215 = null;
        goto L88
    L59:
        r116 = null;
        goto L60
    L55:
        r115 = null;
        goto L56
    L51:
        r114 = null;
        goto L52
    L47:
        r113 = null;
        goto L48
    L43:
        r112 = null;
        goto L44
    L39:
        r111 = null;
        goto L40
    L35:
        r110 = null;
        goto L36
    L31:
        r18 = null;
        goto L32
    L27:
        r16 = null;
        goto L28
    L107:
        r219 = null;
        goto L108
    L221:
        r70 = null;
    L19:
        r9 = false;
        goto L20
    L13:
        r6 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public static List g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "json");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        ouc.b r3 = ouc.k.m(ouc.a.d.e(r2));     // Catch: Throwable -> L9
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));     // Catch: Throwable -> L9
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L9
    L5:
        if (r4.hasNext() == false) goto L7;
        r1.add(f(ouc.k.n((ouc.i) r4.next())));     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r5 = Result.constructor-impl(r1);     // Catch: Throwable -> L9
    L11:
        List r6 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r5) == false) goto L15;
        r5 = r6;
    L15:
        return (List) r5;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static cy8.j h(d0 r9) {
        ouc.i r0 = (ouc.i) r9.get("uri");
        LinkedHashMap r1 = null;
        if (r0 == null) goto L5;
        String r3 = ouc.k.g(ouc.k.o(r0));
    L6:
        ouc.i r2 = (ouc.i) r9.get(ShareType.URL);
        if (r2 == null) goto L9;
        String r4 = ouc.k.g(ouc.k.o(r2));
    L10:
        ouc.i r5 = (ouc.i) r9.get("width");
        if (r5 == null) goto L13;
        Integer r6 = ouc.k.l(ouc.k.o(r5));
    L14:
        ouc.i r7 = (ouc.i) r9.get("height");
        if (r7 == null) goto L17;
        Integer r8 = ouc.k.l(ouc.k.o(r7));
    L18:
        ouc.i r10 = (ouc.i) r9.get("url_formats");
        if (r10 == null) goto L30;
        Set r11 = ouc.k.n(r10).entrySet();
        if (r11 == null) goto L30;
        Set r12 = r11;
        r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16));
        Iterator r13 = r12.iterator();
    L24:
        if (r13.hasNext() == false) goto L30;
        Map.Entry r14 = (Map.Entry) r13.next();
        Object r15 = r14.getKey();
        String r16 = ouc.k.g(ouc.k.o((ouc.i) r14.getValue()));
        if (r16 != null) goto L28;
        r16 = "";
    L28:
        Pair r17 = TuplesKt.to(r15, r16);
        r1.put(r17.getFirst(), r17.getSecond());
    L30:
        return new cy8.j(r3, r4, r6, r8, r1, 32);
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
