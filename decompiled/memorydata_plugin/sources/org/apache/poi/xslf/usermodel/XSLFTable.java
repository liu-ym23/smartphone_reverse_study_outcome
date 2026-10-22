package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.sl.usermodel.TableCell;
import org.apache.poi.sl.usermodel.TableShape;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.ak;
import org.openxmlformats.schemas.drawingml.x2006.main.cr;
import org.openxmlformats.schemas.drawingml.x2006.main.cy;
import org.openxmlformats.schemas.presentationml.x2006.main.q;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFTable extends XSLFGraphicFrame implements Iterable<XSLFTableRow>, TableShape<XSLFShape, XSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    private final List<XSLFTableRow> _rows;
    private final cr _table;

    static {
        LOG = b.a(XSLFTable.class);
    }

    XSLFTable(q r4, XSLFSheet r5) {
        q r6 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.memorydata.plugin");
        super(r6, r5);
        ak r7 = r6.getGraphic().getGraphicData();
        XmlCursor r8 = r7.newCursor();
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r8 != null) goto L32;
    L28:
        throw th;
    L32:
        r8.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);
        goto L28
    L4:
        if (r8.toChild("http://schemas.openxmlformats.org/drawingml/2006/main", "tbl") == false) goto L19;
        XmlObject r9 = r8.getObject();     // Catch: Throwable -> L20
        if (ZeusTransformUtils.instanceOf(r9, XmlAnyTypeImpl.class) == true) goto L17;
        cr r10 = (cr) ZeusTransformUtils.preCheckCast(r9, cr.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        this._table = r10;     // Catch: Throwable -> L20
        if (r8 == null) goto L10;
        r8.close();
    L10:
        this._rows = new ArrayList(r10.sizeOfTrArray());
        Iterator<cy> r11 = r10.getTrList().iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        this._rows.add(new XSLFTableRow((cy) ZeusTransformUtils.preCheckCast(r11.next(), cy.class, "com.obric.memorydata.plugin"), this));
        goto L12
    L14:
        updateRowColIndexes();
        return;
    L17:
        throw new IllegalStateException("Schemas (*.xsb) for CTTable can't be loaded - usually this happens when OSGI loading is used and the thread context classloader has no reference to the xmlbeans classes");     // Catch: Throwable -> L20
    L19:
        throw new IllegalStateException("a:tbl element was not found in\n " + r7);     // Catch: Throwable -> L20
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public /* bridge */ /* synthetic */ TableCell getCell(int r1, int r2) {
        return getCell(r1, r2);
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public XSLFTableCell getCell(int r3, int r4) {
        if (r3 >= 0) goto L5;
    L17:
        return null;
    L5:
        if (this._rows.size() <= r3) goto L17;
        XSLFTableRow r2 = (XSLFTableRow) ZeusTransformUtils.preCheckCast(this._rows.get(r3), XSLFTableRow.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L10;
        return null;
    L10:
        List<XSLFTableCell> r5 = r2.getCells();
        if (r4 < 0) goto L17;
        if (r5.size() <= r4) goto L17;
        return (XSLFTableCell) ZeusTransformUtils.preCheckCast(r5.get(r4), XSLFTableCell.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public int getNumberOfColumns() {
        return this._table.getTblGrid().sizeOfGridColArray();
    }

    @Override // org.apache.poi.sl.usermodel.TableShape
    public int getNumberOfRows() {
        return this._table.sizeOfTrArray();
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTableRow> iterator() {
        return this._rows.iterator();
    }

    void updateRowColIndexes() {
        Iterator<XSLFTableRow> r7 = iterator();
        int r1 = 0;
    L4:
        if (r7.hasNext() == false) goto L10;
        Iterator<XSLFTableCell> r2 = ((XSLFTableRow) ZeusTransformUtils.preCheckCast(r7.next(), XSLFTableRow.class, "com.obric.memorydata.plugin")).iterator();
        int r3 = 0;
    L7:
        if (r2.hasNext() == false) goto L9;
        ((XSLFTableCell) ZeusTransformUtils.preCheckCast(r2.next(), XSLFTableCell.class, "com.obric.memorydata.plugin")).setRowColIndex(r1, r3);
        r3 = r3 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    }
}
