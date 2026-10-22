package com.bytedance.bdinstall.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SystemPropertiesWithCache {
    private static final Map<String, Object> sCache = null;
    private static final SystemPropertiesProxy sGetSystemProperties = null;

    static {
        sGetSystemProperties = new SystemPropertiesProxy();
        sCache = new ConcurrentHashMap();
    }

    public SystemPropertiesWithCache() {
    }

    public static Object get(String r2) {
        Map<String, Object> r0 = sCache;
        Object r1 = r0.get(r2);
        if (r1 == null) goto L5;
        return r1;
    L5:
        String r3 = sGetSystemProperties.get(r2);
        if (r3 == null) goto L8;
        r0.put(r2, r3);
    L8:
        return r3;
    }
}
