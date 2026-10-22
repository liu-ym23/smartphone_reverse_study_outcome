package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
public class Formula implements GenericRecord {
    private static final Formula EMPTY = null;
    private final byte[] _byteEncoding;
    private final int _encodedTokenLen;

    static {
        EMPTY = new Formula(new byte[0], 0);
    }

    private Formula(byte[] r3, int r4) {
        this._byteEncoding = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
        this._encodedTokenLen = r4;
    }

    public static Formula create(Ptg[] r2) {
        if (r2 == null) goto L9;
        if (r2.length < 1) goto L9;
        byte[] r0 = new byte[Ptg.getEncodedSize(r2)];
        Ptg.serializePtgs(r2, r0, 0);
        return new Formula(r0, Ptg.getEncodedSizeWithoutArrayData(r2));
    L9:
        return EMPTY;
    }

    public static Ptg[] getTokens(Formula r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getTokens();
    }

    public static Formula read(int r2, LittleEndianInput r3) {
        return read(r2, (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin"), r2);
    }

    public static Formula read(int r2, LittleEndianInput r3, int r4) {
        LittleEndianInput r5 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        byte[] r6 = IOUtils.safelyAllocate(r4, 100000);
        r5.readFully(r6);
        return new Formula(r6, r2);
    }

    public int getEncodedSize() {
        return this._byteEncoding.length + 2;
    }

    public int getEncodedTokenSize() {
        return this._encodedTokenLen;
    }

    public CellReference getExpReference() {
        byte[] r4 = this._byteEncoding;
        if (r4.length == 5) goto L5;
        return null;
    L5:
        byte r0 = r4[0];
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L11;
        return null;
    L11:
        return new CellReference(LittleEndian.getUShort(r4, 1), LittleEndian.getUShort(r4, 3));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("tokens", new $$Lambda$jJdZKyRse0KT9yuP3blrS24QSEY(this), "expReference", new $$Lambda$uV0LdvJX7zCxE3Q2tAjovtkZF24(this));
    }

    public Ptg[] getTokens() {
        LittleEndianByteArrayInputStream r0 = new LittleEndianByteArrayInputStream(this._byteEncoding);
        return Ptg.readTokens(this._encodedTokenLen, r0);
    }

    public void serializeArrayConstantData(LittleEndianOutput r3) {
        LittleEndianOutput r4 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        byte[] r0 = this._byteEncoding;
        int r1 = r0.length;
        int r2 = this._encodedTokenLen;
        r4.write(r0, r2, r1 - r2);
    }

    public void serializeTokens(LittleEndianOutput r3) {
        ((LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin")).write(this._byteEncoding, 0, this._encodedTokenLen);
    }
}
