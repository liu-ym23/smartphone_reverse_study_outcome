package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseCipherSpi extends CipherSpi {
    private final JcaJceHelper helper;
    protected Wrapper wrapEngine;

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key r2) {
        return ((Key) ZeusTransformUtils.wrapperContextForParams(r2, Key.class, "com.obric.memorydata.plugin")).getEncoded().length;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int r1) {
        return -1;
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String r3) {
        throw new NoSuchAlgorithmException("can't support mode " + r3);
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String r3) {
        throw new NoSuchPaddingException("Padding " + r3 + " unknown.");
    }

    @Override // javax.crypto.CipherSpi
    public Key engineUnwrap(byte[] r5, String r6, int r7) {
        Wrapper r1 = this.wrapEngine;     // Catch: IllegalBlockSizeException -> L39 BadPaddingException -> L42 InvalidCipherTextException -> L45
        if (r1 != null) goto L6;
        byte[] r8 = engineDoFinal(r5, 0, r5.length);     // Catch: IllegalBlockSizeException -> L39 BadPaddingException -> L42 InvalidCipherTextException -> L45
    L8:
        if (r7 != 3) goto L12;
        return new SecretKeySpec(r8, r6);
    L12:
        if (r6.equals("") == false) goto L50;
        if (r7 != 2) goto L50;
        PrivateKeyInfo r4 = PrivateKeyInfo.getInstance(r8);     // Catch: Exception -> L19
        PrivateKey r9 = BouncyCastleProvider.getPrivateKey(r4);     // Catch: Exception -> L19
        if (r9 == null) goto L18;
        return r9;
    L18:
        throw new InvalidKeyException("algorithm " + r4.getPrivateKeyAlgorithm().getAlgorithm() + " not supported");     // Catch: Exception -> L19
    L20:
        throw new InvalidKeyException("Invalid key encoding.");
    L50:
        KeyFactory r10 = this.helper.createKeyFactory(r6);     // Catch: NoSuchProviderException -> L30 InvalidKeySpecException -> L33 NoSuchAlgorithmException -> L36
        if (r7 == 1) goto L24;
        if (r7 != 2) goto L29;
        return r10.generatePrivate(new PKCS8EncodedKeySpec(r8));
    L29:
        throw new InvalidKeyException("Unknown key type " + r7);
    L24:
        return r10.generatePublic(new X509EncodedKeySpec(r8));
    L36:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L30:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L33:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L6:
        r8 = r1.unwrap(r5, 0, r5.length);     // Catch: IllegalBlockSizeException -> L39 BadPaddingException -> L42 InvalidCipherTextException -> L45
    L42:
        e = move-exception;
        final String r11 = "unable to unwrap";
        throw new AnonymousClass1(this, r11, e);
    L39:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    L45:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key r3) {
        byte[] r4 = ((Key) ZeusTransformUtils.wrapperContextForParams(r3, Key.class, "com.obric.memorydata.plugin")).getEncoded();
        if (r4 == null) goto L14;
        Wrapper r0 = this.wrapEngine;     // Catch: BadPaddingException -> L10
        if (r0 != null) goto L9;
        return engineDoFinal(r4, 0, r4.length);
    L9:
        return r0.wrap(r4, 0, r4.length);
    L10:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());
    L14:
        throw new InvalidKeyException("Cannot wrap key, null encoding.");
    }
}
