package com.ss.android.common.lib;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.ss.android.common.applog.ad;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class AppLogNewUtils {
    public static final String EVENT_LABEL_TEST = "click_headline";
    public static final String EVENT_RESERVED_FIELD_TIME_STAMP = "event_v3_reserved_field_time_stamp";
    public static final String EVENT_SIGN = "_event_v3";
    public static final String EVENT_TAG_TEST1 = "go_detail";
    public static final String EVENT_TAG_TEST2 = "video_play";
    public static final String EVENT_V3_CATEGORY = "event_v3";
    private static final String SECOND_APP_ID_KEY = "second_appid";
    private static final String SECOND_APP_NAME_KEY = "second_appname";
    private static final String SECOND_APP_PREFIX = "second_app_";
    private static final String SECOND_APP_PRODUCT_TYPE_KEY = "product_type";
    private static final String SECOND_APP_SPECIAL_KEY = "params_for_special";
    private static final String SECOND_APP_VALUE = "second_app";

    public AppLogNewUtils() {
    }

    public static JSONObject copyJson(JSONObject r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        LinkedList r1 = new LinkedList();
        Iterator<String> r2 = r4.keys();
        if (r2 != null) goto L9;
        return null;
    L9:
        if (r2.hasNext() == false) goto L16;
        r1.add(r2.next());
        goto L9
    L16:
        return new JSONObject(r4, (String[]) ZeusTransformUtils.preCheckCast(r1.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"));
    L13:
        e = move-exception;
        e.printStackTrace();
        return r4;
    }

    public static void onEventV3(final String r4, JSONObject r5) {
        final JSONObject r6 = copyJson(r5);
        final long r0 = System.currentTimeMillis();
        ad.a().a(new AnonymousClass1(r4, r6, r0));
    }

    public static void onEventV3Bundle(final String r4, final Bundle r5) {
        final long r0 = System.currentTimeMillis();
        ad.a().a(new AnonymousClass2(r4, r0, r5));
    }

    public static void onInternalEventV3(String r5, Bundle r6, String r7, String r8, String r9) {
        if (TextUtils.isEmpty(r7) == true) goto L5;
    L8:
        JSONObject r0 = null;
        String r10 = SECOND_APP_PREFIX + r5;
        if (r6 != null) goto L25;
    L23:
        onEventV3(r10, r0);
        return;
    L25:
    L21:
        th = th;
    L22:
        th.printStackTrace();
        goto L23
    L11:
        if (r6.isEmpty() == true) goto L23;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L21
        Iterator<String> r2 = r6.keySet().iterator();     // Catch: Throwable -> L19
    L15:
        if (r2.hasNext() == false) goto L17;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        r1.put(r3, r6.get(r3));     // Catch: Throwable -> L19
        goto L15
    L17:
        r1.put(SECOND_APP_SPECIAL_KEY, SECOND_APP_VALUE);     // Catch: Throwable -> L19
        r1.put(SECOND_APP_ID_KEY, r7);     // Catch: Throwable -> L19
        r1.put(SECOND_APP_NAME_KEY, r8);     // Catch: Throwable -> L19
        r1.put(SECOND_APP_PRODUCT_TYPE_KEY, r9);     // Catch: Throwable -> L19
        r0 = r1;
    L19:
        th = th;
        r0 = r1;
        goto L22
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L8;
        Logger.w("both second appid and second app name is empty, return");
    }

    public static void onInternalEventV3(String r2, JSONObject r3, String r4, String r5, String r6) {
        if (TextUtils.isEmpty(r4) == true) goto L5;
    L8:
        if (r3 != null) goto L10;
        r3 = new JSONObject();
    L10:
        String r7 = SECOND_APP_PREFIX + r2;
        r3.put(SECOND_APP_SPECIAL_KEY, SECOND_APP_VALUE);     // Catch: Throwable -> L13
        r3.put(SECOND_APP_ID_KEY, r4);     // Catch: Throwable -> L13
        r3.put(SECOND_APP_NAME_KEY, r5);     // Catch: Throwable -> L13
        r3.put(SECOND_APP_PRODUCT_TYPE_KEY, r6);     // Catch: Throwable -> L13
    L15:
        onEventV3(r7, r3);
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        Logger.w("both second appid and second app name is empty, return");
    }
}
