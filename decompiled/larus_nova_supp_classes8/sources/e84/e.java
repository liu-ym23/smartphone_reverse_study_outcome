package e84;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements m {
    public static final a a = null;

    public static class a extends i84.r<Boolean> {
        public a() {
        }

        public final Object a(Object[] r4) {
            boolean r0 = false;
            if (((Context) r4[0]).getPackageManager().getPackageInfo("com.huawei.hwid", 128) == null) goto L7;
            r0 = true;
        L7:
            return Boolean.valueOf(r0);
        }
    }

    public static class b extends m$a {
        public long c;

        public b() {
            this.c = 0;
        }
    }

    public final String getName() {
        return "Huawei";
    }

    static {
        a = new a();
    }

    public e() {
    }

    public final boolean a(Context r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        return ((Boolean) a.b(new Object[]{r4})).booleanValue();
    }

    public final m$a getOaid(Context r6) {
        b r0 = new b();
        if (Build.VERSION.SDK_INT >= 24) goto L23;
    L10:
        Pair r1 = (Pair) new u(r6, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new f()).a();
        if (r1 == null) goto L20;
        r0.a = (String) r1.first;
        r0.b = ((Boolean) r1.second).booleanValue();
        int r2 = 0;
        PackageInfo r7 = r6.getPackageManager().getPackageInfo("com.huawei.hwid", 0);     // Catch: PackageManager.NameNotFoundException -> L17
        if (r7 == null) goto L19;
        r2 = r7.versionCode;     // Catch: PackageManager.NameNotFoundException -> L17
    L19:
        r0.c = r2;
    L17:
        e = move-exception;
        e.printStackTrace();
    L20:
        return r0;
    L23:
        String r3 = Settings.Global.getString(r6.getContentResolver(), "pps_oaid");     // Catch: Throwable -> L8
        String r4 = Settings.Global.getString(r6.getContentResolver(), "pps_track_limit");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r3) == true) goto L10;
        r0.a = r3;     // Catch: Throwable -> L8
        r0.b = Boolean.parseBoolean(r4);     // Catch: Throwable -> L8
        r0.c = 202003021704L;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }
}
