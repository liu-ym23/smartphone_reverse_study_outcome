package com.bytedance.apm6.disk;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.apm6.util.JsonUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DiskReportEvent extends PerfBaseEvent {
    private static final int MAX_DATA_SIZE = 262144;
    private static final String PERF_DISK_APP_USAGE = "app_usage";
    private static final String PERF_DISK_CACHE = "cache";
    private static final String PERF_DISK_DATA = "data";
    private static final String PERF_DISK_DISK_INFO = "disk_info";
    private static final String PERF_DISK_EXCEPTION_FOLDERS = "exception_folders";
    private static final String PERF_DISK_FREE_CAPACITY = "free_capacity";
    private static final String PERF_DISK_OCCUPIED_RATE = "app_occupied_rate";
    private static final String PERF_DISK_OUTDATED_FILES = "outdated_files";
    private static final String PERF_DISK_ROM_FREE = "rom_free";
    private static final String PERF_DISK_TOP_USAGE = "top_usage";
    private static final String PERF_DISK_TOTAL = "total";
    private static final String PERF_DISK_TOTAL_CAPACITY = "total_capacity";
    private static final String SERVICE_NAME = "disk";
    private double appOccupiedRate;
    private long appUsage;
    private long cacheUsed;
    private long dataUsed;
    private JSONArray diskInfo;
    private JSONArray exceptionFolder;
    private long freeCapacity;
    private int maxRoomOfJsonObject;
    private JSONArray outDateList;
    private long romFreeSpace;
    private JSONArray topUsage;
    private long totalCapacity;
    private long totalSize;

    public DiskReportEvent(long r10, long r11, long r12, long r13, long r14, long r15, long r16, double r18, JSONArray r20, JSONArray r21, JSONArray r22, JSONArray r23) {
        this.maxRoomOfJsonObject = 262144;
        this.dataUsed = r10;
        this.cacheUsed = r11;
        this.totalSize = r12;
        this.romFreeSpace = r13;
        this.appUsage = r14;
        this.totalCapacity = r15;
        this.freeCapacity = r16;
        this.appOccupiedRate = r18;
        this.topUsage = r20;
        this.exceptionFolder = r21;
        this.outDateList = r22;
        this.diskInfo = r23;
    }

    private static long getJsonSize(JSONArray r10) {
        return r10.toString().getBytes("UTF-8").length;
    L5:
        return 0;
    }

    private JSONArray tailorDiskInfo(JSONArray r10, int r11) {
        JSONArray r12 = new JSONArray();
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L16;
        JSONObject r14 = r10.getJSONObject(r13);
        if (r14.getLong("size") < r11) goto L15;
        JSONArray r15 = r14.optJSONArray("next_disk");
        if (r15 == null) goto L14;
        JSONArray r16 = tailorDiskInfo(r15, r11);
        if (r16.length() <= 0) goto L13;
        r14.put("next_disk", r16);
        goto L14
    L13:
        r14.remove("next_disk");
    L14:
        r12.put(r14);
    L15:
        r13 = r13 + 1;
        goto L4
    L16:
        return r12;
    }

    private JSONArray tailorJsonObject(JSONArray r10) {
        if (r10 == null) goto L4;
        int r11 = 102400;
        int r12 = 0;
    L7:
        if (getJsonSize(r10) <= this.maxRoomOfJsonObject) goto L12;
        if (r12 > 10) goto L12;
        r10 = tailorDiskInfo(r10, r11);     // Catch: JSONException -> L13
    L11:
        r11 = r11 * 2;
        r12 = r12 + 1;
    L12:
        return r10;
    L4:
        return new JSONArray();
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject createRootJSONObject() {
        JSONObject r10 = new JSONObject();
        JSONArray r11 = this.topUsage;     // Catch: Exception -> L20
        if (r11 == null) goto L6;
        r10.put(PERF_DISK_TOP_USAGE, r11);     // Catch: Exception -> L20
    L6:
        JSONArray r12 = this.exceptionFolder;     // Catch: Exception -> L20
        if (r12 == null) goto L9;
        r10.put(PERF_DISK_EXCEPTION_FOLDERS, r12);     // Catch: Exception -> L20
    L9:
        JSONArray r13 = this.outDateList;     // Catch: Exception -> L20
        if (r13 == null) goto L13;
        r10.put(PERF_DISK_OUTDATED_FILES, r13);     // Catch: Exception -> L20
    L13:
        if (this.diskInfo == null) goto L18;
        int r14 = 0;
        r14 = r10.toString().getBytes("UTF-8").length;     // Catch: Exception -> L19
    L17:
        this.maxRoomOfJsonObject = (262144 - r14) - 12288;     // Catch: Exception -> L20
        JSONArray r15 = tailorJsonObject(this.diskInfo);     // Catch: Exception -> L20
        this.diskInfo = r15;     // Catch: Exception -> L20
        r10.put(PERF_DISK_DISK_INFO, r15);     // Catch: Exception -> L20
    L18:
        return r10;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraStatus() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L4
        r10.put("scene", PerfFilterManager.getInstance().getSceneString());     // Catch: Throwable -> L4
        r10.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Throwable -> L4
        r10.put("is_front", false);     // Catch: Throwable -> L4
        r10.put("is_main_process", ApmContext.isMainProcess());     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        JSONObject r10 = new JSONObject();
        long r11 = this.dataUsed;     // Catch: Exception -> L28
        if (r11 <= 0) goto L6;
        r10.put("data", r11);     // Catch: Exception -> L28
    L6:
        long r12 = this.cacheUsed;     // Catch: Exception -> L28
        if (r12 <= 0) goto L9;
        r10.put("cache", r12);     // Catch: Exception -> L28
    L9:
        long r13 = this.totalSize;     // Catch: Exception -> L28
        if (r13 <= 0) goto L12;
        r10.put(PERF_DISK_TOTAL, r13);     // Catch: Exception -> L28
    L12:
        long r14 = this.romFreeSpace;     // Catch: Exception -> L28
        if (r14 <= 0) goto L15;
        r10.put(PERF_DISK_ROM_FREE, r14);     // Catch: Exception -> L28
    L15:
        long r15 = this.appUsage;     // Catch: Exception -> L28
        if (r15 <= 0) goto L18;
        r10.put(PERF_DISK_APP_USAGE, r15);     // Catch: Exception -> L28
    L18:
        long r16 = this.totalCapacity;     // Catch: Exception -> L28
        if (r16 <= 0) goto L21;
        r10.put(PERF_DISK_TOTAL_CAPACITY, r16);     // Catch: Exception -> L28
    L21:
        long r17 = this.freeCapacity;     // Catch: Exception -> L28
        if (r17 <= 0) goto L24;
        r10.put(PERF_DISK_FREE_CAPACITY, r17);     // Catch: Exception -> L28
    L24:
        double r18 = this.appOccupiedRate;     // Catch: Exception -> L28
        if (r18 <= 0.0d) goto L27;
        r10.put(PERF_DISK_OCCUPIED_RATE, r18);     // Catch: Exception -> L28
    L27:
        return r10;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getFilters() {
        JSONObject r10 = PerfFilterManager.getInstance().getPerfFiltersJson();
        JsonUtils.copyJson2(r10, PerfFilterManager.getInstance().getRealTimeMemInfo());     // Catch: Exception -> L5
    L4:
        return r10;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return "disk";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }
}
