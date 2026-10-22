package cn.nubia.neopush.protocol.http;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public class EasyX509TrustManager implements X509TrustManager {
    private X509TrustManager standardTrustManager;

    public EasyX509TrustManager(KeyStore r5) throws NoSuchAlgorithmException, KeyStoreException {
        this.standardTrustManager = null;
        TrustManagerFactory r10 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r10.init(r5);
        TrustManager[] r11 = r10.getTrustManagers();
        if (r11.length == 0) goto L7;
        this.standardTrustManager = (X509TrustManager) r11[0];
        return;
    L7:
        throw new NoSuchAlgorithmException("no trust manager found");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] r5, String r10) throws CertificateException {
        this.standardTrustManager.checkClientTrusted(r5, r10);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] r5, String r10) throws CertificateException {
        if (r5 != null) goto L4;
    L6:
        this.standardTrustManager.checkServerTrusted(r5, r10);
        return;
    L4:
        if (r5.length != 1) goto L6;
        r5[0].checkValidity();
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.standardTrustManager.getAcceptedIssuers();
    }
}
