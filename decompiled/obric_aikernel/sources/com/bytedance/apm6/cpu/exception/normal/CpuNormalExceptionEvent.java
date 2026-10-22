package com.bytedance.apm6.cpu.exception.normal;

import android.util.Log;
import com.bytedance.apm.d;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.apm6.cpu.exception.ThreadExceptionItem;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crash.constants.Constants;
import i0.g;
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

    public CpuNormalExceptionEvent(double r10, double r11, List<ThreadExceptionItem> r12, String r13, boolean r14) {
        this.avgLoad = r10;
        this.maxLoad = r11;
        this.scene = r13;
        this.isBackground = r14;
        this.itemList = new ArrayList(r12);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "cpu_exception_trace";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        List<ThreadExceptionItem> r10 = this.itemList;
        if (r10 != null) goto L5;
    L11:
        return false;
    L5:
        if (r10.isEmpty() == true) goto L11;
        if (this.avgLoad <= 0.0d) goto L11;
        if (this.maxLoad <= 0.0d) goto L11;
        return true;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        JSONObject r10 = new JSONObject();
        r10.put(Constants.EVENT_TYPE, "cpu_exception_trace");     // Catch: Throwable -> L26
        r10.put("log_type", "cpu_exception_trace");     // Catch: Throwable -> L26
        r10.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L26
        r10.put("crash_time", System.currentTimeMillis());     // Catch: Throwable -> L26
        r10.put("is_main_process", d.I());     // Catch: Throwable -> L26
        r10.put("process_name", d.h());     // Catch: Throwable -> L26
        if (this.isBackground == false) goto L8;
        Object r11 = CpuReportEvent.VALUE_BACK;
    L7:
        r10.put("data_type", r11);     // Catch: Throwable -> L26
        r10.put("scene", this.scene);     // Catch: Throwable -> L26
        r10.put("report_scene", this.scene);     // Catch: Throwable -> L26
        if (d.f() <= d.B()) goto L13;
    L16:
        long r12 = d.B();     // Catch: Throwable -> L26
    L15:
        r10.put("app_launch_start_time", r12);     // Catch: Throwable -> L26
        r10.put(KEY_PROCESS_SPEED_AVG, this.avgLoad);     // Catch: Throwable -> L26
        r10.put(KEY_PROCESS_SPEED_MAX, this.maxLoad);     // Catch: Throwable -> L26
        r10.put(KEY_BATTERY_TEMPERATURE, g.d().f());     // Catch: Throwable -> L26
        r10.put(KEY_BATTERY_RECHARGE_STATE, g.d().e());     // Catch: Throwable -> L26
        JSONArray r13 = new JSONArray();     // Catch: Throwable -> L26
        Iterator<ThreadExceptionItem> r14 = this.itemList.iterator();     // Catch: Throwable -> L26
    L19:
        if (r14.hasNext() == false) goto L24;
        ThreadExceptionItem r15 = r14.next();     // Catch: Throwable -> L26
        if (r15 == null) goto L19;
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L26
        r16.put(KEY_THREAD_PRIORITY, r15.getPriority());     // Catch: Throwable -> L26
        r16.put(KEY_THREAD_WEIGHT, Double.valueOf(r15.getWeight()));     // Catch: Throwable -> L26
        r16.put(KEY_THREAD_CPU_USAGE, r15.getCpuUsage());     // Catch: Throwable -> L26
        r16.put(KEY_THREAD_NAME, r15.getThreadName());     // Catch: Throwable -> L26
        r16.put(KEY_THREAD_STACK, r15.getStack());     // Catch: Throwable -> L26
        r16.put(KEY_THREAD_TID, r15.getThreadId());     // Catch: Throwable -> L26
        r13.put(r16);     // Catch: Throwable -> L26
        goto L19
    L24:
        r10.put(KEY_THREAD_INFO, r13);     // Catch: Throwable -> L26
    L29:
        Log.i(com.bytedance.apm6.cpu.Constants.TAG, "exception data: " + r10);
        return r10;
    L13:
        if (d.f() == 0) goto L16;
        r12 = d.f();     // Catch: Throwable -> L26
        goto L15
    L8:
        r11 = CpuReportEvent.VALUE_FRONT;
    L26:
        th = move-exception;
        Logger.e(com.bytedance.apm6.cpu.Constants.TAG, "cpu_exception_data_assemble", th);
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L31
        r17.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, th.getLocalizedMessage());     // Catch: Throwable -> L31
        CommonEventDeliverer.monitorDuration("cpu_exception_no_stack", r17, null);     // Catch: Throwable -> L31
        goto L29
    }
}
