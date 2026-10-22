package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PackageUtils {
    private static final char[] HEX_CHAR_LOOKUP = null;
    private static final String TAG = "PackageUtils";

    static {
        HEX_CHAR_LOOKUP = "0123456789ABCDEF".toCharArray();
    }

    private PackageUtils() {
    }

    static String byteArrayToHexString(byte[] r10) {
        StringBuilder r11 = new StringBuilder((r10.length * 3) - 1);
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L10;
        char[] r13 = HEX_CHAR_LOOKUP;
        r11.append(r13[(r10[r12] & 240) >>> 4]);
        r11.append(r13[r10[r12] & 15]);
        if (r12 >= (r10.length - 1)) goto L8;
        r11.append(':');
    L8:
        r12 = r12 + 1;
        goto L4
    L10:
        return r11.toString();
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static List<String> getCertificateSHA256FingerprintForPackage(PackageManager r10, String r11) {
        PackageInfo r12 = r10.getPackageInfo(r11, 64);     // Catch: PackageManager.NameNotFoundException -> L16
        if (r12 != null) goto L6;
        return null;
    L6:
        ArrayList r13 = new ArrayList(r12.signatures.length);
        Signature[] r14 = r12.signatures;
        int r15 = r14.length;
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L15;
        String r17 = byteArrayToHexString(MessageDigest.getInstance("SHA256").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(r14[r16].toByteArray()))).getEncoded()));     // Catch: Throwable -> L11 CertificateEncodingException -> L13
    L12:
        r13.add(r17);
        r16 = r16 + 1;
    L11:
        r17 = null;
    L13:
        Log.w(TAG, "Certificate type X509 encoding failed", new Object[0]);
        return null;
    L15:
        return r13;
    L16:
        return null;
    }

    public static int getPackageVersion(Context r10, String r11) {
        PackageInfo r12 = r10.getPackageManager().getPackageInfo(r11, 0);     // Catch: PackageManager.NameNotFoundException -> L8
        if (r12 == null) goto L11;
        return r12.versionCode;
    L11:
        return -1;
    L12:
        return -1;
    }

    public static boolean isPackageInstalled(Context r10, String r11) {
        r10.getPackageManager().getPackageInfo(r11, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L6:
        return false;
    }
}
