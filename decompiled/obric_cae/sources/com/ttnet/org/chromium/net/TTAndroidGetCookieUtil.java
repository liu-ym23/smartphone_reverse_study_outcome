package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
public class TTAndroidGetCookieUtil {
    public TTAndroidGetCookieUtil() {
    }

    @CalledByNative
    public static String getCookieHeader(String r8) {
        HashMap r10 = new HashMap();
        StringBuilder r11 = new StringBuilder();
        CookieHandler r12 = CookieHandler.getDefault();     // Catch: Exception -> L27
        if (r12 == null) goto L7;
        Map<String, List<String>> r13 = r12.get(new URI(r8), r10);     // Catch: Exception -> L27
    L8:
        if (r13 == null) goto L26;
        if (r13.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r14 = r13.entrySet().iterator();
    L13:
        if (r14.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r15 = r14.next();
        if ("Cookie".equalsIgnoreCase(r15.getKey()) == false) goto L13;
        if (r15.getValue().isEmpty() == true) goto L13;
        Iterator<String> r16 = r15.getValue().iterator();
        int r17 = 0;
    L20:
        if (r16.hasNext() == false) goto L13;
        String r18 = r16.next();
        if (r17 <= 0) goto L24;
        r11.append("; ");
    L24:
        r11.append(r18);
        r17 = r17 + 1;
    L26:
        return r11.toString();
    L7:
        r13 = null;
    L28:
        return r11.toString();
    }
}
