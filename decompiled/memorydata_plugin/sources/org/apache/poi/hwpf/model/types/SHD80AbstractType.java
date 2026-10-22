package org.apache.poi.hwpf.model.types;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class SHD80AbstractType {
    private static final BitField icoBack = null;
    private static final BitField icoFore = null;
    private static final BitField ipat = null;
    protected short field_1_value;

    static {
        icoFore = new BitField(31);
        icoBack = new BitField(992);
        ipat = new BitField(64512);
    }

    public SHD80AbstractType() {
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
        SHD80AbstractType r6 = (SHD80AbstractType) ZeusTransformUtils.preCheckCast(r5, SHD80AbstractType.class, "com.obric.memorydata.plugin");
        if (this.field_1_value == r6.field_1_value) goto L14;
        return false;
    L14:
        return true;
    }

    public void fillFields(byte[] r1, int r2) {
        this.field_1_value = LittleEndian.getShort(r1, r2 + 0);
    }

    public byte getIcoBack() {
        return (byte) icoBack.getValue(this.field_1_value);
    }

    public byte getIcoFore() {
        return (byte) icoFore.getValue(this.field_1_value);
    }

    public byte getIpat() {
        return (byte) ipat.getValue(this.field_1_value);
    }

    public short getValue() {
        return this.field_1_value;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Short.valueOf(this.field_1_value)});
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[SHD80]\n");
        r0.append("    .value                = ");
        r0.append(" (").append(getValue()).append(" )\n");
        r0.append("         .icoFore                  = ").append(getIcoFore()).append('\n');
        r0.append("         .icoBack                  = ").append(getIcoBack()).append('\n');
        r0.append("         .ipat                     = ").append(getIpat()).append('\n');
        r0.append("[/SHD80]\n");
        return r0.toString();
    }
}
