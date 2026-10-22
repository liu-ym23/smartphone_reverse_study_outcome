package n4a;

import java.security.MessageDigest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b5 {
    public static String a(String r3) {
        if (r3 != null) goto L16;
        return null;
    L16:
        MessageDigest r1 = MessageDigest.getInstance(f5.o("ETUQ1"));     // Catch: Throwable -> L7
        r1.update(f5.j(r3));     // Catch: Throwable -> L7
        byte[] r4 = r1.digest();     // Catch: Throwable -> L7
    L14:
        return f5.s(r4);
    L11:
        th = move-exception;
        n.a(th, "ut", "h2s");
        return null;
    L7:
        th = move-exception;
        n.a(th, "MD5", "gmb");
        r4 = new byte[0];
        goto L14
    }
}
