package com.ctc.wstx.shaded.msv_core.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3552a;

    static {
    L9:
        f3552a = false;
        return;
    L4:
        if (System.getProperty("com.ctc.wstx.shaded.msv_core.debug") == null) goto L6;
        boolean r1 = true;
    L7:
        f3552a = r1;     // Catch: SecurityException -> L9
        return;
    L6:
        r1 = false;
        goto L7
    }
}
