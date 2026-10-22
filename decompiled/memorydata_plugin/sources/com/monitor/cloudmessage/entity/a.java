package com.monitor.cloudmessage.entity;

import android.text.TextUtils;
import com.bytedance.apm.e.e;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5851b;

    @Deprecated
    private long c;
    private String d;
    private JSONObject e;
    private String f;

    public a() {
    }

    public static a a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L15;
        return null;
    L15:
        a r0 = new a();     // Catch: Exception -> L10
        JSONObject r2 = new JSONObject(r5);     // Catch: Exception -> L10
        r0.d = r2.optString("command_id");     // Catch: Exception -> L10
        r0.f5851b = r2.optString("type");     // Catch: Exception -> L10
        String r3 = r2.optString(TrackerImpl.PARAMS);     // Catch: Exception -> L10
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r3) == true) goto L8;
        r4 = new JSONObject(r3);     // Catch: Exception -> L10
    L8:
        r0.f5850a = r3;     // Catch: Exception -> L10
        r0.e = r4;     // Catch: Exception -> L10
        r0.f = r5;     // Catch: Exception -> L10
        return r0;
    L10:
        e = move-exception;
        if (com.bytedance.apm.b.k() == false) goto L14;
        e.a("cloudmessage", e, new String[]{"Parse CloudMessage Error."});
    L14:
        return null;
    }

    public String a() {
        return this.f5850a;
    }

    public JSONObject b() {
        return this.e;
    }

    public boolean c() {
        return this.e.optBoolean("wifiOnly");
    }

    public String d() {
        return this.d;
    }

    public String getType() {
        return this.f5851b;
    }

    public String toString() {
        return "CloudMessage{mParams='" + this.f5850a + "', mType=" + this.f5851b + ", send_time=" + this.c + ", command_id='" + this.d + "'}";
    }
}
