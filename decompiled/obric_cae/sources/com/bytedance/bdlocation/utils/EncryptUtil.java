package com.bytedance.bdlocation.utils;

import android.util.Base64;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EncryptUtil {
    public EncryptUtil() {
    }

    public static String decrypt(String r8) {
        if (r8 != null) goto L5;
    L13:
        return null;
    L5:
        if (r8.isEmpty() == true) goto L13;
        byte[] r10 = Base64.decode(r8, 10);     // Catch: Exception -> L14
        int r11 = r10.length;     // Catch: Exception -> L14
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L11;
        r10[r12] = (byte) (r10[r12] ^ (-99));     // Catch: Exception -> L14
        r12 = r12 + 1;     // Catch: Exception -> L14
        goto L9
    L11:
        return new String(r10);
    }

    public static String encrypt(JSONObject r8) {
        if (r8 != null) goto L11;
        return null;
    L11:
        byte[] r10 = r8.toString().getBytes("utf-8");     // Catch: Exception -> L10
        int r11 = r10.length;     // Catch: Exception -> L10
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L8;
        r10[r12] = (byte) (r10[r12] ^ (-99));     // Catch: Exception -> L10
        r12 = r12 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
        return Base64.encodeToString(r10, 10);
    L10:
        return null;
    }
}
