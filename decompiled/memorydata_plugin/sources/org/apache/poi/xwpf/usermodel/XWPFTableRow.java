package org.apache.poi.xwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.cw;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.dd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.ew;

/* JADX INFO: loaded from: classes7.dex */
public class XWPFTableRow {
    private final cw ctRow;
    private final XWPFTable table;
    private List<XWPFTableCell> tableCells;

    public XWPFTableRow(cw r3, XWPFTable r4) {
        cw r5 = (cw) ZeusTransformUtils.wrapperContextForParams(r3, cw.class, "com.obric.memorydata.plugin");
        this.table = r4;
        this.ctRow = r5;
        getTableCells();
    }

    public XWPFTable getTable() {
        return this.table;
    }

    public List<XWPFTableCell> getTableCells() {
        if (this.tableCells != null) goto L9;
        ArrayList r0 = new ArrayList();
        ew[] r1 = this.ctRow.getTcArray();
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        r0.add(new XWPFTableCell(r1[r3], this, this.table.getBody()));
        r3 = r3 + 1;
        goto L5
    L7:
        this.tableCells = r0;
    L9:
        return this.tableCells;
    }

    public List<ICell> getTableICells() {
        ArrayList r0 = new ArrayList();
        XmlCursor r1 = this.ctRow.newCursor();
        r1.selectPath("./*");     // Catch: Throwable -> L18
    L4:
        if (r1.toNextSelection() == false) goto L15;
        XmlObject r2 = r1.getObject();     // Catch: Throwable -> L18
        if (ZeusTransformUtils.instanceOf(r2, ew.class) == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r2, dd.class) == false) goto L4;
        ICell r3 = new XWPFSDTCell((dd) ZeusTransformUtils.preCheckCast(r2, dd.class, "com.obric.memorydata.plugin"), this, this.table.getBody());     // Catch: Throwable -> L18
    L10:
        r0.add(r3);     // Catch: Throwable -> L18
        goto L4
    L9:
        r3 = new XWPFTableCell((ew) ZeusTransformUtils.preCheckCast(r2, ew.class, "com.obric.memorydata.plugin"), this, this.table.getBody());     // Catch: Throwable -> L18
        goto L10
    L15:
        if (r1 == null) goto L17;
        r1.close();
    L17:
        return r0;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (r1 != null) goto L27;
    L26:
        throw th;
    L27:
        r1.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);
        goto L26
    }
}
