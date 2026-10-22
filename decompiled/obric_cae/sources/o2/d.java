package o2;

import c2.k;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements m2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f9634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9636d;

    public d(long r8, String r10, JSONObject r11) {
        this.f9633a = r10;
        this.f9634b = r11;
        this.f9636d = r8;
    }

    @Override // m2.c
    public final String a() {
        return this.f9633a;
    }

    @Override // m2.c
    public final boolean b(JSONObject r8) {
        if (this.f9635c == true) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // m2.c
    public final JSONObject c() {
        long r8 = this.f9636d;
        JSONObject r10 = this.f9634b;
        if (r10 != null) goto L16;
        return null;
    L16:
        r10.put("timestamp", r8);     // Catch: JSONException -> L15
        r10.put("crash_time", r8);     // Catch: JSONException -> L15
        r10.put(LocationMonitorConst.IS_MAIN_PROCESS, k.e());     // Catch: JSONException -> L15
        r10.put("process_name", k.a());     // Catch: JSONException -> L15
        r10.put("log_type", this.f9633a);     // Catch: JSONException -> L15
        if (k.f3304h > k.b()) goto L10;
        long r11 = k.f3304h;     // Catch: JSONException -> L15
        if (r11 == 0) goto L10;
    L9:
        r10.put("app_launch_start_time", r11);     // Catch: JSONException -> L15
    L10:
        r11 = k.b();     // Catch: JSONException -> L15
    L12:
        return r10;
    }

    @Override // m2.c
    public final boolean d() {
        return true;
    }

    @Override // m2.c
    public final String e() {
        return this.f9633a;
    }

    public final String toString() {
        return "ExceptionLogData{eventType='" + this.f9633a + "', logJson=" + this.f9634b + ", forceSampled=" + this.f9635c + ", time=" + this.f9636d + '}';
    }

    public d(String r8, JSONObject r10) {
        this(System.currentTimeMillis(), r8, r10);
    }
}
