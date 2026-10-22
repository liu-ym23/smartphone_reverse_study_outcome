package org.apache.logging.log4j.util;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f17919a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f17920b = false;
    public static final int c = 0;
    public static final int d = 0;
    public static final Object[] e = null;
    public static final byte[] f = null;

    static {
        PropertiesUtil r0 = PropertiesUtil.a();
        boolean r2 = true;
        if (b("javax.servlet.Servlet") == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        boolean r3 = r0.a("log4j2.is.webapp", r1);
        f17919a = r3;
        if (r3 == false) goto L12;
    L14:
        r2 = false;
    L15:
        f17920b = r2;
        c = a();
        d = a("log4j.maxReusableMsgSize", 518);
        e = new Object[0];
        f = new byte[0];
        return;
    L12:
        if (PropertiesUtil.a().a("log4j2.enable.threadlocals", true) == false) goto L14;
    L5:
        if (b("jakarta.servlet.Servlet") == true) goto L8;
        r1 = false;
        goto L9
    }

    private static int a() {
        return a(System.getProperty("java.version"));
    }

    static int a(String r4) {
        String[] r5 = r4.split("-|\\.");
        int r1 = Integer.parseInt(r5[0]);     // Catch: Exception -> L11
        if (r1 == 1) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
        return r1;
    L9:
        return Integer.parseInt(r5[1]);
    L6:
        r3 = false;
    L11:
        return 0;
    }

    private static int a(String r1, int r2) {
        return PropertiesUtil.a().a(r1, r2);
    }

    private static boolean b(String r1) {
        if (g.a(r1) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }
}
