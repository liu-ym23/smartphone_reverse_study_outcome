package org.apache.commons.collections4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: loaded from: classes6.dex */
public class ListUtils {
    public static <T> List<T> emptyIfNull(List<T> r2) {
        List<T> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L5;
        return r3;
    L5:
        return Collections.emptyList();
    }

    public static int hashCodeForList(Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return 0;
    L5:
        int r1 = 1;
        Iterator r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        Object r2 = r5.next();
        int r6 = r1 * 31;
        if (r2 != null) goto L11;
        int r7 = 0;
    L12:
        r1 = r6 + r7;
        goto L7
    L11:
        r7 = r2.hashCode();
        goto L12
    L13:
        return r1;
    }

    public static boolean isEqualList(Collection<?> r4, Collection<?> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        if (r6 != r7) goto L6;
        return true;
    L6:
        if (r6 == null) goto L30;
        if (r7 == null) goto L30;
        if (r6.size() != r7.size()) goto L30;
        Iterator r8 = r6.iterator();
        Iterator r9 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L24;
        if (r9.hasNext() == false) goto L24;
        Object r2 = r8.next();
        Object r3 = r9.next();
        if (r2 == null) goto L18;
        if (r2.equals(r3) == true) goto L13;
    L22:
        return false;
    L18:
        if (r3 != null) goto L22;
    L24:
        if (r8.hasNext() == true) goto L29;
        if (r9.hasNext() == true) goto L29;
        return true;
    L29:
        return false;
    L30:
        return false;
    }

    public static <E> List<E> unmodifiableList(List<? extends E> r2) {
        return UnmodifiableList.unmodifiableList((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
    }
}
