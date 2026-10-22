package n6;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.obric.security.rot_provision.RotProvisionManager;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static int a(byte[] r8) {
        if (r8.length != 4) goto L7;
        int r10 = (((r8[0] & 255) << 24) | ((r8[1] & 255) << 16)) | ((r8[2] & 255) << 8);
        return (r8[3] & 255) | r10;
    L7:
        throw new IllegalArgumentException("Byte array must be exactly 4 bytes long");
    }

    public static String b(Certificate[] r8, int r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L10;
        String r13 = Base64.getEncoder().encodeToString(r8[r12].getEncoded());     // Catch: Exception -> L6
        r11.append("-----BEGIN CERTIFICATE-----\\n");     // Catch: Exception -> L6
        r11.append(r13);     // Catch: Exception -> L6
        r11.append("\\n-----END CERTIFICATE-----\\n");     // Catch: Exception -> L6
        r12 = r12 + 1;
    L6:
        e = move-exception;
        throw new c("certChainsToPEM failed, error: " + e.getMessage());
    L10:
        return r11.toString();
    }

    public static boolean c(Context r8) {
        String r10 = RotProvisionManager.getInstance().checkState(r8, new Bundle());     // Catch: Exception -> L8
        l6.a.W("TransUtils", "checkRotProvisionState:" + r10);     // Catch: Exception -> L8
        JSONObject r11 = new JSONObject(r10);     // Catch: Exception -> L8
        boolean r12 = r11.getBoolean("dev_key_provisioned");     // Catch: Exception -> L8
        boolean r13 = r11.getBoolean("dev_cert_provisioned");     // Catch: Exception -> L8
        if (r12 == false) goto L13;
        if (r13 == false) goto L14;
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

    public static byte[] d(byte[]... r8) {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        int r11 = r8.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.write(r8[r12]);
        r12 = r12 + 1;
        goto L3
    L6:
        return r10.toByteArray();
    }

    public static PublicKey e(String r8) {
        return KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(r8.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s", ""))));
    L5:
        e = move-exception;
        throw new c("getPublicKeyFromPEM failed, " + e.getMessage());
    }

    public static byte[] f(int r8) {
        ByteBuffer r10 = ByteBuffer.allocate(4);
        r10.putInt(r8);
        return r10.array();
    }

    public static boolean g(Context r8) {
        String r10 = "unknown";
        r10 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"vendor.km.devcert.status", "unknown"});     // Catch: Exception -> L5
    L8:
        if (TextUtils.equals(r10, "ok") == false) goto L10;
    L13:
        return true;
    L10:
        if (c(r8) == true) goto L13;
        return false;
    L5:
        e = move-exception;
        Log.e("TransUtils", "Get system property failed!! error:" + e.getMessage());
        goto L8
    }

    public static byte[] h(byte[] r8) {
        return MessageDigest.getInstance("SHA-256").digest(r8);
    }
}
