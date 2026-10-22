package com.byted.cast.sdk.log;

import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class LoggerManager {
    private static final Map<String, Logger> LOGGER_CACHE = null;

    static {
        LOGGER_CACHE = new WeakHashMap();
    }

    private LoggerManager() {
        throw new UnsupportedOperationException();
    }

    public static Logger getLogger(String r10) {
        Map<String, Logger> r0 = LOGGER_CACHE;
        monitor-enter(r0);
        Logger r1 = r0.get(r10);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        if (r1 != null) goto L15;
        r1 = new Logger(r10);
        monitor-enter(r0);
        r0.put(r10, r1);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        return r1;
    L16:
        th = move-exception;
        throw th;
    }
}
