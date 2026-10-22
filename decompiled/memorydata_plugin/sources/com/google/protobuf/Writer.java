package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
interface Writer {

    public static final enum FieldOrder extends java.lang.Enum<FieldOrder> {
        private static final /* synthetic */ FieldOrder[] $VALUES = null;
        public static final FieldOrder ASCENDING = null;
        public static final FieldOrder DESCENDING = null;

        private static /* synthetic */ FieldOrder[] $values() {
            return new FieldOrder[]{ASCENDING, DESCENDING};
        }

        static {
            ASCENDING = new FieldOrder("ASCENDING", 0);
            DESCENDING = new FieldOrder("DESCENDING", 1);
            $VALUES = $values();
        }

        private FieldOrder(String r1, int r2) {
            super(r1, r2);
        }

        public static FieldOrder valueOf(String r2) {
            return (FieldOrder) ZeusTransformUtils.preCheckCast(java.lang.Enum.valueOf(FieldOrder.class, r2), FieldOrder.class, "com.obric.memorydata.plugin");
        }

        public static FieldOrder[] values() {
            return (FieldOrder[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FieldOrder[].class, "com.obric.memorydata.plugin");
        }
    }

    FieldOrder fieldOrder();

    void writeBool(int r1, boolean r2);

    void writeBoolList(int r1, List<Boolean> r2, boolean r3);

    void writeBytes(int r1, ByteString r2);

    void writeBytesList(int r1, List<ByteString> r2);

    void writeDouble(int r1, double r2);

    void writeDoubleList(int r1, List<Double> r2, boolean r3);

    @Deprecated
    void writeEndGroup(int r1);

    void writeEnum(int r1, int r2);

    void writeEnumList(int r1, List<Integer> r2, boolean r3);

    void writeFixed32(int r1, int r2);

    void writeFixed32List(int r1, List<Integer> r2, boolean r3);

    void writeFixed64(int r1, long r2);

    void writeFixed64List(int r1, List<Long> r2, boolean r3);

    void writeFloat(int r1, float r2);

    void writeFloatList(int r1, List<Float> r2, boolean r3);

    @Deprecated
    void writeGroup(int r1, Object r2);

    @Deprecated
    void writeGroup(int r1, Object r2, Schema r3);

    @Deprecated
    void writeGroupList(int r1, List<?> r2);

    @Deprecated
    void writeGroupList(int r1, List<?> r2, Schema r3);

    void writeInt32(int r1, int r2);

    void writeInt32List(int r1, List<Integer> r2, boolean r3);

    void writeInt64(int r1, long r2);

    void writeInt64List(int r1, List<Long> r2, boolean r3);

    <K, V> void writeMap(int r1, MapEntryLite.Metadata<K, V> r2, Map<K, V> r3);

    void writeMessage(int r1, Object r2);

    void writeMessage(int r1, Object r2, Schema r3);

    void writeMessageList(int r1, List<?> r2);

    void writeMessageList(int r1, List<?> r2, Schema r3);

    void writeMessageSetItem(int r1, Object r2);

    void writeSFixed32(int r1, int r2);

    void writeSFixed32List(int r1, List<Integer> r2, boolean r3);

    void writeSFixed64(int r1, long r2);

    void writeSFixed64List(int r1, List<Long> r2, boolean r3);

    void writeSInt32(int r1, int r2);

    void writeSInt32List(int r1, List<Integer> r2, boolean r3);

    void writeSInt64(int r1, long r2);

    void writeSInt64List(int r1, List<Long> r2, boolean r3);

    @Deprecated
    void writeStartGroup(int r1);

    void writeString(int r1, String r2);

    void writeStringList(int r1, List<String> r2);

    void writeUInt32(int r1, int r2);

    void writeUInt32List(int r1, List<Integer> r2, boolean r3);

    void writeUInt64(int r1, long r2);

    void writeUInt64List(int r1, List<Long> r2, boolean r3);
}
