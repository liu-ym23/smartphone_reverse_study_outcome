package com.google.protobuf;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
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

        private FieldOrder(String r10, int r11) {
            super(r10, r11);
        }

        public static FieldOrder valueOf(String r10) {
            return (FieldOrder) java.lang.Enum.valueOf(FieldOrder.class, r10);
        }

        public static FieldOrder[] values() {
            return (FieldOrder[]) $VALUES.clone();
        }
    }

    FieldOrder fieldOrder();

    void writeBool(int r10, boolean r11);

    void writeBoolList(int r10, List<Boolean> r11, boolean r12);

    void writeBytes(int r10, ByteString r11);

    void writeBytesList(int r10, List<ByteString> r11);

    void writeDouble(int r10, double r11);

    void writeDoubleList(int r10, List<Double> r11, boolean r12);

    @Deprecated
    void writeEndGroup(int r10);

    void writeEnum(int r10, int r11);

    void writeEnumList(int r10, List<Integer> r11, boolean r12);

    void writeFixed32(int r10, int r11);

    void writeFixed32List(int r10, List<Integer> r11, boolean r12);

    void writeFixed64(int r10, long r11);

    void writeFixed64List(int r10, List<Long> r11, boolean r12);

    void writeFloat(int r10, float r11);

    void writeFloatList(int r10, List<Float> r11, boolean r12);

    @Deprecated
    void writeGroup(int r10, Object r11);

    @Deprecated
    void writeGroup(int r10, Object r11, Schema r12);

    @Deprecated
    void writeGroupList(int r10, List<?> r11);

    @Deprecated
    void writeGroupList(int r10, List<?> r11, Schema r12);

    void writeInt32(int r10, int r11);

    void writeInt32List(int r10, List<Integer> r11, boolean r12);

    void writeInt64(int r10, long r11);

    void writeInt64List(int r10, List<Long> r11, boolean r12);

    <K, V> void writeMap(int r10, MapEntryLite.Metadata<K, V> r11, Map<K, V> r12);

    void writeMessage(int r10, Object r11);

    void writeMessage(int r10, Object r11, Schema r12);

    void writeMessageList(int r10, List<?> r11);

    void writeMessageList(int r10, List<?> r11, Schema r12);

    void writeMessageSetItem(int r10, Object r11);

    void writeSFixed32(int r10, int r11);

    void writeSFixed32List(int r10, List<Integer> r11, boolean r12);

    void writeSFixed64(int r10, long r11);

    void writeSFixed64List(int r10, List<Long> r11, boolean r12);

    void writeSInt32(int r10, int r11);

    void writeSInt32List(int r10, List<Integer> r11, boolean r12);

    void writeSInt64(int r10, long r11);

    void writeSInt64List(int r10, List<Long> r11, boolean r12);

    @Deprecated
    void writeStartGroup(int r10);

    void writeString(int r10, String r11);

    void writeStringList(int r10, List<String> r11);

    void writeUInt32(int r10, int r11);

    void writeUInt32List(int r10, List<Integer> r11, boolean r12);

    void writeUInt64(int r10, long r11);

    void writeUInt64List(int r10, List<Long> r11, boolean r12);
}
