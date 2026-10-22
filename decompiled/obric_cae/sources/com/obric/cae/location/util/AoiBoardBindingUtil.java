package com.obric.cae.location.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class AoiBoardBindingUtil {
    private static final String POI_ID_SEPARATOR = ";";

    private AoiBoardBindingUtil() {
    }

    public static boolean containsPoiId(String r8, String r10) {
        if (r10 != null) goto L4;
        return false;
    L4:
        if (r10.trim().isEmpty() == false) goto L7;
        return false;
    L7:
        return parsePoiIds(r8).contains(r10.trim());
    }

    public static String joinPoiIds(Collection<String> r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.isEmpty() == true) goto L36;
        StringBuilder r10 = new StringBuilder();
        LinkedHashSet r11 = new LinkedHashSet();
        Iterator<String> r12 = r8.iterator();
    L8:
        if (r12.hasNext() == false) goto L15;
        String r13 = r12.next();
        if (r13 == null) goto L8;
        String r14 = r13.trim();
        if (r14.isEmpty() == true) goto L8;
        r11.add(r14);
        goto L8
    L15:
        Iterator r15 = r11.iterator();
    L17:
        if (r15.hasNext() == false) goto L23;
        String r16 = (String) r15.next();
        if (r10.length() <= 0) goto L21;
        r10.append(POI_ID_SEPARATOR);
    L21:
        r10.append(r16);
        goto L17
    L23:
        return r10.toString();
    L36:
        return "";
    }

    public static Set<String> parsePoiIds(String r8) {
        LinkedHashSet r10 = new LinkedHashSet();
        if (r8 != null) goto L5;
    L16:
        return r10;
    L5:
        if (r8.trim().isEmpty() == true) goto L16;
        String[] r11 = r8.split(POI_ID_SEPARATOR);
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L16;
        String r14 = r11[r13];
        if (r14 == null) goto L15;
        String r15 = r14.trim();
        if (r15.isEmpty() == true) goto L15;
        r10.add(r15);
    L15:
        r13 = r13 + 1;
        goto L8
    }
}
