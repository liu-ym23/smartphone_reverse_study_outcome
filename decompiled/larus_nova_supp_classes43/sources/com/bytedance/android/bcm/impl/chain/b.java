package com.bytedance.android.bcm.impl.chain;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bcm.impl.config.BcmConfig;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends kc.a.C0174a {
    public static final /* synthetic */ int j = 0;
    public JSONObject h;
    public JSONObject i;

    public static final class a {
        public static b a(kc.a.C0174a r10) {
            b r0 = new b();
            r0.c = r10.c;
            r0.e = r10.e;
            r0.f = r10.f;
            BcmConfig.a();
            List r1 = BcmConfig.a.c();
            kc.a.C0174a.C0175a r11 = r10.g;
            if (r11 == null) goto L17;
            BcmParams r12 = r11.a;
            if (r12 == null) goto L17;
            Map<String, Object> r13 = r12.toMap();
            if (r13 == null) goto L17;
            LinkedHashMap r14 = new LinkedHashMap();
            Iterator<Map.Entry<String, Object>> r15 = r13.entrySet().iterator();
        L10:
            if (r15.hasNext() == false) goto L15;
            Map.Entry<String, Object> r16 = r15.next();
            if (r1.contains(r16.getKey()) == false) goto L10;
            r14.put(r16.getKey(), r16.getValue());
            goto L10
        L15:
            if ((!r14.isEmpty()) == false) goto L17;
            r0.h = cd.a.a(r14);
        L17:
            kc.a.C0174a.C0175a r17 = r10.g;
            if (r17 == null) goto L32;
            BcmParams r18 = r17.b;
            if (r18 == null) goto L32;
            Map<String, Object> r19 = r18.toMap();
            if (r19 == null) goto L32;
            LinkedHashMap r20 = new LinkedHashMap();
            Iterator<Map.Entry<String, Object>> r21 = r19.entrySet().iterator();
        L25:
            if (r21.hasNext() == false) goto L30;
            Map.Entry<String, Object> r22 = r21.next();
            if (r1.contains(r22.getKey()) == false) goto L25;
            r20.put(r22.getKey(), r22.getValue());
            goto L25
        L30:
            if ((!r20.isEmpty()) == false) goto L32;
            r0.i = cd.a.a(r20);
        L32:
            return r0;
        }
    }

    static {
    }

    @Override // kc.a.C0174a
    public final JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("btm", this.c);     // Catch: Throwable -> L13
        r0.put("btm_show_id", this.e);     // Catch: Throwable -> L13
        if (this.h == null) goto L6;
    L7:
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L13
        r10.put(AIStateLogRequest.SOURCE_PAGE, this.h);     // Catch: Throwable -> L12
        r10.put("unit", this.i);     // Catch: Throwable -> L12
    L9:
        r0.put("content", r10);     // Catch: Throwable -> L13
    L10:
        r0.put("jump_with_token", this.f);     // Catch: Throwable -> L13
        goto L11
    L6:
        if (this.i == null) goto L10;
    L11:
        return r0;
    }

    public b() {
    }
}
