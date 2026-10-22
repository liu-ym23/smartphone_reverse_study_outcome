package h30;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.browser.jsbridge.permissions.JSBOpenSettingFragment;
import com.bytedance.android.live.browser.jsbridge.permissions.JSBPermissionFragment;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static boolean a = true;
    public static boolean b = true;

    public static void a(final Activity r4, final a r5, final String[] r6) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isFinishing() == true) goto L31;
        JSBOpenSettingFragment r2 = null;
        if (r4.isFinishing() == true) goto L16;
        FragmentManager r1 = r4.getFragmentManager();     // Catch: Exception -> L19
        if (r1 == null) goto L16;
        r2 = (JSBOpenSettingFragment) r1.findFragmentByTag("JSBOpenSettingFragment");     // Catch: Exception -> L19
        if (r2 != null) goto L16;
        r2 = new JSBOpenSettingFragment();     // Catch: Exception -> L19
        r1.beginTransaction().add(r2, "JSBOpenSettingFragment").commitAllowingStateLoss();     // Catch: Exception -> L19
        r1.executePendingTransactions();     // Catch: Exception -> L19
    L16:
        if (r2 == null) goto L30;
        r2.d(r5, r6);     // Catch: Exception -> L19
        return;
    L30:
        return;
    L19:
        e = move-exception;
        if ((e instanceof IllegalStateException) == true) goto L23;
    L25:
        ALogger.e("JSBOpenSettingFragment", e.toString());
        return;
    L23:
        if (b == false) goto L25;
        new Handler(Looper.getMainLooper()).post(new c(r4, r5, r6));
        b = false;
        ALogger.e("JSBOpenSettingFragment", "try request in handler post");
        goto L25
    }

    public static void b(final Activity r4, final a r5, final String[] r6) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isFinishing() == true) goto L31;
        JSBPermissionFragment r2 = null;
        if (r4.isFinishing() == true) goto L16;
        FragmentManager r1 = r4.getFragmentManager();     // Catch: Exception -> L19
        if (r1 == null) goto L16;
        r2 = (JSBPermissionFragment) r1.findFragmentByTag("JSBPermissionsRequestFragment");     // Catch: Exception -> L19
        if (r2 != null) goto L16;
        r2 = new JSBPermissionFragment();     // Catch: Exception -> L19
        r1.beginTransaction().add(r2, "JSBPermissionsRequestFragment").commitAllowingStateLoss();     // Catch: Exception -> L19
        r1.executePendingTransactions();     // Catch: Exception -> L19
    L16:
        if (r2 == null) goto L30;
        r2.requestPermissions(r5, r6);     // Catch: Exception -> L19
        return;
    L30:
        return;
    L19:
        e = move-exception;
        if ((e instanceof IllegalStateException) == true) goto L23;
    L25:
        ALogger.e("JSBPermissionsRequestFragment", e.toString());
        return;
    L23:
        if (a == false) goto L25;
        new Handler(Looper.getMainLooper()).post(new b(r4, r5, r6));
        a = false;
        ALogger.e("JSBPermissionsRequestFragment", "try request in handler post");
        goto L25
    }
}
