package com.google.protobuf;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
interface Reader {
    public static final int READ_DONE = Integer.MAX_VALUE;
    public static final int TAG_UNKNOWN = 0;

    int getFieldNumber();

    int getTag();

    <T> void mergeGroupField(T r10, Schema<T> r11, ExtensionRegistryLite r12);

    <T> void mergeMessageField(T r10, Schema<T> r11, ExtensionRegistryLite r12);

    boolean readBool();

    void readBoolList(List<Boolean> r10);

    ByteString readBytes();

    void readBytesList(List<ByteString> r10);

    double readDouble();

    void readDoubleList(List<Double> r10);

    int readEnum();

    void readEnumList(List<Integer> r10);

    int readFixed32();

    void readFixed32List(List<Integer> r10);

    long readFixed64();

    void readFixed64List(List<Long> r10);

    float readFloat();

    void readFloatList(List<Float> r10);

    @Deprecated
    <T> T readGroup(Class<T> r10, ExtensionRegistryLite r11);

    @Deprecated
    <T> T readGroupBySchemaWithCheck(Schema<T> r10, ExtensionRegistryLite r11);

    @Deprecated
    <T> void readGroupList(List<T> r10, Schema<T> r11, ExtensionRegistryLite r12);

    @Deprecated
    <T> void readGroupList(List<T> r10, Class<T> r11, ExtensionRegistryLite r12);

    int readInt32();

    void readInt32List(List<Integer> r10);

    long readInt64();

    void readInt64List(List<Long> r10);

    <K, V> void readMap(Map<K, V> r10, MapEntryLite.Metadata<K, V> r11, ExtensionRegistryLite r12);

    <T> T readMessage(Class<T> r10, ExtensionRegistryLite r11);

    <T> T readMessageBySchemaWithCheck(Schema<T> r10, ExtensionRegistryLite r11);

    <T> void readMessageList(List<T> r10, Schema<T> r11, ExtensionRegistryLite r12);

    <T> void readMessageList(List<T> r10, Class<T> r11, ExtensionRegistryLite r12);

    int readSFixed32();

    void readSFixed32List(List<Integer> r10);

    long readSFixed64();

    void readSFixed64List(List<Long> r10);

    int readSInt32();

    void readSInt32List(List<Integer> r10);

    long readSInt64();

    void readSInt64List(List<Long> r10);

    String readString();

    void readStringList(List<String> r10);

    void readStringListRequireUtf8(List<String> r10);

    String readStringRequireUtf8();

    int readUInt32();

    void readUInt32List(List<Integer> r10);

    long readUInt64();

    void readUInt64List(List<Long> r10);

    boolean shouldDiscardUnknownFields();

    boolean skipField();
}
