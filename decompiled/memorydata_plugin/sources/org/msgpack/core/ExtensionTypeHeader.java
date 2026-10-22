package org.msgpack.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class ExtensionTypeHeader {
    private final int length;
    private final byte type;

    public ExtensionTypeHeader(byte r3, int r4) {
        if (r4 < 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "length must be >= 0");
        this.type = r3;
        this.length = r4;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static byte checkedCastToByte(int r2) {
        if ((-128) <= r2) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "Extension type code must be within the range of byte");
        return (byte) r2;
    L5:
        if (r2 > 127) goto L7;
        r0 = true;
        goto L8
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ExtensionTypeHeader.class) == false) goto L10;
        ExtensionTypeHeader r5 = (ExtensionTypeHeader) ZeusTransformUtils.preCheckCast(r4, ExtensionTypeHeader.class, "com.obric.memorydata.plugin");
        if (this.type == r5.type) goto L7;
        return false;
    L7:
        if (this.length != r5.length) goto L12;
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
