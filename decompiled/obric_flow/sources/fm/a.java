package fm;

import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements IAnimaXMonitorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f16924b;

    public a(LynxContext r5) {
        this.f16923a = "unknown";
        this.f16924b = new WeakReference(r5);
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public final void reportError(dm.a r5) {
        WeakReference r10 = this.f16924b;
        LynxContext r11 = (LynxContext) r10.get();
        if (r11 == null) goto L10;
        Map r12 = (Map) r5.f10761a;
        LynxContext r13 = (LynxContext) r10.get();
        if (r13 == null) goto L8;
        HashMap r14 = new HashMap(r12);
        r14.put("src_url", i.a.i(this.f16923a));
        r14.put("page_url", i.a.i(r13.f10149q));
        r12 = r14;
    L8:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "LynxAnimaXMonitorDefault", "reportError: " + r12);
        LynxEventReporter.onEvent("animax_error", r12, r11.A);
        return;
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public final void reportPerformanceMetrics(b r10) {
        WeakReference r5 = this.f16924b;
        LynxContext r11 = (LynxContext) r5.get();
        if (r11 == null) goto L12;
        if (r10 == null) goto L12;
        JavaOnlyMap r12 = r10.f16926b;
        r12.getClass();
        HashMap r13 = new HashMap(r12);
        JavaOnlyMap r14 = r10.f16925a;
        r14.getClass();
        HashMap r15 = new HashMap(r14);
        HashMap r16 = new HashMap();
        r16.putAll(r13);
        r16.putAll(r15);
        LynxContext r17 = (LynxContext) r5.get();
        if (r17 == null) goto L10;
        HashMap r18 = new HashMap(r16);
        r18.put("src_url", i.a.i(this.f16923a));
        r18.put("page_url", i.a.i(r17.f10149q));
        r16 = r18;
    L10:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "LynxAnimaXMonitorDefault", "reportPerformanceMetrics: " + r16);
        LynxEventReporter.onEvent("animax_performance", r16, r11.A);
        return;
    L12:
        StringBuilder r19 = new StringBuilder("report failed, metrics is null:");
        boolean r20 = false;
        if (r10 != null) goto L15;
        boolean r21 = true;
    L16:
        r19.append(r21);
        r19.append(", context is null:");
        if (r11 != null) goto L19;
        r20 = true;
    L19:
        r19.append(r20);
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "LynxAnimaXMonitorDefault", r19.toString());
        return;
    L15:
        r21 = false;
        goto L16
    }

    @Override // com.lynx.animax.service.IAnimaXMonitorService
    public final void setCurrentUrl(String r5) {
        this.f16923a = r5;
    }
}
