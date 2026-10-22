package ms.bd.c;

import android.content.Context;
import android.os.Process;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import g06.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class d3 {
    public static boolean a() {
        return b(new String[]{(String) p2.a(16777217, 0, 0, "5c1e9e", new byte[]{37, 111, 70, 3, 9, 123, 50, 12, 112, 48, 54, 108, 75, 2, 21, 123, 57, 76, 46, 20, 7, 66, 103, 34, 53, 77, 1, 107, 70, 28, 27, 82, 118, 48, 50, 87})});
    }

    public static boolean b(String... r7) {
        Context r1 = d2.b.a;     // Catch: Throwable -> L11
        int r2 = r7.length;     // Catch: Throwable -> L11
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L9;
        if (c(r1, r7[r3], Process.myPid(), Process.myUid()) != 0) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    L11:
        return false;
    }

    public static int c(Context r18, String r19, int r20, int r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, Integer.valueOf(r20), Integer.valueOf(r21)};
        b r11 = new b("auto_cert_ms_bd_c_d3_android_content_Context_checkPermission");
        a r2 = (a) ApiHookConfig.b.get(102607);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102607, "android/content/Context", "checkPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkPermission(r19, r20, r21);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
