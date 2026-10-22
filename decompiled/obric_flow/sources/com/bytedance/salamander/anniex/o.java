package com.bytedance.salamander.anniex;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.rts.foundation.RTSArrayKt;
import com.bytedance.rts.foundation.RTSMapKt;
import com.bytedance.salamander.adapter.Lock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f7270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f7271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ContainerType f7272c;

    public o() {
        Intrinsics.checkNotNullParameter("dummy", "sessionId");
        j r5 = new j();
        this.f7270a = r5;
        this.f7271b = new m();
        Intrinsics.checkNotNullParameter("bullet_custom_bid", "containerBid");
        Intrinsics.checkNotNullParameter("bullet_custom_bid", "<set-?>");
        this.f7272c = ContainerType.f7214a;
        Intrinsics.checkNotNullParameter("dummy", "<set-?>");
        r5.f7259c = "dummy";
    }

    public final void a() {
        Map r5 = RTSMapKt.RTSMap();
        RTSMapKt.set(r5, "errorCode", -1);
        RTSMapKt.set(r5, "errorMessage", MessageIndication.STATUS_FAILED);
        Lock r10 = q.d;
        p.a().getClass();
        a.b("SLAnnieXMonitor", "collectJSBaseField: monitor is disabled. session_id: ".concat(this.f7270a.f7259c));
        RTSMapKt.set(r5, "errorMessage", "monitor is disabled");
    }

    public final void b(b0.c r14) {
        Map r5 = RTSMapKt.RTSMap();
        RTSMapKt.set(r5, "errorCode", -1);
        RTSMapKt.set(r5, "errorMessage", MessageIndication.STATUS_FAILED);
        d(SLEventType.f7229c);
        a.b("SLAnnieXMonitor", "reportJSException: monitor is disabled. session_id: ".concat(this.f7270a.f7259c));
        RTSMapKt.set(r5, "errorMessage", "monitor is disabled");
        ContainerType r10 = ContainerType.f7214a;
        String r11 = null;
        ContainerType r12 = this.f7272c;
        if (r12 != r10) goto L12;
        n r13 = (n) r14.f808b;
        if (r13 == null) goto L7;
        String r15 = r13.f7269c;
    L8:
        if (r15 != null) goto L12;
        RTSMapKt.set(r5, "errorCode", -3);
        RTSMapKt.set(r5, "errorMessage", "data can not be empty");
        return;
    L7:
        r15 = null;
    L12:
        if (r12 != ContainerType.f7215b) goto L20;
        jg.k r16 = (jg.k) r14.f809c;
        if (r16 == null) goto L16;
        String r17 = (String) r16.f18339b;
    L17:
        if (r17 != null) goto L20;
        RTSMapKt.set(r5, "errorCode", -3);
        RTSMapKt.set(r5, "errorMessage", "rawMessage can not be empty");
        return;
    L16:
        r17 = null;
    L20:
        jg.k r18 = (jg.k) r14.f809c;
        if (r18 == null) goto L23;
        String r19 = (String) r18.f18339b;
    L25:
        if (r19 == null) goto L34;
        if (r18 == null) goto L28;
        String r20 = (String) r18.f18339b;
    L29:
        Intrinsics.checkNotNull(r20);
        b0 r21 = c.f7248a.b(r20, "js_exception_js_info_exception");
        ValidateResultCode r22 = ValidateResultCode.d;
        ValidateResultCode r23 = (ValidateResultCode) r21.f7247c;
        if (r23 != r22) goto L34;
        RTSMapKt.set(r5, "errorCode", Long.valueOf(r23.f7234a));
        RTSMapKt.set(r5, "errorMessage", "JSON.string(rawMessage) length must <= " + r21.f7246b);
        Object r24 = r21.d;
        if (r24 == null) goto L34;
        jg.k r25 = (jg.k) r14.f809c;
        Intrinsics.checkNotNull(r25);
        Intrinsics.checkNotNull(r24);
        String r26 = (String) r24;
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        r25.f18339b = r26;
        goto L34
    L28:
        r20 = null;
    L34:
        n r27 = (n) r14.f808b;
        if (r27 == null) goto L37;
        String r28 = r27.f7269c;
    L38:
        if (r28 == null) goto L46;
        if (r27 == null) goto L41;
        r11 = r27.f7269c;
    L41:
        Intrinsics.checkNotNull(r11);
        b0 r29 = c.f7248a.b(r11, "js_exception_native_info_error_msg");
        ValidateResultCode r30 = ValidateResultCode.d;
        ValidateResultCode r31 = (ValidateResultCode) r29.f7247c;
        if (r31 != r30) goto L46;
        RTSMapKt.set(r5, "errorCode", Long.valueOf(r31.f7234a));
        RTSMapKt.set(r5, "errorMessage", "JSON.stringify(data).length must <= " + r29.f7246b);
        Object r32 = r29.d;
        if (r32 == null) goto L46;
        n r33 = (n) r14.f808b;
        Intrinsics.checkNotNull(r33);
        Intrinsics.checkNotNull(r32);
        r33.f7269c = (String) r32;
    L46:
        String r34 = (String) r14.d;
        if (r34 == null) goto L53;
        v r35 = c.f7248a;
        Intrinsics.checkNotNull(r34);
        b0 r36 = r35.b(r34, "js_exception_root_cause");
        ValidateResultCode r37 = ValidateResultCode.d;
        ValidateResultCode r38 = (ValidateResultCode) r36.f7247c;
        if (r38 != r37) goto L53;
        RTSMapKt.set(r5, "errorCode", Long.valueOf(r38.f7234a));
        RTSMapKt.set(r5, "errorMessage", "root_cause.length must < " + r36.f7246b);
        Object r39 = r36.d;
        if (r39 == null) goto L53;
        Intrinsics.checkNotNull(r39);
        r14.d = (String) r39;
    L53:
        Map r40 = (Map) r14.e;
        if (r40 == null) goto L68;
        Intrinsics.checkNotNull(r40);
        Intrinsics.checkNotNull(r40);
        if (RTSArrayKt.getLength(RTSMapKt.keys(r40)) <= 20) goto L58;
        RTSMapKt.set(r5, "errorCode", -3);
        RTSMapKt.set(r5, "errorMessage", "size of property in context must <= 20");
    L58:
        ArrayList r41 = RTSMapKt.keys(r40);
        int r42 = 0;
    L60:
        if (r42 >= RTSArrayKt.getLength(r41)) goto L68;
        String r43 = (String) r41.get(r42);
        String r44 = (String) r40.get(r43);
        v r45 = c.f7248a;
        b0 r46 = r45.b(r43, "js_base_context_key");
        ValidateResultCode r110 = ValidateResultCode.d;
        ValidateResultCode r111 = (ValidateResultCode) r46.f7247c;
        if (r111 != r110) goto L64;
        RTSMapKt.set(r5, "errorCode", Long.valueOf(r111.f7234a));
        RTSMapKt.set(r5, "errorMessage", "property with the longest key in the context must <= " + r46.f7246b);
    L64:
        Intrinsics.checkNotNull(r44);
        b0 r47 = r45.b(r44, "js_base_context_value");
        ValidateResultCode r48 = (ValidateResultCode) r47.f7247c;
        if (r48 != r110) goto L67;
        RTSMapKt.set(r5, "errorCode", Long.valueOf(r48.f7234a));
        RTSMapKt.set(r5, "errorMessage", "property with the longest value in the context must <= " + r47.f7246b);
    L67:
        r42 = r42 + 1;
    L68:
        t r49 = new t();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r49.f7278c = r14;
        g(r49, new SLAnnieXMonitor$doReportJSException$2(r49));
        RTSMapKt.set(r5, "errorCode", 1);
        RTSMapKt.set(r5, "errorMessage", "Success");
        return;
    L37:
        r28 = null;
        goto L38
    L23:
        r19 = null;
        goto L25
    }

    public final void c(AccessLayerStringField r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "field");
        Intrinsics.checkNotNullParameter(r10, "value");
        Lock r11 = q.d;
        p.a().getClass();
        a.b("SLAnnieXMonitor", "collectContainerBaseStringField: monitor is disabled. session_id: ".concat(this.f7270a.f7259c));
    }

    public final void d(SLEventType r5) {
        int r10 = r5.ordinal();
        ContainerType r11 = this.f7272c;
        if (r10 == 0) goto L42;
        if (r10 == 1) goto L34;
        if (r10 == 2) goto L26;
        if (r10 == 3) goto L18;
        if (r10 == 4) goto L14;
    L45:
        Lock r12 = q.d;
        p.a().getClass();
        return;
    L14:
        if (r11 != ContainerType.f7214a) goto L16;
        boolean r13 = y.f.f7282a;
        goto L45
    L16:
        boolean r14 = y.f7285c.f7282a;
        goto L45
    L18:
        if (r11 != ContainerType.f7214a) goto L23;
        if (y.f.f7282a == false) goto L45;
        boolean r15 = y.f7286h.f7282a;
        goto L45
    L23:
        if (y.f7285c.f7282a == false) goto L45;
        boolean r16 = y.e.f7282a;
        goto L45
    L26:
        if (r11 != ContainerType.f7214a) goto L31;
        if (y.f.f7282a == false) goto L45;
        boolean r17 = y.f7286h.f7282a;
        goto L45
    L31:
        if (y.f7285c.f7282a == false) goto L45;
        boolean r18 = y.e.f7282a;
        goto L45
    L34:
        if (r11 != ContainerType.f7214a) goto L39;
        if (y.f.f7282a == false) goto L45;
        boolean r19 = y.g.f7282a;
        goto L45
    L39:
        if (y.f7285c.f7282a == false) goto L45;
        boolean r20 = y.d.f7282a;
        goto L45
    L42:
        if (r11 != ContainerType.f7214a) goto L44;
        boolean r21 = y.f.f7282a;
        goto L45
    L44:
        boolean r22 = y.f7285c.f7282a;
        goto L45
    }

    public final void e(final r r5) {
        Intrinsics.checkNotNullParameter(r5, "jsbErrorEventInfo");
        a0 r10 = a0.f7242b;
        z.a().a(new SLAnnieXMonitor$reportJSBError$1(this, r5));
    }

    public final void f(final s r5) {
        Intrinsics.checkNotNullParameter(r5, "jsbPerfEventInfo");
        a0 r10 = a0.f7242b;
        z.a().a(new SLAnnieXMonitor$reportJSBPerf$1(this, r5));
    }

    public final void g(t r13, Function0 r14) {
        j r5 = this.f7270a;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r13.f7276a = r5;
        m r12 = this.f7271b;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r13.f7277b = r12;
        String r15 = r5.f;
        boolean r10 = false;
        if (a.f7241a != null) goto L5;
        String r11 = d.f7251a.f();
        Intrinsics.checkNotNullParameter(r11, "jsonString");
        JSONObject r16 = new JSONObject(r11);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type org.json.JSONObject{ com.bytedance.salamander.anniex.AnniexMonitorFoundationInterfaceBasicTypeKt.AnnieXJSONObject }");
        Intrinsics.checkNotNullParameter(r16, "jsonObject");
        k r17 = new k();
        JSONObject r18 = b.b("data", r16, new JSONObject());
        Intrinsics.checkNotNullParameter(r18, "jsonObj");
        Intrinsics.checkNotNullParameter("update_time", STGroup.DICT_KEY);
        r18.optLong("update_time", 0);
        Intrinsics.checkNotNullParameter(r18, "jsonObj");
        Intrinsics.checkNotNullParameter("duration", STGroup.DICT_KEY);
        r18.optInt("duration", 0);
        Intrinsics.checkNotNullParameter(r18, "jsonObj");
        Intrinsics.checkNotNullParameter("setting_id", STGroup.DICT_KEY);
        r17.f7262b = r18.optLong("setting_id", 0);
        Intrinsics.checkNotNullParameter(r18, "jsonObj");
        Intrinsics.checkNotNullParameter("enable_switch", STGroup.DICT_KEY);
        long r19 = r18.optLong("enable_switch", 0);
        Map r20 = y.f7283a;
        x.b(r19);
        Intrinsics.checkNotNullParameter(g.b(b.b("all_event_sample", r18, new JSONObject())), "<set-?>");
        JSONObject r21 = b.b("bid_info", r18, new JSONObject());
        i r22 = g.a(r17.f7262b, r21);
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r17.f7261a = r22;
        a.f7241a = r17;
    L5:
        k r23 = a.f7241a;
        Intrinsics.checkNotNull(r23);
        h r110 = r23.f7261a.a(r15);
        long r24 = r110.f7254b;
        l r25 = r5.f7260h;
        r25.d = r24;
        r25.f7265c = r110.f7255c;
        String r26 = r110.f7253a;
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        r25.f7264b = r26;
        int r27 = r13.f7276a.d.ordinal();
        if (r27 != 0) goto L8;
        Intrinsics.checkNotNullParameter(SLEventType.f7229c, "eventType");
        Intrinsics.checkNotNullParameter(r110, "bidConfig");
        r10 = r110.e;
    L12:
        if (r10 == false) goto L15;
        ((SLAnnieXMonitor$doReportJSException$2) r14).invoke();
        return;
    L15:
        String r111 = " bid: ".concat(r5.f);
        String r112 = " session_id: ".concat(r5.f7259c);
        SLEventType r28 = SLEventType.f7229c;
        a.b("SLAnnieXMonitor", j0.l("assembleDataPreHandler: hitSample is false", " event_type: ".concat(a.a(r28)), r111, r112, " schema: ".concat("")));
        Lock r113 = q.d;
        ArrayList r114 = p.a().f7274b;
        if (RTSArrayKt.getLength(r114) <= 0) goto L22;
        a.a(r28);
        f.d(r13);
        Iterator r115 = r114.iterator();
        if (r115.hasNext() == true) goto L21;
        return;
    L21:
        throw mn.h.c(r115);
    L22:
        return;
    L8:
        if (r27 != 1) goto L12;
        Intrinsics.checkNotNullParameter(SLEventType.f7229c, "eventType");
        Intrinsics.checkNotNullParameter(r110, "bidConfig");
        r10 = r110.d;
        goto L12
    }

    public final void h(final u r5) {
        Intrinsics.checkNotNullParameter(r5, "errorParams");
        a0 r10 = a0.f7242b;
        z.a().a(new SLAnnieXMonitor$reportLynxJSException$1(r5, this));
    }

    public final void i(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMsgJsonString");
        a0 r10 = a0.f7242b;
        z.a().a(new SLAnnieXMonitor$reportWebJSException$1(r5, this));
    }

    public final void j(final LinkedHashMap r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        Function1<Boolean, Unit> r10 = new SLAnnieXMonitor$collectJSBaseField$task$1(this, r5);
        a0 r11 = a0.f7242b;
        z.a().a(r10);
    }
}
