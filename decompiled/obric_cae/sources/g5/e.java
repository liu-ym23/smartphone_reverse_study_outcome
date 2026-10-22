package g5;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public final class e implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7648a = null;

    public static class a extends k5.l<Boolean> {
        @Override // k5.l
        public final Boolean a(Object[] r8) {
            boolean r10 = false;
            if (((Context) r8[0]).getPackageManager().getPackageInfo("com.huawei.hwid", 128) == null) goto L7;
            r10 = true;
        L7:
            return Boolean.valueOf(r10);
        }
    }

    public static class b extends m.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7649c;

        public b() {
            this.f7649c = 0;
        }
    }

    static {
        f7648a = new a();
    }

    @Override // g5.m
    public final m.a a(Context r8) {
        b r10 = new b();
        String r11 = Settings.Global.getString(r8.getContentResolver(), "pps_oaid");     // Catch: Throwable -> L7
        String r12 = Settings.Global.getString(r8.getContentResolver(), "pps_track_limit");     // Catch: Throwable -> L7
        if (TextUtils.isEmpty(r11) == true) goto L9;
        r10.f7667a = r11;     // Catch: Throwable -> L7
        r10.f7668b = Boolean.parseBoolean(r12);     // Catch: Throwable -> L7
        r10.f7649c = 202003021704L;     // Catch: Throwable -> L7
    L19:
        return r10;
    L9:
        Pair r13 = (Pair) new t(r8, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new f()).a();
        if (r13 == null) goto L19;
        r10.f7667a = (String) r13.first;
        r10.f7668b = ((Boolean) r13.second).booleanValue();
        int r14 = 0;
        PackageInfo r15 = r8.getPackageManager().getPackageInfo("com.huawei.hwid", 0);     // Catch: PackageManager.NameNotFoundException -> L16
        if (r15 == null) goto L18;
        r14 = r15.versionCode;     // Catch: PackageManager.NameNotFoundException -> L16
    L18:
        r10.f7649c = r14;
    L16:
        e = move-exception;
        e.printStackTrace();
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    @Override // g5.m
    public final boolean b(Context r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        return f7648a.b(new Object[]{r8}).booleanValue();
    }

    @Override // g5.m
    public final String getName() {
        return "Huawei";
    }
}
