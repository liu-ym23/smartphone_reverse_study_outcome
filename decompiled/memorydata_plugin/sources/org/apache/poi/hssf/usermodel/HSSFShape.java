package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.hssf.record.ObjRecord;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HSSFShape {
    private final EscherContainerRecord _escherContainer;
    private final ObjRecord _objRecord;
    private final EscherOptRecord _optRecord;
    private HSSFPatriarch _patriarch;
    HSSFAnchor anchor;
    private HSSFShape parent;

    public HSSFShape(EscherContainerRecord r3, ObjRecord r4) {
        this._escherContainer = r3;
        this._objRecord = r4;
        this._optRecord = (EscherOptRecord) ZeusTransformUtils.preCheckCast(r3.getChildById(EscherOptRecord.RECORD_ID), EscherOptRecord.class, "com.obric.memorydata.plugin");
        this.anchor = HSSFAnchor.createAnchorFromEscher(r3);
    }

    public HSSFPatriarch getPatriarch() {
        return this._patriarch;
    }

    public void setParent(HSSFShape r1) {
        this.parent = r1;
    }

    public void setPatriarch(HSSFPatriarch r1) {
        this._patriarch = r1;
    }
}
