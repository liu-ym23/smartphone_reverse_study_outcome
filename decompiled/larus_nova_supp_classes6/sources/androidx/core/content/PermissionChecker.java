package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.util.ObjectsCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class PermissionChecker {
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED = 0;

    private PermissionChecker() {
    }

    public static int checkCallingOrSelfPermission(Context r3, String r4) {
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
        String r0 = r3.getPackageName();
    L7:
        return checkPermission(r3, r4, Binder.getCallingPid(), Binder.getCallingUid(), r0);
    L5:
        r0 = null;
        goto L7
    }

    public static int checkSelfPermission(Context r3, String r4) {
        return checkPermission(r3, r4, Process.myPid(), Process.myUid(), r3.getPackageName());
    }

    public static int checkCallingPermission(Context r2, String r3, String r4) {
        if (Binder.getCallingPid() != Process.myPid()) goto L7;
        return -1;
    L7:
        return checkPermission(r2, r3, Binder.getCallingPid(), Binder.getCallingUid(), r4);
    }

    private static int androidx_core_content_PermissionChecker_android_content_Context_checkPermission(Context r18, String r19, int r20, int r21) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, Integer.valueOf(r20), Integer.valueOf(r21)};
        b r11 = new b("auto_cert_androidx_core_content_PermissionChecker_android_content_Context_checkPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102607);
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

    public static int checkPermission(Context r2, String r3, int r4, int r5, String r6) {
        if (androidx_core_content_PermissionChecker_android_content_Context_checkPermission(r2, r3, r4, r5) != (-1)) goto L5;
        return -1;
    L5:
        String r7 = AppOpsManagerCompat.permissionToOp(r3);
        if (r7 != null) goto L8;
        return 0;
    L8:
        if (r6 != null) goto L16;
        String[] r8 = r2.getPackageManager().getPackagesForUid(r5);
        if (r8 != null) goto L12;
    L15:
        return -1;
    L12:
        if (r8.length <= 0) goto L15;
        r6 = r8[0];
    L16:
        int r0 = Process.myUid();
        String r1 = r2.getPackageName();
        if (r0 == r5) goto L19;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == false) goto L24;
        int r10 = AppOpsManagerCompat.checkOrNoteProxyOp(r2, r5, r7, r6);
    L25:
        if (r10 == 0) goto L29;
        return -2;
    L29:
        return 0;
    L24:
        r10 = AppOpsManagerCompat.noteProxyOpNoThrow(r2, r7, r6);
        goto L25
    L19:
        if (ObjectsCompat.equals(r1, r6) == false) goto L21;
        r9 = true;
        goto L22
    }
}
