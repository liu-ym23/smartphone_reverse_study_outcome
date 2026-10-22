package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class ExEmbedAtom extends RecordAtom {
    private byte[] _data;
    private byte[] _header;

    public ExEmbedAtom() {
        byte[] r1 = new byte[8];
        this._header = r1;
        this._data = new byte[8];
        LittleEndian.putShort(r1, 2, (short) getRecordType());
        LittleEndian.putInt(this._header, 4, this._data.length);
    }

    public ExEmbedAtom(byte[] r3, int r4, int r5) {
        int r0 = r4 + 8;
        this._header = Arrays.copyOfRange(r3, r4, r0);
        byte[] r6 = IOUtils.safelyClone(r3, r0, r5 - 8, getMaxRecordLength());
        this._data = r6;
        if (r6.length < 8) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("The length of the data for a ExEmbedAtom must be at least 4 bytes, but was only " + this._data.length);
    }

    private String getFollowColorSchemeString() {
        int r1 = getFollowColorScheme();
        if (r1 != 1) goto L5;
        return "FOLLOWS_ENTIRE_COLOR_SCHEME";
    L5:
        if (r1 == 2) goto L8;
        return "DOES_NOT_FOLLOW_COLOR_SCHEME";
    L8:
        return "FOLLOWS_TEXT_AND_BACKGROUND_SCHEME";
    }

    public static /* synthetic */ String lambda$J988zxJZnHBq3ZU64Cwp6NaXtnc(ExEmbedAtom r0) {
        return r0.getFollowColorSchemeString();
    }

    public boolean getCantLockServerB() {
        if (this._data[4] == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getFollowColorScheme() {
        return LittleEndian.getInt(this._data, 0);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("followColorScheme", new $$Lambda$ExEmbedAtom$J988zxJZnHBq3ZU64Cwp6NaXtnc(this), "cantLockServer", new $$Lambda$Xf3l7uuyJ9E0M0k6Wvvs6t6MbpI(this), "noSizeToServer", new $$Lambda$iLZXWTVuDuDfDtRDiPRwBWvIcwU(this), "isTable", new $$Lambda$fdc34FEfzObl8cfpSG9SkGB3RrU(this));
    }

    public boolean getIsTable() {
        if (this._data[6] == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean getNoSizeToServerB() {
        if (this._data[5] == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.ExEmbedAtom.typeID;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._data);
    }
}
