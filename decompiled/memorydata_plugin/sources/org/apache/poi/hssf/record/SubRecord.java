package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public abstract class SubRecord implements GenericRecord {
    private static int MAX_RECORD_LENGTH = 1000000;

    public static final enum SubRecordTypes extends Enum<SubRecordTypes> {
        private static final /* synthetic */ SubRecordTypes[] $VALUES = null;
        public static final SubRecordTypes COMMON_OBJECT_DATA = null;
        public static final SubRecordTypes EMBEDDED_OBJECT_REF = null;
        public static final SubRecordTypes END = null;
        public static final SubRecordTypes FT_CBLS = null;
        public static final SubRecordTypes FT_CF = null;
        public static final SubRecordTypes FT_PIO_GRBIT = null;
        public static final SubRecordTypes GROUP_MARKER = null;
        public static final SubRecordTypes LBS_DATA = null;
        private static final Map<Short, SubRecordTypes> LOOKUP = null;
        public static final SubRecordTypes NOTE_STRUCTURE = null;
        public static final SubRecordTypes UNKNOWN = null;
        public final RecordConstructor<?> recordConstructor;
        public final short sid;

        @FunctionalInterface
        public interface RecordConstructor<T extends SubRecord> {
            T apply(LittleEndianInput r1, int r2, int r3);
        }

        static {
            SubRecordTypes r0 = new SubRecordTypes("UNKNOWN", 0, -1, $$Lambda$aunQRWNL0upEr1oyL1fVZWq9iM.INSTANCE);
            UNKNOWN = r0;
            SubRecordTypes r1 = new SubRecordTypes("END", 1, 0, $$Lambda$8dMfp9sfh6Yq9FjrolE2Dr35JpI.INSTANCE);
            END = r1;
            SubRecordTypes r2 = new SubRecordTypes("GROUP_MARKER", 2, 6, $$Lambda$YHfj_CtKdjZvqTUnOAIyKLo1hi0.INSTANCE);
            GROUP_MARKER = r2;
            SubRecordTypes r4 = new SubRecordTypes("FT_CF", 3, 7, $$Lambda$aSCvcGtS4EXqWZS710gm6UZmbI.INSTANCE);
            FT_CF = r4;
            SubRecordTypes r6 = new SubRecordTypes("FT_PIO_GRBIT", 4, 8, $$Lambda$xJA2ccC65c65T3drzmpRQxZGFv8.INSTANCE);
            FT_PIO_GRBIT = r6;
            SubRecordTypes r9 = new SubRecordTypes("EMBEDDED_OBJECT_REF", 5, 9, $$Lambda$MF7JLt03vmfIPC1gS4CCJHPlLqk.INSTANCE);
            EMBEDDED_OBJECT_REF = r9;
            SubRecordTypes r12 = new SubRecordTypes("FT_CBLS", 6, 12, $$Lambda$JWYRNG1bIzImumhuxz9dhRA8fOs.INSTANCE);
            FT_CBLS = r12;
            SubRecordTypes r7 = new SubRecordTypes("NOTE_STRUCTURE", 7, 13, $$Lambda$EtMToCNydamiPHkbfbrfzrdArk.INSTANCE);
            NOTE_STRUCTURE = r7;
            SubRecordTypes r8 = new SubRecordTypes("LBS_DATA", 8, 19, $$Lambda$FHI8OAiFggq84fWRxgb4owCUDyo.INSTANCE);
            LBS_DATA = r8;
            SubRecordTypes r11 = new SubRecordTypes("COMMON_OBJECT_DATA", 9, 21, $$Lambda$r7kDmlkvZH5xglXXMRs0Ity2cY.INSTANCE);
            COMMON_OBJECT_DATA = r11;
            $VALUES = new SubRecordTypes[]{r0, r1, r2, r4, r6, r9, r12, r7, r8, r11};
            LOOKUP = (Map) ZeusTransformUtils.preCheckCast(Arrays.stream(values()).collect(Collectors.toMap($$Lambda$VSugdwXcsP8mO5B6dmfr9UIuMHg.INSTANCE, Function.identity())), Map.class, "com.obric.memorydata.plugin");
        }

        private SubRecordTypes(String r3, int r4, int r5, RecordConstructor r6) {
            RecordConstructor<?> r7 = (RecordConstructor) ZeusTransformUtils.wrapperContextForParams(r6, RecordConstructor.class, "com.obric.memorydata.plugin");
            super(r3, r4);
            this.sid = (short) r5;
            this.recordConstructor = r7;
        }

        public static SubRecordTypes forSID(int r2) {
            return (SubRecordTypes) ZeusTransformUtils.preCheckCast(LOOKUP.getOrDefault(Short.valueOf((short) r2), UNKNOWN), SubRecordTypes.class, "com.obric.memorydata.plugin");
        }

        public static SubRecordTypes valueOf(String r2) {
            return (SubRecordTypes) ZeusTransformUtils.preCheckCast(Enum.valueOf(SubRecordTypes.class, r2), SubRecordTypes.class, "com.obric.memorydata.plugin");
        }

        public static SubRecordTypes[] values() {
            return (SubRecordTypes[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SubRecordTypes[].class, "com.obric.memorydata.plugin");
        }

        public short getSid() {
            return this.sid;
        }
    }

    private static final class UnknownSubRecord extends SubRecord {
        private final byte[] _data;
        private final int _sid;

        public UnknownSubRecord(LittleEndianInput r3, int r4, int r5) {
            LittleEndianInput r6 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
            this._sid = r5;
            byte[] r7 = IOUtils.safelyAllocate(r4, SubRecord.access$000());
            r6.readFully(r7);
            this._data = r7;
        }

        @Override // org.apache.poi.hssf.record.SubRecord
        public int getDataSize() {
            return this._data.length;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("sid", new $$Lambda$SubRecord$UnknownSubRecord$EPVZLqiZ9CR81xr16FFdyIzcBE(this), "data", new $$Lambda$SubRecord$UnknownSubRecord$aMIJuzk7aRaBp_hGVfmXtb3LQbw(this));
        }

        @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
        public SubRecordTypes getGenericRecordType() {
            return SubRecordTypes.UNKNOWN;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$SubRecord$UnknownSubRecord() {
            return Integer.valueOf(this._sid);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$SubRecord$UnknownSubRecord() {
            return this._data;
        }
    }

    static {
    }

    public SubRecord() {
    }

    static /* synthetic */ int access$000() {
        return MAX_RECORD_LENGTH;
    }

    public static SubRecord createSubRecord(LittleEndianInput r5, int r6) {
        LittleEndianInput r7 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r5, LittleEndianInput.class, "com.obric.memorydata.plugin");
        int r0 = r7.readUShort();
        int r1 = r7.readUShort();
        SubRecordTypes r2 = SubRecordTypes.forSID(r0);
        SubRecordTypes.RecordConstructor<?> r3 = r2.recordConstructor;
        if (r2 != SubRecordTypes.UNKNOWN) goto L6;
        r6 = r0;
    L6:
        return r3.apply(r7, r1, r6);
    }

    public abstract int getDataSize();

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public abstract SubRecordTypes getGenericRecordType();

    public boolean isTerminating() {
        return false;
    }

    public final String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
