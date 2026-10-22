package com.bytedance.vmsdk.monitor;

import android.util.Log;
import com.bytedance.framwork.core.sdkmonitor.f;
import com.bytedance.vmsdk.jsbridge.utils.CalledByNative;
import com.bytedance.vmsdk.log.VLog;
import hk.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class VmSdkMonitor {
    public static synchronized void a() {
        monitor-enter(VmSdkMonitor.class);
        VLog.init();     // Catch: Throwable -> L6
        f.d("8398", a.f17335a);     // Catch: Throwable -> L6
        f.e("8398", a.f17336b);     // Catch: Throwable -> L6
        new JSONObject();     // Catch: Throwable -> L6
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private static boolean getSettings(String r5) {
        jk.a r10 = jk.a.m();
        monitor-enter(r10);
        r10.f18351c = r10.o();     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        boolean r11 = jk.a.m().i(r5);
        Log.d("VmSdkMonitor", "VmSdkMonitor getSettings from native, key:" + r5 + " value: " + r11);
        return r11;
    L8:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private static int getSettingsFlag() {
        jk.a r5 = jk.a.m();
        monitor-enter(r5);
        r5.f18351c = r5.o();     // Catch: Throwable -> L23
        monitor-exit(r5);     // Catch: Throwable -> L23
        jk.a r10 = jk.a.m();
        r10.getClass();
        int r11 = p9.a.f21322a;     // Catch: Throwable -> L9
        throw new RuntimeException("ExperimentManager has not been init");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.e("VmSdkSettingsManager", "experiment may not be initialized,failed to get experimentValue: " + th);
        HashMap r12 = (HashMap) r10.f18351c;
        int r13 = 0;
        if (r12 != null) goto L28;
    L21:
        Log.d("VmSdkMonitor", "VmSdkMonitor getSettingsFlag from native value: " + r13);
        return r13;
    L28:
        Map r14 = (Map) r12.get("vmsdk_common");     // Catch: Throwable -> L19
        if (r14 == null) goto L21;
        Object r15 = r14.get("VMSDK");     // Catch: Throwable -> L19
        Log.i("VmSdkSettingsManager", "getSettingsFlag success, key: VMSDK , value: " + r15);     // Catch: Throwable -> L19
        if (r15 == null) goto L21;
        r13 = ((Integer) r15).intValue();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Log.e("VmSdkSettingsManager", "getSettingsFlag error " + th.toString());
    L23:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private static void monitorEvent(String r5, String r10, String r11, String r12) {
        StringBuilder r13 = com.lynx.tasm.base.a.e("monitorEvent from native, moduleName:", r5, " bizName:", r10, " dataKey:");
        r13.append(r11);
        r13.append(" dataValue:");
        r13.append(r12);
        Log.d("VmSdkMonitor", r13.toString());
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L5
        r14.put("biz_name", r10);     // Catch: Throwable -> L5
        r14.put(r11, r12);     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        Log.e("VmSdkMonitor", "VmSdkMonitor upload error: " + th.getMessage());
    }
}
