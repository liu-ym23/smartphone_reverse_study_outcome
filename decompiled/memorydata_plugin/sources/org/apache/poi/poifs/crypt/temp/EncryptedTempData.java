package org.apache.poi.poifs.crypt.temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.logging.log4j.a;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.t;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.util.RandomSingleton;
import org.apache.poi.util.TempFile;

/* JADX INFO: loaded from: classes7.dex */
public class EncryptedTempData {
    private static final c LOG = null;
    private static final CipherAlgorithm cipherAlgorithm = null;
    private final byte[] ivBytes;
    private CountingOutputStream outputStream;
    private final SecretKeySpec skeySpec;
    private final File tempFile;

    static {
        LOG = b.a(EncryptedTempData.class);
        cipherAlgorithm = CipherAlgorithm.aes128;
    }

    public EncryptedTempData() {
        byte[] r1 = new byte[16];
        this.ivBytes = r1;
        byte[] r0 = new byte[16];
        RandomSingleton.getInstance().nextBytes(r1);
        RandomSingleton.getInstance().nextBytes(r0);
        this.skeySpec = new SecretKeySpec(r0, cipherAlgorithm.jceId);
        this.tempFile = TempFile.createTempFile("poi-temp-data", ".tmp");
    }

    public static /* synthetic */ String lambda$hV9YarkXhY9o9yigFHLwGW8xL8g(File r0) {
        return r0.getAbsolutePath();
    }

    public void dispose() {
        if (this.tempFile.delete() == true) goto L6;
        a r0 = LOG.atWarn();
        final File r4 = this.tempFile;
        r4.getClass();
        r0.a("{} can't be removed (or was already removed).", new t[]{new $$Lambda$EncryptedTempData$hV9YarkXhY9o9yigFHLwGW8xL8g(r4)});
        return;
    }

    public long getByteCount() {
        CountingOutputStream r2 = this.outputStream;
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.getByteCount();
    }

    public InputStream getInputStream() {
        Cipher r0 = CryptoFunctions.getCipher(this.skeySpec, cipherAlgorithm, ChainingMode.cbc, this.ivBytes, 2, "PKCS5Padding");
        return new CipherInputStream(new FileInputStream(this.tempFile), r0);
    }

    public OutputStream getOutputStream() {
        Cipher r0 = CryptoFunctions.getCipher(this.skeySpec, cipherAlgorithm, ChainingMode.cbc, this.ivBytes, 1, "PKCS5Padding");
        CountingOutputStream r1 = new CountingOutputStream(new CipherOutputStream(new FileOutputStream(this.tempFile), r0));
        this.outputStream = r1;
        return r1;
    }
}
