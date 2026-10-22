package b8a;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends l {
    public d(HashMap<String, Object> r3) {
        super(r3);
        m.d(r3, "stage");
        Double r0 = Double.valueOf(-1.0d);
        m.b(r3, "total_blocking_time", r0).doubleValue();
        m.b(r3, "total_blocking_count", r0).doubleValue();
        m.b(r3, "total_duration", r0).doubleValue();
        m.b(r3, "blocking_ratio", r0).doubleValue();
        m.b(r3, "avg_blocking_time", r0).doubleValue();
        m.b(r3, "time_after_fcp", r0).doubleValue();
    }
}
