package org.msgpack.core;

/* JADX INFO: loaded from: classes3.dex */
public class ExtensionTypeHeader {
    private final int length;
    private final byte type;

    public ExtensionTypeHeader(byte r10, int r11) {
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "length must be >= 0");
        this.type = r10;
        this.length = r11;
        return;
    L5:
        r12 = false;
        goto L6
    }

    public static byte checkedCastToByte(int r10) {
        if ((-128) <= r10) goto L5;
    L7:
        boolean r11 = false;
    L8:
        Preconditions.checkArgument(r11, "Extension type code must be within the range of byte");
        return (byte) r10;
    L5:
        if (r10 > 127) goto L7;
        r11 = true;
        goto L8
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ExtensionTypeHeader) == false) goto L10;
        ExtensionTypeHeader r11 = (ExtensionTypeHeader) r10;
        if (this.type == r11.type) goto L7;
        return false;
    L7:
        if (this.length != r11.length) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int getLength() {
        return this.length;
    }

    public byte getType() {
        return this.type;
    }

    public int hashCode() {
        return ((this.type + 31) * 31) + this.length;
    }

    public boolean isTimestampType() {
        if (this.type != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return String.format("ExtensionTypeHeader(type:%d, length:%,d)", new Object[]{Byte.valueOf(this.type), Integer.valueOf(this.length)});
    }
}
