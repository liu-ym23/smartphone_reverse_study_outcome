package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class ImportantFileWriterAndroid {
    public ImportantFileWriterAndroid() {
    }

    private static native boolean nativeWriteFileAtomically(String r8, byte[] r10);

    public static boolean writeFileAtomically(String r8, byte[] r10) {
        return nativeWriteFileAtomically(r8, r10);
    }
}
