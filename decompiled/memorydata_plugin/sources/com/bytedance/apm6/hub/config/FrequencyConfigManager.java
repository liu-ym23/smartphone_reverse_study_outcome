package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.frequency.FrequencyMonitor;
import com.bytedance.apm6.frequency.FrequencyMonitorConfig;
import com.bytedance.apm6.frequency.FrequencyMonitorConfigService;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.perf.base.BasePerfConfigParser;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    static /* synthetic */ void access$000(FrequencyConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
    }

    private void parseConfig(JSONObject r20, boolean r21) {
        if (r20 != null) goto L5;
        return;
    L5:
        JSONObject r0 = BasePerfConfigParser.parseData(r20, BASE_FREQUENCY_KEY);
        if (r0 != null) goto L8;
        return;
    L8:
        boolean r3 = true;
        if (r0.optInt(KEY_ENABLE_FREQUENCY_MONITOR, 0) != 1) goto L11;
        boolean r1 = true;
    L13:
        if (r0.optInt(KEY_ENABLE_EXCEPTION_MONITOR, 0) == 1) goto L16;
        r3 = false;
    L16:
        int r4 = r0.optInt(KEY_FRONT_EXCEPTION_CHECK_INTERVAL, 0);
        int r5 = r0.optInt(KEY_BACKGROUND_EXCEPTION_CHECK_INTERVAL, 0);
        JSONObject r6 = r0.optJSONObject(KEY_FRONT_EXCEPTION_THRESHOLD_PER_MIN);
        String r9 = "com.obric.memorydata.plugin";
        if (r6 == null) goto L22;
        HashMap<String, Float> r11 = new HashMap();
        Iterator<String> r12 = r6.keys();
    L20:
        if (r12.hasNext() == false) goto L23;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        r11.put(r13, Float.valueOf((float) r6.optDouble(r13, 0.0d)));
    L23:
        JSONObject r7 = r0.optJSONObject(KEY_BACKGROUND_EXCEPTION_THRESHOLD_PER_MIN);
        if (r7 == null) goto L30;
        HashMap<String, Float> r14 = new HashMap();
        Iterator<String> r15 = r7.keys();
    L27:
        if (r15.hasNext() == false) goto L29;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        r14.put(r16, Float.valueOf((float) r7.optDouble(r16, 0.0d)));
        r11 = r11;
        goto L27
    L29:
        HashMap<String, Float> r17 = r11;
    L31:
        int r8 = r0.optInt(KEY_EXCEPTION_REPORT_TOP_COUNT, 0);
        int r2 = r0.optInt(KEY_REPORT_INTERVAL, 0);
        int r10 = r0.optInt(KEY_EVENT_SAMPLING_RATE, 10000);
        JSONObject r18 = r0.optJSONObject(KEY_FRONT_REPORT_THRESHOLD_PER_MIN);
        if (r18 == null) goto L38;
        HashMap<String, Float> r19 = new HashMap();
        Iterator<String> r110 = r18.keys();
    L35:
        if (r110.hasNext() == false) goto L37;
        String r22 = (String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.memorydata.plugin");
        r19.put(r22, Float.valueOf((float) r18.optDouble(r22, 0.0d)));
        r17 = r17;
        r110 = r110;
        r5 = r5;
        r8 = r8;
        goto L35
    L37:
        int r111 = r5;
        int r112 = r8;
        HashMap<String, Float> r23 = r17;
    L39:
        JSONObject r24 = r0.optJSONObject(KEY_BACKGROUND_REPORT_THRESHOLD_PER_MIN);
        if (r24 == null) goto L45;
        HashMap<String, Float> r25 = new HashMap();
        Iterator<String> r26 = r24.keys();
    L43:
        if (r26.hasNext() == false) goto L46;
        String r27 = (String) ZeusTransformUtils.preCheckCast(r26.next(), String.class, r9);
        r25.put(r27, Float.valueOf((float) r24.optDouble(r27, 0.0d)));
        r9 = r9;
    L46:
        this.mConfig = new FrequencyMonitorConfig.Builder().enableFrequencyMonitor(r1).enableExceptionMonitor(r3).frontExceptionCheckInterval(r4).backgroundExceptionCheckInterval(r111).frontExceptionThresholdPerMin(r23).backgroundExceptionThresholdPerMin(r14).exceptionReportTopCount(r112).reportInterval(r2).eventSamplingRate(r10).frontReportThreshold(r19).backgroundReportThreshold(r25).build();
        FrequencyMonitor.getInstance().updateConfig(getConfig());
        return;
    L45:
        r25 = null;
        goto L46
    L38:
        r111 = r5;
        r112 = r8;
        r23 = r17;
        r19 = null;
        goto L39
    L30:
        r17 = r11;
        r14 = null;
        goto L31
    L22:
        r11 = null;
        goto L23
    L11:
        r1 = false;
        goto L13
    }

    @Override // com.bytedance.apm6.frequency.FrequencyMonitorConfigService
    public FrequencyMonitorConfig getConfig() {
        return this.mConfig;
    }
}
