package org.apache.poi.poifs.crypt.agile;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.XMLHelper;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/* JADX INFO: loaded from: classes7.dex */
public class AgileEncryptionInfoBuilder implements EncryptionInfoBuilder {
    public AgileEncryptionInfoBuilder() {
    }

    public static EncryptionDocument parseDescriptor(InputStream r1) {
        return parseDescriptor(new InputSource(r1));
    }

    private static EncryptionDocument parseDescriptor(InputSource r2) {
        Document r3 = XMLHelper.newDocumentBuilder().parse(r2);     // Catch: Throwable -> L4
        EncryptionDocument r0 = new EncryptionDocument();     // Catch: Throwable -> L4
        r0.parse(r3);     // Catch: Throwable -> L4
        return r0;
    L4:
        e = move-exception;
        throw new EncryptedDocumentException("Unable to parse encryption descriptor", e);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo r7, CipherAlgorithm r8, HashAlgorithm r9, int r10, int r11, ChainingMode r12) {
        if (r8 != null) goto L5;
        r8 = CipherAlgorithm.aes128;
    L5:
        if (r8 == CipherAlgorithm.rc4) goto L35;
        if (r9 != null) goto L8;
        r9 = HashAlgorithm.sha1;
    L8:
        if (r12 != null) goto L11;
        r12 = ChainingMode.cbc;
    L11:
        if (r12 == ChainingMode.cbc) goto L18;
        if (r12 == ChainingMode.cfb) goto L18;
        throw new EncryptedDocumentException("Agile encryption only supports CBC/CFB chaining.");
    L18:
        if (r10 != (-1)) goto L20;
        r10 = r8.defaultKeySize;
    L20:
        if (r11 != (-1)) goto L22;
        r11 = r8.blockSize;
    L22:
        int[] r6 = r8.allowedKeySize;
        int r0 = r6.length;
        int r2 = 0;
        boolean r3 = false;
    L23:
        if (r2 >= r0) goto L29;
        if (r6[r2] != r10) goto L27;
        boolean r4 = true;
    L28:
        r3 = r3 | r4;
        r2 = r2 + 1;
        goto L23
    L27:
        r4 = false;
        goto L28
    L29:
        if (r3 == false) goto L33;
        CipherAlgorithm r1 = r8;
        HashAlgorithm r5 = r9;
        int r13 = r10;
        int r14 = r11;
        ChainingMode r15 = r12;
        r7.setHeader(new AgileEncryptionHeader(r1, r5, r13, r14, r15));
        r7.setVerifier(new AgileEncryptionVerifier(r1, r5, r13, r14, r15));
        AgileDecryptor r16 = new AgileDecryptor();
        r16.setEncryptionInfo(r7);
        r7.setDecryptor(r16);
        AgileEncryptor r17 = new AgileEncryptor();
        r17.setEncryptionInfo(r7);
        r7.setEncryptor(r17);
        return;
    L33:
        throw new EncryptedDocumentException("KeySize " + r10 + " not allowed for Cipher " + r8);
    L35:
        throw new EncryptedDocumentException("RC4 must not be used with agile encryption.");
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo r2, LittleEndianInput r3) {
        EncryptionDocument r1 = parseDescriptor((InputStream) ZeusTransformUtils.preCheckCast((LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin"), InputStream.class, "com.obric.memorydata.plugin"));
        r2.setHeader(new AgileEncryptionHeader(r1));
        r2.setVerifier(new AgileEncryptionVerifier(r1));
        if (r2.getVersionMajor() == EncryptionMode.agile.versionMajor) goto L5;
        return;
    L5:
        if (r2.getVersionMinor() != EncryptionMode.agile.versionMinor) goto L9;
        AgileDecryptor r4 = new AgileDecryptor();
        r4.setEncryptionInfo(r2);
        r2.setDecryptor(r4);
        AgileEncryptor r5 = new AgileEncryptor();
        r5.setEncryptionInfo(r2);
        r2.setEncryptor(r5);
        return;
    }
}
