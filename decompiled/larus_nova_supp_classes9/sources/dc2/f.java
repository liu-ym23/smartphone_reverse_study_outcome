package dc2;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public long a;
    public long b;
    public boolean c;
    public final String d;
    public final long e;

    public f(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "syncKey");
        this.d = r2;
        this.e = r3;
        this.b = -1;
    }

    public final void a(boolean r6, boolean r7, Long r8, String r9, Throwable r10) {
        this.c = true;
        if (this.a > 0) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis() - this.a;
        JSONObject r2 = new JSONObject();
        r2.put("key", this.d);
        r2.put("success", r6);
        r2.put("timeout", r7);
        JSONObject r11 = new JSONObject();
        r11.put("realWaitTime", r0);
        JSONObject r13 = new JSONObject();
        r13.put("room_id", this.e);
        r13.put("wait_version", this.b);
        if (r8 == null) goto L8;
        r13.put("receive_version", r8.longValue());
    L8:
        if (r9 == null) goto L10;
        r13.put("bizLogId", r9);
    L10:
        if (r10 == null) goto L12;
        r13.put("error", r10.getMessage());
    L12:
        LiveTracingMonitor.f("ttlive_wrds_wait_time", LiveTracingMonitor.EventModule.LIVE_MESSAGE, r2, r11, r13);
    }
}
