package qz8;

import androidx.appcompat.app.AppCompatDelegate;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final String a(String r2, String r3) {
        int r0 = AppCompatDelegate.getDefaultNightMode();
        if (r0 == 2) goto L9;
        boolean r1 = v19.h.a;
        if (v19.h.b(AppHost.a.getApplication().getApplicationContext()) == true) goto L7;
        return r2;
    L7:
        if (r0 == (-1)) goto L9;
        return r2;
    L9:
        return r3;
    }
}
