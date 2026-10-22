package com.bytedance.bdlocation.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CollectionUtil {
    public CollectionUtil() {
    }

    public static boolean containsIgnoreCase(List<String> r5, String r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L13:
        return false;
    L5:
        if (r7.size() < 1) goto L13;
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L13;
        if (((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin")).equalsIgnoreCase(r6) == false) goto L9;
        return true;
    }

    public static boolean isEmpty(Collection r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.isEmpty() == true) goto L8;
        return false;
    }
}
