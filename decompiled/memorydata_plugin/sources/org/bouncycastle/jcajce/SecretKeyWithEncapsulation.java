package org.bouncycastle.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.crypto.SecretKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class SecretKeyWithEncapsulation implements SecretKey {
    private final byte[] encapsulation;
    private final SecretKey secretKey;

    public SecretKeyWithEncapsulation(SecretKey r3, byte[] r4) {
        this.secretKey = (SecretKey) ZeusTransformUtils.wrapperContextForParams(r3, SecretKey.class, "com.obric.memorydata.plugin");
        this.encapsulation = Arrays.clone(r4);
    }

    public boolean equals(Object r1) {
        return this.secretKey.equals(r1);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.secretKey.getAlgorithm();
    }

    public byte[] getEncapsulation() {
        return Arrays.clone(this.encapsulation);
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.secretKey.getEncoded();
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.secretKey.getFormat();
    }

    public int hashCode() {
        return this.secretKey.hashCode();
    }
}
