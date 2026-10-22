package com.bytedance.apm6.cpu.collect;

import android.content.Context;
import android.util.Log;
import com.bytedance.apm.b;
import com.bytedance.apm.util.m;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.watson.assist.a.c;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    private List<m<String, Double>> threadUsageList;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.collect.CpuReportEvent$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType = null;

        static {
            int[] r0 = new int[CpuCacheItem.CpuDataType.values().length];
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType = r0;
            r0[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public CpuReportEvent(CpuCacheItem.CpuDataType r3, String r4, double r5, double r7, double r9, double r11, c.a r13) {
        this.metricRate = -1.0d;
        this.metricMaxRate = -1.0d;
        this.metricCpuSpeed = -1.0d;
        this.metricMaxCpuSpeed = -1.0d;
        this.batteryCurrent = -1.0f;
        this.isAutoSample = true;
        this.isNormalSampleState = true;
        this.dataType = r3;
        this.sceneString = r4;
        this.metricRate = r5;
        this.metricMaxRate = r7;
        this.metricCpuSpeed = r9;
        this.metricMaxCpuSpeed = r11;
        this.factorTag = r13;
    }

    public CpuReportEvent(CpuCacheItem.CpuDataType r3, String r4, List<m<String, Double>> r5, c.a r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.metricRate = -1.0d;
        this.metricMaxRate = -1.0d;
        this.metricCpuSpeed = -1.0d;
        this.metricMaxCpuSpeed = -1.0d;
        this.batteryCurrent = -1.0f;
        this.isAutoSample = true;
        this.isNormalSampleState = true;
        this.threadUsageList = new ArrayList(r7);
        this.dataType = r3;
        this.sceneString = r4;
        this.factorTag = r6;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraStatus() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L16
        r0.put("process_name", b.e());     // Catch: Throwable -> L16
        r0.put(LocationMonitorConst.IS_MAIN_PROCESS, b.f());     // Catch: Throwable -> L16
        r0.put(MemoryInfoSectionEditActivity.KIND_SCENE, this.sceneString);     // Catch: Throwable -> L16
        int r3 = AnonymousClass1.$SwitchMap$com$bytedance$apm6$cpu$collect$CpuCacheItem$CpuDataType[this.dataType.ordinal()];     // Catch: Throwable -> L16
        if (r3 != 1) goto L6;
        String r4 = VALUE_MIX;
    L11:
        r0.put("data_type", r4);     // Catch: Throwable -> L16
    L15:
        return r0;
    L6:
        if (r3 != 2) goto L8;
        r4 = VALUE_BACK;
        goto L11
    L8:
        if (r3 != 3) goto L15;
        r4 = VALUE_FRONT;
    L16:
        th = move-exception;
        Log.e(Constants.TAG, "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraValues() {
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L31
        if (hasThreadUsageData() == false) goto L20;
        Iterator<m<String, Double>> r8 = this.threadUsageList.iterator();     // Catch: Throwable -> L31
    L7:
        if (r8.hasNext() == false) goto L30;
        m r2 = (m) ZeusTransformUtils.preCheckCast(r8.next(), m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r2 == null) goto L7;
        if (r2.f1494a == 0) goto L7;
        if (((String) ZeusTransformUtils.preCheckCast(r2.f1494a, String.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L7;
        if (r2.f1495b == 0) goto L7;
        if (((Double) ZeusTransformUtils.preCheckCast(r2.f1495b, Double.class, "com.obric.memorydata.plugin")).doubleValue() == 0.0d) goto L7;
        r1.put((String) ZeusTransformUtils.preCheckCast(r2.f1494a, String.class, "com.obric.memorydata.plugin"), r2.f1495b);     // Catch: Throwable -> L31
    L30:
        return r1;
    L20:
        double r3 = this.metricRate;     // Catch: Throwable -> L31
        if (r3 > (-1.0d)) goto L23;
    L25:
        double r4 = this.metricCpuSpeed;     // Catch: Throwable -> L31
        if (r4 <= (-1.0d)) goto L30;
        if (this.metricMaxCpuSpeed <= (-1.0d)) goto L30;
        r1.put(PERF_APP_STAT_SPEED, r4);     // Catch: Throwable -> L31
        r1.put(PERF_APP_MAX_STAT_SPEED, this.metricMaxCpuSpeed);     // Catch: Throwable -> L31
        goto L30
    L23:
        if (this.metricMaxRate <= (-1.0d)) goto L25;
        r1.put(PERF_CPU_APP_USAGE_RATE, r3);     // Catch: Throwable -> L31
        r1.put(PERF_CPU_APP_MAX_USAGE_RATE, this.metricMaxRate);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Log.e(Constants.TAG, "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getFilters() {
        JSONObject r1 = PerfFilterManager.getInstance().getPerfFiltersJson();     // Catch: Throwable -> L10
        r1.put(FILTER_IS_AUTO_SAMPLE, this.isAutoSample);     // Catch: Throwable -> L10
        if (this.factorTag == null) goto L6;
        r1.put("network_type", NetworkUtils.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L10
        r1.put(FILTERS_BATTERY_LEVEL, this.factorTag.c);     // Catch: Throwable -> L10
        r1.put(FILTERS_CPU_HARDWARE, this.factorTag.f3361a);     // Catch: Throwable -> L10
        r1.put(FILTERS_IS_CHARGING, this.factorTag.f3362b);     // Catch: Throwable -> L10
        r1.put(FILTERS_POWER_SAVE_MODE, this.factorTag.e);     // Catch: Throwable -> L10
        r1.put(FILTERS_THERMAL_STATUS, this.factorTag.d);     // Catch: Throwable -> L10
        r1.put(FILTERS_BATTERY_THERMAL, this.factorTag.f);     // Catch: Throwable -> L10
        r1.put(FILTER_IS_NORMAL_SAMPLE_STATE, this.isNormalSampleState);     // Catch: Throwable -> L10
    L6:
        float r5 = this.batteryCurrent;     // Catch: Throwable -> L10
        if (r5 <= 0.0f) goto L9;
        r1.put(FILTERS_BATTERY_CURRENT, r5);     // Catch: Throwable -> L10
    L9:
        return r1;
    L10:
        th = move-exception;
        Log.e(Constants.TAG, "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public String getServiceName() {
        if (hasThreadUsageData() == false) goto L6;
        return SERVICE_NAME_THREAD;
    L6:
        return SERVICE_NAME;
    }

    public boolean hasThreadUsageData() {
        List<m<String, Double>> r0 = this.threadUsageList;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public void setBatteryCurrent(float r1) {
        this.batteryCurrent = r1;
    }

    public void setIsAutoSample(boolean r1) {
        this.isAutoSample = r1;
    }

    public void setNormalSampleState(boolean r1) {
        this.isNormalSampleState = r1;
    }
}
