package com.bytedance.android.monitorV2.webview;

import android.webkit.WebView;
import com.bytedance.common.wschannel.WsConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.bytedance.android.monitorV2.dataprocessor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f3773a;

    public e(f r5) {
        this.f3773a = r5;
    }

    @Override // com.bytedance.android.monitorV2.dataprocessor.a
    public final void a(Object r18) {
        Intrinsics.checkNotNullParameter(r18, "data");
        boolean r5 = r18 instanceof com.bytedance.android.monitorV2.event.a;
        f r10 = this.f3773a;
        String r11 = null;
        if (r5 == false) goto L43;
        com.bytedance.android.monitorV2.event.a r12 = (com.bytedance.android.monitorV2.event.a) r18;
        r10.getClass();
        r12.getClass();
        c r13 = r10.f3774a;
        sk.a.c(null, r13.f3754a.a(), r12.f);
        r12.f3560h = r13.f3757h;
        r12.g = qo.a.q(r12.g, r13.e);
        LinkedHashMap r14 = r12.e;
        r14.put("jsb_bid", r13.d);
        i r15 = r13.f3754a;
        b r16 = (b) r15.e.getValue();
        if (r16 == null) goto L7;
        String r17 = r16.d;
    L8:
        r14.put("config_bid", r17);
        r12.f3559c = r15.f3781c;
        r10.a(r12);
        if (Intrinsics.areEqual(r12.f3557a, "jsbPv") == false) goto L39;
        Method r19 = u4.d.f22248a;
        String r20 = "";
        StringsKt.isBlank("");
        String r110 = "default_bid";
        if (StringsKt.isBlank("") == false) goto L13;
        String r111 = r13.d;
        String r112 = "jsb_bid";
    L15:
        if (StringsKt.isBlank(r111) == false) goto L25;
        j5.b r113 = j5.b.f18235a;
        ConcurrentHashMap r114 = j5.b.c(r15.f3781c);
        String r115 = String.valueOf(r114.get("schema"));
        String r21 = r13.f3755b;
        if (r21 != null) goto L19;
    L20:
        r21 = String.valueOf(r114.get("url"));
    L21:
        k5.a r22 = k5.e.d.a(r21, r115);
        if (r22.a() == false) goto L25;
        r111 = r22.f18595a;
        r112 = r22.f18596b;
        goto L25
    L19:
        if (StringsKt.isBlank(r21) == false) goto L21;
    L25:
        if (StringsKt.isBlank(r111) == false) goto L34;
        b r23 = (b) r15.e.getValue();
        if (r23 == null) goto L29;
        String r24 = r23.d;
    L30:
        if (r24 == null) goto L33;
        r20 = r24;
    L33:
        r112 = "config_bid";
        r111 = r20;
        goto L34
    L29:
        r24 = null;
    L34:
        StringsKt.isBlank(r111);
        if (StringsKt.isBlank(r111) == false) goto L37;
        r111 = "__hybrid_default";
    L38:
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r12.f3561i = r111;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r12.f3562j = r110;
        ArrayList r25 = k5.h.f18618a;
        Intrinsics.checkNotNullParameter(r111, "bid");
        u4.d.a(r12, (String) new Triple(r111, r110, com.bytedance.android.monitorV2.h.e().a().a().f(r111)).getFirst());
        goto L43
    L37:
        r110 = r112;
        goto L38
    L13:
        r111 = "";
        r112 = "default_bid";
        goto L15
    L39:
        com.bytedance.android.monitorV2.dataprocessor.b r26 = com.bytedance.android.monitorV2.c.f3517a;
        b r27 = (b) r15.e.getValue();
        com.bytedance.android.monitorV2.c.b(r12, Boolean.FALSE);
        if (CollectionsKt.listOf(new String[]{"js_exception", "static", "nativeError"}).contains(r12.f3557a) == false) goto L43;
        JSONObject r28 = new JSONObject();
        r28.put("session_id", r12.f3559c);
        r28.put("event_type", r12.f3557a);
        r28.put("url", r13.f3755b);
        d5.b.f("WebDataHandler", r28.toString());
        goto L43
    L7:
        r17 = null;
    L43:
        if ((r18 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L58;
        com.bytedance.android.monitorV2.event.b r29 = (com.bytedance.android.monitorV2.event.b) r18;
        r10.getClass();
        r29.getClass();
        c r30 = r10.f3774a;
        b r31 = (b) r30.f3754a.e.getValue();
        String r32 = r30.f3755b;
        x4.c r33 = r29.f3553m;
        JSONObject r34 = r33.f22950h;
        JSONObject r116 = r30.e;
        qo.a.t("virtual_aid", null, r34);
        qo.a.e(0, WsConstants.KEY_PLATFORM, r34);
        i r35 = r30.f3754a;
        WebView r117 = r35.a();
        m5.b r118 = r30.g;
        sk.a.c(null, r117, r118);
        WebView r119 = r35.a();
        if (r119 == null) goto L47;
        x4.a r120 = j5.b.g(r119);
    L48:
        String r121 = r33.f22947a;
        if (r121 != null) goto L51;
    L52:
        r33.f22947a = r32;
    L53:
        r29.g = r116;
        qo.a.m(r118.g, r29.f.g);
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r29.f = r118;
        r29.f3560h = r120;
        LinkedHashMap r36 = r29.e;
        r36.put("jsb_bid", r30.d);
        b r37 = (b) r35.e.getValue();
        if (r37 == null) goto L56;
        r11 = r37.d;
    L56:
        r36.put("config_bid", r11);
        r29.f3559c = r35.f3781c;
        r10.a(r29);
        com.bytedance.android.monitorV2.dataprocessor.b r38 = com.bytedance.android.monitorV2.c.f3517a;
        com.bytedance.android.monitorV2.c.d(r29, Boolean.FALSE);
        return;
    L51:
        if (r121.length() != 0) goto L53;
    L47:
        r120 = null;
        goto L48
    }
}
