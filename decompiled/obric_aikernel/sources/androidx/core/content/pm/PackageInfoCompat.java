package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PackageInfoCompat {

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        @Nullable
        @DoNotInline
        static Signature[] getApkContentsSigners(@NonNull SigningInfo r10) {
            return r10.getApkContentsSigners();
        }

        @DoNotInline
        static long getLongVersionCode(PackageInfo r10) {
            return r10.getLongVersionCode();
        }

        @Nullable
        @DoNotInline
        static Signature[] getSigningCertificateHistory(@NonNull SigningInfo r10) {
            return r10.getSigningCertificateHistory();
        }

        @DoNotInline
        static boolean hasMultipleSigners(@NonNull SigningInfo r10) {
            return r10.hasMultipleSigners();
        }

        @DoNotInline
        static boolean hasSigningCertificate(@NonNull PackageManager r10, @NonNull String r11, @NonNull byte[] r12, int r13) {
            return r10.hasSigningCertificate(r11, r12, r13);
        }
    }

    private PackageInfoCompat() {
    }

    private static boolean byteArrayContains(@NonNull byte[][] r10, @NonNull byte[] r11) {
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (Arrays.equals(r11, r10[r13]) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static byte[] computeSHA256Digest(byte[] r10) {
        return MessageDigest.getInstance("SHA256").digest(r10);
    L4:
        e = move-exception;
        throw new RuntimeException("Device doesn't support SHA256 cert checking", e);
    }

    public static long getLongVersionCode(@NonNull PackageInfo r10) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getLongVersionCode(r10);
    L7:
        return r10.versionCode;
    }

    @NonNull
    public static List<Signature> getSignatures(@NonNull PackageManager r10, @NonNull String r11) {
        if (Build.VERSION.SDK_INT < 28) goto L8;
        SigningInfo r12 = r10.getPackageInfo(r11, 134217728).signingInfo;
        if (Api28Impl.hasMultipleSigners(r12) == false) goto L7;
        Signature[] r13 = Api28Impl.getApkContentsSigners(r12);
    L9:
        if (r13 != null) goto L13;
        return Collections.emptyList();
    L13:
        return Arrays.asList(r13);
    L7:
        r13 = Api28Impl.getSigningCertificateHistory(r12);
        goto L9
    L8:
        r13 = r10.getPackageInfo(r11, 64).signatures;
        goto L9
    }

    public static boolean hasSignatures(@NonNull PackageManager r10, @NonNull String r11, @NonNull @Size(min = 1) Map<byte[], Integer> r12, boolean r13) {
        if (r12.isEmpty() == false) goto L5;
        return false;
    L5:
        Set<byte[]> r14 = r12.keySet();
        Iterator<byte[]> r15 = r14.iterator();
    L7:
        if (r15.hasNext() == false) goto L22;
        byte[] r16 = r15.next();
        if (r16 == null) goto L21;
        Integer r17 = r12.get(r16);
        if (r17 == null) goto L19;
        int r18 = r17.intValue();
        if (r18 == 0) goto L7;
        if (r18 == 1) goto L7;
        throw new IllegalArgumentException("Unsupported certificate type " + r17 + " when verifying " + r11);
    L19:
        throw new IllegalArgumentException("Type must be specified for cert when verifying " + r11);
    L21:
        throw new IllegalArgumentException("Cert byte array cannot be null when verifying " + r11);
    L22:
        List<Signature> r19 = getSignatures(r10, r11);
        if (r13 == true) goto L34;
        if (Build.VERSION.SDK_INT < 28) goto L34;
        Iterator<byte[]> r110 = r14.iterator();
    L28:
        if (r110.hasNext() == false) goto L32;
        byte[] r20 = r110.next();
        if (Api28Impl.hasSigningCertificate(r10, r11, r20, r12.get(r20).intValue()) == true) goto L28;
        return false;
    L32:
        return true;
    L34:
        if (r19.size() != 0) goto L36;
    L61:
        return false;
    L36:
        if (r12.size() > r19.size()) goto L61;
        if (r13 == true) goto L39;
    L41:
        byte[][] r21 = null;
        if (r12.containsValue(1) == false) goto L47;
        r21 = new byte[r19.size()][];
        int r22 = 0;
    L45:
        if (r22 >= r19.size()) goto L47;
        r21[r22] = computeSHA256Digest(r19.get(r22).toByteArray());
        r22 = r22 + 1;
    L47:
        Iterator<byte[]> r23 = r14.iterator();
        if (r23.hasNext() == false) goto L61;
        byte[] r24 = r23.next();
        Integer r25 = r12.get(r24);
        int r111 = r25.intValue();
        if (r111 == 0) goto L58;
        if (r111 != 1) goto L56;
        if (byteArrayContains(r21, r24) == true) goto L60;
        return false;
    L60:
        return true;
    L56:
        throw new IllegalArgumentException("Unsupported certificate type " + r25);
    L58:
        if (r19.contains(new Signature(r24)) == true) goto L60;
        return false;
    L39:
        if (r12.size() == r19.size()) goto L41;
        goto L41
    }
}
