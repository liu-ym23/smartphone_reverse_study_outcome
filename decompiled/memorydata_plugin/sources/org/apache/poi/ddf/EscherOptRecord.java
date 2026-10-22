package org.apache.poi.ddf;

/* JADX INFO: loaded from: classes6.dex */
public class EscherOptRecord extends AbstractEscherOptRecord {
    public static final String RECORD_DESCRIPTION = null;
    public static final short RECORD_ID = 0;

    static {
        RECORD_ID = EscherRecordTypes.OPT.typeID;
        RECORD_DESCRIPTION = EscherRecordTypes.OPT.description;
    }

    public EscherOptRecord() {
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return EscherRecordTypes.OPT;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getInstance() {
        setInstance((short) getEscherProperties().size());
        return super.getInstance();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getOptions() {
        getInstance();
        getVersion();
        return super.getOptions();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public short getVersion() {
        setVersion(3);
        return super.getVersion();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public void setVersion(short r2) {
        if (r2 != 3) goto L7;
        super.setVersion(r2);
        return;
    L7:
        throw new IllegalArgumentException(RECORD_DESCRIPTION + " can have only '0x3' version");
    }
}
