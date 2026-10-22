package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.TreeMap;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.SSCellRange;
import org.apache.poi.xssf.model.Comments;
import org.apache.poi.xssf.usermodel.helpers.ColumnHelper;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.aa;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.af;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bb;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cg;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cp;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ct;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.cu;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.de;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.dz;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ej;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ek;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.en;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.eo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fm;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.gu;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.r;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFSheet extends POIXMLDocumentPart implements Sheet, OoxmlSheetExtensions {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    private final SortedMap<Integer, XSSFRow> _rows;
    private List<CellRangeAddress> arrayFormulas;
    private ColumnHelper columnHelper;
    private final XSSFDataValidationHelper dataValidationHelper;
    private CellRangeAddress dimensionOverride;
    private List<XSSFHyperlink> hyperlinks;
    private Map<Integer, r> sharedFormulas;
    protected ef sheet;
    private Comments sheetComments;
    private SortedMap<String, XSSFTable> tables;
    protected fm worksheet;
    private XSSFVMLDrawing xssfvmlDrawing;

    static {
        LOG = b.a(XSSFSheet.class);
    }

    public XSSFSheet() {
        this._rows = new TreeMap();
        this.dataValidationHelper = new XSSFDataValidationHelper(this);
        onDocumentCreate();
    }

    public XSSFSheet(PackagePart r1) {
        super(r1);
        this._rows = new TreeMap();
        this.dataValidationHelper = new XSSFDataValidationHelper(this);
    }

    private CellRange<XSSFCell> getCellRange(CellRangeAddress r11) {
        int r0 = r11.getFirstRow();
        int r1 = r11.getFirstColumn();
        int r2 = r11.getLastRow();
        int r12 = r11.getLastColumn();
        int r3 = (r2 - r0) + 1;
        int r4 = (r12 - r1) + 1;
        ArrayList r5 = new ArrayList(r3 * r4);
        int r6 = r0;
    L3:
        if (r6 > r2) goto L15;
        int r7 = r1;
    L5:
        if (r7 > r12) goto L13;
        XSSFRow r8 = getRow(r6);
        if (r8 != null) goto L9;
        r8 = createRow(r6);
    L9:
        XSSFCell r9 = r8.getCell(r7);
        if (r9 != null) goto L12;
        r9 = r8.createCell(r7);
    L12:
        r5.add(r9);
        r7 = r7 + 1;
        goto L5
    L13:
        r6 = r6 + 1;
        goto L3
    L15:
        return SSCellRange.create(r0, r1, r3, r4, r5, XSSFCell.class);
    }

    private void initHyperlinks() {
        this.hyperlinks = new ArrayList();
        if (this.worksheet.isSetHyperlinks() == true) goto L16;
        return;
    L16:
        PackageRelationshipCollection r0 = getPackagePart().getRelationshipsByType(XSSFRelation.SHEET_HYPERLINKS.getRelation());     // Catch: InvalidFormatException -> L13
        cg[] r1 = this.worksheet.getHyperlinks().getHyperlinkArray();     // Catch: InvalidFormatException -> L13
        int r2 = r1.length;     // Catch: InvalidFormatException -> L13
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        cg r4 = r1[r3];     // Catch: InvalidFormatException -> L13
        PackageRelationship r5 = null;
        if (r4.getId() == null) goto L10;
        r5 = r0.getRelationshipByID(r4.getId());     // Catch: InvalidFormatException -> L13
    L10:
        this.hyperlinks.add(new XSSFHyperlink(r4, r5));     // Catch: InvalidFormatException -> L13
        r3 = r3 + 1;
        goto L6
    L12:
        return;
    L13:
        e = move-exception;
        throw new POIXMLException(e);
    }

    private void initRows(fm r6) {
        fm r7 = (fm) ZeusTransformUtils.wrapperContextForParams(r6, fm.class, "com.obric.memorydata.plugin");
        if (r7.getSheetData() == null) goto L11;
        if (r7.getSheetData().getRowArray() == null) goto L11;
        this._rows.clear();
        this.tables = new TreeMap();
        this.sharedFormulas = new HashMap();
        this.arrayFormulas = new ArrayList();
        dz[] r8 = r7.getSheetData().getRowArray();
        int r0 = r8.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L9;
        XSSFRow r3 = new XSSFRow(r8[r1], this);
        Integer r2 = Integer.valueOf(r3.getRowNum());
        this._rows.put(r2, r3);
        r1 = r1 + 1;
        goto L7
    L9:
        return;
    L11:
        throw new IllegalArgumentException("Had empty sheet data when initializing the sheet");
    }

    private static fm newSheet() {
        fm r0 = (fm) ZeusTransformUtils.preCheckCast(fm.f19697a.newInstance(), fm.class, "com.obric.memorydata.plugin");
        r0.addNewSheetFormatPr().setDefaultRowHeight(15.0d);
        r0.addNewSheetViews().addNewSheetView().setWorkbookViewId(0);
        r0.addNewDimension().setRef("A1");
        r0.addNewSheetData();
        de r1 = r0.addNewPageMargins();
        r1.setBottom(0.75d);
        r1.setFooter(0.3d);
        r1.setHeader(0.3d);
        r1.setLeft(0.7d);
        r1.setRight(0.7d);
        r1.setTop(0.75d);
        return r0;
    }

    private void setColWidthAttribute(af r7) {
        aa[] r8 = ((af) ZeusTransformUtils.wrapperContextForParams(r7, af.class, "com.obric.memorydata.plugin")).getColArray();
        int r0 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        aa r3 = r8[r2];
        if (r3.isSetWidth() == true) goto L7;
        r3.setWidth(getDefaultColumnWidth());
        r3.setCustomWidth(false);
    L7:
        r2 = r2 + 1;
        goto L3
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        OutputStream r0 = getPackagePart().getOutputStream();
        write(r0);     // Catch: Throwable -> L7
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

    @Override // org.apache.poi.ss.usermodel.Sheet
    public /* bridge */ /* synthetic */ Row createRow(int r1) {
        return createRow(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFRow createRow(int r6) {
        Integer r0 = Integer.valueOf(r6);
        XSSFRow r1 = (XSSFRow) ZeusTransformUtils.preCheckCast(this._rows.get(r0), XSSFRow.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L9;
    L5:
        if (r1.getFirstCellNum() == (-1)) goto L7;
        r1.removeCell(r1.getCell(r1.getFirstCellNum()));
        goto L5
    L7:
        dz r2 = r1.getCTRow();
        r2.set((XmlObject) ZeusTransformUtils.preCheckCast(dz.f19617a.newInstance(), XmlObject.class, "com.obric.memorydata.plugin"));
    L15:
        XSSFRow r3 = new XSSFRow(r2, this);
        r3.setRowNum(r6);
        this._rows.put(r0, r3);
        return r3;
    L9:
        if (this._rows.isEmpty() == false) goto L11;
    L14:
        r2 = this.worksheet.getSheetData().addNewRow();
        goto L15
    L11:
        if (r6 > ((Integer) ZeusTransformUtils.preCheckCast(this._rows.lastKey(), Integer.class, "com.obric.memorydata.plugin")).intValue()) goto L14;
        int r4 = this._rows.headMap(r0).size();
        r2 = this.worksheet.getSheetData().insertNewRow(r4);
        goto L15
    }

    public bb getCTDrawing() {
        return this.worksheet.getDrawing();
    }

    public cp getCTLegacyDrawing() {
        return this.worksheet.getLegacyDrawing();
    }

    public fm getCTWorksheet() {
        return this.worksheet;
    }

    public CellStyle getColumnStyle(int r4) {
        int r5 = this.columnHelper.getColDefaultStyle(r4);
        XSSFWorkbook r3 = getWorkbook();
        if (r5 != (-1)) goto L6;
        r5 = 0;
    L6:
        return r3.getCellStyleAt((short) r5);
    }

    public int getColumnWidth(int r4) {
        aa r5 = this.columnHelper.getColumn(r4, false);
        if (r5 != null) goto L5;
    L8:
        double r3 = getDefaultColumnWidth();
    L10:
        return Math.toIntExact(Math.round(r3 * 256.0d));
    L5:
        if (r5.isSetWidth() == false) goto L8;
        r3 = r5.getWidth();
        goto L10
    }

    public int getDefaultColumnWidth() {
        ek r2 = this.worksheet.getSheetFormatPr();
        if (r2 != null) goto L6;
        return 8;
    L6:
        return Math.toIntExact(r2.getBaseColWidth());
    }

    public float getDefaultRowHeightInPoints() {
        ek r2 = this.worksheet.getSheetFormatPr();
        if (r2 != null) goto L5;
        double r0 = 0.0d;
    L7:
        return (float) r0;
    L5:
        r0 = r2.getDefaultRowHeight();
        goto L7
    }

    public XSSFDrawing getDrawingPatriarch() {
        bb r0 = getCTDrawing();
        if (r0 == null) goto L21;
        Iterator<POIXMLDocumentPart.RelationPart> r5 = getRelationParts().iterator();
    L6:
        if (r5.hasNext() == false) goto L12;
        POIXMLDocumentPart.RelationPart r1 = (POIXMLDocumentPart.RelationPart) ZeusTransformUtils.preCheckCast(r5.next(), POIXMLDocumentPart.RelationPart.class, "com.obric.memorydata.plugin");
        POIXMLDocumentPart r2 = r1.getDocumentPart();
        if (ZeusTransformUtils.instanceOf(r2, XSSFDrawing.class) == false) goto L6;
        XSSFDrawing r3 = (XSSFDrawing) ZeusTransformUtils.preCheckCast(r2, XSSFDrawing.class, "com.obric.memorydata.plugin");
        if (r1.getRelationship().getId().equals(r0.getId()) == false) goto L6;
        return r3;
    L12:
        LOG.atError().a("Can't find drawing with id={} in the list of the sheet's relationships", r0.getId());
        return null;
    L21:
        return null;
    }

    XSSFCell getFirstCellInArrayFormula(XSSFCell r5) {
        Iterator<CellRangeAddress> r0 = this.arrayFormulas.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        CellRangeAddress r1 = (CellRangeAddress) ZeusTransformUtils.preCheckCast(r0.next(), CellRangeAddress.class, "com.obric.memorydata.plugin");
        if (r1.isInRange(r5.getRowIndex(), r5.getColumnIndex()) == false) goto L4;
        return getRow(r1.getFirstRow()).getCell(r1.getFirstColumn());
    L9:
        return null;
    }

    public int getFirstRowNum() {
        if (this._rows.isEmpty() == false) goto L6;
        return -1;
    L6:
        return ((Integer) ZeusTransformUtils.preCheckCast(this._rows.firstKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public int getLastRowNum() {
        if (this._rows.isEmpty() == false) goto L6;
        return -1;
    L6:
        return ((Integer) ZeusTransformUtils.preCheckCast(this._rows.lastKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public List<CellRangeAddress> getMergedRegions() {
        ArrayList r0 = new ArrayList();
        cu r4 = this.worksheet.getMergeCells();
        if (r4 != null) goto L5;
        return r0;
    L5:
        ct[] r5 = r4.getMergeCellArray();
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        r0.add(CellRangeAddress.valueOf(r5[r2].getRef()));
        r2 = r2 + 1;
        goto L6
    L8:
        return r0;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getNumMergedRegions() {
        cu r0 = this.worksheet.getMergeCells();
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.sizeOfMergeCellArray();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public int getPhysicalNumberOfRows() {
        return this._rows.size();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public /* bridge */ /* synthetic */ Row getRow(int r1) {
        return getRow(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFRow getRow(int r2) {
        Integer r3 = Integer.valueOf(r2);
        return (XSSFRow) ZeusTransformUtils.preCheckCast(this._rows.get(r3), XSSFRow.class, "com.obric.memorydata.plugin");
    }

    public r getSharedFormula(int r2) {
        return (r) ZeusTransformUtils.preCheckCast(this.sharedFormulas.get(Integer.valueOf(r2)), r.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public /* bridge */ /* synthetic */ SheetConditionalFormatting getSheetConditionalFormatting() {
        return getSheetConditionalFormatting();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFSheetConditionalFormatting getSheetConditionalFormatting() {
        return new XSSFSheetConditionalFormatting(this);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public String getSheetName() {
        return this.sheet.getName();
    }

    public eo getSheetTypeSheetViews(boolean r2) {
        if (this.worksheet.isSetSheetViews() == true) goto L7;
        if (r2 == false) goto L7;
        eo r1 = this.worksheet.addNewSheetViews();
    L8:
        if (r1 != null) goto L12;
        return null;
    L12:
        if (r1.sizeOfSheetViewArray() != 0) goto L15;
        if (r2 == false) goto L15;
        r1.addNewSheetView();
    L15:
        return r1;
    L7:
        r1 = this.worksheet.getSheetViews();
        goto L8
    }

    public List<XSSFTable> getTables() {
        return new ArrayList(this.tables.values());
    }

    @Override // org.apache.poi.xssf.usermodel.OoxmlSheetExtensions
    public XSSFVMLDrawing getVMLDrawing(boolean r7) {
        if (this.xssfvmlDrawing != null) goto L20;
        XSSFVMLDrawing r0 = null;
        cp r1 = getCTLegacyDrawing();
        if (r1 != null) goto L8;
        if (r7 == false) goto L18;
        int r8 = getNextPartNumber(XSSFRelation.VML_DRAWINGS, getPackagePart().getPackage().getPartsByContentType(XSSFRelation.VML_DRAWINGS.getContentType()).size());
        POIXMLDocumentPart.RelationPart r9 = createRelationship(XSSFRelation.VML_DRAWINGS, getWorkbook().getXssfFactory(), r8, false);
        r0 = (XSSFVMLDrawing) ZeusTransformUtils.preCheckCast(r9.getDocumentPart(), XSSFVMLDrawing.class, "com.obric.memorydata.plugin");
        String r10 = r9.getRelationship().getId();
        this.worksheet.addNewLegacyDrawing().setId(r10);
    L18:
        this.xssfvmlDrawing = r0;
        goto L20
    L8:
        String r11 = r1.getId();
        Iterator<POIXMLDocumentPart.RelationPart> r2 = getRelationParts().iterator();
    L10:
        if (r2.hasNext() == false) goto L16;
        POIXMLDocumentPart.RelationPart r3 = (POIXMLDocumentPart.RelationPart) ZeusTransformUtils.preCheckCast(r2.next(), POIXMLDocumentPart.RelationPart.class, "com.obric.memorydata.plugin");
        POIXMLDocumentPart r4 = r3.getDocumentPart();
        if (ZeusTransformUtils.instanceOf(r4, XSSFVMLDrawing.class) == false) goto L10;
        XSSFVMLDrawing r5 = (XSSFVMLDrawing) ZeusTransformUtils.preCheckCast(r4, XSSFVMLDrawing.class, "com.obric.memorydata.plugin");
        if (r3.getRelationship().getId().equals(r11) == false) goto L10;
        r0 = r5;
    L16:
        if (r0 != null) goto L18;
        LOG.atError().a("Can't find VML drawing with id={} in the list of the sheet's relationships", r11);
    L20:
        return this.xssfvmlDrawing;
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public /* bridge */ /* synthetic */ Workbook getWorkbook() {
        return getWorkbook();
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public XSSFWorkbook getWorkbook() {
        return (XSSFWorkbook) ZeusTransformUtils.preCheckCast(getParent(), XSSFWorkbook.class, "com.obric.memorydata.plugin");
    }

    boolean isCellInArrayFormulaContext(XSSFCell r4) {
        Iterator<CellRangeAddress> r3 = this.arrayFormulas.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((CellRangeAddress) ZeusTransformUtils.preCheckCast(r3.next(), CellRangeAddress.class, "com.obric.memorydata.plugin")).isInRange(r4.getRowIndex(), r4.getColumnIndex()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void onDeleteFormula(XSSFCell r12, BaseXSSFEvaluationWorkbook r13) {
        r r0 = r12.getCTCell().getF();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getT() == STCellFormulaType.f) goto L7;
        return;
    L7:
        if (r0.isSetRef() == true) goto L9;
        return;
    L9:
        if (r0.getStringValue() == null) goto L44;
        CellRangeAddress r1 = CellRangeAddress.valueOf(r0.getRef());
        if (r1.getNumberOfCells() <= 1) goto L45;
        int r2 = r12.getRowIndex();
    L14:
        if (r2 > r1.getLastRow()) goto L47;
        XSSFRow r3 = getRow(r2);
        if (r3 == null) goto L31;
        int r4 = r12.getColumnIndex();
    L19:
        if (r4 > r1.getLastColumn()) goto L31;
        XSSFCell r5 = r3.getCell(r4);
        if (r5 == null) goto L30;
        if (r5 == r12) goto L30;
        if (r5.getCellType() != CellType.FORMULA) goto L30;
        r r6 = r5.getCTCell().getF();
        if (r6.getT() != STCellFormulaType.f) goto L30;
        if (r6.getSi() != r0.getSi()) goto L30;
        r6.setStringValue(r5.getCellFormula(r13));
        r6.setRef(new CellRangeAddress(r5.getRowIndex(), r1.getLastRow(), r5.getColumnIndex(), r1.getLastColumn()).formatAsString());
        this.sharedFormulas.put(Integer.valueOf(Math.toIntExact(r6.getSi())), r6);
        return;
    L30:
        r4 = r4 + 1;
    L31:
        r2 = r2 + 1;
        goto L14
    L47:
        return;
    L45:
        return;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentCreate() {
        fm r0 = newSheet();
        this.worksheet = r0;
        initRows(r0);
        this.columnHelper = new ColumnHelper(this.worksheet);
        this.hyperlinks = new ArrayList();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        InputStream r0 = getPackagePart().getInputStream();     // Catch: IOException -> L16
        read(r0);     // Catch: Throwable -> L7
        if (r0 == null) goto L26;
        r0.close();     // Catch: IOException -> L16
        return;
    L26:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r0 != null) goto L23;
    L15:
        throw th;     // Catch: IOException -> L16
    L23:
        r0.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L16
    L16:
        e = move-exception;
        throw new POIXMLException(e);
    }

    void onReadCell(XSSFCell r9) {
        r r0 = r9.getCTCell().getF();
        if (r0 != null) goto L5;
    L16:
        if (r0 != null) goto L18;
        return;
    L18:
        if (r0.getT() == STCellFormulaType.d) goto L20;
        return;
    L20:
        if (r0.getRef() == null) goto L25;
        this.arrayFormulas.add(CellRangeAddress.valueOf(r0.getRef()));
        return;
    L25:
        return;
    L5:
        if (r0.getT() != STCellFormulaType.f) goto L16;
        if (r0.isSetRef() == false) goto L16;
        if (r0.getStringValue() == null) goto L16;
        r r1 = (r) ZeusTransformUtils.preCheckCast(r0.copy(), r.class, "com.obric.memorydata.plugin");
        CellRangeAddress r2 = CellRangeAddress.valueOf(r1.getRef());
        CellReference r3 = new CellReference(r9);
        if (r3.getCol() <= r2.getFirstColumn()) goto L13;
    L14:
        r1.setRef(new CellRangeAddress(Math.max(r3.getRow(), r2.getFirstRow()), Math.max(r3.getRow(), r2.getLastRow()), Math.max(r3.getCol(), r2.getFirstColumn()), Math.max(r3.getCol(), r2.getLastColumn())).formatAsString());
    L15:
        this.sharedFormulas.put(Integer.valueOf(Math.toIntExact(r0.getSi())), r1);
        goto L16
    L13:
        if (r3.getRow() <= r2.getFirstRow()) goto L15;
        goto L14
    }

    public void read(InputStream r6) {
        fm r7 = ((gu) ZeusTransformUtils.preCheckCast(gu.f19761a.parse(r6, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), gu.class, "com.obric.memorydata.plugin")).getWorksheet();     // Catch: XmlException -> L18
        this.worksheet = r7;     // Catch: XmlException -> L18
        initRows(r7);
        this.columnHelper = new ColumnHelper(this.worksheet);
        Iterator<POIXMLDocumentPart.RelationPart> r8 = getRelationParts().iterator();
    L6:
        if (r8.hasNext() == false) goto L16;
        POIXMLDocumentPart.RelationPart r1 = (POIXMLDocumentPart.RelationPart) ZeusTransformUtils.preCheckCast(r8.next(), POIXMLDocumentPart.RelationPart.class, "com.obric.memorydata.plugin");
        POIXMLDocumentPart r2 = r1.getDocumentPart();
        if (ZeusTransformUtils.instanceOf(r2, Comments.class) == false) goto L11;
        Comments r3 = (Comments) ZeusTransformUtils.preCheckCast(r2, Comments.class, "com.obric.memorydata.plugin");
        this.sheetComments = r3;
        r3.setSheet(this);
    L11:
        if (ZeusTransformUtils.instanceOf(r2, XSSFTable.class) == false) goto L14;
        this.tables.put(r1.getRelationship().getId(), (XSSFTable) ZeusTransformUtils.preCheckCast(r2, XSSFTable.class, "com.obric.memorydata.plugin"));
    L14:
        if (ZeusTransformUtils.instanceOf(r2, XSSFPivotTable.class) == false) goto L6;
        getWorkbook().getPivotTables().add((XSSFPivotTable) ZeusTransformUtils.preCheckCast(r2, XSSFPivotTable.class, "com.obric.memorydata.plugin"));
        goto L6
    L16:
        initHyperlinks();
        return;
    L18:
        e = move-exception;
        throw new POIXMLException(e);
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public CellRange<XSSFCell> removeArrayFormula(Cell r5) {
        Cell r6 = (Cell) ZeusTransformUtils.wrapperContextForParams(r5, Cell.class, "com.obric.memorydata.plugin");
        if (r6.getSheet() != this) goto L17;
        Iterator<CellRangeAddress> r0 = this.arrayFormulas.iterator();
    L6:
        if (r0.hasNext() == false) goto L15;
        CellRangeAddress r2 = (CellRangeAddress) ZeusTransformUtils.preCheckCast(r0.next(), CellRangeAddress.class, "com.obric.memorydata.plugin");
        if (r2.isInRange(r6) == false) goto L6;
        this.arrayFormulas.remove(r2);
        CellRange<XSSFCell> r4 = getCellRange(r2);
        Iterator<C> r7 = r4.iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        ((XSSFCell) ZeusTransformUtils.preCheckCast(r7.next(), XSSFCell.class, "com.obric.memorydata.plugin")).setBlank();
        goto L11
    L13:
        return r4;
    L15:
        throw new IllegalArgumentException("Cell " + new CellReference(r6).formatAsString() + " is not part of an array formula.");
    L17:
        throw new IllegalArgumentException("Specified cell does not belong to this sheet.");
    }

    @Override // org.apache.poi.ss.usermodel.Sheet
    public Iterator<Row> rowIterator() {
        return this._rows.values().iterator();
    }

    public void setSelected(boolean r4) {
        en[] r3 = getSheetTypeSheetViews(true).getSheetViewArray();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].setTabSelected(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // org.apache.poi.ss.usermodel.Sheet, java.lang.Iterable
    public Spliterator<Row> spliterator() {
        return this._rows.values().spliterator();
    }

    public void write(OutputStream r12) {
        int r1 = 0;
        if (this.worksheet.sizeOfColsArray() != 1) goto L8;
        af r0 = this.worksheet.getColsArray(0);
        if (r0.sizeOfColArray() != 0) goto L7;
        this.worksheet.setColsArray(null);
        boolean r2 = true;
    L10:
        if (this.hyperlinks.isEmpty() == true) goto L19;
        if (this.worksheet.getHyperlinks() != null) goto L14;
        this.worksheet.addNewHyperlinks();
    L14:
        int r3 = this.hyperlinks.size();
        cg[] r5 = new cg[r3];
    L15:
        if (r1 >= r3) goto L17;
        XSSFHyperlink r6 = (XSSFHyperlink) ZeusTransformUtils.preCheckCast(this.hyperlinks.get(r1), XSSFHyperlink.class, "com.obric.memorydata.plugin");
        r6.generateRelationIfNeeded(getPackagePart());
        r5[r1] = r6.getCTHyperlink();
        r1 = r1 + 1;
        goto L15
    L17:
        this.worksheet.getHyperlinks().setHyperlinkArray(r5);
    L24:
        CellRangeAddress r4 = this.dimensionOverride;
        if (r4 != null) goto L37;
        int r7 = Integer.MIN_VALUE;
        Iterator<Map.Entry<Integer, XSSFRow>> r8 = this._rows.entrySet().iterator();
        int r9 = Integer.MAX_VALUE;
    L28:
        if (r8.hasNext() == false) goto L35;
        XSSFRow r10 = (XSSFRow) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), XSSFRow.class, "com.obric.memorydata.plugin");
        r10.onDocumentWrite();
        if (r10.getFirstCellNum() == (-1)) goto L33;
        r9 = Math.min(r9, r10.getFirstCellNum());
    L33:
        if (r10.getLastCellNum() == (-1)) goto L28;
        r7 = Math.max(r7, r10.getLastCellNum() - 1);
        goto L28
    L35:
        if (r9 == Integer.MAX_VALUE) goto L37;
        r4 = new CellRangeAddress(getFirstRowNum(), getLastRowNum(), r9, r7);
    L37:
        if (r4 != null) goto L39;
    L43:
        XmlOptions r11 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r11.setSaveSyntheticDocumentElement(new QName(fm.f19698b.getName().getNamespaceURI(), "worksheet"));
        this.worksheet.save(r12, r11);
        if (r2 == false) goto L54;
        this.worksheet.addNewCols();
        return;
    L54:
        return;
    L39:
        if (this.worksheet.isSetDimension() == false) goto L41;
        ej r13 = this.worksheet.getDimension();
    L42:
        r13.setRef(r4.formatAsString());
        goto L43
    L41:
        r13 = this.worksheet.addNewDimension();
        goto L42
    L19:
        if (this.worksheet.getHyperlinks() == null) goto L24;
        int r14 = this.worksheet.getHyperlinks().sizeOfHyperlinkArray() - 1;
    L21:
        if (r14 < 0) goto L23;
        this.worksheet.getHyperlinks().removeHyperlink(r14);
        r14 = r14 - 1;
        goto L21
    L23:
        this.worksheet.unsetHyperlinks();
        goto L24
    L7:
        setColWidthAttribute(r0);
    L8:
        r2 = false;
        goto L10
    }
}
