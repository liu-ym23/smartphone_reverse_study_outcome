package ms.bd.c;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import java.util.TimeZone;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class a0 {
    public static String b() {
        TimeZone r1 = TimeZone.getDefault();     // Catch: Throwable -> L6
        String r2 = r1.getID();     // Catch: Throwable -> L6
        int r3 = ((r1.getRawOffset() / 60) / 60) / 1000;     // Catch: Throwable -> L10
    L9:
        return r2 + ((String) p2.a(16777217, 0, 0, "703361", new byte[]{106})) + r3;
    L7:
        r3 = 0;
    L6:
        r2 = null;
        goto L7
    }

    public static int a(Context r8) {
        PowerManager r0 = (PowerManager) r8.getSystemService((String) p2.a(16777217, 0, 0, "226a9b", new byte[]{51, 63, 82, 16, 20}));
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.isInteractive() == true) goto L9;
        return 1;
    L9:
        KeyguardManager r9 = (KeyguardManager) r8.getSystemService((String) p2.a(16777217, 0, 0, "a5a2be", new byte[]{123, 50, 11, 65, 72, 115, 112, 16}));
        if (r9 != null) goto L13;
        return 0;
    L13:
        if (r9.inKeyguardRestrictedInputMode() == false) goto L16;
        return 2;
    L16:
        return 3;
    }
}
