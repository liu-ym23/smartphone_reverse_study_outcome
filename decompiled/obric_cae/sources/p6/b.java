package p6;

import android.content.Context;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import com.obric.security.keymanager.KeyManager;
import com.obric.security.keymanager.KeyManagerResult;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;
import java.util.List;
import n6.c;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f9946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9947b;

        public a(byte[] r8) {
            if (r8[0] != 48) goto L10;
            this.f9946a = r8;
            int r10 = 1;
            this.f9947b = 1;
            int r11 = b.a(1, r8);
            int r12 = this.f9947b;
            if (r11 <= 127) goto L7;
            r10 = 1 + (r11 / 128);
        L7:
            this.f9947b = r12 + r10;
            return;
        L10:
            throw new IOException("Expected SEQUENCE tag (0x30)");
        }

        public final boolean a() {
            if (this.f9947b >= this.f9946a.length) goto L5;
            return true;
        L5:
            return false;
        }

        public final byte[] b() {
            if (a() == false) goto L11;
            int r8 = this.f9947b;
            byte[] r10 = this.f9946a;
            byte r11 = r10[r8];
            int r12 = b.a(r8 + 1, r10);
            if (r12 <= 127) goto L7;
            int r13 = (r12 / 128) + 1;
        L8:
            int r14 = (r13 + 1) + r12;
            int r15 = this.f9947b;
            byte[] r16 = Arrays.copyOfRange(r10, r15, r15 + r14);
            this.f9947b += r14;
            return r16;
        L7:
            r13 = 1;
            goto L8
        L11:
            throw new IOException("No more elements in sequence");
        }
    }

    public static int a(int r8, byte[] r10) {
        int r11 = r10[r8] & 255;
        if (r11 > 127) goto L5;
        return r11;
    L5:
        int r12 = r11 & QesdkUtils.LIMITS.INT_8_UPPER;
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r12) goto L8;
        r14 = (r14 << 8) | (r10[(r8 + 1) + r13] & 255);
        r13 = r13 + 1;
        goto L6
    L8:
        return r14;
    }

    public static void b(Context r8, String r10) {
        l6.a.W("KeyPairHelper", "deleteKey succeed, alias:" + r10 + " ret:" + KeyManager.getInstance().deleteKey(r8, r10, new Bundle()));
    }

    public static void c(Context r8, String r10) {
        Bundle r11 = new Bundle();
        r11.putInt("key_algorithm", 2);
        r11.putInt("key_length", 256);
        r11.putInt("key_purpose", 96);
        int r12 = KeyManager.getInstance().generateKeyPair(r8, r10, r11);
        if (r12 != 0) goto L6;
        return;
    L6:
        throw new c(defpackage.a.d("generate ecdsa keypair failed, error: key manager generate key pair failed, ret:", r12));
    }

    public static void d(String r8, String r10) {
        KeyPairGenerator r11 = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");     // Catch: Throwable -> L7
        r11.initialize(new KeyGenParameterSpec.Builder(r8, 68).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests(new String[]{"SHA-256"}).setAttestationChallenge(r10.getBytes()).setKeySize(256).build());     // Catch: Throwable -> L7
        if (r11.generateKeyPair() == null) goto L6;
        return;
    L6:
        throw new c("generate ecdsa keypair failed, error: key pair is null");     // Catch: Throwable -> L7
    L7:
        e = move-exception;
        throw new c("generate ecdsa keypair failed, error:" + e.getMessage());
    }

    public static Certificate[] e(Context r8, String r10, String r11) {
        Bundle r12 = new Bundle();
        r12.putString("challenge", r11);
        KeyManagerResult r13 = KeyManager.getInstance().keyAttestation(r8, r10, r12);
        if (r13.getResultCode() != 0) goto L13;
        List r14 = r13.getCertChain();
        if (r14 == null) goto L11;
        if (r14.isEmpty() == true) goto L11;
        return (Certificate[]) r14.toArray(new Certificate[0]);
    L11:
        throw new c("load cert chain failed, error: cert chain is empty");
    L13:
        throw new c("load cert chain failed, error: key manager attest key failed, ret:" + r13.getResultCode());
    }

    public static Certificate[] f(String r8) {
        KeyStore r10 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L11
        r10.load(null);     // Catch: Exception -> L11
        Certificate[] r11 = r10.getCertificateChain(r8);     // Catch: Exception -> L11
        if (r11 == null) goto L10;
        if (r11.length == 0) goto L10;
        Log.i("challenge", "challenge:".concat(new String(g((X509Certificate) r11[0]))));     // Catch: Exception -> L11
        return r11;
    L10:
        throw new c("load cert chain failed, error: cert chain is empty");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        throw new c("load cert failed, error:" + e.getMessage());
    }

    public static byte[] g(X509Certificate r8) {
        byte[] r10 = r8.getExtensionValue("1.3.6.1.4.1.11129.2.1.17");
        if (r10 == null) goto L33;
        if (r10[0] != 4) goto L31;
        int r11 = a(1, r10);
        int r12 = 2;
        if (r11 <= 127) goto L9;
        int r13 = (r11 / 128) + 2;
    L10:
        a r14 = new a(Arrays.copyOfRange(r10, r13, r11 + r13));
        int r15 = 0;
    L12:
        if (r14.a() == false) goto L29;
        byte[] r16 = r14.b();
        if (r15 == 4) goto L15;
        r15 = r15 + 1;
        goto L12
    L15:
        byte r17 = r16[0];
        if (r17 != 4) goto L26;
        if (r17 != 4) goto L24;
        int r18 = a(1, r16);
        if (r18 <= 127) goto L22;
        r12 = 2 + (r18 / 128);
    L22:
        return Arrays.copyOfRange(r16, r12, r18 + r12);
    L24:
        throw new IOException("Expected OCTET STRING tag (0x04)");
    L26:
        throw new IOException("Unexpected ASN.1 tag at index 4: " + r16[0]);
    L29:
        throw new IOException("Challenge not found at index 4");
    L9:
        r13 = 2;
        goto L10
    L31:
        throw new IOException("Expected OCTET STRING tag (0x04)");
    L33:
        throw new RuntimeException("No Attestation Extension found");
    }

    public static KeyPair h(String r8) {
        KeyStore r10 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Throwable -> L4
        r10.load(null);     // Catch: Throwable -> L4
        return new KeyPair(r10.getCertificate(r8).getPublicKey(), (PrivateKey) r10.getKey(r8, null));
    L4:
        e = move-exception;
        throw new c("load key pair failed, error:" + e.getMessage());
    }
}
