package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TransUtils {
    private static final String TAG = "TransUtils";

    public TransUtils() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static long byteArrayToLong(byte[] r5) {
        long r0 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L6;
        r0 = (r0 << 8) | ((long) (r5[r2] & 255));
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static int bytesToInt(byte[] r2) {
        if (r2.length != 4) goto L7;
        int r0 = (((r2[0] & 255) << 24) | ((r2[1] & 255) << 16)) | ((r2[2] & 255) << 8);
        return (r2[3] & 255) | r0;
    L7:
        throw new IllegalArgumentException("Byte array must be exactly 4 bytes long");
    }

    public static long bytesToLong(byte[] r6) {
        if (r6.length != 8) goto L7;
        long r2 = (((((((long) (r6[0] & 255)) << 56) | (((long) (r6[1] & 255)) << 48)) | (((long) (r6[2] & 255)) << 40)) | (((long) (r6[3] & 255)) << 32)) | (((long) (r6[4] & 255)) << 24)) | (((long) (r6[5] & 255)) << 16);
        return ((((long) (r6[6] & 255)) << 8) | r2) | ((long) (r6[7] & 255));
    L7:
        throw new IllegalArgumentException("Byte array must be exactly 8 bytes long");
    }

    public static String certChainsToPEM(Certificate[] r4, int r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L10;
        String r2 = Base64.getEncoder().encodeToString(r4[r1].getEncoded());     // Catch: Exception -> L6
        r0.append("-----BEGIN CERTIFICATE-----\\n");     // Catch: Exception -> L6
        r0.append(r2);     // Catch: Exception -> L6
        r0.append("\\n-----END CERTIFICATE-----\\n");     // Catch: Exception -> L6
        r1 = r1 + 1;
    L6:
        e = move-exception;
        throw new CloudTransException("certChainsToPEM failed, error: " + e.getMessage());
    L10:
        return r0.toString();
    }

    private static boolean checkRotProvisionState(Context r4) {
        String r5 = FrameworkSecurityCompat.rotCheckState(r4, new Bundle());     // Catch: Exception -> L8
        LogUtils.i(TAG, "checkRotProvisionState:" + r5);     // Catch: Exception -> L8
        JSONObject r0 = new JSONObject(r5);     // Catch: Exception -> L8
        boolean r6 = JSONObjectProtectorUtils.getBoolean(r0, "dev_key_provisioned");     // Catch: Exception -> L8
        boolean r1 = JSONObjectProtectorUtils.getBoolean(r0, "dev_cert_provisioned");     // Catch: Exception -> L8
        if (r6 == false) goto L13;
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static boolean checkVendorKmProp() {
        return TextUtils.equals(getSystemProperty("vendor.km.devcert.status"), "ok");
    }

    public static byte[] concatenate(byte[]... r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.write(r4[r2]);
        r2 = r2 + 1;
        goto L3
    L6:
        return r0.toByteArray();
    }

    public static String convertToPem(PublicKey r2) {
        if ("EC".equals(r2.getAlgorithm()) == false) goto L7;
        return "-----BEGIN PUBLIC KEY-----\\n" + Base64.getEncoder().encodeToString(r2.getEncoded()) + "\\n-----END PUBLIC KEY-----";
    L7:
        throw new IllegalArgumentException("不是有效的ECC公钥");
    }

    public static PublicKey getPublicKeyFromBytes(byte[] r1) {
        X509EncodedKeySpec r0 = new X509EncodedKeySpec(r1);
        return KeyFactory.getInstance("EC").generatePublic(r0);
    }

    public static PublicKey getPublicKeyFromPEM(String r3) {
        return KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(r3.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s", ""))));
    L5:
        e = move-exception;
        throw new CloudTransException("getPublicKeyFromPEM failed, " + e.getMessage());
    }

    public static String getSystemProperty(String r8) {
        return (String) INVOKESTATIC_com_bytedance_crypto_cloudtrans_TransUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r8, "unknown"});
    L5:
        e = move-exception;
        LogUtils.e(TAG, "Get system property failed!! error:" + e.getMessage());
        return "unknown";
    }

    public static byte[] intToByteArray(int r1) {
        ByteBuffer r0 = ByteBuffer.allocate(4);
        r0.putInt(r1);
        return r0.array();
    }

    public static boolean isBDDevice() {
        INVOKESTATIC_com_bytedance_crypto_cloudtrans_TransUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.security.secretdata.SecretDataManager");     // Catch: ClassNotFoundException -> L5
        return true;
    L5:
        INVOKESTATIC_com_bytedance_crypto_cloudtrans_TransUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.obric.security.secretdata.SecretDataManager");     // Catch: ClassNotFoundException -> L7
        return true;
    L7:
        INVOKESTATIC_com_bytedance_crypto_cloudtrans_TransUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.aiassistant.security.secretdata.SecretDataManager");     // Catch: ClassNotFoundException -> L9
        return true;
    L9:
        return false;
    }

    public static boolean isDevCertExist(Context r1) {
        if (checkVendorKmProp() == false) goto L5;
    L8:
        return true;
    L5:
        if (checkRotProvisionState(r1) == true) goto L8;
        return false;
    }

    public static void logLongString(String r2, String r3) {
        if (r3.length() <= 4000) goto L8;
        int r4 = 0;
    L6:
        if (r4 >= r3.length()) goto L10;
        int r1 = r4 + 4000;
        r3.substring(r4, Math.min(r3.length(), r1));
        r4 = r1;
        goto L6
    L10:
        return;
    }

    public static byte[] longToByteArray(long r1) {
        ByteBuffer r0 = ByteBuffer.allocate(8);
        r0.putLong(r1);
        return r0.array();
    }

    public static void printErrorInfo(String r0, String r1) {
        LogUtils.e(r0, r1);
        throw new CloudTransException(r1);
    }

    public static byte[] sha256(byte[] r1) {
        return MessageDigest.getInstance("SHA-256").digest(r1);
    }

    public static boolean verifySignature(PublicKey r1, byte[] r2, String r3) {
        Signature r0 = Signature.getInstance("SHA256withECDSA");
        r0.initVerify(r1);
        r0.update(r2);
        return r0.verify(CryptoUtils.hexStringToByteArray(r3));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_crypto_cloudtrans_TransUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }
}
