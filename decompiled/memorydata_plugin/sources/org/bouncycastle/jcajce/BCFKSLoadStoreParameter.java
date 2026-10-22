package org.bouncycastle.jcajce;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Key;
import java.security.cert.X509Certificate;
import org.bouncycastle.crypto.util.PBKDFConfig;

/* JADX INFO: loaded from: classes7.dex */
public class BCFKSLoadStoreParameter extends BCLoadStoreParameter {
    private final X509Certificate[] certificates;
    private final EncryptionAlgorithm encAlg;
    private final MacAlgorithm macAlg;
    private final SignatureAlgorithm sigAlg;
    private final Key sigKey;
    private final PBKDFConfig storeConfig;
    private final CertChainValidator validator;

    public interface CertChainValidator {
        boolean isValid(X509Certificate[] r1);
    }

    public static final enum EncryptionAlgorithm extends Enum<EncryptionAlgorithm> {
        private static final /* synthetic */ EncryptionAlgorithm[] $VALUES = null;
        public static final EncryptionAlgorithm AES256_CCM = null;
        public static final EncryptionAlgorithm AES256_KWP = null;

        static {
            EncryptionAlgorithm r0 = new EncryptionAlgorithm("AES256_CCM", 0);
            AES256_CCM = r0;
            EncryptionAlgorithm r1 = new EncryptionAlgorithm("AES256_KWP", 1);
            AES256_KWP = r1;
            $VALUES = new EncryptionAlgorithm[]{r0, r1};
        }

        private EncryptionAlgorithm(String r1, int r2) {
            super(r1, r2);
        }

        public static EncryptionAlgorithm valueOf(String r2) {
            return (EncryptionAlgorithm) ZeusTransformUtils.preCheckCast(Enum.valueOf(EncryptionAlgorithm.class, r2), EncryptionAlgorithm.class, "com.obric.memorydata.plugin");
        }

        public static EncryptionAlgorithm[] values() {
            return (EncryptionAlgorithm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EncryptionAlgorithm[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum MacAlgorithm extends Enum<MacAlgorithm> {
        private static final /* synthetic */ MacAlgorithm[] $VALUES = null;
        public static final MacAlgorithm HmacSHA3_512 = null;
        public static final MacAlgorithm HmacSHA512 = null;

        static {
            MacAlgorithm r0 = new MacAlgorithm("HmacSHA512", 0);
            HmacSHA512 = r0;
            MacAlgorithm r1 = new MacAlgorithm("HmacSHA3_512", 1);
            HmacSHA3_512 = r1;
            $VALUES = new MacAlgorithm[]{r0, r1};
        }

        private MacAlgorithm(String r1, int r2) {
            super(r1, r2);
        }

        public static MacAlgorithm valueOf(String r2) {
            return (MacAlgorithm) ZeusTransformUtils.preCheckCast(Enum.valueOf(MacAlgorithm.class, r2), MacAlgorithm.class, "com.obric.memorydata.plugin");
        }

        public static MacAlgorithm[] values() {
            return (MacAlgorithm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MacAlgorithm[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum SignatureAlgorithm extends Enum<SignatureAlgorithm> {
        private static final /* synthetic */ SignatureAlgorithm[] $VALUES = null;
        public static final SignatureAlgorithm SHA3_512withDSA = null;
        public static final SignatureAlgorithm SHA3_512withECDSA = null;
        public static final SignatureAlgorithm SHA3_512withRSA = null;
        public static final SignatureAlgorithm SHA512withDSA = null;
        public static final SignatureAlgorithm SHA512withECDSA = null;
        public static final SignatureAlgorithm SHA512withRSA = null;

        static {
            SignatureAlgorithm r0 = new SignatureAlgorithm("SHA512withDSA", 0);
            SHA512withDSA = r0;
            SignatureAlgorithm r1 = new SignatureAlgorithm("SHA3_512withDSA", 1);
            SHA3_512withDSA = r1;
            SignatureAlgorithm r3 = new SignatureAlgorithm("SHA512withECDSA", 2);
            SHA512withECDSA = r3;
            SignatureAlgorithm r5 = new SignatureAlgorithm("SHA3_512withECDSA", 3);
            SHA3_512withECDSA = r5;
            SignatureAlgorithm r7 = new SignatureAlgorithm("SHA512withRSA", 4);
            SHA512withRSA = r7;
            SignatureAlgorithm r9 = new SignatureAlgorithm("SHA3_512withRSA", 5);
            SHA3_512withRSA = r9;
            $VALUES = new SignatureAlgorithm[]{r0, r1, r3, r5, r7, r9};
        }

        private SignatureAlgorithm(String r1, int r2) {
            super(r1, r2);
        }

        public static SignatureAlgorithm valueOf(String r2) {
            return (SignatureAlgorithm) ZeusTransformUtils.preCheckCast(Enum.valueOf(SignatureAlgorithm.class, r2), SignatureAlgorithm.class, "com.obric.memorydata.plugin");
        }

        public static SignatureAlgorithm[] values() {
            return (SignatureAlgorithm[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SignatureAlgorithm[].class, "com.obric.memorydata.plugin");
        }
    }

    public CertChainValidator getCertChainValidator() {
        return this.validator;
    }

    public X509Certificate[] getStoreCertificates() {
        return this.certificates;
    }

    public EncryptionAlgorithm getStoreEncryptionAlgorithm() {
        return this.encAlg;
    }

    public MacAlgorithm getStoreMacAlgorithm() {
        return this.macAlg;
    }

    public PBKDFConfig getStorePBKDFConfig() {
        return this.storeConfig;
    }

    public SignatureAlgorithm getStoreSignatureAlgorithm() {
        return this.sigAlg;
    }

    public Key getStoreSignatureKey() {
        return this.sigKey;
    }
}
