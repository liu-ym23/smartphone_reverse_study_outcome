package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.sprm.SprmBuffer;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class CHPFormattedDiskPage extends FormattedDiskPage {
    private ArrayList<CHPX> _chpxList;

    public CHPFormattedDiskPage() {
        this._chpxList = new ArrayList();
    }

    public CHPFormattedDiskPage(byte[] r9, int r10, CharIndexTranslator r11) {
        CharIndexTranslator r12 = (CharIndexTranslator) ZeusTransformUtils.wrapperContextForParams(r11, CharIndexTranslator.class, "com.obric.memorydata.plugin");
        super(r9, r10);
        this._chpxList = new ArrayList();
        int r13 = 0;
    L4:
        if (r13 >= this._crun) goto L9;
        int[][] r0 = r12.getCharIndexRanges(getStart(r13), getEnd(r13));
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        int[] r3 = r0[r2];
        this._chpxList.add(new CHPX(r3[0], r3[1], new SprmBuffer(getGrpprl(r13), 0)));
        r2 = r2 + 1;
        goto L6
    L8:
        r13 = r13 + 1;
        goto L4
    }

    public List<CHPX> getCHPXs() {
        return Collections.unmodifiableList(this._chpxList);
    }

    public byte[] getGrpprl(int r4) {
        int r5 = LittleEndian.getUByte(this._fkp, this._offset + (((this._crun + 1) * 4) + r4)) * 2;
        if (r5 == 0) goto L5;
        short r0 = LittleEndian.getUByte(this._fkp, this._offset + r5);
        return IOUtils.safelyClone(this._fkp, (this._offset + r5) + 1, r0, HWPFDocument.getMaxRecordLength());
    L5:
        return new byte[0];
    }
}
