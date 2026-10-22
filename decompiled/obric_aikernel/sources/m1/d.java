package m1;

import android.text.TextUtils;
import f1.n;
import o1.p;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f10990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f10996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f10997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f10998i;

    private d() {
        this.f10992c = false;
        this.f10993d = null;
        this.f10994e = false;
        this.f10995f = null;
        this.f10997h = 0;
        this.f10998i = 0;
    }

    public d(long r10, long r11) {
        this.f10992c = false;
        this.f10993d = null;
        this.f10994e = false;
        this.f10995f = null;
        this.f10997h = 0;
        this.f10998i = 0;
        this.f10990a = r10;
        this.f10991b = a1.e.c();
        this.f10998i = r11;
    }

    public static d b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L11;
        return null;
    L11:
        JSONObject r11 = new JSONObject(r10);     // Catch: Throwable -> L8
        String r12 = r11.optString("session_id", "");     // Catch: Throwable -> L8
        d r13 = new d();     // Catch: Throwable -> L8
        r13.f10991b = r12;     // Catch: Throwable -> L8
        r13.f10990a = p.p(r11, "start_time");     // Catch: Throwable -> L8
        r13.f10992c = r11.optBoolean("is_front_continuous", false);     // Catch: Throwable -> L8
        r13.f10993d = r11.optString("front_session_id", "");     // Catch: Throwable -> L8
        r13.f10994e = r11.optBoolean("is_end_continuous", false);     // Catch: Throwable -> L8
        r13.f10995f = r11.optString("end_session_id", "");     // Catch: Throwable -> L8
        r13.f10996g = p.p(r11, "latest_end_time");     // Catch: Throwable -> L8
        r13.f10997h = p.p(r11, "non_task_time");     // Catch: Throwable -> L8
        r13.f10998i = p.p(r11, "tea_event_index");     // Catch: Throwable -> L8
        return r13;
    L8:
        th = move-exception;
        n.B().j("[Task] get session from string failed", th, new Object[0]);
        return null;
    }

    public void a(long r10) {
        this.f10997h += r10;
    }

    public long c() {
        return Math.max(0, (this.f10996g - this.f10990a) - this.f10997h);
    }

    public String d() {
        return this.f10995f;
    }

    public String e() {
        return this.f10993d;
    }

    public long f() {
        return this.f10996g;
    }

    public String g() {
        return this.f10991b;
    }

    public int h() {
        boolean r10 = this.f10992c;
        boolean r11 = this.f10994e;
        if (r10 == true) goto L7;
        if (r11 == true) goto L7;
        return 1;
    L7:
        if (r10 == false) goto L11;
        if (r11 == true) goto L11;
        return 2;
    L11:
        if (r10 == true) goto L14;
        return 3;
    L14:
        return 4;
    }

    public long i() {
        return this.f10990a;
    }

    public boolean j() {
        return !TextUtils.isEmpty(this.f10995f);
    }

    public boolean k() {
        return !TextUtils.isEmpty(this.f10993d);
    }

    public void l(String r10) {
        this.f10994e = true;
        this.f10995f = r10;
    }

    public void m(String r10) {
        this.f10992c = true;
        this.f10993d = r10;
    }

    public void n(long r10) {
        this.f10996g = r10;
    }

    public String o() {
        JSONObject r10 = new JSONObject();
        r10.put("start_time", this.f10990a);     // Catch: JSONException -> L5
        r10.put("session_id", this.f10991b);     // Catch: JSONException -> L5
        r10.put("is_front_continuous", this.f10992c);     // Catch: JSONException -> L5
        r10.put("front_session_id", this.f10993d);     // Catch: JSONException -> L5
        r10.put("is_end_continuous", this.f10994e);     // Catch: JSONException -> L5
        r10.put("end_session_id", this.f10995f);     // Catch: JSONException -> L5
        r10.put("latest_end_time", this.f10996g);     // Catch: JSONException -> L5
        r10.put("non_task_time", this.f10997h);     // Catch: JSONException -> L5
        r10.put("tea_event_index", this.f10998i);     // Catch: JSONException -> L5
        return r10.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public String toString() {
        return o();
    }
}
