package com.bytedance.salamander.anniex;

import com.bytedance.apm.ApmAgent;
import com.bytedance.salamander.adapter.Lock;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class SLAnnieXMonitor$doReportJSException$2 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f7220a;

    public SLAnnieXMonitor$doReportJSException$2(t r5) {
        this.f7220a = r5;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        Map r5 = f.e(this.f7220a);
        SLEventType r10 = SLEventType.f7229c;
        Intrinsics.checkNotNullParameter(r10, "eventType");
        Intrinsics.checkNotNullParameter(r5, "result");
        Intrinsics.checkNotNullParameter(r5, "jsonMap");
        String r11 = new JSONObject(r5).toString();
        Intrinsics.checkNotNull(r11);
        a.b("SLMonitor report: ", r11);
        Intrinsics.checkNotNullParameter("bd_hybrid_monitor_p_zero", "logType");
        Intrinsics.checkNotNullParameter(r5, "result");
        ApmAgent.monitorCommonLog("bd_hybrid_monitor_p_zero", new JSONObject(r5));
        Lock r12 = q.d;
        Iterator r13 = p.a().f7274b.iterator();
        if (r13.hasNext() == true) goto L7;
        return Unit.INSTANCE;
    L7:
        if (r13.next() != null) goto L11;
        a.a(r10);
        throw null;
    L11:
        throw new ClassCastException();
    }
}
