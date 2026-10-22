package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.sl.usermodel.ShapeContainer;
import org.apache.poi.sl.usermodel.SimpleShape;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HSLFSimpleShape extends HSLFShape implements SimpleShape<HSLFShape, HSLFTextParagraph> {
    protected static final EscherPropertyTypes[] ADJUST_VALUES = null;
    private static final c LOG = null;
    protected HSLFHyperlink _hyperlink;

    static {
        LOG = b.a(HSLFSimpleShape.class);
        ADJUST_VALUES = new EscherPropertyTypes[]{EscherPropertyTypes.GEOMETRY__ADJUSTVALUE, EscherPropertyTypes.GEOMETRY__ADJUST2VALUE, EscherPropertyTypes.GEOMETRY__ADJUST3VALUE, EscherPropertyTypes.GEOMETRY__ADJUST4VALUE, EscherPropertyTypes.GEOMETRY__ADJUST5VALUE, EscherPropertyTypes.GEOMETRY__ADJUST6VALUE, EscherPropertyTypes.GEOMETRY__ADJUST7VALUE, EscherPropertyTypes.GEOMETRY__ADJUST8VALUE, EscherPropertyTypes.GEOMETRY__ADJUST9VALUE, EscherPropertyTypes.GEOMETRY__ADJUST10VALUE};
    }

    public HSLFSimpleShape(EscherContainerRecord r3, ShapeContainer<HSLFShape, HSLFTextParagraph> r4) {
        super(r3, (ShapeContainer) ZeusTransformUtils.wrapperContextForParams(r4, ShapeContainer.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.poi.hslf.usermodel.HSLFShape
    public EscherContainerRecord createSpContainer(boolean r5) {
        EscherContainerRecord r4 = super.createSpContainer(r5);
        r4.setRecordId(EscherContainerRecord.SP_CONTAINER);
        EscherSpRecord r0 = new EscherSpRecord();
        if (r5 == false) goto L5;
        int r1 = 2562;
    L6:
        r0.setFlags(r1);
        r4.addChildRecord(r0);
        EscherOptRecord r2 = new EscherOptRecord();
        r2.setRecordId(EscherOptRecord.RECORD_ID);
        r4.addChildRecord(r2);
        if (r5 == false) goto L9;
        EscherRecord r6 = new EscherChildAnchorRecord();
    L10:
        r4.addChildRecord(r6);
        return r4;
    L9:
        r6 = new EscherClientAnchorRecord();
        byte[] r3 = new byte[16];
        LittleEndian.putUShort(r3, 0, 0);
        LittleEndian.putUShort(r3, 2, 0);
        LittleEndian.putInt(r3, 4, 8);
        r6.fillFields(r3, 0, null);
        goto L10
    L5:
        r1 = 2560;
        goto L6
    }

    public void setHyperlink(HSLFHyperlink r1) {
        this._hyperlink = r1;
    }
}
