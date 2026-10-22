package com.squareup.wire;

import com.qualcomm.qti.qesdk.QesdkUtils;
import jf.e;
import jf.g;

/* JADX INFO: loaded from: classes2.dex */
public final class ProtoWriter {
    private final e sink;

    public ProtoWriter(e r8) {
        this.sink = r8;
    }

    public static int decodeZigZag32(int r8) {
        int r10 = r8 >>> 1;
        return (-(r8 & 1)) ^ r10;
    }

    public static long decodeZigZag64(long r8) {
        long r10 = r8 >>> 1;
        return (-(r8 & 1)) ^ r10;
    }

    public static int encodeZigZag32(int r8) {
        int r10 = r8 << 1;
        return (r8 >> 31) ^ r10;
    }

    public static long encodeZigZag64(long r8) {
        long r10 = r8 << 1;
        return (r8 >> 63) ^ r10;
    }

    public static int int32Size(int r8) {
        if (r8 >= 0) goto L4;
        return 10;
    L4:
        return varint32Size(r8);
    }

    private static int makeTag(int r8, FieldEncoding r10) {
        return (r8 << 3) | r10.value;
    }

    public static int tagSize(int r8) {
        return varint32Size(makeTag(r8, FieldEncoding.VARINT));
    }

    public static int utf8Length(String r8) {
        int r10 = r8.length();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L26;
        char r13 = r8.charAt(r11);
        if (r13 >= 128) goto L8;
    L6:
        r12 = r12 + 1;
    L25:
        r11 = r11 + 1;
        goto L3
    L8:
        if (r13 >= 2048) goto L11;
        r12 = r12 + 2;
        goto L25
    L11:
        if (r13 >= 55296) goto L13;
    L24:
        r12 = r12 + 3;
        goto L25
    L13:
        if (r13 > 57343) goto L24;
        if (r13 > 56319) goto L6;
        int r14 = r11 + 1;
        if (r14 >= r10) goto L6;
        if (r8.charAt(r14) < 56320) goto L6;
        if (r8.charAt(r14) > 57343) goto L6;
        r12 = r12 + 4;
        r11 = r14;
        goto L25
    L26:
        return r12;
    }

    public static int varint32Size(int r8) {
        if ((r8 & QesdkUtils.LIMITS.INT_8_LOWER) != 0) goto L7;
        return 1;
    L7:
        if ((r8 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r8) != 0) goto L15;
        return 3;
    L15:
        if ((r8 & (-268435456)) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public static int varint64Size(long r8) {
        if (((-128) & r8) != 0) goto L7;
        return 1;
    L7:
        if (((-16384) & r8) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r8) != 0) goto L15;
        return 3;
    L15:
        if (((-268435456) & r8) != 0) goto L19;
        return 4;
    L19:
        if (((-34359738368L) & r8) != 0) goto L23;
        return 5;
    L23:
        if (((-4398046511104L) & r8) != 0) goto L27;
        return 6;
    L27:
        if (((-562949953421312L) & r8) != 0) goto L31;
        return 7;
    L31:
        if (((-72057594037927936L) & r8) != 0) goto L35;
        return 8;
    L35:
        if ((r8 & Long.MIN_VALUE) != 0) goto L38;
        return 9;
    L38:
        return 10;
    }

    public void writeBytes(g r8) {
        this.sink.s(r8);
    }

    public void writeFixed32(int r8) {
        this.sink.T(r8);
    }

    public void writeFixed64(long r8) {
        this.sink.h(r8);
    }

    public void writeSignedVarint32(int r8) {
        if (r8 < 0) goto L4;
        writeVarint32(r8);
        return;
    L4:
        writeVarint64(r8);
    }

    public void writeString(String r8) {
        this.sink.p(r8);
    }

    public void writeTag(int r8, FieldEncoding r10) {
        writeVarint32(makeTag(r8, r10));
    }

    public void writeVarint32(int r8) {
    L3:
        if ((r8 & QesdkUtils.LIMITS.INT_8_LOWER) == 0) goto L5;
        this.sink.writeByte((r8 & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
        r8 = r8 >>> 7;
        goto L3
    L5:
        this.sink.writeByte(r8);
    }

    public void writeVarint64(long r8) {
    L3:
        if (((-128) & r8) == 0) goto L5;
        this.sink.writeByte((((int) r8) & QesdkUtils.LIMITS.INT_8_UPPER) | 128);
        r8 = r8 >>> 7;
        goto L3
    L5:
        this.sink.writeByte((int) r8);
    }
}
