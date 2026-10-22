package uc8;

import android.app.Application;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static boolean a() {
        Application r0 = AppHost.a.getApplication();
        if (Build.VERSION.SDK_INT < 33) goto L9;
        if (ContextCompat.checkSelfPermission(r0, "android.permission.POST_NOTIFICATIONS") != 0) goto L7;
        return true;
    L7:
        return false;
    L9:
        return NotificationManagerCompat.from(r0).areNotificationsEnabled();
    }
}
