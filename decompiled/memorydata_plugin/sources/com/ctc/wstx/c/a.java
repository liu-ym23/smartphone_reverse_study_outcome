package com.ctc.wstx.c;

import java.util.logging.Logger;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0173a f3453a = null;

    /* JADX INFO: renamed from: com.ctc.wstx.c.a$a, reason: collision with other inner class name */
    private static final class C0173a {
        public C0173a() {
        }

        public QName a(String r1, String r2, String r3) {
            return new QName(r1, r2, r3);
        }
    }

    static {
        C0173a r0 = new C0173a();     // Catch: Throwable -> L4
        r0.a("elem", "http://dummy", "ns");     // Catch: Throwable -> L4
    L10:
        f3453a = r0;
        return;
    L4:
        th = move-exception;
        String r1 = "Could not construct QNameCreator.Helper; assume 3-arg QName constructor not available and use 2-arg method instead. Problem: " + th.getMessage();
        Logger.getLogger("com.ctc.wstx.compat.QNameCreator").warning(r1);     // Catch: Throwable -> L8
    L9:
        r0 = null;
    L8:
        System.err.println("ERROR: failed to log error using Logger (problem " + th.getMessage() + "), original problem: " + r1);
        goto L9
    }

    public static QName a(String r1, String r2, String r3) {
        C0173a r0 = f3453a;
        if (r0 != null) goto L7;
        return new QName(r1, r2);
    L7:
        return r0.a(r1, r2, r3);
    }
}
