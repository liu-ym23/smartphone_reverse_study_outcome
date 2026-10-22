package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.commonevent.config.CommonEventConfig;
import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    static /* synthetic */ void access$000(CommonEventConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
    }

    private void parseConfig(JSONObject r8, boolean r9) {
        JSONObject r10 = r8.optJSONObject("custom_event_settings");
        if (r10 == null) goto L29;
        JSONObject r11 = r10.optJSONObject(BASE_KEY_ALLOW_SERVICE_NAME);
        HashSet r0 = new HashSet();
        if (r11 == null) goto L10;
        Iterator<String> r12 = r11.keys();
    L8:
        if (r12.hasNext() == false) goto L10;
        r0.add((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin"));
    L10:
        HashSet r13 = new HashSet();
        JSONObject r2 = r10.optJSONObject(SlardarSettingsConstants.KEY_ALLOW_LOG_TYPE);
        if (r2 == null) goto L18;
        Iterator<String> r3 = r2.keys();
    L14:
        if (r3.hasNext() == false) goto L18;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        if (r2.optInt(r4) != 1) goto L14;
        r13.add(r4);
    L18:
        this.config = new CommonEventConfig(r0, r13);
        if (ApmContext.isDebugMode() == false) goto L21;
        Logger.d(ConfigConstants.LOG_TAG, "received customEventSettings=" + r10);
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
