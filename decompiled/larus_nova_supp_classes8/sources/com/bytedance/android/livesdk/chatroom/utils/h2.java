package com.bytedance.android.livesdk.chatroom.utils;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h2 {
    public static String b(Bundle r4) {
        Bundle r0 = com.bytedance.android.livesdk.chatroom.m0.a(r4);
        boolean r2 = false;
        if (r4.getBoolean("live.intent.extra.FROM_NEW_STYLE", false) == true) goto L7;
        if (r0 == null) goto L9;
        if (r0.getBoolean("live.intent.extra.FROM_NEW_STYLE", false) == true) goto L7;
    L9:
        if (r2 == true) goto L11;
        return "";
    L11:
        String r5 = r4.getString("live.intent.extra.FEED_URL", "");
        if (StringUtils.isEmpty(r5) == false) goto L20;
        if (r0 == null) goto L15;
        r5 = r0.getString("live.intent.extra.FEED_URL", "");
    L17:
        if (StringUtils.isEmpty(r5) == false) goto L20;
        return "";
    L15:
        r5 = "";
    L20:
        return r5;
    L7:
        r2 = true;
        goto L9
    }

    public static boolean c(Bundle r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (tb1.c.a == true) goto L8;
        return false;
    L8:
        if (r4.getBoolean("live.intent.extra.FROM_NEW_STYLE", false) == false) goto L10;
        return true;
    L10:
        Bundle r5 = com.bytedance.android.livesdk.chatroom.m0.a(r4);
        if (r5 != null) goto L13;
        return false;
    L13:
        if (r5.getBoolean("live.intent.extra.FROM_NEW_STYLE", false) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public static boolean d(DataCenter r2) {
        if (tb1.c.a == false) goto L10;
        if (r2 == null) goto L10;
        if (((Boolean) r2.get("data_live_new_feed_style", Boolean.FALSE)).booleanValue() == false) goto L10;
        if (((Boolean) r2.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean e(Bundle r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r8.getLong("live.intent.extra.LOAD_DURATION", 0) <= 0) goto L8;
        return true;
    L8:
        Bundle r9 = com.bytedance.android.livesdk.chatroom.m0.a(r8);
        if (r9 != null) goto L11;
        return false;
    L11:
        if (r9.getLong("live.intent.extra.LOAD_DURATION", 0) <= 0) goto L15;
        return true;
    L15:
        return false;
    }

    public static String a(Map<String, String> r5, String r6) {
        if (r5 != null) goto L5;
    L33:
        return null;
    L5:
        if (StringUtils.isEmpty(r6) == true) goto L33;
        String r7 = r5.get("req_param");
        if (StringUtils.isEmpty(r7) == false) goto L10;
        return null;
    L10:
        StringBuilder r0 = new StringBuilder();
        Uri r8 = UriProtector.parse(r6);
        JSONObject r1 = new JSONObject(r7);     // Catch: JSONException -> L29
        Iterator<String> r9 = r1.keys();     // Catch: JSONException -> L29
        if (StringUtils.isEmpty(r8.getQuery()) == false) goto L21;
        if (r9.hasNext() == false) goto L21;
        String r10 = r9.next();     // Catch: JSONException -> L29
        String r3 = r1.optString(r10);     // Catch: JSONException -> L29
        if (StringUtils.isEmpty(r10) == true) goto L21;
        if (StringUtils.isEmpty(r3) == true) goto L21;
        r0.append("?");     // Catch: JSONException -> L29
        r0.append(r10);     // Catch: JSONException -> L29
        r0.append("=");     // Catch: JSONException -> L29
        r0.append(r3);     // Catch: JSONException -> L29
    L21:
        if (r9.hasNext() == false) goto L32;
        String r11 = r9.next();     // Catch: JSONException -> L29
        String r4 = r1.optString(r11);     // Catch: JSONException -> L29
        if (StringUtils.isEmpty(r11) == true) goto L21;
        if (StringUtils.isEmpty(r4) == true) goto L21;
        r0.append("&");     // Catch: JSONException -> L29
        r0.append(r11);     // Catch: JSONException -> L29
        r0.append("=");     // Catch: JSONException -> L29
        r0.append(r4);     // Catch: JSONException -> L29
    L32:
        return r0.toString();
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }

    public static void f(boolean r3, Bundle r4) {
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.j0.l().c(Room.class);
        if (c(r4) == false) goto L13;
        if (r0 == null) goto L14;
        String r1 = "full_screen";
        if (r3 == true) goto L9;
    L11:
        r0.c("live_window_mode", r1);
        return;
    L9:
        if (r4.containsKey("live.intent.extra.WINDOW_MODE") == false) goto L11;
        r1 = r4.getString("live.intent.extra.WINDOW_MODE", "full_screen");
        goto L11
    L14:
        return;
    }
}
