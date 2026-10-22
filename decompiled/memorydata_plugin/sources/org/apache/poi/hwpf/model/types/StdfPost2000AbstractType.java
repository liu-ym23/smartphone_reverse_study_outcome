package org.apache.poi.hwpf.model.types;

import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public abstract class StdfPost2000AbstractType {
    private static final BitField fHasOriginalStyle = null;
    private static final BitField fSpare = null;
    private static final BitField iPriority = null;
    private static final BitField iftcHtml = null;
    private static final BitField istdLink = null;
    private static final BitField unused = null;
    protected short field_1_info1;
    protected long field_2_rsid;
    protected short field_3_info3;

    static {
        istdLink = new BitField(4095);
        fHasOriginalStyle = new BitField(4096);
        fSpare = new BitField(57344);
        iftcHtml = new BitField(7);
        unused = new BitField(8);
        iPriority = new BitField(65520);
    }

    public StdfPost2000AbstractType() {
    }

    public void fillFields(byte[] r3, int r4) {
        this.field_1_info1 = LittleEndian.getShort(r3, r4 + 0);
        this.field_2_rsid = LittleEndian.getUInt(r3, r4 + 2);
        this.field_3_info3 = LittleEndian.getShort(r3, r4 + 6);
    }

    public byte getFSpare() {
        return (byte) fSpare.getValue(this.field_1_info1);
    }

    public short getIPriority() {
        return (short) iPriority.getValue(this.field_3_info3);
    }

    public byte getIftcHtml() {
        return (byte) iftcHtml.getValue(this.field_3_info3);
    }

    public short getInfo1() {
        return this.field_1_info1;
    }

    public short getInfo3() {
        return this.field_3_info3;
    }

    public short getIstdLink() {
        return (short) istdLink.getValue(this.field_1_info1);
    }

    public long getRsid() {
        return this.field_2_rsid;
    }

    public boolean isFHasOriginalStyle() {
        return fHasOriginalStyle.isSet(this.field_1_info1);
    }

    public boolean isUnused() {
        return unused.isSet(this.field_3_info3);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[StdfPost2000]\n");
        r0.append("    .info1                = ");
        r0.append(" (").append(getInfo1()).append(" )\n");
        r0.append("         .istdLink                 = ").append(getIstdLink()).append('\n');
        r0.append("         .fHasOriginalStyle        = ").append(isFHasOriginalStyle()).append('\n');
        r0.append("         .fSpare                   = ").append(getFSpare()).append('\n');
        r0.append("    .rsid                 = ");
        r0.append(" (").append(getRsid()).append(" )\n");
        r0.append("    .info3                = ");
        r0.append(" (").append(getInfo3()).append(" )\n");
        r0.append("         .iftcHtml                 = ").append(getIftcHtml()).append('\n');
        r0.append("         .unused                   = ").append(isUnused()).append('\n');
        r0.append("         .iPriority                = ").append(getIPriority()).append('\n');
        r0.append("[/StdfPost2000]\n");
        return r0.toString();
    }
}
