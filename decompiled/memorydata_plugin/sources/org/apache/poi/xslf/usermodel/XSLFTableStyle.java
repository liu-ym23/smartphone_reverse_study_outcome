package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.openxmlformats.schemas.drawingml.x2006.main.cz;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFTableStyle {
    private cz _tblStyle;

    public static final enum TablePartStyle extends Enum<TablePartStyle> {
        private static final /* synthetic */ TablePartStyle[] $VALUES = null;
        public static final TablePartStyle band1H = null;
        public static final TablePartStyle band1V = null;
        public static final TablePartStyle band2H = null;
        public static final TablePartStyle band2V = null;
        public static final TablePartStyle firstCol = null;
        public static final TablePartStyle firstRow = null;
        public static final TablePartStyle lastCol = null;
        public static final TablePartStyle lastRow = null;
        public static final TablePartStyle neCell = null;
        public static final TablePartStyle nwCell = null;
        public static final TablePartStyle seCell = null;
        public static final TablePartStyle swCell = null;
        public static final TablePartStyle wholeTbl = null;

        static {
            TablePartStyle r0 = new TablePartStyle("wholeTbl", 0);
            wholeTbl = r0;
            TablePartStyle r1 = new TablePartStyle("band1H", 1);
            band1H = r1;
            TablePartStyle r3 = new TablePartStyle("band2H", 2);
            band2H = r3;
            TablePartStyle r5 = new TablePartStyle("band1V", 3);
            band1V = r5;
            TablePartStyle r7 = new TablePartStyle("band2V", 4);
            band2V = r7;
            TablePartStyle r9 = new TablePartStyle("firstCol", 5);
            firstCol = r9;
            TablePartStyle r11 = new TablePartStyle("lastCol", 6);
            lastCol = r11;
            TablePartStyle r13 = new TablePartStyle("firstRow", 7);
            firstRow = r13;
            TablePartStyle r15 = new TablePartStyle("lastRow", 8);
            lastRow = r15;
            TablePartStyle r14 = new TablePartStyle("seCell", 9);
            seCell = r14;
            TablePartStyle r12 = new TablePartStyle("swCell", 10);
            swCell = r12;
            TablePartStyle r10 = new TablePartStyle("neCell", 11);
            neCell = r10;
            TablePartStyle r8 = new TablePartStyle("nwCell", 12);
            nwCell = r8;
            $VALUES = new TablePartStyle[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        }

        private TablePartStyle(String r1, int r2) {
            super(r1, r2);
        }

        public static TablePartStyle valueOf(String r2) {
            return (TablePartStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(TablePartStyle.class, r2), TablePartStyle.class, "com.obric.memorydata.plugin");
        }

        public static TablePartStyle[] values() {
            return (TablePartStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TablePartStyle[].class, "com.obric.memorydata.plugin");
        }
    }

    XSLFTableStyle(cz r3) {
        this._tblStyle = (cz) ZeusTransformUtils.wrapperContextForParams(r3, cz.class, "com.obric.memorydata.plugin");
    }
}
