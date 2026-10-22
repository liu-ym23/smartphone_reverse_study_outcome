package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.hslf.record.PPDrawing;
import org.apache.poi.hslf.record.SheetContainer;
import org.apache.poi.sl.usermodel.Sheet;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HSLFSheet implements HSLFShapeContainer, Sheet<HSLFShape, HSLFTextParagraph> {
    private final SheetContainer _container;
    private final int _sheetNo;
    private HSLFSlideShow _slideShow;

    public HSLFSheet(SheetContainer r1, int r2) {
        this._container = r1;
        this._sheetNo = r2;
    }

    public int _getSheetNumber() {
        return this._sheetNo;
    }

    public PPDrawing getPPDrawing() {
        return this._container.getPPDrawing();
    }

    @Override // org.apache.poi.sl.usermodel.ShapeContainer
    public List<HSLFShape> getShapes() {
        Iterator<EscherRecord> r0 = getPPDrawing().getDgContainer().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        EscherRecord r1 = (EscherRecord) ZeusTransformUtils.preCheckCast(r0.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        if (r1.getRecordId() != EscherContainerRecord.SPGR_CONTAINER) goto L4;
        EscherContainerRecord r2 = (EscherContainerRecord) ZeusTransformUtils.preCheckCast(r1, EscherContainerRecord.class, "com.obric.memorydata.plugin");
    L9:
        if (r2 == null) goto L24;
        ArrayList r3 = new ArrayList();
        boolean r4 = true;
        Iterator<EscherRecord> r5 = r2.iterator();
    L12:
        if (r5.hasNext() == false) goto L22;
        EscherRecord r6 = (EscherRecord) ZeusTransformUtils.preCheckCast(r5.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        if (r4 == true) goto L15;
        HSLFShape r7 = HSLFShapeFactory.createShape((EscherContainerRecord) ZeusTransformUtils.preCheckCast(r6, EscherContainerRecord.class, "com.obric.memorydata.plugin"), null);
        r7.setSheet(this);
        if (ZeusTransformUtils.instanceOf(r7, HSLFSimpleShape.class) == false) goto L21;
        HSLFHyperlink r8 = HSLFHyperlink.find(r7);
        if (r8 == null) goto L21;
        ((HSLFSimpleShape) ZeusTransformUtils.preCheckCast(r7, HSLFSimpleShape.class, "com.obric.memorydata.plugin")).setHyperlink(r8);
    L21:
        r3.add(r7);
        goto L12
    L15:
        r4 = false;
        goto L12
    L22:
        return r3;
    L24:
        throw new IllegalStateException("spgr not found");
    L8:
        r2 = null;
        goto L9
    }

    public SheetContainer getSheetContainer() {
        return this._container;
    }

    public HSLFSlideShow getSlideShow() {
        return this._slideShow;
    }

    public abstract List<List<HSLFTextParagraph>> getTextParagraphs();

    @Override // java.lang.Iterable
    public Iterator<HSLFShape> iterator() {
        return getShapes().iterator();
    }

    public void setSlideShow(HSLFSlideShow r4) {
        if (this._slideShow != null) goto L13;
        this._slideShow = r4;
        List<List<HSLFTextParagraph>> r5 = getTextParagraphs();
        if (r5 != null) goto L7;
        return;
    L7:
        Iterator<List<HSLFTextParagraph>> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        List r0 = (List) ZeusTransformUtils.preCheckCast(r6.next(), List.class, "com.obric.memorydata.plugin");
        HSLFTextParagraph.supplySheet(r0, this);
        HSLFTextParagraph.applyHyperlinks(r0);
        goto L9
    L11:
        return;
    L13:
        throw new HSLFException("Can't change existing slideshow reference");
    }

    @Override // java.lang.Iterable
    public Spliterator<HSLFShape> spliterator() {
        return getShapes().spliterator();
    }
}
