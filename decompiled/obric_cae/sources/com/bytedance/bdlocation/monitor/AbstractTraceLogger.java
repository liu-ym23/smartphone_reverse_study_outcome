package com.bytedance.bdlocation.monitor;

import android.os.SystemClock;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import defpackage.b;
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

    public void begin(String r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.METRIC_CACHE_DATA.containsKey(r8) == false) goto L8;
        StringBuilder r10 = b.h("begin action error:", r8, ", class: ");
        r10.append(this.CLASS_NAME_STR);
        Logger.i(r10.toString());
        this.METRIC_CACHE_DATA.remove(r8);
        return;
    L8:
        this.METRIC_CACHE_DATA.put(r8, Long.valueOf(SystemClock.uptimeMillis()));
    }

    public void dumpCategoriesTo(JSONObject r8) {
        if (this.CATEGORY_DATA.isEmpty() == true) goto L17;
        if (r8 == null) goto L27;
        Iterator<Map.Entry<String, Object>> r10 = this.CATEGORY_DATA.entrySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L28;
        Map.Entry<String, Object> r11 = r10.next();
        if (r11 == null) goto L8;
        if (r11.getKey() == null) goto L8;
        if (r11.getValue() == null) goto L8;
        JsonUtil.safePutObject(r8, r11.getKey(), r11.getValue());
        goto L8
    L28:
        return;
    L27:
        return;
    }

    public void dumpLogExtrasTo(JSONObject r8) {
        if (this.LOG_EXTRAS.isEmpty() == true) goto L17;
        if (r8 == null) goto L27;
        Iterator<Map.Entry<String, Object>> r10 = this.LOG_EXTRAS.entrySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L28;
        Map.Entry<String, Object> r11 = r10.next();
        if (r11 == null) goto L8;
        if (r11.getKey() == null) goto L8;
        if (r11.getValue() == null) goto L8;
        JsonUtil.safePutObject(r8, r11.getKey(), r11.getValue());
        goto L8
    L28:
        return;
    L27:
        return;
    }

    public void dumpMetricsTo(JSONObject r8) {
        if (this.REPORT_METRIC_DATA.isEmpty() == true) goto L17;
        if (r8 == null) goto L27;
        Iterator<Map.Entry<String, Long>> r10 = this.REPORT_METRIC_DATA.entrySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L28;
        Map.Entry<String, Long> r11 = r10.next();
        if (r11 == null) goto L8;
        if (r11.getKey() == null) goto L8;
        if (r11.getValue() == null) goto L8;
        JsonUtil.safePutLong(r8, r11.getKey(), r11.getValue().longValue());
        goto L8
    L28:
        return;
    L27:
        return;
    }

    public void end(String r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Long r10 = this.METRIC_CACHE_DATA.get(r8);
        if (r10 != null) goto L7;
    L11:
        StringBuilder r11 = b.h("end action error:", r8, ", class: ");
        r11.append(this.CLASS_NAME_STR);
        Logger.i(r11.toString());
        return;
    L7:
        if (this.REPORT_METRIC_DATA.containsKey(r8) == true) goto L11;
        this.REPORT_METRIC_DATA.put(r8, Long.valueOf(SystemClock.uptimeMillis() - r10.longValue()));
        this.METRIC_CACHE_DATA.remove(r8);
    }

    public void putCategoryData(String r8, Object r10) {
        if (r8 == null) goto L7;
        if (r10 == null) goto L8;
        this.CATEGORY_DATA.put(r8, r10);
        return;
    L8:
        return;
    }

    public void putLogExtra(String r8, Object r10) {
        if (r8 == null) goto L7;
        if (r10 == null) goto L8;
        this.LOG_EXTRAS.put(r8, r10);
        return;
    L8:
        return;
    }

    public void putReportMetricData(String r8, long r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.REPORT_METRIC_DATA.put(r8, Long.valueOf(r10));
    }
}
