package n4a;

import android.net.wifi.WifiInfo;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p3 {
    public static String a(WifiInfo r19) {
        if (r19 != null) goto L5;
        return null;
    L5:
        ArrayList r9 = new ArrayList();
        Object[] r11 = new Object[0];
        f06.b r12 = new f06.b();
        g06.a r1 = (g06.a) ApiHookConfig.b.get(101100);
        if (r1 == null) goto L8;
        f06.a[] r2 = r1.i;
    L9:
        f06.a[] r8 = r2;
        int r7 = r8.length;
        int r6 = 0;
    L11:
        if (r6 >= r7) goto L18;
        f06.a r5 = r8[r6];
        int r16 = r6;
        int r17 = r7;
        f06.a[] r18 = r8;
        f06.d r3 = r5.preInvoke(101100, "android/net/wifi/WifiInfo", "getBSSID", r19, r11, "java.lang.String", r12);     // Catch: Exception -> L24
        if (r3.a == true) goto L20;
        r9.add(r5);     // Catch: Exception -> L24
    L20:
        if (r3.a == false) goto L23;
        return (String) r3.b;
    L23:
        return r19.getBSSID();
    L17:
        r6 = r16 + 1;
        r7 = r17;
        r8 = r18;
        goto L11
    L18:
        r3 = new f06.d(false, null);
        goto L20
    L8:
        r2 = ApiHookConfig.d;
        goto L9
    }
}
