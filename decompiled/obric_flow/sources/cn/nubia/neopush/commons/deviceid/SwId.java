package cn.nubia.neopush.commons.deviceid;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public class SwId {
    private static final String TAG = "SwId";

    public static class Holder {
        static final SecureRandom sNG = null;

        static {
            sNG = new SecureRandom();
        }

        private Holder() {
        }
    }

    public SwId() {
    }

    public static String generateRandomId(String r5) {
        if (r5 != null) goto L6;
        r5 = HwId.getSerial();
        if (TextUtils.isEmpty(r5) == false) goto L6;
        r5 = String.valueOf(Build.MANUFACTURER) + Build.MODEL + Build.ID + SystemClock.uptimeMillis();
    L6:
        byte[] r10 = new byte[32];
        Holder.sNG.nextBytes(r10);
        String r11 = IdCodecer.sha256(r5, r10);
        if (TextUtils.isEmpty(r11) == false) goto L10;
        r11 = IdCodecer.toHexString(r10);
    L10:
        if (TextUtils.isEmpty(r11) == false) goto L13;
        return IdCodecer.FAKE_ID;
    L13:
        return r11;
    }
}
