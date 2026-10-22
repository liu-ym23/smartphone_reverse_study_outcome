package org.apache.poi.xssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.dw;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.n;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ParagraphPropertyFetcher<T> {
    private int _level;
    private T _value;

    public ParagraphPropertyFetcher(int r1) {
        this._level = r1;
    }

    public abstract boolean fetch(dw r1);

    public boolean fetch(n r5) {
        XmlObject[] r6 = ((n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.memorydata.plugin")).selectPath("declare namespace xdr='http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//xdr:txBody/a:lstStyle/a:lvl" + (this._level + 1) + "pPr");
        if (r6.length == 1) goto L5;
        return false;
    L5:
        return fetch((dw) ZeusTransformUtils.preCheckCast(r6[0], dw.class, "com.obric.memorydata.plugin"));
    }

    public T getValue() {
        return this._value;
    }

    public void setValue(T r1) {
        this._value = r1;
    }
}
