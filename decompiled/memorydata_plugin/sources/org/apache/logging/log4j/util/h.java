package org.apache.logging.log4j.util;

import java.io.PrintWriter;

/* JADX INFO: loaded from: classes6.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static PrintWriter f17927a;

    static {
        f17927a = new PrintWriter(System.err, true);
    }

    public static void a(String r1) {
        if (r1 == null) goto L5;
        f17927a.println(r1);
        return;
    }

    public static void a(String r0, Throwable r1) {
        a(r0);
        a(r1);
    }

    public static void a(Throwable r1) {
        if (r1 == null) goto L5;
        r1.printStackTrace(f17927a);
        return;
    }
}
