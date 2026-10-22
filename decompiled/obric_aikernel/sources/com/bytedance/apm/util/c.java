package com.bytedance.apm.util;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.crypto.utils.CryptoConst;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class c {
    static {
    }

    public static String a(byte[] r10, String r11) {
        byte[] r12 = Base64.decode(r10, 0);     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return "";
    L8:
        return b(r11, r12);
    L9:
        return "";
    }

    private static String b(String r10, byte[] r11) {
        String r12 = "";
        SecretKeySpec r13 = new SecretKeySpec(r10.getBytes(), CryptoConst.ALGORITHM_AES);     // Catch: Exception -> L11
        Cipher r14 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Exception -> L11
        r14.init(2, r13);     // Catch: Exception -> L11
        String r15 = new String(r14.doFinal(r11));     // Catch: Exception -> L11
        int r16 = r15.indexOf("$");     // Catch: Exception -> L8
        if (r16 == (-1)) goto L16;
        return r15.substring(0, r16);
    L16:
        return r15;
    L8:
        r12 = r15;
    L10:
        return r12;
    }
}
