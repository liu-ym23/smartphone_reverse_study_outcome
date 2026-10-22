package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("net")
public class TTPatternUtil {
    public TTPatternUtil() {
    }

    public static boolean isPatternStringValid(String r0) {
        Pattern.compile(r0);     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }
}
