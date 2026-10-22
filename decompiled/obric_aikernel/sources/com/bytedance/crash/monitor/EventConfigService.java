package com.bytedance.crash.monitor;

import androidx.annotation.NonNull;
import com.bytedance.crash.config.ConfigManager;
import com.bytedance.crash.config.IConfigChangeListener;
import com.bytedance.crash.event.EnsureConfig;
import com.bytedance.crash.event.EventConfig;
import com.bytedance.crash.util.NpthLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    public EventConfigService(EventMonitor r10) {
        this.monitor = r10;
        ConfigManager r11 = createConfigManager();
        this.configManager = r11;
        r11.registerConfigListener(this);
    }

    private Set<String> parseAllowLogType(JSONObject r10) {
        HashSet r11 = new HashSet();
        JSONObject r12 = r10.optJSONObject("custom_event_settings");
        if (r12 == null) goto L5;
        JSONObject r13 = r12.optJSONObject("allow_log_type");
    L6:
        if (r13 == null) goto L13;
        Iterator<String> r14 = r13.keys();
    L9:
        if (r14.hasNext() == false) goto L13;
        String r15 = r14.next();
        if (r13.optInt(r15) != 1) goto L9;
        r11.add(r15);
    L13:
        return r11;
    L5:
        r13 = null;
        goto L6
    }

    @NonNull
    protected ConfigManager createConfigManager() {
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
    public void onConfigChanged(JSONObject r10) {
        NpthLog.d(TAG, "onConfigChanged:" + this.monitor.getAppId());
        if (r10 != null) goto L5;
        return;
    L5:
        parseEnsureConfig(r10);
        parseEventConfig(r10);
        this.monitor.getEnsureDeliver().updateConfig(getEnsureConfig());
        this.monitor.getEventDeliverer().updateConfig(getEventConfig());
    }

    protected void parseEnsureConfig(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Set<String> r11 = parseAllowLogType(r10);
        JSONObject r12 = new JSONObject();
        JSONObject r13 = r10.optJSONObject(EXCEPTION_MODULE);
        boolean r14 = false;
        if (r13 == null) goto L12;
        JSONObject r15 = r13.optJSONObject("exception");
        if (r15 == null) goto L12;
        if (r15.optInt("enable_upload") != 1) goto L11;
        r14 = true;
    L11:
        r12 = r15.optJSONObject(METRIC_SAMPLE);
    L12:
        this.ensureConfig = new EnsureConfig(r11, r12, r14);
        NpthLog.d(TAG, "parseEnsureConfig:" + this.monitor.mAppId + " " + this.ensureConfig);
    }

    protected void parseEventConfig(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        HashSet r11 = new HashSet();
        JSONObject r12 = null;
        JSONObject r13 = r10.optJSONObject("custom_event_settings");
        if (r13 == null) goto L7;
        r12 = r13.optJSONObject(BASE_KEY_ALLOW_SERVICE_NAME);
    L7:
        if (r12 == null) goto L14;
        Iterator<String> r14 = r12.keys();
    L10:
        if (r14.hasNext() == false) goto L14;
        String r15 = r14.next();
        if (r12.optInt(r15) != 1) goto L10;
        r11.add(r15);
    L14:
        this.eventConfig = new EventConfig(r11);
    }
}
