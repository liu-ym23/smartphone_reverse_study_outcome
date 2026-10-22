package com.bytedance.apm6.cpu.collect;

import android.util.Log;
import androidx.annotation.Nullable;
import com.bytedance.apm.d;
import com.bytedance.apm.util.o;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.common.utility.NetworkUtils;
import g5.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CpuReportEvent extends PerfBaseEvent {
    private static final String FILTERS_BATTERY_CURRENT = "battery_current";
    private static final String FILTERS_BATTERY_LEVEL = "battery_level";
    private static final String FILTERS_BATTERY_THERMAL = "battery_thermal";
    private static final String FILTERS_CPU_HARDWARE = "cpu_hardware";
    private static final String FILTERS_IS_CHARGING = "is_charging";
    private static final String FILTERS_NETWORK_TYPE = "network_type";
    private static final String FILTERS_POWER_SAVE_MODE = "power_save_mode";
    private static final String FILTERS_THERMAL_STATUS = "thermal_status";
    private static final String FILTER_IS_AUTO_SAMPLE = "is_auto_sample";
    private static final String FILTER_IS_NORMAL_SAMPLE_STATE = "is_normal_sample_state";
    private static final String PERF_APP_MAX_STAT_SPEED = "app_max_stat_speed";
    private static final String PERF_APP_STAT_SPEED = "app_stat_speed";
    private static final String PERF_CPU_APP_MAX_USAGE_RATE = "app_max_usage_rate";
    private static final String PERF_CPU_APP_USAGE_RATE = "app_usage_rate";
    public static final String PERF_DATA_TYPE = "data_type";
    private static final String PERF_THREAD_CPU_USAGE = "thread_cpu_usage";
    private static final String SERVICE_NAME = "cpu";
    private static final String SERVICE_NAME_THREAD = "cpu_thread";
    public static final String VALUE_BACK = "back";
    public static final String VALUE_FRONT = "front";
    public static final String VALUE_MIX = "mix";
    private float batteryCurrent;
    private CpuCacheItem.CpuDataType dataType;
    private c.a factorTag;
    private boolean isAutoSample;
    private boolean isNormalSampleState;
    private double metricCpuSpeed;
    private double metricMaxCpuSpeed;
    private double metricMaxRate;
    private double metricRate;
    private String sceneString;
    private List<o<String, Double>> threadUsageList;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.collect.CpuReportEvent$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType = null;

        static {
            int[] r10 = new int[CpuCacheItem.CpuDataType.values().length];
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType = r10;
            r10[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public CpuReportEvent(CpuCacheItem.CpuDataType r10, String r11, double r12, double r13, double r14, double r15, @Nullable c.a r16) {
        this.metricRate = -1.0d;
        this.metricMaxRate = -1.0d;
        this.metricCpuSpeed = -1.0d;
        this.metricMaxCpuSpeed = -1.0d;
        this.batteryCurrent = -1.0f;
        this.isAutoSample = true;
        this.isNormalSampleState = true;
        this.dataType = r10;
        this.sceneString = r11;
        this.metricRate = r12;
        this.metricMaxRate = r13;
        this.metricCpuSpeed = r14;
        this.metricMaxCpuSpeed = r15;
        this.factorTag = r16;
    }

    public CpuReportEvent(CpuCacheItem.CpuDataType r10, String r11, List<o<String, Double>> r12, c.a r13) {
        this.metricRate = -1.0d;
        this.metricMaxRate = -1.0d;
        this.metricCpuSpeed = -1.0d;
        this.metricMaxCpuSpeed = -1.0d;
        this.batteryCurrent = -1.0f;
        this.isAutoSample = true;
        this.isNormalSampleState = true;
        this.threadUsageList = new ArrayList(r12);
        this.dataType = r10;
        this.sceneString = r11;
        this.factorTag = r13;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraStatus() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L16
        r10.put("process_name", d.h());     // Catch: Throwable -> L16
        r10.put("is_main_process", d.I());     // Catch: Throwable -> L16
        r10.put("scene", this.sceneString);     // Catch: Throwable -> L16
        int r11 = AnonymousClass1.$SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[this.dataType.ordinal()];     // Catch: Throwable -> L16
        if (r11 != 1) goto L6;
        String r12 = VALUE_MIX;
    L11:
        r10.put("data_type", r12);     // Catch: Throwable -> L16
    L15:
        return r10;
    L6:
        if (r11 != 2) goto L8;
        r12 = VALUE_BACK;
        goto L11
    L8:
        if (r11 != 3) goto L15;
        r12 = VALUE_FRONT;
    L16:
        th = move-exception;
        Log.e(Constants.TAG, "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L30
        if (hasThreadUsageData() == false) goto L19;
        Iterator<o<String, Double>> r11 = this.threadUsageList.iterator();     // Catch: Throwable -> L30
    L6:
        if (r11.hasNext() == false) goto L29;
        o<String, Double> r12 = r11.next();     // Catch: Throwable -> L30
        if (r12 == null) goto L6;
        String r13 = r12.f1139a;     // Catch: Throwable -> L30
        if (r13 == null) goto L6;
        if (r13.isEmpty() == true) goto L6;
        Double r14 = r12.f1140b;     // Catch: Throwable -> L30
        if (r14 == null) goto L6;
        if (r14.doubleValue() == 0.0d) goto L6;
        r10.put(r12.f1139a, r12.f1140b);     // Catch: Throwable -> L30
    L29:
        return r10;
    L19:
        double r15 = this.metricRate;     // Catch: Throwable -> L30
        if (r15 > (-1.0d)) goto L22;
    L24:
        double r16 = this.metricCpuSpeed;     // Catch: Throwable -> L30
        if (r16 <= (-1.0d)) goto L29;
        if (this.metricMaxCpuSpeed <= (-1.0d)) goto L29;
        r10.put(PERF_APP_STAT_SPEED, r16);     // Catch: Throwable -> L30
        r10.put(PERF_APP_MAX_STAT_SPEED, this.metricMaxCpuSpeed);     // Catch: Throwable -> L30
        goto L29
    L22:
        if (this.metricMaxRate <= (-1.0d)) goto L24;
        r10.put(PERF_CPU_APP_USAGE_RATE, r15);     // Catch: Throwable -> L30
        r10.put(PERF_CPU_APP_MAX_USAGE_RATE, this.metricMaxRate);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        Log.e(Constants.TAG, "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getFilters() {
        JSONObject r10 = PerfFilterManager.getInstance().getPerfFiltersJson();     // Catch: Throwable -> L9
        r10.put(FILTER_IS_AUTO_SAMPLE, this.isAutoSample);     // Catch: Throwable -> L9
        if (this.factorTag == null) goto L5;
        r10.put("network_type", NetworkUtils.f(d.g()));     // Catch: Throwable -> L9
        r10.put(FILTERS_BATTERY_LEVEL, this.factorTag.f8978c);     // Catch: Throwable -> L9
        r10.put(FILTERS_CPU_HARDWARE, this.factorTag.f8976a);     // Catch: Throwable -> L9
        r10.put(FILTERS_IS_CHARGING, this.factorTag.f8977b);     // Catch: Throwable -> L9
        r10.put(FILTERS_POWER_SAVE_MODE, this.factorTag.f8980e);     // Catch: Throwable -> L9
        r10.put(FILTERS_THERMAL_STATUS, this.factorTag.f8979d);     // Catch: Throwable -> L9
        r10.put(FILTERS_BATTERY_THERMAL, this.factorTag.f8981f);     // Catch: Throwable -> L9
        r10.put(FILTER_IS_NORMAL_SAMPLE_STATE, this.isNormalSampleState);     // Catch: Throwable -> L9
    L5:
        float r11 = this.batteryCurrent;     // Catch: Throwable -> L9
        if (r11 <= 0.0f) goto L8;
        r10.put(FILTERS_BATTERY_CURRENT, r11);     // Catch: Throwable -> L9
    L8:
        return r10;
    L9:
        th = move-exception;
        Log.e(Constants.TAG, "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        if (hasThreadUsageData() == false) goto L6;
        return SERVICE_NAME_THREAD;
    L6:
        return SERVICE_NAME;
    }

    public boolean hasThreadUsageData() {
        List<o<String, Double>> r10 = this.threadUsageList;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isEmpty() == true) goto L7;
        return true;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public void setBatteryCurrent(float r10) {
        this.batteryCurrent = r10;
    }

    public void setIsAutoSample(boolean r10) {
        this.isAutoSample = r10;
    }

    public void setNormalSampleState(boolean r10) {
        this.isNormalSampleState = r10;
    }
}
