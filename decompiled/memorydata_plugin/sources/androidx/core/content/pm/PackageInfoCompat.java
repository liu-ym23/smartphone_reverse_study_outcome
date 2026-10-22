package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PackageInfoCompat {

    private static class Api28Impl {
        private Api28Impl() {
        }

        static Signature[] getApkContentsSigners(SigningInfo r0) {
            return r0.getApkContentsSigners();
        }

        static long getLongVersionCode(PackageInfo r2) {
            return r2.getLongVersionCode();
        }

        static Signature[] getSigningCertificateHistory(SigningInfo r0) {
            return r0.getSigningCertificateHistory();
        }

        static boolean hasMultipleSigners(SigningInfo r0) {
            return r0.hasMultipleSigners();
        }

        static boolean hasSigningCertificate(PackageManager r0, String r1, byte[] r2, int r3) {
            return r0.hasSigningCertificate(r1, r2, r3);
        }
    }

    private PackageInfoCompat() {
    }

    private static boolean byteArrayContains(byte[][] r4, byte[] r5) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (Arrays.equals(r5, r4[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static byte[] computeSHA256Digest(byte[] r2) {
        return MessageDigest.getInstance("SHA256").digest(r2);
    L4:
        e = move-exception;
        throw new RuntimeException("Device doesn't support SHA256 cert checking", e);
    }

    public static long getLongVersionCode(PackageInfo r2) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getLongVersionCode(r2);
    L7:
        return r2.versionCode;
    }

    public static List<Signature> getSignatures(PackageManager r2, String r3) {
        if (Build.VERSION.SDK_INT < 28) goto L8;
        SigningInfo r4 = r2.getPackageInfo(r3, 134217728).signingInfo;
        if (Api28Impl.hasMultipleSigners(r4) == false) goto L7;
        Signature[] r5 = Api28Impl.getApkContentsSigners(r4);
    L9:
        if (r5 != null) goto L13;
        return Collections.emptyList();
    L13:
        return Arrays.asList(r5);
    L7:
        r5 = Api28Impl.getSigningCertificateHistory(r4);
        goto L9
    L8:
        r5 = r2.getPackageInfo(r3, 64).signatures;
        goto L9
    }

    public static boolean hasSignatures(PackageManager r9, String r10, Map<byte[], Integer> r11, boolean r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        if (r13.isEmpty() == false) goto L5;
        return false;
    L5:
        Set r1 = r13.keySet();
        Iterator r4 = r1.iterator();
    L7:
        if (r4.hasNext() == false) goto L22;
        byte[] r5 = (byte[]) ZeusTransformUtils.preCheckCast(r4.next(), byte[].class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L21;
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r13.get(r5), Integer.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L19;
        int r8 = r6.intValue();
        if (r8 == 0) goto L7;
        if (r8 == 1) goto L7;
        throw new IllegalArgumentException("Unsupported certificate type " + r6 + " when verifying " + r10);
    L19:
        throw new IllegalArgumentException("Type must be specified for cert when verifying " + r10);
    L21:
        throw new IllegalArgumentException("Cert byte array cannot be null when verifying " + r10);
    L22:
        List<Signature> r7 = getSignatures(r9, r10);
        if (r12 == true) goto L34;
        if (Build.VERSION.SDK_INT < 28) goto L34;
        Iterator r14 = r1.iterator();
    L28:
        if (r14.hasNext() == false) goto L32;
        byte[] r2 = (byte[]) ZeusTransformUtils.preCheckCast(r14.next(), byte[].class, "com.obric.memorydata.plugin");
        if (Api28Impl.hasSigningCertificate(r9, r10, r2, ((Integer) ZeusTransformUtils.preCheckCast(r13.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue()) == true) goto L28;
        return false;
    L32:
        return true;
    L34:
        if (r7.size() != 0) goto L36;
    L61:
        return false;
    L36:
        if (r13.size() > r7.size()) goto L61;
        if (r12 == true) goto L39;
    L41:
        byte[][] r15 = null;
        if (r13.containsValue(1) == false) goto L47;
        r15 = new byte[r7.size()][];
        int r16 = 0;
    L45:
        if (r16 >= r7.size()) goto L47;
        r15[r16] = computeSHA256Digest(((Signature) ZeusTransformUtils.preCheckCast(r7.get(r16), Signature.class, "com.obric.memorydata.plugin")).toByteArray());
        r16 = r16 + 1;
    L47:
        Iterator r17 = r1.iterator();
        if (r17.hasNext() == false) goto L61;
        byte[] r18 = (byte[]) ZeusTransformUtils.preCheckCast(r17.next(), byte[].class, "com.obric.memorydata.plugin");
        Integer r19 = (Integer) ZeusTransformUtils.preCheckCast(r13.get(r18), Integer.class, "com.obric.memorydata.plugin");
        int r110 = r19.intValue();
        if (r110 == 0) goto L58;
        if (r110 != 1) goto L56;
        if (byteArrayContains(r15, r18) == true) goto L60;
        return false;
    L60:
        return true;
    L56:
        throw new IllegalArgumentException("Unsupported certificate type " + r19);
    L58:
        if (r7.contains(new Signature(r18)) == true) goto L60;
        return false;
    L39:
        if (r13.size() == r7.size()) goto L41;
        goto L41
    }
}
