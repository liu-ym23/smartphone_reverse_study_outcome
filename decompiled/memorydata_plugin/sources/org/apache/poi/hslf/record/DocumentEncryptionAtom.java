package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptionHeader;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptionVerifier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class DocumentEncryptionAtom extends PositionDependentRecordAtom {
    private static final long _type = 0;
    private final byte[] _header;
    private EncryptionInfo ei;

    static {
        _type = RecordTypes.DocumentEncryptionAtom.typeID;
    }

    public DocumentEncryptionAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putShort(r0, 0, 15);
        LittleEndian.putShort(r0, 2, (short) _type);
        this.ei = new EncryptionInfo(EncryptionMode.cryptoAPI);
    }

    public DocumentEncryptionAtom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        LittleEndianInputStream r5 = new LittleEndianInputStream(new ByteArrayInputStream(r2, r0, r4 - 8));     // Catch: IOException -> L15
        this.ei = new EncryptionInfo(r5, EncryptionMode.cryptoAPI);     // Catch: Throwable -> L7
        r5.close();     // Catch: IOException -> L15
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L12
    L14:
        throw th;     // Catch: IOException -> L15
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L15
    L15:
        e = move-exception;
        throw new EncryptedDocumentException(e);
    }

    public EncryptionInfo getEncryptionInfo() {
        return this.ei;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("encryptionInfo", new $$Lambda$qEkc2O9sb3zgV1eQWN6B2aLqQvY(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r7) {
        byte[] r0 = new byte[1024];
        LittleEndianByteArrayOutputStream r1 = new LittleEndianByteArrayOutputStream(r0, 0);
        r1.writeShort(this.ei.getVersionMajor());
        r1.writeShort(this.ei.getVersionMinor());
        r1.writeInt(this.ei.getEncryptionFlags());
        ((CryptoAPIEncryptionHeader) ZeusTransformUtils.preCheckCast(this.ei.getHeader(), CryptoAPIEncryptionHeader.class, "com.obric.memorydata.plugin")).write(r1);
        ((CryptoAPIEncryptionVerifier) ZeusTransformUtils.preCheckCast(this.ei.getVerifier(), CryptoAPIEncryptionVerifier.class, "com.obric.memorydata.plugin")).write(r1);
        LittleEndian.putInt(this._header, 4, r1.getWriteIndex());
        r7.write(this._header);
        r7.write(r0, 0, r1.getWriteIndex());
        r1.close();
    }
}
