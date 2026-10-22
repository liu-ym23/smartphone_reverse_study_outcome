package p60;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends a {
    @Override // p60.a, p60.c
    public final boolean b() {
        return false;
    }

    public b() {
    }

    @Override // p60.a, p60.c
    public final Intent a(Context r4) {
        Intent r0 = new Intent();
        r0.putExtra("packageName", r4.getPackageName());
        r0.setComponent(new ComponentName("com.android.packageinstaller", "com.android.packageinstaller.permission.ui.ManagePermissionsActivity"));
        return r0;
    }
}
