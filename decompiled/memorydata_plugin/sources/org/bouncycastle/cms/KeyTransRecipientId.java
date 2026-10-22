package org.bouncycastle.cms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.selector.X509CertificateHolderSelector;

/* JADX INFO: loaded from: classes7.dex */
public class KeyTransRecipientId extends RecipientId {
    private X509CertificateHolderSelector baseSelector;

    public KeyTransRecipientId(X500Name r2, BigInteger r3) {
        this(r2, r3, null);
    }

    public KeyTransRecipientId(X500Name r2, BigInteger r3, byte[] r4) {
        this(new X509CertificateHolderSelector(r2, r3, r4));
    }

    private KeyTransRecipientId(X509CertificateHolderSelector r2) {
        super(0);
        this.baseSelector = r2;
    }

    public KeyTransRecipientId(byte[] r2) {
        this(null, null, r2);
    }

    @Override // org.bouncycastle.cms.RecipientId, org.bouncycastle.util.Selector
    public Object clone() {
        return new KeyTransRecipientId(this.baseSelector);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, KeyTransRecipientId.class) == true) goto L6;
        return false;
    L6:
        KeyTransRecipientId r4 = (KeyTransRecipientId) ZeusTransformUtils.preCheckCast(r3, KeyTransRecipientId.class, "com.obric.memorydata.plugin");
        return this.baseSelector.equals(r4.baseSelector);
    }

    public X500Name getIssuer() {
        return this.baseSelector.getIssuer();
    }

    public BigInteger getSerialNumber() {
        return this.baseSelector.getSerialNumber();
    }

    public int hashCode() {
        return this.baseSelector.hashCode();
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, KeyTransRecipientInformation.class) == false) goto L7;
        return ((KeyTransRecipientInformation) ZeusTransformUtils.preCheckCast(r3, KeyTransRecipientInformation.class, "com.obric.memorydata.plugin")).getRID().equals(this);
    L7:
        return this.baseSelector.match(r3);
    }
}
