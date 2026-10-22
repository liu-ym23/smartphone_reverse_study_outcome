package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.base.LinkInternalServiceContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "updateLinkmicSettingsSucceed")
public final class k1 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    public static final class a {
    }

    static {
    }

    public k1() {
    }

    public final Object invoke(Object r13, CallContext r14) {
        JSONObject r15 = (JSONObject) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        ALogger.i("ttlive_link_paid", "UpdateLinkMicSettingsMethod " + r15);
        int r2 = 0;
        int r3 = 0;
        boolean r4 = true;
        if (r15.has(String.valueOf(41)) == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.c.q0;
        Integer r16 = Integer.valueOf(r15.optInt(String.valueOf(41)));
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r16);
        boolean r17 = true;
    L7:
        if (r15.has(String.valueOf(42)) == false) goto L10;
        com.bytedance.android.livesdk.sharedpref.e r18 = com.bytedance.android.livesdk.sharedpref.c.T0;
        Integer r5 = Integer.valueOf(r15.optInt(String.valueOf(42)));
        r18.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r18, r5);
        r17 = true;
    L10:
        if (r15.has(String.valueOf(51)) == false) goto L13;
        com.bytedance.android.livesdk.sharedpref.e r19 = com.bytedance.android.livesdk.sharedpref.c.r;
        Integer r6 = Integer.valueOf(r15.optInt(String.valueOf(51)));
        r19.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r19, r6);
        r17 = true;
    L13:
        if (r15.has("application_reason_template") == false) goto L16;
        com.bytedance.android.livesdk.sharedpref.e r110 = com.bytedance.android.livesdk.sharedpref.c.s;
        String r7 = r15.optString("application_reason_template");
        r110.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r110, r7);
        r17 = true;
    L16:
        if (r15.has(String.valueOf(43)) == false) goto L18;
        com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.c.w;
        Integer r9 = Integer.valueOf(r15.optInt(String.valueOf(43)));
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, r9);
        boolean r10 = true;
    L20:
        if (r15.has(String.valueOf(44)) == false) goto L23;
        com.bytedance.android.livesdk.sharedpref.d.o(r15.optInt(String.valueOf(44)));
        r10 = true;
    L23:
        if (r15.has(String.valueOf(66)) == false) goto L46;
        JSONObject r111 = r15.optJSONObject(String.valueOf(66));
        if (fj0.e.i() == false) goto L27;
        fj0.b.d(fj0.b.b);
        fj0.a r11 = fj0.b.a;
        r11.getClass();
        r11.e = System.currentTimeMillis();
    L27:
        if (r111 != null) goto L29;
    L44:
        r17 = true;
        goto L46
    L29:
        if ((r111.get("paid_count") instanceof Integer) == false) goto L35;
        Object r12 = r111.get("paid_count");
        if (r12 == null) goto L34;
        int r20 = ((Integer) r12).intValue();
    L36:
        com.bytedance.android.livesdk.sharedpref.d.k(r20);
        if ((r111.get("limited_time") instanceof Integer) == false) goto L43;
        Object r112 = r111.get("limited_time");
        if (r112 == null) goto L42;
        r2 = ((Integer) r112).intValue();
        goto L43
    L42:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L43:
        com.bytedance.android.livesdk.sharedpref.d.g(r2);
        goto L44
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L35:
        r20 = 0;
    L46:
        if (r15.has(String.valueOf(63)) == false) goto L70;
        JSONObject r21 = r15.optJSONObject(String.valueOf(63));
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L51;
        fj0.b.d(fj0.b.b);
        fj0.a r22 = fj0.b.a;
        r22.getClass();
        r22.e = System.currentTimeMillis();
    L51:
        if (fj0.e.l() == false) goto L53;
        fj0.b.d(fj0.b.b);
        fj0.a r23 = fj0.b.a;
        r23.getClass();
        r23.e = System.currentTimeMillis();
    L53:
        if (r21 == null) goto L71;
        com.bytedance.android.livesdk.sharedpref.e r24 = com.bytedance.android.livesdk.sharedpref.c.u;
        if ((r21.get("paid_count") instanceof Integer) == false) goto L61;
        Object r25 = r21.get("paid_count");
        if (r25 == null) goto L60;
        Integer r26 = (Integer) r25;
    L62:
        r24.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r24, r26);
        com.bytedance.android.livesdk.sharedpref.e r27 = com.bytedance.android.livesdk.sharedpref.c.v;
        if ((r21.get("limited_time") instanceof Integer) == false) goto L69;
        Object r28 = r21.get("limited_time");
        if (r28 == null) goto L68;
        r3 = (Integer) r28;
        goto L69
    L68:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L69:
        r27.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r27, r3);
        goto L71
    L60:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L61:
        r26 = 0;
    L71:
        if (r17 == false) goto L77;
        LinkInternalServiceContext r113 = LinkInternalServiceContext.Companion.getContext();
        if (r113 == null) goto L77;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.api.data.a> r114 = r113.getPaidInteractAudienceConfig();
        if (r114 == null) goto L77;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r114.setValue(com.bytedance.android.live.liveinteract.api.data.a.C0017a.h());
    L77:
        if (r4 == false) goto L83;
        LinkInternalServiceContext r115 = LinkInternalServiceContext.Companion.getContext();
        if (r115 == null) goto L83;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.api.data.a> r116 = r115.getPaidVideoTalkConfig();
        if (r116 == null) goto L83;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r116.setValue(com.bytedance.android.live.liveinteract.api.data.a.C0017a.k());
    L83:
        int r117 = fj0.d.a;
        String r118 = r15.toString();
        Intrinsics.checkNotNullParameter(r118, "params");
        LinkedHashMap r119 = new LinkedHashMap();
        r119.put("params", r118);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("update_paid_link_setting", r119);
        return null;
    L70:
        r4 = r10;
        goto L71
    L18:
        r10 = false;
        goto L20
    L5:
        r17 = false;
        goto L7
    }
}
