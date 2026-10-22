package org.bouncycastle.cms.jcajce;

import java.security.PrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.operator.jcajce.JceAsymmetricKeyUnwrapper;

/* JADX INFO: loaded from: classes7.dex */
interface JcaJceExtHelper extends JcaJceHelper {
    JceAsymmetricKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier r1, PrivateKey r2);
}
