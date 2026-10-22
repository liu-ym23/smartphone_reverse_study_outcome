package org.bouncycastle.jcajce.provider.symmetric.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.jcajce.spec.GOST28147WrapParameterSpec;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseWrapCipher extends CipherSpi implements PBE {
    private Class[] availableSpecs;
    protected AlgorithmParameters engineParams;
    private boolean forWrapping;
    private final JcaJceHelper helper;
    private byte[] iv;
    private int ivSize;
    protected Wrapper wrapEngine;
    private ErasableOutputStream wrapStream;

    protected static final class ErasableOutputStream extends ByteArrayOutputStream {
        public ErasableOutputStream() {
        }

        public void erase() {
            Arrays.fill(this.buf, (byte) 0);
            reset();
        }

        public byte[] getBuf() {
            return this.buf;
        }
    }

    protected static class InvalidKeyOrParametersException extends InvalidKeyException {
        private final Throwable cause;

        InvalidKeyOrParametersException(String r1, Throwable r2) {
            super(r1);
            this.cause = r2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public final AlgorithmParameters createParametersInstance(String r1) {
        return this.helper.createAlgorithmParameters(r1);
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] r2, int r3, int r4, byte[] r5, int r6) {
        ErasableOutputStream r0 = this.wrapStream;
        if (r0 == null) goto L28;
        r0.write(r2, r3, r4);
    L24:
        th = move-exception;
        this.wrapStream.erase();
        throw th;
    L7:
        if (this.forWrapping == false) goto L31;
        byte[] r7 = this.wrapEngine.wrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());     // Catch: Exception -> L10 Throwable -> L24
    L15:
        if ((r7.length + r6) > r5.length) goto L20;
        System.arraycopy(r7, 0, r5, r6, r7.length);     // Catch: Throwable -> L24
        int r8 = r7.length;     // Catch: Throwable -> L24
        this.wrapStream.erase();
        return r8;
    L20:
        throw new ShortBufferException("output buffer too short for input.");     // Catch: Throwable -> L24
    L10:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());     // Catch: Throwable -> L24
    L31:
        r7 = this.wrapEngine.unwrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());     // Catch: InvalidCipherTextException -> L21 Throwable -> L24
    L21:
        e = move-exception;
        throw new BadPaddingException(e.getMessage());     // Catch: Throwable -> L24
    L28:
        throw new IllegalStateException("not supported in a wrapping mode");
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] r2, int r3, int r4) {
        ErasableOutputStream r0 = this.wrapStream;
        if (r0 == null) goto L24;
        if (r2 == null) goto L29;
        r0.write(r2, r3, r4);
    L29:
    L20:
        th = move-exception;
        this.wrapStream.erase();
        throw th;
    L8:
        if (this.forWrapping == false) goto L27;
        byte[] r5 = this.wrapEngine.wrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());     // Catch: Exception -> L12 Throwable -> L20
    L10:
        this.wrapStream.erase();
        return r5;
    L12:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());     // Catch: Throwable -> L20
    L27:
        r5 = this.wrapEngine.unwrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());     // Catch: InvalidCipherTextException -> L17 Throwable -> L20
    L17:
        e = move-exception;
        throw new BadPaddingException(e.getMessage());     // Catch: Throwable -> L20
    L24:
        throw new IllegalStateException("not supported in a wrapping mode");
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return Arrays.clone(this.iv);
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key r2) {
        return ((Key) ZeusTransformUtils.wrapperContextForParams(r2, Key.class, "com.obric.memorydata.plugin")).getEncoded().length * 8;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int r1) {
        return -1;
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams != null) goto L15;
        if (this.iv == null) goto L15;
        String r0 = this.wrapEngine.getAlgorithmName();
        if (r0.indexOf(47) < 0) goto L16;
        r0 = r0.substring(0, r0.indexOf(47));
    L16:
        AlgorithmParameters r1 = createParametersInstance(r0);     // Catch: Exception -> L11
        this.engineParams = r1;     // Catch: Exception -> L11
        r1.init(new IvParameterSpec(this.iv));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        throw new RuntimeException(e.toString());
    L15:
        return this.engineParams;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int r3, Key r4, AlgorithmParameters r5, SecureRandom r6) {
        Key r7 = (Key) ZeusTransformUtils.wrapperContextForParams(r4, Key.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        AlgorithmParameterSpec r0 = SpecUtil.extractSpec(r5, this.availableSpecs);
        if (r0 == null) goto L8;
    L10:
        this.engineParams = r5;
        engineInit(r3, r7, r0, r6);
        return;
    L8:
        throw new InvalidAlgorithmParameterException("can't handle parameter " + r5.toString());
    L9:
        r0 = null;
        goto L10
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int r4, Key r5, SecureRandom r6) {
        Key r7 = (Key) ZeusTransformUtils.wrapperContextForParams(r5, Key.class, "com.obric.memorydata.plugin");
        engineInit(r4, r7, (AlgorithmParameterSpec) ZeusTransformUtils.preCheckCast(null, AlgorithmParameterSpec.class, "com.obric.memorydata.plugin"), r6);     // Catch: InvalidAlgorithmParameterException -> L5
        return;
    L5:
        e = move-exception;
        throw new InvalidKeyOrParametersException(e.getMessage(), e);
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int r4, Key r5, AlgorithmParameterSpec r6, SecureRandom r7) {
        Key r8 = (Key) ZeusTransformUtils.wrapperContextForParams(r5, Key.class, "com.obric.memorydata.plugin");
        AlgorithmParameterSpec r9 = (AlgorithmParameterSpec) ZeusTransformUtils.wrapperContextForParams(r6, AlgorithmParameterSpec.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, BCPBEKey.class) == false) goto L12;
        BCPBEKey r10 = (BCPBEKey) ZeusTransformUtils.preCheckCast(r8, BCPBEKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, PBEParameterSpec.class) == false) goto L8;
        CipherParameters r11 = PBE.Util.makePBEParameters(r10, r9, this.wrapEngine.getAlgorithmName());
    L14:
        if (ZeusTransformUtils.instanceOf(r9, IvParameterSpec.class) == false) goto L17;
        this.iv = ((IvParameterSpec) ZeusTransformUtils.preCheckCast(r9, IvParameterSpec.class, "com.obric.memorydata.plugin")).getIV();
        r11 = new ParametersWithIV(r11, this.iv);
    L17:
        if (ZeusTransformUtils.instanceOf(r9, GOST28147WrapParameterSpec.class) == false) goto L23;
        GOST28147WrapParameterSpec r12 = (GOST28147WrapParameterSpec) ZeusTransformUtils.preCheckCast(r9, GOST28147WrapParameterSpec.class, "com.obric.memorydata.plugin");
        byte[] r0 = r12.getSBox();
        if (r0 == null) goto L21;
        r11 = new ParametersWithSBox(r11, r0);
    L21:
        r11 = new ParametersWithUKM(r11, r12.getUKM());
    L23:
        if (ZeusTransformUtils.instanceOf(r11, KeyParameter.class) == false) goto L29;
        int r13 = this.ivSize;
        if (r13 == 0) goto L29;
        if (r4 == 3) goto L28;
        if (r4 != 1) goto L29;
    L28:
        byte[] r14 = new byte[r13];
        this.iv = r14;
        r7.nextBytes(r14);
        r11 = new ParametersWithIV(r11, this.iv);
    L29:
        if (r7 == null) goto L51;
        r11 = new ParametersWithRandom(r11, r7);
    L51:
        if (r4 != 1) goto L33;
        this.wrapEngine.init(true, r11);     // Catch: Exception -> L48
        this.wrapStream = new ErasableOutputStream();     // Catch: Exception -> L48
    L43:
        this.forWrapping = true;     // Catch: Exception -> L48
        return;
    L33:
        if (r4 != 2) goto L35;
        this.wrapEngine.init(false, r11);     // Catch: Exception -> L48
        this.wrapStream = new ErasableOutputStream();     // Catch: Exception -> L48
    L39:
        this.forWrapping = false;     // Catch: Exception -> L48
        return;
    L35:
        if (r4 != 3) goto L37;
        this.wrapEngine.init(true, r11);     // Catch: Exception -> L48
        this.wrapStream = null;     // Catch: Exception -> L48
        goto L43
    L37:
        if (r4 != 4) goto L41;
        this.wrapEngine.init(false, r11);     // Catch: Exception -> L48
        this.wrapStream = null;     // Catch: Exception -> L48
        goto L39
    L41:
        throw new InvalidParameterException("Unknown mode parameter passed to init.");     // Catch: Exception -> L48
    L48:
        e = move-exception;
        throw new InvalidKeyOrParametersException(e.getMessage(), e);
    L8:
        if (r10.getParam() == null) goto L11;
        r11 = r10.getParam();
        goto L14
    L11:
        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
    L12:
        r11 = new KeyParameter(r8.getEncoded());
        goto L14
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
        Wrapper r1 = this.wrapEngine;     // Catch: IllegalBlockSizeException -> L36 BadPaddingException -> L39 InvalidCipherTextException -> L42
        if (r1 != null) goto L6;
        byte[] r8 = engineDoFinal(r5, 0, r5.length);     // Catch: IllegalBlockSizeException -> L36 BadPaddingException -> L39 InvalidCipherTextException -> L42
    L8:
        if (r7 != 3) goto L12;
        return new SecretKeySpec(r8, r6);
    L12:
        if (r6.equals("") == false) goto L47;
        if (r7 != 2) goto L47;
        PrivateKeyInfo r4 = PrivateKeyInfo.getInstance(r8);     // Catch: Exception -> L19
        PrivateKey r9 = BouncyCastleProvider.getPrivateKey(r4);     // Catch: Exception -> L19
        if (r9 == null) goto L18;
        return r9;
    L18:
        throw new InvalidKeyException("algorithm " + r4.getPrivateKeyAlgorithm().getAlgorithm() + " not supported");     // Catch: Exception -> L19
    L20:
        throw new InvalidKeyException("Invalid key encoding.");
    L47:
        KeyFactory r10 = this.helper.createKeyFactory(r6);     // Catch: InvalidKeySpecException -> L30 NoSuchProviderException -> L33
        if (r7 == 1) goto L24;
        if (r7 != 2) goto L29;
        return r10.generatePrivate(new PKCS8EncodedKeySpec(r8));
    L29:
        throw new InvalidKeyException("Unknown key type " + r7);
    L24:
        return r10.generatePublic(new X509EncodedKeySpec(r8));
    L33:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L30:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L6:
        r8 = r1.unwrap(r5, 0, r5.length);     // Catch: IllegalBlockSizeException -> L36 BadPaddingException -> L39 InvalidCipherTextException -> L42
    L39:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    L36:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    L42:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] r1, int r2, int r3, byte[] r4, int r5) {
        ErasableOutputStream r0 = this.wrapStream;
        if (r0 == null) goto L7;
        r0.write(r1, r2, r3);
        return 0;
    L7:
        throw new IllegalStateException("not supported in a wrapping mode");
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] r1, int r2, int r3) {
        ErasableOutputStream r0 = this.wrapStream;
        if (r0 == null) goto L7;
        r0.write(r1, r2, r3);
        return null;
    L7:
        throw new IllegalStateException("not supported in a wrapping mode");
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
