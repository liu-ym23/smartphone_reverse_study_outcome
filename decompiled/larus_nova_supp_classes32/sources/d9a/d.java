package d9a;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public static String[] a;

    public static Map<String, Boolean> a(Context r27) {
        HashMap r0 = new HashMap();
        String[] r1 = a;
        if (r1 == null) goto L31;
        int r2 = r1.length;
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L31;
        String r5 = r1[r4];
        if (TextUtils.isEmpty(r5) == true) goto L29;
        int r6 = Process.myPid();
        int r7 = Process.myUid();
        ArrayList r8 = new ArrayList();
        boolean r18 = true;
        Object[] r9 = {r5, Integer.valueOf(r6), Integer.valueOf(r7)};
        f06.b r15 = new f06.b("auto_cert_com_monitor_cloudmessage_utils_PermissionUtils_android_content_Context_checkPermission");
        g06.a r10 = (g06.a) ApiHookConfig.b.get(102607);
        if (r10 == null) goto L12;
        f06.a[] r11 = r10.i;
    L13:
        f06.a[] r14 = r11;
        int r13 = r14.length;
        int r12 = 0;
    L15:
        if (r12 >= r13) goto L22;
        f06.a r16 = r14[r12];
        int r23 = r12;
        int r24 = r13;
        f06.a[] r25 = r14;
        f06.b r26 = r15;
        f06.d r17 = r16.preInvoke(102607, "android/content/Context", "checkPermission", r27, r9, "int", r26);     // Catch: Exception -> L32
        if (r17.a == true) goto L24;
        r8.add(r16);     // Catch: Exception -> L32
    L24:
        if (r17.a == false) goto L26;
        int r19 = ((Integer) r17.b).intValue();
    L27:
        if (r19 != 0) goto L29;
    L30:
        r0.put(r5, Boolean.valueOf(r18));
        r4 = r4 + 1;
        goto L5
    L26:
        r19 = r27.checkPermission(r5, r6, r7);
    L21:
        r12 = r23 + 1;
        r13 = r24;
        r14 = r25;
        r15 = r26;
        goto L15
    L22:
        r17 = new f06.d(false, null);
        goto L24
    L12:
        r11 = ApiHookConfig.d;
    L29:
        r18 = false;
    L31:
        return r0;
    }
}
