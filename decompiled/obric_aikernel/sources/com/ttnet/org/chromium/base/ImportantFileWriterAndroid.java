package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class ImportantFileWriterAndroid {

    interface Natives {
        boolean writeFileAtomically(String r10, byte[] r11);
    }

    public ImportantFileWriterAndroid() {
    }

    public static boolean writeFileAtomically(String r10, byte[] r11) {
        return ImportantFileWriterAndroidJni.get().writeFileAtomically(r10, r11);
    }
}
