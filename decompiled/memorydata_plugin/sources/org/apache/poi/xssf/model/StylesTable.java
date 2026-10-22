package org.apache.poi.xssf.model;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.FontFamily;
import org.apache.poi.ss.usermodel.FontScheme;
import org.apache.poi.ss.usermodel.TableStyle;
import org.apache.poi.xssf.usermodel.CustomIndexedColorMap;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFBuiltinTableStyle;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFTableStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bc;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bd;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bw;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bx;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.by;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cd;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cv;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cw;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ev;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.f;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fc;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ff;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.gr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.h;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.t;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.w;

/* JADX INFO: loaded from: classes7.dex */
public class StylesTable extends POIXMLDocumentPart implements Styles {
    private static final int MAXIMUM_STYLE_ID = 0;
    private int MAXIMUM_NUMBER_OF_DATA_FORMATS;
    private final List<XSSFCellBorder> borders;
    private gr doc;
    private final List<bc> dxfs;
    private final List<XSSFCellFill> fills;
    private final List<XSSFFont> fonts;
    private IndexedColorMap indexedColors;
    private final SortedMap<Short, String> numberFormats;
    private final List<fo> styleXfs;
    private final Map<String, TableStyle> tableStyles;
    private ThemesTable theme;
    private XSSFWorkbook workbook;
    private final List<fo> xfs;

    static {
        MAXIMUM_STYLE_ID = SpreadsheetVersion.EXCEL2007.getMaxCellStyles();
    }

    public StylesTable() {
        this.numberFormats = new TreeMap();
        this.fonts = new ArrayList();
        this.fills = new ArrayList();
        this.borders = new ArrayList();
        this.styleXfs = new ArrayList();
        this.xfs = new ArrayList();
        this.dxfs = new ArrayList();
        this.tableStyles = new HashMap();
        this.indexedColors = new DefaultIndexedColorMap();
        this.MAXIMUM_NUMBER_OF_DATA_FORMATS = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        gr r0 = (gr) ZeusTransformUtils.preCheckCast(gr.f19755a.newInstance(), gr.class, "com.obric.memorydata.plugin");
        this.doc = r0;
        r0.addNewStyleSheet();
        initialize();
    }

    public StylesTable(PackagePart r2) {
        super(r2);
        this.numberFormats = new TreeMap();
        this.fonts = new ArrayList();
        this.fills = new ArrayList();
        this.borders = new ArrayList();
        this.styleXfs = new ArrayList();
        this.xfs = new ArrayList();
        this.dxfs = new ArrayList();
        this.tableStyles = new HashMap();
        this.indexedColors = new DefaultIndexedColorMap();
        this.MAXIMUM_NUMBER_OF_DATA_FORMATS = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        InputStream r3 = r2.getInputStream();
        readFrom(r3);     // Catch: Throwable -> L7
        if (r3 == null) goto L22;
        r3.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r3 != null) goto L20;
    L15:
        throw th;
    L20:
        r3.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    private static f createDefaultBorder() {
        f r0 = (f) ZeusTransformUtils.preCheckCast(f.f19671a.newInstance(), f.class, "com.obric.memorydata.plugin");
        r0.addNewBottom();
        r0.addNewTop();
        r0.addNewLeft();
        r0.addNewRight();
        r0.addNewDiagonal();
        return r0;
    }

    private static bw[] createDefaultFills() {
        bw[] r0 = {(bw) ZeusTransformUtils.preCheckCast(bw.f19503a.newInstance(), bw.class, "com.obric.memorydata.plugin"), (bw) ZeusTransformUtils.preCheckCast(bw.f19503a.newInstance(), bw.class, "com.obric.memorydata.plugin")};
        r0[0].addNewPatternFill().setPatternType(STPatternType.c);
        r0[1].addNewPatternFill().setPatternType(STPatternType.f);
        return r0;
    }

    private static XSSFFont createDefaultFont() {
        XSSFFont r1 = new XSSFFont((by) ZeusTransformUtils.preCheckCast(by.f19507a.newInstance(), by.class, "com.obric.memorydata.plugin"), 0, null);
        r1.setFontHeightInPoints(11);
        r1.setColor(XSSFFont.DEFAULT_FONT_COLOR);
        r1.setFontName("Calibri");
        r1.setFamily(FontFamily.SWISS);
        r1.setScheme(FontScheme.MINOR);
        return r1;
    }

    private static fo createDefaultXf() {
        fo r0 = (fo) ZeusTransformUtils.preCheckCast(fo.f19701a.newInstance(), fo.class, "com.obric.memorydata.plugin");
        r0.setNumFmtId(0);
        r0.setFontId(0);
        r0.setFillId(0);
        r0.setBorderId(0);
        return r0;
    }

