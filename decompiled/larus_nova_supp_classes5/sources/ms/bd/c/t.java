package ms.bd.c;

import android.os.Build;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class t {
    public static HashMap a() {
        HashMap r0 = new HashMap();
        r0.put((String) p2.a(16777217, 0, 0, "b294e9", new byte[]{34}), Build.MODEL);
        r0.put((String) p2.a(16777217, 0, 0, "f282d0", new byte[]{37}), Build.BRAND);
        r0.put((String) p2.a(16777217, 0, 0, "06438f", new byte[]{114}), Build.BOARD);
        r0.put((String) p2.a(16777217, 0, 0, "fa4473", new byte[]{35}), Build.VERSION.RELEASE);
        r0.put((String) p2.a(16777217, 0, 0, "8afa6b", new byte[]{124}), Build.DISPLAY);
        r0.put((String) p2.a(16777217, 0, 0, "73c2bc", new byte[]{112}), Build.HARDWARE);
        r0.put((String) p2.a(16777217, 0, 0, "69e59a", new byte[]{112}), Build.FINGERPRINT);
        return r0;
    }
}
