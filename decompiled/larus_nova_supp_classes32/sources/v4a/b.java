package v4a;

import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements IAnimaXMonitorService {
    public String a;
    public final WeakReference<LynxContext> b;

    public b(LynxContext r2) {
        this.a = "unknown";
        this.b = new WeakReference(r2);
    }

    public final Map<String, Object> c(Map<String, Object> r4) {
        LynxContext r0 = this.b.get();
        if (r0 != null) goto L5;
        return r4;
    L5:
        HashMap r1 = new HashMap(r4);
        r1.put("src_url", a.a(this.a));
        r1.put("page_url", a.a(r0.getTemplateUrl()));
        r1.put("integration_type", "lynx");
        return r1;
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public final void reportError(t4a.a r4) {
        LynxContext r0 = this.b.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.enableEventReporter() == false) goto L10;
        Map<String, Object> r5 = c(r4.a);
        AnimaXLog.b("LynxAnimaXMonitorDefault", "reportError: " + r5);
        LynxEventReporter.onEvent("animax_error", r5, r0.getInstanceId());
        return;
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public final void reportPerformanceMetrics(c r6) {
        LynxContext r0 = this.b.get();
        if (r0 == null) goto L11;
        if (r6 == null) goto L11;
        if (r0.enableEventReporter() == true) goto L9;
        return;
    L9:
        HashMap r2 = new HashMap(r6.b.asHashMap());
        HashMap r3 = new HashMap(r6.a.asHashMap());
        HashMap r7 = new HashMap();
        r7.putAll(r2);
        r7.putAll(r3);
        Map<String, Object> r8 = c(r7);
        AnimaXLog.b("LynxAnimaXMonitorDefault", "reportPerformanceMetrics: " + r8);
        LynxEventReporter.onEvent("animax_performance", r8, r0.getInstanceId());
        return;
    L11:
        StringBuilder r4 = new StringBuilder("report failed, metrics is null:");
        boolean r5 = false;
        if (r6 != null) goto L14;
        boolean r9 = true;
    L15:
        r4.append(r9);
        r4.append(", context is null:");
        if (r0 != null) goto L18;
        r5 = true;
    L18:
        r4.append(r5);
        AnimaXLog.a("LynxAnimaXMonitorDefault", r4.toString());
        return;
    L14:
        r9 = false;
        goto L15
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public final void setCurrentUrl(String r1) {
        this.a = r1;
    }
}
