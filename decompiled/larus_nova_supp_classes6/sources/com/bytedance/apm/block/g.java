package com.bytedance.apm.block;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class g {
    public static final HashSet<String> a = null;
    public static String b;
    public static boolean c;

    static {
        a = new HashSet();
        b = "";
        c = true;
    }

    public static String a() {
        if (c == false) goto L18;
        HashSet<String> r0 = a;     // Catch: ConcurrentModificationException -> L19
        if (r0 != null) goto L7;
        String r1 = null;
    L16:
        b = r1;     // Catch: ConcurrentModificationException -> L19
        c = false;     // Catch: ConcurrentModificationException -> L19
        goto L18
    L7:
        StringBuilder r3 = new StringBuilder();     // Catch: ConcurrentModificationException -> L19
        Iterator<String> r2 = r0.iterator();     // Catch: ConcurrentModificationException -> L19
        boolean r4 = true;
    L9:
        if (r2.hasNext() == false) goto L15;
        String r5 = r2.next();     // Catch: ConcurrentModificationException -> L19
        if (r4 == false) goto L13;
        r4 = false;
    L14:
        r3.append(r5.toString());     // Catch: ConcurrentModificationException -> L19
        goto L9
    L13:
        r3.append(",");     // Catch: ConcurrentModificationException -> L19
        goto L14
    L15:
        r1 = r3.toString();     // Catch: ConcurrentModificationException -> L19
    L18:
        return b;
    }
}
