package org.apache.poi.poifs.crypt.xor;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class XORDecryptor extends Decryptor {
    private int chunkSize;
    private long length;

    private class XORCipherInputStream extends ChunkedCipherInputStream {
        private final int initialOffset;
        private int recordEnd;
        private int recordStart;
        final /* synthetic */ XORDecryptor this$0;

        public XORCipherInputStream(XORDecryptor r3, InputStream r4, int r5) {
            this.this$0 = r3;
            super(r4, 2147483647L, XORDecryptor.access$000(r3));
            this.initialOffset = r5;
        }

        private byte rotateLeft(byte r1, int r2) {
            int r0 = r1 & 255;
            int r3 = r0 << r2;
            return (byte) ((r0 >>> (8 - r2)) | r3);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public Cipher initCipherForBlock(Cipher r1, int r2) {
            return this.this$0.initCipherForBlock(r1, r2);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public int invokeCipher(int r10, boolean r11) {
            int r12 = (int) getPos();
            byte[] r0 = this.this$0.getEncryptionInfo().getDecryptor().getSecretKey().getEncoded();
            byte[] r1 = getChunk();
            byte[] r2 = getPlain();
            int r3 = getChunkMask() & r12;
            int r4 = (this.initialOffset + this.recordEnd) + (r12 - this.recordStart);
            int r5 = 0;
        L4:
            if ((r12 + r5) >= this.recordEnd) goto L7;
            if (r5 >= r10) goto L7;
            int r6 = r3 + r5;
            r1[r6] = (byte) (rotateLeft(r2[r6], 3) ^ r0[(r4 + r5) & 15]);
            r5 = r5 + 1;
        L7:
            return r10;
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public void setNextRecordSize(int r5) {
            int r0 = (int) getPos();
            byte[] r1 = getChunk();
            int r2 = getChunkMask();
            this.recordStart = r0;
            this.recordEnd = r0 + r5;
            invokeCipher(Math.min(r5, r1.length - (r0 & r2)), true);
        }
    }

    public XORDecryptor() {
        this.length = -1;
        this.chunkSize = 512;
    }

    static /* synthetic */ int access$000(XORDecryptor r0) {
        return r0.chunkSize;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(InputStream r1, int r2, int r3) {
        return new XORCipherInputStream(this, r1, r3);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public /* bridge */ /* synthetic */ InputStream getDataStream(DirectoryNode r1) {
        return getDataStream(r1);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public ChunkedCipherInputStream getDataStream(DirectoryNode r1) {
        throw new EncryptedDocumentException("not supported");
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public Cipher initCipherForBlock(Cipher r1, int r2) {
        return null;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public void setChunkSize(int r1) {
        this.chunkSize = r1;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String r5) {
        XOREncryptionVerifier r0 = (XOREncryptionVerifier) ZeusTransformUtils.preCheckCast(getEncryptionInfo().getVerifier(), XOREncryptionVerifier.class, "com.obric.memorydata.plugin");
        int r1 = LittleEndian.getUShort(r0.getEncryptedKey());
        int r2 = LittleEndian.getUShort(r0.getEncryptedVerifier());
        int r3 = CryptoFunctions.createXorKey1(r5);
        int r4 = CryptoFunctions.createXorVerifier1(r5);
        if (r1 != r3) goto L7;
        if (r2 != r4) goto L9;
        setSecretKey(new SecretKeySpec(CryptoFunctions.createXorArray1(r5), "XOR"));
        return true;
    L9:
        return false;
    L7:
        return false;
    }
}
