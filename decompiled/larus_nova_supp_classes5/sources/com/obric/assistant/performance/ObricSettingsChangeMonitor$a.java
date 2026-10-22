package com.obric.assistant.performance;

import com.bytedance.news.common.settings.SettingsManager;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricSettingsChangeMonitor$a implements f09.a.b {
    public ObricSettingsChangeMonitor$a() {
    }

    public final void onAllActivityDestroyed() {
    }

    public final void onAppForeground() {
    }

    public final void onAppBackground() {
        FLogger r1 = FLogger.a;
        r1.d("ObricPerformanceMonitor", "onAppBackground: try pull settings");
    L16:
        e = move-exception;
        FLogger.a.e("ObricPerformanceMonitor", "updateSettings: error", e);
        return;
    L4:
        if (ObricSettingsChangeMonitor.d != SettingsChangeMonitorMode.TIGGER_SETTINGS_PULL) goto L14;
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L16
        if ((r3 - ObricSettingsChangeMonitor.j) < ((ObricSettingsChangeMonitor.h * ((long) 60)) * ((long) 1000))) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        r1.i("ObricPerformanceMonitor", "checkSettingsVersionChange: trigger settings pull");     // Catch: Exception -> L16
        SettingsManager.updateSettings(true);     // Catch: Exception -> L16
        ObricSettingsChangeMonitor.a();     // Catch: Exception -> L16
        return;
    L8:
        if (r3 < ObricSettingsChangeMonitor.j) goto L11;
        r4 = false;
    L14:
        r1.d("ObricPerformanceMonitor", "no need to pull settings, lastPullTime=" + ObricSettingsChangeMonitor.j + ", monitorMode=" + ObricSettingsChangeMonitor.d);     // Catch: Exception -> L16
    }
}
