package androidx.core.content.pm;

import ai.j0;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
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
    public static class Api28Impl {
        private Api28Impl() {
        }

        @Nullable
        @DoNotInline
        public static Signature[] getApkContentsSigners(@NonNull SigningInfo r5) {
            return r5.getApkContentsSigners();
        }

        @DoNotInline
        public static long getLongVersionCode(PackageInfo r5) {
            return r5.getLongVersionCode();
        }

        @Nullable
        @DoNotInline
        public static Signature[] getSigningCertificateHistory(@NonNull SigningInfo r5) {
            return r5.getSigningCertificateHistory();
        }

        @DoNotInline
        public static boolean hasMultipleSigners(@NonNull SigningInfo r5) {
            return r5.hasMultipleSigners();
        }

        @DoNotInline
        public static boolean hasSigningCertificate(@NonNull PackageManager r5, @NonNull String r10, @NonNull byte[] r11, int r12) {
            return r5.hasSigningCertificate(r10, r11, r12);
        }
    }

    private PackageInfoCompat() {
    }

    private static boolean byteArrayContains(@NonNull byte[][] r5, @NonNull byte[] r10) {
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (Arrays.equals(r10, r5[r12]) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static byte[] computeSHA256Digest(byte[] r5) {
        return MessageDigest.getInstance("SHA256").digest(r5);
    L4:
        e = move-exception;
        throw new RuntimeException("Device doesn't support SHA256 cert checking", e);
    }

    public static long getLongVersionCode(@NonNull PackageInfo r5) {
        return Api28Impl.getLongVersionCode(r5);
    }

    @NonNull
    public static List<Signature> getSignatures(@NonNull PackageManager r5, @NonNull String r10) throws PackageManager.NameNotFoundException {
        SigningInfo r11 = r5.getPackageInfo(r10, 134217728).signingInfo;
        if (Api28Impl.hasMultipleSigners(r11) == false) goto L5;
        Signature[] r12 = Api28Impl.getApkContentsSigners(r11);
    L6:
        if (r12 != null) goto L10;
        return Collections.emptyList();
    L10:
        return Arrays.asList(r12);
    L5:
        r12 = Api28Impl.getSigningCertificateHistory(r11);
        goto L6
    }

    public static boolean hasSignatures(@NonNull PackageManager r10, @NonNull String r11, @NonNull @Size(min = 1) Map<byte[], Integer> r12, boolean r13) throws PackageManager.NameNotFoundException {
        if (r12.isEmpty() == false) goto L5;
        return false;
    L5:
        Set<byte[]> r5 = r12.keySet();
        Iterator<byte[]> r14 = r5.iterator();
    L7:
        if (r14.hasNext() == false) goto L22;
        byte[] r15 = r14.next();
        if (r15 == null) goto L21;
        Integer r16 = r12.get(r15);
        if (r16 == null) goto L19;
        int r17 = r16.intValue();
        if (r17 == 0) goto L7;
        if (r17 == 1) goto L7;
        throw new IllegalArgumentException("Unsupported certificate type " + r16 + " when verifying " + r11);
    L19:
        throw new IllegalArgumentException(j0.C("Type must be specified for cert when verifying ", r11));
    L21:
        throw new IllegalArgumentException(j0.C("Cert byte array cannot be null when verifying ", r11));
    L22:
        List<Signature> r18 = getSignatures(r10, r11);
        if (r13 == true) goto L32;
        Iterator<byte[]> r19 = r5.iterator();
    L26:
        if (r19.hasNext() == false) goto L30;
        byte[] r20 = r19.next();
        if (Api28Impl.hasSigningCertificate(r10, r11, r20, r12.get(r20).intValue()) == true) goto L26;
        return false;
    L30:
        return true;
    L32:
        if (r18.size() != 0) goto L34;
    L60:
        return false;
    L34:
        if (r12.size() > r18.size()) goto L60;
        if (r13 == false) goto L40;
        if (r12.size() != r18.size()) goto L60;
    L40:
        if (r12.containsValue(1) == false) goto L45;
        byte[][] r21 = new byte[r18.size()][];
        int r22 = 0;
    L43:
        if (r22 >= r18.size()) goto L46;
        r21[r22] = computeSHA256Digest(r18.get(r22).toByteArray());
        r22 = r22 + 1;
    L46:
        Iterator<byte[]> r23 = r5.iterator();
        if (r23.hasNext() == false) goto L60;
        byte[] r24 = r23.next();
        Integer r25 = r12.get(r24);
        int r110 = r25.intValue();
        if (r110 == 0) goto L57;
        if (r110 != 1) goto L55;
        if (byteArrayContains(r21, r24) == true) goto L59;
        return false;
    L59:
        return true;
    L55:
        throw new IllegalArgumentException("Unsupported certificate type " + r25);
    L57:
        if (r18.contains(new Signature(r24)) == true) goto L59;
        return false;
    L45:
        r21 = null;
        goto L46
    }
}
