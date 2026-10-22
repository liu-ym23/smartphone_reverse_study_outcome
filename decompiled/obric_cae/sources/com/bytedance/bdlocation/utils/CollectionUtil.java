package com.bytedance.bdlocation.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CollectionUtil {
    public CollectionUtil() {
    }

    public static boolean containsIgnoreCase(List<String> r8, String r10) {
        if (r8 != null) goto L5;
    L13:
        return false;
    L5:
        if (r8.size() < 1) goto L13;
        Iterator<String> r11 = r8.iterator();
    L9:
        if (r11.hasNext() == false) goto L13;
        if (r11.next().equalsIgnoreCase(r10) == false) goto L9;
        return true;
    }

    public static boolean isEmpty(Collection r8) {
        if (r8 != null) goto L4;
    L7:
        return true;
    L4:
        if (r8.isEmpty() == true) goto L7;
        return false;
    }
}
