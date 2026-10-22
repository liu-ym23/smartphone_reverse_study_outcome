package org.bouncycastle.asn1.edec;

import com.bytedance.bdlocation.exception.BDLocationException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public interface EdECObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_Ed25519 = null;
    public static final ASN1ObjectIdentifier id_Ed448 = null;
    public static final ASN1ObjectIdentifier id_X25519 = null;
    public static final ASN1ObjectIdentifier id_X448 = null;
    public static final ASN1ObjectIdentifier id_edwards_curve_algs = null;

    static {
        ASN1ObjectIdentifier r0 = new ASN1ObjectIdentifier("1.3.101");
        id_edwards_curve_algs = r0;
        id_X25519 = r0.branch(BDLocationException.ERROR_TMAP_CLIENT).intern();
        id_X448 = r0.branch("111").intern();
        id_Ed25519 = r0.branch(BDLocationException.ERROR_TMAP_BAD_JSON).intern();
        id_Ed448 = r0.branch("113").intern();
    }
}
