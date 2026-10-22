package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.usermodel.TableStyleInfo;
import org.apache.poi.ss.util.CellReference;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ew;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ex;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ey;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.gs;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFTable extends POIXMLDocumentPart implements Table {
    private static final c LOG = null;
    private transient ConcurrentSkipListMap<String, Integer> columnMap;
    private transient String commonXPath;
    private ew ctTable;
    private transient CellReference endCellReference;
    private transient String name;
    private transient CellReference startCellReference;
    private transient List<XSSFTableColumn> tableColumns;
    private transient List<Object> xmlColumnPrs;

    static {
        LOG = b.a(XSSFTable.class);
    }

    public XSSFTable() {
        this.ctTable = (ew) ZeusTransformUtils.preCheckCast(ew.f19665a.newInstance(), ew.class, "com.obric.memorydata.plugin");
    }

    public XSSFTable(PackagePart r2) {
        super(r2);
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

    private void setCellReferences() {
        String r0 = this.ctTable.getRef();
        if (r0 == null) goto L10;
        String[] r1 = r0.split(ParameterizedMessage.ERROR_MSG_SEPARATOR, 2);
        String r3 = r1[0];
        if (r1.length != 2) goto L7;
        String r2 = r1[1];
    L8:
        this.startCellReference = new CellReference(r3);
        this.endCellReference = new CellReference(r2);
        return;
    L7:
        r2 = r1[0];
        goto L8
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

    @Override // org.apache.poi.ss.usermodel.Table
    public boolean contains(CellReference r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (getSheetName().equals(r4.getSheetName()) == true) goto L9;
        return false;
    L9:
        if (r4.getRow() >= getStartRowIndex()) goto L11;
        return false;
    L11:
        if (r4.getRow() <= getEndRowIndex()) goto L13;
        return false;
    L13:
        if (r4.getCol() >= getStartColIndex()) goto L15;
        return false;
    L15:
        if (r4.getCol() > getEndColIndex()) goto L21;
        return true;
    L21:
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int findColumnIndex(String r8) {
        if (r8 != null) goto L6;
        return -1;
    L6:
        if (this.columnMap != null) goto L11;
        this.columnMap = new ConcurrentSkipListMap(String.CASE_INSENSITIVE_ORDER);
        int r1 = 0;
        Iterator<XSSFTableColumn> r3 = getColumns().iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        String r4 = ((XSSFTableColumn) ZeusTransformUtils.preCheckCast(r3.next(), XSSFTableColumn.class, "com.obric.memorydata.plugin")).getName();
        this.columnMap.put(r4, Integer.valueOf(r1));
        r1 = r1 + 1;
    L11:
        String r9 = r8.replace("''", "'").replace("'#", "#");
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(this.columnMap.get(r9), Integer.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L15;
        return -1;
    L15:
        return r7.intValue();
    }

    public ew getCTTable() {
        return this.ctTable;
    }

    public List<XSSFTableColumn> getColumns() {
        if (this.tableColumns != null) goto L12;
        ArrayList r0 = new ArrayList();
        ey r1 = this.ctTable.getTableColumns();
        if (r1 == null) goto L10;
        Iterator<ex> r2 = r1.getTableColumnList().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r0.add(new XSSFTableColumn(this, (ex) ZeusTransformUtils.preCheckCast(r2.next(), ex.class, "com.obric.memorydata.plugin")));
    L10:
        this.tableColumns = Collections.unmodifiableList(r0);
    L12:
        return this.tableColumns;
    }

    public CellReference getEndCellReference() {
        if (this.endCellReference != null) goto L6;
        setCellReferences();
    L6:
        return this.endCellReference;
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getEndColIndex() {
        return getEndCellReference().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getEndRowIndex() {
        return getEndCellReference().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getHeaderRowCount() {
        return (int) this.ctTable.getHeaderRowCount();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public String getName() {
        if (this.name != null) goto L8;
        if (this.ctTable.getName() == null) goto L8;
        setName(this.ctTable.getName());
    L8:
        return this.name;
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public String getSheetName() {
        return getXSSFSheet().getSheetName();
    }

    public CellReference getStartCellReference() {
        if (this.startCellReference != null) goto L6;
        setCellReferences();
    L6:
        return this.startCellReference;
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getStartColIndex() {
        return getStartCellReference().getCol();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getStartRowIndex() {
        return getStartCellReference().getRow();
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public TableStyleInfo getStyle() {
        if (this.ctTable.isSetTableStyleInfo() == true) goto L7;
        return null;
    L7:
        return new XSSFTableStyleInfo(((XSSFSheet) ZeusTransformUtils.preCheckCast(getParent(), XSSFSheet.class, "com.obric.memorydata.plugin")).getWorkbook().getStylesSource(), this.ctTable.getTableStyleInfo());
    }

    @Override // org.apache.poi.ss.usermodel.Table
    public int getTotalsRowCount() {
        return (int) this.ctTable.getTotalsRowCount();
    }

    public XSSFSheet getXSSFSheet() {
        return (XSSFSheet) ZeusTransformUtils.preCheckCast(getParent(), XSSFSheet.class, "com.obric.memorydata.plugin");
    }

    public void readFrom(InputStream r3) {
        this.ctTable = ((gs) ZeusTransformUtils.preCheckCast(gs.f19757a.parse(r3, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), gs.class, "com.obric.memorydata.plugin")).getTable();     // Catch: XmlException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getLocalizedMessage());
    }

    public void setName(String r2) {
        if (r2 != null) goto L6;
        this.ctTable.unsetName();
        r2 = null;
    L4:
        this.name = r2;
        return;
    L6:
        this.ctTable.setName(r2);
        goto L4
    }

    public void updateHeaders() {
        XSSFSheet r0 = (XSSFSheet) ZeusTransformUtils.preCheckCast(getParent(), XSSFSheet.class, "com.obric.memorydata.plugin");
        CellReference r1 = getStartCellReference();
        if (r1 != null) goto L5;
        return;
    L5:
        int r3 = r1.getRow();
        int r2 = r1.getCol();
        XSSFRow r4 = r0.getRow(r3);
        DataFormatter r5 = new DataFormatter();
        if (r4 == null) goto L16;
        ey r6 = getCTTable().getTableColumns();
        if (r6 == null) goto L16;
        Iterator<ex> r7 = r6.getTableColumnList().iterator();
    L11:
        if (r7.hasNext() == false) goto L16;
        ex r8 = (ex) ZeusTransformUtils.preCheckCast(r7.next(), ex.class, "com.obric.memorydata.plugin");
        XSSFCell r9 = r4.getCell(r2);
        if (r9 == null) goto L15;
        r8.setName(r5.formatCellValue(r9).replace("\n", "_x000a_").replace("\r", "_x000d_"));
    L15:
        r2 = r2 + 1;
    L16:
        this.tableColumns = null;
        this.columnMap = null;
        this.xmlColumnPrs = null;
        this.commonXPath = null;
    }

    public void writeTo(OutputStream r4) {
        updateHeaders();
        gs r0 = (gs) ZeusTransformUtils.preCheckCast(gs.f19757a.newInstance(), gs.class, "com.obric.memorydata.plugin");
        r0.setTable(this.ctTable);
        r0.save(r4, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }
}
