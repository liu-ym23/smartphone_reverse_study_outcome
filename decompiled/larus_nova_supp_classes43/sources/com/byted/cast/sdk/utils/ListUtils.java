package com.byted.cast.sdk.utils;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ListUtils {

    public interface Filter<T> {
        boolean keepItem(T r1);
    }

    public ListUtils() {
    }

    public static <T> List<T> filter(List<T> r10, Filter<T> r11) {
        Iterator<T> r0 = r10.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r11.keepItem(r0.next()) == true) goto L4;
        r0.remove();
        goto L4
    L8:
        return r10;
    }
}
