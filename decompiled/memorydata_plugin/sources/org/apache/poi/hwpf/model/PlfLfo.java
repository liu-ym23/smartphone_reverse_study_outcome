package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hwpf.model.types.LFOAbstractType;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class PlfLfo {
    private static final c LOGGER = null;
    private int _lfoMac;
    private LFO[] _rgLfo;
    private LFOData[] _rgLfoData;

    static {
        LOGGER = b.a(PlfLfo.class);
    }

    PlfLfo(byte[] r6, int r7, int r8) {
        long r0 = LittleEndian.getUInt(r6, r7);
        int r2 = r7 + 4;
        if (r0 > 2147483647L) goto L16;
        IOUtils.safelyAllocateCheck(r0, 100000);
        int r1 = (int) r0;
        this._lfoMac = r1;
        this._rgLfo = new LFO[r1];
        this._rgLfoData = new LFOData[r1];
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r4 >= this._lfoMac) goto L9;
        LFO r5 = new LFO(r6, r2);
        r2 = r2 + LFOAbstractType.getSize();
        this._rgLfo[r4] = r5;
        r4 = r4 + 1;
    L9:
        if (r3 >= this._lfoMac) goto L11;
        LFOData r9 = new LFOData(r6, r2, this._rgLfo[r3].getClfolvl());
        r2 = r2 + r9.getSizeInBytes();
        this._rgLfoData[r3] = r9;
        r3 = r3 + 1;
        goto L9
    L11:
        int r10 = r2 - r7;
        if (r10 == r8) goto L19;
        LOGGER.atWarn().a("Actual size of PlfLfo is {} bytes, but expected {}", v.a(r10), v.a(r8));
        return;
    L19:
        return;
    L16:
        throw new UnsupportedOperationException("Apache POI doesn't support rgLfo/rgLfoData size large than 2147483647 elements");
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
        PlfLfo r6 = (PlfLfo) ZeusTransformUtils.preCheckCast(r5, PlfLfo.class, "com.obric.memorydata.plugin");
        if (this._lfoMac != r6._lfoMac) goto L19;
        if (Arrays.equals(this._rgLfo, r6._rgLfo) == false) goto L19;
        if (Arrays.equals(this._rgLfoData, r6._rgLfoData) == false) goto L19;
        return true;
    L19:
        return false;
    }

    public LFO getLfo(int r4) {
        if (r4 <= 0) goto L8;
        if (r4 > this._lfoMac) goto L8;
        return this._rgLfo[r4 - 1];
    L8:
        throw new NoSuchElementException("LFO with ilfo " + r4 + " not found. lfoMac is " + this._lfoMac);
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{Integer.valueOf(this._lfoMac), this._rgLfo, this._rgLfoData});
    }
}
