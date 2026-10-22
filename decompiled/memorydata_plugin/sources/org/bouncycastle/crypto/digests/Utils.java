package org.bouncycastle.crypto.digests;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes7.dex */
class Utils {

    private static class DefaultProperties implements CryptoServiceProperties {
        private final String algorithmName;
        private final int bitsOfSecurity;
        private final CryptoServicePurpose purpose;

        public DefaultProperties(int r1, String r2, CryptoServicePurpose r3) {
            this.bitsOfSecurity = r1;
            this.algorithmName = r2;
            this.purpose = r3;
        }

        @Override // org.bouncycastle.crypto.CryptoServiceProperties
        public String getServiceName() {
            return this.algorithmName;
        }
    }

    private static class DefaultPropertiesWithPRF implements CryptoServiceProperties {
        private final String algorithmName;
        private final int bitsOfSecurity;
        private final int prfBitsOfSecurity;
        private final CryptoServicePurpose purpose;

        public DefaultPropertiesWithPRF(int r1, int r2, String r3, CryptoServicePurpose r4) {
            this.bitsOfSecurity = r1;
            this.prfBitsOfSecurity = r2;
            this.algorithmName = r3;
            this.purpose = r4;
        }

        @Override // org.bouncycastle.crypto.CryptoServiceProperties
        public String getServiceName() {
            return this.algorithmName;
        }
    }

    static CryptoServiceProperties getDefaultProperties(Digest r2, int r3, CryptoServicePurpose r4) {
        Digest r5 = (Digest) ZeusTransformUtils.wrapperContextForParams(r2, Digest.class, "com.obric.memorydata.plugin");
        return new DefaultPropertiesWithPRF(r5.getDigestSize() * 4, r3, r5.getAlgorithmName(), r4);
    }

    static CryptoServiceProperties getDefaultProperties(Digest r2, CryptoServicePurpose r3) {
        Digest r4 = (Digest) ZeusTransformUtils.wrapperContextForParams(r2, Digest.class, "com.obric.memorydata.plugin");
        return new DefaultProperties(r4.getDigestSize() * 4, r4.getAlgorithmName(), r3);
    }
}
