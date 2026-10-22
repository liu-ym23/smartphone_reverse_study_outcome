package com.ss.android.common.applog;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class EventVerify {
    public static final String TYPE_EVENT_V1 = "event";
    public static final String TYPE_EVENT_V3 = "event_v3";
    public static final String TYPE_ITEM_IMPRESSION = "item_impression";
    public static final String TYPE_LAUNCH = "launch";
    public static final String TYPE_LOG_DATA = "log_data";
    public static final String TYPE_TERMINATE = "terminate";
    private static volatile EventVerify sInstance;
    private nx3.e mIEventsSender;

    public static EventVerify inst() {
        if (sInstance != null) goto L15;
        monitor-enter(EventVerify.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new EventVerify();     // Catch: Throwable -> L11
    L9:
        monitor-exit(EventVerify.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public boolean isEnable() {
        return this.mIEventsSender.isEnable();
    }

    private EventVerify() {
        if (AppLog.b0 >= 0) goto L6;
        ita.j.g("AppLog SwitchToBdtracker has not been set!", null);
    L6:
        if (AppLog.b0 <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        this.mIEventsSender = new k();
        return;
    L11:
        this.mIEventsSender = new l();
        return;
    L8:
        r0 = false;
        goto L9
    }

    private void setEventVerifyInterval(long r2) {
        this.mIEventsSender.setEventVerifyInterval(r2);
    }

    public void setEventVerifyUrl(String r2) {
        this.mIEventsSender.setEventVerifyUrl(r2);
    }

    public void setSpecialKeys(List<String> r2) {
        this.mIEventsSender.setSpecialKeys(r2);
    }

    public void loginEtWithScheme(String r2, Context r3) {
        this.mIEventsSender.loginEtWithScheme(r2, r3);
    }

    public void putEvent(String r2, JSONArray r3) {
        this.mIEventsSender.putEvent(r2, r3);
    }

    public synchronized void setEnable(boolean r2, Context r3) {
        monitor-enter(this);
        this.mIEventsSender.setEnable(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void putEvent(String r18, String r19, String r20, long r21, long r23, long r25, long r27, JSONObject r29) {
        if (isEnable() == true) goto L5;
        return;
    L5:
        if (r29 != null) goto L45;
    L9:
        JSONObject r11 = null;
    L10:
        if (r11 != null) goto L13;
        r11 = new JSONObject();
    L13:
        if (TYPE_EVENT_V3.equals(r18) == false) goto L15;
        JSONObject r12 = new JSONObject();
        String r14 = TYPE_EVENT_V3;
    L47:
        if (TYPE_EVENT_V3.equals(r18) == true) goto L19;
        r12.put("category", r18);     // Catch: JSONException -> L43
        r12.put("tag", r19);     // Catch: JSONException -> L43
        if (TextUtils.isEmpty(r20) == true) goto L29;
        r12.put("label", r20);     // Catch: JSONException -> L43
    L29:
        if (r21 == 0) goto L32;
        r12.put("value", r21);     // Catch: JSONException -> L43
    L32:
        if (r23 == 0) goto L35;
        r12.put("ext_value", r23);     // Catch: JSONException -> L43
    L35:
        if (r25 <= 0) goto L37;
        r12.put("user_id", r25);     // Catch: JSONException -> L43
    L37:
        String r0 = AppLog.w();     // Catch: JSONException -> L43
        if (TextUtils.isEmpty(r0) == true) goto L40;
        r12.put("user_unique_id", r0);     // Catch: JSONException -> L43
    L40:
        r12.put("session_id", AppLog.getCurrentSessionId());     // Catch: JSONException -> L43
        r12.put("datetime", AppLog.m(r27));     // Catch: JSONException -> L43
        goto L41
    L19:
        if (r11.has("nt") == false) goto L21;
        r12.put("nt", r11.optInt("nt"));     // Catch: JSONException -> L43
    L21:
        r11.remove("nt");     // Catch: JSONException -> L43
        r11.remove("_event_v3");     // Catch: JSONException -> L43
        if (r11.has("ab_sdk_version") == false) goto L24;
        r12.put("ab_sdk_version", r11.optString("ab_sdk_version"));     // Catch: JSONException -> L43
        r11.remove("ab_sdk_version");     // Catch: JSONException -> L43
    L24:
        r12.put(TYPE_EVENT_V1, r19);     // Catch: JSONException -> L43
        r12.put("params", r11);     // Catch: JSONException -> L43
        r12.put("local_time_ms", r27);     // Catch: JSONException -> L43
    L41:
        JSONArray r1 = new JSONArray();
        r1.put(r12);
        putEvent(r14, r1);
        return;
    L15:
        r12 = r11;
        r14 = TYPE_EVENT_V1;
        goto L47
    L45:
        r11 = new JSONObject(r29.toString());     // Catch: JSONException -> L44
        goto L10
    }
}
