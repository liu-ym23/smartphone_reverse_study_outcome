package org.apache.poi.ss.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.text.AttributedString;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: loaded from: classes7.dex */
public class SheetUtil {
    private static final FormulaEvaluator dummyEvaluator = null;
    private static final FontRenderContext fontRenderContext = null;
    private static final boolean ignoreMissingFontSystem = false;

    static {
        dummyEvaluator = new AnonymousClass1();
        fontRenderContext = new FontRenderContext(null, true, true);
        ignoreMissingFontSystem = Boolean.parseBoolean(System.getProperty("org.apache.poi.ss.ignoreMissingFontSystem"));
    }

    private static void copyAttributes(Font r2, AttributedString r3, int r4, int r5) {
        Font r6 = (Font) ZeusTransformUtils.wrapperContextForParams(r2, Font.class, "com.obric.memorydata.plugin");
        r3.addAttribute(TextAttribute.FAMILY, r6.getFontName(), r4, r5);
        r3.addAttribute(TextAttribute.SIZE, Float.valueOf(r6.getFontHeightInPoints()));
        if (r6.getBold() == false) goto L6;
        r3.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, r4, r5);
    L6:
        if (r6.getItalic() == false) goto L9;
        r3.addAttribute(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE, r4, r5);
    L9:
        if (r6.getUnderline() != 1) goto L12;
        r3.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, r4, r5);
        return;
    }

    private static double getCellWidth(int r7, int r8, CellStyle r9, double r10, AttributedString r12) {
        CellStyle r11 = (CellStyle) ZeusTransformUtils.wrapperContextForParams(r9, CellStyle.class, "com.obric.memorydata.plugin");
        TextLayout r0 = new TextLayout(r12.getIterator(), fontRenderContext);
        if (r11.getRotation() == 0) goto L5;
        AffineTransform r13 = new AffineTransform();
        r13.concatenate(AffineTransform.getRotateInstance(((((double) r11.getRotation()) * 2.0d) * 3.141592653589793d) / 360.0d));
        r13.concatenate(AffineTransform.getScaleInstance(1.0d, 2.0d));
        Rectangle r14 = r0.getOutline(r13).getBounds();
    L7:
        return Math.max(r10, (((r14.getX() + r14.getWidth()) / ((double) r8)) / ((double) r7)) + ((double) r11.getIndention()));
    L5:
        r14 = r0.getBounds();
        goto L7
    }

    public static double getCellWidth(Cell r2, int r3, DataFormatter r4, boolean r5) {
        Cell r6 = (Cell) ZeusTransformUtils.wrapperContextForParams(r2, Cell.class, "com.obric.memorydata.plugin");
        return getCellWidth(r6, r3, r4, r5, r6.getSheet().getMergedRegions());
    }

    public static double getCellWidth(Cell r14, int r15, DataFormatter r16, boolean r17, List<CellRangeAddress> r18) {
        Cell r0 = (Cell) ZeusTransformUtils.wrapperContextForParams(r14, Cell.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Workbook r3 = r0.getSheet().getWorkbook();
        Row r4 = r0.getRow();
        int r5 = r0.getColumnIndex();
        Iterator r6 = r2.iterator();
        int r13 = 1;
    L4:
        if (r6.hasNext() == false) goto L11;
        CellRangeAddress r7 = (CellRangeAddress) ZeusTransformUtils.preCheckCast(r6.next(), CellRangeAddress.class, "com.obric.memorydata.plugin");
        if (r7.isInRange(r4.getRowNum(), r5) == false) goto L4;
        if (r17 == false) goto L8;
        r0 = r4.getCell(r7.getFirstColumn());
        r13 = (r7.getLastColumn() + 1) - r7.getFirstColumn();
        goto L4
    L8:
        return -1.0d;
    L11:
        CellStyle r1 = r0.getCellStyle();
        CellType r8 = r0.getCellType();
        if (r8 != CellType.FORMULA) goto L14;
        r8 = r0.getCachedFormulaResultType();
    L14:
        Font r9 = r3.getFontAt(r1.getFontIndex());
        double r10 = -1.0d;
        if (r8 != CellType.STRING) goto L23;
        RichTextString r11 = r0.getRichStringCellValue();
        if (r11 != null) goto L19;
        return -1.0d;
    L19:
        if (r11.getString() == null) goto L44;
        String[] r12 = r11.getString().split("\\n");
        int r19 = r12.length;
        int r20 = 0;
    L21:
        if (r20 >= r19) goto L46;
        String r21 = r12[r20] + '0';
        AttributedString r110 = new AttributedString(r21);
        copyAttributes(r9, r110, 0, r21.length());
        r10 = getCellWidth(r15, r13, r1, r10, r110);
        r20 = r20 + 1;
        goto L21
    L46:
        return r10;
    L44:
        return -1.0d;
    L23:
        String r22 = null;
        if (r8 != CellType.NUMERIC) goto L29;
        r22 = r16.formatCellValue(r0, dummyEvaluator);     // Catch: Exception -> L27
    L31:
        if (r22 == null) goto L45;
        String r23 = r22 + '0';
        AttributedString r111 = new AttributedString(r23);
        copyAttributes(r9, r111, 0, r23.length());
        return getCellWidth(r15, r13, r1, -1.0d, r111);
    L45:
        return -1.0d;
    L27:
        r22 = String.valueOf(r0.getNumericCellValue());
        goto L31
    L29:
        if (r8 != CellType.BOOLEAN) goto L31;
        r22 = String.valueOf(r0.getBooleanCellValue()).toUpperCase(Locale.ROOT);
        goto L31
    }

    public static int getDefaultCharWidth(Workbook r3) {
        Font r4 = ((Workbook) ZeusTransformUtils.wrapperContextForParams(r3, Workbook.class, "com.obric.memorydata.plugin")).getFontAt(0);
        AttributedString r1 = new AttributedString(String.valueOf('0'));
        copyAttributes(r4, r1, 0, 1);
        return (int) new TextLayout(r1.getIterator(), fontRenderContext).getAdvance();
    L6:
        e = move-exception;
        if (ignoreMissingFontSystem == false) goto L11;
        return 5;
    L11:
        throw e;
    }
}
