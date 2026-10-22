package com.ttnet.org.chromium.base;

import java.io.FileInputStream;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public class ByteArrayGenerator {
    public ByteArrayGenerator() {
    }

    public byte[] getBytes(int r10) {
        FileInputStream r11 = new FileInputStream("/dev/urandom");     // Catch: Throwable -> L12
        byte[] r12 = new byte[r10];     // Catch: Throwable -> L10
        if (r10 != r11.read(r12)) goto L9;
        r11.close();
        return r12;
    L9:
        throw new GeneralSecurityException("Not enough random data available");     // Catch: Throwable -> L10
    L10:
        Throwable th = th;
    L14:
        if (r11 == null) goto L16;
        r11.close();
    L16:
        throw th;
    L12:
        th = move-exception;
        r11 = null;
        th = th;
        goto L14
    }
}
