package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class SlideListWithText extends RecordContainer {
    private static final long _type = 0;
    private final byte[] _header;
    private SlideAtomsSet[] slideAtomsSets;

    public static class SlideAtomsSet {
        private final SlidePersistAtom slidePersistAtom;
        private final Record[] slideRecords;

        public SlideAtomsSet(SlidePersistAtom r2, Record[] r3) {
            this.slidePersistAtom = r2;
            this.slideRecords = (Record[]) ZeusTransformUtils.preCheckCast(r3.clone(), Record[].class, "com.obric.memorydata.plugin");
        }

        public SlidePersistAtom getSlidePersistAtom() {
            return this.slidePersistAtom;
        }

        public Record[] getSlideRecords() {
            return this.slideRecords;
        }
    }

    static {
        _type = RecordTypes.SlideListWithText.typeID;
    }

    public SlideListWithText() {
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putUShort(r0, 0, 15);
        LittleEndian.putUShort(r0, 2, (int) _type);
        LittleEndian.putInt(r0, 4, 0);
        this._children = new Record[0];
        this.slideAtomsSets = new SlideAtomsSet[0];
    }

    public SlideListWithText(byte[] r7, int r8, int r9) {
        int r0 = r8 + 8;
        this._header = Arrays.copyOfRange(r7, r8, r0);
        this._children = Record.findChildRecords(r7, r0, r9 - 8);
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L4:
        if (r11 >= this._children.length) goto L15;
        if (ZeusTransformUtils.instanceOf(this._children[r11], SlidePersistAtom.class) == false) goto L14;
        int r1 = r11 + 1;
        int r2 = r1;
    L9:
        if (r2 >= this._children.length) goto L13;
        if (ZeusTransformUtils.instanceOf(this._children[r2], SlidePersistAtom.class) == true) goto L13;
        r2 = r2 + 1;
    L13:
        int r3 = (r2 - r11) - 1;
        r10.add(new SlideAtomsSet((SlidePersistAtom) ZeusTransformUtils.preCheckCast(this._children[r11], SlidePersistAtom.class, "com.obric.memorydata.plugin"), (Record[]) ZeusTransformUtils.preCheckCast(Arrays.copyOfRange(this._children, r1, r1 + r3, Record[].class), Record[].class, "com.obric.memorydata.plugin")));
        r11 = r11 + r3;
    L14:
        r11 = r11 + 1;
        goto L4
    L15:
        this.slideAtomsSets = (SlideAtomsSet[]) ZeusTransformUtils.preCheckCast(r10.toArray(new SlideAtomsSet[0]), SlideAtomsSet[].class, "com.obric.memorydata.plugin");
    }

    public int getInstance() {
        return LittleEndian.getShort(this._header, 0) >> 4;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public SlideAtomsSet[] getSlideAtomsSets() {
        return this.slideAtomsSets;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r10) {
        byte[] r0 = this._header;
        writeOut(r0[0], r0[1], _type, this._children, r10);
    }
}
