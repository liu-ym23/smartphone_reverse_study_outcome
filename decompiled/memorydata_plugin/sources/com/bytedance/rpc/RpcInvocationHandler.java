package com.bytedance.rpc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RpcInvocationHandler implements InvocationHandler {
    private Class<?> mClazz;
    private final Map<Method, RpcMethod> mMethodCache;
    private RpcInvokeContext mRpcInvokeContext;
    private RpcInvoker mRpcInvoker;

    public RpcInvocationHandler(Class<?> r2, RpcInvoker r3, RpcInvokeContext r4) {
        this.mMethodCache = new LinkedHashMap();
        this.mClazz = r2;
        this.mRpcInvoker = r3;
        this.mRpcInvokeContext = r4;
    }

    private RpcRequest createRpcRequest(RpcInvokeContext r1, Method r2, Object[] r3) {
        return loadRpcMethod(r2).toRequest(r1, r3);
    }

    private RpcMethod loadRpcMethod(Method r5) {
        Map<Method, RpcMethod> r0 = this.mMethodCache;
        monitor-enter(r0);
        RpcMethod r1 = (RpcMethod) ZeusTransformUtils.preCheckCast(this.mMethodCache.get(r5), RpcMethod.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        r1 = new RpcMethod(this.mClazz, r5);     // Catch: Throwable -> L9
        this.mMethodCache.put(r5, r1);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public RpcInvokeContext getRpcInvokeContext() {
        return this.mRpcInvokeContext;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r1, Method r2, Object[] r3) {
        RpcRequest r4 = createRpcRequest(this.mRpcInvokeContext, r2, r3);
        return this.mRpcInvoker.invokeWithIntercept(r4);
    }
}
