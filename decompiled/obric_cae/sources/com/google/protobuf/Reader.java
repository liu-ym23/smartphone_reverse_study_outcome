package com.google.protobuf;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface Reader {
    public static final int READ_DONE = Integer.MAX_VALUE;
    public static final int TAG_UNKNOWN = 0;

    int getFieldNumber();

    int getTag();

    <T> void mergeGroupField(T r8, Schema<T> r10, ExtensionRegistryLite r11);

    <T> void mergeMessageField(T r8, Schema<T> r10, ExtensionRegistryLite r11);

    boolean readBool();

    void readBoolList(List<Boolean> r8);

    ByteString readBytes();

    void readBytesList(List<ByteString> r8);

    double readDouble();

    void readDoubleList(List<Double> r8);

    int readEnum();

    void readEnumList(List<Integer> r8);

    int readFixed32();

    void readFixed32List(List<Integer> r8);

    long readFixed64();

    void readFixed64List(List<Long> r8);

    float readFloat();

    void readFloatList(List<Float> r8);

    @Deprecated
    <T> T readGroup(Class<T> r8, ExtensionRegistryLite r10);

    @Deprecated
    <T> T readGroupBySchemaWithCheck(Schema<T> r8, ExtensionRegistryLite r10);

    @Deprecated
    <T> void readGroupList(List<T> r8, Schema<T> r10, ExtensionRegistryLite r11);

    @Deprecated
    <T> void readGroupList(List<T> r8, Class<T> r10, ExtensionRegistryLite r11);

    int readInt32();

    void readInt32List(List<Integer> r8);

    long readInt64();

    void readInt64List(List<Long> r8);

    <K, V> void readMap(Map<K, V> r8, MapEntryLite.Metadata<K, V> r10, ExtensionRegistryLite r11);

    <T> T readMessage(Class<T> r8, ExtensionRegistryLite r10);

    <T> T readMessageBySchemaWithCheck(Schema<T> r8, ExtensionRegistryLite r10);

    <T> void readMessageList(List<T> r8, Schema<T> r10, ExtensionRegistryLite r11);

    <T> void readMessageList(List<T> r8, Class<T> r10, ExtensionRegistryLite r11);

    int readSFixed32();

    void readSFixed32List(List<Integer> r8);

    long readSFixed64();

    void readSFixed64List(List<Long> r8);

    int readSInt32();

    void readSInt32List(List<Integer> r8);

    long readSInt64();

    void readSInt64List(List<Long> r8);

    String readString();

    void readStringList(List<String> r8);

    void readStringListRequireUtf8(List<String> r8);

    String readStringRequireUtf8();

    int readUInt32();

    void readUInt32List(List<Integer> r8);

    long readUInt64();

    void readUInt64List(List<Long> r8);

    boolean shouldDiscardUnknownFields();

    boolean skipField();
}
