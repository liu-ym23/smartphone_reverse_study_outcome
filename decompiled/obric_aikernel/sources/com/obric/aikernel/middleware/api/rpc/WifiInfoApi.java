package com.obric.aikernel.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiInfoApi implements IWifiInfoApi {
    public static final WifiInfoApi INSTANCE = null;
    private final /* synthetic */ IWifiInfoApi $$delegate_0;

    static {
        INSTANCE = new WifiInfoApi();
    }

    private WifiInfoApi() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IWifiInfoApi.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IWifiInfoApi) r10;
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IWifiInfoApi
    public long getUidRxBytes() {
        return this.$$delegate_0.getUidRxBytes();
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IWifiInfoApi
    public long getUidTxBytes() {
        return this.$$delegate_0.getUidTxBytes();
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IWifiInfoApi
    public int getWifiFrequency() {
        return this.$$delegate_0.getWifiFrequency();
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IWifiInfoApi
    public int getWifiGeneration() {
        return this.$$delegate_0.getWifiGeneration();
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IWifiInfoApi
    public int getWifiLevel() {
        return this.$$delegate_0.getWifiLevel();
    }

    @Override // com.obric.aikernel.middleware.api.rpc.IWifiInfoApi
    public int getWifiRssi() {
        return this.$$delegate_0.getWifiRssi();
    }
}
