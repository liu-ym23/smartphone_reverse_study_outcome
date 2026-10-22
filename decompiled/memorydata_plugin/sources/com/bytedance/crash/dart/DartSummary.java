package com.bytedance.crash.dart;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DartSummary {
    public DartSummary() {
    }

    static CrashBody assemblyCrashBody(EventMonitor r4, String r5, long r6, String r8, Map<? extends String, ? extends String> r9, Map<String, String> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        CrashBody r0 = new CrashBody();
        if (r4.getBodyDumper() == null) goto L6;
        JSONUtils.combineJson(r0.getJson(), r4.getBodyDumper().load(CrashType.DART));     // Catch: Throwable -> L15
    L6:
        r0.put("is_dart", 1);     // Catch: Throwable -> L15
        r0.put("data", r8);     // Catch: Throwable -> L15
        r0.put("crash_time", Long.valueOf(r6));     // Catch: Throwable -> L15
        r0.put(CrashBody.CRASH_THREAD_NAME, r5);     // Catch: Throwable -> L15
        r0.put("process_name", App.getProcessName());     // Catch: Throwable -> L15
        r0.put("app_start_time", Long.valueOf(Global.getAppStartTime()));     // Catch: Throwable -> L15
        r0.put("upload_scene", "direct");     // Catch: Throwable -> L15
        MemoryInfo.pushTo(r0.getJson());     // Catch: Throwable -> L15
        Scraps.pushTo(r0.getJson());     // Catch: Throwable -> L15
        if (AppMonitorConfigService.enableUserCustomData() == false) goto L13;
        if (r11 == null) goto L13;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L15
        JSONUtils.put(r7, r11);     // Catch: Throwable -> L15
        if (r12 == null) goto L12;
        JSONUtils.put(r7, r12);     // Catch: Throwable -> L15
    L12:
        r0.put("custom", r7);     // Catch: Throwable -> L15
    L13:
        int r13 = Process.myPid();
        return r0.setHeader(Header.createEventHeader(r4, r6, CrashType.DART, r13));
    }
}
