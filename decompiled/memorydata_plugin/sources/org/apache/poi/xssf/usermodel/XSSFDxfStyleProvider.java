package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.BorderFormatting;
import org.apache.poi.ss.usermodel.DifferentialStyleProvider;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bc;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cv;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFDxfStyleProvider implements DifferentialStyleProvider {
    private final BorderFormatting border;
    private final IndexedColorMap colorMap;
    private final PatternFormatting fill;
    private final FontFormatting font;
    private final ExcelNumberFormat number;
    private final int stripeSize;

    public XSSFDxfStyleProvider(bc r5, int r6, IndexedColorMap r7) {
        bc r8 = (bc) ZeusTransformUtils.wrapperContextForParams(r5, bc.class, "com.obric.memorydata.plugin");
        IndexedColorMap r9 = (IndexedColorMap) ZeusTransformUtils.wrapperContextForParams(r7, IndexedColorMap.class, "com.obric.memorydata.plugin");
        this.stripeSize = r6;
        this.colorMap = r9;
        XSSFPatternFormatting r10 = null;
        if (r8 != null) goto L7;
        this.border = null;
        this.font = null;
        this.number = null;
    L5:
        this.fill = r10;
        return;
    L7:
        if (r8.isSetBorder() == false) goto L9;
        XSSFBorderFormatting r0 = new XSSFBorderFormatting(r8.getBorder(), r9);
    L10:
        this.border = r0;
        if (r8.isSetFont() == false) goto L13;
        XSSFFontFormatting r1 = new XSSFFontFormatting(r8.getFont(), r9);
    L14:
        this.font = r1;
        if (r8.isSetNumFmt() == false) goto L17;
        cv r2 = r8.getNumFmt();
        this.number = new ExcelNumberFormat((int) r2.getNumFmtId(), r2.getFormatCode());
    L19:
        if (r8.isSetFill() == false) goto L5;
        r10 = new XSSFPatternFormatting(r8.getFill(), r9);
        goto L5
    L17:
        this.number = null;
        goto L19
    L13:
        r1 = null;
        goto L14
    L9:
        r0 = null;
        goto L10
    }

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public int getStripeSize() {
        return this.stripeSize;
    }
}
