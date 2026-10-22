package com.ss.android.common.lib;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.util.BlockHelper;
import com.bytedance.common.utility.StringUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.k0;
import ita.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
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

    public static class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ long c;

        public final void a() {
            BlockHelper.tryBlock();
            if (StringUtils.isEmpty(this.a) == false) goto L5;
            return;
        L5:
            JSONObject r0 = this.b;
            if (r0 != null) goto L8;
            r0 = new JSONObject();
        L8:
            JSONObject r9 = r0;
            r9.put(AppLogNewUtils.EVENT_SIGN, 1);     // Catch: JSONException -> L13
            r9.put(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP, this.c);     // Catch: JSONException -> L13
            String r1 = AppLog.n();     // Catch: JSONException -> L13
            if (TextUtils.isEmpty(r1) == true) goto L15;
            r9.put("ab_sdk_version", r1);     // Catch: JSONException -> L13
        L15:
            AppLog.E(null, AppLogNewUtils.EVENT_V3_CATEGORY, this.a, null, 0, 0, r9);
            return;
        L13:
            e = move-exception;
            e.printStackTrace();
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r1, JSONObject r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public AppLogNewUtils() {
    }

    public static JSONObject copyJson(JSONObject r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        LinkedList r0 = new LinkedList();
        Iterator<String> r1 = r3.keys();
    L7:
        if (r1.hasNext() == false) goto L14;
        r0.add(r1.next());
        goto L7
    L14:
        return new JSONObject(r3, (String[]) r0.toArray(new String[0]));
    L11:
        e = move-exception;
        e.printStackTrace();
        return r3;
    }

    private static boolean isEmptyMap(Map<String, String> r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }

    public static void onEventV3(String r0, JSONObject r1) {
        onEventV3ByConstParams(r0, copyJson(r1));
    }

    public static void onEventV3Bundle(String r4, Bundle r5) {
        long r0 = System.currentTimeMillis();
        k0.d().b(new c(r4, r0, r5));
    }

    public static void onEventV3ByConstParams(String r4, JSONObject r5) {
        long r0 = System.currentTimeMillis();
        k0.d().b(new a(r4, r5, r0));
    }

    public static void onEventV3Map(String r4, Map<String, String> r5) {
        if (StringUtils.isEmpty(r4) == false) goto L6;
        return;
    L6:
        if (isEmptyMap(r5) == false) goto L8;
        JSONObject r6 = new JSONObject();
    L9:
        long r0 = System.currentTimeMillis();
        k0.d().b(new b(r6, r0, r4));
        return;
    L8:
        r6 = new JSONObject(r5);
        goto L9
    }

    public static void onInternalEventV3(String r4, Bundle r5, String r6, String r7, String r8) {
        JSONObject r1 = null;
        if (TextUtils.isEmpty(r6) == true) goto L5;
    L8:
        String r9 = SECOND_APP_PREFIX + r4;
        if (r5 != null) goto L27;
    L23:
        onEventV3(r9, r1);
        return;
    L27:
    L21:
        th = th;
    L22:
        th.printStackTrace();
        goto L23
    L11:
        if (r5.isEmpty() == true) goto L23;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L21
        Iterator<String> r2 = r5.keySet().iterator();     // Catch: Throwable -> L19
    L15:
        if (r2.hasNext() == false) goto L17;
        String r3 = r2.next();     // Catch: Throwable -> L19
        r0.put(r3, r5.get(r3));     // Catch: Throwable -> L19
        goto L15
    L17:
        r0.put(SECOND_APP_SPECIAL_KEY, SECOND_APP_VALUE);     // Catch: Throwable -> L19
        r0.put(SECOND_APP_ID_KEY, r6);     // Catch: Throwable -> L19
        r0.put(SECOND_APP_NAME_KEY, r7);     // Catch: Throwable -> L19
        r0.put(SECOND_APP_PRODUCT_TYPE_KEY, r8);     // Catch: Throwable -> L19
        r1 = r0;
    L19:
        th = th;
        r1 = r0;
        goto L22
    L5:
        if (TextUtils.isEmpty(r7) == false) goto L8;
        j.g("both second appid and second app name is empty, return", null);
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
        j.g("both second appid and second app name is empty, return", null);
    }
}
