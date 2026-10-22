package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class PackageUtils {
    private static final char[] HEX_CHAR_LOOKUP = null;
    private static final String TAG = "PackageUtils";

    static {
        HEX_CHAR_LOOKUP = "0123456789ABCDEF".toCharArray();
    }

    private PackageUtils() {
    }

    static String byteArrayToHexString(byte[] r4) {
        StringBuilder r0 = new StringBuilder((r4.length * 3) - 1);
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L10;
        char[] r2 = HEX_CHAR_LOOKUP;
        r0.append(r2[(r4[r1] & 240) >>> 4]);
        r0.append(r2[r4[r1] & 15]);
        if (r1 >= (r4.length - 1)) goto L8;
        r0.append(':');
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return r0.toString();
    }

    public static List<String> getCertificateSHA256FingerprintForPackage(PackageManager r7, String r8) {
        PackageInfo r9 = r7.getPackageInfo(r8, 64);     // Catch: PackageManager.NameNotFoundException -> L16
        if (r9 != null) goto L6;
        return null;
    L6:
        ArrayList r10 = new ArrayList(r9.signatures.length);
        Signature[] r11 = r9.signatures;
        int r0 = r11.length;
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L15;
        String r4 = byteArrayToHexString(MessageDigest.getInstance("SHA256").digest(((X509Certificate) ZeusTransformUtils.preCheckCast(CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(r11[r3].toByteArray())), X509Certificate.class, "com.obric.memorydata.plugin")).getEncoded()));     // Catch: Throwable -> L11 CertificateEncodingException -> L13
    L12:
        r10.add(r4);
        r3 = r3 + 1;
    L11:
        r4 = null;
    L13:
        Log.w(TAG, "Certificate type X509 encoding failed", new Object[0]);
        return null;
    L15:
        return r10;
    L16:
        return null;
    }

    public static int getPackageVersion(Context r2, String r3) {
        PackageInfo r4 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L8
        if (r4 == null) goto L11;
        return r4.versionCode;
    L11:
        return -1;
    L12:
        return -1;
    }

    public static boolean isPackageInstalled(Context r2, String r3) {
        ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L6:
        return false;
    }
}
