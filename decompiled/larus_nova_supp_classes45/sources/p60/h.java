package p60;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h extends a {
    @Override // p60.a, p60.c
    public final boolean b() {
        return false;
    }

    public h() {
    }

    @Override // p60.a, p60.c
    public final Intent a(Context r5) {
        Intent r0 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        r0.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
        r0.putExtra("extra_pkgname", r5.getPackageName());
        return r0;
    }
}
