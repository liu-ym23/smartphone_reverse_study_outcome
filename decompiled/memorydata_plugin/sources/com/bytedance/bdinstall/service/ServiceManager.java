package com.bytedance.bdinstall.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public static <T> T getService(Class<T> r2, String r3) {
        ServiceManager r4 = (ServiceManager) ZeusTransformUtils.preCheckCast(sManagerMap.get(r3), ServiceManager.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        return (T) r4.sServices.get(r2);
    }

    public static <T> void registerService(Class<T> r4, T r5, String r6) {
        ConcurrentHashMap<String, ServiceManager> r0 = sManagerMap;
        ServiceManager r1 = (ServiceManager) ZeusTransformUtils.preCheckCast(r0.get(r6), ServiceManager.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        r1 = new ServiceManager();
        r0.put(r6, r1);
    L5:
        r1.sServices.put(r4, r5);
    }

    public static synchronized <T> void unregisterService(Class<T> r2, T r3, String r4) {
        monitor-enter(ServiceManager.class);
        HashMap<Class, HashMap<String, ?>> r1 = gServices;     // Catch: Throwable -> L15
        if (r1 == null) goto L13;
        if (r3 == null) goto L13;
        HashMap r5 = (HashMap) ZeusTransformUtils.preCheckCast(r1.get(r2), HashMap.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r5 == null) goto L11;
        r5.remove(r4);     // Catch: Throwable -> L15
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
