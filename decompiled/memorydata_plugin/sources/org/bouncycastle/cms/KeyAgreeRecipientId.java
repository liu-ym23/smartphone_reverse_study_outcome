package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.selector.X509CertificateHolderSelector;

/* JADX INFO: loaded from: classes7.dex */
public class KeyAgreeRecipientId extends RecipientId {
    private X509CertificateHolderSelector baseSelector;

    public KeyAgreeRecipientId(X500Name r2, BigInteger r3) {
        this(r2, r3, null);
    }

    public KeyAgreeRecipientId(X500Name r2, BigInteger r3, byte[] r4) {
        this(new X509CertificateHolderSelector(r2, r3, r4));
    }

    private KeyAgreeRecipientId(X509CertificateHolderSelector r2) {
        super(2);
        this.baseSelector = r2;
    }

    public KeyAgreeRecipientId(byte[] r2) {
        this(null, null, r2);
    }

    @Override // org.bouncycastle.cms.RecipientId, org.bouncycastle.util.Selector
    public Object clone() {
        return new KeyAgreeRecipientId(this.baseSelector);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, KeyAgreeRecipientId.class) == true) goto L6;
        return false;
    L6:
        KeyAgreeRecipientId r4 = (KeyAgreeRecipientId) ZeusTransformUtils.preCheckCast(r3, KeyAgreeRecipientId.class, "com.obric.memorydata.plugin");
        return this.baseSelector.equals(r4.baseSelector);
    }

    public int hashCode() {
        return this.baseSelector.hashCode();
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, KeyAgreeRecipientInformation.class) == false) goto L7;
        return ((KeyAgreeRecipientInformation) ZeusTransformUtils.preCheckCast(r3, KeyAgreeRecipientInformation.class, "com.obric.memorydata.plugin")).getRID().equals(this);
    L7:
        return this.baseSelector.match(r3);
    }
}
