package com.obric.memorydata.middleware.api.env;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\t\u0010\f\u001a\u00020\u0005H\u0096\u0001J\t\u0010\r\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0096\u0001¨\u0006 "}, d2 = {"Lcom/obric/memorydata/middleware/api/env/EnvManager;", "Lcom/obric/memorydata/middleware/api/env/IEnvManager;", "<init>", "()V", "applyAdminWebViewEnvHeader", "", "url", "getAbDebugHeader", "", "getAdminNetEnv", "Lcom/obric/memorydata/middleware/api/env/NetEnv;", "getAdminSaaSLiveEnvHeader", "getAdminTTEnvHeader", "getAdminTTFeatureHeader", "getAdminWebViewEnvHeader", "getMockCurrentRegion", "getRpcResponseEnvHeader", "getTikTokLiveSdkDistEnvHeader", "removeEnv", "", "saveAbDebugHeader", "header", "saveAdminNetEnv", "env", "saveAdminSaaSLiveEnvHeader", "saveAdminTTEnvHeader", "saveAdminTTFeatureHeader", "saveAdminWebViewEnvHeader", "saveMockCurrentRegion", "currentRegion", "saveRpcResponseEnvHeader", "saveTikTokLiveSdkDistEnvHeader", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EnvManager implements IEnvManager {
    public static final EnvManager INSTANCE = null;
    private final /* synthetic */ IEnvManager $$delegate_0;

    static {
        INSTANCE = new EnvManager();
    }

    private EnvManager() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IEnvManager.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IEnvManager) ZeusTransformUtils.preCheckCast(r0, IEnvManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String applyAdminWebViewEnvHeader(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        return this.$$delegate_0.applyAdminWebViewEnvHeader(r2);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public int getAbDebugHeader() {
        return this.$$delegate_0.getAbDebugHeader();
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public NetEnv getAdminNetEnv() {
        return this.$$delegate_0.getAdminNetEnv();
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getAdminSaaSLiveEnvHeader() {
        return this.$$delegate_0.getAdminSaaSLiveEnvHeader();
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getAdminTTEnvHeader() {
        return this.$$delegate_0.getAdminTTEnvHeader();
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getAdminTTFeatureHeader() {
        return this.$$delegate_0.getAdminTTFeatureHeader();
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getAdminWebViewEnvHeader() {
        return this.$$delegate_0.getAdminWebViewEnvHeader();
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getMockCurrentRegion() {
        return this.$$delegate_0.getMockCurrentRegion();
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getRpcResponseEnvHeader() {
        return this.$$delegate_0.getRpcResponseEnvHeader();
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public String getTikTokLiveSdkDistEnvHeader() {
        return this.$$delegate_0.getTikTokLiveSdkDistEnvHeader();
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void removeEnv() {
        this.$$delegate_0.removeEnv();
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveAbDebugHeader(int r1) {
        this.$$delegate_0.saveAbDebugHeader(r1);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveAdminNetEnv(NetEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.$$delegate_0.saveAdminNetEnv(r2);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveAdminSaaSLiveEnvHeader(String r2) {
        Intrinsics.checkNotNullParameter(r2, "header");
        this.$$delegate_0.saveAdminSaaSLiveEnvHeader(r2);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveAdminTTEnvHeader(String r2) {
        Intrinsics.checkNotNullParameter(r2, "header");
        this.$$delegate_0.saveAdminTTEnvHeader(r2);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveAdminTTFeatureHeader(String r2) {
        Intrinsics.checkNotNullParameter(r2, "header");
        this.$$delegate_0.saveAdminTTFeatureHeader(r2);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveAdminWebViewEnvHeader(String r2) {
        Intrinsics.checkNotNullParameter(r2, "header");
        this.$$delegate_0.saveAdminWebViewEnvHeader(r2);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveMockCurrentRegion(String r1) {
        this.$$delegate_0.saveMockCurrentRegion(r1);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveRpcResponseEnvHeader(String r2) {
        Intrinsics.checkNotNullParameter(r2, "header");
        this.$$delegate_0.saveRpcResponseEnvHeader(r2);
    }

    @Override // com.obric.memorydata.middleware.api.env.IEnvManager
    public void saveTikTokLiveSdkDistEnvHeader(String r2) {
        Intrinsics.checkNotNullParameter(r2, "header");
        this.$$delegate_0.saveTikTokLiveSdkDistEnvHeader(r2);
    }
}
