package org.apache.poi.hssf.record;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class WriteAccessRecord extends StandardRecord {
    private static final byte[] PADDING = null;
    private static final BitField UTF16FLAG = null;
    private String field_1_username;

    static {
        UTF16FLAG = BitFieldFactory.getInstance(1);
        byte[] r0 = new byte[109];
        PADDING = r0;
        Arrays.fill(r0, (byte) 32);
    }

    public WriteAccessRecord() {
        setUsername("");
    }

    public WriteAccessRecord(RecordInputStream r10) {
        if (r10.remaining() > 112) goto L31;
        int r0 = r10.readUShort();
        int r2 = r10.readUByte();
        if (r0 > 109) goto L16;
        if ((r2 & 254) != 0) goto L16;
        byte[] r1 = IOUtils.safelyAllocate(r10.remaining(), 109);
        r10.readFully(r1);
        if (UTF16FLAG.isSet(r2) == false) goto L13;
        int r11 = Math.min(r0 * 2, r1.length);
    L12:
        Charset r3 = StandardCharsets.UTF_16LE;
    L28:
        setUsername(new String(r1, 0, r11, r3).trim());
        return;
    L13:
        r11 = Math.min(r0, r1.length);
    L14:
        r3 = StandardCharsets.ISO_8859_1;
    L16:
        if (r10.isEncrypted() == false) goto L27;
        r1 = IOUtils.safelyAllocate(r10.remaining(), 109);
        r10.readPlain(r1, 0, r1.length);
        r11 = r1.length;
    L18:
        if (r11 <= 0) goto L23;
        if (r1[r11 - 1] != 32) goto L23;
        r11 = r11 - 1;
    L23:
        if (r1.length <= 1) goto L14;
        if (r1[1] != 0) goto L14;
    L27:
        int r5 = r10.remaining() + 3;
        r1 = IOUtils.safelyAllocate(r5, 112);
        LittleEndian.putUShort(r1, 0, r0);
        LittleEndian.putByte(r1, 2, r2);
        r10.readFully(r1, 3, r5 - 3);
        r3 = StandardCharsets.UTF_8;
        r11 = r5;
        goto L28
    L31:
        throw new RecordFormatException("Expected data size (112) but got (" + r10.remaining() + ")");
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return 112;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("username", new $$Lambda$NUrCkycH_Cm2MTQ7nAe8Ep171A(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.WRITE_ACCESS;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 92;
    }

    public String getUsername() {
        return this.field_1_username;
    }

    public void setUsername(String r3) {
        boolean r0 = StringUtil.hasMultibyte(r3);
        int r1 = r3.length();
        if (r0 == false) goto L5;
        int r2 = 2;
    L7:
        if ((r1 * r2) > 109) goto L11;
        this.field_1_username = r3;
        return;
    L11:
        throw new IllegalArgumentException("Name is too long: " + r3);
    L5:
        r2 = 1;
        goto L7
    }
}
