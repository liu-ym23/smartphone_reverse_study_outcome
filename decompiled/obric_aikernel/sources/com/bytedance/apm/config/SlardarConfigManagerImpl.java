package com.bytedance.apm.config;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm6.Apm6;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.List;
import org.json.JSONObject;
import u4.b;

/* JADX INFO: loaded from: classes.dex */
public class SlardarConfigManagerImpl implements IConfigManager {
    private a mSlardarConfigFetcher;

    public SlardarConfigManagerImpl() {
        this.mSlardarConfigFetcher = new a();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void fetchConfig() {
        this.mSlardarConfigFetcher.o();
    }

    @WorkerThread
    public void forceUpdateFromRemote(@Nullable IQueryParams r10, @Nullable List<String> r11) {
        this.mSlardarConfigFetcher.f(r10, r11);
    }

    @Nullable
    public JSONObject getConfig() {
        return this.mSlardarConfigFetcher.g();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public int getConfigInt(String r10, int r11) {
        return this.mSlardarConfigFetcher.h(r10, r11);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    @Nullable
    public JSONObject getConfigJSON(String r10) {
        return this.mSlardarConfigFetcher.i(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getLogTypeSwitch(String r10) {
        return this.mSlardarConfigFetcher.j(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getMetricTypeSwitch(String r10) {
        return this.mSlardarConfigFetcher.k(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getServiceSwitch(String r10) {
        return this.mSlardarConfigFetcher.l(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean getSwitch(String r10) {
        return this.mSlardarConfigFetcher.m(r10);
    }

    public void initParams(boolean r10, IQueryParams r11, List<String> r12) {
        this.mSlardarConfigFetcher.p(r10, r11, r12);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean isConfigReady() {
        return this.mSlardarConfigFetcher.u();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public String queryConfig() {
        return this.mSlardarConfigFetcher.x();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerConfigListener(u4.a r10) {
        this.mSlardarConfigFetcher.c(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void registerResponseConfigListener(b r10) {
        Apm6.registerResponseConfigListener(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public JSONObject retrieveSettingsParams() {
        return this.mSlardarConfigFetcher.C();
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterConfigListener(u4.a r10) {
        this.mSlardarConfigFetcher.B(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public void unregisterResponseConfigListener(b r10) {
        Apm6.unregisterResponseConfigListener(r10);
    }

    @Override // com.bytedance.services.slardar.config.IConfigManager
    public boolean updateWithSpecificAidResult(JSONObject r10) {
        return this.mSlardarConfigFetcher.H(r10);
    }
}
