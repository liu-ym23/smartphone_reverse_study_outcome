package muc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@ExperimentalSerializationApi
public abstract class a implements e, c {
    public a() {
    }

    @Override // muc.e
    public c beginStructure(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return this;
    }

    @Override // muc.e
    public e decodeInline(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return this;
    }

    @Override // muc.e
    public boolean decodeNotNullMark() {
        return true;
    }

    @Override // muc.e
    public Void decodeNull() {
        return null;
    }

    @Override // muc.c
    @ExperimentalSerializationApi
    public boolean decodeSequentially() {
        return false;
    }

    public void endStructure(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
    }

    public Object decodeValue() {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(getClass()) + " can't retrieve untyped values");
    }

    @Override // muc.e
    public boolean decodeBoolean() {
        Object r0 = decodeValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) r0).booleanValue();
    }

    @Override // muc.e
    public byte decodeByte() {
        Object r0 = decodeValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) r0).byteValue();
    }

    @Override // muc.e
    public char decodeChar() {
        Object r0 = decodeValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) r0).charValue();
    }

    @Override // muc.e
    public double decodeDouble() {
        Object r0 = decodeValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) r0).doubleValue();
    }

    @Override // muc.e
    public float decodeFloat() {
        Object r0 = decodeValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) r0).floatValue();
    }

    @Override // muc.e
    public int decodeInt() {
        Object r0 = decodeValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) r0).intValue();
    }

    @Override // muc.e
    public long decodeLong() {
        Object r0 = decodeValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) r0).longValue();
    }

    @Override // muc.e
    public short decodeShort() {
        Object r0 = decodeValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) r0).shortValue();
    }

    @Override // muc.e
    public String decodeString() {
        Object r0 = decodeValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.String");
        return (String) r0;
    }

    @Override // muc.c
    public int decodeCollectionSize(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return -1;
    }

    @Override // muc.e
    public int decodeEnum(luc.f r2) {
        Intrinsics.checkNotNullParameter(r2, "enumDescriptor");
        Object r3 = decodeValue();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) r3).intValue();
    }

    @ExperimentalSerializationApi
    public <T> T decodeNullableSerializableValue(juc.c<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "deserializer");
        if (r2.getDescriptor().a() == true) goto L9;
        if (decodeNotNullMark() == true) goto L9;
        return (T) decodeNull();
    L9:
        return (T) decodeSerializableValue(r2);
    }

    @Override // muc.e
    public <T> T decodeSerializableValue(juc.c<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "deserializer");
        return r2.deserialize(this);
    }

    @Override // muc.c
    public final boolean decodeBooleanElement(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return decodeBoolean();
    }

    @Override // muc.c
    public final byte decodeByteElement(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return decodeByte();
    }

    @Override // muc.c
    public final char decodeCharElement(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return decodeChar();
    }

    @Override // muc.c
    public final double decodeDoubleElement(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return decodeDouble();
    }

    @Override // muc.c
    public final float decodeFloatElement(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return decodeFloat();
    }

    @Override // muc.c
    public e decodeInlineElement(luc.f r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        return decodeInline(r2.h(r3));
    }

    @Override // muc.c
    public final int decodeIntElement(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return decodeInt();
    }

    @Override // muc.c
    public final long decodeLongElement(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return decodeLong();
    }

    public <T> T decodeSerializableValue(juc.c<? extends T> r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "deserializer");
        return (T) decodeSerializableValue(r1);
    }

    @Override // muc.c
    public final short decodeShortElement(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return decodeShort();
    }

    @Override // muc.c
    public final String decodeStringElement(luc.f r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        return decodeString();
    }

    @Override // muc.c
    public final <T> T decodeNullableSerializableElement(luc.f r1, int r2, juc.c<? extends T> r3, T r4) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        Intrinsics.checkNotNullParameter(r3, "deserializer");
        if (r3.getDescriptor().a() == true) goto L9;
        if (decodeNotNullMark() == true) goto L9;
        return (T) decodeNull();
    L9:
        return (T) decodeSerializableValue(r3, r4);
    }

    public <T> T decodeSerializableElement(luc.f r1, int r2, juc.c<? extends T> r3, T r4) {
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        Intrinsics.checkNotNullParameter(r3, "deserializer");
        return (T) decodeSerializableValue(r3, r4);
    }

    public static /* synthetic */ Object decodeSerializableValue$default(a r0, juc.c r1, Object r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = null;
    L7:
        return r0.decodeSerializableValue(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableValue");
    }
}
