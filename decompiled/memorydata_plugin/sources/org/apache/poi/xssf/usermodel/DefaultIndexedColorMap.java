package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.util.HSSFColor;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultIndexedColorMap implements IndexedColorMap {
    public DefaultIndexedColorMap() {
    }

    public static byte[] getDefaultRGB(int r3) {
        HSSFColor r4 = (HSSFColor) ZeusTransformUtils.preCheckCast(HSSFColor.getIndexHash().get(Integer.valueOf(r3)), HSSFColor.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return null;
    L6:
        short[] r5 = r4.getTriplet();
        return new byte[]{(byte) r5[0], (byte) r5[1], (byte) r5[2]};
    }

    @Override // org.apache.poi.xssf.usermodel.IndexedColorMap
    public byte[] getRGB(int r1) {
        return getDefaultRGB(r1);
    }
}
