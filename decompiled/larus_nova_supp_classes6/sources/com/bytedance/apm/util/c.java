package com.bytedance.apm.util;

import android.text.TextUtils;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c {
    public static String a = "";

    public static String a(byte[] r2, String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        r3 = a;
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L15;
        return "";
    L15:
        return b(r3, Base64.decode(r2, 0));
    L12:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String b(String r3, byte[] r4) {
        String r0 = "";
        SecretKeySpec r1 = new SecretKeySpec(r3.getBytes(), "AES");     // Catch: Exception -> L11
        Cipher r5 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Exception -> L11
        r5.init(2, r1);     // Catch: Exception -> L11
        String r6 = new String(r5.doFinal(r4));     // Catch: Exception -> L11
        int r7 = r6.indexOf("$");     // Catch: Exception -> L8
        if (r7 == (-1)) goto L16;
        return r6.substring(0, r7);
    L16:
        return r6;
    L8:
        r0 = r6;
    L10:
        return r0;
    }
}
