package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.config.CommonEventConfig;
import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CommonEventConfigManager implements CommonEventConfigService {
    private static final String BASE_KEY_ALLOW_SERVICE_NAME = "allow_service_name";
    private volatile CommonEventConfig config;

    public CommonEventConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    static /* synthetic */ void access$000(CommonEventConfigManager r10, JSONObject r11, boolean r12) {
        r10.parseConfig(r11, r12);
    }

    private void parseConfig(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject("custom_event_settings");
        if (r12 == null) goto L29;
        JSONObject r13 = r12.optJSONObject(BASE_KEY_ALLOW_SERVICE_NAME);
        HashSet r14 = new HashSet();
        if (r13 == null) goto L10;
        Iterator<String> r15 = r13.keys();
    L8:
        if (r15.hasNext() == false) goto L10;
        r14.add(r15.next());
    L10:
        HashSet r16 = new HashSet();
        JSONObject r17 = r12.optJSONObject(SlardarSettingsConstants.KEY_ALLOW_LOG_TYPE);
        if (r17 == null) goto L18;
        Iterator<String> r18 = r17.keys();
    L14:
        if (r18.hasNext() == false) goto L18;
        String r19 = r18.next();
        if (r17.optInt(r19) != 1) goto L14;
        r16.add(r19);
    L18:
        this.config = new CommonEventConfig(r14, r16);
        if (ApmBaseContext.isDebugMode() == false) goto L21;
        Logger.d(ConfigConstants.LOG_TAG, "received customEventSettings=" + r12);
        Logger.d(ConfigConstants.LOG_TAG, "parsed CommonEventConfig=" + this.config);
    L21:
        CommonEventDeliverer.updateConfig(getConfig());
        return;
    }

    @Override // com.bytedance.apm6.commonevent.config.CommonEventConfigService
    public CommonEventConfig getConfig() {
        return this.config;
    }
}
