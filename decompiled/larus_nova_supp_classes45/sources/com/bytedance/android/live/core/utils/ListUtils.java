package com.bytedance.android.live.core.utils;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ListUtils {
    public ListUtils() {
    }

    public static boolean isEmpty(List<?> r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.size() == 0) goto L7;
        return false;
    }

    public static <T> boolean notEmpty(Collection<T> r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.size() <= 0) goto L6;
        return true;
    }
}
