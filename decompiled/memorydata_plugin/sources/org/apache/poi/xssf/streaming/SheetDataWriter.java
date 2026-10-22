package org.apache.poi.xssf.streaming;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import kotlin.UShort;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.CodepointsUtil;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;

/* JADX INFO: loaded from: classes7.dex */
public class SheetDataWriter implements Closeable {
    private static final c LOG = null;
    private final File _fd;
    private int _lowestIndexOfFlushedRows;
    private int _numberLastFlushedRow;
    private int _numberOfCellsOfLastFlushedRow;
    private int _numberOfFlushedRows;
    protected final Writer _out;
    private int _rownum;
    private SharedStringsTable _sharedStringSource;

    /* JADX INFO: renamed from: org.apache.poi.xssf.streaming.SheetDataWriter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType = null;

        static {
            int[] r0 = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = r0;
            r0[CellType.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        LOG = b.a(SheetDataWriter.class);
    }

    public SheetDataWriter() {
        this._numberLastFlushedRow = -1;
        File r0 = createTempFile();
        this._fd = r0;
        this._out = createWriter(r0);
    }

    public SheetDataWriter(SharedStringsTable r1) {
        this();
        this._sharedStringSource = r1;
    }

    static boolean replaceWithQuestionMark(char r1) {
        if (r1 >= ' ') goto L5;
    L10:
        return true;
    L5:
        if (65534 <= r1) goto L7;
    L9:
        return false;
    L7:
        if (r1 > 65535) goto L9;
        goto L9
    }

    private void writeAttribute(String r3, String r4) {
        this._out.write(32);
        this._out.write(r3);
        this._out.write("=\"");
        this._out.write(r4);
        this._out.write(34);
    }

    void beginRow(int r5, SXSSFRow r6) {
        this._out.write("<row");
        writeAttribute("r", Integer.toString(r5 + 1));
        if (r6.hasCustomHeight() == false) goto L6;
        writeAttribute("customHeight", "true");
        writeAttribute("ht", Float.toString(r6.getHeightInPoints()));
    L6:
        if (r6.getZeroHeight() == false) goto L8;
        writeAttribute("hidden", "true");
    L8:
        String r1 = "1";
        if (r6.isFormatted() == false) goto L12;
        writeAttribute("s", Integer.toString(r6.getRowStyleIndex()));
        writeAttribute("customFormat", "1");
    L12:
        if (r6.getOutlineLevel() == 0) goto L15;
        writeAttribute("outlineLevel", Integer.toString(r6.getOutlineLevel()));
    L15:
        if (r6.getHidden() == null) goto L22;
        if (r6.getHidden().booleanValue() == false) goto L19;
        String r0 = "1";
    L20:
        writeAttribute("hidden", r0);
        goto L22
    L19:
        r0 = "0";
    L22:
        if (r6.getCollapsed() != null) goto L24;
    L28:
        this._out.write(">\n");
        this._rownum = r5;
        return;
    L24:
        if (r6.getCollapsed().booleanValue() == true) goto L27;
        r1 = "0";
    L27:
        writeAttribute("collapsed", r1);
        goto L28
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this._out.close();
    }

    public File createTempFile() {
        return TempFile.createTempFile("poi-sxssf-sheet", ".xml");
    }

    public Writer createWriter(File r3) {
        FileOutputStream r0 = new FileOutputStream(r3);
        OutputStream r2 = decorateOutputStream(r0);     // Catch: IOException -> L6
        return new BufferedWriter(new OutputStreamWriter(r2, StandardCharsets.UTF_8));
    L6:
        e = move-exception;
        r0.close();
        throw e;
    }

    public OutputStream decorateOutputStream(FileOutputStream r1) {
        return r1;
    }

    void endRow() {
        this._out.write("</row>\n");
    }

    public int getLastFlushedRow() {
        return this._numberLastFlushedRow;
    }

    public int getNumberOfFlushedRows() {
        return this._numberOfFlushedRows;
    }

    boolean hasLeadingTrailingSpaces(String r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.length() <= 0) goto L13;
        char r0 = r4.charAt(0);
        char r5 = r4.charAt(r4.length() - 1);
        if (Character.isWhitespace(r0) == true) goto L11;
        if (Character.isWhitespace(r5) == true) goto L11;
        return false;
    L11:
        return true;
    L13:
        return false;
    }

    public void outputEscapedString(String r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.length() == 0) goto L81;
        Iterator<String> r7 = CodepointsUtil.iteratorFor(r6);
    L8:
        if (r7.hasNext() == false) goto L82;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        r0.hashCode();
        byte r1 = -1;
        switch(r0.hashCode()) {
            case 9: goto L41;
            case 10: goto L37;
            case 13: goto L33;
            case 34: goto L29;
            case 38: goto L25;
            case 60: goto L21;
            case 62: goto L17;
            case 160: goto L13;
            default: goto L44;
        };
    L44:
        switch(r1) {
            case 0: goto L60;
            case 1: goto L59;
            case 2: goto L58;
            case 3: goto L57;
            case 4: goto L56;
            case 5: goto L54;
            case 6: goto L53;
            case 7: goto L52;
            default: goto L46;
        };
    L52:
        Writer r2 = this._out;
        String r3 = "&#xa0;";
    L55:
        r2.write(r3);
        goto L8
    L53:
        r2 = this._out;
        r3 = "&gt;";
        goto L55
    L54:
        r2 = this._out;
        r3 = "&lt;";
        goto L55
    L56:
        r2 = this._out;
        r3 = "&amp;";
        goto L55
    L57:
        r2 = this._out;
        r3 = "&quot;";
        goto L55
    L58:
        r2 = this._out;
        r3 = "&#xd;";
        goto L55
    L59:
        r2 = this._out;
        r3 = "&#xa;";
        goto L55
    L60:
        r2 = this._out;
        r3 = "&#x9;";
        goto L55
    L46:
        if (r0.length() == 1) goto L47;
        this._out.write(r0);
        goto L8
    L47:
        char r4 = r0.charAt(0);
        if (replaceWithQuestionMark(r4) == true) goto L49;
        this._out.write(r4);
        goto L8
    L49:
        this._out.write(63);
        goto L8
    L13:
        if (r0.equals(" ") == false) goto L44;
        r1 = 7;
        goto L44
    L17:
        if (r0.equals(">") == false) goto L44;
        r1 = 6;
        goto L44
    L21:
        if (r0.equals("<") == false) goto L44;
        r1 = 5;
        goto L44
    L25:
        if (r0.equals("&") == false) goto L44;
        r1 = 4;
        goto L44
    L29:
        if (r0.equals("\"") == false) goto L44;
        r1 = 3;
        goto L44
    L33:
        if (r0.equals("\r") == false) goto L44;
        r1 = 2;
        goto L44
    L37:
        if (r0.equals("\n") == false) goto L44;
        r1 = 1;
        goto L44
    L41:
        if (r0.equals("\t") == false) goto L44;
        r1 = 0;
        goto L44
    L82:
        return;
    }

    public void writeCell(int r13, Cell r14) {
        Cell r15 = (Cell) ZeusTransformUtils.wrapperContextForParams(r14, Cell.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L5;
        return;
    L5:
        String r16 = new CellReference(this._rownum, r13).formatAsString();
        this._out.write("<c");
        writeAttribute("r", r16);
        CellStyle r17 = r15.getCellStyle();
        if (r17.getIndex() == 0) goto L8;
        writeAttribute("s", Integer.toString(r17.getIndex() & UShort.MAX_VALUE));
    L8:
        CellType r18 = r15.getCellType();
        String r1 = "1";
        switch(AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r18.ordinal()]) {
            case 1: goto L56;
            case 2: goto L50;
            case 3: goto L44;
            case 4: goto L41;
            case 5: goto L40;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        int r19 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r15.getCachedFormulaResultType().ordinal()];
        if (r19 == 1) goto L21;
        if (r19 == 2) goto L20;
        if (r19 == 3) goto L19;
        if (r19 != 4) goto L22;
        writeAttribute("t", "e");
    L22:
        this._out.write("><f>");
        outputEscapedString(r15.getCellFormula());
        this._out.write("</f>");
        int r110 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[r15.getCachedFormulaResultType().ordinal()];
        if (r110 == 1) goto L37;
        if (r110 == 2) goto L32;
        if (r110 == 3) goto L29;
        if (r110 != 4) goto L58;
        FormulaError r111 = FormulaError.forInt(r15.getErrorCellValue());
    L42:
        this._out.write("><v>");
        String r112 = r111.getString();
    L43:
        outputEscapedString(r112);
    L57:
        this._out.write("</v>");
    L58:
        this._out.write("</c>");
        return;
    L29:
        this._out.write("><v>");
        Writer r113 = this._out;
        if (r15.getBooleanCellValue() == true) goto L48;
    L47:
        r1 = "0";
    L48:
        r113.write(r1);
        goto L57
    L32:
        r112 = r15.getStringCellValue();
        if (r112 == null) goto L58;
        if (r112.isEmpty() == true) goto L58;
        this._out.write("<v>");
        goto L43
    L37:
        double r114 = r15.getNumericCellValue();
        if (Double.isNaN(r114) == true) goto L58;
        this._out.write("<v>");
        this._out.write(Double.toString(r114));
        goto L57
    L19:
        writeAttribute("t", "b");
        goto L22
    L20:
        writeAttribute("t", STCellType.g.toString());
        goto L22
    L21:
        writeAttribute("t", "n");
        goto L22
    L40:
        this._out.write(62);
        goto L58
    L41:
        r111 = FormulaError.forInt(r15.getErrorCellValue());
        writeAttribute("t", "e");
        goto L42
    L44:
        writeAttribute("t", "b");
        this._out.write("><v>");
        r113 = this._out;
        if (r15.getBooleanCellValue() == false) goto L47;
    L56:
        writeAttribute("t", "n");
        this._out.write("><v>");
        this._out.write(Double.toString(r15.getNumericCellValue()));
        goto L57
    L11:
        throw new IllegalStateException("Invalid cell type: " + r18);
    L50:
        if (this._sharedStringSource == null) goto L52;
        int r115 = this._sharedStringSource.addSharedStringItem(r15.getRichStringCellValue());
        writeAttribute("t", STCellType.f.toString());
        this._out.write("><v>");
        this._out.write(String.valueOf(r115));
        goto L57
    L52:
        writeAttribute("t", "inlineStr");
        this._out.write("><is><t");
        if (hasLeadingTrailingSpaces(r15.getStringCellValue()) == false) goto L55;
        writeAttribute("xml:space", "preserve");
    L55:
        this._out.write(">");
        outputEscapedString(r15.getStringCellValue());
        this._out.write("</t></is>");
        goto L58
    }

    public void writeRow(int r5, SXSSFRow r6) {
        if (this._numberOfFlushedRows != 0) goto L5;
        this._lowestIndexOfFlushedRows = r5;
    L5:
        this._numberLastFlushedRow = Math.max(r5, this._numberLastFlushedRow);
        this._numberOfCellsOfLastFlushedRow = r6.getLastCellNum();
        this._numberOfFlushedRows++;
        beginRow(r5, r6);
        Iterator<Cell> r7 = r6.allCellsIterator();
        int r8 = 0;
    L7:
        if (r7.hasNext() == false) goto L9;
        writeCell(r8, (Cell) ZeusTransformUtils.preCheckCast(r7.next(), Cell.class, "com.obric.memorydata.plugin"));
        r8 = r8 + 1;
        goto L7
    L9:
        endRow();
    }
}