    private void initialize() {
        XSSFFont r0 = createDefaultFont();
        this.fonts.add(r0);
        bw[] r1 = createDefaultFills();
        this.fills.add(new XSSFCellFill(r1[0], this.indexedColors));
        this.fills.add(new XSSFCellFill(r1[1], this.indexedColors));
        f r2 = createDefaultBorder();
        this.borders.add(new XSSFCellBorder(r2));
        fo r3 = createDefaultXf();
        this.styleXfs.add(r3);
        fo r4 = createDefaultXf();
        r4.setXfId(0);
        this.xfs.add(r4);
    }

    public int _getDXfsSize() {
        return this.dxfs.size();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        OutputStream r0 = getPackagePart().getOutputStream();
        writeTo(r0);     // Catch: Throwable -> L7
        if (r0 == null) goto L22;
        r0.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r0 != null) goto L20;
    L15:
        throw th;
    L20:
        r0.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public fo getCellStyleXfAt(int r2) {
        return (fo) ZeusTransformUtils.preCheckCast(this.styleXfs.get(r2), fo.class, "com.obric.memorydata.plugin");
    L4:
        return null;
    }

    public fo getCellXfAt(int r2) {
        return (fo) ZeusTransformUtils.preCheckCast(this.xfs.get(r2), fo.class, "com.obric.memorydata.plugin");
    }

    public bc getDxfAt(int r2) {
        return (bc) ZeusTransformUtils.preCheckCast(this.dxfs.get(r2), bc.class, "com.obric.memorydata.plugin");
    }

    public TableStyle getExplicitTableStyle(String r2) {
        return (TableStyle) ZeusTransformUtils.preCheckCast(this.tableStyles.get(r2), TableStyle.class, "com.obric.memorydata.plugin");
    }

    public XSSFFont getFontAt(int r2) {
        return (XSSFFont) ZeusTransformUtils.preCheckCast(this.fonts.get(r2), XSSFFont.class, "com.obric.memorydata.plugin");
    }

    public IndexedColorMap getIndexedColors() {
        return this.indexedColors;
    }

    @Override // org.apache.poi.xssf.model.Styles
    public int getNumCellStyles() {
        return this.xfs.size();
    }

