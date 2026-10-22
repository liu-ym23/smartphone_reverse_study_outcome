package org.apache.poi.xssf.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.aa;

/* JADX INFO: loaded from: classes7.dex */
public class CTColComparator {
    public static final Comparator<aa> BY_MAX = null;
    public static final Comparator<aa> BY_MIN_MAX = null;

    static {
        BY_MAX = $$Lambda$CTColComparator$nOnALHvOAiGpshlV8EN6gfX7oA.INSTANCE;
        BY_MIN_MAX = $$Lambda$CTColComparator$ANKGZWxfdaD6QROzB5nfumrZU.INSTANCE;
    }

    static /* synthetic */ int lambda$static$0(aa r2, aa r3) {
        aa r4 = (aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.memorydata.plugin");
        aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.memorydata.plugin");
        return Long.compare(r4.getMax(), r5.getMax());
    }

    static /* synthetic */ int lambda$static$1(aa r4, aa r5) {
        aa r6 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin");
        aa r7 = (aa) ZeusTransformUtils.wrapperContextForParams(r5, aa.class, "com.obric.memorydata.plugin");
        long r0 = r6.getMin();
        long r2 = r7.getMin();
        if (r0 >= r2) goto L5;
        return -1;
    L5:
        if (r0 <= r2) goto L8;
        return 1;
    L8:
        return BY_MAX.compare(r6, r7);
    }
}
