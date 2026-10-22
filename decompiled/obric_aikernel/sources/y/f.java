package y;

import androidx.annotation.Nullable;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements w.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f13624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f13625d;

    public f(String r10, String r11, JSONObject r12, JSONObject r13) {
        this.f13622a = r10;
        this.f13623b = r11;
        this.f13624c = r12;
        this.f13625d = r13;
    }

    @Override // w.b
    public String a() {
        return LogTypeName.MONITOR_LOG_TYPE_UI_ACTION;
    }

    @Override // w.b
    public boolean b(JSONObject r10) {
        return o0.c.c("ui");
    }

    @Override // w.b
    @Nullable
    public JSONObject c() {
    L7:
        return null;
    L3:
        if (this.f13625d != null) goto L5;
        this.f13625d = new JSONObject();     // Catch: JSONException -> L7
    L5:
        this.f13625d.put("log_type", LogTypeName.MONITOR_LOG_TYPE_UI_ACTION);     // Catch: JSONException -> L7
        this.f13625d.put("action", this.f13622a);     // Catch: JSONException -> L7
        this.f13625d.put("page", this.f13623b);     // Catch: JSONException -> L7
        this.f13625d.put("context", this.f13624c);     // Catch: JSONException -> L7
        return this.f13625d;
    }

    @Override // w.b
    public boolean d() {
        return true;
    }

    @Override // w.b
    public String e() {
        return LogTypeName.MONITOR_LOG_TYPE_UI_ACTION;
    }
}
