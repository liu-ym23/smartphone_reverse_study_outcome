package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Pair;
import com.bytedance.crypto.utils.CryptoConst;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
@MainDex
public class X509Util {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char[] HEX_DIGITS = null;
    private static final String OID_ANY_EKU = "2.5.29.37.0";
    private static final String OID_SERVER_GATED_MICROSOFT = "1.3.6.1.4.1.311.10.3.3";
    private static final String OID_SERVER_GATED_NETSCAPE = "2.16.840.1.113730.4.1";
    private static final String OID_TLS_SERVER_AUTH = "1.3.6.1.5.5.7.3.1";
    private static final String TAG = "X509Util";
    private static CertificateFactory sCertificateFactory;
    private static X509TrustManagerExtensions sDefaultTrustManager;
    private static boolean sLoadedSystemKeyStore;
    private static final Object sLock = null;
    private static File sSystemCertificateDirectory;
    private static KeyStore sSystemKeyStore;
    private static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
    private static KeyStore sTestKeyStore;
    private static X509TrustManagerExtensions sTestTrustManager;
    private static TrustStorageListener sTrustStorageListener;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.X509Util$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    interface Natives {
        void notifyKeyChainChanged();
    }

    private static final class TrustStorageListener extends BroadcastReceiver {
        private TrustStorageListener() {
        }

        /* synthetic */ TrustStorageListener(AnonymousClass1 r10) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            boolean r12 = "android.security.STORAGE_CHANGED".equals(r11.getAction());
        L17:
            if (r12 == false) goto L29;
            X509Util.access$000();     // Catch: NoSuchAlgorithmException -> L20 KeyStoreException -> L22 CertificateException -> L24
        L32:
            return;
        L22:
            e = move-exception;
            Log.e(X509Util.TAG, "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L20:
            e = move-exception;
            Log.e(X509Util.TAG, "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L24:
            e = move-exception;
            Log.e(X509Util.TAG, "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L29:
            return;
        L5:
            if ("android.security.action.KEYCHAIN_CHANGED".equals(r11.getAction()) == false) goto L7;
        L15:
            r12 = true;
            goto L17
        L7:
            if ("android.security.action.TRUST_STORE_CHANGED".equals(r11.getAction()) == true) goto L15;
            if ("android.security.action.KEY_ACCESS_CHANGED".equals(r11.getAction()) == true) goto L12;
        L14:
            r12 = false;
            goto L17
        L12:
            if (r11.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false) == true) goto L14;
            goto L14
        }
    }

