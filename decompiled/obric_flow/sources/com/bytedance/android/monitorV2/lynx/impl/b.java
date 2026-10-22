package com.bytedance.android.monitorV2.lynx.impl;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.android.monitorV2.event.HybridEvent$TerminateType;
import com.bytedance.common.wschannel.WsConstants;
import com.google.common.reflect.w;
import com.obric.oui.constraintlayout.core.widgets.analyzer.f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import x4.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.bytedance.android.monitorV2.dataprocessor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f3654a;

    public b(w r5) {
        this.f3654a = r5;
    }

    @Override // com.bytedance.android.monitorV2.dataprocessor.a
    public final void a(Object r15) {
        Intrinsics.checkNotNullParameter(r15, "data");
        if ((r15 instanceof com.bytedance.android.monitorV2.event.d) == false) goto L133;
        w r14 = this.f3654a;
        d r5 = ((e) r14.f9377c).f3692c;
        f r10 = r5.f3688c;
        g5.b r11 = (g5.b) r5.f3691j.getValue();
        e r16 = (e) r14.f9377c;
        a r12 = r16.f3698m;
        com.bytedance.android.monitorV2.event.d r13 = (com.bytedance.android.monitorV2.event.d) r15;
        boolean r17 = r10.f12567a;
        r13.d(!r17, HybridEvent$TerminateType.f3540a);
        if (r17 == false) goto L136;
        LinkedHashMap r18 = r13.e;
        String r19 = "config_bid";
        r18.put("config_bid", (String) r10.f12569c);
        String r20 = "jsb_bid";
        r18.put("jsb_bid", r16.f);
        r13.g = r16.f3693h;
        r11.f = (String) r10.d;
        qo.a.m(r11.g, r13.f.g);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r13.f = r11;
        r13.f3559c = r16.g;
        String r21 = null;
        if (r16.F() == null) goto L48;
        r13.f3560h = new x4.a(0, r12.f3652a);
        h r22 = r13.f;
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type com.bytedance.android.monitorV2.lynx.data.entity.LynxCommonData");
        g5.b r23 = (g5.b) r22;
        String r110 = r23.f22973a;
        ConcurrentHashMap r24 = r12.f3653b;
        if (r110 != null) goto L12;
    L13:
        Intrinsics.checkNotNullParameter("url", STGroup.DICT_KEY);
        Object r111 = r24.get("url");
        if ((r111 instanceof String) == false) goto L16;
        String r112 = (String) r111;
    L17:
        if (r112 == null) goto L19;
        r13.f.f22973a = r112;
    L19:
        String r113 = r23.d;
        if (r113 != null) goto L22;
    L23:
        Intrinsics.checkNotNullParameter("native_page", STGroup.DICT_KEY);
        Object r114 = r24.get("native_page");
        if ((r114 instanceof String) == false) goto L26;
        String r115 = (String) r114;
    L27:
        if (r115 == null) goto L30;
        r13.f.d = r115;
    L30:
        if (r23.f17051k.length() != 0) goto L37;
        Intrinsics.checkNotNullParameter("page_version", STGroup.DICT_KEY);
        Object r116 = r24.get("page_version");
        if ((r116 instanceof String) == false) goto L34;
        String r117 = (String) r116;
    L35:
        if (r117 == null) goto L37;
        h r118 = r13.f;
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type com.bytedance.android.monitorV2.lynx.data.entity.LynxCommonData");
        g5.b r119 = (g5.b) r118;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        r119.f17051k = r117;
        goto L37
    L34:
        r117 = null;
    L37:
        String r25 = r23.f22975c;
        if (r25 != null) goto L40;
    L41:
        Intrinsics.checkNotNullParameter("container_type", STGroup.DICT_KEY);
        Object r26 = r24.get("container_type");
        if ((r26 instanceof String) == false) goto L44;
        String r27 = (String) r26;
    L45:
        if (r27 == null) goto L48;
        r13.f.f22975c = r27;
        goto L48
    L44:
        r27 = null;
        goto L45
    L40:
        if (r25.length() != 0) goto L48;
    L26:
        r115 = null;
        goto L27
    L22:
        if (r113.length() != 0) goto L30;
    L16:
        r112 = null;
        goto L17
    L12:
        if (r110.length() != 0) goto L19;
    L48:
        if (StringsKt.isBlank(r16.g) == false) goto L55;
        String r28 = (String) r16.f3692c.f3688c.g;
        if (StringsKt.isBlank(r28) == true) goto L52;
        r21 = r28;
    L52:
        if (r21 == null) goto L55;
        r13.f3560h = new x4.a(0, MapsKt.mapOf(TuplesKt.to("container_name", "AnnieX")));
    L55:
        if ((r15 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L116;
        if (Intrinsics.areEqual(r13.f3557a, "jsbPv") == false) goto L108;
        Method r29 = u4.d.f22248a;
        com.bytedance.android.monitorV2.event.a r120 = (com.bytedance.android.monitorV2.event.a) r15;
        String r30 = "";
        String r31 = "custom_bid";
        String r32 = "default_bid";
        if (StringsKt.isBlank("") == true) goto L61;
    L72:
        String r33 = "default_bid";
    L74:
        if (StringsKt.isBlank(r30) == false) goto L76;
        r30 = r16.f;
    L78:
        if (StringsKt.isBlank(r30) == false) goto L88;
        ConcurrentHashMap r34 = r16.f3698m.f3652a;
        String r35 = String.valueOf(r34.get("schema"));
        String r121 = r16.f3696k;
        if (r121 != null) goto L82;
    L83:
        r121 = String.valueOf(r34.get("url"));
    L84:
        k5.a r36 = k5.e.d.a(r121, r35);
        if (r36.a() == false) goto L88;
        r30 = r36.f18595a;
        r20 = r36.f18596b;
        goto L88
    L82:
        if (StringsKt.isBlank(r121) == false) goto L84;
    L88:
        if (StringsKt.isBlank(r30) == false) goto L90;
        r30 = (String) r16.f3692c.f3688c.f12569c;
    L92:
        if (StringsKt.isBlank(r30) == true) goto L94;
    L101:
        r31 = r19;
    L103:
        if (StringsKt.isBlank(r30) == false) goto L105;
        r30 = "__hybrid_default";
    L106:
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r13.f3561i = r30;
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        r13.f3562j = r32;
        ArrayList r37 = k5.h.f18618a;
        Intrinsics.checkNotNullParameter(r30, "bid");
        u4.d.a(r120, (String) new Triple(r30, r32, com.bytedance.android.monitorV2.h.e().a().a().f(r30)).getFirst());
        return;
    L105:
        r32 = r31;
        goto L106
    L94:
        if ((r13 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L101;
        x4.c r122 = ((com.bytedance.android.monitorV2.event.b) r13).f3553m;
        String r38 = r122.f22948b;
        if (r38 == null) goto L101;
        if (r38.length() == 0) goto L101;
        r30 = r122.f22948b;
        goto L103
    L90:
        r19 = r20;
        goto L92
    L76:
        r20 = r33;
        goto L78
    L61:
        if ((r13 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L72;
        x4.c r39 = ((com.bytedance.android.monitorV2.event.b) r13).f3553m;
        String r40 = r39.f22948b;
        if (r40 == null) goto L72;
        if (r40.length() == 0) goto L72;
        String r41 = r39.f22951i;
        if (r41 != null) goto L70;
    L71:
        r30 = r39.f22948b;
        r33 = "custom_bid";
        goto L74
    L70:
        if (r41.length() != 0) goto L72;
    L108:
        com.bytedance.android.monitorV2.dataprocessor.b r42 = com.bytedance.android.monitorV2.c.f3517a;
        com.bytedance.android.monitorV2.event.a r123 = (com.bytedance.android.monitorV2.event.a) r15;
        com.bytedance.android.monitorV2.c.b(r123, Boolean.FALSE);
        if (CollectionsKt.listOf(new String[]{"js_exception", "static", "nativeError"}).contains(r123.f3557a) == false) goto L112;
        JSONObject r43 = new JSONObject();
        r43.put("session_id", r123.f3559c);
        r43.put("event_type", r123.f3557a);
        r43.put("url", r16.f3696k);
        d5.b.f("LynxEventHandler", r43.toString());
    L112:
        if (Intrinsics.areEqual(r123.f3557a, "navigationStart") == false) goto L134;
        ((g5.b) r16.f3692c.f3691j.getValue()).getClass();
        return;
    L134:
        return;
    L116:
        if ((r15 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L135;
        com.bytedance.android.monitorV2.event.b r124 = (com.bytedance.android.monitorV2.event.b) r15;
        x4.c r44 = r124.f3553m;
        String r45 = r44.f22952j;
        if (r45 != null) goto L120;
    L123:
        String r46 = r11.f;
    L124:
        r44.f22952j = r46;
        String r47 = r44.f22947a;
        if (r47 != null) goto L127;
    L130:
        String r125 = r16.f3696k;
    L131:
        r44.f22947a = r125;
        qo.a.e(3, WsConstants.KEY_PLATFORM, r44.f22950h);
        com.bytedance.android.monitorV2.dataprocessor.b r126 = com.bytedance.android.monitorV2.c.f3517a;
        com.bytedance.android.monitorV2.c.d(r124, Boolean.FALSE);
        return;
    L127:
        if (r47.length() == 0) goto L130;
        r125 = r44.f22947a;
        goto L131
    L120:
        if (r45.length() == 0) goto L123;
        r46 = r44.f22952j;
        goto L124
    L135:
        return;
    L136:
        return;
    }
}
