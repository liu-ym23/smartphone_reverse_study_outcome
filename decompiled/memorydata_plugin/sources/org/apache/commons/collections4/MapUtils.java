package org.apache.commons.collections4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.map.UnmodifiableSortedMap;

/* JADX INFO: loaded from: classes6.dex */
public class MapUtils {
    public static final SortedMap EMPTY_SORTED_MAP = null;

    static {
        EMPTY_SORTED_MAP = UnmodifiableSortedMap.unmodifiableSortedMap(new TreeMap());
    }

    public static boolean isEmpty(Map<?, ?> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.isEmpty() == true) goto L8;
        return false;
    }

    public static boolean isNotEmpty(Map<?, ?> r2) {
        return !isEmpty((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"));
    }
}
