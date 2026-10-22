package v4a;

import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.util.AnimaXMetricsCallback;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import t4a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends e {
    public final w4a.d a;
    public WeakReference<x4a.d> b;
    public boolean c;
    public final Map<String, Object> d;
    public long e;
    public int f;
    public int g;
    public final long h;

    public d(w4a.d r3) {
        this.c = false;
        this.d = new ConcurrentHashMap();
        this.a = r3;
        long r0 = System.currentTimeMillis();
        this.h = r0;
        this.e = r0;
    }

    @Override // t4a.f
    public final void d(t4a.c r1) {
        f(false);
    }

    public final void f(boolean r9) {
        this.f++;
        if (r9 == false) goto L5;
        this.g++;
    L5:
        long r2 = System.currentTimeMillis();
        if (this.c == true) goto L8;
    L11:
        h("onPlay");
        this.c = true;
        this.e = r2;
        return;
    L8:
        if (this.g >= 5) goto L11;
        if ((r2 - this.e) >= 300000) goto L11;
    }

    public final void h(String r6) {
        IAnimaXMonitorService r0 = (IAnimaXMonitorService) this.a.a(IAnimaXMonitorService.class);
        WeakReference<x4a.d> r1 = this.b;
        if (r1 == null) goto L5;
        x4a.d r2 = r1.get();
    L6:
        if (r2 == null) goto L14;
        if (r0 == null) goto L15;
        HashMap r3 = new HashMap(this.d);
        int r4 = this.f;
        if (r4 <= 0) goto L12;
        r3.put("play_count", Integer.valueOf(r4));
        this.f = 0;
        this.g = 0;
    L12:
        r2.f(new AnimaXMetricsCallback(r0, r6, r3));
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // t4a.e, t4a.f
    public final void i(t4a.a r3) {
        IAnimaXMonitorService r0 = (IAnimaXMonitorService) this.a.a(IAnimaXMonitorService.class);
        if (r0 == null) goto L6;
        r0.reportError(r3);
        return;
    }
}
