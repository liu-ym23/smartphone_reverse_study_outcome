package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.a;
import com.microsoft.schemas.office.visio.x2012.main.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFSheet;

/* JADX INFO: loaded from: classes7.dex */
public class CharacterSection extends XDGFSection {
    Map<String, XDGFCell> _characterCells;
    Color _fontColor;
    Double _fontSize;

    public CharacterSection(q r6, XDGFSheet r7) {
        q r8 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.memorydata.plugin");
        super(r8, r7);
        this._characterCells = new HashMap();
        int r9 = 0;
        a[] r10 = r8.getRowArray(0).getCellArray();
        int r0 = r10.length;
    L3:
        if (r9 >= r0) goto L5;
        a r1 = r10[r9];
        this._characterCells.put(r1.getN(), new XDGFCell(r1));
        r9 = r9 + 1;
        goto L3
    L5:
        this._fontSize = XDGFCell.maybeGetDouble(this._characterCells, "Size");
        String r11 = XDGFCell.maybeGetString(this._characterCells, "Color");
        if (r11 == null) goto L10;
        this._fontColor = Color.decode(r11);
        return;
    }
}
