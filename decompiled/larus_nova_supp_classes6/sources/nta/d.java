package nta;

import android.text.TextUtils;
import android.util.Base64;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d {
    public static String a;

    public static String[] c() {
        KeyGenerator r1 = KeyGenerator.getInstance("AES");     // Catch: Throwable -> L8
        SecureRandom r2 = new SecureRandom();     // Catch: Throwable -> L8
        r1.init(128, r2);     // Catch: Throwable -> L8
        byte[] r3 = new byte[8];     // Catch: Throwable -> L8
        r2.nextBytes(r3);     // Catch: Throwable -> L8
        String[] r0 = {b(r1.generateKey().getEncoded()), b(r3)};     // Catch: Throwable -> L8
        if (d(r0) == false) goto L6;
        return r0;
    L6:
        return null;
    L11:
        return null;
    }

    public static String a(String r2) {
        return new String(Base64.decode(r2.getBytes("UTF-8"), 2));
    L4:
        return "";
    }

    public static String b(byte[] r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r5 == null) goto L11;
        if (r1 >= r5.length) goto L11;
        String r2 = Integer.toHexString(r5[r1] & 255);
        if (r2.length() != 1) goto L9;
        r0.append('0');
    L9:
        r0.append(r2);
        r1 = r1 + 1;
    L11:
        return r0.toString();
    }

    public static boolean d(String[] r3) {
        if (r3 != null) goto L5;
    L16:
        return false;
    L5:
        if (r3.length != 2) goto L16;
        if (TextUtils.isEmpty(r3[0]) == true) goto L16;
        if (r3[0].length() != 32) goto L16;
        if (TextUtils.isEmpty(r3[1]) == true) goto L16;
        if (r3[1].length() != 16) goto L16;
        return true;
    }
}
