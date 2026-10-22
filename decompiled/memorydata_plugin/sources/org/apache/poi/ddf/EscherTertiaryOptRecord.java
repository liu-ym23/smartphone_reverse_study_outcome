package org.apache.poi.ddf;

/* JADX INFO: loaded from: classes6.dex */
public class EscherTertiaryOptRecord extends AbstractEscherOptRecord {
    public static final short RECORD_ID = 0;

    static {
        RECORD_ID = EscherRecordTypes.USER_DEFINED.typeID;
    }

    public EscherTertiaryOptRecord() {
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.USER_DEFINED;
    }
}
