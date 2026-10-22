package org.apache.poi.poifs.crypt.standard;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CipherProvider;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class StandardEncryptionHeader extends EncryptionHeader {
    public StandardEncryptionHeader(CipherAlgorithm r2, HashAlgorithm r3, int r4, int r5, ChainingMode r6) {
        setCipherAlgorithm(r2);
        setHashAlgorithm(r3);
        setKeySize(r4);
        setBlockSize(r5);
        setCipherProvider(r2.provider);
        boolean r7 = true;
        int r8 = EncryptionInfo.flagCryptoAPI.setBoolean(0, true);
        BitField r9 = EncryptionInfo.flagAES;
        if (r2.provider == CipherProvider.aes) goto L6;
        r7 = false;
    L6:
        setFlags(r9.setBoolean(0, r7) | r8);
    }

    public StandardEncryptionHeader(LittleEndianInput r4) {
        LittleEndianInput r5 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r4, LittleEndianInput.class, "com.obric.memorydata.plugin");
        setFlags(r5.readInt());
        setSizeExtra(r5.readInt());
        setCipherAlgorithm(CipherAlgorithm.fromEcmaId(r5.readInt()));
        setHashAlgorithm(HashAlgorithm.fromEcmaId(r5.readInt()));
        int r0 = r5.readInt();
        if (r0 != 0) goto L5;
        r0 = 40;
    L5:
        setKeySize(r0);
        setBlockSize(getKeySize());
        setCipherProvider(CipherProvider.fromEcmaId(r5.readInt()));
        r5.readLong();
        if (ZeusTransformUtils.instanceOf(r5, RecordInputStream.class) == false) goto L8;
        ((RecordInputStream) ZeusTransformUtils.preCheckCast(r5, RecordInputStream.class, "com.obric.memorydata.plugin")).mark(5);
    L9:
        int r1 = r5.readInt();
        if (ZeusTransformUtils.instanceOf(r5, RecordInputStream.class) == false) goto L12;
        ((RecordInputStream) ZeusTransformUtils.preCheckCast(r5, RecordInputStream.class, "com.obric.memorydata.plugin")).reset();
    L14:
        if (r1 != 16) goto L17;
        String r6 = "";
    L16:
        setCspName(r6);
        setChainingMode(ChainingMode.ecb);
        setKeySalt(null);
        return;
    L17:
        StringBuilder r2 = new StringBuilder();
    L18:
        char r3 = (char) r5.readShort();
        if (r3 == 0) goto L20;
        r2.append(r3);
        goto L18
    L20:
        r6 = r2.toString();
        goto L16
    L12:
        ((InputStream) ZeusTransformUtils.preCheckCast(r5, InputStream.class, "com.obric.memorydata.plugin")).reset();
        goto L14
    L8:
        ((InputStream) ZeusTransformUtils.preCheckCast(r5, InputStream.class, "com.obric.memorydata.plugin")).mark(5);
        goto L9
    }

    public void write(LittleEndianByteArrayOutputStream r6) {
        int r0 = r6.getWriteIndex();
        LittleEndianOutput r2 = r6.createDelayedOutput(4);
        r6.writeInt(getFlags());
        r6.writeInt(0);
        r6.writeInt(getCipherAlgorithm().ecmaId);
        r6.writeInt(getHashAlgorithm().ecmaId);
        r6.writeInt(getKeySize());
        r6.writeInt(getCipherProvider().ecmaId);
        r6.writeInt(0);
        r6.writeInt(0);
        String r4 = getCspName();
        if (r4 != null) goto L5;
        r4 = getCipherProvider().cipherProviderName;
    L5:
        r6.write(StringUtil.getToUnicodeLE(r4));
        r6.writeShort(0);
        r2.writeInt((r6.getWriteIndex() - r0) - 4);
    }
}
