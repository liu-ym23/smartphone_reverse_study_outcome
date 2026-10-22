package com.bytedance.apm6.cpu.exception.normal;

import android.util.Log;
import com.bytedance.apm.b;
import com.bytedance.apm.h.f;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.apm6.cpu.exception.ThreadExceptionItem;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.constants.Constants;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CpuNormalExceptionEvent implements Monitorable {
    private static final String EVENT_CPU_EXCEPTION = "cpu_exception_trace";
    private static final String KEY_BATTERY_RECHARGE_STATE = "battery_recharge_state";
    private static final String KEY_BATTERY_TEMPERATURE = "battery_temperature";
    public static final String KEY_MAX_BACKGROUND = "apm_max_background";
    public static final String KEY_MAX_FOREGROUND = "apm_max_foreground";
    private static final String KEY_PROCESS_SPEED_AVG = "process_speed_avg";
    private static final String KEY_PROCESS_SPEED_MAX = "process_speed_max";
    private static final String KEY_THREAD_CPU_USAGE = "cpu_usage";
    private static final String KEY_THREAD_INFO = "threads_info";
    private static final String KEY_THREAD_NAME = "thread_name";
    private static final String KEY_THREAD_PRIORITY = "nice";
    private static final String KEY_THREAD_STACK = "thread_back_trace";
    private static final String KEY_THREAD_TID = "thread_id";
    private static final String KEY_THREAD_WEIGHT = "weight";
    private double avgLoad;
    private boolean isBackground;
    private List<ThreadExceptionItem> itemList;
    private double maxLoad;
    private String scene;

    public CpuNormalExceptionEvent(double r3, double r5, List<ThreadExceptionItem> r7, String r8, boolean r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.avgLoad = r3;
        this.maxLoad = r5;
        this.scene = r8;
        this.isBackground = r9;
        this.itemList = new ArrayList(r10);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "cpu_exception_trace";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        List<ThreadExceptionItem> r0 = this.itemList;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L11;
        if (this.avgLoad <= 0.0d) goto L11;
        if (this.maxLoad <= 0.0d) goto L11;
        return true;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        JSONObject r2 = new JSONObject();
        r2.put(Constants.EVENT_TYPE, "cpu_exception_trace");     // Catch: Throwable -> L26
        r2.put("log_type", "cpu_exception_trace");     // Catch: Throwable -> L26
        r2.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L26
        r2.put("crash_time", System.currentTimeMillis());     // Catch: Throwable -> L26
        r2.put(LocationMonitorConst.IS_MAIN_PROCESS, b.f());     // Catch: Throwable -> L26
        r2.put("process_name", b.e());     // Catch: Throwable -> L26
        if (this.isBackground == false) goto L8;
        Object r1 = CpuReportEvent.VALUE_BACK;
    L7:
        r2.put("data_type", r1);     // Catch: Throwable -> L26
        r2.put(MemoryInfoSectionEditActivity.KIND_SCENE, this.scene);     // Catch: Throwable -> L26
        r2.put("report_scene", this.scene);     // Catch: Throwable -> L26
        if (b.w() <= b.i()) goto L13;
    L16:
        long r4 = b.i();     // Catch: Throwable -> L26
    L15:
        r2.put("app_launch_start_time", r4);     // Catch: Throwable -> L26
        r2.put(KEY_PROCESS_SPEED_AVG, this.avgLoad);     // Catch: Throwable -> L26
        r2.put(KEY_PROCESS_SPEED_MAX, this.maxLoad);     // Catch: Throwable -> L26
        r2.put(KEY_BATTERY_TEMPERATURE, f.a().b());     // Catch: Throwable -> L26
        r2.put(KEY_BATTERY_RECHARGE_STATE, f.a().c());     // Catch: Throwable -> L26
        JSONArray r3 = new JSONArray();     // Catch: Throwable -> L26
        Iterator<ThreadExceptionItem> r8 = this.itemList.iterator();     // Catch: Throwable -> L26
    L19:
        if (r8.hasNext() == false) goto L24;
        ThreadExceptionItem r5 = (ThreadExceptionItem) ZeusTransformUtils.preCheckCast(r8.next(), ThreadExceptionItem.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r5 == null) goto L19;
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L26
        r6.put(KEY_THREAD_PRIORITY, r5.getPriority());     // Catch: Throwable -> L26
        r6.put(KEY_THREAD_WEIGHT, Double.valueOf(r5.getWeight()));     // Catch: Throwable -> L26
        r6.put(KEY_THREAD_CPU_USAGE, r5.getCpuUsage());     // Catch: Throwable -> L26
        r6.put("thread_name", r5.getThreadName());     // Catch: Throwable -> L26
        r6.put(KEY_THREAD_STACK, r5.getStack());     // Catch: Throwable -> L26
        r6.put(KEY_THREAD_TID, r5.getThreadId());     // Catch: Throwable -> L26
        r3.put(r6);     // Catch: Throwable -> L26
        goto L19
    L24:
        r2.put(KEY_THREAD_INFO, r3);     // Catch: Throwable -> L26
    L29:
        Log.i(com.bytedance.apm6.cpu.Constants.TAG, "exception data: " + r2);
        return r2;
    L13:
        if (b.w() == 0) goto L16;
        r4 = b.w();     // Catch: Throwable -> L26
        goto L15
    L8:
        r1 = CpuReportEvent.VALUE_FRONT;
    L26:
        th = move-exception;
        Logger.e(com.bytedance.apm6.cpu.Constants.TAG, "cpu_exception_data_assemble", th);
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L31
        r7.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, th.getLocalizedMessage());     // Catch: Throwable -> L31
        CommonEventDeliverer.monitorDuration("cpu_exception_no_stack", r7, null);     // Catch: Throwable -> L31
        goto L29
    }
}
