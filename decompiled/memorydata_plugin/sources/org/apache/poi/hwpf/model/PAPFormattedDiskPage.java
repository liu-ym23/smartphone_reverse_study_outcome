package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class PAPFormattedDiskPage extends FormattedDiskPage {
    private ArrayList<PAPX> _papxList;

    public PAPFormattedDiskPage() {
        this._papxList = new ArrayList();
    }

    public PAPFormattedDiskPage(byte[] r12, byte[] r13, int r14, CharIndexTranslator r15) {
        CharIndexTranslator r16 = (CharIndexTranslator) ZeusTransformUtils.wrapperContextForParams(r15, CharIndexTranslator.class, "com.obric.memorydata.plugin");
        super(r12, r14);
        this._papxList = new ArrayList();
        int r17 = 0;
    L4:
        if (r17 >= this._crun) goto L9;
        int[][] r0 = r16.getCharIndexRanges(getStart(r17), getEnd(r17));
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        int[] r3 = r0[r2];
        this._papxList.add(new PAPX(r3[0], r3[1], getGrpprl(r17), getParagraphHeight(r17), r13));
        r2 = r2 + 1;
        goto L6
    L8:
        r17 = r17 + 1;
        goto L4
    L9:
        this._fkp = null;
    }

    private ParagraphHeight getParagraphHeight(int r3) {
        int r0 = (this._offset + 1) + (((this._crun + 1) * 4) + (r3 * 13));
        return new ParagraphHeight(this._fkp, r0);
    }

    public byte[] getGrpprl(int r4) {
        int r5 = LittleEndian.getUByte(this._fkp, this._offset + (((this._crun + 1) * 4) + (r4 * 13))) * 2;
        int r0 = LittleEndian.getUByte(this._fkp, this._offset + r5) * 2;
        if (r0 != 0) goto L5;
        r5 = r5 + 1;
        int r1 = LittleEndian.getUByte(this._fkp, this._offset + r5) * 2;
    L7:
        return IOUtils.safelyClone(this._fkp, (this._offset + r5) + 1, r1, 512);
    L5:
        r1 = r0 - 1;
        goto L7
    }

    public List<PAPX> getPAPXs() {
        return Collections.unmodifiableList(this._papxList);
    }
}
