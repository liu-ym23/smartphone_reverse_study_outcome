package org.bouncycastle.jce.spec;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST3410NamedParameters;
import org.bouncycastle.asn1.cryptopro.GOST3410ParamSetParameters;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.jce.interfaces.GOST3410Params;

/* JADX INFO: loaded from: classes7.dex */
public class GOST3410ParameterSpec implements AlgorithmParameterSpec, GOST3410Params {
    private String digestParamSetOID;
    private String encryptionParamSetOID;
    private String keyParamSetOID;
    private GOST3410PublicKeyParameterSetSpec keyParameters;

    public GOST3410ParameterSpec(String r2, String r3) {
        this(r2, r3, null);
    }

    public GOST3410ParameterSpec(String r5, String r6, String r7) {
        GOST3410ParamSetParameters r0 = GOST3410NamedParameters.getByOID(new ASN1ObjectIdentifier(r5));     // Catch: IllegalArgumentException -> L5
    L9:
        if (r0 == null) goto L13;
        this.keyParameters = new GOST3410PublicKeyParameterSetSpec(r0.getP(), r0.getQ(), r0.getA());
        this.keyParamSetOID = r5;
        this.digestParamSetOID = r6;
        this.encryptionParamSetOID = r7;
        return;
    L13:
        throw new IllegalArgumentException("no key parameter set for passed in name/OID.");
    L5:
        ASN1ObjectIdentifier r1 = GOST3410NamedParameters.getOID(r5);
        if (r1 == null) goto L8;
        r5 = r1.getId();
        r0 = GOST3410NamedParameters.getByOID(r1);
        goto L9
    L8:
        r0 = null;
        goto L9
    }

    public GOST3410ParameterSpec(GOST3410PublicKeyParameterSetSpec r1) {
        this.keyParameters = r1;
        this.digestParamSetOID = CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet.getId();
        this.encryptionParamSetOID = null;
    }

    public static GOST3410ParameterSpec fromPublicKeyAlg(GOST3410PublicKeyAlgParameters r3) {
        if (r3.getEncryptionParamSet() == null) goto L7;
        return new GOST3410ParameterSpec(r3.getPublicKeyParamSet().getId(), r3.getDigestParamSet().getId(), r3.getEncryptionParamSet().getId());
    L7:
        return new GOST3410ParameterSpec(r3.getPublicKeyParamSet().getId(), r3.getDigestParamSet().getId());
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, GOST3410ParameterSpec.class) == false) goto L15;
        GOST3410ParameterSpec r5 = (GOST3410ParameterSpec) ZeusTransformUtils.preCheckCast(r4, GOST3410ParameterSpec.class, "com.obric.memorydata.plugin");
        if (this.keyParameters.equals(r5.keyParameters) == true) goto L7;
        return false;
    L7:
        if (this.digestParamSetOID.equals(r5.digestParamSetOID) == false) goto L17;
        String r3 = this.encryptionParamSetOID;
        String r6 = r5.encryptionParamSetOID;
        if (r3 == r6) goto L13;
        if (r3 != null) goto L12;
        return false;
    L12:
        if (r3.equals(r6) == true) goto L13;
        return false;
    L13:
        return true;
    L17:
        return false;
    L15:
        return false;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410Params
    public String getDigestParamSetOID() {
        return this.digestParamSetOID;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410Params
    public String getEncryptionParamSetOID() {
        return this.encryptionParamSetOID;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410Params
    public String getPublicKeyParamSetOID() {
        return this.keyParamSetOID;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410Params
    public GOST3410PublicKeyParameterSetSpec getPublicKeyParameters() {
        return this.keyParameters;
    }

    public int hashCode() {
        int r0 = this.keyParameters.hashCode() ^ this.digestParamSetOID.hashCode();
        String r2 = this.encryptionParamSetOID;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r3 ^ r0;
    L5:
        r3 = 0;
        goto L7
    }
}
