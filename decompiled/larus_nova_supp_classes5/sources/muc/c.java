package muc;

import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface c {
    boolean decodeBooleanElement(luc.f r1, int r2);

    byte decodeByteElement(luc.f r1, int r2);

    char decodeCharElement(luc.f r1, int r2);

    int decodeCollectionSize(luc.f r1);

    double decodeDoubleElement(luc.f r1, int r2);

    int decodeElementIndex(luc.f r1);

    float decodeFloatElement(luc.f r1, int r2);

    e decodeInlineElement(luc.f r1, int r2);

    int decodeIntElement(luc.f r1, int r2);

    long decodeLongElement(luc.f r1, int r2);

    @ExperimentalSerializationApi
    <T> T decodeNullableSerializableElement(luc.f r1, int r2, juc.c<? extends T> r3, T r4);

    @ExperimentalSerializationApi
    boolean decodeSequentially();

    <T> T decodeSerializableElement(luc.f r1, int r2, juc.c<? extends T> r3, T r4);

    short decodeShortElement(luc.f r1, int r2);

    String decodeStringElement(luc.f r1, int r2);

    void endStructure(luc.f r1);

    kotlinx.serialization.modules.d getSerializersModule();
}
