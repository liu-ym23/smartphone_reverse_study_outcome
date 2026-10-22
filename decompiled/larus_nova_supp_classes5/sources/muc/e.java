package muc;

import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface e {
    c beginStructure(luc.f r1);

    boolean decodeBoolean();

    byte decodeByte();

    char decodeChar();

    double decodeDouble();

    int decodeEnum(luc.f r1);

    float decodeFloat();

    e decodeInline(luc.f r1);

    int decodeInt();

    long decodeLong();

    @ExperimentalSerializationApi
    boolean decodeNotNullMark();

    @ExperimentalSerializationApi
    Void decodeNull();

    <T> T decodeSerializableValue(juc.c<? extends T> r1);

    short decodeShort();

    String decodeString();

    kotlinx.serialization.modules.d getSerializersModule();
}
