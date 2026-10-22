package rx1;

import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import com.bytedance.android.live.core.utils.SystemPropertiesUtil;
import com.bytedance.android.livesdk.z;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m {
    public static final String a = null;

    static {
        a = m.class.getCanonicalName();
    }

    public static String c() {
        return jc1.a.b().getPackageName();
    }

    public m() {
    }

    public static boolean a(Context r9) {
        String r0 = Build.MANUFACTURER;
        r0.getClass();
        if (r0.equals("Xiaomi") == false) goto L15;
        AppOpsManager r1 = (AppOpsManager) r9.getSystemService("appops");     // Catch: Exception -> L9
        Class<?> r2 = r1.getClass();     // Catch: Exception -> L9
        Class<?> r6 = Integer.TYPE;     // Catch: Exception -> L9
        if (((Integer) r2.getMethod("checkOpNoThrow", new Class[]{r6, r6, String.class}).invoke(r1, new Object[]{10021, Integer.valueOf(Process.myUid()), r9.getPackageName()})).intValue() == 0) goto L16;
        return false;
    L16:
        return true;
    L9:
        e = move-exception;
        Logger.e(a, "not support", e);
        return true;
    L15:
        return true;
    }

    public static void d(Context r1) {
        j(r1, "android.settings.APPLICATION_DETAILS_SETTINGS");
    }

    public static boolean e(Context r9) {
        if (r9 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L17;
        AppOpsManager r1 = (AppOpsManager) r9.getSystemService("appops");     // Catch: Exception -> L14
        Class r6 = Integer.TYPE;     // Catch: Exception -> L14
        if (((Integer) AppOpsManager.class.getMethod("checkOp", new Class[]{r6, r6, String.class}).invoke(r1, new Object[]{24, Integer.valueOf(Binder.getCallingUid()), r9.getApplicationContext().getPackageName()})).intValue() != 0) goto L19;
        return true;
    L19:
        return false;
    L20:
        return false;
    L17:
        return Settings.canDrawOverlays(r9);
    L9:
        return false;
    }

    public static boolean f(Context r4) {
        if (Build.VERSION.SDK_INT < 26) goto L11;
        if (((AppOpsManager) r4.getSystemService("appops")).checkOpNoThrow("android:picture_in_picture", Binder.getCallingUid(), r4.getApplicationContext().getPackageName()) != 0) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    L11:
        return false;
    }

    public static void h(Context r2) {
        if (((Boolean) z.a.getValue()).booleanValue() == false) goto L6;
        com.ss.android.ugc.route_monitor.impl.route_out.control.i.a("91101186");
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L9;
        j(r2, "android.settings.action.MANAGE_OVERLAY_PERMISSION");
        return;
    L9:
        i(r2);
    }

    public static void i(Context r6) {
        String r0 = Build.MANUFACTURER;
        Logger.e(m.class.getCanonicalName(), "jumpPermissionPage --- name : " + r0);
        r0.getClass();
        switch(r0.hashCode()) {
            case -1678088054: goto L38;
            case -1675632421: goto L34;
            case 2427: goto L30;
            case 2432928: goto L26;
            case 2582855: goto L22;
            case 3620012: goto L18;
            case 74224812: goto L14;
            case 1864941562: goto L10;
            case 2141820391: goto L6;
            default: goto L41;
        };
    L41:
        byte r1 = -1;
    L42:
        String r2 = a;
        switch(r1) {
            case 0: goto L95;
            case 1: goto L74;
            case 2: goto L101;
            case 3: goto L67;
            case 4: goto L107;
            case 5: goto L59;
            case 6: goto L98;
            case 7: goto L51;
            case 8: goto L104;
            default: goto L44;
        };
    L44:
        d(r6);
        return;
    L51:
        d(r6);
        return;
    L59:
        b("com.bairenkeji.icaller", r6);
        return;
    L67:
        b("com.coloros.safecenter", r6);
        return;
    L74:
        String r3 = SystemPropertiesUtil.getProp("ro.miui.ui.version.name");
        Logger.e(r2, "goMiaoMiMainager --- rom : " + r3);
        Intent r4 = new Intent();
        if ("V6".equals(r3) == false) goto L77;
    L91:
        r4.setAction("miui.intent.action.APP_PERM_EDITOR");
        r4.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        r4.putExtra("extra_pkgname", c());
    L93:
        if (g(r6, r4) == false) goto L123;
        n.a(r4);
        r6.startActivity(r4);
        return;
    L123:
        return;
    L77:
        if ("V7".equals(r3) == true) goto L91;
        if ("V8".equals(r3) == false) goto L82;
    L90:
        r4.setAction("miui.intent.action.APP_PERM_EDITOR");
        r4.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        r4.putExtra("extra_pkgname", c());
        goto L93
    L82:
        if ("V9".equals(r3) == true) goto L90;
        if ("V10".equals(r3) == true) goto L90;
        if ("V11".equals(r3) == false) goto L89;
        j(r6, "android.settings.action.MANAGE_OVERLAY_PERMISSION");
        return;
    L89:
        d(r6);
        return;
    L95:
        b("com.yulong.android.security:remote", r6);
        return;
    L98:
        Intent r5 = new Intent("com.meizu.safe.security.SHOW_APPSEC");     // Catch: ActivityNotFoundException -> L57
        r5.addCategory("android.intent.category.DEFAULT");     // Catch: ActivityNotFoundException -> L57
        r5.putExtra("packageName", c());     // Catch: ActivityNotFoundException -> L57
        if (g(r6, r5) == false) goto L55;
        n.a(r5);     // Catch: ActivityNotFoundException -> L57
        r6.startActivity(r5);     // Catch: ActivityNotFoundException -> L57
    L97:
        return;
    L55:
        d(r6);     // Catch: ActivityNotFoundException -> L57
    L57:
        e = move-exception;
        Logger.e(e.getMessage());
        d(r6);
        return;
    L101:
        Intent r7 = new Intent(c());     // Catch: Exception -> L73
        r7.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));     // Catch: Exception -> L73
        if (g(r6, r7) == false) goto L71;
        n.a(r7);     // Catch: Exception -> L73
        r6.startActivity(r7);     // Catch: Exception -> L73
    L100:
        return;
    L71:
        d(r6);     // Catch: Exception -> L73
    L73:
        d(r6);
        return;
    L104:
        Intent r8 = new Intent(c());     // Catch: Exception -> L50
        r8.setFlags(268435456);     // Catch: Exception -> L50
        r8.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));     // Catch: Exception -> L50
        if (g(r6, r8) == false) goto L48;
        n.a(r8);     // Catch: Exception -> L50
        r6.startActivity(r8);     // Catch: Exception -> L50
    L103:
        return;
    L48:
        d(r6);     // Catch: Exception -> L50
    L50:
        d(r6);
        return;
    L107:
        Intent r9 = new Intent(c());     // Catch: Exception -> L65
        r9.setComponent(new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));     // Catch: Exception -> L65
        if (g(r6, r9) == false) goto L63;
        n.a(r9);     // Catch: Exception -> L65
        r6.startActivity(r9);     // Catch: Exception -> L65
    L106:
        return;
    L63:
        d(r6);     // Catch: Exception -> L65
    L65:
        e = move-exception;
        Logger.e(r2, "goSonyMainager: ", e);
        d(r6);
        return;
    L6:
        if (r0.equals("HUAWEI") == false) goto L41;
        r1 = 8;
        goto L42
    L10:
        if (r0.equals("samsung") == false) goto L41;
        r1 = 7;
        goto L42
    L14:
        if (r0.equals("Meizu") == false) goto L41;
        r1 = 6;
        goto L42
    L18:
        if (r0.equals("vivo") == false) goto L41;
        r1 = 5;
        goto L42
    L22:
        if (r0.equals("Sony") == false) goto L41;
        r1 = 4;
        goto L42
    L26:
        if (r0.equals("OPPO") == false) goto L41;
        r1 = 3;
        goto L42
    L30:
        if (r0.equals("LG") == false) goto L41;
        r1 = 2;
        goto L42
    L34:
        if (r0.equals("Xiaomi") == false) goto L41;
        r1 = 1;
        goto L42
    L38:
        if (r0.equals("Coolpad") == false) goto L41;
        r1 = 0;
        goto L42
    }

    public static void b(String r8, Context r9) {
        String r1 = a;
        int r2 = 0;
        PackageInfo r10 = r9.getPackageManager().getPackageInfo(r8, 0);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r10 != null) goto L10;
        d(r9);
        return;
    L10:
        Intent r4 = new Intent("android.intent.action.MAIN", null);
        r4.addCategory("android.intent.category.LAUNCHER");
        r4.setPackage(r10.packageName);
        List<ResolveInfo> r11 = r9.getPackageManager().queryIntentActivities(r4, 0);
        Logger.e("PermissionPageManager", "resolveinfoList" + r11.size());
    L12:
        if (r2 >= r11.size()) goto L23;
        Logger.e("PermissionPageManager", ((ResolveInfo) ListProtector.get(r11, r2)).activityInfo.packageName + ((ResolveInfo) ListProtector.get(r11, r2)).activityInfo.name);
        r2 = r2 + 1;
        goto L12
    L23:
        ResolveInfo r12 = r11.iterator().next();     // Catch: Exception -> L18
        if (r12 == null) goto L25;
        ActivityInfo r13 = r12.activityInfo;     // Catch: Exception -> L18
        String r3 = r13.packageName;     // Catch: Exception -> L18
        String r14 = r13.name;     // Catch: Exception -> L18
        Intent r5 = new Intent("android.intent.action.MAIN");     // Catch: Exception -> L18
        r5.addCategory("android.intent.category.LAUNCHER");     // Catch: Exception -> L18
        r5.setComponent(new ComponentName(r3, r14));     // Catch: Exception -> L18
        n.a(r5);     // Catch: Exception -> L18
        r9.startActivity(r5);     // Catch: Exception -> L18
        return;
    L25:
        return;
    L18:
        e = move-exception;
        d(r9);
        Logger.e(r1, "doStartApplicationWithPackageName: ", e);
        return;
    L5:
        e = move-exception;
        Logger.e(r1, "doStartApplicationWithPackageName: ", e);
        r10 = null;
        goto L7
    }

    public static boolean g(Context r1, Intent r2) {
        if (r1 != null) goto L11;
    L10:
        return false;
    L11:
        if (r1.getPackageManager().resolveActivity(r2, 0) == null) goto L13;
        return true;
    L13:
        return false;
    L8:
        e = move-exception;
        Logger.e(e.getMessage());
        goto L10
    }

    public static void j(Context r3, String r4) {
        Intent r0 = new Intent(r4);
        r0.setData(Uri.fromParts("package", r3.getPackageName(), null));
    L7:
        e = move-exception;
        Logger.e(e.getMessage());
        return;
    L4:
        if (g(r3, r0) == false) goto L12;
        r3.startActivity(r0);     // Catch: Exception -> L7
        n.a(r0);     // Catch: Exception -> L7
        return;
    }
}
