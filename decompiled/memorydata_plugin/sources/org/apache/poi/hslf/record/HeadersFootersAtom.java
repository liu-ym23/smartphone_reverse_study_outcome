package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class HeadersFootersAtom extends RecordAtom {
    private static final int[] PLACEHOLDER_MASKS = null;
    private static final String[] PLACEHOLDER_NAMES = null;
    private final byte[] _header;
    private final byte[] _recdata;

    static {
        PLACEHOLDER_MASKS = new int[]{1, 2, 4, 8, 16, 32};
        PLACEHOLDER_NAMES = new String[]{"DATE", "TODAY_DATE", "USER_DATE", "SLIDE_NUMBER", "HEADER", "FOOTER"};
    }

    public HeadersFootersAtom() {
        byte[] r1 = new byte[4];
        this._recdata = r1;
        byte[] r2 = new byte[8];
        this._header = r2;
        LittleEndian.putShort(r2, 2, (short) getRecordType());
        LittleEndian.putInt(r2, 4, r1.length);
    }

    HeadersFootersAtom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._recdata = IOUtils.safelyClone(r2, r0, r4 - 8, getMaxRecordLength());
    }

    public boolean getFlag(int r1) {
        if ((getMask() & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getFormatId() {
        return LittleEndian.getShort(this._recdata, 0);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("formatIndex", new $$Lambda$MAegLAihXMCJgLYdcuzfDtGa5fs(this), "flags", GenericRecordUtil.getBitsAsString(new $$Lambda$h45VvZrfVgPFO7859KTHGSQZrmc(this), PLACEHOLDER_MASKS, PLACEHOLDER_NAMES));
    }

    public int getMask() {
        return LittleEndian.getShort(this._recdata, 2);
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.HeadersFootersAtom.typeID;
    }

    public String toString() {
        return "HeadersFootersAtom\n\tFormatId: " + getFormatId() + "\n\tMask    : " + getMask() + "\n\t  fHasDate        : " + getFlag(1) + "\n\t  fHasTodayDate   : " + getFlag(2) + "\n\t  fHasUserDate    : " + getFlag(4) + "\n\t  fHasSlideNumber : " + getFlag(8) + "\n\t  fHasHeader      : " + getFlag(16) + "\n\t  fHasFooter      : " + getFlag(32) + "\n";
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._recdata);
    }
}
