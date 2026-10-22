package n4a;

import android.net.wifi.WifiInfo;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r3 {
    public final WifiInfo a;
    public String b;
    public String c;
    public int d;

    public r3(WifiInfo r2) {
        this.d = -1;
        this.a = r2;
    }

    public final String a() {
        if (this.b != null) goto L28;
        WifiInfo r1 = this.a;
        if (r1 != null) goto L7;
        String r10 = null;
    L26:
        this.b = r10;
        goto L28
    L7:
        ArrayList r11 = new ArrayList();
        Object[] r13 = new Object[0];
        f06.b r14 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101000);
        if (r2 == null) goto L10;
        f06.a[] r3 = r2.i;
    L11:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L13:
        if (r7 >= r8) goto L20;
        f06.a r6 = r9[r7];
        int r18 = r7;
        int r19 = r8;
        f06.a[] r20 = r9;
        f06.d r4 = r6.preInvoke(101000, "android/net/wifi/WifiInfo", "getSSID", r1, r13, "java.lang.String", r14);     // Catch: Exception -> L29
        if (r4.a == true) goto L22;
        r11.add(r6);     // Catch: Exception -> L29
    L22:
        if (r4.a == false) goto L24;
        String r5 = (String) r4.b;
    L25:
        r10 = r5;
        goto L26
    L24:
        r5 = r1.getSSID();
    L19:
        r7 = r18 + 1;
        r8 = r19;
        r9 = r20;
        goto L13
    L20:
        r4 = new f06.d(false, null);
        goto L22
    L10:
        r3 = ApiHookConfig.d;
    L28:
        return this.b;
    }
}
