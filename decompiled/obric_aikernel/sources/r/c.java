package r;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f12514e;

    public c() {
    }

    @Nullable
    public JSONObject b() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L4
        r10.put("start_time", this.f12510a);     // Catch: Throwable -> L4
        r10.put("end_time", this.f12511b);     // Catch: Throwable -> L4
        r10.put("thread_name", this.f12512c);     // Catch: Throwable -> L4
        r10.put("thread_stack", a());     // Catch: Throwable -> L4
        r10.put("request", this.f12514e);     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    public String toString() {
        return "LocInfo{request=" + this.f12514e + ", startTime=" + this.f12510a + ", endTime=" + this.f12511b + ", threadName=" + this.f12512c + ", threadStack=" + a() + '}';
    }
}
