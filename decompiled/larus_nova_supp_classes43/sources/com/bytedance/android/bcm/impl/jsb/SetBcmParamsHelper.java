package com.bytedance.android.bcm.impl.jsb;

import com.bytedance.android.bcm.api.b;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SetBcmParamsHelper {
    static {
    }

    public static boolean a(PageFinder r10, final Map r11) {
        ALogger.c(ALogger.d, "FE_setBcmParams", new SetBcmParamsHelper$handle$1(r11));
        if (r10.isEmpty() == false) goto L5;
        return false;
    L5:
        Object r0 = r11.get("param_type");
        Object r12 = null;
        if ((r0 instanceof String) == true) goto L8;
        r0 = null;
    L8:
        String r1 = (String) r0;
        Object r13 = r11.get("update_type");
        if ((r13 instanceof String) == true) goto L11;
        r13 = null;
    L11:
        String r14 = (String) r13;
        Object r15 = r11.get("content");
        if ((r15 instanceof Map) == false) goto L15;
        r12 = r15;
    L15:
        Map r16 = (Map) r12;
        if (r1 != null) goto L18;
    L21:
        boolean r17 = true;
    L22:
        if (r17 == true) goto L54;
        if (r14 != null) goto L25;
    L28:
        boolean r18 = true;
    L29:
        if (r18 == true) goto L54;
        if (r16 != null) goto L32;
    L35:
        boolean r19 = true;
    L36:
        if (r19 == true) goto L54;
        boolean r20 = Intrinsics.areEqual(r1, "unit");
        boolean r21 = Intrinsics.areEqual(r14, "append");
        JSONObject r22 = new JSONObject(r16);     // Catch: Exception -> L52
        Iterator<String> r23 = r22.keys();     // Catch: Exception -> L52
    L40:
        if (r23.hasNext() == false) goto L51;
        String r24 = r23.next().toString();     // Catch: Exception -> L52
        JSONObject r25 = r22.optJSONObject(r24);     // Catch: Exception -> L52
        if (r20 == true) goto L44;
        if (r21 == true) goto L48;
        b.e(r10, r24, new BcmParams().merge(r25));     // Catch: Exception -> L52
        goto L40
    L48:
        b.a.appendPageParams(r10, r24, new BcmParams().merge(r25));     // Catch: Exception -> L52
        goto L40
    L44:
        if (r21 == true) goto L45;
        b.a.setUnitParams(r10, r24, new BcmParams().merge(r25));     // Catch: Exception -> L52
        goto L40
    L45:
        b.a.appendUnitParams(r10, r24, new BcmParams().merge(r25));     // Catch: Exception -> L52
        goto L40
    L51:
        return true;
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L54
    L32:
        if (r16.isEmpty() == true) goto L35;
        r19 = false;
        goto L36
    L25:
        if (r14.length() == 0) goto L28;
        r18 = false;
    L54:
        return false;
    L18:
        if (r1.length() == 0) goto L21;
        r17 = false;
        goto L22
    }

    public static boolean b(PageFinder r10, final Map r11) {
        ALogger.c(ALogger.d, "FE_setBcmParams", new SetBcmParamsHelper$handleV2$1(r11));
        if (r10.isEmpty() == false) goto L5;
        return false;
    L5:
        Object r0 = r11.get("bcm");
        Object r12 = r11.get("clear_old_value");
        if ((r12 instanceof Boolean) == true) goto L8;
        r12 = null;
    L8:
        Boolean r13 = (Boolean) r12;
        if (r13 == null) goto L11;
        boolean r14 = r13.booleanValue();
    L13:
        if ((r0 instanceof Map) == true) goto L15;
        Object r15 = null;
    L16:
        Map<String, ? extends Object> r16 = (Map) r15;
        if (r16 == null) goto L21;
        BcmParams r17 = new BcmParams().merge(r16);
        if (r17 == null) goto L21;
    L35:
        if (r14 == false) goto L30;
        b.e(r10, "ecom_entrance", r17);     // Catch: Exception -> L28
    L34:
        return true;
    L30:
        b.a.appendPageParams(r10, "ecom_entrance", r17);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
        return false;
    L21:
        BcmParams r18 = new BcmParams();
        if ((r0 instanceof JSONObject) == true) goto L24;
        r0 = null;
    L24:
        r17 = r18.merge((JSONObject) r0);
        goto L35
    L15:
        r15 = r0;
        goto L16
    L11:
        r14 = true;
        goto L13
    }
}
