package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
public class TTPatternUtil {
    public TTPatternUtil() {
    }

    @CalledByNative
    public static boolean isPatternStringValid(String r10) {
        Pattern.compile(r10);     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }
}
