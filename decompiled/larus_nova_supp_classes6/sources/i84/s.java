package i84;

import android.text.TextUtils;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class s {
    public static String a;

    public static String d() {
        if (TextUtils.isEmpty(a) == false) goto L6;
        a = a("Ynl0ZWRhbmNl");
    L6:
        return a;
    }

    public static String a(String r2) {
        return new String(Base64.decode(r2.getBytes("UTF-8"), 2));
    L4:
        return "";
    }

    public static String b(byte[] r3, String r4) throws Exception {
        byte[] r5 = Base64.decode(r3, 0);     // Catch: Exception -> L5
        Cipher r0 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: Exception -> L5
        r0.init(2, new SecretKeySpec(r4.getBytes(), "AES"), new IvParameterSpec("NIfb&95GUY86Gfgh".getBytes()));     // Catch: Exception -> L5
        return new String(r0.doFinal(r5)).trim();
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static byte[] c(String r4, String r5) throws Exception {
        Cipher r0 = Cipher.getInstance("AES/CBC/NoPadding");     // Catch: Exception -> L7
        int r1 = r0.getBlockSize();     // Catch: Exception -> L7
        byte[] r6 = r4.getBytes();     // Catch: Exception -> L7
        int r2 = r6.length;     // Catch: Exception -> L7
        if ((r2 % r1) == 0) goto L5;
        r2 = r2 + (r1 - (r2 % r1));     // Catch: Exception -> L7
    L5:
        byte[] r3 = new byte[r2];     // Catch: Exception -> L7
        System.arraycopy(r6, 0, r3, 0, r6.length);     // Catch: Exception -> L7
        r0.init(1, new SecretKeySpec(r5.getBytes(), "AES"), new IvParameterSpec("NIfb&95GUY86Gfgh".getBytes()));     // Catch: Exception -> L7
        return Base64.encode(r0.doFinal(r3), 0);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
