package d5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;
import x4.j0;

/* JADX INFO: loaded from: classes.dex */
public final class u extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f6827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0 f6828f;

    public u(Context r8, j0 r10) {
        super(false, false);
        this.f6827e = r8;
        this.f6828f = r10;
    }

    @Override // d5.d
    public final boolean a(JSONObject r13) {
        Context r8 = this.f6827e;
        String r10 = r8.getPackageName();
        j0 r12 = this.f6828f;
        String r11 = r12.f13467e;
        String r14 = r12.f13470h;
        String r15 = r12.f13468f;
        x4.g r16 = r12.f13476n;
        if (TextUtils.isEmpty(r11) == false) goto L5;
        r13.put("package", r10);
    L36:
        r13.put("app_version", r12.c());     // Catch: Throwable -> L32
        r13.put("app_version_minor", r16.f13420b);     // Catch: Throwable -> L32
        r13.put("version_code", r12.d());     // Catch: Throwable -> L32
        long r17 = r16.f13422d;     // Catch: Throwable -> L32
        if (r17 != 0) goto L12;
        PackageInfo r18 = r16.f13425g.b(new Object[0]);     // Catch: Throwable -> L32
        if (r18 == null) goto L12;
        r17 = r18.versionCode;     // Catch: Throwable -> L32
    L12:
        r13.put("update_version_code", r17);     // Catch: Throwable -> L32
        long r19 = r16.f13423e;     // Catch: Throwable -> L32
        if (r19 != 0) goto L17;
        PackageInfo r20 = r16.f13425g.b(new Object[0]);     // Catch: Throwable -> L32
        if (r20 == null) goto L17;
        r19 = r20.versionCode;     // Catch: Throwable -> L32
    L17:
        r13.put("manifest_version_code", r19);     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r15) == true) goto L21;
        r13.put("app_name", r15);     // Catch: Throwable -> L32
    L21:
        if (TextUtils.isEmpty(r14) == true) goto L34;
        r13.put("tweaked_channel", r14);     // Catch: Throwable -> L32
    L34:
        ApplicationInfo r110 = r8.getPackageManager().getPackageInfo(r10, 0).applicationInfo;     // Catch: Throwable -> L29
        if (r110 == null) goto L38;
        int r111 = r110.labelRes;     // Catch: Throwable -> L29
        if (r111 <= 0) goto L39;
        r13.put("display_name", r8.getString(r111));     // Catch: Throwable -> L29
    L40:
        return true;
    L39:
        return true;
    L38:
        return true;
    L29:
        int r112 = x4.r.f13543a;     // Catch: Throwable -> L32
        return true;
    L32:
        int r113 = x4.r.f13543a;
        return false;
    L5:
        int r21 = x4.r.f13543a;
        r13.put("package", r12.f13467e);
        r13.put("real_package_name", r10);
        goto L36
    }
}
