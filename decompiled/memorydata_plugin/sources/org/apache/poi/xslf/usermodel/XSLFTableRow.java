package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.openxmlformats.schemas.drawingml.x2006.main.cs;
import org.openxmlformats.schemas.drawingml.x2006.main.cy;

/* JADX INFO: loaded from: classes7.dex */
public class XSLFTableRow implements Iterable<XSLFTableCell> {
    private final List<XSLFTableCell> _cells;
    private final cy _row;
    private final XSLFTable _table;

    XSLFTableRow(cy r6, XSLFTable r7) {
        cy r8 = (cy) ZeusTransformUtils.wrapperContextForParams(r6, cy.class, "com.obric.memorydata.plugin");
        this._row = r8;
        this._table = r7;
        cs[] r9 = r8.getTcArray();
        this._cells = new ArrayList(r9.length);
        int r0 = r9.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        cs r2 = r9[r1];
        this._cells.add(new XSLFTableCell(r2, r7));
        r1 = r1 + 1;
        goto L3
    }

    public List<XSLFTableCell> getCells() {
        return Collections.unmodifiableList(this._cells);
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTableCell> iterator() {
        return this._cells.iterator();
    }
}
