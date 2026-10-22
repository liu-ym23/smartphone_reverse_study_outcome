package com.ss.android.common.applog;

import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.entity.Header;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.ss.android.common.lib.AppLogNewUtils;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f15083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.applog.util.h f15084b;

    private f() {
        if (AppLog.a() == false) goto L5;
        com.bytedance.applog.util.h r0 = new g();
    L6:
        this.f15084b = r0;
        return;
    L5:
        r0 = new h();
        goto L6
    }

    public static f a() {
        if (f15083a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15083a != null) goto L9;
        f15083a = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f15083a;
    }

    public void a(String r18, String r19, String r20, long r21, long r23, long r25, long r27, JSONObject r29) {
        if (b() == true) goto L5;
        return;
    L5:
        JSONObject r10 = null;
        if (r29 != null) goto L45;
    L10:
        if (r10 != null) goto L13;
        r10 = new JSONObject();
    L13:
        if (AppLogNewUtils.EVENT_V3_CATEGORY.equals(r18) == false) goto L15;
        JSONObject r12 = new JSONObject();
        String r14 = AppLogNewUtils.EVENT_V3_CATEGORY;
    L47:
        if (AppLogNewUtils.EVENT_V3_CATEGORY.equals(r18) == true) goto L19;
        r12.put(EventBody.KEY_CATEGORY, r18);     // Catch: JSONException -> L44
        r12.put(LocationMonitorConst.TAG, r19);     // Catch: JSONException -> L44
        if (TextUtils.isEmpty(r20) == true) goto L29;
        r12.put(AnnotatedPrivateKey.LABEL, r20);     // Catch: JSONException -> L44
    L29:
        if (r21 == 0) goto L32;
        r12.put(EventBody.KEY_VALUE, r21);     // Catch: JSONException -> L44
    L32:
        if (r23 == 0) goto L35;
        r12.put("ext_value", r23);     // Catch: JSONException -> L44
    L35:
        if (r25 <= 0) goto L37;
        r12.put(Header.KEY_USER_ID, r25);     // Catch: JSONException -> L44
    L37:
        String r0 = AppLog.B();     // Catch: JSONException -> L44
        if (TextUtils.isEmpty(r0) == true) goto L40;
        r12.put(Api.KEY_USER_UNIQUE_ID, r0);     // Catch: JSONException -> L44
    L40:
        r12.put("session_id", AppLog.n());     // Catch: JSONException -> L44
        r12.put("datetime", AppLog.a(r27));     // Catch: JSONException -> L44
        goto L41
    L19:
        if (r10.has("nt") == false) goto L21;
        r12.put("nt", r10.optInt("nt"));     // Catch: JSONException -> L44
    L21:
        r10.remove("nt");     // Catch: JSONException -> L44
        r10.remove(AppLogNewUtils.EVENT_SIGN);     // Catch: JSONException -> L44
        if (r10.has("ab_sdk_version") == false) goto L24;
        r12.put("ab_sdk_version", r10.optString("ab_sdk_version"));     // Catch: JSONException -> L44
        r10.remove("ab_sdk_version");     // Catch: JSONException -> L44
    L24:
        r12.put("event", r19);     // Catch: JSONException -> L44
        r12.put(TrackerImpl.PARAMS, r10);     // Catch: JSONException -> L44
        r12.put("local_time_ms", r27);     // Catch: JSONException -> L44
    L41:
        JSONArray r1 = new JSONArray();
        r1.put(r12);
        a(r14, r1);
        return;
    L15:
        r12 = r10;
        r14 = "event";
        goto L47
    L45:
        r10 = new JSONObject(r29.toString());     // Catch: JSONException -> L43
        goto L10
    }

    public void a(String r1, JSONArray r2) {
        this.f15084b.putEvent(r1, r2);
    }

    public boolean b() {
        return this.f15084b.isEnable();
    }
}
