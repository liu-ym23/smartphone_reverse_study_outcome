package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.p;
import com.microsoft.schemas.office.visio.x2012.main.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xdgf.usermodel.XDGFSheet;
import org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow;

/* JADX INFO: loaded from: classes7.dex */
public class GeometrySection extends XDGFSection {
    SortedMap<Long, GeometryRow> _rows;

    public GeometrySection(q r6, XDGFSheet r7) {
        q r8 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.memorydata.plugin");
        super(r8, r7);
        this._rows = new TreeMap();
        p[] r9 = r8.getRowArray();
        int r10 = r9.length;
        int r0 = 0;
    L3:
        if (r0 >= r10) goto L9;
        p r1 = r9[r0];
        if (this._rows.containsKey(Long.valueOf(r1.getIX())) == true) goto L8;
        this._rows.put(Long.valueOf(r1.getIX()), GeometryRowTypes.load(r1));
        r0 = r0 + 1;
        goto L3
    L8:
        throw new POIXMLException("Index element '" + r1.getIX() + "' already exists");
    }
}