    static {
        sLock = new Object();
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public X509Util() {
    }

    static /* synthetic */ void access$000() {
        reloadDefaultTrustManager();
    }

    public static void addTestRootCertificate(byte[] r10) {
        ensureInitialized();
        X509Certificate r11 = createCertificateFromBytes(r10);
        Object r12 = sLock;
        monitor-enter(r12);
        sTestKeyStore.setCertificateEntry("root_cert_" + Integer.toString(sTestKeyStore.size()), r11);     // Catch: Throwable -> L7
        reloadTestTrustManager();     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static List<X509Certificate> checkServerTrustedIgnoringRuntimeException(X509TrustManagerExtensions r10, X509Certificate[] r11, String r12, String r13) {
        return r10.checkServerTrusted(r11, r12, r13);
    L4:
        e = move-exception;
        Log.e(TAG, "checkServerTrusted() unexpectedly threw: %s", new Object[]{e});
        throw new CertificateException(e);
    }

    public static void clearTestRootCertificates() {
        ensureInitialized();
        Object r10 = sLock;
        monitor-enter(r10);
        sTestKeyStore.load(null);     // Catch: Throwable -> L6 IOException -> L12
        reloadTestTrustManager();     // Catch: Throwable -> L6 IOException -> L12
    L6:
        th = move-exception;
        throw th;
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L6
    }

    public static X509Certificate createCertificateFromBytes(byte[] r10) {
        ensureInitialized();
        return (X509Certificate) sCertificateFactory.generateCertificate(new ByteArrayInputStream(r10));
    }

    private static X509TrustManagerExtensions createTrustManager(KeyStore r10) {
        TrustManagerFactory r11 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r11.init(r10);
        TrustManager[] r12 = r11.getTrustManagers();     // Catch: RuntimeException -> L15
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L13;
        TrustManager r15 = r12[r14];
        if ((r15 instanceof X509TrustManager) == false) goto L12;
        return new X509TrustManagerExtensions((X509TrustManager) r15);
    L10:
        e = move-exception;
        Log.e(TAG, "Error creating trust manager (" + r15.getClass().getName() + "): " + e, new Object[0]);
    L12:
        r14 = r14 + 1;
        goto L5
    L13:
        Log.e(TAG, "Could not find suitable trust manager", new Object[0]);
        return null;
    L15:
        e = move-exception;
        Log.e(TAG, "TrustManagerFactory.getTrustManagers() unexpectedly threw: %s", new Object[]{e});
        throw new KeyStoreException(e);
    }

    private static void ensureInitialized() {
        Object r10 = sLock;
        monitor-enter(r10);
        ensureInitializedLocked();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void ensureInitializedLocked() {
        if (sCertificateFactory != null) goto L5;
        sCertificateFactory = CertificateFactory.getInstance("X.509");
    L5:
        AnonymousClass1 r10 = null;
        if (sDefaultTrustManager != null) goto L9;
        sDefaultTrustManager = createTrustManager(null);
    L9:
        if (sLoadedSystemKeyStore == true) goto L15;
        KeyStore r11 = KeyStore.getInstance("AndroidCAStore");     // Catch: KeyStoreException -> L34
        sSystemKeyStore = r11;     // Catch: KeyStoreException -> L34
        r11.load(null);     // Catch: IOException -> L32 KeyStoreException -> L34
    L12:
        sSystemCertificateDirectory = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");     // Catch: KeyStoreException -> L34
    L13:
        sLoadedSystemKeyStore = true;
    L15:
        if (sSystemTrustAnchorCache != null) goto L18;
        sSystemTrustAnchorCache = new HashSet();
    L18:
        if (sTestKeyStore != null) goto L22;
        KeyStore r12 = KeyStore.getInstance(KeyStore.getDefaultType());
        sTestKeyStore = r12;
        r12.load(null);     // Catch: IOException -> L33
    L22:
        if (sTestTrustManager != null) goto L25;
        sTestTrustManager = createTrustManager(sTestKeyStore);
    L25:
        if (sTrustStorageListener != null) goto L41;
        sTrustStorageListener = new TrustStorageListener(r10);
        IntentFilter r13 = new IntentFilter();
        if (Build.VERSION.SDK_INT < 26) goto L29;
        r13.addAction("android.security.action.KEYCHAIN_CHANGED");
        r13.addAction("android.security.action.KEY_ACCESS_CHANGED");
        String r14 = "android.security.action.TRUST_STORE_CHANGED";
    L30:
        r13.addAction(r14);
        ContextUtils.registerNonExportedBroadcastReceiver(ContextUtils.getApplicationContext(), sTrustStorageListener, r13);
        return;
    L29:
        r14 = "android.security.STORAGE_CHANGED";
        goto L30
    }

    private static String hashPrincipal(X500Principal r10) {
        byte[] r11 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5).digest(r10.getEncoded());
        char[] r12 = new char[8];
        int r13 = 0;
    L4:
        if (r13 >= 4) goto L7;
        int r14 = r13 * 2;
        char[] r15 = HEX_DIGITS;
        int r16 = 3 - r13;
        r12[r14] = r15[(r11[r16] >> 4) & 15];
        r12[r14 + 1] = r15[r11[r16] & 15];
        r13 = r13 + 1;
        goto L4
    L7:
        return new String(r12);
    }

    private static boolean isKnownRoot(X509Certificate r10) {
        if (sSystemKeyStore != null) goto L5;
        return false;
    L5:
        Pair<X500Principal, PublicKey> r11 = new Pair(r10.getSubjectX500Principal(), r10.getPublicKey());
        if (sSystemTrustAnchorCache.contains(r11) == false) goto L8;
        return true;
    L8:
        String r12 = hashPrincipal(r10.getSubjectX500Principal());
        int r13 = 0;
    L9:
        String r14 = r12 + '.' + r13;
        if (new File(sSystemCertificateDirectory, r14).exists() == false) goto L11;
        Certificate r15 = sSystemKeyStore.getCertificate("system:" + r14);
        if (r15 == null) goto L24;
        if ((r15 instanceof X509Certificate) == true) goto L18;
        Log.e(TAG, "Anchor " + r14 + " not an X509Certificate: " + r15.getClass().getName(), new Object[0]);
        goto L24
    L18:
        X509Certificate r16 = (X509Certificate) r15;
        if (r10.getSubjectX500Principal().equals(r16.getSubjectX500Principal()) == false) goto L24;
        if (r10.getPublicKey().equals(r16.getPublicKey()) == false) goto L24;
        sSystemTrustAnchorCache.add(r11);
        return true;
    L24:
        r13 = r13 + 1;
        goto L9
    L11:
        return false;
    }

    private static void reloadDefaultTrustManager() {
        Object r10 = sLock;
        monitor-enter(r10);
        sDefaultTrustManager = null;     // Catch: Throwable -> L9
        sSystemTrustAnchorCache = null;     // Catch: Throwable -> L9
        ensureInitializedLocked();     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        X509UtilJni.get().notifyKeyChainChanged();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static void reloadTestTrustManager() {
        sTestTrustManager = createTrustManager(sTestKeyStore);
    }

    static boolean verifyKeyUsage(X509Certificate r10) {
        List<String> r11 = r10.getExtendedKeyUsage();     // Catch: NullPointerException -> L20
        if (r11 != null) goto L7;
        return true;
    L7:
        Iterator<String> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L19;
        String r13 = r12.next();
        if (r13.equals(OID_TLS_SERVER_AUTH) == true) goto L18;
        if (r13.equals(OID_ANY_EKU) == true) goto L18;
        if (r13.equals(OID_SERVER_GATED_NETSCAPE) == true) goto L18;
        if (r13.equals(OID_SERVER_GATED_MICROSOFT) == false) goto L9;
    L18:
        return true;
    L19:
        return false;
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r10, String r11, String r12) {
        if (r10 == null) goto L58;
        if (r10.length == 0) goto L58;
        if (r10[0] == null) goto L58;
        ensureInitialized();     // Catch: CertificateException -> L55
        ArrayList r13 = new ArrayList();
        r13.add(createCertificateFromBytes(r10[0]));     // Catch: CertificateException -> L53
        int r14 = 1;
    L13:
        if (r14 >= r10.length) goto L18;
        r13.add(createCertificateFromBytes(r10[r14]));     // Catch: CertificateException -> L16
    L17:
        r14 = r14 + 1;
    L16:
        Log.w(TAG, "intermediate " + r14 + " failed parsing", new Object[0]);
        goto L17
    L18:
        X509Certificate[] r15 = (X509Certificate[]) r13.toArray(new X509Certificate[r13.size()]);
        r15[0].checkValidity();     // Catch: CertificateException -> L47 CertificateNotYetValidException -> L49 CertificateExpiredException -> L51
        if (verifyKeyUsage(r15[0]) == true) goto L23;
        return new AndroidCertVerifyResult(-6);
    L23:
        Object r16 = sLock;
        monitor-enter(r16);
        X509TrustManagerExtensions r17 = sDefaultTrustManager;     // Catch: Throwable -> L44
        if (r17 != null) goto L62;
        AndroidCertVerifyResult r18 = new AndroidCertVerifyResult(-1);     // Catch: Throwable -> L44
        monitor-exit(r16);     // Catch: Throwable -> L44
        return r18;
    L62:
        List<X509Certificate> r19 = checkServerTrustedIgnoringRuntimeException(r17, r15, r11, r12);     // Catch: CertificateException -> L32 Throwable -> L44
    L35:
        if (r19.size() <= 0) goto L37;
        boolean r20 = isKnownRoot(r19.get(r19.size() - 1));     // Catch: Throwable -> L44
    L38:
        AndroidCertVerifyResult r110 = new AndroidCertVerifyResult(0, r20, r19);     // Catch: Throwable -> L44
        monitor-exit(r16);     // Catch: Throwable -> L44
        return r110;
    L37:
        r20 = false;
    L32:
        e = move-exception;
        r19 = checkServerTrustedIgnoringRuntimeException(sTestTrustManager, r15, r11, r12);     // Catch: CertificateException -> L41 Throwable -> L44
    L41:
        Log.i(TAG, "Failed to validate the certificate chain, error: " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L44
        return new AndroidCertVerifyResult(-2);
    L44:
        th = move-exception;
        throw th;
    L52:
        return new AndroidCertVerifyResult(-3);
    L50:
        return new AndroidCertVerifyResult(-4);
    L48:
        return new AndroidCertVerifyResult(-1);
    L54:
        return new AndroidCertVerifyResult(-5);
    L56:
        return new AndroidCertVerifyResult(-1);
    L58:
        throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(r10));
    }
}
