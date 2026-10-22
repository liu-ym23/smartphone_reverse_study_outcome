package com.obric.memorydata.middleware.api.rpc;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/middleware/api/rpc/RpcApi;", "Lcom/obric/memorydata/middleware/api/rpc/IRpcApi;", "<init>", "()V", "isRpcReady", "", "rpcReady", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RpcApi implements IRpcApi {
    public static final RpcApi INSTANCE = null;
    private final /* synthetic */ IRpcApi $$delegate_0;

    static {
        INSTANCE = new RpcApi();
    }

    private RpcApi() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IRpcApi.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IRpcApi) ZeusTransformUtils.preCheckCast(r0, IRpcApi.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IRpcApi
    public boolean isRpcReady() {
        return this.$$delegate_0.isRpcReady();
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IRpcApi
    public void rpcReady() {
        this.$$delegate_0.rpcReady();
    }
}
