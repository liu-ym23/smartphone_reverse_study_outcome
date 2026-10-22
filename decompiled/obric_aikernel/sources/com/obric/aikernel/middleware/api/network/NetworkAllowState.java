package com.obric.aikernel.middleware.api.network;

import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.p1;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkAllowState implements INetworkAllowState {
    public static final NetworkAllowState INSTANCE = null;
    private final /* synthetic */ INetworkAllowState $$delegate_0;

    static {
        INSTANCE = new NetworkAllowState();
    }

    private NetworkAllowState() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(INetworkAllowState.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (INetworkAllowState) r10;
    }

    @Override // com.obric.aikernel.middleware.api.network.INetworkAllowState
    public p1<Boolean> getAllowState() {
        return this.$$delegate_0.getAllowState();
    }

    @Override // com.obric.aikernel.middleware.api.network.INetworkAllowState
    public void init() {
        this.$$delegate_0.init();
    }

    @Override // com.obric.aikernel.middleware.api.network.INetworkAllowState
    public boolean isAllowNetworkRequestNow() {
        return this.$$delegate_0.isAllowNetworkRequestNow();
    }
}
