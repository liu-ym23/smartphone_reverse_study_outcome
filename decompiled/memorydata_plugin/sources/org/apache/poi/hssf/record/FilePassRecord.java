package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4EncryptionHeader;
import org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4EncryptionVerifier;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptionHeader;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptionVerifier;
import org.apache.poi.poifs.crypt.xor.XOREncryptionHeader;
import org.apache.poi.poifs.crypt.xor.XOREncryptionVerifier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.LittleEndianOutputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class FilePassRecord extends StandardRecord {
    private final EncryptionInfo encryptionInfo;
    private final int encryptionType;

    /* JADX INFO: renamed from: org.apache.poi.hssf.record.FilePassRecord$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode = null;

        static {
            int[] r0 = new int[EncryptionMode.values().length];
            $SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode = r0;
            r0[EncryptionMode.xor.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode[EncryptionMode.binaryRC4.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode[EncryptionMode.cryptoAPI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public FilePassRecord(RecordInputStream r3) {
        int r0 = r3.readUShort();
        this.encryptionType = r0;
        if (r0 != 0) goto L5;
        EncryptionMode r1 = EncryptionMode.xor;
    L15:
        this.encryptionInfo = new EncryptionInfo(r3, r1);     // Catch: IOException -> L12
        return;
    L12:
        e = move-exception;
        throw new EncryptedDocumentException(e);
    L5:
        if (r0 != 1) goto L8;
        r1 = EncryptionMode.cryptoAPI;
        goto L15
    L8:
        throw new EncryptedDocumentException("invalid encryption type");
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        UnsynchronizedByteArrayOutputStream r0 = new UnsynchronizedByteArrayOutputStream();
        serialize(new LittleEndianOutputStream(r0));
        return r0.size();
    }

    public EncryptionInfo getEncryptionInfo() {
        return this.encryptionInfo;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("type", new $$Lambda$FilePassRecord$Gqd1Wu7eQuZQeUpNt1QbZiGcFn4(this), "encryptionInfo", new $$Lambda$mVCZGIdALXFu3FC9WbtgpmGDPU(this));
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FILE_PASS;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 47;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$FilePassRecord() {
        return Integer.valueOf(this.encryptionType);
    }

    public void serialize(LittleEndianOutput r7) {
        LittleEndianOutput r8 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r7, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        r8.writeShort(this.encryptionType);
        byte[] r0 = new byte[1024];
        LittleEndianByteArrayOutputStream r2 = new LittleEndianByteArrayOutputStream(r0, 0);     // Catch: IOException -> L26
        int r4 = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$crypt$EncryptionMode[this.encryptionInfo.getEncryptionMode().ordinal()];     // Catch: Throwable -> L18
        if (r4 != 1) goto L7;
        ((XOREncryptionHeader) ZeusTransformUtils.preCheckCast(this.encryptionInfo.getHeader(), XOREncryptionHeader.class, "com.obric.memorydata.plugin")).write(r2);     // Catch: Throwable -> L18
        ((XOREncryptionVerifier) ZeusTransformUtils.preCheckCast(this.encryptionInfo.getVerifier(), XOREncryptionVerifier.class, "com.obric.memorydata.plugin")).write(r2);     // Catch: Throwable -> L18
    L15:
        r8.write(r0, 0, r2.getWriteIndex());     // Catch: Throwable -> L18
        r2.close();     // Catch: IOException -> L26
        return;
    L7:
        if (r4 != 2) goto L9;
        r8.writeShort(this.encryptionInfo.getVersionMajor());     // Catch: Throwable -> L18
        r8.writeShort(this.encryptionInfo.getVersionMinor());     // Catch: Throwable -> L18
        ((BinaryRC4EncryptionHeader) ZeusTransformUtils.preCheckCast(this.encryptionInfo.getHeader(), BinaryRC4EncryptionHeader.class, "com.obric.memorydata.plugin")).write(r2);     // Catch: Throwable -> L18
        ((BinaryRC4EncryptionVerifier) ZeusTransformUtils.preCheckCast(this.encryptionInfo.getVerifier(), BinaryRC4EncryptionVerifier.class, "com.obric.memorydata.plugin")).write(r2);     // Catch: Throwable -> L18
        goto L15
    L9:
        if (r4 != 3) goto L12;
        r8.writeShort(this.encryptionInfo.getVersionMajor());     // Catch: Throwable -> L18
        r8.writeShort(this.encryptionInfo.getVersionMinor());     // Catch: Throwable -> L18
        r8.writeInt(this.encryptionInfo.getEncryptionFlags());     // Catch: Throwable -> L18
        ((CryptoAPIEncryptionHeader) ZeusTransformUtils.preCheckCast(this.encryptionInfo.getHeader(), CryptoAPIEncryptionHeader.class, "com.obric.memorydata.plugin")).write(r2);     // Catch: Throwable -> L18
        ((CryptoAPIEncryptionVerifier) ZeusTransformUtils.preCheckCast(this.encryptionInfo.getVerifier(), CryptoAPIEncryptionVerifier.class, "com.obric.memorydata.plugin")).write(r2);     // Catch: Throwable -> L18
        goto L15
    L12:
        throw new EncryptedDocumentException("not supported");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: IOException -> L26
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L26
    L26:
        e = move-exception;
        throw new IllegalStateException(e);
    }
}
