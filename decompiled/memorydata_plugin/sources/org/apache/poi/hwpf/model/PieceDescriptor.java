package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.util.Objects;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class PieceDescriptor {
    private final Charset charset;
    private final short descriptor;
    int fc;
    private final PropertyModifier prm;
    private final boolean unicode;

    public PieceDescriptor(byte[] r2, int r3) {
        this(r2, r3, null);
    }

    public PieceDescriptor(byte[] r2, int r3, Charset r4) {
        this.descriptor = LittleEndian.getShort(r2, r3);
        int r5 = r3 + 2;
        this.fc = LittleEndian.getInt(r2, r5);
        this.prm = new PropertyModifier(LittleEndian.getShort(r2, r5 + 4));
        if (r4 != null) goto L10;
        int r6 = this.fc;
        if ((1073741824 & r6) != 0) goto L7;
        this.unicode = true;
        Charset r7 = null;
    L8:
        this.charset = r7;
        return;
    L7:
        this.unicode = false;
        int r8 = (-1073741825) & r6;
        this.fc = r8;
        this.fc = r8 / 2;
        r7 = StringUtil.WIN_1252;
        goto L8
    L10:
        if (r4 != StringUtil.UTF16LE) goto L12;
        this.unicode = true;
    L13:
        this.charset = r4;
        return;
    L12:
        this.unicode = false;
        goto L13
    }

    public static int getSizeInBytes() {
        return 8;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        PieceDescriptor r6 = (PieceDescriptor) ZeusTransformUtils.preCheckCast(r5, PieceDescriptor.class, "com.obric.memorydata.plugin");
        if (this.descriptor == r6.descriptor) goto L14;
        return false;
    L14:
        PropertyModifier r2 = this.prm;
        if (r2 != null) goto L20;
        if (r6.prm == null) goto L23;
        return false;
    L23:
        if (this.unicode == r6.unicode) goto L25;
        return false;
    L25:
        return true;
    L20:
        if (r2.equals(r6.prm) == true) goto L23;
        return false;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public int getFilePosition() {
        return this.fc;
    }

    public PropertyModifier getPrm() {
        return this.prm;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Short.valueOf(this.descriptor), this.prm, Boolean.valueOf(this.unicode)});
    }

    public boolean isUnicode() {
        return this.unicode;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("PieceDescriptor (pos: ").append(getFilePosition()).append("; ");
        if (isUnicode() == false) goto L5;
        String r1 = "unicode";
    L7:
        return r0.append(r1).append("; prm: ").append(getPrm()).append(")").toString();
    L5:
        r1 = "non-unicode";
        goto L7
    }
}
