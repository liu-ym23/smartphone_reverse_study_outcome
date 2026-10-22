package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class Xst {
    private int _cch;
    private char[] _rgtchar;

    public Xst() {
        this._cch = 0;
        this._rgtchar = new char[0];
    }

    public Xst(byte[] r4, int r5) {
        int r0 = LittleEndian.getUShort(r4, r5);
        this._cch = r0;
        int r6 = r5 + 2;
        this._rgtchar = new char[r0];
        int r1 = 0;
    L4:
        if (r1 >= this._cch) goto L6;
        this._rgtchar[r1] = (char) LittleEndian.getShort(r4, r6);
        r6 = r6 + 2;
        r1 = r1 + 1;
        goto L4
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        Xst r6 = (Xst) ZeusTransformUtils.preCheckCast(r5, Xst.class, "com.obric.memorydata.plugin");
        if (this._cch == r6._cch) goto L15;
        return false;
    L15:
        if (Arrays.equals(this._rgtchar, r6._rgtchar) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int getCch() {
        return this._cch;
    }

    public int getSize() {
        return (this._rgtchar.length * 2) + 2;
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{Integer.valueOf(this._cch), this._rgtchar});
    }

    public String toString() {
        return "Xst [" + this._cch + "; " + Arrays.toString(this._rgtchar) + "]";
    }
}
