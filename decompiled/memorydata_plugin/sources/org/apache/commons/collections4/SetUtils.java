package org.apache.commons.collections4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.collections4.set.UnmodifiableSortedSet;

/* JADX INFO: loaded from: classes6.dex */
public class SetUtils {
    public static final SortedSet EMPTY_SORTED_SET = null;

    static {
        EMPTY_SORTED_SET = UnmodifiableSortedSet.unmodifiableSortedSet(new TreeSet());
    }

    public static <T> Set<T> emptyIfNull(Set<T> r2) {
        Set<T> r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L5;
        return r3;
    L5:
        return Collections.emptySet();
    }

    public static <T> int hashCodeForSet(Collection<T> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r3 != null) goto L5;
        return 0;
    L5:
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        Object r1 = r4.next();
        if (r1 == null) goto L7;
        r0 = r0 + r1.hashCode();
        goto L7
    L11:
        return r0;
    }

    public static boolean isEqualSet(Collection<?> r2, Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (r4 != r5) goto L6;
        return true;
    L6:
        if (r4 == null) goto L13;
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r4.size() == r5.size()) goto L12;
        return false;
    L12:
        return r4.containsAll(r5);
    L13:
        return false;
    }
}
