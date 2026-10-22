package p60;

import android.content.Context;
import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a implements c {
    public a() {
    }

    @Override // p60.c
    public boolean b() {
        return false;
    }

    @Override // p60.c
    public Intent a(Context r3) {
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", UriProtector.parse("package:" + r3.getPackageName()));
    }
}
