package com.bytedance.android.livesdk.jsbridge.methods;

import android.os.Bundle;
import com.bytedance.android.livesdk.config.tj;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i2 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final CompositeDisposable a;

    public final void onTerminate() {
        this.a.clear();
    }

    public i2() {
        this.a = new CompositeDisposable();
    }

    public final void invoke(Object r9, CallContext r10) throws Exception {
        JSONObject r11 = (JSONObject) r9;
        if (r11 != null) goto L5;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "ocr service proxy is unavaliable"));
        return;
    L5:
        Bundle r0 = new Bundle();
        Iterator<String> r1 = r11.keys();
        v80.d.a r2 = new v80.d.a();
        r2.a = r10.getContext();
        ((com.bytedance.android.livesdk.model.n) tj.a.getValue()).getClass();
        HashMap r13 = null;
    L6:
        byte r4 = 1;
        if (r1.hasNext() == false) goto L95;
        String r3 = r1.next();
        Object r5 = r11.opt(r3);
        r3.getClass();
        switch(r3.hashCode()) {
            case -1405651851: goto L67;
            case -995427962: goto L64;
            case -818786127: goto L60;
            case -714207650: goto L56;
            case -419323305: goto L52;
            case 3146030: goto L48;
            case 182018955: goto L44;
            case 494495645: goto L40;
            case 562019534: goto L36;
            case 562334060: goto L32;
            case 678323412: goto L28;
            case 838006421: goto L24;
            case 924324347: goto L20;
            case 1125349443: goto L16;
            case 1969256807: goto L12;
            default: goto L10;
        };
    L10:
        r4 = -1;
    L70:
        switch(r4) {
            case 0: goto L94;
            case 1: goto L92;
            case 2: goto L90;
            case 3: goto L89;
            case 4: goto L88;
            case 5: goto L87;
            case 6: goto L86;
            case 7: goto L85;
            case 8: goto L84;
            case 9: goto L83;
            case 10: goto L82;
            case 11: goto L81;
            case 12: goto L76;
            case 13: goto L75;
            case 14: goto L74;
            default: goto L71;
        };
    L74:
        r2.i = ((Boolean) r5).booleanValue();
        goto L6
    L75:
        r2.l = (String) r5;
        goto L6
    L76:
        HashMap r6 = new HashMap();
        JSONObject r7 = (JSONObject) r5;
        Iterator<String> r8 = r7.keys();
    L78:
        if (r8.hasNext() == false) goto L80;
        String r14 = r8.next();
        r6.put(r14, r7.optString(r14));
        goto L78
    L80:
        r2.n = r6;
        goto L6
    L81:
        String r15 = (String) r5;
        goto L6
    L82:
        r0.putString(r3, (String) r5);
        goto L6
    L83:
        r2.f = (String) r5;
        goto L6
    L84:
        r2.e = (String) r5;
        goto L6
    L85:
        ((Integer) r5).intValue();
        goto L6
    L86:
        ((Integer) r5).intValue();
        r0.putString(r3, String.valueOf(r5));
        goto L6
    L87:
        r2.m = (String) r5;
        goto L6
    L88:
        r0.putString(r3, (String) r5);
        goto L6
    L89:
        String r16 = (String) r5;
        goto L6
    L90:
        r2.h = (String) r5;
        r2.g = "recharge".equals(r5);
        goto L6
    L92:
        if ((r5 instanceof JSONObject) == false) goto L6;
        JSONObject r17 = (JSONObject) r5;
        String r18 = r17.optString("ticket");
        String r19 = r17.optString("scene");
        String r20 = r17.optString("mode");
        r2.c = r18;
        r2.b = r19;
        r2.d = r20;
        goto L6
    L94:
        r2.j = String.valueOf(r5);
        goto L6
    L71:
        if (r13 != null) goto L73;
        r13 = new HashMap();
    L73:
        r13.put(r3, String.valueOf(r5));
        goto L6
    L12:
        if (r3.equals("skip_record_verify") == false) goto L10;
        r4 = 14;
        goto L70
    L16:
        if (r3.equals("use_new_api") == false) goto L10;
        r4 = 13;
        goto L70
    L20:
        if (r3.equals("api_request_params") == false) goto L10;
        r4 = 12;
        goto L70
    L24:
        if (r3.equals("byte_scene") == false) goto L10;
        r4 = 11;
        goto L70
    L28:
        if (r3.equals("verified_page_source") == false) goto L10;
        r4 = 10;
        goto L70
    L32:
        if (r3.equals("identity_name") == false) goto L10;
        r4 = 9;
        goto L70
    L36:
        if (r3.equals("identity_code") == false) goto L10;
        r4 = 8;
        goto L70
    L40:
        if (r3.equals("youth_cert_scene") == false) goto L10;
        r4 = 7;
        goto L70
    L44:
        if (r3.equals("age_larger_14") == false) goto L10;
        r4 = 6;
        goto L70
    L48:
        if (r3.equals("flow") == false) goto L10;
        r4 = 5;
        goto L70
    L52:
        if (r3.equals("conversation_id") == false) goto L10;
        r4 = 4;
        goto L70
    L56:
        if (r3.equals("children_cert_token") == false) goto L10;
        r4 = 3;
        goto L70
    L60:
        if (r3.equals("enter_from") == false) goto L10;
        r4 = 2;
        goto L70
    L64:
        if (r3.equals("params") == true) goto L70;
    L67:
        if (r3.equals("cert_type") == false) goto L10;
        r4 = 0;
        goto L70
    L95:
        if (r13 == null) goto L97;
        r2.o = r13;
    L97:
        r2.k = new h2(this);
        v80.d r21 = new v80.d(r2);
        x80.c.a(1).a.a(r21);
    }
}
