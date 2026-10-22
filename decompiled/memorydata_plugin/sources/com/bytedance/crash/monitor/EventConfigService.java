package com.bytedance.crash.monitor;

import com.bytedance.crash.config.ConfigManager;
import com.bytedance.crash.config.IConfigChangeListener;
import com.bytedance.crash.event.EnsureConfig;
import com.bytedance.crash.event.EventConfig;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class EventConfigService implements IConfigChangeListener {
    private static final String BASE_KEY_ALLOW_LOG_TYPE = "allow_log_type";
    private static final String BASE_KEY_ALLOW_SERVICE_NAME = "allow_service_name";
    public static final String CUSTOM_EVENT_SETTINGS = "custom_event_settings";
    private static final String ENABLE_UPLOAD = "enable_upload";
    private static final String EXCEPTION = "exception";
    public static final String EXCEPTION_MODULE = "exception_modules";
    private static final String METRIC_SAMPLE = "metric_sampling";
    public static final String NPTH_SIMPLE_SETTING = "npth_simple_setting";
    private static final String TAG = "NPTH-Config";
    private final ConfigManager configManager;
    protected EnsureConfig ensureConfig;
    protected EventConfig eventConfig;
    protected EventMonitor monitor;

    public EventConfigService(EventMonitor r1) {
        this.monitor = r1;
        ConfigManager r2 = createConfigManager();
        this.configManager = r2;
        r2.registerConfigListener(this);
    }

    private Set<String> parseAllowLogType(JSONObject r5) {
        HashSet r4 = new HashSet();
        JSONObject r6 = r5.optJSONObject("custom_event_settings");
        if (r6 == null) goto L5;
        JSONObject r7 = r6.optJSONObject("allow_log_type");
    L6:
        if (r7 == null) goto L13;
        Iterator<String> r0 = r7.keys();
    L9:
        if (r0.hasNext() == false) goto L13;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (r7.optInt(r1) != 1) goto L9;
        r4.add(r1);
    L13:
        return r4;
    L5:
        r7 = null;
        goto L6
    }

    public ConfigManager createConfigManager() {
        return new ConfigManager(this.monitor);
    }

    public EnsureConfig getEnsureConfig() {
        return this.ensureConfig;
    }

    public EventConfig getEventConfig() {
        return this.eventConfig;
    }

    public void init() {
        this.configManager.init();
    }

    @Override // com.bytedance.crash.config.IConfigChangeListener
    public void onConfigChanged(JSONObject r3) {
        NpthLog.d(TAG, "onConfigChanged:" + this.monitor.getAppId());
        if (r3 != null) goto L5;
        return;
    L5:
        parseEnsureConfig(r3);
        parseEventConfig(r3);
        this.monitor.getEnsureDeliver().updateConfig(getEnsureConfig());
        this.monitor.getEventDeliverer().updateConfig(getEventConfig());
    }

    public void parseEnsureConfig(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Set<String> r0 = parseAllowLogType(r5);
        JSONObject r1 = new JSONObject();
        JSONObject r6 = r5.optJSONObject(EXCEPTION_MODULE);
        boolean r2 = false;
        if (r6 == null) goto L12;
        JSONObject r7 = r6.optJSONObject("exception");
        if (r7 == null) goto L12;
        if (r7.optInt("enable_upload") != 1) goto L11;
        r2 = true;
    L11:
        r1 = r7.optJSONObject(METRIC_SAMPLE);
    L12:
        this.ensureConfig = new EnsureConfig(r0, r1, r2);
        NpthLog.d(TAG, "parseEnsureConfig:" + this.monitor.mAppId + " " + this.ensureConfig);
    }

    public void parseEventConfig(JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        HashSet r0 = new HashSet();
        JSONObject r1 = null;
        JSONObject r7 = r6.optJSONObject("custom_event_settings");
        if (r7 == null) goto L7;
        r1 = r7.optJSONObject(BASE_KEY_ALLOW_SERVICE_NAME);
    L7:
        if (r1 == null) goto L14;
        Iterator<String> r8 = r1.keys();
    L10:
        if (r8.hasNext() == false) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r1.optInt(r2) != 1) goto L10;
        r0.add(r2);
    L14:
        this.eventConfig = new EventConfig(r0);
    }
}
