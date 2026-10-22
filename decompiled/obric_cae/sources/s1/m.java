package s1;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11987a = null;

    static {
        f11987a = androidx.work.m.f("PackageManagerHelper");
    }

    public static void a(Context r8, Class<?> r10, boolean r11) {
        String r12 = "enabled";
        String r13 = f11987a;
        PackageManager r14 = r8.getPackageManager();     // Catch: Exception -> L13
        ComponentName r15 = new ComponentName(r8, r10.getName());     // Catch: Exception -> L13
        if (r11 == false) goto L6;
        int r16 = 1;
    L7:
        r14.setComponentEnabledSetting(r15, r16, 1);     // Catch: Exception -> L13
        androidx.work.m r17 = androidx.work.m.d();     // Catch: Exception -> L13
        StringBuilder r18 = new StringBuilder();     // Catch: Exception -> L13
        r18.append(r10.getName());     // Catch: Exception -> L13
        r18.append(" ");     // Catch: Exception -> L13
        if (r11 == false) goto L10;
        String r19 = "enabled";
    L11:
        r18.append(r19);     // Catch: Exception -> L13
        r17.a(r13, r18.toString());     // Catch: Exception -> L13
        return;
    L10:
        r19 = "disabled";
        goto L11
    L6:
        r16 = 2;
    L13:
        e = move-exception;
        androidx.work.m r20 = androidx.work.m.d();
        StringBuilder r21 = new StringBuilder();
        r21.append(r10.getName());
        r21.append("could not be ");
        if (r11 == true) goto L18;
        r12 = "disabled";
    L18:
        r21.append(r12);
        String r22 = r21.toString();
        if (((androidx.work.m.a) r20).f2930c > 3) goto L24;
        Log.d(r13, r22, e);
        return;
    }
}
