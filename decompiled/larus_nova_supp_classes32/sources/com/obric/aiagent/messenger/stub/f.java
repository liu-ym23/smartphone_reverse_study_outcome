package com.obric.aiagent.messenger.stub;

import android.os.SystemClock;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public final long a;
    public final long b;
    public long c;
    public long d;
    public boolean e;
    public long f;

    public final Map<String, Object> a() {
        Pair[] r0 = new Pair[5];
        r0[0] = TuplesKt.to("encrypt_cost_ms", Long.valueOf(this.d));
        r0[1] = TuplesKt.to("total_prepare_cost_ms", Long.valueOf(SystemClock.elapsedRealtime() - this.b));
        if (this.e == false) goto L5;
        long r1 = 1;
    L6:
        r0[2] = TuplesKt.to("feature_heif", Long.valueOf(r1));
        r0[3] = TuplesKt.to("screenshot_size", Long.valueOf(this.f));
        r0[4] = TuplesKt.to("flow_received_elapsed_ms", Long.valueOf(this.a));
        return MapsKt.mapOf(r0);
    L5:
        r1 = 0;
        goto L6
    }

    public f(long r1) {
        this.a = r1;
        this.b = SystemClock.elapsedRealtime();
    }
}