    public String getNumberFormatAt(short r2) {
        return (String) ZeusTransformUtils.preCheckCast(this.numberFormats.get(Short.valueOf(r2)), String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.xssf.model.Styles
    public XSSFCellStyle getStyleAt(int r6) {
        if (r6 >= 0) goto L4;
        return null;
    L4:
        if (r6 < this.xfs.size()) goto L7;
        return null;
    L7:
        if (((fo) ZeusTransformUtils.preCheckCast(this.xfs.get(r6), fo.class, "com.obric.memorydata.plugin")).getXfId() <= 0) goto L9;
        int r0 = (int) ((fo) ZeusTransformUtils.preCheckCast(this.xfs.get(r6), fo.class, "com.obric.memorydata.plugin")).getXfId();
    L11:
        return new XSSFCellStyle(r6, r0, this, this.theme);
    L9:
        r0 = 0;
        goto L11
    }

    public TableStyle getTableStyle(String r2) {
        if (r2 != null) goto L9;
        return null;
    L9:
        return XSSFBuiltinTableStyle.valueOf(r2).getStyle();
    L8:
        return getExplicitTableStyle(r2);
    }

    public int putDxf(bc r3) {
        bc r4 = (bc) ZeusTransformUtils.wrapperContextForParams(r3, bc.class, "com.obric.memorydata.plugin");
        this.dxfs.add(r4);
        return this.dxfs.size();
    }

    public int putStyle(XSSFCellStyle r2) {
        fo r3 = r2.getCoreXf();
        if (this.xfs.contains(r3) == true) goto L6;
        this.xfs.add(r3);
    L6:
        return this.xfs.indexOf(r3);
    }

    public void readFrom(InputStream r10) {
        gr r11 = (gr) ZeusTransformUtils.preCheckCast(gr.f19755a.parse(r10, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), gr.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L42
        this.doc = r11;     // Catch: XmlException -> L42
        ev r12 = r11.getStyleSheet();     // Catch: XmlException -> L42
        CustomIndexedColorMap r0 = CustomIndexedColorMap.fromColors(r12.getColors());     // Catch: XmlException -> L42
        if (r0 == null) goto L5;
        this.indexedColors = r0;     // Catch: XmlException -> L42
    L5:
        cw r1 = r12.getNumFmts();     // Catch: XmlException -> L42
        int r2 = 0;
        if (r1 == null) goto L10;
        cv[] r3 = r1.getNumFmtArray();     // Catch: XmlException -> L42
        int r4 = r3.length;     // Catch: XmlException -> L42
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L10;
        cv r6 = r3[r5];     // Catch: XmlException -> L42
        this.numberFormats.put(Short.valueOf((short) r6.getNumFmtId()), r6.getFormatCode());     // Catch: XmlException -> L42
        r5 = r5 + 1;     // Catch: XmlException -> L42
    L10:
        cd r7 = r12.getFonts();     // Catch: XmlException -> L42
        if (r7 == null) goto L15;
        by[] r8 = r7.getFontArray();     // Catch: XmlException -> L42
        int r9 = r8.length;     // Catch: XmlException -> L42
        int r13 = 0;
        int r14 = 0;
    L13:
        if (r13 >= r9) goto L15;
        this.fonts.add(new XSSFFont(r8[r13], r14, this.indexedColors));     // Catch: XmlException -> L42
        r14 = r14 + 1;     // Catch: XmlException -> L42
        r13 = r13 + 1;     // Catch: XmlException -> L42
    L15:
        bx r15 = r12.getFills();     // Catch: XmlException -> L42
        if (r15 == null) goto L20;
        bw[] r16 = r15.getFillArray();     // Catch: XmlException -> L42
        int r17 = r16.length;     // Catch: XmlException -> L42
        int r18 = 0;
    L18:
        if (r18 >= r17) goto L20;
        this.fills.add(new XSSFCellFill(r16[r18], this.indexedColors));     // Catch: XmlException -> L42
        r18 = r18 + 1;     // Catch: XmlException -> L42
    L20:
        h r19 = r12.getBorders();     // Catch: XmlException -> L42
        if (r19 == null) goto L25;
        f[] r20 = r19.getBorderArray();     // Catch: XmlException -> L42
        int r21 = r20.length;     // Catch: XmlException -> L42
        int r22 = 0;
    L23:
        if (r22 >= r21) goto L25;
        this.borders.add(new XSSFCellBorder(r20[r22], this.indexedColors));     // Catch: XmlException -> L42
        r22 = r22 + 1;     // Catch: XmlException -> L42
    L25:
        w r23 = r12.getCellXfs();     // Catch: XmlException -> L42
        if (r23 == null) goto L28;
        this.xfs.addAll(Arrays.asList(r23.getXfArray()));     // Catch: XmlException -> L42
    L28:
        t r24 = r12.getCellStyleXfs();     // Catch: XmlException -> L42
        if (r24 == null) goto L31;
        this.styleXfs.addAll(Arrays.asList(r24.getXfArray()));     // Catch: XmlException -> L42
    L31:
        bd r25 = r12.getDxfs();     // Catch: XmlException -> L42
        if (r25 == null) goto L34;
        this.dxfs.addAll(Arrays.asList(r25.getDxfArray()));     // Catch: XmlException -> L42
    L34:
        ff r110 = r12.getTableStyles();     // Catch: XmlException -> L42
        if (r110 == null) goto L41;
        if (r25 == null) goto L52;
        fc[] r111 = r110.getTableStyleArray();     // Catch: XmlException -> L42
        int r26 = r111.length;     // Catch: XmlException -> L42
        int r27 = 0;
    L38:
        if (r2 >= r26) goto L53;
        fc r28 = r111[r2];     // Catch: XmlException -> L42
        this.tableStyles.put(r28.getName(), new XSSFTableStyle(r27, r25, r28, this.indexedColors));     // Catch: XmlException -> L42
        r27 = r27 + 1;
        r2 = r2 + 1;
        goto L38
    L53:
        return;
    L52:
        return;
    L41:
        return;
    L42:
        e = move-exception;
        throw new IOException(e.getLocalizedMessage());
    }

    public void setTheme(ThemesTable r5) {
        this.theme = r5;
        if (r5 == null) goto L5;
        r5.setColorMap(getIndexedColors());
    L5:
        Iterator<XSSFFont> r0 = this.fonts.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((XSSFFont) ZeusTransformUtils.preCheckCast(r0.next(), XSSFFont.class, "com.obric.memorydata.plugin")).setThemesTable(r5);
        goto L7
    L9:
        Iterator<XSSFCellBorder> r4 = this.borders.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        ((XSSFCellBorder) ZeusTransformUtils.preCheckCast(r4.next(), XSSFCellBorder.class, "com.obric.memorydata.plugin")).setThemesTable(r5);
        goto L11
    }

    public void setWorkbook(XSSFWorkbook r1) {
        this.workbook = r1;
    }

    public void writeTo(OutputStream r10) {
        ev r0 = this.doc.getStyleSheet();
        cw r1 = (cw) ZeusTransformUtils.preCheckCast(cw.f19557a.newInstance(), cw.class, "com.obric.memorydata.plugin");
        r1.setCount(this.numberFormats.size());
        Iterator<Map.Entry<Short, String>> r2 = this.numberFormats.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        cv r5 = r1.addNewNumFmt();
        r5.setNumFmtId(((Short) ZeusTransformUtils.preCheckCast(r4.getKey(), Short.class, "com.obric.memorydata.plugin")).shortValue());
        r5.setFormatCode((String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        r0.setNumFmts(r1);
        cd r3 = r0.getFonts();
        if (r3 != null) goto L9;
        r3 = (cd) ZeusTransformUtils.preCheckCast(cd.f19519a.newInstance(), cd.class, "com.obric.memorydata.plugin");
    L9:
        r3.setCount(this.fonts.size());
        by[] r6 = new by[this.fonts.size()];
        Iterator<XSSFFont> r7 = this.fonts.iterator();
        int r8 = 0;
    L11:
        if (r7.hasNext() == false) goto L13;
        r6[r8] = ((XSSFFont) ZeusTransformUtils.preCheckCast(r7.next(), XSSFFont.class, "com.obric.memorydata.plugin")).getCTFont();
        r8 = r8 + 1;
        goto L11
    L13:
        r3.setFontArray(r6);
        r0.setFonts(r3);
        bx r9 = r0.getFills();
        if (r9 != null) goto L16;
        r9 = (bx) ZeusTransformUtils.preCheckCast(bx.f19505a.newInstance(), bx.class, "com.obric.memorydata.plugin");
    L16:
        r9.setCount(this.fills.size());
        bw[] r11 = new bw[this.fills.size()];
        Iterator<XSSFCellFill> r12 = this.fills.iterator();
        int r13 = 0;
    L18:
        if (r12.hasNext() == false) goto L20;
        r11[r13] = ((XSSFCellFill) ZeusTransformUtils.preCheckCast(r12.next(), XSSFCellFill.class, "com.obric.memorydata.plugin")).getCTFill();
        r13 = r13 + 1;
        goto L18
    L20:
        r9.setFillArray(r11);
        r0.setFills(r9);
        h r14 = r0.getBorders();
        if (r14 != null) goto L23;
        r14 = (h) ZeusTransformUtils.preCheckCast(h.f19763a.newInstance(), h.class, "com.obric.memorydata.plugin");
    L23:
        r14.setCount(this.borders.size());
        f[] r15 = new f[this.borders.size()];
        Iterator<XSSFCellBorder> r16 = this.borders.iterator();
        int r17 = 0;
    L25:
        if (r16.hasNext() == false) goto L27;
        r15[r17] = ((XSSFCellBorder) ZeusTransformUtils.preCheckCast(r16.next(), XSSFCellBorder.class, "com.obric.memorydata.plugin")).getCTBorder();
        r17 = r17 + 1;
        goto L25
    L27:
        r14.setBorderArray(r15);
        r0.setBorders(r14);
        if (this.xfs.isEmpty() == true) goto L34;
        w r18 = r0.getCellXfs();
        if (r18 != null) goto L32;
        r18 = (w) ZeusTransformUtils.preCheckCast(w.f19791a.newInstance(), w.class, "com.obric.memorydata.plugin");
    L32:
        r18.setCount(this.xfs.size());
        r18.setXfArray((fo[]) ZeusTransformUtils.preCheckCast(this.xfs.toArray(new fo[0]), fo[].class, "com.obric.memorydata.plugin"));
        r0.setCellXfs(r18);
    L34:
        if (this.styleXfs.isEmpty() == true) goto L40;
        t r19 = r0.getCellStyleXfs();
        if (r19 != null) goto L38;
        r19 = (t) ZeusTransformUtils.preCheckCast(t.f19785a.newInstance(), t.class, "com.obric.memorydata.plugin");
    L38:
        r19.setCount(this.styleXfs.size());
        r19.setXfArray((fo[]) ZeusTransformUtils.preCheckCast(this.styleXfs.toArray(new fo[0]), fo[].class, "com.obric.memorydata.plugin"));
        r0.setCellStyleXfs(r19);
    L40:
        if (this.dxfs.isEmpty() == true) goto L45;
        bd r20 = r0.getDxfs();
        if (r20 != null) goto L44;
        r20 = (bd) ZeusTransformUtils.preCheckCast(bd.f19465a.newInstance(), bd.class, "com.obric.memorydata.plugin");
    L44:
        r20.setCount(this.dxfs.size());
        r20.setDxfArray((bc[]) ZeusTransformUtils.preCheckCast(this.dxfs.toArray(new bc[0]), bc[].class, "com.obric.memorydata.plugin"));
        r0.setDxfs(r20);
    L45:
        this.doc.save(r10, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }
}
