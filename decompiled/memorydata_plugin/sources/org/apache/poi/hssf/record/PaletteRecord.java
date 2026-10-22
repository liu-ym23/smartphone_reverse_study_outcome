package org.apache.poi.hssf.record;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class PaletteRecord extends StandardRecord {
    private static final int[] DEFAULT_COLORS = null;
    private final ArrayList<PColor> _colors;

    private static final class PColor implements GenericRecord {
        private final int _blue;
        private final int _green;
        private final int _red;

        PColor(int r2) {
            this._red = (r2 >>> 16) & 255;
            this._green = (r2 >>> 8) & 255;
            this._blue = r2 & 255;
        }

        PColor(RecordInputStream r2) {
            this._red = r2.readByte();
            this._green = r2.readByte();
            this._blue = r2.readByte();
            r2.readByte();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("red", new $$Lambda$PaletteRecord$PColor$O5mT9b4bEyPWup6oYMGWbRDMYa8(this), "green", new $$Lambda$PaletteRecord$PColor$Z79h9u5YEckiVtaUJuHvlfSo8c(this), "blue", new $$Lambda$PaletteRecord$PColor$EWrt_GUl0gcFMuy4WyRmWPRAcP0(this));
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$PaletteRecord$PColor() {
            return Integer.valueOf(this._red & 255);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$PaletteRecord$PColor() {
            return Integer.valueOf(this._green & 255);
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$PaletteRecord$PColor() {
            return Integer.valueOf(this._blue & 255);
        }
    }

    static {
        DEFAULT_COLORS = new int[]{0, ViewCompat.MEASURED_SIZE_MASK, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255, 16776960, 16711935, 65535, 8388608, 32768, 128, 8421376, 8388736, 32896, 12632256, 8421504, 10066431, 10040166, 16777164, 13434879, 6684774, 16744576, 26316, 13421823, 128, 16711935, 16776960, 65535, 8388736, 8388608, 32896, 255, 52479, 13434879, 13434828, 16777113, 10079487, 16751052, 13408767, 16764057, 3368703, 3394764, 10079232, 16763904, 16750848, 16737792, 6710937, 9868950, 13158, 3381606, 13056, 3355392, 10040064, 10040166, 3355545, 3355443};
    }

    public PaletteRecord() {
        final ArrayList<PColor> r0 = new ArrayList(100);
        this._colors = r0;
        Arrays.stream(DEFAULT_COLORS).mapToObj($$Lambda$E0NKMHPAIW_sQW6Av3IK7u4C1y0.INSTANCE).forEach(new $$Lambda$PaletteRecord$W_x2fiqxNwNSxTTmAab2_GUW6pY(r0));
    }

    public PaletteRecord(RecordInputStream r5) {
        ArrayList<PColor> r0 = new ArrayList(100);
        this._colors = r0;
        short r1 = r5.readShort();
        r0.ensureCapacity(r1);
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        this._colors.add(new PColor(r5));
        r2 = r2 + 1;
        goto L3
    }

    public static /* synthetic */ boolean lambda$W_x2fiqxNwNSxTTmAab2_GUW6pY(ArrayList r0, Object r1) {
        return r0.add(r1);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (this._colors.size() * 4) + 2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("colors", new $$Lambda$PaletteRecord$iCukc_Iiqk_MhrdEkCNEvPwMOBk(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.PALETTE;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 146;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$PaletteRecord() {
        return this._colors;
    }
}
