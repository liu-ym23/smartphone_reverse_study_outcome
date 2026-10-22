package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherContainerRecord;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HSSFAnchor {
    public HSSFAnchor() {
        createEscherAnchor();
    }

    public static HSSFAnchor createAnchorFromEscher(EscherContainerRecord r3) {
        if (r3.getChildById(EscherChildAnchorRecord.RECORD_ID) == null) goto L7;
        return new HSSFChildAnchor((EscherChildAnchorRecord) ZeusTransformUtils.preCheckCast(r3.getChildById(EscherChildAnchorRecord.RECORD_ID), EscherChildAnchorRecord.class, "com.obric.memorydata.plugin"));
    L7:
        if (r3.getChildById(EscherClientAnchorRecord.RECORD_ID) != null) goto L9;
        return null;
    L9:
        return new HSSFClientAnchor((EscherClientAnchorRecord) ZeusTransformUtils.preCheckCast(r3.getChildById(EscherClientAnchorRecord.RECORD_ID), EscherClientAnchorRecord.class, "com.obric.memorydata.plugin"));
    }

    public abstract void createEscherAnchor();
}
