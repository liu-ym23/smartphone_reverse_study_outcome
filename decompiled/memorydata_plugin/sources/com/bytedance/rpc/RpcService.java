package com.bytedance.rpc;

import android.app.Application;
import com.bytedance.rpc.annotation.RpcBizParam;
import com.bytedance.rpc.callback.RpcInterceptor;
import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import com.bytedance.rpc.log.LogInterceptor;
import com.bytedance.rpc.log.LogLevel;
import com.bytedance.rpc.log.Loggable;
import com.bytedance.rpc.log.Logger;
import com.bytedance.rpc.serialize.SerializeFactory;
import com.bytedance.rpc.serialize.SerializeManager;
import com.bytedance.rpc.serialize.SerializeType;
import com.bytedance.rpc.transport.TransportClientFactory;
import com.bytedance.rpc.transport.TransportRequestInterceptor;
import com.bytedance.rpc.transport.TransportResultInterceptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RpcService {
    private static volatile RpcContext sContext;
    private static Map<Class<?>, RpcInvokeContext> sRpcInvokeContext;
    private static volatile RpcInvoker sRpcInvoker;

    static {
        sRpcInvokeContext = new HashMap(4);
    }

    public RpcService() {
    }

    public static void addRpcInterceptor(RpcInterceptor r3, Class<?>... r4) {
        RpcInterceptor r5 = (RpcInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, RpcInterceptor.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L19;
        if (r4 != null) goto L6;
    L14:
        sContext.addRpcInterceptor(r5);
        return;
    L6:
        if (r4.length == 0) goto L14;
        int r0 = r4.length;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L20;
        Class<?> r2 = r4[r1];
        if (r2 == null) goto L13;
        getRpcInvokeContext(r2).addRpcInterceptor(r5);
    L13:
        r1 = r1 + 1;
        goto L9
    L20:
        return;
    }

    public static void addRpcInvokeInterceptor(RpcInvokeInterceptor r2) {
        RpcInvokeInterceptor r3 = (RpcInvokeInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, RpcInvokeInterceptor.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        sContext.addRpcInvokeInterceptor(r3);
        return;
    }

    public static void addTransportRequestInterceptor(TransportRequestInterceptor r2) {
        TransportRequestInterceptor r3 = (TransportRequestInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, TransportRequestInterceptor.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        sContext.addTransportRequestInterceptor(r3);
        return;
    }

    public static void addTransportResultInterceptor(TransportResultInterceptor r2) {
        TransportResultInterceptor r3 = (TransportResultInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, TransportResultInterceptor.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        sContext.addTransportResultInterceptor(r3);
        return;
    }

    public static void cancelRequest(int r1) {
        sRpcInvoker.cancelRequest(r1);
    }

    private static RpcInvokeContext createRPContext() {
        return new RpcInvokeContext(sContext);
    }

    public static RpcConfig.Builder createRpcConfigBuilder() {
        if (sContext != null) goto L7;
        return new RpcConfig.Builder();
    L7:
        return sContext.getRpcConfig().toBuilder();
    }

    public static int getLatestRequestId() {
        return sRpcInvoker.getLatestRequestId();
    }

    public static synchronized <T> T getProxy(Class<T> r6) {
        monitor-enter(RpcService.class);
        throwIfNotInitialized();     // Catch: Throwable -> L7
        T r7 = (T) Proxy.newProxyInstance(r6.getClassLoader(), new Class[]{r6}, new RpcInvocationHandler(r6, sRpcInvoker, getRpcInvokeContext(r6)));
        monitor-exit(RpcService.class);
        return r7;
    L7:
        th = move-exception;
        throw th;
    }

    public static RpcConfig getRpcConfig() {
        throwIfNotInitialized();
        return sContext.getRpcConfig();
    }

    public static RpcContext getRpcContext() {
        throwIfNotInitialized();
        return sContext;
    }

    public static RpcInvokeContext getRpcInvokeContext(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, Class.class) == false) goto L15;
        Map<Class<?>, RpcInvokeContext> r0 = sRpcInvokeContext;
        monitor-enter(r0);
        RpcInvokeContext r1 = (RpcInvokeContext) ZeusTransformUtils.preCheckCast(sRpcInvokeContext.get(r5), RpcInvokeContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        throwIfNotInitialized();     // Catch: Throwable -> L11
        r1 = createRPContext();     // Catch: Throwable -> L11
        sRpcInvokeContext.put((Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.memorydata.plugin"), r1);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L15:
        if (Proxy.isProxyClass(r5.getClass()) == false) goto L19;
        return ((RpcInvocationHandler) ZeusTransformUtils.preCheckCast(Proxy.getInvocationHandler(r5), RpcInvocationHandler.class, "com.obric.memorydata.plugin")).getRpcInvokeContext();
    L19:
        throw new IllegalArgumentException(r5.getClass().getName() + " class is not a proxy class ");
    }

    public static RequestModifier getRpcRequestModify() {
        return sRpcInvoker.getRequestModifier();
    }

    public static SerializeManager getSerializeManager() {
        throwIfNotInitialized();
        return sRpcInvoker.getSerializeManager();
    }

    public static void init(Application r3, RpcConfig r4) {
        Application r5 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L22;
        if (r4 == null) goto L22;
        if (Logger.isLoggableD() == false) goto L9;
        Logger.d(String.format("rpc: init config=%s", new Object[]{r4}));
    L9:
        if (sContext == null) goto L11;
        return;
    L11:
        monitor-enter(RpcService.class);
    L17:
        th = move-exception;
        throw th;
    L13:
        if (sContext != null) goto L15;
        sContext = new RpcContext(r5, r4);     // Catch: Throwable -> L17
        sRpcInvoker = new RpcInvoker(sContext);     // Catch: Throwable -> L17
    L15:
        monitor-exit(RpcService.class);     // Catch: Throwable -> L17
        return;
    L22:
        throw new RuntimeException("parameters of RpcService.init should not be null ");
    }

    public static boolean isInitialized() {
        if (sContext == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void registerBizModel(Object r3) {
        if (r3 == null) goto L10;
        throwIfNotInitialized();
        RpcBizParam r0 = (RpcBizParam) ZeusTransformUtils.preCheckCast(r3.getClass().getAnnotation(RpcBizParam.class), RpcBizParam.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        sContext.registerBizModel(r0.value(), r3);
        return;
    L6:
        if (Logger.isLoggableD() == false) goto L11;
        Logger.d(String.format("rpc: registerBizCommonModel with wrong argument=%s,it should have annotation RpcBizParam", new Object[]{r3}));
        return;
    L11:
        return;
    }

    public static void registerSerializeFactory(SerializeFactory r2) {
        SerializeFactory r3 = (SerializeFactory) ZeusTransformUtils.wrapperContextForParams(r2, SerializeFactory.class, "com.obric.memorydata.plugin");
        throwIfNotInitialized();
        sRpcInvoker.registerSerializeFactory(r3);
    }

    public static void removeRpcInterceptor(RpcInterceptor r3, Class<?>... r4) {
        RpcInterceptor r5 = (RpcInterceptor) ZeusTransformUtils.wrapperContextForParams(r3, RpcInterceptor.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L20;
        throwIfNotInitialized();
        if (r4 != null) goto L7;
    L15:
        sContext.removeRpcInterceptor(r5);
        return;
    L7:
        if (r4.length == 0) goto L15;
        int r0 = r4.length;
        int r1 = 0;
    L10:
        if (r1 >= r0) goto L21;
        Class<?> r2 = r4[r1];
        if (r2 == null) goto L14;
        getRpcInvokeContext(r2).removeRpcInterceptor(r5);
    L14:
        r1 = r1 + 1;
        goto L10
    L21:
        return;
    }

    public static void removeRpcInvokeInterceptor(RpcInvokeInterceptor r2) {
        RpcInvokeInterceptor r3 = (RpcInvokeInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, RpcInvokeInterceptor.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        sContext.removeRpcInvokeInterceptor(r3);
        return;
    }

    public static void removeSerializeFactory(SerializeType r1) {
        if (sRpcInvoker == null) goto L6;
        sRpcInvoker.removeSerializeFactory(r1);
        return;
    }

    public static void removeTransportRequestInterceptor(TransportRequestInterceptor r2) {
        TransportRequestInterceptor r3 = (TransportRequestInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, TransportRequestInterceptor.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        sContext.removeTransportRequestInterceptor(r3);
        return;
    }

    public static void removeTransportResultInterceptor(TransportResultInterceptor r2) {
        TransportResultInterceptor r3 = (TransportResultInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, TransportResultInterceptor.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        sContext.removeTransportResultInterceptor(r3);
        return;
    }

    public static void setLogDelegate(Loggable r2) {
        Logger.setLogDelegate((Loggable) ZeusTransformUtils.wrapperContextForParams(r2, Loggable.class, "com.obric.memorydata.plugin"));
    }

    public static void setLogInterceptor(LogInterceptor r2) {
        Logger.setLogIntercept((LogInterceptor) ZeusTransformUtils.wrapperContextForParams(r2, LogInterceptor.class, "com.obric.memorydata.plugin"));
    }

    public static void setLogLevel(LogLevel r0) {
        Logger.setLogLevel(r0);
    }

    public static void setLogTag(String r0) {
        Logger.setLogTag(r0);
    }

    public static void setTransportFactory(TransportClientFactory r2) {
        TransportClientFactory r3 = (TransportClientFactory) ZeusTransformUtils.wrapperContextForParams(r2, TransportClientFactory.class, "com.obric.memorydata.plugin");
        throwIfNotInitialized();
        sRpcInvoker.setTransportFactory(r3);
    }

    private static void throwIfNotInitialized() {
        if (sContext == null) goto L6;
        return;
    L6:
        throw new RuntimeException("had you called RpcService.init(Application,RpcConfig)");
    }

    private static void updateContextConfig(RpcConfig r5) {
        sContext.updateRpcConfig(r5);
        if (r5.changed(9) == true) goto L5;
        return;
    L5:
        if (sRpcInvokeContext.isEmpty() == false) goto L7;
        return;
    L7:
        monitor-enter(RpcService.class);
        Iterator<Map.Entry<Class<?>, RpcInvokeContext>> r1 = sRpcInvokeContext.entrySet().iterator();     // Catch: Throwable -> L14
    L10:
        if (r1.hasNext() == false) goto L12;
        ((RpcInvokeContext) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), RpcInvokeContext.class, "com.obric.memorydata.plugin")).updateConfig(r5);     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(RpcService.class);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static boolean updateRpcConfig(RpcConfig r2) {
        if (r2 == null) goto L7;
        throwIfNotInitialized();
        if (r2.computeChangedFlag(getRpcConfig(), true) == 0) goto L7;
        updateContextConfig(r2);
        return true;
    L7:
        return false;
    }
}
