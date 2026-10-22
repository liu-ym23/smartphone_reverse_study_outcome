package org.apache.xmlbeans.impl.common;

/* JADX INFO: loaded from: classes7.dex */
public class GlobalLock {
    private static final Mutex GLOBAL_MUTEX = null;

    static {
        GLOBAL_MUTEX = new Mutex();
    }

    public static void acquire() {
        GLOBAL_MUTEX.acquire();
    }

    public static void release() {
        GLOBAL_MUTEX.release();
    }
}
