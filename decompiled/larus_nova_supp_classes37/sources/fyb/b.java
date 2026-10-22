package fyb;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.model.OPMonitorHeartBeatMonitorData;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TimerTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b extends TimerTask {
    public final /* synthetic */ d a;

    public final void a() {
        Log.i("OPMonitorHeartBeatManager", "heart upload start upload size: " + this.a.f.size());
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, OPMonitorHeartBeatMonitorData>> r2 = this.a.f.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L17;
        Map.Entry<String, OPMonitorHeartBeatMonitorData> r3 = r2.next();
        OPMonitorHeartBeatMonitorData r4 = r3.getValue();
        byb.a r5 = this.a.g.get(r3.getKey());
        if (r4 == null) goto L4;
        r0.add(r4.a);
        r4.d++;
        if (r4.c != 1) goto L12;
        if (r5 == null) goto L12;
        r4.c = r5.getCurrentHeartBeatStatus(r3.getKey());
    L15:
        if (r4.d <= this.a.a.c) goto L4;
        Log.i("OPMonitorHeartBeatManager", "data max upload count heartBeatID:" + r4.b);
        r4.c = 0;
    L12:
        if (r5 != null) goto L15;
        r4.c = 0;
        goto L15
    L17:
        d r6 = this.a;
        r6.getClass();
        if (r0.size() != 0) goto L20;
        Log.i("OPMonitorHeartBeatManager", "uploadData size = 0");
    L21:
        Log.i("OPMonitorHeartBeatManager", "heart upload end upload");
        d r1 = this.a;
        if (r1.f.size() != 0) goto L24;
        r1.g.clear();
    L32:
        Log.i("OPMonitorHeartBeatManager", "clear data is done after size:" + this.a.f.size());
        return;
    L24:
        Iterator<Map.Entry<String, OPMonitorHeartBeatMonitorData>> r7 = r1.f.entrySet().iterator();
    L26:
        if (r7.hasNext() == false) goto L32;
        Map.Entry<String, OPMonitorHeartBeatMonitorData> r8 = r7.next();
        if (r8.getValue() == null) goto L31;
        if (r8.getValue().c != 0) goto L26;
    L31:
        r7.remove();
        r1.g.remove(r8.getKey());
        goto L26
    L20:
        new OPMonitor("openplatform_ecosystem_monitor_report_heartbeat", r6.b).addCategoryValue("active_ids", GsonProtectorUtils.toJson(new Gson(), r0)).reportPlatform(4).flush();
        goto L21
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(d r1) {
        this.a = r1;
    }
}
