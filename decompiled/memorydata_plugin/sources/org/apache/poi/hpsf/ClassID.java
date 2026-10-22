package org.apache.poi.hpsf;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class ClassID implements GenericRecord {
    private final byte[] bytes;

    public ClassID() {
        byte[] r0 = new byte[16];
        this.bytes = r0;
        Arrays.fill(r0, (byte) 0);
    }

    public ClassID(String r6) {
        this.bytes = new byte[16];
        String r7 = r6.replaceAll("[{}-]", "");
        int r1 = 0;
    L4:
        if (r1 >= r7.length()) goto L6;
        int r4 = r1 + 2;
        this.bytes[r1 / 2] = (byte) Integer.parseInt(r7.substring(r1, r4), 16);
        r1 = r4;
        goto L4
    }

    public ClassID(LittleEndianInput r4) {
        LittleEndianInput r5 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r4, LittleEndianInput.class, "com.obric.memorydata.plugin");
        byte[] r0 = new byte[16];
        this.bytes = r0;
        byte[] r1 = (byte[]) ZeusTransformUtils.preCheckCast(r0.clone(), byte[].class, "com.obric.memorydata.plugin");
        r5.readFully(r1);
        read(r1, 0);
    }

    public ClassID(byte[] r2, int r3) {
        this.bytes = new byte[16];
        read(r2, r3);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ClassID.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(this.bytes, ((ClassID) ZeusTransformUtils.preCheckCast(r3, ClassID.class, "com.obric.memorydata.plugin")).bytes) == false) goto L7;
        return true;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(Api.KEY_UUID, new $$Lambda$Wx15YXlr7KI7tApSqvcqJbwhR5s(this));
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public byte[] read(byte[] r4, int r5) {
        byte[] r0 = this.bytes;
        r0[0] = r4[r5 + 3];
        r0[1] = r4[r5 + 2];
        r0[2] = r4[r5 + 1];
        r0[3] = r4[r5 + 0];
        r0[4] = r4[r5 + 5];
        r0[5] = r4[r5 + 4];
        r0[6] = r4[r5 + 7];
        r0[7] = r4[r5 + 6];
        System.arraycopy(r4, r5 + 8, r0, 8, 8);
        return this.bytes;
    }

    public String toString() {
        return "{" + toUUIDString() + "}";
    }

    public UUID toUUID() {
        return new UUID(ByteBuffer.wrap(this.bytes, 0, 8).getLong(), ByteBuffer.wrap(this.bytes, 8, 8).getLong());
    }

    public String toUUIDString() {
        return toUUID().toString().toUpperCase(Locale.ROOT);
    }
}
