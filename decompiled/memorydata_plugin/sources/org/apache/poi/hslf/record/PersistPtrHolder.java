package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class PersistPtrHolder extends PositionDependentRecordAtom {
    private static final BitField cntPersistFld = null;
    private static final BitField persistIdFld = null;
    private final byte[] _header;
    private byte[] _ptrData;
    private final Map<Integer, Integer> _slideLocations;
    private final long _type;

    static {
        persistIdFld = BitFieldFactory.getInstance(1048575);
        cntPersistFld = BitFieldFactory.getInstance(-1048576);
    }

    public PersistPtrHolder(byte[] r6, int r7, int r8) {
        if (r8 >= 8) goto L5;
        r8 = 8;
    L5:
        int r1 = r7 + 8;
        byte[] r9 = Arrays.copyOfRange(r6, r7, r1);
        this._header = r9;
        this._type = LittleEndian.getUShort(r9, 2);
        this._slideLocations = new HashMap();
        this._ptrData = IOUtils.safelyClone(r6, r1, r8 - 8, RecordAtom.getMaxRecordLength());
        int r10 = 0;
    L6:
        byte[] r11 = this._ptrData;
        if (r10 >= r11.length) goto L11;
        int r12 = LittleEndian.getInt(r11, r10);
        int r0 = persistIdFld.getValue(r12);
        int r13 = cntPersistFld.getValue(r12);
        r10 = r10 + 4;
        int r2 = 0;
    L9:
        if (r2 >= r13) goto L6;
        this._slideLocations.put(Integer.valueOf(r0 + r2), Integer.valueOf((int) LittleEndian.getUInt(this._ptrData, r10)));
        r10 = r10 + 4;
        r2 = r2 + 1;
        goto L9
    }

    private void normalizePersistDirectory() {
        int[] r0 = new int[this._slideLocations.size() * 2];
        final Stream<Map.Entry<Integer, Integer>> r1 = this._slideLocations.entrySet().stream().sorted(Comparator.comparingInt($$Lambda$74eMduJKh7CW4pGA2a0gxawkuB4.INSTANCE));
        r1.getClass();
        Iterator r2 = new $$Lambda$jWyddd9Wv_OtaabsQz0HTR918E(r1).iterator();
        int r3 = -1;
        int r4 = 0;
        int r5 = -1;
        int r6 = -1;
        int r7 = 0;
        int r8 = 0;
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r10 = ((Integer) ZeusTransformUtils.preCheckCast(r9.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if ((r5 + 1) >= r10) goto L8;
        r3 = r3 + 1;
        r7 = r3;
        r8 = 0;
        r6 = r10;
    L8:
        r8 = r8 + 1;
        r0[r7] = cntPersistFld.setValue(persistIdFld.setValue(0, r6), r8);
        r3 = r3 + 1;
        r0[r3] = ((Integer) ZeusTransformUtils.preCheckCast(r9.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r5 = r10;
        goto L4
    L9:
        this._ptrData = new byte[(r3 + 1) * 4];
    L10:
        if (r4 > r3) goto L12;
        LittleEndian.putInt(this._ptrData, r4 * 4, r0[r4]);
        r4 = r4 + 1;
        goto L10
    L12:
        LittleEndian.putInt(this._header, 4, this._ptrData.length);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("slideLocations", new $$Lambda$cowzQAmxIt3mPuOaQvxw5Sydong(this));
    }

    public int[] getKnownSlideIDs() {
        int[] r0 = new int[this._slideLocations.size()];
        Iterator<Integer> r5 = this._slideLocations.keySet().iterator();
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0[r1] = ((Integer) ZeusTransformUtils.preCheckCast(r5.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return this._type;
    }

    public Map<Integer, Integer> getSlideLocationsLookup() {
        return Collections.unmodifiableMap(this._slideLocations);
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        normalizePersistDirectory();
        r2.write(this._header);
        r2.write(this._ptrData);
    }
}
