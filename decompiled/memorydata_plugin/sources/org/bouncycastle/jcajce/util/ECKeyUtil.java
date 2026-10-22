package org.bouncycastle.jcajce.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECParametersHolder;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.math.ec.ECCurve;

/* JADX INFO: loaded from: classes7.dex */
public class ECKeyUtil {

    private static class ECPublicKeyWithCompression implements ECPublicKey {
        private final ECPublicKey ecPublicKey;

        public ECPublicKeyWithCompression(ECPublicKey r3) {
            this.ecPublicKey = (ECPublicKey) ZeusTransformUtils.wrapperContextForParams(r3, ECPublicKey.class, "com.obric.memorydata.plugin");
        }

        @Override // java.security.Key
        public String getAlgorithm() {
            return this.ecPublicKey.getAlgorithm();
        }

        @Override // java.security.Key
        public byte[] getEncoded() {
            SubjectPublicKeyInfo r3 = SubjectPublicKeyInfo.getInstance(this.ecPublicKey.getEncoded());
            X962Parameters r0 = X962Parameters.getInstance(r3.getAlgorithm().getParameters());
            if (r0.isNamedCurve() == false) goto L9;
            ASN1ObjectIdentifier r1 = (ASN1ObjectIdentifier) ZeusTransformUtils.preCheckCast(r0.getParameters(), ASN1ObjectIdentifier.class, "com.obric.memorydata.plugin");
            X9ECParametersHolder r2 = CustomNamedCurves.getByOIDLazy(r1);
            if (r2 != null) goto L7;
            r2 = ECNamedCurveTable.getByOIDLazy(r1);
        L7:
            ECCurve r4 = r2.getCurve();
        L19:
            return new SubjectPublicKeyInfo(r3.getAlgorithm(), ASN1OctetString.getInstance(new X9ECPoint(r4.decodePoint(r3.getPublicKeyData().getOctets()), true).toASN1Primitive()).getOctets()).getEncoded();
        L14:
            e = move-exception;
            throw new IllegalStateException("unable to encode EC public key: " + e.getMessage());
        L9:
            if (r0.isImplicitlyCA() == true) goto L18;
            r4 = X9ECParameters.getInstance(r0.getParameters()).getCurve();
            goto L19
        L18:
            throw new IllegalStateException("unable to identify implictlyCA");
        }

        @Override // java.security.Key
        public String getFormat() {
            return this.ecPublicKey.getFormat();
        }

        @Override // java.security.interfaces.ECKey
        public ECParameterSpec getParams() {
            return this.ecPublicKey.getParams();
        }

        @Override // java.security.interfaces.ECPublicKey
        public ECPoint getW() {
            return this.ecPublicKey.getW();
        }
    }
}
