package a7;

import android.text.TextUtils;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.j;
import jg.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long[] f139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f141c;
    public final /* synthetic */ long d;
    public final /* synthetic */ int e;

    public b(long[] r5, long r10, long r11, long r12, int r13) {
        this.f139a = r5;
        this.f140b = r10;
        this.f141c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r5 = MethodCollector.getInstance().evilMethodString(this.f139a, this.f140b);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return;
    L6:
        long r10 = this.f141c - this.d;     // Catch: Throwable -> L8
        JSONObject r11 = k.m().k();     // Catch: Throwable -> L8
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L8
        r12.put("is_main_process", j.d());     // Catch: Throwable -> L8
        r12.put("block_duration", r10);     // Catch: Throwable -> L8
        r12.put("stack", r5);     // Catch: Throwable -> L8
        r12.put("stack_key", "1048574\n");     // Catch: Throwable -> L8
        r12.put("scene", "launchTrace");     // Catch: Throwable -> L8
        r12.put("cost_time", r10);     // Catch: Throwable -> L8
        r12.put("method_time", r10);     // Catch: Throwable -> L8
        r12.put("message", "launchTrace");     // Catch: Throwable -> L8
        r12.put("event_type", "lag_drop_frame");     // Catch: Throwable -> L8
        JSONObject r13 = q7.a.k().m(true);     // Catch: Throwable -> L8
        r13.put("crash_section", j.c(System.currentTimeMillis()));     // Catch: Throwable -> L8
        r13.put("trace_type", "launchTrace");     // Catch: Throwable -> L8
        r13.put("launchMode", String.valueOf(this.e));     // Catch: Throwable -> L8
        r13.put("customLaunchMode", "");     // Catch: Throwable -> L8
        r12.put("custom", r11);     // Catch: Throwable -> L8
        r12.put("filters", r13);     // Catch: Throwable -> L8
        i6.a.i().b(new j6.c("drop_frame_stack", r12));     // Catch: Throwable -> L8
        return;
    }
}
