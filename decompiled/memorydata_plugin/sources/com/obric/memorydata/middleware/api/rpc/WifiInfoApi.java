package com.obric.memorydata.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\t\u0010\n\u001a\u00020\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\bH\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/middleware/api/rpc/WifiInfoApi;", "Lcom/obric/memorydata/middleware/api/rpc/IWifiInfoApi;", "<init>", "()V", "getUidRxBytes", "", "getUidTxBytes", "getWifiFrequency", "", "getWifiGeneration", "getWifiLevel", "getWifiRssi", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WifiInfoApi implements IWifiInfoApi {
    public static final WifiInfoApi INSTANCE = null;
    private final /* synthetic */ IWifiInfoApi $$delegate_0;

    static {
        INSTANCE = new WifiInfoApi();
    }

    private WifiInfoApi() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IWifiInfoApi.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IWifiInfoApi) ZeusTransformUtils.preCheckCast(r0, IWifiInfoApi.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IWifiInfoApi
    public long getUidRxBytes() {
        return this.$$delegate_0.getUidRxBytes();
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IWifiInfoApi
    public long getUidTxBytes() {
        return this.$$delegate_0.getUidTxBytes();
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IWifiInfoApi
    public int getWifiFrequency() {
        return this.$$delegate_0.getWifiFrequency();
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IWifiInfoApi
    public int getWifiGeneration() {
        return this.$$delegate_0.getWifiGeneration();
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IWifiInfoApi
    public int getWifiLevel() {
        return this.$$delegate_0.getWifiLevel();
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IWifiInfoApi
    public int getWifiRssi() {
        return this.$$delegate_0.getWifiRssi();
    }
}
