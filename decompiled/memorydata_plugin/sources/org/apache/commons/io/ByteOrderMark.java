package org.apache.commons.io;

import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class ByteOrderMark implements Serializable {
    public static final ByteOrderMark UTF_16BE = null;
    public static final ByteOrderMark UTF_16LE = null;
    public static final ByteOrderMark UTF_32BE = null;
    public static final ByteOrderMark UTF_32LE = null;
    public static final ByteOrderMark UTF_8 = null;
    public static final char UTF_BOM = 65279;
    private static final long serialVersionUID = 1;
    private final int[] bytes;
    private final String charsetName;

    static {
        UTF_8 = new ByteOrderMark(RpcUtils.CHARSET_UTF8, new int[]{239, 187, 191});
        UTF_16BE = new ByteOrderMark("UTF-16BE", new int[]{254, 255});
        UTF_16LE = new ByteOrderMark("UTF-16LE", new int[]{255, 254});
        UTF_32BE = new ByteOrderMark("UTF-32BE", new int[]{0, 0, 254, 255});
        UTF_32LE = new ByteOrderMark("UTF-32LE", new int[]{255, 254, 0, 0});
    }

    public ByteOrderMark(String r2, int... r3) {
        if (r2 == null) goto L14;
        if (r2.isEmpty() == true) goto L14;
        if (r3 == null) goto L12;
        if (r3.length == 0) goto L12;
        this.charsetName = r2;
        int[] r4 = new int[r3.length];
        this.bytes = r4;
        System.arraycopy(r3, 0, r4, 0, r3.length);
        return;
    L12:
        throw new IllegalArgumentException("No bytes specified");
    L14:
        throw new IllegalArgumentException("No charsetName specified");
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, ByteOrderMark.class) == true) goto L5;
        return false;
    L5:
        ByteOrderMark r6 = (ByteOrderMark) ZeusTransformUtils.preCheckCast(r5, ByteOrderMark.class, "com.obric.memorydata.plugin");
        if (this.bytes.length == r6.length()) goto L8;
        return false;
    L8:
        int r0 = 0;
    L9:
        int[] r1 = this.bytes;
        if (r0 >= r1.length) goto L15;
        if (r1[r0] != r6.get(r0)) goto L13;
        r0 = r0 + 1;
        goto L9
    L13:
        return false;
    L15:
        return true;
    }

    public int get(int r1) {
        return this.bytes[r1];
    }

    public byte[] getBytes() {
        byte[] r0 = IOUtils.byteArray(this.bytes.length);
        int r1 = 0;
    L3:
        int[] r2 = this.bytes;
        if (r1 >= r2.length) goto L6;
        r0[r1] = (byte) r2[r1];
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public String getCharsetName() {
        return this.charsetName;
    }

    public int hashCode() {
        int r0 = getClass().hashCode();
        int[] r4 = this.bytes;
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0 = r0 + r4[r2];
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public int length() {
        return this.bytes.length;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(getClass().getSimpleName());
        r0.append('[');
        r0.append(this.charsetName);
        r0.append(": ");
        int r1 = 0;
    L4:
        if (r1 >= this.bytes.length) goto L8;
        if (r1 <= 0) goto L7;
        r0.append(",");
    L7:
        r0.append("0x");
        r0.append(Integer.toHexString(this.bytes[r1] & 255).toUpperCase(Locale.ROOT));
        r1 = r1 + 1;
        goto L4
    L8:
        r0.append(']');
        return r0.toString();
    }
}
