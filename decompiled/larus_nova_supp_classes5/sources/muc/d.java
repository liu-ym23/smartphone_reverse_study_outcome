package muc;

import juc.n;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface d {
    void encodeBooleanElement(luc.f r1, int r2, boolean r3);

    void encodeByteElement(luc.f r1, int r2, byte r3);

    void encodeCharElement(luc.f r1, int r2, char r3);

    void encodeDoubleElement(luc.f r1, int r2, double r3);

    void encodeFloatElement(luc.f r1, int r2, float r3);

    f encodeInlineElement(luc.f r1, int r2);

    void encodeIntElement(luc.f r1, int r2, int r3);

    void encodeLongElement(luc.f r1, int r2, long r3);

    @ExperimentalSerializationApi
    <T> void encodeNullableSerializableElement(luc.f r1, int r2, n<? super T> r3, T r4);

    <T> void encodeSerializableElement(luc.f r1, int r2, n<? super T> r3, T r4);

    void encodeShortElement(luc.f r1, int r2, short r3);

    void encodeStringElement(luc.f r1, int r2, String r3);

    void endStructure(luc.f r1);

    @ExperimentalSerializationApi
    boolean shouldEncodeElementDefault(luc.f r1, int r2);
}
