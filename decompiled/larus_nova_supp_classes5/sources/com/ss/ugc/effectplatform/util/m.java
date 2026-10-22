package com.ss.ugc.effectplatform.util;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Map r5, String r6) {
        StringBuilder r0 = new StringBuilder(r6);
        if ((!r5.isEmpty()) == false) goto L17;
        r0.append("?");
        Iterator r7 = r5.entrySet().iterator();
        int r8 = 0;
    L6:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r1 = (Map.Entry) r7.next();
        String r2 = (String) r1.getKey();
        String r3 = (String) r1.getValue();
        if (r.b(r2) == true) goto L15;
        if (r.b(r3) == true) goto L15;
        if (r8 != 0) goto L14;
        r0.append(r2);
        r0.append("=");
        r0.append(r3);
        goto L15
    L14:
        r0.append("&");
        r0.append(r2);
        r0.append("=");
        r0.append(r3);
    L15:
        r8 = r8 + 1;
    L17:
        return r0.toString();
    }
}
