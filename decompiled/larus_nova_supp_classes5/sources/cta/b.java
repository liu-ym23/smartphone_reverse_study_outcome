package cta;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.router.CJPayRouterAPI;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.caijing.cjpay.env.permission.PermissionHandlerActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public final List<a> a;
    public boolean b;

    public b() {
        this.a = new ArrayList();
    }

    public static boolean c(Context r2) {
        if (Build.VERSION.SDK_INT < 33) goto L8;
        if (r2 == null) goto L8;
        if (r2.getApplicationInfo().targetSdkVersion < 33) goto L8;
        return true;
    L8:
        return false;
    }

    public static a a(Context r10, a r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        String[] r1 = r11.b;
        int r2 = r1.length;
        if (r2 == 1) goto L8;
        ArrayList r4 = new ArrayList(r2);
        ArrayList r5 = new ArrayList(r2);
        int r6 = 0;
    L13:
        if (r6 >= r2) goto L22;
        String r7 = r1[r6];
        if (b(r10, r7) == false) goto L19;
        Map r8 = r11.d;
        if (r8 == null) goto L20;
        ((HashMap) r8).put(r7, 0);
    L20:
        r6 = r6 + 1;
        goto L13
    L19:
        r4.add(r7);
        r5.add(r11.c[r6]);
        goto L20
    L22:
        if (r4.size() != 0) goto L25;
        r11.b();
        return null;
    L25:
        r11.b = (String[]) r4.toArray(new String[r4.size()]);
        r11.c = (String[]) r5.toArray(new String[r5.size()]);
        return r11;
    L8:
        if (b(r10, r1[0]) == false) goto L11;
        r11.b();
        return null;
    L11:
        return r11;
    }

    public static boolean b(Context r9, String r10) {
        boolean r2 = false;
        if (TextUtils.isEmpty(r10) == true) goto L33;
        if (r9 == null) goto L33;
        int r4 = ContextCompat.checkSelfPermission(r9, r10);     // Catch: Exception -> L9
    L14:
        CJLogger.d("PermissionCheckHelper", r10 + " " + r4);
        boolean r5 = true;
        if (r4 != 0) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == true) goto L20;
    L31:
        CJLogger.d("PermissionCheckHelper", "final:" + r10 + " " + r6);
        return r6;
    L20:
        if (Build.VERSION.SDK_INT >= 23) goto L35;
    L30:
        r6 = r5;
        goto L31
    L35:
        AppOpsManager r1 = (AppOpsManager) r9.getSystemService("appops");     // Catch: Exception -> L28
        String r7 = AppOpsManager.permissionToOp(r10);     // Catch: Exception -> L28
        if (r7 == null) goto L30;
        int r11 = r1.checkOpNoThrow(r7, Process.myUid(), r9.getPackageName());     // Catch: Exception -> L28
        CJLogger.d("PermissionCheckHelper", "checkOps:" + r7 + " " + r10 + " " + r11);     // Catch: Exception -> L28
        if (r11 != 0) goto L27;
        r2 = true;
    L27:
        r5 = r2;
    L28:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PermissionCheckHelper#checkOps", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PermissionCheckHelper#checkOps", e);
        goto L30
    L17:
        r6 = false;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PermissionCheckHelper#isGranted", e);
        CJBasicCommonUtils.logCatch("CJCatch", "PermissionCheckHelper#isGranted", e);
        if (Build.VERSION.SDK_INT < 23) goto L13;
        r4 = -1;
        goto L14
    L13:
        r4 = 0;
    L33:
        CJLogger.a("PermissionCheckHelper", "runtime permission check params error");
        return false;
    }

    public void requestPermissions(Context r2, a r3, boolean r4) {
        if (r2 == null) goto L20;
        if (r3 == null) goto L20;
        a r5 = a(r2, r3);
        if (r5 == null) goto L19;
        monitor-enter(this);
        ((ArrayList) this.a).add(r5);     // Catch: Throwable -> L16
        if (this.b == false) goto L22;
    L14:
        monitor-exit(this);
        return;
    L22:
        CJPayRouterAPI.getInstance().build(PermissionHandlerActivity.class).withSerializable("is_immersive", Boolean.valueOf(r4)).addFlags(603979776).setPackage(r2.getPackageName()).navigation(r2);     // Catch: Exception -> L12 Throwable -> L16
        this.b = true;     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("PermissionCheckHelper#enqueueRequestPermission", e);     // Catch: Throwable -> L16
        CJLogger.a("PermissionCheckHelper", "permission handle activity start failed!");     // Catch: Throwable -> L16
        this.b = false;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L19:
        return;
    L20:
        CJLogger.a("PermissionCheckHelper", "runtime permission request params error");
    }

    public void requestPermissions(Context r2, String[] r3, a r4) {
        requestPermissions(r2, r3, r4, false);
    }

    public void requestPermissions(Context r9, String[] r10, a r11, boolean r12) {
        if (r9 == null) goto L9;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.length == 0) goto L11;
        String[] r5 = new String[r10.length];
        Arrays.fill(r5, "");
        requestPermissions(r9, 1, r10, r5, r11, r12);
        return;
    L11:
        return;
    }

    public void requestPermissions(Context r8, int r9, String[] r10, String[] r11, a r12) {
        requestPermissions(r8, r9, r10, r11, r12, false);
    }

    public void requestPermissions(Context r3, int r4, String[] r5, String[] r6, a r7, boolean r8) {
        if (r7 == null) goto L28;
        if (r5 == null) goto L28;
        if (r5.length == 0) goto L28;
        if (r6 == null) goto L28;
        if (r5.length != r6.length) goto L28;
        a r9 = new a(r7, r5, r6);
        if (r5.length == 0) goto L18;
        int r10 = r5.length;
        boolean r11 = false;
        int r0 = 0;
    L13:
        if (r0 >= r10) goto L18;
        if (b(r3, r5[r0]) == false) goto L19;
        r0 = r0 + 1;
    L19:
        if (r11 == false) goto L21;
    L25:
        r9.b();
        return;
    L21:
        if (Build.VERSION.SDK_INT < 23) goto L25;
        requestPermissions(r3, r9, r8);
        return;
    L18:
        r11 = true;
    L28:
        throw new IllegalArgumentException("permission request build failed: params error");
    }
}
