package com.ss.android.common.applog.b;

import android.text.TextUtils;
import com.ss.android.common.applog.ab;
import com.ss.android.common.applog.ae;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15070b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private long g;
    private long h;
    private long i;

    private d() {
        this.c = false;
        this.d = null;
        this.e = false;
        this.f = null;
        this.h = 0;
        this.i = 0;
    }

    public d(long r3) {
        this.c = false;
        this.d = null;
        this.e = false;
        this.f = null;
        this.h = 0;
        this.i = 0;
        this.f15069a = r3;
        this.f15070b = ab.a();
        this.i = ab.b();
    }

    public static d a(d r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        d r0 = new d();
        r0.f15069a = r3.f15069a;
        r0.f15070b = r3.f15070b;
        r0.c = r3.c;
        r0.d = r3.d;
        r0.e = r3.e;
        r0.f = r3.f;
        r0.g = r3.g;
        r0.h = r3.h;
        r0.i = r3.i;
        return r0;
    }

    public static d a(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L10;
        return null;
    L10:
        JSONObject r1 = new JSONObject(r6);     // Catch: JSONException -> L7
        String r7 = r1.optString("session_id", "");     // Catch: JSONException -> L7
        d r3 = new d();     // Catch: JSONException -> L7
        r3.f15070b = r7;     // Catch: JSONException -> L7
        r3.f15069a = ae.a(r1, "start_time");     // Catch: JSONException -> L7
        r3.c = r1.optBoolean("is_front_continuous", false);     // Catch: JSONException -> L7
        r3.d = r1.optString("front_session_id", "");     // Catch: JSONException -> L7
        r3.e = r1.optBoolean("is_end_continuous", false);     // Catch: JSONException -> L7
        r3.f = r1.optString("end_session_id", "");     // Catch: JSONException -> L7
        r3.g = ae.a(r1, "latest_end_time");     // Catch: JSONException -> L7
        r3.h = ae.a(r1, "non_task_time");     // Catch: JSONException -> L7
        r3.i = ae.a(r1, "tea_event_index");     // Catch: JSONException -> L7
        return r3;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void a(long r1) {
        this.g = r1;
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.d);
    }

    public void b(long r3) {
        this.h += r3;
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
        r0.put("start_time", this.f15069a);     // Catch: JSONException -> L5
        r0.put("session_id", this.f15070b);     // Catch: JSONException -> L5
        r0.put("is_front_continuous", this.c);     // Catch: JSONException -> L5
        r0.put("front_session_id", this.d);     // Catch: JSONException -> L5
        r0.put("is_end_continuous", this.e);     // Catch: JSONException -> L5
        r0.put("end_session_id", this.f);     // Catch: JSONException -> L5
        r0.put("latest_end_time", this.g);     // Catch: JSONException -> L5
        r0.put("non_task_time", this.h);     // Catch: JSONException -> L5
        r0.put("tea_event_index", this.i);     // Catch: JSONException -> L5
        return r0.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public String f() {
        return this.f15070b;
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
        if (r0 == true) goto L15;
        if (r1 == false) goto L17;
        return 3;
    L17:
        return 4;
    L15:
        return 4;
    }

    public long h() {
        return this.g;
    }

    public long i() {
        return Math.max(0, (this.g - this.f15069a) - this.h);
    }

    public long j() {
        return Math.max(1, i() / 1000);
    }

    public long k() {
        return this.f15069a;
    }

    public String toString() {
        return e();
    }
}
