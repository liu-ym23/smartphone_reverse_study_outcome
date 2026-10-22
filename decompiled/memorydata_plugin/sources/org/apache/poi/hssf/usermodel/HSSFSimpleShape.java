package org.apache.poi.hssf.usermodel;

import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.TextObjectRecord;

/* JADX INFO: loaded from: classes7.dex */
public class HSSFSimpleShape extends HSSFShape {
    private TextObjectRecord _textObjectRecord;

    public HSSFSimpleShape(EscherContainerRecord r1, ObjRecord r2) {
        super(r1, r2);
    }

    public HSSFSimpleShape(EscherContainerRecord r1, ObjRecord r2, TextObjectRecord r3) {
        super(r1, r2);
        this._textObjectRecord = r3;
    }

    public HSSFRichTextString getString() {
        return this._textObjectRecord.getStr();
    }
}
