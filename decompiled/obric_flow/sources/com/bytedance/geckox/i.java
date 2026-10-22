package com.bytedance.geckox;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends BaseGeckoConfig.BaseGeckoConfigBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f4752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f4753b;

    public i(Context r5) {
        super(r5.getApplicationContext());
    }

    public final i a(long r5) {
        return (i) super.appId(r5);
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
    public final BaseGeckoConfig.BaseGeckoConfigBuilder appId(long r5) {
        return (i) super.appId(r5);
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
    public final BaseGeckoConfig.BaseGeckoConfigBuilder appVersion(String r5) {
        return this;
    }

    public final i b(String r5) {
        return (i) super.deviceId(r5);
    }

    public final i c(String r5) {
        return (i) super.host(r5);
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
    public final BaseGeckoConfig.BaseGeckoConfigBuilder checkUpdateExecutor(Executor r5) {
        return this;
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
    public final BaseGeckoConfig.BaseGeckoConfigBuilder deviceId(String r5) {
        return (i) super.deviceId(r5);
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
    public final BaseGeckoConfig.BaseGeckoConfigBuilder host(String r5) {
        return (i) super.host(r5);
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
    public final BaseGeckoConfig.BaseGeckoConfigBuilder netStack(ta.b r5) {
        return this;
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
    public final BaseGeckoConfig.BaseGeckoConfigBuilder region(String r5) {
        return this;
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
    public final BaseGeckoConfig.BaseGeckoConfigBuilder statisticMonitor(ya.a r5) {
        return this;
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
    public final BaseGeckoConfig.BaseGeckoConfigBuilder updateExecutor(Executor r5) {
        return this;
    }

    @Override // com.bytedance.geckox.BaseGeckoConfig.BaseGeckoConfigBuilder
    public final BaseGeckoConfig.BaseGeckoConfigBuilder useMMap(boolean r5) {
        return this;
    }
}
