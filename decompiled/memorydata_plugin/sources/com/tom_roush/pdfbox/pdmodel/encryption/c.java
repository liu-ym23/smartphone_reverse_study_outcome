package com.tom_roush.pdfbox.pdmodel.encryption;

import com.bytedance.crypto.utils.CryptoConst;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes6.dex */
final class c {
    static MessageDigest a() {
        return MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    static MessageDigest b() {
        return MessageDigest.getInstance("SHA-1");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    static MessageDigest c() {
        return MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
