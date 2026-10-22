package org.apache.poi.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class BitFieldFactory {
    private static Map<Integer, BitField> instances;

    static {
        instances = new HashMap();
    }

    public static BitField getInstance(int r3) {
        BitField r0 = (BitField) ZeusTransformUtils.preCheckCast(instances.get(Integer.valueOf(r3)), BitField.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        BitField r1 = new BitField(r3);
        instances.put(Integer.valueOf(r3), r1);
        return r1;
    L6:
        return r0;
    }
}
