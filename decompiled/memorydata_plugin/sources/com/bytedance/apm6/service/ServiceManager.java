package com.bytedance.apm6.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ServiceManager {
    private static final ConcurrentHashMap<Class, Object> SERVICES = null;
    private static final ConcurrentHashMap<Class, ServiceCreator<?>> SERVICE_CREATORS = null;
    private static final ConcurrentHashMap<Class, ServiceLoadListener> SERVICE_LOAD_LISTENERS = null;

    static {
        SERVICES = new ConcurrentHashMap();
        SERVICE_CREATORS = new ConcurrentHashMap();
        SERVICE_LOAD_LISTENERS = new ConcurrentHashMap();
    }

    public ServiceManager() {
    }

    public static <T> T getService(Class<T> r6) {
        T r0 = (T) SERVICES.get(r6);
        if (r0 == null) goto L5;
    L18:
        return r0;
    L5:
        monitor-enter(ServiceManager.class);
        ConcurrentHashMap<Class, ServiceCreator<?>> r2 = SERVICE_CREATORS;     // Catch: Throwable -> L15
        ServiceCreator r3 = (ServiceCreator) ZeusTransformUtils.preCheckCast(r2.get(r6), ServiceCreator.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r3 == null) goto L13;
        r0 = (T) r3.create();
        r2.remove(r6);     // Catch: Throwable -> L15
        if (r0 == null) goto L13;
        putService(r6, r0);     // Catch: Throwable -> L15
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L15
        return r0;
    L13:
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private static <T> void putService(Class<T> r4, T r5) {
        SERVICES.put(r4, r5);
        ConcurrentHashMap<Class, ServiceLoadListener> r0 = SERVICE_LOAD_LISTENERS;
        ServiceLoadListener r1 = (ServiceLoadListener) ZeusTransformUtils.preCheckCast(r0.get(r4), ServiceLoadListener.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.onServiceLoaded(r5);
        r0.remove(r4);
        return;
    }

    public static <T> void registerService(Class<T> r2, ServiceCreator<T> r3) {
        ServiceCreator<?> r4 = (ServiceCreator) ZeusTransformUtils.wrapperContextForParams(r3, ServiceCreator.class, "com.obric.memorydata.plugin");
        SERVICE_CREATORS.put(r2, r4);
    }

    public static <T> void registerService(Class<T> r1, T r2) {
        SERVICES.put(r1, r2);
    }

    public static <T> void registerServiceLoadListener(Class<T> r2, ServiceLoadListener<T> r3) {
        ServiceLoadListener r4 = (ServiceLoadListener) ZeusTransformUtils.wrapperContextForParams(r3, ServiceLoadListener.class, "com.obric.memorydata.plugin");
        SERVICE_LOAD_LISTENERS.put(r2, r4);
    }

    public static <T> void unregisterService(Class<T> r1, T r2) {
        SERVICES.remove(r1, r2);
    }
}
