package y7a;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.performance.PerformanceController;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public final String a;
    public final HashMap<String, Long> b;
    public boolean c;

    public final JavaOnlyMap c() {
        JavaOnlyMap r0 = new JavaOnlyMap();
        if (this.c == false) goto L5;
        return r0;
    L5:
        r0.putString("pipelineOrigin", this.a);
        r0.putMap("timestampMap", JavaOnlyMap.from(this.b));
        return r0;
    }

    public h(String r2) {
        this.c = false;
        this.a = r2;
        this.b = new HashMap();
    }

    public final void b(String r4) {
        if (this.c == false) goto L5;
        return;
    L5:
        long r0 = PerformanceController.j();
        this.b.put(r4, Long.valueOf(r0));
    }

    public static h a(String r4, String r5, boolean r6) {
        h r0 = new h(r4);
        r0.c = r6;
        if (r6 == false) goto L5;
        return r0;
    L5:
        long r1 = PerformanceController.j();
        if (r0.c == true) goto L10;
        r0.b.put("pipelineStart", Long.valueOf(r1));
    L10:
        if (r0.c == true) goto L13;
        r0.b.put(r5, Long.valueOf(r1));
    L13:
        return r0;
    }
}
