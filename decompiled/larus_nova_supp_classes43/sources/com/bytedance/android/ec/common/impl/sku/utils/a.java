package com.bytedance.android.ec.common.impl.sku.utils;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.mt.protector.impl.UriProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    public static String a(String r10, ECAdLogExtra r11, ECAdInfo r12, boolean r13) {
        if (r10 != null) goto L4;
        return "";
    L4:
        String r0 = null;
        if (r11 != null) goto L7;
    L23:
        String r14 = r10;
    L24:
        if (r12 == null) goto L52;
        String r15 = UriProtector.getQueryParameter(UriProtector.parse(r10), com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        boolean r16 = true;
        if (r15 != null) goto L54;
    L35:
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L37
    L53:
    L39:
        if (r17.optString(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID).length() != 0) goto L41;
        boolean r18 = true;
    L42:
        if (r18 == false) goto L45;
        r17.put(com.bytedance.android.ec.core.event.a.KEY_CREATIVE_ID, r12.getCid());
    L45:
        if (r17.optString(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA).length() == 0) goto L48;
        r16 = false;
    L48:
        if (r16 == false) goto L50;
        r17.put(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r12.getLogExtra());
    L50:
        int r19 = jg.e.a;
        return jg.e.b(r14, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r17.toString());
    L41:
        r18 = false;
    L37:
        r17 = new JSONObject();
        goto L39
    L54:
        if (r15.length() <= 0) goto L30;
        boolean r20 = true;
    L31:
        if (r20 == false) goto L33;
        r0 = r15;
    L33:
        if (r0 == null) goto L35;
        r17 = new JSONObject(r0);     // Catch: Exception -> L37
        goto L53
    L30:
        r20 = false;
        goto L31
    L52:
        return r14;
    L7:
        if (a2.b(r11.getCreativeId()) == false) goto L23;
        String r21 = r11.getAdExtraData();
        if (r13 == true) goto L18;
        String r110 = r11.getCreativeId().toString();
        String r22 = r11.getLogExtra();
        JSONObject r23 = new JSONObject();
        if (r110 == null) goto L13;
        r23.put(com.bytedance.android.ec.core.event.a.KEY_CID, r110);
    L13:
        if (r22 == null) goto L15;
        r23.put(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r22);
    L15:
        if (r21 == null) goto L17;
        r23.put(com.bytedance.android.ec.core.event.a.KEY_AD_EXTRA_DATA, r21);
    L17:
        String r24 = r23.toString();
        Uri.Builder r111 = UriProtector.parse(r10).buildUpon();
        r111.appendQueryParameter("has_adinfojson", "1");
        r111.appendQueryParameter("adinfojson", r24);
        r14 = r111.toString();
        goto L24
    L18:
        String r112 = r11.getCreativeId().toString();
        String r25 = r11.getLogExtra();
        JSONObject r26 = jg.g.f(UriProtector.getQueryParameter(UriProtector.parse(r10), com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT));
        if (r26 == null) goto L21;
        r26.put(com.bytedance.android.ec.core.event.a.KEY_CID, r112);
        r26.put(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r25);
        r26.put(com.bytedance.android.ec.core.event.a.KEY_AD_EXTRA_DATA, r21);
    L22:
        int r27 = jg.e.a;
        r14 = jg.e.b(r10, com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT, String.valueOf(r26));
        goto L24
    L21:
        r26 = null;
        goto L22
    }
}
