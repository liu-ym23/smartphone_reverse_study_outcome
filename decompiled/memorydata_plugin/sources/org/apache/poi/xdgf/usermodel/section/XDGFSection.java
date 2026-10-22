package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.a;
import com.microsoft.schemas.office.visio.x2012.main.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFSheet;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XDGFSection {
    protected Map<String, XDGFCell> _cells;
    protected XDGFSheet _containingSheet;
    protected q _section;

    public XDGFSection(q r6, XDGFSheet r7) {
        q r8 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.memorydata.plugin");
        this._cells = new HashMap();
        this._section = r8;
        this._containingSheet = r7;
        a[] r9 = r8.getCellArray();
        int r10 = r9.length;
        int r0 = 0;
    L3:
        if (r0 >= r10) goto L5;
        a r1 = r9[r0];
        this._cells.put(r1.getN(), new XDGFCell(r1));
        r0 = r0 + 1;
        goto L3
    }

    public String toString() {
        return "<Section type=" + this._section.getN() + " from " + this._containingSheet + ">";
    }
}
