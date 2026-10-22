package org.apache.poi.poifs.crypt.xor;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class XOREncryptionVerifier extends EncryptionVerifier {
    public XOREncryptionVerifier() {
        setEncryptedKey(new byte[2]);
        setEncryptedVerifier(new byte[2]);
    }

    public XOREncryptionVerifier(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        byte[] r1 = new byte[2];
        r4.readFully(r1);
        setEncryptedKey(r1);
        byte[] r0 = new byte[2];
        r4.readFully(r0);
        setEncryptedVerifier(r0);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public final void setEncryptedKey(byte[] r1) {
        super.setEncryptedKey(r1);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public final void setEncryptedVerifier(byte[] r1) {
        super.setEncryptedVerifier(r1);
    }

    public void write(LittleEndianByteArrayOutputStream r2) {
        r2.write(getEncryptedKey());
        r2.write(getEncryptedVerifier());
    }
}
