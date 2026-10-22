package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyMonitor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class InteractBusinessPerformanceStrategyTask extends BasePerformanceStrategyTask {
    private final List<WeakReference<com.bytedance.android.livesdk.a>> degradeStrategyList;
    public boolean isInit;

    private String getLevelStr(int r2) {
        if (r2 != 1) goto L7;
        return "serious";
    L7:
        if (r2 != 2) goto L10;
        return "critical";
    L10:
        return "";
    }

    public boolean onTriggerEnhance(int r1, Map<String, String> r2, IPerformanceStrategyMonitor r3) {
        return false;
    }

    public void onTriggerOrigin(Map<String, String> r1, IPerformanceStrategyMonitor r2) {
    }

    public void init() {
        if (this.isInit == true) goto L9;
        IPerformanceStrategyManager r0 = jc1.k.f(IPerformanceStrategyManager.class);
        if (r0 == null) goto L7;
        r0.registerPerformanceStrategyTask(300, this);
    L7:
        this.isInit = true;
        return;
    }

    public InteractBusinessPerformanceStrategyTask() {
        this.degradeStrategyList = new CopyOnWriteArrayList();
        this.isInit = false;
    }

    public void addBusinessDegradeStrategy(com.bytedance.android.livesdk.a r3) {
        this.degradeStrategyList.add(new WeakReference(r3));
    }

    public void onDownGradeInfo(boolean r8, int r9) {
        HashMap r10 = new HashMap();
        r10.put("degrade_level", getLevelStr(r9));
        Iterator<WeakReference<com.bytedance.android.livesdk.a>> r0 = this.degradeStrategyList.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.a r2 = r0.next().get();
        if (r2 == null) goto L4;
        ALogger.w("LiveDegradeManager", "onDownGradeInfo" + r9);
        com.bytedance.android.livesdk.a.g = r9;
        r2.a(r9);
        if (r2.b == false) goto L4;
        r10.put("scene", r2.f.a());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_performance_monitor_biz_degrade", r10, new Object[]{com.bytedance.android.livesdk.log.filter.y.class});
        goto L4
    L10:
        HashMap r11 = new HashMap();
        r11.put("degrade_level", getLevelStr(r9));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_performance_monitor_degrade_notify", r11, new Object[]{com.bytedance.android.livesdk.log.filter.y.class});
    }

    public void resetBusinessDegradeStrategy(int r5, String r6) {
        Iterator<WeakReference<com.bytedance.android.livesdk.a>> r0 = this.degradeStrategyList.iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        com.bytedance.android.livesdk.a r1 = r0.next().get();
        if (r1 == null) goto L4;
        List r2 = r1.f.c();
        if (r2 == null) goto L4;
        if (r2.isEmpty() == true) goto L4;
        if (r2.contains(Integer.valueOf(r5)) == false) goto L4;
        if (r6 == null) goto L16;
        if (r1.f.a().equals(r6) == false) goto L4;
    L16:
        r1.b = false;
        r1.c = 0;
        goto L4
    }

    public boolean onDownGradeInfo(int r7, Map<String, String> r8, IPerformanceStrategyMonitor r9) {
        HashMap r10 = new HashMap();
        r10.put("degrade_level", getLevelStr(r7));
        Iterator<WeakReference<com.bytedance.android.livesdk.a>> r0 = this.degradeStrategyList.iterator();
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.a r3 = r0.next().get();
        if (r3 == null) goto L4;
        ALogger.w("LiveDegradeManager", "onDownGradeInfo" + r7);
        com.bytedance.android.livesdk.a.g = r7;
        r3.a(r7);
        if (r3.b == false) goto L4;
        r10.put("scene", r3.f.a());
        r9.updatePerformanceExecuteMonitor(r10, r7);
        r2 = true;
        goto L4
    L10:
        HashMap r11 = new HashMap();
        r11.put("degrade_level", getLevelStr(r7));
        r9.updatePerformanceNotifyMonitor(r11, r7);
        return r2;
    }

    public boolean onTriggerDegrade(int r1, Map<String, String> r2, IPerformanceStrategyMonitor r3) {
        onDownGradeInfo(r1, r2, r3);
        return false;
    }
}
