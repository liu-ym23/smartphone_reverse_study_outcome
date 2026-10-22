package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.frequency.FrequencyMonitor;
import com.bytedance.apm6.frequency.FrequencyMonitorConfig;
import com.bytedance.apm6.frequency.FrequencyMonitorConfigService;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.perf.base.BasePerfConfigParser;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FrequencyConfigManager implements FrequencyMonitorConfigService {
    private static final String BASE_FREQUENCY_KEY = "frequency";
    private static final String KEY_BACKGROUND_EXCEPTION_CHECK_INTERVAL = "background_exception_check_interval";
    private static final String KEY_BACKGROUND_EXCEPTION_THRESHOLD_PER_MIN = "background_exception_threshold_per_min";
    private static final String KEY_BACKGROUND_REPORT_THRESHOLD_PER_MIN = "background_report_threshold_per_min";
    private static final String KEY_ENABLE_EXCEPTION_MONITOR = "enable_exception_monitor";
    private static final String KEY_ENABLE_FREQUENCY_MONITOR = "enable_frequency_monitor";
    private static final String KEY_EVENT_SAMPLING_RATE = "event_sampling_rate";
    private static final String KEY_EXCEPTION_REPORT_TOP_COUNT = "exception_report_top_count";
    private static final String KEY_FRONT_EXCEPTION_CHECK_INTERVAL = "front_exception_check_interval";
    private static final String KEY_FRONT_EXCEPTION_THRESHOLD_PER_MIN = "front_exception_threshold_per_min";
    private static final String KEY_FRONT_REPORT_THRESHOLD_PER_MIN = "front_report_threshold_per_min";
    private static final String KEY_REPORT_INTERVAL = "report_interval";
    private FrequencyMonitorConfig mConfig;

    public FrequencyConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    static /* synthetic */ void access$000(FrequencyConfigManager r10, JSONObject r11, boolean r12) {
        r10.parseConfig(r11, r12);
    }

    private void parseConfig(JSONObject r18, boolean r19) {
        if (r18 != null) goto L5;
        return;
    L5:
        JSONObject r10 = BasePerfConfigParser.parseData(r18, BASE_FREQUENCY_KEY);
        if (r10 != null) goto L8;
        return;
    L8:
        boolean r11 = true;
        if (r10.optInt(KEY_ENABLE_FREQUENCY_MONITOR, 0) != 1) goto L11;
        boolean r12 = true;
    L13:
        if (r10.optInt(KEY_ENABLE_EXCEPTION_MONITOR, 0) == 1) goto L16;
        r11 = false;
    L16:
        int r13 = r10.optInt(KEY_FRONT_EXCEPTION_CHECK_INTERVAL, 0);
        int r14 = r10.optInt(KEY_BACKGROUND_EXCEPTION_CHECK_INTERVAL, 0);
        JSONObject r15 = r10.optJSONObject(KEY_FRONT_EXCEPTION_THRESHOLD_PER_MIN);
        if (r15 == null) goto L22;
        HashMap<String, Float> r16 = new HashMap();
        Iterator<String> r17 = r15.keys();
    L20:
        if (r17.hasNext() == false) goto L23;
        String r110 = r17.next();
        r16.put(r110, Float.valueOf((float) r15.optDouble(r110, 0.0d)));
    L23:
        JSONObject r20 = r10.optJSONObject(KEY_BACKGROUND_EXCEPTION_THRESHOLD_PER_MIN);
        if (r20 == null) goto L29;
        HashMap<String, Float> r111 = new HashMap();
        Iterator<String> r112 = r20.keys();
    L27:
        if (r112.hasNext() == false) goto L30;
        String r113 = r112.next();
        r111.put(r113, Float.valueOf((float) r20.optDouble(r113, 0.0d)));
    L30:
        int r21 = r10.optInt(KEY_EXCEPTION_REPORT_TOP_COUNT, 0);
        int r22 = r10.optInt(KEY_REPORT_INTERVAL, 0);
        int r114 = r10.optInt(KEY_EVENT_SAMPLING_RATE, 10000);
        JSONObject r115 = r10.optJSONObject(KEY_FRONT_REPORT_THRESHOLD_PER_MIN);
        if (r115 == null) goto L37;
        HashMap<String, Float> r116 = new HashMap();
        Iterator<String> r117 = r115.keys();
    L34:
        if (r117.hasNext() == false) goto L36;
        String r23 = r117.next();
        r116.put(r23, Float.valueOf((float) r115.optDouble(r23, 0.0d)));
        r114 = r114;
        r111 = r111;
        goto L34
    L36:
        HashMap<String, Float> r118 = r111;
        int r119 = r114;
    L38:
        JSONObject r24 = r10.optJSONObject(KEY_BACKGROUND_REPORT_THRESHOLD_PER_MIN);
        if (r24 == null) goto L45;
        HashMap<String, Float> r25 = new HashMap();
        Iterator<String> r120 = r24.keys();
    L42:
        if (r120.hasNext() == false) goto L44;
        String r121 = r120.next();
        r25.put(r121, Float.valueOf((float) r24.optDouble(r121, 0.0d)));
        r116 = r116;
        goto L42
    L44:
        HashMap<String, Float> r122 = r116;
    L46:
        this.mConfig = new FrequencyMonitorConfig.Builder().enableFrequencyMonitor(r12).enableExceptionMonitor(r11).frontExceptionCheckInterval(r13).backgroundExceptionCheckInterval(r14).frontExceptionThresholdPerMin(r16).backgroundExceptionThresholdPerMin(r118).exceptionReportTopCount(r21).reportInterval(r22).eventSamplingRate(r119).frontReportThreshold(r122).backgroundReportThreshold(r25).build();
        FrequencyMonitor.getInstance().updateConfig(getConfig());
        return;
    L45:
        r122 = r116;
        r25 = null;
        goto L46
    L37:
        r118 = r111;
        r119 = r114;
        r116 = null;
        goto L38
    L29:
        r111 = null;
        goto L30
    L22:
        r16 = null;
        goto L23
    L11:
        r12 = false;
        goto L13
    }

    @Override // com.bytedance.apm6.frequency.FrequencyMonitorConfigService
    public FrequencyMonitorConfig getConfig() {
        return this.mConfig;
    }
}
