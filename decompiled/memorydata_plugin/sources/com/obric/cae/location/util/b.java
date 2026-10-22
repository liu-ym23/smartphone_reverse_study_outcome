package com.obric.cae.location.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static String a(Collection<String> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return "";
    L5:
        if (r6.isEmpty() == true) goto L37;
        StringBuilder r0 = new StringBuilder();
        LinkedHashSet r2 = new LinkedHashSet();
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L16;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        String r4 = r3.trim();
        if (r4.isEmpty() == true) goto L9;
        r2.add(r4);
        goto L9
    L16:
        Iterator r8 = r2.iterator();
    L18:
        if (r8.hasNext() == false) goto L24;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r0.length() <= 0) goto L22;
        r0.append(";");
    L22:
        r0.append(r9);
        goto L18
    L24:
        return r0.toString();
    L37:
        return "";
    }

    public static Set<String> a(String r5) {
        LinkedHashSet r0 = new LinkedHashSet();
        if (r5 != null) goto L5;
    L16:
        return r0;
    L5:
        if (r5.trim().isEmpty() == true) goto L16;
        String[] r6 = r5.split(";");
        int r1 = r6.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L16;
        String r3 = r6[r2];
        if (r3 == null) goto L15;
        String r4 = r3.trim();
        if (r4.isEmpty() == true) goto L15;
        r0.add(r4);
    L15:
        r2 = r2 + 1;
        goto L8
    }

    public static boolean a(String r1, String r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (r2.trim().isEmpty() == false) goto L7;
        return false;
    L7:
        return a(r1).contains(r2.trim());
    }
}
