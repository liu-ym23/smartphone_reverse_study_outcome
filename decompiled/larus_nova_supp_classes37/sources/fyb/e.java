package fyb;

import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e extends a {
    public static final e b = null;
    public dyb.a a;

    static {
        b = new e();
    }

    public e() {
    }

    public e(dyb.a r1) {
        this.a = r1;
    }

    @Override // byb.e
    public final void flush(OPMonitor r11) {
        if (this.a != null) goto L6;
        return;
    L6:
        if (r11.getLevel() != OPMonitorLevel.TRACE) goto L8;
        return;
    L8:
        String r0 = getEventName(r11, this.a);
        if (r11.getReportPlatform() != 0) goto L11;
        this.a.getClass();
        r11.reportPlatform(2);
    L11:
        dyb.a r1 = this.a;
        HashMap<String, Object> r3 = r11.getMetrics();
        HashMap<String, Object> r4 = r11.getCategories();
        r11.getReportPlatform();
        r1.getClass();
        cyb.c r12 = dyb.a.c;
        HashMap r5 = new HashMap();
        r5.put("event_name", r0);
        r5.putAll(r3);
        r5.putAll(r4);
        monitor-enter(r12);
        Object r6 = r5.get("monitor_level");     // Catch: Throwable -> L48
        if ((r6 instanceof OPMonitorLevel) == false) goto L17;
        OPMonitorLevel r7 = (OPMonitorLevel) r6;     // Catch: Throwable -> L48
    L21:
        if (r7 == null) goto L34;
        int r8 = cyb.c.a.a[r7.ordinal()];     // Catch: Throwable -> L48
        if (r8 == 1) goto L34;
        if (r8 == 2) goto L34;
        if (r8 == 3) goto L34;
        if (r8 == 4) goto L34;
        if (r8 != 5) goto L34;
        double r9 = 0.0d;
    L36:
        if (r9 < 1.0d) goto L38;
        float r10 = 1.0f;
    L39:
        monitor-exit(r12);
        if (r10 == 0.0f) goto L54;
        byb.d r13 = r1.a;
        if ((r13 instanceof byb.b) == false) goto L46;
        ((byb.b) r13).getClass();
        byb.b.b(r3, r4);
        return;
    L46:
        r13.a(r0, r3, r4);
        return;
    L54:
        return;
    L38:
        r10 = 0.0f;
    L34:
        r9 = 1.0d;
        goto L36
    L17:
        if ((r6 instanceof Integer) == false) goto L19;
        r7 = OPMonitorLevel.forNumber(((Integer) r6).intValue());     // Catch: Throwable -> L48
        goto L21
    L19:
        r7 = null;
    L48:
        th = move-exception;
        throw th;
    }

    @Override // byb.e
    public final void log(OPMonitor r2) {
        log(r2, this.a);
    }
}
