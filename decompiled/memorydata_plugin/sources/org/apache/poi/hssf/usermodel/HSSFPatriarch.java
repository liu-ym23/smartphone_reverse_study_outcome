package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import org.apache.poi.ddf.EscherComplexProperty;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherDgRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperty;
import org.apache.poi.ddf.EscherSpgrRecord;
import org.apache.poi.hssf.model.DrawingManager2;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFPatriarch implements HSSFShapeContainer, Drawing<HSSFShape> {
    private EscherAggregate _boundAggregate;
    private final EscherContainerRecord _mainSpgrContainer;
    private final List<HSSFShape> _shapes;
    private final HSSFSheet _sheet;
    private final EscherSpgrRecord _spgrRecord;

    HSSFPatriarch(HSSFSheet r3, EscherAggregate r4) {
        this._shapes = new ArrayList();
        this._sheet = r3;
        this._boundAggregate = r4;
        this._mainSpgrContainer = (EscherContainerRecord) ZeusTransformUtils.preCheckCast(r4.getEscherContainer().getChildContainers().get(0), EscherContainerRecord.class, "com.obric.memorydata.plugin");
        this._spgrRecord = (EscherSpgrRecord) ZeusTransformUtils.preCheckCast(((EscherContainerRecord) ZeusTransformUtils.preCheckCast(((EscherContainerRecord) ZeusTransformUtils.preCheckCast(this._boundAggregate.getEscherContainer().getChildContainers().get(0), EscherContainerRecord.class, "com.obric.memorydata.plugin")).getChild(0), EscherContainerRecord.class, "com.obric.memorydata.plugin")).getChildById(EscherSpgrRecord.RECORD_ID), EscherSpgrRecord.class, "com.obric.memorydata.plugin");
        buildShapeTree();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public void addShape(HSSFShape r1) {
        r1.setPatriarch(this);
        this._shapes.add(r1);
    }

    void afterCreate() {
        DrawingManager2 r0 = this._sheet.getWorkbook().getWorkbook().getDrawingManager();
        short r1 = r0.findNewDrawingGroupId();
        this._boundAggregate.setDgId(r1);
        this._boundAggregate.setMainSpRecordId(newShapeId());
        r0.incrementDrawingsSaved();
    }

    void buildShapeTree() {
        EscherContainerRecord r0 = this._boundAggregate.getEscherContainer();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = 0;
        List<EscherContainerRecord> r2 = ((EscherContainerRecord) ZeusTransformUtils.preCheckCast(r0.getChildContainers().get(0), EscherContainerRecord.class, "com.obric.memorydata.plugin")).getChildContainers();
    L7:
        if (r1 >= r2.size()) goto L12;
        EscherContainerRecord r3 = (EscherContainerRecord) ZeusTransformUtils.preCheckCast(r2.get(r1), EscherContainerRecord.class, "com.obric.memorydata.plugin");
        if (r1 == 0) goto L11;
        HSSFShapeFactory.createShapeTree(r3, this._boundAggregate, this, this._sheet.getWorkbook().getDirectory());
    L11:
        r1 = r1 + 1;
        goto L7
    }

    public boolean containsChart() {
        EscherOptRecord r5 = (EscherOptRecord) ZeusTransformUtils.preCheckCast(this._boundAggregate.findFirstWithId(EscherOptRecord.RECORD_ID), EscherOptRecord.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return false;
    L5:
        Iterator<EscherProperty> r6 = r5.getEscherProperties().iterator();
    L7:
        if (r6.hasNext() == false) goto L16;
        EscherProperty r2 = (EscherProperty) ZeusTransformUtils.preCheckCast(r6.next(), EscherProperty.class, "com.obric.memorydata.plugin");
        if (r2.getPropertyNumber() != 896) goto L7;
        if (r2.isComplex() == false) goto L7;
        if (StringUtil.getFromUnicodeLE(((EscherComplexProperty) ZeusTransformUtils.preCheckCast(r2, EscherComplexProperty.class, "com.obric.memorydata.plugin")).getComplexData()).equals("Chart 1\u0000") == false) goto L7;
        return true;
    L16:
        return false;
    }

    public List<HSSFShape> getChildren() {
        return Collections.unmodifiableList(this._shapes);
    }

    @Override // java.lang.Iterable
    public Iterator<HSSFShape> iterator() {
        return this._shapes.iterator();
    }

    int newShapeId() {
        return this._sheet.getWorkbook().getWorkbook().getDrawingManager().allocateShapeId((EscherDgRecord) ZeusTransformUtils.preCheckCast(this._boundAggregate.getEscherContainer().getChildById(EscherDgRecord.RECORD_ID), EscherDgRecord.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.lang.Iterable
    public Spliterator<HSSFShape> spliterator() {
        return this._shapes.spliterator();
    }
}
