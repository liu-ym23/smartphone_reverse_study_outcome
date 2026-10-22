package j2;

import c2.e;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f8559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d.a f8560b;

    public c(d.a r8, long r10) {
        this.f8560b = r8;
        this.f8559a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L4
        r8.put("looper_monitor", this.f8559a);     // Catch: JSONException -> L4
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L4
        r10.put(LocationMonitorConst.IS_MAIN_PROCESS, this.f8560b.f8577a.f8574n);     // Catch: JSONException -> L4
        e.c("apm_cost", r10, r8, null);     // Catch: JSONException -> L4
        return;
    }
}
