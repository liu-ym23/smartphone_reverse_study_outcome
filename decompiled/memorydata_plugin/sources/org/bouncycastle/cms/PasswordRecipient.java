package org.bouncycastle.cms;

import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes7.dex */
public interface PasswordRecipient extends Recipient {

    public static final class PRF {
        public static final PRF HMacSHA1 = null;
        public static final PRF HMacSHA224 = null;
        public static final PRF HMacSHA256 = null;
        public static final PRF HMacSHA384 = null;
        public static final PRF HMacSHA512 = null;
        private final String hmac;
        final AlgorithmIdentifier prfAlgID;

        static {
            HMacSHA1 = new PRF("HMacSHA1", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, DERNull.INSTANCE));
            HMacSHA224 = new PRF("HMacSHA224", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA224, DERNull.INSTANCE));
            HMacSHA256 = new PRF("HMacSHA256", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA256, DERNull.INSTANCE));
            HMacSHA384 = new PRF("HMacSHA384", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA384, DERNull.INSTANCE));
            HMacSHA512 = new PRF("HMacSHA512", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, DERNull.INSTANCE));
        }

        private PRF(String r1, AlgorithmIdentifier r2) {
            this.hmac = r1;
            this.prfAlgID = r2;
        }

        public AlgorithmIdentifier getAlgorithmID() {
            return this.prfAlgID;
        }
    }

    byte[] calculateDerivedKey(int r1, AlgorithmIdentifier r2, int r3);

    int getPasswordConversionScheme();

    RecipientOperator getRecipientOperator(AlgorithmIdentifier r1, AlgorithmIdentifier r2, byte[] r3, byte[] r4);
}
