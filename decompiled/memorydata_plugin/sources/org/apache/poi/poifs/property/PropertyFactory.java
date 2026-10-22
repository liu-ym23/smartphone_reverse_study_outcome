package org.apache.poi.poifs.property;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
final class PropertyFactory {
    static void convertToProperties(byte[] r5, List<Property> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.length / 128;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L15;
        byte r3 = r5[r2 + 66];
        if (r3 != 1) goto L7;
        Property r4 = new DirectoryProperty(r7.size(), r5, r2);
    L14:
        r7.add(r4);
        r2 = r2 + 128;
        r1 = r1 + 1;
        goto L3
    L7:
        if (r3 != 2) goto L9;
        r4 = new DocumentProperty(r7.size(), r5, r2);
        goto L14
    L9:
        if (r3 == 5) goto L11;
        r4 = null;
        goto L14
    L11:
        r4 = new RootProperty(r7.size(), r5, r2);
        goto L14
    }
}
