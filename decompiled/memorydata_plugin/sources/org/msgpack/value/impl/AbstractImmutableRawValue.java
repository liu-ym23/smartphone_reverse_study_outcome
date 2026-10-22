package org.msgpack.value.impl;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageStringCodingException;
import org.msgpack.value.ImmutableArrayValue;
import org.msgpack.value.ImmutableBinaryValue;
import org.msgpack.value.ImmutableBooleanValue;
import org.msgpack.value.ImmutableExtensionValue;
import org.msgpack.value.ImmutableFloatValue;
import org.msgpack.value.ImmutableIntegerValue;
import org.msgpack.value.ImmutableMapValue;
import org.msgpack.value.ImmutableNilValue;
import org.msgpack.value.ImmutableNumberValue;
import org.msgpack.value.ImmutableRawValue;
import org.msgpack.value.ImmutableStringValue;
import org.msgpack.value.ImmutableTimestampValue;
import org.msgpack.value.RawValue;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractImmutableRawValue extends AbstractImmutableValue implements ImmutableRawValue {
    private static final char[] HEX_TABLE = null;
    private volatile CharacterCodingException codingException;
    protected final byte[] data;
    private volatile String decodedStringCache;

    static {
        HEX_TABLE = "0123456789ABCDEF".toCharArray();
    }

    public AbstractImmutableRawValue(String r2) {
        this.decodedStringCache = r2;
        this.data = r2.getBytes(MessagePack.UTF8);
    }

    public AbstractImmutableRawValue(byte[] r1) {
        this.data = r1;
    }

    static void appendJsonString(StringBuilder r4, String r5) {
        r4.append("\"");
        int r1 = 0;
    L4:
        if (r1 >= r5.length()) goto L31;
        char r2 = r5.charAt(r1);
        if (r2 >= ' ') goto L16;
        switch(r2) {
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L8;
            case 12: goto L10;
            case 13: goto L9;
            default: goto L8;
        };
    L8:
        escapeChar(r4, r2);
    L30:
        r1 = r1 + 1;
        goto L4
    L9:
        String r3 = "\\r";
    L14:
        r4.append(r3);
        goto L30
    L10:
        r3 = "\\f";
        goto L14
    L11:
        r3 = "\\n";
        goto L14
    L12:
        r3 = "\\t";
        goto L14
    L13:
        r3 = "\\b";
        goto L14
    L16:
        if (r2 > 127) goto L25;
        if (r2 != '\"') goto L20;
        r3 = "\\\"";
        goto L14
    L20:
        if (r2 != '\\') goto L29;
        r3 = "\\\\";
    L29:
        r4.append(r2);
        goto L30
    L25:
        if (r2 < 55296) goto L29;
        if (r2 > 57343) goto L29;
    L31:
        r4.append("\"");
    }

    private void decodeString() {
        byte[] r0 = this.data;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.decodedStringCache == null) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L22:
        this.decodedStringCache = MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(asByteBuffer()).toString();     // Catch: CharacterCodingException -> L10 Throwable -> L18
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L10:
        e = move-exception;
        this.decodedStringCache = MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).decode(asByteBuffer()).toString();     // Catch: CharacterCodingException -> L15 Throwable -> L18
        this.codingException = e;     // Catch: Throwable -> L18
        goto L13
    L15:
        e = move-exception;
        throw new MessageStringCodingException(e);     // Catch: Throwable -> L18
    }

    private static void escapeChar(StringBuilder r2, int r3) {
        r2.append("\\u");
        char[] r0 = HEX_TABLE;
        r2.append(r0[(r3 >> 12) & 15]);
        r2.append(r0[(r3 >> 8) & 15]);
        r2.append(r0[(r3 >> 4) & 15]);
        r2.append(r0[r3 & 15]);
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableArrayValue asArrayValue() {
        return super.asArrayValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableBinaryValue asBinaryValue() {
        return super.asBinaryValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableBooleanValue asBooleanValue() {
        return super.asBooleanValue();
    }

    @Override // org.msgpack.value.RawValue
    public byte[] asByteArray() {
        byte[] r1 = this.data;
        return Arrays.copyOf(r1, r1.length);
    }

    @Override // org.msgpack.value.RawValue
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableExtensionValue asExtensionValue() {
        return super.asExtensionValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableFloatValue asFloatValue() {
        return super.asFloatValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableIntegerValue asIntegerValue() {
        return super.asIntegerValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableMapValue asMapValue() {
        return super.asMapValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableNilValue asNilValue() {
        return super.asNilValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableNumberValue asNumberValue() {
        return super.asNumberValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public ImmutableRawValue asRawValue() {
        return this;
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ RawValue asRawValue() {
        return asRawValue();
    }

    @Override // org.msgpack.value.RawValue
    public String asString() {
        if (this.decodedStringCache != null) goto L6;
        decodeString();
    L6:
        if (this.codingException != null) goto L10;
        return this.decodedStringCache;
    L10:
        throw new MessageStringCodingException(this.codingException);
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableStringValue asStringValue() {
        return super.asStringValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.ImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ ImmutableTimestampValue asTimestampValue() {
        return super.asTimestampValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isArrayValue() {
        return super.isArrayValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isBinaryValue() {
        return super.isBinaryValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isBooleanValue() {
        return super.isBooleanValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isExtensionValue() {
        return super.isExtensionValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isFloatValue() {
        return super.isFloatValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isIntegerValue() {
        return super.isIntegerValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isMapValue() {
        return super.isMapValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isNilValue() {
        return super.isNilValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isNumberValue() {
        return super.isNumberValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isRawValue() {
        return super.isRawValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isStringValue() {
        return super.isStringValue();
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public /* bridge */ /* synthetic */ boolean isTimestampValue() {
        return super.isTimestampValue();
    }

    @Override // org.msgpack.value.Value
    public String toJson() {
        StringBuilder r0 = new StringBuilder();
        appendJsonString(r0, toString());
        return r0.toString();
    }

    @Override // org.msgpack.value.RawValue
    public String toString() {
        if (this.decodedStringCache != null) goto L6;
        decodeString();
    L6:
        return this.decodedStringCache;
    }
}
