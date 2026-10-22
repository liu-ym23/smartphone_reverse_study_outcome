package com.bytedance.bdlocation.monitor;

import android.os.SystemClock;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractTraceLogger {
    private final Map<String, Object> CATEGORY_DATA;
    private final String CLASS_NAME_STR;
    private final Map<String, Object> LOG_EXTRAS;
    private final Map<String, Long> METRIC_CACHE_DATA;
    private final Map<String, Long> REPORT_METRIC_DATA;

    public AbstractTraceLogger() {
        this.CLASS_NAME_STR = getClass().getName();
        this.CATEGORY_DATA = new ConcurrentHashMap();
        this.METRIC_CACHE_DATA = new ConcurrentHashMap();
        this.REPORT_METRIC_DATA = new ConcurrentHashMap();
        this.LOG_EXTRAS = new ConcurrentHashMap();
    }

    public void begin(String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.METRIC_CACHE_DATA.containsKey(r3) == false) goto L8;
        Logger.i("begin action error:" + r3 + ", class: " + this.CLASS_NAME_STR);
        this.METRIC_CACHE_DATA.remove(r3);
        return;
    L8:
        this.METRIC_CACHE_DATA.put(r3, Long.valueOf(SystemClock.uptimeMillis()));
    }

    public void dumpCategoriesTo(JSONObject r5) {
        if (this.CATEGORY_DATA.isEmpty() == true) goto L17;
        if (r5 == null) goto L27;
        Iterator<Map.Entry<String, Object>> r4 = this.CATEGORY_DATA.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L28;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        if (r0.getKey() == null) goto L8;
        if (r0.getValue() == null) goto L8;
        JsonUtil.safePutObject(r5, (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), r0.getValue());
        goto L8
    L28:
        return;
    L27:
        return;
    }

    public void dumpLogExtrasTo(JSONObject r5) {
        if (this.LOG_EXTRAS.isEmpty() == true) goto L17;
        if (r5 == null) goto L27;
        Iterator<Map.Entry<String, Object>> r4 = this.LOG_EXTRAS.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L28;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        if (r0.getKey() == null) goto L8;
        if (r0.getValue() == null) goto L8;
        JsonUtil.safePutObject(r5, (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), r0.getValue());
        goto L8
    L28:
        return;
    L27:
        return;
    }

    public void dumpMetricsTo(JSONObject r5) {
        if (this.REPORT_METRIC_DATA.isEmpty() == true) goto L17;
        if (r5 == null) goto L27;
        Iterator<Map.Entry<String, Long>> r4 = this.REPORT_METRIC_DATA.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L28;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        if (r0.getKey() == null) goto L8;
        if (r0.getValue() == null) goto L8;
        JsonUtil.safePutLong(r5, (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), ((Long) ZeusTransformUtils.preCheckCast(r0.getValue(), Long.class, "com.obric.memorydata.plugin")).longValue());
        goto L8
    L28:
        return;
    L27:
        return;
    }

    public void end(String r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.METRIC_CACHE_DATA.get(r7), Long.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
    L11:
        Logger.i("end action error:" + r7 + ", class: " + this.CLASS_NAME_STR);
        return;
    L7:
        if (this.REPORT_METRIC_DATA.containsKey(r7) == true) goto L11;
        this.REPORT_METRIC_DATA.put(r7, Long.valueOf(SystemClock.uptimeMillis() - r0.longValue()));
        this.METRIC_CACHE_DATA.remove(r7);
    }

    public void putCategoryData(String r1, Object r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L8;
        this.CATEGORY_DATA.put(r1, r2);
        return;
    L8:
        return;
    }

    public void putLogExtra(String r1, Object r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L8;
        this.LOG_EXTRAS.put(r1, r2);
        return;
    L8:
        return;
    }

    public void putReportMetricData(String r1, long r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.REPORT_METRIC_DATA.put(r1, Long.valueOf(r2));
    }
}
