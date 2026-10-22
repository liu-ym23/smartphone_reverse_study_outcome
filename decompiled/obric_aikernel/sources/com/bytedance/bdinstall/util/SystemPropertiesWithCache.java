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

    public static Object get(String r10) {
        Map<String, Object> r11 = sCache;
        Object r12 = r11.get(r10);
        if (r12 == null) goto L5;
        return r12;
    L5:
        String r13 = sGetSystemProperties.get(r10);
        if (r13 == null) goto L8;
        r11.put(r10, r13);
    L8:
        return r13;
    }
}
