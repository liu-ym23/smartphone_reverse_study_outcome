package com.bytedance.crash.util;

import com.bytedance.frameworks.core.encrypt.b;

/* JADX INFO: loaded from: classes2.dex */
public class EncryptUtils {
    public EncryptUtils() {
    }

    public static byte[] encrypt(byte[] r1) {
        return b.a(r1, r1.length);
    }
}
