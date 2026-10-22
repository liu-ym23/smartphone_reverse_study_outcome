package r;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f12516f;

    public d() {
    }

    @Nullable
    public JSONObject b() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L4
        r10.put("flags", this.f12515e);     // Catch: Throwable -> L4
        r10.put("tag", this.f12516f);     // Catch: Throwable -> L4
        r10.put("start_time", this.f12510a);     // Catch: Throwable -> L4
        r10.put("end_time", this.f12511b);     // Catch: Throwable -> L4
        r10.put("thread_name", this.f12512c);     // Catch: Throwable -> L4
        r10.put("thread_stack", a());     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    public String toString() {
        return "WakeLockInfo{flags=" + this.f12515e + ", tag=" + this.f12516f + ", startTime=" + this.f12510a + ", endTime=" + this.f12511b + ", threadName=" + this.f12512c + ", threadStack=" + a() + '}';
    }
}
