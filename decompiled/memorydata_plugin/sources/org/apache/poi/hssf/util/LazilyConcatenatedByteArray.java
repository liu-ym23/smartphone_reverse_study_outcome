package org.apache.poi.hssf.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class LazilyConcatenatedByteArray {
    private final List<byte[]> arrays;

    public LazilyConcatenatedByteArray() {
        this.arrays = new ArrayList(1);
    }

    public void concatenate(byte[] r1) {
        if (r1 == null) goto L6;
        this.arrays.add(r1);
        return;
    L6:
        throw new IllegalArgumentException("array cannot be null");
    }

    public byte[] toArray() {
        if (this.arrays.isEmpty() == false) goto L7;
        return null;
    L7:
        if (this.arrays.size() <= 1) goto L18;
        Iterator<byte[]> r1 = this.arrays.iterator();
        int r2 = 0;
    L10:
        if (r1.hasNext() == false) goto L12;
        r2 = r2 + ((byte[]) ZeusTransformUtils.preCheckCast(r1.next(), byte[].class, "com.obric.memorydata.plugin")).length;
        goto L10
    L12:
        byte[] r3 = new byte[r2];
        Iterator<byte[]> r4 = this.arrays.iterator();
        int r5 = 0;
    L14:
        if (r4.hasNext() == false) goto L16;
        byte[] r6 = (byte[]) ZeusTransformUtils.preCheckCast(r4.next(), byte[].class, "com.obric.memorydata.plugin");
        System.arraycopy(r6, 0, r3, r5, r6.length);
        r5 = r5 + r6.length;
        goto L14
    L16:
        this.arrays.clear();
        this.arrays.add(r3);
    L18:
        return (byte[]) ZeusTransformUtils.preCheckCast(this.arrays.get(0), byte[].class, "com.obric.memorydata.plugin");
    }
}
