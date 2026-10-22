package i0;

import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.perf.ICpuDataService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f9300a;

    private d() {
    }

    public static d b() {
        if (f9300a != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9300a != null) goto L9;
        f9300a = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f9300a;
    }

    public JSONObject a() {
        JSONObject r10 = new JSONObject();
        ICpuDataService r11 = (ICpuDataService) ServiceManager.getService(ICpuDataService.class);     // Catch: JSONException -> L5
        r10.put("process_usage", r11.getCpuRate());     // Catch: JSONException -> L5
        r10.put("stat_speed", r11.getCpuSpeed());     // Catch: JSONException -> L5
        return r10;
    L6:
        return new JSONObject();
    }
}
