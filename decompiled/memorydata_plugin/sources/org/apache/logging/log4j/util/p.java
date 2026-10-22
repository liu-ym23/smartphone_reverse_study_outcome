package org.apache.logging.log4j.util;

import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: loaded from: classes6.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static o f17938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f17939b;

    static {
        f17938a = o.a();
    }

    public static Class<?> a(int r1) {
        return f17938a.a(r1 + 1);
    }

    public static StackTraceElement a(String r3) {
        return f17938a.a(r3);
    L4:
        e = move-exception;
        if (f17939b == true) goto L12;
        f17939b = true;
        StatusLogger.getLogger().warn("Unable to locate stack trace element for {}", r3, e);
        return null;
    L12:
        return null;
    }
}
