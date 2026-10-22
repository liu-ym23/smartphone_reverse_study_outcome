package com.bytedance.bdinstall.service;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ServiceManager {
    private static HashMap<Class, HashMap<String, ?>> gServices;
    public static final ConcurrentHashMap<String, ServiceManager> sManagerMap = null;
    private final ConcurrentHashMap<Class, ServiceCreator> sServiceCreators;
    private final ConcurrentHashMap<Class, Object> sServices;

    static {
        sManagerMap = new ConcurrentHashMap();
    }

    public ServiceManager() {
        this.sServices = new ConcurrentHashMap();
        this.sServiceCreators = new ConcurrentHashMap();
    }

    public static <T> T getService(Class<T> r10, String r11) {
        ServiceManager r12 = sManagerMap.get(r11);
        if (r12 != null) goto L5;
        return null;
    L5:
        return (T) r12.sServices.get(r10);
    }

    public static <T> void registerService(Class<T> r10, T r11, String r12) {
        ConcurrentHashMap<String, ServiceManager> r13 = sManagerMap;
        ServiceManager r14 = r13.get(r12);
        if (r14 != null) goto L5;
        r14 = new ServiceManager();
        r13.put(r12, r14);
    L5:
        r14.sServices.put(r10, r11);
    }

    public static synchronized <T> void unregisterService(Class<T> r10, T r11, String r12) {
        monitor-enter(ServiceManager.class);
        HashMap<Class, HashMap<String, ?>> r13 = gServices;     // Catch: Throwable -> L15
        if (r13 == null) goto L13;
        if (r11 == null) goto L13;
        HashMap<String, ?> r14 = r13.get(r10);     // Catch: Throwable -> L15
        if (r14 == null) goto L11;
        r14.remove(r12);     // Catch: Throwable -> L15
    L11:
        monitor-exit(ServiceManager.class);
        return;
    L13:
        monitor-exit(ServiceManager.class);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
