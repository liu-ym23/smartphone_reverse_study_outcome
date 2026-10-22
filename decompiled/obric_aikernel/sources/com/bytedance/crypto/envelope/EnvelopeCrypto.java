package com.bytedance.crypto.envelope;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class EnvelopeCrypto {
    private static final String TAG = "EnvelopeCrypto";
    private static volatile EnvelopeCrypto instance;

    private EnvelopeCrypto() {
    }

    public static EnvelopeCrypto getInstance() {
        if (instance != null) goto L15;
        monitor-enter(EnvelopeCrypto.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new EnvelopeCrypto();     // Catch: Throwable -> L11
    L9:
        monitor-exit(EnvelopeCrypto.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public int decrypt(byte[] r10, InputStream r11, OutputStream r12) {
        return EnvelopeCryptoImpl.getInstance().decrypt(r10, r11, r12);
    }

    public int encrypt(byte[] r10, byte[] r11, long r12, InputStream r13, OutputStream r14) {
        return EnvelopeCryptoImpl.getInstance().encrypt(r10, r11, r12, r13, r14);
    }

    public byte[] extractDEKCipher(InputStream r10) {
        return EnvelopeCryptoImpl.getInstance().extractDEKCipher(r10);
    }
}
