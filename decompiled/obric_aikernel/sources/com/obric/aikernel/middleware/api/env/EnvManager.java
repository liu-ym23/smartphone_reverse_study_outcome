package com.obric.aikernel.middleware.api.env;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class EnvManager implements IEnvManager {
    public static final EnvManager INSTANCE = null;
    private final /* synthetic */ IEnvManager $$delegate_0;

    static {
        INSTANCE = new EnvManager();
    }

    private EnvManager() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IEnvManager.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IEnvManager) r10;
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String applyAdminWebViewEnvHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        return this.$$delegate_0.applyAdminWebViewEnvHeader(r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public int getAbDebugHeader() {
        return this.$$delegate_0.getAbDebugHeader();
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public NetEnv getAdminNetEnv() {
        return this.$$delegate_0.getAdminNetEnv();
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getAdminSaaSLiveEnvHeader() {
        return this.$$delegate_0.getAdminSaaSLiveEnvHeader();
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getAdminTTEnvHeader() {
        return this.$$delegate_0.getAdminTTEnvHeader();
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getAdminTTFeatureHeader() {
        return this.$$delegate_0.getAdminTTFeatureHeader();
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getAdminWebViewEnvHeader() {
        return this.$$delegate_0.getAdminWebViewEnvHeader();
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getMockCurrentRegion() {
        return this.$$delegate_0.getMockCurrentRegion();
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getRpcResponseEnvHeader() {
        return this.$$delegate_0.getRpcResponseEnvHeader();
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public String getTikTokLiveSdkDistEnvHeader() {
        return this.$$delegate_0.getTikTokLiveSdkDistEnvHeader();
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveAbDebugHeader(int r10) {
        this.$$delegate_0.saveAbDebugHeader(r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveAdminNetEnv(NetEnv r10) {
        Intrinsics.checkNotNullParameter(r10, "env");
        this.$$delegate_0.saveAdminNetEnv(r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveAdminSaaSLiveEnvHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        this.$$delegate_0.saveAdminSaaSLiveEnvHeader(r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveAdminTTEnvHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        this.$$delegate_0.saveAdminTTEnvHeader(r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveAdminTTFeatureHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        this.$$delegate_0.saveAdminTTFeatureHeader(r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveAdminWebViewEnvHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        this.$$delegate_0.saveAdminWebViewEnvHeader(r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveMockCurrentRegion(String r10) {
        this.$$delegate_0.saveMockCurrentRegion(r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveRpcResponseEnvHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        this.$$delegate_0.saveRpcResponseEnvHeader(r10);
    }

    @Override // com.obric.aikernel.middleware.api.env.IEnvManager
    public void saveTikTokLiveSdkDistEnvHeader(String r10) {
        Intrinsics.checkNotNullParameter(r10, "header");
        this.$$delegate_0.saveTikTokLiveSdkDistEnvHeader(r10);
    }
}
