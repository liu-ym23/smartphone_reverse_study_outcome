package com.loc;

import com.bytedance.crypto.utils.CryptoConst;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public final class ft {
    public static String a(String r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return fx.e(c(r0));
    }

    public static String a(byte[] r1) {
        return fx.e(a(r1, fx.c("ETUQ1")));
    }

    public static byte[] a(byte[] r1, String r2) {
        MessageDigest r3 = MessageDigest.getInstance(r2);     // Catch: Throwable -> L4
        r3.update(r1);     // Catch: Throwable -> L4
        return r3.digest();
    L4:
        th = move-exception;
        n.a(th, CryptoConst.ALGORITHM_MD5, "gmb");
        return null;
    }

    public static String b(String r0) {
        return fx.f(d(r0));
    }

    private static byte[] c(String r2) {
        return e(r2);
    L4:
        th = move-exception;
        n.a(th, CryptoConst.ALGORITHM_MD5, "gmb");
        return new byte[0];
    }

    private static byte[] d(String r0) {
        return e(r0);
    L4:
        th = move-exception;
        th.printStackTrace();
        return new byte[0];
    }

    private static byte[] e(String r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        MessageDigest r0 = MessageDigest.getInstance(fx.c("ETUQ1"));
        r0.update(fx.a(r1));
        return r0.digest();
    }
}
