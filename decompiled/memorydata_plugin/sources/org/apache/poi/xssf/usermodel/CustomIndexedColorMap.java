package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.List;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ae;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.dy;

/* JADX INFO: loaded from: classes7.dex */
public class CustomIndexedColorMap implements IndexedColorMap {
    private final byte[][] colorIndex;

    private CustomIndexedColorMap(byte[][] r1) {
        this.colorIndex = r1;
    }

    public static CustomIndexedColorMap fromColors(ae r5) {
        ae r6 = (ae) ZeusTransformUtils.wrapperContextForParams(r5, ae.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.isSetIndexedColors() == false) goto L16;
        List<dy> r7 = r6.getIndexedColors().getRgbColorList();
        int r2 = 0;
        byte[][] r0 = (byte[][]) Array.newInstance(byte.class, new int[]{r7.size(), 3});
    L9:
        if (r2 >= r7.size()) goto L12;
        r0[r2] = ((dy) ZeusTransformUtils.preCheckCast(r7.get(r2), dy.class, "com.obric.memorydata.plugin")).getRgb();
        r2 = r2 + 1;
        goto L9
    L12:
        return new CustomIndexedColorMap(r0);
    L16:
        return null;
    }

    @Override // org.apache.poi.xssf.usermodel.IndexedColorMap
    public byte[] getRGB(int r2) {
        byte[][] r1 = this.colorIndex;
        if (r1 == null) goto L10;
        if (r2 >= 0) goto L6;
        return null;
    L6:
        if (r2 < r1.length) goto L9;
        return null;
    L9:
        return r1[r2];
    L10:
        return null;
    }
}
