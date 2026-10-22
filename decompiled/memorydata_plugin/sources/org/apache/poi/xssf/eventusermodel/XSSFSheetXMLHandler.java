package org.apache.poi.xssf.eventusermodel;

import com.bytedance.apm.util.f;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.model.Comments;
import org.apache.poi.xssf.model.SharedStrings;
import org.apache.poi.xssf.model.Styles;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFSheetXMLHandler extends DefaultHandler {
    private static final c LOG = null;
    private String cellRef;
    private Queue<CellAddress> commentCellRefs;
    private final Comments comments;
    private boolean fIsOpen;
    private short formatIndex;
    private String formatString;
    private final DataFormatter formatter;
    private final StringBuilder formula;
    private final boolean formulasNotResults;
    private final StringBuilder headerFooter;
    private boolean hfIsOpen;
    private boolean isIsOpen;
    private xssfDataType nextDataType;
    private int nextRowNum;
    private final SheetContentsHandler output;
    private int rowNum;
    private final SharedStrings sharedStringsTable;
    private final Styles stylesTable;
    private boolean vIsOpen;
    private final StringBuilder value;

    /* JADX INFO: renamed from: org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType = null;

        static {
            int[] r0 = new int[xssfDataType.values().length];
            $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType = r0;
            r0[xssfDataType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.FORMULA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.INLINE_STRING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.SST_STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[xssfDataType.NUMBER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    private static final enum EmptyCellCommentsCheckType extends Enum<EmptyCellCommentsCheckType> {
        private static final /* synthetic */ EmptyCellCommentsCheckType[] $VALUES = null;
        public static final EmptyCellCommentsCheckType CELL = null;
        public static final EmptyCellCommentsCheckType END_OF_ROW = null;
        public static final EmptyCellCommentsCheckType END_OF_SHEET_DATA = null;

        static {
            EmptyCellCommentsCheckType r0 = new EmptyCellCommentsCheckType("CELL", 0);
            CELL = r0;
            EmptyCellCommentsCheckType r1 = new EmptyCellCommentsCheckType("END_OF_ROW", 1);
            END_OF_ROW = r1;
            EmptyCellCommentsCheckType r3 = new EmptyCellCommentsCheckType("END_OF_SHEET_DATA", 2);
            END_OF_SHEET_DATA = r3;
            $VALUES = new EmptyCellCommentsCheckType[]{r0, r1, r3};
        }

        private EmptyCellCommentsCheckType(String r1, int r2) {
            super(r1, r2);
        }

        public static EmptyCellCommentsCheckType valueOf(String r2) {
            return (EmptyCellCommentsCheckType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmptyCellCommentsCheckType.class, r2), EmptyCellCommentsCheckType.class, "com.obric.memorydata.plugin");
        }

        public static EmptyCellCommentsCheckType[] values() {
            return (EmptyCellCommentsCheckType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmptyCellCommentsCheckType[].class, "com.obric.memorydata.plugin");
        }
    }

    public interface SheetContentsHandler {
        void cell(String r1, String r2, XSSFComment r3);

        void endRow(int r1);

        default void endSheet() {
        }

        default void headerFooter(String r1, boolean r2, String r3) {
        }

        void startRow(int r1);
    }

    static final enum xssfDataType extends Enum<xssfDataType> {
        private static final /* synthetic */ xssfDataType[] $VALUES = null;
        public static final xssfDataType BOOLEAN = null;
        public static final xssfDataType ERROR = null;
        public static final xssfDataType FORMULA = null;
        public static final xssfDataType INLINE_STRING = null;
        public static final xssfDataType NUMBER = null;
        public static final xssfDataType SST_STRING = null;

        static {
            xssfDataType r0 = new xssfDataType("BOOLEAN", 0);
            BOOLEAN = r0;
            xssfDataType r1 = new xssfDataType(CipherConst.LEVEL_ERROR, 1);
            ERROR = r1;
            xssfDataType r3 = new xssfDataType("FORMULA", 2);
            FORMULA = r3;
            xssfDataType r5 = new xssfDataType("INLINE_STRING", 3);
            INLINE_STRING = r5;
            xssfDataType r7 = new xssfDataType("SST_STRING", 4);
            SST_STRING = r7;
            xssfDataType r9 = new xssfDataType("NUMBER", 5);
            NUMBER = r9;
            $VALUES = new xssfDataType[]{r0, r1, r3, r5, r7, r9};
        }

        private xssfDataType(String r1, int r2) {
            super(r1, r2);
        }

        public static xssfDataType valueOf(String r2) {
            return (xssfDataType) ZeusTransformUtils.preCheckCast(Enum.valueOf(xssfDataType.class, r2), xssfDataType.class, "com.obric.memorydata.plugin");
        }

        public static xssfDataType[] values() {
            return (xssfDataType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), xssfDataType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        LOG = b.a(XSSFSheetXMLHandler.class);
    }

    private void checkForEmptyCellComments(EmptyCellCommentsCheckType r6) {
        Queue<CellAddress> r0 = this.commentCellRefs;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return;
    L7:
        if (r6 != EmptyCellCommentsCheckType.END_OF_SHEET_DATA) goto L13;
    L9:
        if (this.commentCellRefs.isEmpty() == true) goto L11;
        outputEmptyCellComment((CellAddress) ZeusTransformUtils.preCheckCast(this.commentCellRefs.remove(), CellAddress.class, "com.obric.memorydata.plugin"));
        goto L9
    L11:
        return;
    L13:
        if (this.cellRef == null) goto L15;
    L24:
        CellAddress r1 = new CellAddress(this.cellRef);
        CellAddress r2 = (CellAddress) ZeusTransformUtils.preCheckCast(this.commentCellRefs.peek(), CellAddress.class, "com.obric.memorydata.plugin");
        if (r6 == EmptyCellCommentsCheckType.CELL) goto L27;
    L30:
        int r3 = r2.compareTo2(r1);
        if (r3 > 0) goto L33;
    L37:
        if (r3 < 0) goto L39;
    L43:
        CellAddress r4 = null;
    L44:
        if (r4 == null) goto L57;
        if (this.commentCellRefs.isEmpty() == false) goto L24;
        return;
    L57:
        return;
    L39:
        if (r6 != EmptyCellCommentsCheckType.CELL) goto L43;
        if (r2.getRow() > this.rowNum) goto L43;
    L36:
        r4 = (CellAddress) ZeusTransformUtils.preCheckCast(this.commentCellRefs.remove(), CellAddress.class, "com.obric.memorydata.plugin");
        outputEmptyCellComment(r4);
        goto L44
    L33:
        if (r6 != EmptyCellCommentsCheckType.END_OF_ROW) goto L37;
        if (r2.getRow() > this.rowNum) goto L37;
    L27:
        if (r1.equals(r2) == false) goto L30;
        this.commentCellRefs.remove();
        return;
    L15:
        if (r6 != EmptyCellCommentsCheckType.END_OF_ROW) goto L23;
    L17:
        if (this.commentCellRefs.isEmpty() == true) goto L21;
        if (((CellAddress) ZeusTransformUtils.preCheckCast(this.commentCellRefs.peek(), CellAddress.class, "com.obric.memorydata.plugin")).getRow() != this.rowNum) goto L55;
        outputEmptyCellComment((CellAddress) ZeusTransformUtils.preCheckCast(this.commentCellRefs.remove(), CellAddress.class, "com.obric.memorydata.plugin"));
        goto L17
    L55:
        return;
    L21:
        return;
    L23:
        throw new IllegalStateException("Cell ref should be null only if there are only empty cells in the row; rowNum: " + this.rowNum);
    }

    private boolean isTextTag(String r3) {
        if (BaseSwitches.V.equals(r3) == false) goto L6;
        return true;
    L6:
        if ("inlineStr".equals(r3) == false) goto L9;
        return true;
    L9:
        if ("t".equals(r3) == true) goto L11;
        return false;
    L11:
        if (this.isIsOpen == false) goto L15;
        return true;
    L15:
        return false;
    }

    private void outputCell() {
        XSSFComment r1 = null;
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$xssf$eventusermodel$XSSFSheetXMLHandler$xssfDataType[this.nextDataType.ordinal()]) {
            case 1: goto L28;
            case 2: goto L25;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L10;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        StringBuilder r0 = new StringBuilder().append("(TODO: Unexpected type: ").append(this.nextDataType).append(")");
    L26:
        String r2 = r0.toString();
    L31:
        checkForEmptyCellComments(EmptyCellCommentsCheckType.CELL);
        Comments r3 = this.comments;
        if (r3 == null) goto L34;
        r1 = r3.findCellComment(new CellAddress(this.cellRef));
    L34:
        this.output.cell(this.cellRef, r2, r1);
        return;
    L5:
        r2 = this.value.toString();
        if (this.formatString == null) goto L31;
        if (r2.length() <= 0) goto L31;
        r2 = this.formatter.formatRawCellContents(Double.parseDouble(r2), this.formatIndex, this.formatString);
        goto L31
    L10:
        String r4 = this.value.toString();
        if (r4.length() > 0) goto L37;
    L16:
        r2 = null;
        goto L31
    L37:
        r2 = this.sharedStringsTable.getItemAt(Integer.parseInt(r4)).toString();     // Catch: NumberFormatException -> L14
    L14:
        e = move-exception;
        LOG.atError().a(e).a("Failed to parse SST index '{}'", r4);
        goto L16
    L17:
        r2 = new XSSFRichTextString(this.value.toString()).toString();
        goto L31
    L25:
        r0 = new StringBuilder().append("ERROR:").append(this.value);
        goto L26
    L19:
        if (this.formulasNotResults == false) goto L21;
        r0 = this.formula;
        goto L26
    L21:
        r2 = this.value.toString();
        if (this.formatString == null) goto L31;
        r2 = this.formatter.formatRawCellContents(Double.parseDouble(r2), this.formatIndex, this.formatString);     // Catch: NumberFormatException -> L36
        goto L31
    L28:
        if (this.value.charAt(0) != '0') goto L30;
        r2 = "FALSE";
        goto L31
    L30:
        r2 = "TRUE";
        goto L31
    }

    private void outputEmptyCellComment(CellAddress r3) {
        XSSFComment r0 = this.comments.findCellComment(r3);
        this.output.cell(r3.formatAsString(), null, r0);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] r2, int r3, int r4) {
        if (this.vIsOpen == false) goto L6;
        this.value.append(r2, r3, r4);
    L6:
        if (this.fIsOpen == false) goto L9;
        this.formula.append(r2, r3, r4);
    L9:
        if (this.hfIsOpen == false) goto L12;
        this.headerFooter.append(r2, r3, r4);
        return;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String r2, String r3, String r4) {
        if (r2 == null) goto L7;
        if (r2.equals("http://schemas.openxmlformats.org/spreadsheetml/2006/main") == true) goto L7;
        return;
    L7:
        if (isTextTag(r3) == false) goto L12;
        this.vIsOpen = false;
        if (this.isIsOpen == true) goto L39;
    L10:
        outputCell();
        this.value.setLength(0);
        return;
    L39:
        return;
    L12:
        if (f.f1488a.equals(r3) == false) goto L15;
        this.fIsOpen = false;
        return;
    L15:
        if ("is".equals(r3) == false) goto L18;
        this.isIsOpen = false;
        goto L10
    L18:
        if ("row".equals(r3) == false) goto L21;
        checkForEmptyCellComments(EmptyCellCommentsCheckType.END_OF_ROW);
        this.output.endRow(this.rowNum);
        this.nextRowNum = this.rowNum + 1;
        return;
    L21:
        if ("sheetData".equals(r3) == false) goto L24;
        checkForEmptyCellComments(EmptyCellCommentsCheckType.END_OF_SHEET_DATA);
        this.output.endSheet();
        return;
    L24:
        if ("oddHeader".equals(r3) == false) goto L26;
    L37:
        this.hfIsOpen = false;
        this.output.headerFooter(this.headerFooter.toString(), true, r3);
        return;
    L26:
        if ("evenHeader".equals(r3) == true) goto L37;
        if ("firstHeader".equals(r3) == true) goto L37;
        if ("oddFooter".equals(r3) == false) goto L33;
    L36:
        this.hfIsOpen = false;
        this.output.headerFooter(this.headerFooter.toString(), false, r3);
        return;
    L33:
        if ("evenFooter".equals(r3) == true) goto L36;
        if ("firstFooter".equals(r3) == true) goto L36;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String r4, String r5, String r6, Attributes r7) {
        Attributes r8 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r7, Attributes.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L8;
        if (r4.equals("http://schemas.openxmlformats.org/spreadsheetml/2006/main") == true) goto L8;
        return;
    L8:
        if (isTextTag(r5) == false) goto L14;
        this.vIsOpen = true;
        if (this.isIsOpen == true) goto L81;
        StringBuilder r3 = this.value;
    L12:
        r3.setLength(0);
        return;
    L81:
        return;
    L14:
        if ("is".equals(r5) == false) goto L17;
        this.isIsOpen = true;
        return;
    L17:
        if (f.f1488a.equals(r5) == false) goto L32;
        this.formula.setLength(0);
        if (this.nextDataType != xssfDataType.NUMBER) goto L21;
        this.nextDataType = xssfDataType.FORMULA;
    L21:
        String r9 = r8.getValue("t");
        if (r9 != null) goto L24;
    L27:
        this.fIsOpen = true;
        return;
    L24:
        if (r9.equals("shared") == false) goto L27;
        String r10 = r8.getValue("ref");
        r8.getValue("si");
        if (r10 != null) goto L27;
        if (this.formulasNotResults == false) goto L85;
        LOG.atWarn().a("shared formulas not yet supported!");
        return;
    L85:
        return;
    L32:
        if ("oddHeader".equals(r5) == false) goto L34;
    L80:
        this.hfIsOpen = true;
        r3 = this.headerFooter;
        goto L12
    L34:
        if ("evenHeader".equals(r5) == true) goto L80;
        if ("firstHeader".equals(r5) == true) goto L80;
        if ("firstFooter".equals(r5) == true) goto L80;
        if ("oddFooter".equals(r5) == true) goto L80;
        if ("evenFooter".equals(r5) == true) goto L80;
        if ("row".equals(r5) == false) goto L52;
        String r11 = r8.getValue("r");
        if (r11 == null) goto L49;
        int r12 = Integer.parseInt(r11) - 1;
    L50:
        this.rowNum = r12;
        this.output.startRow(this.rowNum);
        return;
    L49:
        r12 = this.nextRowNum;
        goto L50
    L52:
        if ("c".equals(r5) == false) goto L88;
        this.nextDataType = xssfDataType.NUMBER;
        this.formatIndex = -1;
        XSSFCellStyle r13 = null;
        this.formatString = null;
        this.cellRef = r8.getValue("r");
        String r14 = r8.getValue("t");
        String r15 = r8.getValue("s");
        if ("b".equals(r14) == false) goto L58;
        xssfDataType r16 = xssfDataType.BOOLEAN;
    L56:
        this.nextDataType = r16;
        return;
    L58:
        if ("e".equals(r14) == false) goto L61;
        r16 = xssfDataType.ERROR;
        goto L56
    L61:
        if ("inlineStr".equals(r14) == false) goto L64;
        r16 = xssfDataType.INLINE_STRING;
        goto L56
    L64:
        if ("s".equals(r14) == false) goto L67;
        r16 = xssfDataType.SST_STRING;
        goto L56
    L67:
        if ("str".equals(r14) == false) goto L69;
        r16 = xssfDataType.FORMULA;
        goto L56
    L69:
        Styles r17 = this.stylesTable;
        if (r17 == null) goto L76;
        if (r15 == null) goto L74;
        int r18 = Integer.parseInt(r15);
        r13 = this.stylesTable.getStyleAt(r18);
        goto L76
    L74:
        if (r17.getNumCellStyles() <= 0) goto L76;
        r13 = this.stylesTable.getStyleAt(0);
    L76:
        if (r13 == null) goto L90;
        this.formatIndex = r13.getDataFormat();
        String r19 = r13.getDataFormatString();
        this.formatString = r19;
        if (r19 != null) goto L91;
        this.formatString = BuiltinFormats.getBuiltinFormat(this.formatIndex);
        return;
    L91:
        return;
    L90:
        return;
    }
}
