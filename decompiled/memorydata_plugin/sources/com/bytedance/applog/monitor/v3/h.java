package com.bytedance.applog.monitor.v3;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1703b;
    public long c;
    public StageEventType d;
    public String e;
    public int f;

    public h(String r2, int r3, String r4, String r5, long r6, StageEventType r8) {
        this.f = -1;
        this.e = r2;
        this.f = r3;
        this.f1702a = r4;
        this.f1703b = r5;
        this.c = r6;
        this.d = r8;
    }

    public h(String r9, String r10, long r11, StageEventType r13) {
        this(null, -1, r9, r10, r11, r13);
    }

    public h(JSONObject r10) {
        this(r10.optString("priority_name"), r10.optInt("group_id", -1), r10.optString("event_name"), r10.optString("monitor_id"), r10.optLong("local_time_ms"), StageEventType.parse(r10.optString("type")));
    }

    public JSONObject a() {
        JSONObject r0 = new JSONObject();
        r0.put("event_name", this.f1702a);     // Catch: Throwable -> L18
        r0.put("monitor_id", this.f1703b);     // Catch: Throwable -> L18
        StageEventType r1 = this.d;     // Catch: Throwable -> L18
        if (r1 == null) goto L6;
        r0.put("type", r1.name());     // Catch: Throwable -> L18
    L6:
        long r2 = this.c;     // Catch: Throwable -> L18
        if (r2 <= 0) goto L9;
        r0.put("local_time_ms", r2);     // Catch: Throwable -> L18
    L9:
        String r3 = this.e;     // Catch: Throwable -> L18
        if (r3 != null) goto L12;
    L14:
        int r5 = this.f;     // Catch: Throwable -> L18
        if (r5 < 0) goto L17;
        r0.put("group_id", r5);     // Catch: Throwable -> L18
        goto L17
    L12:
        if (r3.isEmpty() == true) goto L14;
        r0.put("priority_name", this.e);     // Catch: Throwable -> L18
    L17:
        return r0;
    }

    public void a(h r5) {
        if (TextUtils.equals(this.f1703b, r5.f1703b) == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.e) == false) goto L11;
        if (TextUtils.isEmpty(r5.e) == true) goto L11;
        this.e = r5.e;
    L11:
        if (this.f >= 0) goto L16;
        int r0 = r5.f;
        if (r0 < 0) goto L16;
        this.f = r0;
    L16:
        if (TextUtils.isEmpty(this.f1702a) == false) goto L21;
        if (TextUtils.isEmpty(r5.f1702a) == true) goto L21;
        this.f1702a = r5.f1702a;
    L21:
        if (this.c > 0) goto L26;
        long r1 = r5.c;
        if (r1 <= 0) goto L26;
        this.c = r1;
    L26:
        if (this.d != null) goto L31;
        StageEventType r6 = r5.d;
        if (r6 == null) goto L32;
        this.d = r6;
        return;
    L32:
        return;
    }
}
