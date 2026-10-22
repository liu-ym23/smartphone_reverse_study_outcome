package com.bytedance.applog.p;

import android.text.TextUtils;
import com.bytedance.applog.e.f;
import com.bytedance.applog.log.q;
import com.bytedance.applog.util.i;
import com.bytedance.applog.util.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1759b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private JSONObject g;
    private long h;
    private long i;
    private long j;

    private d() {
        this.c = false;
        this.d = null;
        this.e = false;
        this.f = null;
        this.g = null;
        this.i = 0;
        this.j = 0;
    }

    public d(long r3, long r5) {
        this.c = false;
        this.d = null;
        this.e = false;
        this.f = null;
        this.g = null;
        this.i = 0;
        this.j = 0;
        this.f1758a = r3;
        this.f1759b = f.a();
        this.j = r5;
    }

    public static d a(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L11;
        return null;
    L11:
        JSONObject r3 = new JSONObject(r7);     // Catch: Throwable -> L8
        String r8 = r3.optString("session_id", "");     // Catch: Throwable -> L8
        d r4 = new d();     // Catch: Throwable -> L8
        r4.f1759b = r8;     // Catch: Throwable -> L8
        r4.f1758a = o.a(r3, "start_time");     // Catch: Throwable -> L8
        r4.c = r3.optBoolean("is_front_continuous", false);     // Catch: Throwable -> L8
        r4.d = r3.optString("front_session_id", "");     // Catch: Throwable -> L8
        r4.e = r3.optBoolean("is_end_continuous", false);     // Catch: Throwable -> L8
        r4.f = r3.optString("end_session_id", "");     // Catch: Throwable -> L8
        r4.h = o.a(r3, "latest_end_time");     // Catch: Throwable -> L8
        r4.i = o.a(r3, "non_task_time");     // Catch: Throwable -> L8
        r4.j = o.a(r3, "tea_event_index");     // Catch: Throwable -> L8
        r4.g = r3.optJSONObject("flatParams");     // Catch: Throwable -> L8
        return r4;
    L8:
        th = move-exception;
        q.a().a("[Task] get session from string failed", th, new Object[0]);
        return null;
    }

    public void a(long r1) {
        this.h = r1;
    }

    public void a(JSONObject r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        JSONObject r0 = this.g;
        if (r0 != null) goto L8;
        this.g = r2;
        return;
    L8:
        i.a(r2, r0);
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.d);
    }

    public void b(long r3) {
        this.i += r3;
    }

    public void b(String r2) {
        this.c = true;
        this.d = r2;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f);
    }

    public String c() {
        return this.d;
    }

    public void c(String r2) {
        this.e = true;
        this.f = r2;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        JSONObject r0 = new JSONObject();
        r0.put("start_time", this.f1758a);     // Catch: JSONException -> L8
        r0.put("session_id", this.f1759b);     // Catch: JSONException -> L8
        r0.put("is_front_continuous", this.c);     // Catch: JSONException -> L8
        r0.put("front_session_id", this.d);     // Catch: JSONException -> L8
        r0.put("is_end_continuous", this.e);     // Catch: JSONException -> L8
        r0.put("end_session_id", this.f);     // Catch: JSONException -> L8
        r0.put("latest_end_time", this.h);     // Catch: JSONException -> L8
        r0.put("non_task_time", this.i);     // Catch: JSONException -> L8
        r0.put("tea_event_index", this.j);     // Catch: JSONException -> L8
        JSONObject r4 = this.g;     // Catch: JSONException -> L8
        if (r4 == null) goto L6;
        r0.put("flatParams", r4);     // Catch: JSONException -> L8
    L6:
        return r0.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public String f() {
        return this.f1759b;
    }

    public int g() {
        boolean r0 = this.c;
        boolean r1 = this.e;
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        return 1;
    L7:
        if (r0 == false) goto L11;
        if (r1 == true) goto L11;
        return 2;
    L11:
        if (r0 == true) goto L14;
        return 3;
    L14:
        return 4;
    }

    public long h() {
        return this.h;
    }

    public long i() {
        return Math.max(0, (this.h - this.f1758a) - this.i);
    }

    public long j() {
        return this.f1758a;
    }

    public JSONObject k() {
        return this.g;
    }

    public String toString() {
        return e();
    }
}
