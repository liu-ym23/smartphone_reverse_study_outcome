package com.bytedance.apm6.memory.monitorable;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.memory.bean.MemoryCollectInfo;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import com.bytedance.apm6.util.JsonUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class MemoryPerfDataEvent extends PerfBaseEvent {
    private static final String KEY_BLOCK_GC_COUNT = "block_gc_count";
    private static final String KEY_BLOCK_GC_TIME = "block_gc_time";
    private static final String KEY_GC_COUNT = "gc_count";
    private static final String KEY_GC_TIME = "gc_time";
    private static final String KEY_REACH_TOP_JAVA = "reach_top_java";
    private static final String PERF_MEM_DALVIK_PSS_BACKGROUND = "dalvik_pss_background";
    private static final String PERF_MEM_DALVIK_PSS_FOREGROUND = "dalvik_pss_foreground";
    private static final String PERF_MEM_GRAPHICS_MEM_BACKGROUND = "graphics_background";
    private static final String PERF_MEM_GRAPHICS_MEM_FOREGROUND = "graphics_foreground";
    private static final String PERF_MEM_NATIVE_PSS_BACKGROUND = "native_pss_background";
    private static final String PERF_MEM_NATIVE_PSS_FOREGROUND = "native_pss_foreground";
    private static final String PERF_MEM_TOTAL_JAVA_BACKGROUND = "java_heap_background";
    private static final String PERF_MEM_TOTAL_JAVA_BACKGROUND_USED_RATE = "java_heap_background_used_rate";
    private static final String PERF_MEM_TOTAL_JAVA_FOREGROUND = "java_heap_foreground";
    private static final String PERF_MEM_TOTAL_JAVA_FOREGROUND_USED_RATE = "java_heap_foreground_used_rate";
    private static final String PERF_MEM_TOTAL_PSS_BACKGROUND = "total_pss_background";
    private static final String PERF_MEM_TOTAL_PSS_FOREGROUND = "total_pss_foreground";
    private static final String PERF_MEM_VM_SIZE_BACKGROUND = "vm_size_background";
    private static final String PERF_MEM_VM_SIZE_FOREGROUND = "vm_size_foreground";
    private static final String SERVICE_NAME = "memory";
    private boolean background;
    private long blockingGcCount;
    private long blockingGcTime;
    private long dalvikUsedSize;
    private long gcCount;
    private long gcTime;
    private long graphics;
    private boolean isMemoryReachTop;
    private boolean isRealTimeMemEnable;
    private long javaUsedMemory;
    private double javaUsedMemoryRate;
    private Map<Object, Object> mmapInfo;
    private long nativePss;
    private long totalPss;
    private long vmSize;

    public MemoryPerfDataEvent(long r10, long r11, long r12, long r13, boolean r14, long r15, long r16, long r17, long r19, long r21, long r23, double r25, boolean r27, boolean r28) {
        this.gcCount = r10;
        this.gcTime = r11;
        this.blockingGcCount = r12;
        this.blockingGcTime = r13;
        this.background = r14;
        this.nativePss = r15;
        this.totalPss = r16;
        this.javaUsedMemory = r17;
        this.dalvikUsedSize = r19;
        this.graphics = r21;
        this.vmSize = r23;
        this.javaUsedMemoryRate = r25;
        this.isMemoryReachTop = r27;
        this.isRealTimeMemEnable = r28;
    }

    private void calMapsInfo(JSONObject r10) {
        if (r10 != null) goto L14;
        return;
    L14:
        Map<Object, Object> r11 = this.mmapInfo;     // Catch: Exception -> L13
        if (r11 != null) goto L7;
        return;
    L7:
        Iterator<Map.Entry<Object, Object>> r12 = r11.entrySet().iterator();     // Catch: Exception -> L13
    L9:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<Object, Object> r13 = r12.next();     // Catch: Exception -> L13
        r10.put((String) r13.getKey(), Long.parseLong((String) r13.getValue()));     // Catch: Exception -> L13
    L18:
        return;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraStatus() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L8
        r10.put("scene", PerfFilterManager.getInstance().getSceneString());     // Catch: Throwable -> L8
        r10.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Throwable -> L8
        if (this.background == true) goto L5;
        boolean r11 = true;
    L6:
        r10.put("is_front", r11);     // Catch: Throwable -> L8
        r10.put("is_main_process", ApmContext.isMainProcess());     // Catch: Throwable -> L8
        return r10;
    L5:
        r11 = false;
    L8:
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        JSONObject r10 = new JSONObject();
        r10.put(KEY_GC_COUNT, this.gcCount);     // Catch: JSONException -> L13
        r10.put(KEY_GC_TIME, this.gcTime);     // Catch: JSONException -> L13
        r10.put(KEY_BLOCK_GC_COUNT, this.blockingGcCount);     // Catch: JSONException -> L13
        r10.put(KEY_BLOCK_GC_TIME, this.blockingGcTime);     // Catch: JSONException -> L13
        if (this.background == false) goto L7;
        r10.put(PERF_MEM_DALVIK_PSS_BACKGROUND, this.dalvikUsedSize);     // Catch: JSONException -> L13
        r10.put(PERF_MEM_NATIVE_PSS_BACKGROUND, this.nativePss);     // Catch: JSONException -> L13
        r10.put(PERF_MEM_TOTAL_PSS_BACKGROUND, this.totalPss);     // Catch: JSONException -> L13
        r10.put(PERF_MEM_TOTAL_JAVA_BACKGROUND, this.javaUsedMemory);     // Catch: JSONException -> L13
        r10.put(PERF_MEM_TOTAL_JAVA_BACKGROUND_USED_RATE, this.javaUsedMemoryRate);     // Catch: JSONException -> L13
        r10.put(PERF_MEM_VM_SIZE_BACKGROUND, this.vmSize);     // Catch: JSONException -> L13
        String r11 = PERF_MEM_GRAPHICS_MEM_BACKGROUND;
        long r12 = this.graphics;     // Catch: JSONException -> L13
    L6:
        r10.put(r11, r12);     // Catch: JSONException -> L13
        if (this.isMemoryReachTop == false) goto L11;
        r10.put("reach_top_java", 1);     // Catch: JSONException -> L13
    L11:
        calMapsInfo(r10);     // Catch: JSONException -> L13
    L15:
        return r10;
    L7:
        r10.put(PERF_MEM_DALVIK_PSS_FOREGROUND, this.dalvikUsedSize);     // Catch: JSONException -> L13
        r10.put(PERF_MEM_NATIVE_PSS_FOREGROUND, this.nativePss);     // Catch: JSONException -> L13
        r10.put(PERF_MEM_TOTAL_PSS_FOREGROUND, this.totalPss);     // Catch: JSONException -> L13
        r10.put(PERF_MEM_TOTAL_JAVA_FOREGROUND, this.javaUsedMemory);     // Catch: JSONException -> L13
        r10.put(PERF_MEM_TOTAL_JAVA_FOREGROUND_USED_RATE, this.javaUsedMemoryRate);     // Catch: JSONException -> L13
        r10.put(PERF_MEM_VM_SIZE_FOREGROUND, this.vmSize);     // Catch: JSONException -> L13
        r11 = PERF_MEM_GRAPHICS_MEM_FOREGROUND;
        r12 = this.graphics;     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getFilters() {
        JSONObject r10 = PerfFilterManager.getInstance().getPerfFiltersJson();
        if (this.isRealTimeMemEnable == true) goto L14;
    L6:
        IDeviceInfoService r11 = (IDeviceInfoService) ServiceManager.getService(IDeviceInfoService.class);
        if (r11 != null) goto L12;
    L9:
        return r10;
    L12:
        JsonUtils.copyJson2(r10, r11.getDeviceInfo());     // Catch: Exception -> L11
        goto L9
    L14:
        JsonUtils.copyJson2(r10, PerfFilterManager.getInstance().getRealTimeMemInfo());     // Catch: Exception -> L10
        goto L6
    }

    public double getJavaUsedMemoryRate() {
        return this.javaUsedMemoryRate;
    }

    public MemoryCollectInfo getMemoryCollectInfo() {
        MemoryCollectInfo r10 = new MemoryCollectInfo();
        r10.gcCount = this.gcCount;
        r10.gcTime = this.gcTime;
        r10.blockingGcCount = this.blockingGcCount;
        r10.blockingGcTime = this.blockingGcTime;
        r10.background = this.background;
        r10.nativePss = this.nativePss;
        r10.totalPss = this.totalPss;
        r10.javaUsedMemory = this.javaUsedMemory;
        r10.dalvikUsedSize = this.dalvikUsedSize;
        r10.graphics = this.graphics;
        r10.vmSize = this.vmSize;
        r10.isMemoryReachTop = this.isMemoryReachTop;
        return r10;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return "memory";
    }

    public boolean isBackground() {
        return this.background;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public void setMmapInfo(Map<Object, Object> r10) {
        this.mmapInfo = r10;
    }

    public String toString() {
        return "MemoryPerfMonitorable{gcCount=" + this.gcCount + ", gcTime=" + this.gcTime + ", blockingGcCount=" + this.blockingGcCount + ", blockingGcTime=" + this.blockingGcTime + ", background=" + this.background + ", nativePss=" + this.nativePss + ", totalPss=" + this.totalPss + ", javaUsedMemory=" + this.javaUsedMemory + ", dalvikUsedSize=" + this.dalvikUsedSize + ", graphics=" + this.graphics + ", vmSize=" + this.vmSize + ", javaUsedMemoryRate=" + this.javaUsedMemoryRate + ", isMemoryReachTop=" + this.isMemoryReachTop + '}';
    }
}
