package com.ss.bduploader.util;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes6.dex */
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

    /* JADX INFO: renamed from: com.ss.bduploader.util.X509Util$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class TrustStorageListener extends PluginBroadcastReceiver {
        private TrustStorageListener() {
        }

        /* synthetic */ TrustStorageListener(AnonymousClass1 r1) {
            this();
        }

        public void onReceive(Context r5, Intent r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            boolean r1 = true;
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            r1 = "android.security.STORAGE_CHANGED".equals(r6.getAction());
        L15:
            if (r1 == false) goto L23;
            X509Util.access$100();     // Catch: Throwable -> L18
            return;
        L18:
            e = move-exception;
            Log.e(X509Util.TAG, "Unable to reload the default TrustManager", e);
            return;
        L23:
            return;
        L5:
            if ("android.security.action.KEYCHAIN_CHANGED".equals(r6.getAction()) == true) goto L15;
            if ("android.security.action.TRUST_STORE_CHANGED".equals(r6.getAction()) == true) goto L15;
            if ("android.security.action.KEY_ACCESS_CHANGED".equals(r6.getAction()) == true) goto L11;
        L13:
            r1 = false;
            goto L15
        L11:
            if (r6.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false) == true) goto L13;
            goto L13
        }
    }

    private static final class X509TrustManagerIceCreamSandwich implements X509TrustManagerImplementation {
        private final X509TrustManager mTrustManager;

        public X509TrustManagerIceCreamSandwich(X509TrustManager r3) {
            this.mTrustManager = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.bduploader.util.X509Util.X509TrustManagerImplementation
        public List<X509Certificate> checkServerTrusted(X509Certificate[] r1, String r2, String r3) {
            this.mTrustManager.checkServerTrusted(r1, r2);
            return Collections.emptyList();
        }
    }

    private interface X509TrustManagerImplementation {
        List<X509Certificate> checkServerTrusted(X509Certificate[] r1, String r2, String r3);
    }

    private static final class X509TrustManagerJellyBean implements X509TrustManagerImplementation {
        private final X509TrustManagerExtensions mTrustManagerExtensions;

        public X509TrustManagerJellyBean(X509TrustManager r3) {
            this.mTrustManagerExtensions = new X509TrustManagerExtensions((X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.ss.bduploader.util.X509Util.X509TrustManagerImplementation
        public List<X509Certificate> checkServerTrusted(X509Certificate[] r1, String r2, String r3) {
            return this.mTrustManagerExtensions.checkServerTrusted(r1, r2, r3);
        }
    }

    static {
        sLock = new Object();
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public X509Util() {
    }

    static /* synthetic */ void access$100() {
        reloadDefaultTrustManager();
    }

    public static void addTestRootCertificate(byte[] r4) {
        ensureInitialized();
        X509Certificate r5 = createCertificateFromBytes(r4);
        Object r0 = sLock;
        monitor-enter(r0);
        sTestKeyStore.setCertificateEntry("root_cert_" + Integer.toString(sTestKeyStore.size()), r5);     // Catch: Throwable -> L7
        reloadTestTrustManager();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void clearTestRootCertificates() {
        ensureInitialized();
        Object r0 = sLock;
        monitor-enter(r0);
        sTestKeyStore.load((KeyStore.LoadStoreParameter) ZeusTransformUtils.preCheckCast(null, KeyStore.LoadStoreParameter.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6 IOException -> L12
        reloadTestTrustManager();     // Catch: Throwable -> L6 IOException -> L12
    L6:
        th = move-exception;
        throw th;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L6
    }

    public static X509Certificate createCertificateFromBytes(byte[] r2) {
        ensureInitialized();
        return (X509Certificate) ZeusTransformUtils.preCheckCast(sCertificateFactory.generateCertificate(new ByteArrayInputStream(r2)), X509Certificate.class, "com.obric.memorydata.plugin");
    }

    private static X509TrustManagerImplementation createTrustManager(KeyStore r7) {
        TrustManagerFactory r0 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r0.init(r7);
        TrustManager[] r8 = r0.getTrustManagers();
        int r1 = r8.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L17;
        TrustManager r3 = r8[r2];
        if (ZeusTransformUtils.instanceOf(r3, X509TrustManager.class) == false) goto L16;
    L14:
        e = move-exception;
        Log.e(TAG, "Error creating trust manager (" + r3.getClass().getName() + "): " + e);
        goto L16
    L9:
        if (Build.VERSION.SDK_INT < 17) goto L13;
        return new X509TrustManagerJellyBean((X509TrustManager) ZeusTransformUtils.preCheckCast(r3, X509TrustManager.class, "com.obric.memorydata.plugin"));
    L13:
        return new X509TrustManagerIceCreamSandwich((X509TrustManager) ZeusTransformUtils.preCheckCast(r3, X509TrustManager.class, "com.obric.memorydata.plugin"));
    L16:
        r2 = r2 + 1;
        goto L4
    L17:
        Log.e(TAG, "Could not find suitable trust manager");
        return null;
    }

    private static void ensureInitialized() {
        Object r0 = sLock;
        monitor-enter(r0);
        ensureInitializedLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void ensureInitializedLocked() {
        if (sCertificateFactory != null) goto L5;
        sCertificateFactory = CertificateFactory.getInstance("X.509");
    L5:
        AnonymousClass1 r1 = null;
        if (sDefaultTrustManager != null) goto L9;
        sDefaultTrustManager = createTrustManager((KeyStore) ZeusTransformUtils.preCheckCast(null, KeyStore.class, "com.obric.memorydata.plugin"));
    L9:
        if (sLoadedSystemKeyStore == true) goto L15;
        KeyStore r0 = KeyStore.getInstance("AndroidCAStore");     // Catch: KeyStoreException -> L34
        sSystemKeyStore = r0;     // Catch: KeyStoreException -> L34
        r0.load((KeyStore.LoadStoreParameter) ZeusTransformUtils.preCheckCast(null, KeyStore.LoadStoreParameter.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L32 KeyStoreException -> L34
    L12:
        sSystemCertificateDirectory = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");     // Catch: KeyStoreException -> L34
    L13:
        sLoadedSystemKeyStore = true;
    L15:
        if (sSystemTrustAnchorCache != null) goto L18;
        sSystemTrustAnchorCache = new HashSet();
    L18:
        if (sTestKeyStore != null) goto L22;
        KeyStore r2 = KeyStore.getInstance(KeyStore.getDefaultType());
        sTestKeyStore = r2;
        r2.load((KeyStore.LoadStoreParameter) ZeusTransformUtils.preCheckCast(null, KeyStore.LoadStoreParameter.class, "com.obric.memorydata.plugin"));     // Catch: IOException -> L33
    L22:
        if (sTestTrustManager != null) goto L25;
        sTestTrustManager = createTrustManager(sTestKeyStore);
    L25:
        if (sTrustStorageListener != null) goto L41;
        sTrustStorageListener = new TrustStorageListener(r1);
        IntentFilter r3 = new IntentFilter();
        if (Build.VERSION.SDK_INT < 26) goto L29;
        r3.addAction("android.security.action.KEYCHAIN_CHANGED");
        r3.addAction("android.security.action.KEY_ACCESS_CHANGED");
        String r4 = "android.security.action.TRUST_STORE_CHANGED";
    L30:
        r3.addAction(r4);
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(NetUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), sTrustStorageListener, r3, "com.obric.memorydata.plugin");
        return;
    L29:
        r4 = "android.security.STORAGE_CHANGED";
        goto L30
    }

    private static String hashPrincipal(X500Principal r7) {
        byte[] r8 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5).digest(r7.getEncoded());
        char[] r0 = new char[8];
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L7;
        int r3 = r1 * 2;
        char[] r4 = HEX_DIGITS;
        int r5 = 3 - r1;
        r0[r3] = r4[(r8[r5] >> 4) & 15];
        r0[r3 + 1] = r4[r8[r5] & 15];
        r1 = r1 + 1;
        goto L4
    L7:
        return new String(r0);
    }

    private static boolean isKnownRoot(X509Certificate r9) {
        if (sSystemKeyStore != null) goto L5;
        return false;
    L5:
        Pair<X500Principal, PublicKey> r0 = new Pair(r9.getSubjectX500Principal(), r9.getPublicKey());
        if (sSystemTrustAnchorCache.contains(r0) == false) goto L8;
        return true;
    L8:
        String r2 = hashPrincipal(r9.getSubjectX500Principal());
        int r4 = 0;
    L9:
        String r5 = r2 + '.' + r4;
        if (new File(sSystemCertificateDirectory, r5).exists() == false) goto L11;
        Certificate r6 = sSystemKeyStore.getCertificate("system:" + r5);
        if (r6 == null) goto L23;
        if (ZeusTransformUtils.instanceOf(r6, X509Certificate.class) == true) goto L17;
        Log.e(TAG, "Anchor " + r5 + " not an X509Certificate: " + r6.getClass().getName());
        goto L23
    L17:
        X509Certificate r7 = (X509Certificate) ZeusTransformUtils.preCheckCast(r6, X509Certificate.class, "com.obric.memorydata.plugin");
        if (r9.getSubjectX500Principal().equals(r7.getSubjectX500Principal()) == false) goto L23;
        if (r9.getPublicKey().equals(r7.getPublicKey()) == false) goto L23;
        sSystemTrustAnchorCache.add(r0);
        return true;
    L23:
        r4 = r4 + 1;
        goto L9
    L11:
        return false;
    }

    private static void reloadDefaultTrustManager() {
        Object r0 = sLock;
        monitor-enter(r0);
        sDefaultTrustManager = null;     // Catch: Throwable -> L8
        sSystemTrustAnchorCache = null;     // Catch: Throwable -> L8
        ensureInitializedLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static void reloadTestTrustManager() {
        sTestTrustManager = createTrustManager(sTestKeyStore);
    }

    public static void setDisableNativeCodeForTest(boolean r0) {
        sDisableNativeCodeForTest = r0;
    }

    static boolean verifyKeyUsage(X509Certificate r5) {
        List<String> r6 = r5.getExtendedKeyUsage();     // Catch: NullPointerException -> L20
        if (r6 != null) goto L7;
        return true;
    L7:
        Iterator<String> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        if (r2.equals(OID_TLS_SERVER_AUTH) == true) goto L19;
        if (r2.equals(OID_ANY_EKU) == true) goto L19;
        if (r2.equals(OID_SERVER_GATED_NETSCAPE) == true) goto L19;
        if (r2.equals(OID_SERVER_GATED_MICROSOFT) == false) goto L9;
    L19:
        return true;
    L10:
        return false;
    L20:
        return false;
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r8, String r9, String r10) {
        if (r8 == null) goto L58;
        if (r8.length == 0) goto L58;
        if (r8[0] == null) goto L58;
        ensureInitialized();     // Catch: CertificateException -> L55
        ArrayList r2 = new ArrayList();
        r2.add(createCertificateFromBytes(r8[0]));     // Catch: CertificateException -> L53
        int r4 = 1;
    L13:
        if (r4 >= r8.length) goto L18;
        r2.add(createCertificateFromBytes(r8[r4]));     // Catch: CertificateException -> L16
    L17:
        r4 = r4 + 1;
    L16:
        Log.w(TAG, "intermediate " + r4 + " failed parsing");
        goto L17
    L18:
        X509Certificate[] r11 = (X509Certificate[]) ZeusTransformUtils.preCheckCast((X509Certificate[]) ZeusTransformUtils.preCheckCast(r2.toArray(new X509Certificate[r2.size()]), X509Certificate[].class, "com.obric.memorydata.plugin"), X509Certificate[].class, "com.obric.memorydata.plugin");
        r11[0].checkValidity();     // Catch: CertificateException -> L47 CertificateNotYetValidException -> L49 CertificateExpiredException -> L51
        if (verifyKeyUsage(r11[0]) == true) goto L23;
        return new AndroidCertVerifyResult(-6);
    L23:
        Object r3 = sLock;
        monitor-enter(r3);
        X509TrustManagerImplementation r5 = sDefaultTrustManager;     // Catch: Throwable -> L44
        if (r5 != null) goto L66;
        AndroidCertVerifyResult r12 = new AndroidCertVerifyResult(-1);     // Catch: Throwable -> L44
        monitor-exit(r3);     // Catch: Throwable -> L44
        return r12;
    L66:
        List<X509Certificate> r13 = r5.checkServerTrusted(r11, r9, r10);     // Catch: CertificateException -> L32 Throwable -> L44
    L35:
        if (r13.size() <= 0) goto L37;
        boolean r14 = isKnownRoot((X509Certificate) ZeusTransformUtils.preCheckCast(r13.get(r13.size() - 1), X509Certificate.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L44
    L38:
        AndroidCertVerifyResult r15 = new AndroidCertVerifyResult(0, r14, r13);     // Catch: Throwable -> L44
        monitor-exit(r3);     // Catch: Throwable -> L44
        return r15;
    L37:
        r14 = false;
    L32:
        e = move-exception;
        r13 = sTestTrustManager.checkServerTrusted(r11, r9, r10);     // Catch: CertificateException -> L41 Throwable -> L44
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
