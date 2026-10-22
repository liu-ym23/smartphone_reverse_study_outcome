package com.ttnet.org.chromium.url;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.IDN;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("url::android")
public class IDNStringUtil {
    public IDNStringUtil() {
    }

    @CalledByNative
    private static String idnToASCII(String r8) {
        return IDN.toASCII(r8, 2);
    L5:
        return null;
    }
}
