package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Spliterator;
import org.apache.poi.ss.usermodel.ShapeContainer;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.h;

/* JADX INFO: loaded from: classes7.dex */
public final class XSSFShapeGroup extends XSSFShape implements ShapeContainer<XSSFShape> {
    private h ctGroup;

    public XSSFShapeGroup(XSSFDrawing r3, h r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        this.drawing = r3;
        this.ctGroup = r5;
    }

    public h getCTGroupShape() {
        return this.ctGroup;
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFShape> iterator() {
        return getDrawing().getShapes(this).iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<XSSFShape> spliterator() {
        return getDrawing().getShapes(this).spliterator();
    }
}
