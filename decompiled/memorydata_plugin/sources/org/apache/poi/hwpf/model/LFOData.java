package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class LFOData {
    private int _cp;
    private ListFormatOverrideLevel[] _rgLfoLvl;

    public LFOData() {
        this._cp = 0;
        this._rgLfoLvl = new ListFormatOverrideLevel[0];
    }

    LFOData(byte[] r4, int r5, int r6) {
        if (r6 < 0) goto L9;
        this._cp = LittleEndian.getInt(r4, r5);
        int r7 = r5 + 4;
        this._rgLfoLvl = new ListFormatOverrideLevel[r6];
        int r0 = 0;
    L5:
        if (r0 >= r6) goto L7;
        this._rgLfoLvl[r0] = new ListFormatOverrideLevel(r4, r7);
        r7 = r7 + this._rgLfoLvl[r0].getSizeInBytes();
        r0 = r0 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new IllegalArgumentException("Cannot create LFOData with negative count");
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L15:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L15;
        LFOData r5 = (LFOData) ZeusTransformUtils.preCheckCast(r4, LFOData.class, "com.obric.memorydata.plugin");
        if (this._cp == r5._cp) goto L14;
        return false;
    L14:
        return Arrays.equals(this._rgLfoLvl, r5._rgLfoLvl);
    }

    public int getSizeInBytes() {
        ListFormatOverrideLevel[] r4 = this._rgLfoLvl;
        int r0 = r4.length;
        int r1 = 4;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = r1 + r4[r2].getSizeInBytes();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public int hashCode() {
        return Arrays.deepHashCode(this._rgLfoLvl);
    }
}
