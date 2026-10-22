package e5;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.bytedance.bdinstall.migrate.MigrateDetectorActivity;
import x4.j0;
import x4.r;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f7119e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PackageManager f7120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ComponentName f7121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f7122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f7123d;

    public a(Context r8, j0 r10) {
        Context r11 = r8.getApplicationContext();
        SharedPreferences r12 = k5.a.a(r8, r10);
        this.f7123d = r12;
        PackageManager r13 = r11.getPackageManager();
        this.f7120a = r13;
        ComponentName r14 = new ComponentName(r8, MigrateDetectorActivity.class);
        this.f7121b = r14;
        int r15 = f7119e;
        boolean r16 = false;
        if (r15 == (-1)) goto L13;
    L5:
        int r17 = r12.getInt("component_state", 0);
        int r18 = r.f13543a;
        if (r15 == 0) goto L8;
    L10:
        this.f7122c = r16;
        int r19 = r.f13543a;
        return;
    L8:
        if (r17 != 2) goto L10;
        r16 = true;
        goto L10
    L13:
        r15 = r13.getComponentEnabledSetting(r14);     // Catch: Exception -> L12
        f7119e = r15;     // Catch: Exception -> L12
        goto L5
    }

    public static void a(Context r8, j0 r10, String r11, boolean r12) {
        SharedPreferences.Editor r13 = k5.a.a(r8, r10).edit();
        r13.putString("old_did", r11);
        if (r12 == false) goto L5;
        r13.putBoolean("is_migrate", true);
    L6:
        r13.apply();
        return;
    L5:
        r13.remove("is_migrate");
        goto L6
    }
}
