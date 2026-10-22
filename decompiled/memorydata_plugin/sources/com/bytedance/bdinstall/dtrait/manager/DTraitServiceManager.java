package com.bytedance.bdinstall.dtrait.manager;

import com.bytedance.bdinstall.dtrait.interfaces.ServiceCreator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class DTraitServiceManager {
    private static final String TAG = "ServiceManager ";
    private static final ConcurrentHashMap<Class, ServiceCreator> sServiceCreators = null;
    private static final ConcurrentHashMap<Class, Object> sServices = null;

    static {
        sServices = new ConcurrentHashMap();
        sServiceCreators = new ConcurrentHashMap();
    }

    public DTraitServiceManager() {
    }

    public static <T> T getService(Class<T> r6) {
        ConcurrentHashMap<Class, Object> r0 = sServices;
        Object r1 = (T) r0.get(r6);
        if (r1 != null) goto L18;
        monitor-enter(r0);
        r1 = r0.get(r6);     // Catch: Throwable -> L15
        if (r1 != null) goto L13;
        ConcurrentHashMap<Class, ServiceCreator> r2 = sServiceCreators;     // Catch: Throwable -> L15
        ServiceCreator r3 = (ServiceCreator) ZeusTransformUtils.preCheckCast(r2.get(r6), ServiceCreator.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r3 == null) goto L13;
        r1 = (T) r3.create(r6);
        if (r1 == null) goto L12;
        r0.put(r6, r1);     // Catch: Throwable -> L15
    L12:
        r2.remove(r6);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        return (T) r1;
    }

    public static <T> void registerService(Class<T> r1, T r2) {
        sServices.put(r1, r2);
    }

    public static <T> void unregisterService(Class<T> r1, T r2) {
        sServices.remove(r1, r2);
    }
}
