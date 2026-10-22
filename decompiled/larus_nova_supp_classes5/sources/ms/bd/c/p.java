package ms.bd.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.security.KeyPairGenerator;
import java.security.spec.ECGenParameterSpec;
import java.util.Date;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class p {
    public static boolean a(String r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        if (b(r3, true) == false) goto L7;
        return true;
    L7:
        return b(r3, false);
    }

    public static boolean b(String r18, boolean r19) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L21;
        Date r1 = new Date();
        KeyGenParameterSpec.Builder r3 = new KeyGenParameterSpec.Builder(r18, 12).setAlgorithmParameterSpec(new ECGenParameterSpec((String) p2.a(16777217, 0, 0, "cef7c2", new byte[]{97, 98, 22, 83, 14, 112, 54, 86, 102}))).setDigests(new String[]{(String) p2.a(16777217, 0, 0, "cc42f5", new byte[]{65, 73, 102, 11, 11, 119, 54}), (String) p2.a(16777217, 0, 0, "13d653", new byte[]{19, 25, 54, 15, 89, 124, 102}), (String) p2.a(16777217, 0, 0, "152e3c", new byte[]{19, 31, 96, 92, 89, 37, 96})}).setKeyValidityStart(r1);
        if (r0 < 24) goto L7;
        r3.setAttestationChallenge(r1.toString().getBytes());
    L7:
        Context r2 = d2.b.a;
        if (r2 != null) goto L10;
        PackageManager r4 = null;
    L11:
        if (r19 == false) goto L23;
        if (r0 < 31) goto L23;
        if (r4 == null) goto L23;
        if (r4.hasSystemFeature((String) p2.a(16777217, 0, 0, "b1face", new byte[]{114, 61, 17, 7, 83, 123, 101, 94, 36, 62, 117, 39, 2, 20, 78, 119, 47, 20, 50, 39, 122, 48, 16, 42, 85, 118, 94, 17, 35, 37, 118, 32, 1, 20, 72, 123, 110, 30})) == false) goto L23;
        r3.setDevicePropertiesAttestationIncluded(true);
    L23:
        KeyPairGenerator r5 = KeyPairGenerator.getInstance((String) p2.a(16777217, 0, 0, "51affe", new byte[]{1, 16}), (String) p2.a(16777217, 0, 0, "837edd", new byte[]{8, 63, 64, 3, 84, 122, 63, 57, 99, 44, 26, 37, 75, 3, 94}));     // Catch: Exception -> L22
        r5.initialize(r3.build());     // Catch: Exception -> L22
        r5.generateKeyPair();     // Catch: Exception -> L22
        return true;
    L10:
        r4 = r2.getPackageManager();
    L21:
        return false;
    }
}
