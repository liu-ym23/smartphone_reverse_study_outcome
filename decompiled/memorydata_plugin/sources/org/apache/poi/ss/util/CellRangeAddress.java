package org.apache.poi.ss.util;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.ss.formula.SheetNameFormatter;

/* JADX INFO: loaded from: classes7.dex */
public class CellRangeAddress extends CellRangeAddressBase {
    public CellRangeAddress(int r3, int r4, int r5, int r6) {
        super(r3, r4, r5, r6);
        if (r4 < r3) goto L7;
        if (r6 < r5) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Invalid cell range, having lastRow < firstRow || lastCol < firstCol, had rows " + r4 + " >= " + r3 + " or cells " + r6 + " >= " + r5);
    }

    public CellRangeAddress(RecordInputStream r4) {
        super(readUShortAndCheck(r4), r4.readUShort(), r4.readUShort(), r4.readUShort());
    }

    public static int getEncodedSize(int r0) {
        return r0 * 8;
    }

    private static int readUShortAndCheck(RecordInputStream r2) {
        if (r2.remaining() < 8) goto L7;
        return r2.readUShort();
    L7:
        throw new IllegalArgumentException("Ran out of data reading CellRangeAddress");
    }

    public static CellRangeAddress valueOf(String r4) {
        int r0 = r4.indexOf(58);
        if (r0 != (-1)) goto L5;
        CellReference r1 = new CellReference(r4);
        CellReference r2 = r1;
    L7:
        return new CellRangeAddress(r1.getRow(), r2.getRow(), r1.getCol(), r2.getCol());
    L5:
        CellReference r3 = new CellReference(r4.substring(0, r0));
        r2 = new CellReference(r4.substring(r0 + 1));
        r1 = r3;
        goto L7
    }

    public String formatAsString() {
        return formatAsString(null, false);
    }

    public String formatAsString(String r5, boolean r6) {
        StringBuilder r0 = new StringBuilder();
        if (r5 == null) goto L5;
        r0.append(SheetNameFormatter.format(r5));
        r0.append('!');
    L5:
        CellReference r7 = new CellReference(getFirstRow(), getFirstColumn(), r6, r6);
        CellReference r1 = new CellReference(getLastRow(), getLastColumn(), r6, r6);
        r0.append(r7.formatAsString());
        if (r7.equals(r1) == true) goto L8;
    L11:
        r0.append(':');
        r0.append(r1.formatAsString());
    L13:
        return r0.toString();
    L8:
        if (isFullColumnRange() == true) goto L11;
        if (isFullRowRange() == false) goto L13;
        goto L11
    }
}
