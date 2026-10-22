package com.bytedance.crash.util;

import androidx.annotation.Nullable;
import com.bytedance.crypto.utils.CryptoConst;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class Digest {
    public Digest() {
    }

    @Nullable
    public static String getMD5(String r10) {
        MessageDigest r11 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Throwable -> L11
        r11.update(r10.getBytes());     // Catch: Throwable -> L11
        byte[] r12 = r11.digest();     // Catch: Throwable -> L11
        if (r12.length <= 0) goto L9;
        int r13 = 0;
        char[] r14 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};     // Catch: Throwable -> L11
        char[] r15 = new char[r12.length * 2];     // Catch: Throwable -> L11
        int r16 = r12.length;     // Catch: Throwable -> L11
        int r17 = 0;
    L5:
        if (r13 >= r16) goto L7;
        byte r18 = r12[r13];     // Catch: Throwable -> L11
        int r19 = r17 + 1;     // Catch: Throwable -> L11
        r15[r17] = r14[(r18 >>> 4) & 15];     // Catch: Throwable -> L11
        r17 = r19 + 1;     // Catch: Throwable -> L11
        r15[r19] = r14[r18 & 15];     // Catch: Throwable -> L11
        r13 = r13 + 1;     // Catch: Throwable -> L11
        goto L5
    L7:
        return new String(r15);
    L9:
        return null;
    L15:
        return null;
    }
}
