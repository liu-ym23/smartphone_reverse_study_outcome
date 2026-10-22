package y;

import androidx.annotation.Nullable;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements w.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f13604b;

    public b(String r10, JSONObject r11, boolean r12) {
        this.f13603a = r10;
        this.f13604b = r11;
    }

    @Override // w.b
    public String a() {
        return this.f13603a;
    }

    @Override // w.b
    public boolean b(JSONObject r10) {
        return o0.c.a(this.f13603a);
    }

    @Override // w.b
    @Nullable
    public JSONObject c() {
        JSONObject r10 = this.f13604b;
        if (r10 != null) goto L10;
        return null;
    L10:
        r10.put("log_type", this.f13603a);     // Catch: JSONException -> L9
    L6:
        return this.f13604b;
    }

    @Override // w.b
    public boolean d() {
        return true;
    }

    @Override // w.b
    public String e() {
        return LogTypeName.MONITOR_LOG_TYPE_COMMON_LOG;
    }
}
