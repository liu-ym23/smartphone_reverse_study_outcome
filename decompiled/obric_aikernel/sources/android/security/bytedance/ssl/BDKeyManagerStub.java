package android.security.bytedance.ssl;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BDKeyManagerStub {
    public static final String TLS_PRO_CERT = "SYSTEM_Device_TLS_cert";
    public static final String TLS_PRO_PKEY = "SYSTEM_Device_TLS_pkey";
    public static final String TLS_TEST_CERT = "SYSTEM_Device_TLS_cert_test";
    public static final String TLS_TEST_PKEY = "SYSTEM_Device_TLS_pkey_test";

    public BDKeyManagerStub() {
    }

    public static BDKeyManagerStub getInstance() {
        return null;
    }

    public abstract long getAlgorithmAddress();

    public abstract List<X509Certificate> getCertChain(String r10);

    public abstract long getDoSignAddress(String r10);

    public abstract PrivateKey getPrivateKey(String r10);

    public abstract boolean isContainsKey(String r10);
}
