package com.bytedance.apm6.service;

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

    public static <T> T getService(Class<T> r10) {
        T r11 = (T) SERVICES.get(r10);
        if (r11 == null) goto L5;
    L18:
        return r11;
    L5:
        monitor-enter(ServiceManager.class);
        ConcurrentHashMap<Class, ServiceCreator<?>> r12 = SERVICE_CREATORS;     // Catch: Throwable -> L15
        ServiceCreator<?> r13 = r12.get(r10);     // Catch: Throwable -> L15
        if (r13 == null) goto L13;
        r11 = (T) r13.create();
        r12.remove(r10);     // Catch: Throwable -> L15
        if (r11 == null) goto L13;
        putService(r10, r11);     // Catch: Throwable -> L15
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L15
        return r11;
    L13:
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private static <T> void putService(Class<T> r10, T r11) {
        SERVICES.put(r10, r11);
        ConcurrentHashMap<Class, ServiceLoadListener> r12 = SERVICE_LOAD_LISTENERS;
        ServiceLoadListener r13 = r12.get(r10);
        if (r13 == null) goto L6;
        r13.onServiceLoaded(r11);
        r12.remove(r10);
        return;
    }

    public static <T> void registerService(Class<T> r10, ServiceCreator<T> r11) {
        SERVICE_CREATORS.put(r10, r11);
    }

    public static <T> void registerService(Class<T> r10, T r11) {
        SERVICES.put(r10, r11);
    }

    public static <T> void registerServiceLoadListener(Class<T> r10, ServiceLoadListener<T> r11) {
        SERVICE_LOAD_LISTENERS.put(r10, r11);
    }

    public static <T> void unregisterService(Class<T> r10, T r11) {
        SERVICES.remove(r10, r11);
    }
}
