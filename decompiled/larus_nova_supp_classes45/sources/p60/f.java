package p60;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends a {
    @Override // p60.a, p60.c
    public final boolean b() {
        if (Build.VERSION.SDK_INT == 23) goto L5;
        return false;
    L5:
        if (LiveInfraSettingKeys.LIVE_ENABLE_BY_CHECKER.getValue().booleanValue() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public f() {
    }

    @Override // p60.a, p60.c
    public final Intent a(Context r5) {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.PermissionManagerActivity"));
        r0.putExtra("pkg_name", r5.getPackageName());
        ApplicationInfo r1 = r5.getApplicationInfo();
        int r2 = r1.labelRes;
        if (r2 == 0) goto L5;
        String r6 = r5.getString(r2);
    L9:
        r0.putExtra("app_name", r6);
        r0.putExtra("class_name", f.class.getSimpleName());
        return r0;
    L5:
        CharSequence r3 = r1.nonLocalizedLabel;
        if (r3 == null) goto L8;
        r6 = r3.toString();
        goto L9
    L8:
        r6 = String.valueOf(r5.getPackageManager().getApplicationLabel(r1));
        goto L9
    }
}
