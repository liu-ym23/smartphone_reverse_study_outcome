package org.apache.poi.hwpf.model;

import java.util.Arrays;
import org.apache.logging.log4j.b;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class Sttb {
    private final int _cDataLength;
    private int _cbExtra;
    private String[] _data;
    private byte[][] _extraData;
    private final boolean _fExtend;

    public Sttb(int r2, byte[] r3, int r4) {
        this._fExtend = true;
        this._cDataLength = r2;
        fillFields(r3, r4);
    }

    public void fillFields(byte[] r7, int r8) {
        short r0 = LittleEndian.getShort(r7, r8);
        int r9 = r8 + 2;
        int r2 = 0;
        if (r0 == (-1)) goto L7;
        b.a(Sttb.class).atWarn().a("Non-extended character Pascal strings are not supported right now. Creating empty values in the RevisionMarkAuthorTable for now.  Please, contact POI developers for update.");
        this._data = new String[0];
        this._extraData = new byte[0][];
        return;
    L7:
        if (this._cDataLength != 2) goto L9;
        int r1 = LittleEndian.getUShort(r7, r9);
    L10:
        int r10 = r9 + this._cDataLength;
        this._cbExtra = LittleEndian.getUShort(r7, r10);
        int r11 = r10 + 2;
        this._data = new String[r1];
        this._extraData = new byte[r1][];
    L11:
        if (r2 >= r1) goto L17;
        short r3 = LittleEndian.getShort(r7, r11);
        r11 = r11 + 2;
        if (r3 < 0) goto L16;
        this._data[r2] = StringUtil.getFromUnicodeLE(r7, r11, r3);
        int r12 = r11 + (r3 * 2);
        this._extraData[r2] = Arrays.copyOfRange(r7, r12, this._cbExtra + r12);
        r11 = r12 + this._cbExtra;
    L16:
        r2 = r2 + 1;
        goto L11
    L17:
        return;
    L9:
        r1 = LittleEndian.getInt(r7, r9);
        goto L10
    }

    public String[] getData() {
        return this._data;
    }
}
