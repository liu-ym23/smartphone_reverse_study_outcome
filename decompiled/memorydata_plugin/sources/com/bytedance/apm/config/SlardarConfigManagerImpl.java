package com.bytedance.apm.config;

import com.bytedance.apm6.Apm6;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SlardarConfigManagerImpl implements IConfigManager {
    private g mSlardarConfigFetcher;

    public SlardarConfigManagerImpl() {
        this.mSlardarConfigFetcher = new g();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void fetchConfig() {
        this.mSlardarConfigFetcher.a();
    }

    public void forceUpdateFromRemote(com.bytedance.apm.core.d r3, List<String> r4) {
        com.bytedance.apm.core.d r5 = (com.bytedance.apm.core.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.core.d.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.mSlardarConfigFetcher.a(r5, r6);
    }

    public JSONObject getConfig() {
        return this.mSlardarConfigFetcher.c();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public int getConfigInt(String r1, int r2) {
        return this.mSlardarConfigFetcher.a(r1, r2);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject getConfigJSON(String r1) {
        return this.mSlardarConfigFetcher.e(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getLogTypeSwitch(String r1) {
        return this.mSlardarConfigFetcher.a(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getMetricTypeSwitch(String r1) {
        return this.mSlardarConfigFetcher.b(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getServiceSwitch(String r1) {
        return this.mSlardarConfigFetcher.c(r1);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getSwitch(String r1) {
        return this.mSlardarConfigFetcher.d(r1);
    }

    public void initParams(boolean r3, com.bytedance.apm.core.d r4, List<String> r5) {
        com.bytedance.apm.core.d r6 = (com.bytedance.apm.core.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.apm.core.d.class, "com.obric.memorydata.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.mSlardarConfigFetcher.a(r3, r6, r7);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean isConfigReady() {
        return this.mSlardarConfigFetcher.b();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public String queryConfig() {
        return this.mSlardarConfigFetcher.e();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerConfigListener(com.bytedance.services.slardar.config.a r3) {
        com.bytedance.services.slardar.config.a r4 = (com.bytedance.services.slardar.config.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.services.slardar.config.a.class, "com.obric.memorydata.plugin");
        this.mSlardarConfigFetcher.a(r4);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerResponseConfigListener(com.bytedance.services.slardar.config.b r2) {
        Apm6.registerResponseConfigListener((com.bytedance.services.slardar.config.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.services.slardar.config.b.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject retrieveSettingsParams() {
        return this.mSlardarConfigFetcher.d();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterConfigListener(com.bytedance.services.slardar.config.a r3) {
        com.bytedance.services.slardar.config.a r4 = (com.bytedance.services.slardar.config.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.services.slardar.config.a.class, "com.obric.memorydata.plugin");
        this.mSlardarConfigFetcher.b(r4);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterResponseConfigListener(com.bytedance.services.slardar.config.b r2) {
        Apm6.unregisterResponseConfigListener((com.bytedance.services.slardar.config.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.services.slardar.config.b.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean updateWithSpecificAidResult(JSONObject r1) {
        return this.mSlardarConfigFetcher.a(r1);
    }
}
