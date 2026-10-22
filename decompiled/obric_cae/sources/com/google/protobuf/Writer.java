package com.google.protobuf;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
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

        private FieldOrder(String r8, int r10) {
            super(r8, r10);
        }

        public static FieldOrder valueOf(String r8) {
            return (FieldOrder) java.lang.Enum.valueOf(FieldOrder.class, r8);
        }

        public static FieldOrder[] values() {
            return (FieldOrder[]) $VALUES.clone();
        }
    }

    FieldOrder fieldOrder();

    void writeBool(int r8, boolean r10);

    void writeBoolList(int r8, List<Boolean> r10, boolean r11);

    void writeBytes(int r8, ByteString r10);

    void writeBytesList(int r8, List<ByteString> r10);

    void writeDouble(int r8, double r10);

    void writeDoubleList(int r8, List<Double> r10, boolean r11);

    @Deprecated
    void writeEndGroup(int r8);

    void writeEnum(int r8, int r10);

    void writeEnumList(int r8, List<Integer> r10, boolean r11);

    void writeFixed32(int r8, int r10);

    void writeFixed32List(int r8, List<Integer> r10, boolean r11);

    void writeFixed64(int r8, long r10);

    void writeFixed64List(int r8, List<Long> r10, boolean r11);

    void writeFloat(int r8, float r10);

    void writeFloatList(int r8, List<Float> r10, boolean r11);

    @Deprecated
    void writeGroup(int r8, Object r10);

    @Deprecated
    void writeGroup(int r8, Object r10, Schema r11);

    @Deprecated
    void writeGroupList(int r8, List<?> r10);

    @Deprecated
    void writeGroupList(int r8, List<?> r10, Schema r11);

    void writeInt32(int r8, int r10);

    void writeInt32List(int r8, List<Integer> r10, boolean r11);

    void writeInt64(int r8, long r10);

    void writeInt64List(int r8, List<Long> r10, boolean r11);

    <K, V> void writeMap(int r8, MapEntryLite.Metadata<K, V> r10, Map<K, V> r11);

    void writeMessage(int r8, Object r10);

    void writeMessage(int r8, Object r10, Schema r11);

    void writeMessageList(int r8, List<?> r10);

    void writeMessageList(int r8, List<?> r10, Schema r11);

    void writeMessageSetItem(int r8, Object r10);

    void writeSFixed32(int r8, int r10);

    void writeSFixed32List(int r8, List<Integer> r10, boolean r11);

    void writeSFixed64(int r8, long r10);

    void writeSFixed64List(int r8, List<Long> r10, boolean r11);

    void writeSInt32(int r8, int r10);

    void writeSInt32List(int r8, List<Integer> r10, boolean r11);

    void writeSInt64(int r8, long r10);

    void writeSInt64List(int r8, List<Long> r10, boolean r11);

    @Deprecated
    void writeStartGroup(int r8);

    void writeString(int r8, String r10);

    void writeStringList(int r8, List<String> r10);

    void writeUInt32(int r8, int r10);

    void writeUInt32List(int r8, List<Integer> r10, boolean r11);

    void writeUInt64(int r8, long r10);

    void writeUInt64List(int r8, List<Long> r10, boolean r11);
}
