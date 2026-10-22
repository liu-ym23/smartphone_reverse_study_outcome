package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hslf.model.textproperties.TextPFException9;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class StyleTextProp9Atom extends RecordAtom {
    private static int MAX_RECORD_LENGTH = 100000;
    private final TextPFException9[] autoNumberSchemes;
    private byte[] data;
    private byte[] header;
    private int length;
    private short recordId;
    private short version;

    static {
    }

    public StyleTextProp9Atom(byte[] r5, int r6, int r7) {
        LinkedList r0 = new LinkedList();
        int r1 = r6 + 8;
        byte[] r8 = Arrays.copyOfRange(r5, r6, r1);
        this.header = r8;
        this.version = LittleEndian.getShort(r8, 0);
        this.recordId = LittleEndian.getShort(this.header, 2);
        this.length = LittleEndian.getInt(this.header, 4);
        this.data = IOUtils.safelyClone(r5, r1, r7 - 8, MAX_RECORD_LENGTH);
        int r9 = 0;
    L4:
        if (r9 >= this.data.length) goto L16;
        TextPFException9 r10 = new TextPFException9(this.data, r9);
        r0.add(r10);
        int r11 = r9 + r10.getRecordLength();
        int r12 = r11 + 4;
        byte[] r13 = this.data;
        if (r12 >= r13.length) goto L16;
        LittleEndian.getInt(r13, r11);
        r9 = r12 + 4;
        byte[] r14 = this.data;
        if (r9 >= r14.length) goto L16;
        if ((LittleEndian.getInt(r14, r12) & 64) == 0) goto L15;
        r9 = r9 + 2;
    L15:
        if ((r9 + 4) < this.data.length) goto L4;
    L16:
        this.autoNumberSchemes = (TextPFException9[]) ZeusTransformUtils.preCheckCast(r0.toArray(new TextPFException9[0]), TextPFException9[].class, "com.obric.memorydata.plugin");
    }

    public TextPFException9[] getAutoNumberTypes() {
        return this.autoNumberSchemes;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("autoNumberSchemes", new $$Lambda$FDMUkrkGjlzskHJ9q_uVe8xFd8(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return this.recordId;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this.header);
        r2.write(this.data);
    }
}
