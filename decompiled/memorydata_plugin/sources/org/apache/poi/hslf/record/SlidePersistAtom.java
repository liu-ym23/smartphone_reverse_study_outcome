package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class SlidePersistAtom extends RecordAtom {
    private static final int[] FLAGS_MASKS = null;
    private static final String[] FLAGS_NAMES = null;
    private final byte[] _header;
    private int flags;
    private int numPlaceholderTexts;
    private int refID;
    private byte[] reservedFields;
    private int slideIdentifier;

    static {
        FLAGS_MASKS = new int[]{4};
        FLAGS_NAMES = new String[]{"HAS_SHAPES_OTHER_THAN_PLACEHOLDERS"};
    }

    public SlidePersistAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putUShort(r0, 0, 0);
        LittleEndian.putUShort(r0, 2, 1011);
        LittleEndian.putInt(r0, 4, 20);
        this.flags = 4;
        this.reservedFields = new byte[4];
    }

    public SlidePersistAtom(byte[] r3, int r4, int r5) {
        if (r5 >= 8) goto L5;
        r5 = 8;
    L5:
        int r0 = r4 + 8;
        this._header = Arrays.copyOfRange(r3, r4, r0);
        this.refID = LittleEndian.getInt(r3, r0);
        this.flags = LittleEndian.getInt(r3, r4 + 12);
        this.numPlaceholderTexts = LittleEndian.getInt(r3, r4 + 16);
        this.slideIdentifier = LittleEndian.getInt(r3, r4 + 20);
        this.reservedFields = IOUtils.safelyClone(r3, r4 + 24, r5 - 24, 32);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("refID", new $$Lambda$Y6xw6bgt6hBRmMs8SCAOusBSl0(this), "flags", GenericRecordUtil.getBitsAsString(new $$Lambda$SlidePersistAtom$DNzWwivJEIgBSI0gSGcoHDZegSM(this), FLAGS_MASKS, FLAGS_NAMES), "numPlaceholderTexts", new $$Lambda$6wKlLTHQEpv8KbmOUiXCYwZkrM(this), "slideIdentifier", new $$Lambda$yXgP5593GqqHxi8gEHwcWWhMnIM(this));
    }

    public int getNumPlaceholderTexts() {
        return this.numPlaceholderTexts;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return 1011;
    }

    public int getRefID() {
        return this.refID;
    }

    public int getSlideIdentifier() {
        return this.slideIdentifier;
    }

    public /* synthetic */ Number lambda$getGenericProperties$0$SlidePersistAtom() {
        return Integer.valueOf(this.flags);
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        writeLittleEndian(this.refID, r2);
        writeLittleEndian(this.flags, r2);
        writeLittleEndian(this.numPlaceholderTexts, r2);
        writeLittleEndian(this.slideIdentifier, r2);
        r2.write(this.reservedFields);
    }
}
