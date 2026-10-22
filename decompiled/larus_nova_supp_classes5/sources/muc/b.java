package muc;

import juc.n;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import nuc.o1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@ExperimentalSerializationApi
public abstract class b implements f, d {
    public b() {
    }

    @Override // muc.f
    public d beginStructure(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return this;
    }

    public boolean encodeElement(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return true;
    }

    @Override // muc.f
    public f encodeInline(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return this;
    }

    @Override // muc.f
    @ExperimentalSerializationApi
    public void encodeNotNullMark() {
    }

    public void endStructure(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
    }

    @Override // muc.f
    public void encodeNull() {
        throw new SerializationException("'null' is not supported by default");
    }

    @Override // muc.f
    public void encodeBoolean(boolean r1) {
        encodeValue(Boolean.valueOf(r1));
    }

    @Override // muc.f
    public void encodeByte(byte r1) {
        encodeValue(Byte.valueOf(r1));
    }

    @Override // muc.f
    public void encodeChar(char r1) {
        encodeValue(Character.valueOf(r1));
    }

    @Override // muc.f
    public void encodeDouble(double r1) {
        encodeValue(Double.valueOf(r1));
    }

    @Override // muc.f
    public void encodeFloat(float r1) {
        encodeValue(Float.valueOf(r1));
    }

    @Override // muc.f
    public void encodeInt(int r1) {
        encodeValue(Integer.valueOf(r1));
    }

    @Override // muc.f
    public void encodeLong(long r1) {
        encodeValue(Long.valueOf(r1));
    }

    @Override // muc.f
    public void encodeShort(short r1) {
        encodeValue(Short.valueOf(r1));
    }

    @Override // muc.f
    public void encodeString(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        encodeValue(r2);
    }

    public void encodeValue(Object r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(r4.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    @Override // muc.f
    public d beginCollection(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return beginStructure(r1);
    }

    @Override // muc.f
    public void encodeEnum(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "enumDescriptor");
        encodeValue(Integer.valueOf(r3));
    }

    @Override // muc.d
    public final f encodeInlineElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if (encodeElement(r2, r3) == false) goto L6;
        return encodeInline(r2.h(r3));
    L6:
        return o1.a;
    }

    @ExperimentalSerializationApi
    public <T> void encodeNullableSerializableValue(n<? super T> r1, T r2) {
        f.a.a(this, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // muc.f
    public <T> void encodeSerializableValue(n<? super T> r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "serializer");
        r2.serialize(this, r3);
    }

    @ExperimentalSerializationApi
    public boolean shouldEncodeElementDefault(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return true;
    }

    @Override // muc.d
    public final void encodeBooleanElement(luc.f r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if (encodeElement(r2, r3) == false) goto L6;
        encodeBoolean(r4);
        return;
    }

    @Override // muc.d
    public final void encodeByteElement(luc.f r2, int r3, byte r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if (encodeElement(r2, r3) == false) goto L6;
        encodeByte(r4);
        return;
    }

    @Override // muc.d
    public final void encodeCharElement(luc.f r2, int r3, char r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if (encodeElement(r2, r3) == false) goto L6;
        encodeChar(r4);
        return;
    }

    @Override // muc.d
    public final void encodeDoubleElement(luc.f r2, int r3, double r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if (encodeElement(r2, r3) == false) goto L6;
        encodeDouble(r4);
        return;
    }

    @Override // muc.d
    public final void encodeFloatElement(luc.f r2, int r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if (encodeElement(r2, r3) == false) goto L6;
        encodeFloat(r4);
        return;
    }

    @Override // muc.d
    public final void encodeIntElement(luc.f r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if (encodeElement(r2, r3) == false) goto L6;
        encodeInt(r4);
        return;
    }

    @Override // muc.d
    public final void encodeLongElement(luc.f r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if (encodeElement(r2, r3) == false) goto L6;
        encodeLong(r4);
        return;
    }

    @Override // muc.d
    public final void encodeShortElement(luc.f r2, int r3, short r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if (encodeElement(r2, r3) == false) goto L6;
        encodeShort(r4);
        return;
    }

    @Override // muc.d
    public final void encodeStringElement(luc.f r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "value");
        if (encodeElement(r2, r3) == false) goto L6;
        encodeString(r4);
        return;
    }

    public <T> void encodeNullableSerializableElement(luc.f r2, int r3, n<? super T> r4, T r5) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "serializer");
        if (encodeElement(r2, r3) == false) goto L6;
        encodeNullableSerializableValue(r4, r5);
        return;
    }

    @Override // muc.d
    public <T> void encodeSerializableElement(luc.f r2, int r3, n<? super T> r4, T r5) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        Intrinsics.checkNotNullParameter(r4, "serializer");
        if (encodeElement(r2, r3) == false) goto L6;
        encodeSerializableValue(r4, r5);
        return;
    }
}
