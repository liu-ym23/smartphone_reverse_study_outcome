package com.bytedance.apm6.memory.monitorable;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.memory.bean.MemoryCollectInfo;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public MemoryPerfDataEvent(long r4, long r6, long r8, long r10, boolean r12, long r13, long r15, long r17, long r19, long r21, long r23, double r25, boolean r27, boolean r28) {
        this.gcCount = r4;
        this.gcTime = r6;
        this.blockingGcCount = r8;
        this.blockingGcTime = r10;
        this.background = r12;
        this.nativePss = r13;
        this.totalPss = r15;
        this.javaUsedMemory = r17;
        this.dalvikUsedSize = r19;
        this.graphics = r21;
        this.vmSize = r23;
        this.javaUsedMemoryRate = r25;
        this.isMemoryReachTop = r27;
        this.isRealTimeMemEnable = r28;
    }

    private void calMapsInfo(JSONObject r6) {
        if (r6 != null) goto L15;
        return;
    L15:
        Map<Object, Object> r5 = this.mmapInfo;     // Catch: Exception -> L14
        if (r5 != null) goto L8;
        return;
    L8:
        Iterator<Map.Entry<Object, Object>> r7 = r5.entrySet().iterator();     // Catch: Exception -> L14
    L10:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        r6.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), Long.parseLong((String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin")));     // Catch: Exception -> L14
    L19:
        return;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraStatus() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L8
        r0.put(MemoryInfoSectionEditActivity.KIND_SCENE, PerfFilterManager.getInstance().getSceneString());     // Catch: Throwable -> L8
        r0.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Throwable -> L8
        if (this.background == true) goto L5;
        boolean r3 = true;
    L6:
        r0.put("is_front", r3);     // Catch: Throwable -> L8
        r0.put(LocationMonitorConst.IS_MAIN_PROCESS, ApmContext.isMainProcess());     // Catch: Throwable -> L8
        return r0;
    L5:
        r3 = false;
    L8:
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraValues() {
        JSONObject r0 = new JSONObject();
        r0.put(KEY_GC_COUNT, this.gcCount);     // Catch: JSONException -> L13
        r0.put(KEY_GC_TIME, this.gcTime);     // Catch: JSONException -> L13
        r0.put(KEY_BLOCK_GC_COUNT, this.blockingGcCount);     // Catch: JSONException -> L13
        r0.put(KEY_BLOCK_GC_TIME, this.blockingGcTime);     // Catch: JSONException -> L13
        if (this.background == false) goto L7;
        r0.put(PERF_MEM_DALVIK_PSS_BACKGROUND, this.dalvikUsedSize);     // Catch: JSONException -> L13
        r0.put(PERF_MEM_NATIVE_PSS_BACKGROUND, this.nativePss);     // Catch: JSONException -> L13
        r0.put(PERF_MEM_TOTAL_PSS_BACKGROUND, this.totalPss);     // Catch: JSONException -> L13
        r0.put(PERF_MEM_TOTAL_JAVA_BACKGROUND, this.javaUsedMemory);     // Catch: JSONException -> L13
        r0.put(PERF_MEM_TOTAL_JAVA_BACKGROUND_USED_RATE, this.javaUsedMemoryRate);     // Catch: JSONException -> L13
        r0.put(PERF_MEM_VM_SIZE_BACKGROUND, this.vmSize);     // Catch: JSONException -> L13
        String r1 = PERF_MEM_GRAPHICS_MEM_BACKGROUND;
        long r2 = this.graphics;     // Catch: JSONException -> L13
    L6:
        r0.put(r1, r2);     // Catch: JSONException -> L13
        if (this.isMemoryReachTop == false) goto L11;
        r0.put("reach_top_java", 1);     // Catch: JSONException -> L13
    L11:
        calMapsInfo(r0);     // Catch: JSONException -> L13
    L15:
        return r0;
    L7:
        r0.put(PERF_MEM_DALVIK_PSS_FOREGROUND, this.dalvikUsedSize);     // Catch: JSONException -> L13
        r0.put(PERF_MEM_NATIVE_PSS_FOREGROUND, this.nativePss);     // Catch: JSONException -> L13
        r0.put(PERF_MEM_TOTAL_PSS_FOREGROUND, this.totalPss);     // Catch: JSONException -> L13
        r0.put(PERF_MEM_TOTAL_JAVA_FOREGROUND, this.javaUsedMemory);     // Catch: JSONException -> L13
        r0.put(PERF_MEM_TOTAL_JAVA_FOREGROUND_USED_RATE, this.javaUsedMemoryRate);     // Catch: JSONException -> L13
        r0.put(PERF_MEM_VM_SIZE_FOREGROUND, this.vmSize);     // Catch: JSONException -> L13
        r1 = PERF_MEM_GRAPHICS_MEM_FOREGROUND;
        r2 = this.graphics;     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getFilters() {
        JSONObject r0 = PerfFilterManager.getInstance().getPerfFiltersJson();
        if (this.isRealTimeMemEnable == true) goto L14;
    L6:
        IDeviceInfoService r3 = (IDeviceInfoService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IDeviceInfoService.class), IDeviceInfoService.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
    L9:
        return r0;
    L12:
        JsonUtils.copyJson2(r0, r3.getDeviceInfo());     // Catch: Exception -> L11
        goto L9
    L14:
        JsonUtils.copyJson2(r0, PerfFilterManager.getInstance().getRealTimeMemInfo());     // Catch: Exception -> L10
        goto L6
    }

    public double getJavaUsedMemoryRate() {
        return this.javaUsedMemoryRate;
    }

    public MemoryCollectInfo getMemoryCollectInfo() {
        MemoryCollectInfo r0 = new MemoryCollectInfo();
        r0.gcCount = this.gcCount;
        r0.gcTime = this.gcTime;
        r0.blockingGcCount = this.blockingGcCount;
        r0.blockingGcTime = this.blockingGcTime;
        r0.background = this.background;
        r0.nativePss = this.nativePss;
        r0.totalPss = this.totalPss;
        r0.javaUsedMemory = this.javaUsedMemory;
        r0.dalvikUsedSize = this.dalvikUsedSize;
        r0.graphics = this.graphics;
        r0.vmSize = this.vmSize;
        r0.isMemoryReachTop = this.isMemoryReachTop;
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public String getServiceName() {
        return "memory";
    }

    public boolean isBackground() {
        return this.background;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public void setMmapInfo(Map<Object, Object> r3) {
        this.mmapInfo = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        return "MemoryPerfMonitorable{gcCount=" + this.gcCount + ", gcTime=" + this.gcTime + ", blockingGcCount=" + this.blockingGcCount + ", blockingGcTime=" + this.blockingGcTime + ", background=" + this.background + ", nativePss=" + this.nativePss + ", totalPss=" + this.totalPss + ", javaUsedMemory=" + this.javaUsedMemory + ", dalvikUsedSize=" + this.dalvikUsedSize + ", graphics=" + this.graphics + ", vmSize=" + this.vmSize + ", javaUsedMemoryRate=" + this.javaUsedMemoryRate + ", isMemoryReachTop=" + this.isMemoryReachTop + '}';
    }
}
