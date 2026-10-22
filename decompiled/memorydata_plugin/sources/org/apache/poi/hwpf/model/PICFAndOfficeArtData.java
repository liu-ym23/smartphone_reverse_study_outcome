package org.apache.poi.hwpf.model;

import java.util.LinkedList;
import java.util.List;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.types.PICFAbstractType;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class PICFAndOfficeArtData {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final List<EscherRecord> _blipRecords;
    private final PICF _picf;
    private final EscherContainerRecord _shape;
    private byte[] _stPicName;

    static {
    }

    public PICFAndOfficeArtData(byte[] r6, int r7) {
        this._blipRecords = new LinkedList();
        EscherContainerRecord r0 = new EscherContainerRecord();
        this._shape = r0;
        PICF r1 = new PICF(r6, r7);
        this._picf = r1;
        int r2 = PICFAbstractType.getSize() + r7;
        if (r1.getMm() != 102) goto L5;
        short r3 = LittleEndian.getUByte(r6, r2);
        int r4 = r2 + 1;
        this._stPicName = IOUtils.safelyClone(r6, r4, r3, HWPFDocument.getMaxRecordLength());
        r2 = r4 + r3;
    L5:
        DefaultEscherRecordFactory r5 = new DefaultEscherRecordFactory();
        int r8 = r2 + r0.fillFields(r6, r2, r5);
    L7:
        if ((r8 - r7) >= this._picf.getLcb()) goto L16;
        EscherRecord r9 = r5.createRecord(r6, r8);
        if (r9.getRecordId() == (-4089)) goto L15;
        if (r9.getRecordId() < (-4072)) goto L22;
        if (r9.getRecordId() <= (-3817)) goto L15;
        return;
    L22:
        return;
    L15:
        r8 = r8 + r9.fillFields(r6, r8, r5);
        this._blipRecords.add(r9);
        goto L7
    }

    public List<EscherRecord> getBlipRecords() {
        return this._blipRecords;
    }

    public PICF getPicf() {
        return this._picf;
    }
}
