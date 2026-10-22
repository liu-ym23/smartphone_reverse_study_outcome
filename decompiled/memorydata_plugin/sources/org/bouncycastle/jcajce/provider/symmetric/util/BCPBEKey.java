package org.bouncycastle.jcajce.provider.symmetric.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import javax.security.auth.Destroyable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class BCPBEKey implements PBEKey, Destroyable {
    String algorithm;
    int digest;
    private final AtomicBoolean hasBeenDestroyed;
    private final int iterationCount;
    int ivSize;
    int keySize;
    ASN1ObjectIdentifier oid;
    private final CipherParameters param;
    private final char[] password;
    private final byte[] salt;
    boolean tryWrong;
    int type;

    public BCPBEKey(String r3, ASN1ObjectIdentifier r4, int r5, int r6, int r7, int r8, PBEKeySpec r9, CipherParameters r10) {
        CipherParameters r11 = (CipherParameters) ZeusTransformUtils.wrapperContextForParams(r10, CipherParameters.class, "com.obric.memorydata.plugin");
        this.hasBeenDestroyed = new AtomicBoolean(false);
        this.tryWrong = false;
        this.algorithm = r3;
        this.oid = r4;
        this.type = r5;
        this.digest = r6;
        this.keySize = r7;
        this.ivSize = r8;
        this.password = r9.getPassword();
        this.iterationCount = r9.getIterationCount();
        this.salt = r9.getSalt();
        this.param = r11;
    }

    public BCPBEKey(String r3, CipherParameters r4) {
        CipherParameters r5 = (CipherParameters) ZeusTransformUtils.wrapperContextForParams(r4, CipherParameters.class, "com.obric.memorydata.plugin");
        this.hasBeenDestroyed = new AtomicBoolean(false);
        this.tryWrong = false;
        this.algorithm = r3;
        this.param = r5;
        this.password = null;
        this.iterationCount = -1;
        this.salt = null;
    }

    static void checkDestroyed(Destroyable r2) {
        if (((Destroyable) ZeusTransformUtils.wrapperContextForParams(r2, Destroyable.class, "com.obric.memorydata.plugin")).isDestroyed() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("key has been destroyed");
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        if (this.hasBeenDestroyed.getAndSet(true) == true) goto L11;
        char[] r0 = this.password;
        if (r0 == null) goto L7;
        Arrays.fill(r0, 0);
    L7:
        byte[] r2 = this.salt;
        if (r2 == null) goto L12;
        Arrays.fill(r2, (byte) 0);
        return;
    L12:
        return;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        checkDestroyed(this);
        return this.algorithm;
    }

    int getDigest() {
        checkDestroyed(this);
        return this.digest;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        checkDestroyed(this);
        CipherParameters r0 = this.param;
        if (r0 == null) goto L9;
        boolean r1 = ZeusTransformUtils.instanceOf(r0, ParametersWithIV.class);
        CipherParameters r2 = this.param;
        if (r1 == false) goto L8;
        r2 = ((ParametersWithIV) ZeusTransformUtils.preCheckCast(r2, ParametersWithIV.class, "com.obric.memorydata.plugin")).getParameters();
    L8:
        return ((KeyParameter) ZeusTransformUtils.preCheckCast(r2, KeyParameter.class, "com.obric.memorydata.plugin")).getKey();
    L9:
        int r3 = this.type;
        if (r3 == 2) goto L12;
        char[] r4 = this.password;
        if (r3 != 5) goto L18;
        return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(r4);
    L18:
        return PBEParametersGenerator.PKCS5PasswordToBytes(r4);
    L12:
        return PBEParametersGenerator.PKCS12PasswordToBytes(this.password);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "RAW";
    }

    @Override // javax.crypto.interfaces.PBEKey
    public int getIterationCount() {
        checkDestroyed(this);
        return this.iterationCount;
    }

    public int getIvSize() {
        checkDestroyed(this);
        return this.ivSize;
    }

    int getKeySize() {
        checkDestroyed(this);
        return this.keySize;
    }

    public ASN1ObjectIdentifier getOID() {
        checkDestroyed(this);
        return this.oid;
    }

    public CipherParameters getParam() {
        checkDestroyed(this);
        return this.param;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public char[] getPassword() {
        checkDestroyed(this);
        char[] r1 = this.password;
        if (r1 == null) goto L7;
        return Arrays.clone(r1);
    L7:
        throw new IllegalStateException("no password available");
    }

    @Override // javax.crypto.interfaces.PBEKey
    public byte[] getSalt() {
        checkDestroyed(this);
        return Arrays.clone(this.salt);
    }

    int getType() {
        checkDestroyed(this);
        return this.type;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.hasBeenDestroyed.get();
    }

    public void setTryWrongPKCS12Zero(boolean r1) {
        this.tryWrong = r1;
    }

    boolean shouldTryWrongPKCS12() {
        return this.tryWrong;
    }
}
