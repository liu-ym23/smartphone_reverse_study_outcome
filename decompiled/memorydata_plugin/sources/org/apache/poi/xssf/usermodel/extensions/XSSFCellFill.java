package org.apache.poi.xssf.usermodel.extensions;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bw;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.di;

/* JADX INFO: loaded from: classes7.dex */
public final class XSSFCellFill {
    private bw _fill;
    private IndexedColorMap _indexedColorMap;

    public XSSFCellFill() {
        this._fill = (bw) ZeusTransformUtils.preCheckCast(bw.f19503a.newInstance(), bw.class, "com.obric.memorydata.plugin");
    }

    public XSSFCellFill(bw r3, IndexedColorMap r4) {
        bw r5 = (bw) ZeusTransformUtils.wrapperContextForParams(r3, bw.class, "com.obric.memorydata.plugin");
        IndexedColorMap r6 = (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r4, IndexedColorMap.class, "com.obric.memorydata.plugin");
        this._fill = r5;
        this._indexedColorMap = r6;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, XSSFCellFill.class) == true) goto L5;
        return false;
    L5:
        XSSFCellFill r5 = (XSSFCellFill) ZeusTransformUtils.preCheckCast(r4, XSSFCellFill.class, "com.obric.memorydata.plugin");
        if (Objects.equals(getFillBackgroundColor(), r5.getFillBackgroundColor()) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(getFillForegroundColor(), r5.getFillForegroundColor()) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(getPatternType(), r5.getPatternType()) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public bw getCTFill() {
        return this._fill;
    }

    public XSSFColor getFillBackgroundColor() {
        di r0 = this._fill.getPatternFill();
        if (r0 != null) goto L7;
        return null;
    L7:
        return XSSFColor.from(r0.getBgColor(), this._indexedColorMap);
    }

    public XSSFColor getFillForegroundColor() {
        di r0 = this._fill.getPatternFill();
        if (r0 != null) goto L7;
        return null;
    L7:
        return XSSFColor.from(r0.getFgColor(), this._indexedColorMap);
    }

    public STPatternType.Enum getPatternType() {
        di r0 = this._fill.getPatternFill();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getPatternType();
    }

    public int hashCode() {
        return this._fill.toString().hashCode();
    }
}
