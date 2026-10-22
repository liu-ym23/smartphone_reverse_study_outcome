package z1b;

import android.os.SystemClock;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends q5c.a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final int h;

    public a() {
        this.a = "send_start_time";
        this.b = "send_end_time";
        this.c = "send_diff_time";
        this.d = "send_state";
        this.e = "msg_type";
        this.f = "msg_length";
        this.g = 1;
        this.h = 2;
    }

    public final void a() {
        if (getDefaultParamsMap().get(this.a) == null) goto L6;
        Object r0 = getDefaultParamsMap().get(this.a);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Long");
        long r1 = ((Long) r0).longValue();
        long r2 = SystemClock.elapsedRealtime();
        Long r4 = Long.valueOf(r2);
        getDefaultParamsMap().put(this.b, r4);
        getDefaultParamsMap().put(this.c, Long.valueOf(r2 - r1));
        Statistics.sendEvent("perf_send_msg", new JSONObject().put(this.a, getDefaultParamsMap().get(this.a)).put(this.b, getDefaultParamsMap().get(this.b)).put(this.c, getDefaultParamsMap().get(this.c)).put(this.d, getDefaultParamsMap().get(this.d)).put(this.e, getDefaultParamsMap().get(this.e)).put(this.f, getDefaultParamsMap().get(this.f)));
        return;
    }
}
