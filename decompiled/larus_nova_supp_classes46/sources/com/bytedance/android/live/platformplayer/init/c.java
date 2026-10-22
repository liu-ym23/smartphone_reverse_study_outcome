package com.bytedance.android.live.platformplayer.init;

import android.os.Debug;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import i60.e;
import java.util.HashMap;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final String a;

    public c() {
        this.a = "LivePlayerMonitorService";
    }

    public final Map<String, Long> a(boolean r7, boolean r8) {
        Map<String, Long> r2 = null;
        if (r7 == true) goto L10;
        if (r8 == true) goto L10;
    L14:
        e = e;
    L22:
        ALogger.e(this.a, e);
        return r2;
    L6:
        if (k.n(IPerformanceManager.class).getPssTotal() < 0) goto L10;
        HashMap r9 = new HashMap();     // Catch: Exception -> L14
        r9.put("mem_pss_total", Long.valueOf(k.n(IPerformanceManager.class).getPssTotal()));     // Catch: Exception -> L20
        r9.put("mem_pss_dalvik", Long.valueOf(k.n(IPerformanceManager.class).getPssDalvik()));     // Catch: Exception -> L20
        r2 = r9;
    L20:
        e = e;
        r2 = r9;
    L10:
        if (r2 != null) goto L16;
        IHostPerformanceMonitor r10 = TTMiddlewareLiveSDK.hostMiddlewareService().hostPerformanceMonitor();     // Catch: Exception -> L14
        if (r10 == null) goto L16;
        r2 = r10.getMemory();     // Catch: Exception -> L14
    L16:
        if (r2 != null) goto L28;
        r9 = new HashMap();     // Catch: Exception -> L14
        SettingKey r11 = e.a;     // Catch: Exception -> L20
        Debug.MemoryInfo r12 = new Debug.MemoryInfo();     // Catch: Exception -> L20
        Debug.getMemoryInfo(r12);     // Catch: Exception -> L20
        r9.put("mem_pss_total", Long.valueOf(r12.getTotalPss()));     // Catch: Exception -> L20
        Debug.MemoryInfo r13 = new Debug.MemoryInfo();     // Catch: Exception -> L20
        Debug.getMemoryInfo(r13);     // Catch: Exception -> L20
        r9.put("mem_pss_dalvik", Long.valueOf(r13.dalvikPss));     // Catch: Exception -> L20
        return r9;
    L28:
        return r2;
    }
}
