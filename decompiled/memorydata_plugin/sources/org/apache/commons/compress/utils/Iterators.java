package org.apache.commons.compress.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class Iterators {
    public static <T> boolean addAll(Collection<T> r2, Iterator<? extends T> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4);
        Objects.requireNonNull(r5);
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 | r4.add(r5.next());
        goto L4
    L6:
        return r0;
    }
}
