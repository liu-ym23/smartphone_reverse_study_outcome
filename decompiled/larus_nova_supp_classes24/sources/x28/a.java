package x28;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static byte[] a(String r1) {
        Charset r0 = Charsets.UTF_8;
        if (r1 != null) goto L5;
        byte[] r2 = null;
    L13:
        return MessageDigest.getInstance("MD5").digest(r2);
    L10:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L5:
        r2 = r1.getBytes(r0);
        goto L13
    }

    public static byte[] b(String r1) {
        Charset r0 = Charsets.UTF_8;
        if (r1 != null) goto L5;
        byte[] r2 = null;
    L13:
        return MessageDigest.getInstance("SHA-1").digest(r2);
    L10:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L5:
        r2 = r1.getBytes(r0);
        goto L13
    }
}
