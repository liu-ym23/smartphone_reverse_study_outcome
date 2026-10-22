package com.obric.memorydata.middleware.impl.network;

import com.obric.memorydata.middleware.api.rpc.IRpcApi;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/RpcApiImpl;", "Lcom/obric/memorydata/middleware/api/rpc/IRpcApi;", "<init>", "()V", "getInst", "isRpcReady", "", "rpcReady", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RpcApiImpl implements IRpcApi {
    public static final RpcApiImpl INSTANCE = null;
    private static boolean isRpcReady;

    static {
        INSTANCE = new RpcApiImpl();
    }

    private RpcApiImpl() {
    }

    @JvmStatic
    public static final RpcApiImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IRpcApi
    public boolean isRpcReady() {
        return isRpcReady;
    }

    @Override // com.obric.memorydata.middleware.api.rpc.IRpcApi
    public void rpcReady() {
        isRpcReady = true;
    }
}
