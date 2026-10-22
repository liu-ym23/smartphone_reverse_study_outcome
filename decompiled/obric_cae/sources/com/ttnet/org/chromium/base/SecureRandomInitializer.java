package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"SecureRandom"})
public class SecureRandomInitializer {
    private static final int NUM_RANDOM_BYTES = 16;

    public SecureRandomInitializer() {
    }

    public static void initialize(SecureRandom r8) {
        FileInputStream r10 = new FileInputStream("/dev/urandom");
        byte[] r11 = new byte[16];     // Catch: Throwable -> L10
        if (r10.read(r11) != 16) goto L9;
        r8.setSeed(r11);     // Catch: Throwable -> L10
        r10.close();
        return;
    L9:
        throw new IOException("Failed to get enough random data.");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L15
    L17:
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }
}
