package j6;

import com.bytedance.apm.j;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements h6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f18254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18255c;
    public final long d;

    public c(String r5, JSONObject r10) {
        this(r5, System.currentTimeMillis(), r10);
    }

    @Override // h6.b
    public final String a() {
        return this.f18253a;
    }

    @Override // h6.b
    public final boolean b(JSONObject r5) {
        return this.f18255c;
    }

    @Override // h6.b
    public final JSONObject c() {
        long r5 = this.d;
        JSONObject r10 = this.f18254b;
        if (r10 != null) goto L16;
        return null;
    L16:
        r10.put("timestamp", r5);     // Catch: JSONException -> L14
        r10.put("crash_time", r5);     // Catch: JSONException -> L14
        r10.put("is_main_process", j.d());     // Catch: JSONException -> L14
        r10.put("process_name", j.a());     // Catch: JSONException -> L14
        r10.put("log_type", this.f18253a);     // Catch: JSONException -> L14
        if (j.g > j.b()) goto L10;
        long r11 = j.g;     // Catch: JSONException -> L14
        if (r11 == 0) goto L10;
        r10.put("app_launch_start_time", r11);     // Catch: JSONException -> L14
    L15:
    L10:
        r10.put("app_launch_start_time", j.b());     // Catch: JSONException -> L14
    L11:
        return r10;
    }

    @Override // h6.b
    public final boolean d() {
        return true;
    }

    @Override // h6.b
    public final String e() {
        return this.f18253a;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ExceptionLogData{eventType='");
        r5.append(this.f18253a);
        r5.append("', logJson=");
        r5.append(this.f18254b);
        r5.append(", forceSampled=");
        r5.append(this.f18255c);
        r5.append(", time=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.d, '}');
    }

    public c(String r5, long r10, JSONObject r11) {
        this.f18253a = r5;
        this.f18254b = r11;
        this.d = r10;
    }
}
