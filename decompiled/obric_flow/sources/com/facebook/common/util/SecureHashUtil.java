package com.facebook.common.util;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SecureHashUtil {
    public static String a(byte[] r5) {
        MessageDigest r10 = MessageDigest.getInstance("SHA-1");     // Catch: NoSuchAlgorithmException -> L4
        r10.update(r5, 0, r5.length);     // Catch: NoSuchAlgorithmException -> L4
        return Base64.encodeToString(r10.digest(), 11);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
