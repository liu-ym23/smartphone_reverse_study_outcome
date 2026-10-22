package c3;

import android.text.TextUtils;
import c2.k;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import i2.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long[] f3313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3314b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f3315m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f3316n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f3317o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f3318p;

    public c(long[] r8, long r10, long r11, long r12, int r13) {
        this.f3313a = r8;
        this.f3314b = r10;
        this.f3315m = r11;
        this.f3316n = r12;
        this.f3317o = r13;
        this.f3318p = "";
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = e.f8105a;     // Catch: Throwable -> L8
        long[] r10 = this.f3313a;     // Catch: Throwable -> L8
        String r11 = e.b(this.f3314b, r10);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        long r12 = this.f3315m - this.f3316n;     // Catch: Throwable -> L8
        JSONObject r13 = com.bytedance.monitor.collector.a.b().a();     // Catch: Throwable -> L8
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L8
        r14.put(LocationMonitorConst.IS_MAIN_PROCESS, k.f());     // Catch: Throwable -> L8
        r14.put("block_duration", r12);     // Catch: Throwable -> L8
        r14.put("stack", r11);     // Catch: Throwable -> L8
        r14.put("stack_key", "1048574\n");     // Catch: Throwable -> L8
        r14.put("scene", "launchTrace");     // Catch: Throwable -> L8
        r14.put("cost_time", r12);     // Catch: Throwable -> L8
        r14.put("method_time", r12);     // Catch: Throwable -> L8
        r14.put("message", "launchTrace");     // Catch: Throwable -> L8
        r14.put("event_type", "lag_drop_frame");     // Catch: Throwable -> L8
        JSONObject r15 = l3.a.a().c(true);     // Catch: Throwable -> L8
        r15.put("crash_section", k.c(System.currentTimeMillis()));     // Catch: Throwable -> L8
        r15.put("trace_type", "launchTrace");     // Catch: Throwable -> L8
        r15.put("launchMode", String.valueOf(this.f3317o));     // Catch: Throwable -> L8
        r15.put("customLaunchMode", this.f3318p);     // Catch: Throwable -> L8
        r14.put("custom", r13);     // Catch: Throwable -> L8
        r14.put("filters", r15);     // Catch: Throwable -> L8
        n2.a.i().d(new o2.d("drop_frame_stack", r14));     // Catch: Throwable -> L8
        return;
    }
}
