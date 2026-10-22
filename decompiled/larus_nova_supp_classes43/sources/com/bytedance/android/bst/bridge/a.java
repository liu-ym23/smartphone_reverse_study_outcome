package com.bytedance.android.bst.bridge;

import android.view.View;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.bst.api.lynx.JsBridgeExposureData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uc.c;
import yc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(JSONObject r13, View r14, Function3 r15) {
        if (r14 != null) goto L6;
        ExtKt.b("JsBridgeProvider", "sendBstExposure view is null!");
        r15.invoke(Boolean.FALSE, new LinkedHashMap(), "native view is null");
        return;
    L6:
        boolean r16 = true;
        JSONObject r10 = new JSONObject(JSONObjectProtectorUtils.getString(r13, "bst_data"));     // Catch: Exception -> L46
        String r11 = r10.optString("btm", "");     // Catch: Exception -> L46
        int r12 = r10.optInt("unique_id", 0);     // Catch: Exception -> L46
        String r17 = r10.optString("biz", "");     // Catch: Exception -> L46
        String r18 = r10.optString("model", "");     // Catch: Exception -> L46
        JSONObject r19 = r10.optJSONObject("extra_info");     // Catch: Exception -> L46
        int r110 = r10.optInt("exposure_repeatedly", 0);     // Catch: Exception -> L46
        String r111 = r10.optString("event_name", "");     // Catch: Exception -> L46
        Object r20 = r10.opt("card_id");     // Catch: Exception -> L46
        if (r20 == null) goto L12;
        String r21 = r20.toString();     // Catch: Exception -> L46
        if (r21 == null) goto L12;
        String r22 = r21;
    L14:
        if (r11.length() != 0) goto L16;
        boolean r23 = true;
    L17:
        if (r23 == true) goto L31;
        if (r12 <= 0) goto L31;
        if (r17.length() != 0) goto L22;
        boolean r24 = true;
    L23:
        if (r24 == true) goto L31;
        if (r18.length() != 0) goto L27;
        boolean r25 = true;
    L28:
        if (r25 == true) goto L31;
        if (r19 == null) goto L31;
        boolean r26 = true;
    L54:
        ExtKt.b("JsBridgeProvider", "isAvailable: " + r26);     // Catch: Exception -> L44
        if (r26 == true) goto L35;
    L48:
        if (r26 == false) goto L50;
        r15.invoke(Boolean.TRUE, new LinkedHashMap(), "");
        return;
    L50:
        r15.invoke(Boolean.FALSE, new LinkedHashMap(), "data is illegal");
        return;
    L35:
        if (r110 != 1) goto L37;
        boolean r112 = true;
    L38:
        if (r19 != null) goto L40;
        Intrinsics.throwNpe();     // Catch: Exception -> L44
    L40:
        new JsBridgeExposureData(r11, r12, r22, r17, r18, r112, r111, r19);     // Catch: Exception -> L44
        c r113 = (c) b.a(c.class);     // Catch: Exception -> L44
        if (r113 == null) goto L48;
        r113.a();     // Catch: Exception -> L44
        goto L48
    L37:
        r112 = false;
    L44:
        e = e;
        r16 = r26;
    L47:
        ExtKt.b("JsBridgeProvider", ExtKt.c(e));
        r26 = r16;
        goto L48
    L27:
        r25 = false;
        goto L28
    L22:
        r24 = false;
    L31:
        r26 = false;
        goto L54
    L16:
        r23 = false;
    L12:
        r22 = "";
    L46:
        e = e;
        goto L47
    }
}
