package com.squareup.wire;

import okio.ByteString;
import okio.e;

/* JADX INFO: loaded from: classes2.dex */
public final class ProtoWriter {
    private final e sink;

    public ProtoWriter(e r10) {
        this.sink = r10;
    }

    static int decodeZigZag32(int r10) {
        int r11 = r10 >>> 1;
        return (-(r10 & 1)) ^ r11;
    }

    static long decodeZigZag64(long r10) {
        long r11 = r10 >>> 1;
        return (-(r10 & 1)) ^ r11;
    }

    static int encodeZigZag32(int r10) {
        int r11 = r10 << 1;
        return (r10 >> 31) ^ r11;
    }

    static long encodeZigZag64(long r10) {
        long r11 = r10 << 1;
        return (r10 >> 63) ^ r11;
    }

    static int int32Size(int r10) {
        if (r10 >= 0) goto L4;
        return 10;
    L4:
        return varint32Size(r10);
    }

    private static int makeTag(int r10, FieldEncoding r11) {
        return (r10 << 3) | r11.value;
    }

    static int tagSize(int r10) {
        return varint32Size(makeTag(r10, FieldEncoding.VARINT));
    }

    static int utf8Length(String r10) {
        int r11 = r10.length();
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L26;
        char r14 = r10.charAt(r12);
        if (r14 >= 128) goto L8;
    L6:
        r13 = r13 + 1;
    L25:
        r12 = r12 + 1;
        goto L3
    L8:
        if (r14 >= 2048) goto L11;
        r13 = r13 + 2;
        goto L25
    L11:
        if (r14 >= 55296) goto L13;
    L24:
        r13 = r13 + 3;
        goto L25
    L13:
        if (r14 > 57343) goto L24;
        if (r14 > 56319) goto L6;
        int r15 = r12 + 1;
        if (r15 >= r11) goto L6;
        if (r10.charAt(r15) < 56320) goto L6;
        if (r10.charAt(r15) > 57343) goto L6;
        r13 = r13 + 4;
        r12 = r15;
        goto L25
    L26:
        return r13;
    }

    static int varint32Size(int r10) {
        if ((r10 & (-128)) != 0) goto L7;
        return 1;
    L7:
        if ((r10 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r10) != 0) goto L15;
        return 3;
    L15:
        if ((r10 & (-268435456)) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    static int varint64Size(long r10) {
        if (((-128) & r10) != 0) goto L7;
        return 1;
    L7:
        if (((-16384) & r10) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r10) != 0) goto L15;
        return 3;
    L15:
        if (((-268435456) & r10) != 0) goto L19;
        return 4;
    L19:
        if (((-34359738368L) & r10) != 0) goto L23;
        return 5;
    L23:
        if (((-4398046511104L) & r10) != 0) goto L27;
        return 6;
    L27:
        if (((-562949953421312L) & r10) != 0) goto L31;
        return 7;
    L31:
        if (((-72057594037927936L) & r10) != 0) goto L35;
        return 8;
    L35:
        if ((r10 & Long.MIN_VALUE) != 0) goto L38;
        return 9;
    L38:
        return 10;
    }

    public void writeBytes(ByteString r10) {
        this.sink.O(r10);
    }

    public void writeFixed32(int r10) {
        this.sink.m(r10);
    }

    public void writeFixed64(long r10) {
        this.sink.j(r10);
    }

    void writeSignedVarint32(int r10) {
        if (r10 < 0) goto L4;
        writeVarint32(r10);
        return;
    L4:
        writeVarint64(r10);
    }

    public void writeString(String r10) {
        this.sink.t(r10);
    }

    public void writeTag(int r10, FieldEncoding r11) {
        writeVarint32(makeTag(r10, r11));
    }

    public void writeVarint32(int r10) {
    L3:
        if ((r10 & (-128)) == 0) goto L5;
        this.sink.writeByte((r10 & 127) | 128);
        r10 = r10 >>> 7;
        goto L3
    L5:
        this.sink.writeByte(r10);
    }

    public void writeVarint64(long r10) {
    L3:
        if (((-128) & r10) == 0) goto L5;
        this.sink.writeByte((((int) r10) & 127) | 128);
        r10 = r10 >>> 7;
        goto L3
    L5:
        this.sink.writeByte((int) r10);
    }
}
