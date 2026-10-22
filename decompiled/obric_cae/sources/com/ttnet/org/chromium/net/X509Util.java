package com.ttnet.org.chromium.net;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.util.Log;
import android.util.Pair;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    private static X509TrustManagerImplementation sDefaultTrustManager;
    private static boolean sDisableNativeCodeForTest;
    private static boolean sLoadedSystemKeyStore;
    private static final Object sLock = null;
    private static File sSystemCertificateDirectory;
    private static KeyStore sSystemKeyStore;
    private static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
    private static KeyStore sTestKeyStore;
    private static X509TrustManagerImplementation sTestTrustManager;
    private static TrustStorageListener sTrustStorageListener;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.X509Util$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class TrustStorageListener extends BroadcastReceiver {
        private TrustStorageListener() {
        }

        public /* synthetic */ TrustStorageListener(AnonymousClass1 r8) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            boolean r11 = true;
            if ("android.security.action.KEYCHAIN_CHANGED".equals(r10.getAction()) == false) goto L5;
        L13:
            if (r11 == false) goto L21;
            X509Util.access$000();     // Catch: Throwable -> L16
            return;
        L16:
            e = move-exception;
            Log.e(X509Util.TAG, "Unable to reload the default TrustManager", e);
            return;
        L21:
            return;
        L5:
            if ("android.security.action.TRUST_STORE_CHANGED".equals(r10.getAction()) == true) goto L13;
            if ("android.security.action.KEY_ACCESS_CHANGED".equals(r10.getAction()) == true) goto L10;
        L12:
            r11 = false;
            goto L13
        L10:
            if (r10.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false) == true) goto L12;
            goto L12
        }
    }

    public static final class X509TrustManagerIceCreamSandwich implements X509TrustManagerImplementation {
        private final X509TrustManager mTrustManager;

        public X509TrustManagerIceCreamSandwich(X509TrustManager r8) {
            this.mTrustManager = r8;
        }

        @Override // com.ttnet.org.chromium.net.X509Util.X509TrustManagerImplementation
        public List<X509Certificate> checkServerTrusted(X509Certificate[] r8, String r10, String r11) {
            this.mTrustManager.checkServerTrusted(r8, r10);
            return Collections.emptyList();
        }
    }

    public interface X509TrustManagerImplementation {
        List<X509Certificate> checkServerTrusted(X509Certificate[] r8, String r10, String r11);
    }

    public static final class X509TrustManagerJellyBean implements X509TrustManagerImplementation {
        private final X509TrustManagerExtensions mTrustManagerExtensions;

        @SuppressLint({"NewApi"})
        public X509TrustManagerJellyBean(X509TrustManager r8) {
            this.mTrustManagerExtensions = new X509TrustManagerExtensions(r8);
        }

        @Override // com.ttnet.org.chromium.net.X509Util.X509TrustManagerImplementation
        @SuppressLint({"NewApi"})
        public List<X509Certificate> checkServerTrusted(X509Certificate[] r8, String r10, String r11) {
            return this.mTrustManagerExtensions.checkServerTrusted(r8, r10, r11);
        }
    }

    static {
        sLock = new Object();
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public X509Util() {
    }

    public static /* synthetic */ void access$000() {
        reloadDefaultTrustManager();
    }

    public static void addTestRootCertificate(byte[] r8) {
        ensureInitialized();
        X509Certificate r10 = createCertificateFromBytes(r8);
        Object r11 = sLock;
        monitor-enter(r11);
        sTestKeyStore.setCertificateEntry("root_cert_" + Integer.toString(sTestKeyStore.size()), r10);     // Catch: Throwable -> L7
        reloadTestTrustManager();     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void clearTestRootCertificates() {
        ensureInitialized();
        Object r8 = sLock;
        monitor-enter(r8);
        sTestKeyStore.load(null);     // Catch: Throwable -> L6 IOException -> L12
        reloadTestTrustManager();     // Catch: Throwable -> L6 IOException -> L12
    L6:
        th = move-exception;
        throw th;
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L6
    }

    public static X509Certificate createCertificateFromBytes(byte[] r8) {
        ensureInitialized();
        return (X509Certificate) sCertificateFactory.generateCertificate(new ByteArrayInputStream(r8));
    }

    private static X509TrustManagerImplementation createTrustManager(KeyStore r8) {
        TrustManagerFactory r10 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r10.init(r8);
        TrustManager[] r11 = r10.getTrustManagers();
        int r12 = r11.length;
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L12;
        TrustManager r14 = r11[r13];
        if ((r14 instanceof X509TrustManager) == false) goto L11;
        return new X509TrustManagerJellyBean((X509TrustManager) r14);
    L9:
        e = move-exception;
        Log.e(TAG, "Error creating trust manager (" + r14.getClass().getName() + "): " + e);
    L11:
        r13 = r13 + 1;
        goto L4
    L12:
        Log.e(TAG, "Could not find suitable trust manager");
        return null;
    }

    private static void ensureInitialized() {
        Object r8 = sLock;
        monitor-enter(r8);
        ensureInitializedLocked();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void ensureInitializedLocked() {
        if (sCertificateFactory != null) goto L5;
        sCertificateFactory = CertificateFactory.getInstance("X.509");
    L5:
        AnonymousClass1 r8 = null;
        if (sDefaultTrustManager != null) goto L9;
        sDefaultTrustManager = createTrustManager(null);
    L9:
        if (sLoadedSystemKeyStore == true) goto L15;
        KeyStore r10 = KeyStore.getInstance("AndroidCAStore");     // Catch: KeyStoreException -> L30
        sSystemKeyStore = r10;     // Catch: KeyStoreException -> L30
        r10.load(null);     // Catch: IOException -> L28 KeyStoreException -> L30
    L12:
        sSystemCertificateDirectory = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");     // Catch: KeyStoreException -> L30
    L13:
        sLoadedSystemKeyStore = true;
    L15:
        if (sSystemTrustAnchorCache != null) goto L18;
        sSystemTrustAnchorCache = new HashSet();
    L18:
        if (sTestKeyStore != null) goto L22;
        KeyStore r11 = KeyStore.getInstance(KeyStore.getDefaultType());
        sTestKeyStore = r11;
        r11.load(null);     // Catch: IOException -> L29
    L22:
        if (sTestTrustManager != null) goto L25;
        sTestTrustManager = createTrustManager(sTestKeyStore);
    L25:
        if (sTrustStorageListener != null) goto L37;
        sTrustStorageListener = new TrustStorageListener(r8);
        IntentFilter r12 = new IntentFilter();
        r12.addAction("android.security.action.KEYCHAIN_CHANGED");
        r12.addAction("android.security.action.KEY_ACCESS_CHANGED");
        r12.addAction("android.security.action.TRUST_STORE_CHANGED");
        ContextUtils.getApplicationContext().registerReceiver(sTrustStorageListener, r12);
        return;
    }

    private static String hashPrincipal(X500Principal r8) {
        byte[] r10 = MessageDigest.getInstance("MD5").digest(r8.getEncoded());
        char[] r11 = new char[8];
        int r12 = 0;
    L4:
        if (r12 >= 4) goto L7;
        int r13 = r12 * 2;
        char[] r14 = HEX_DIGITS;
        byte r15 = r10[3 - r12];
        r11[r13] = r14[(r15 >> 4) & 15];
        r11[r13 + 1] = r14[r15 & 15];
        r12 = r12 + 1;
        goto L4
    L7:
        return new String(r11);
    }

    private static boolean isKnownRoot(X509Certificate r10) {
        if (sSystemKeyStore != null) goto L5;
        return false;
    L5:
        Pair<X500Principal, PublicKey> r8 = new Pair(r10.getSubjectX500Principal(), r10.getPublicKey());
        if (sSystemTrustAnchorCache.contains(r8) == false) goto L8;
        return true;
    L8:
        String r11 = hashPrincipal(r10.getSubjectX500Principal());
        int r12 = 0;
    L9:
        String r13 = r11 + '.' + r12;
        if (new File(sSystemCertificateDirectory, r13).exists() == false) goto L11;
        Certificate r14 = sSystemKeyStore.getCertificate("system:" + r13);
        if (r14 == null) goto L24;
        if ((r14 instanceof X509Certificate) == true) goto L18;
        Log.e(TAG, "Anchor " + r13 + " not an X509Certificate: " + r14.getClass().getName());
        goto L24
    L18:
        X509Certificate r15 = (X509Certificate) r14;
        if (r10.getSubjectX500Principal().equals(r15.getSubjectX500Principal()) == false) goto L24;
        if (r10.getPublicKey().equals(r15.getPublicKey()) == false) goto L24;
        sSystemTrustAnchorCache.add(r8);
        return true;
    L24:
        r12 = r12 + 1;
        goto L9
    L11:
        return false;
    }

    private static native void nativeNotifyKeyChainChanged();

    private static void reloadDefaultTrustManager() {
        Object r8 = sLock;
        monitor-enter(r8);
        sDefaultTrustManager = null;     // Catch: Throwable -> L9
        sSystemTrustAnchorCache = null;     // Catch: Throwable -> L9
        ensureInitializedLocked();     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
        nativeNotifyKeyChainChanged();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static void reloadTestTrustManager() {
        sTestTrustManager = createTrustManager(sTestKeyStore);
    }

    public static void setDisableNativeCodeForTest(boolean r8) {
        sDisableNativeCodeForTest = r8;
    }

    public static boolean verifyKeyUsage(X509Certificate r8) {
        List<String> r10 = r8.getExtendedKeyUsage();     // Catch: NullPointerException -> L20
        if (r10 != null) goto L7;
        return true;
    L7:
        Iterator<String> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L19;
        String r12 = r11.next();
        if (r12.equals(OID_TLS_SERVER_AUTH) == true) goto L18;
        if (r12.equals(OID_ANY_EKU) == true) goto L18;
        if (r12.equals(OID_SERVER_GATED_NETSCAPE) == true) goto L18;
        if (r12.equals(OID_SERVER_GATED_MICROSOFT) == false) goto L9;
    L18:
        return true;
    L19:
        return false;
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r8, String r10, String r11) {
        if (r8 == null) goto L58;
        if (r8.length == 0) goto L58;
        if (r8[0] == null) goto L58;
        ensureInitialized();     // Catch: CertificateException -> L55
        ArrayList r12 = new ArrayList();
        r12.add(createCertificateFromBytes(r8[0]));     // Catch: CertificateException -> L53
        int r13 = 1;
    L13:
        if (r13 >= r8.length) goto L18;
        r12.add(createCertificateFromBytes(r8[r13]));     // Catch: CertificateException -> L16
    L17:
        r13 = r13 + 1;
    L16:
        Log.w(TAG, "intermediate " + r13 + " failed parsing");
        goto L17
    L18:
        X509Certificate[] r14 = (X509Certificate[]) r12.toArray(new X509Certificate[r12.size()]);
        r14[0].checkValidity();     // Catch: CertificateException -> L47 CertificateNotYetValidException -> L49 CertificateExpiredException -> L51
        if (verifyKeyUsage(r14[0]) == true) goto L23;
        return new AndroidCertVerifyResult(-6);
    L23:
        Object r15 = sLock;
        monitor-enter(r15);
        X509TrustManagerImplementation r16 = sDefaultTrustManager;     // Catch: Throwable -> L44
        if (r16 != null) goto L62;
        AndroidCertVerifyResult r17 = new AndroidCertVerifyResult(-1);     // Catch: Throwable -> L44
        monitor-exit(r15);     // Catch: Throwable -> L44
        return r17;
    L62:
        List<X509Certificate> r18 = r16.checkServerTrusted(r14, r10, r11);     // Catch: CertificateException -> L32 Throwable -> L44
    L35:
        if (r18.size() <= 0) goto L37;
        boolean r19 = isKnownRoot(r18.get(r18.size() - 1));     // Catch: Throwable -> L44
    L38:
        AndroidCertVerifyResult r110 = new AndroidCertVerifyResult(0, r19, r18);     // Catch: Throwable -> L44
        monitor-exit(r15);     // Catch: Throwable -> L44
        return r110;
    L37:
        r19 = false;
    L32:
        e = move-exception;
        r18 = sTestTrustManager.checkServerTrusted(r14, r10, r11);     // Catch: CertificateException -> L41 Throwable -> L44
    L41:
        Log.i(TAG, "Failed to validate the certificate chain, error: " + e.getMessage());     // Catch: Throwable -> L44
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
        throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(r8));
    }
}
