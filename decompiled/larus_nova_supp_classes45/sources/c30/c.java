package c30;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public c() {
    }

    static {
    }

    public static final void a(Context r7) {
        if (r7 == null) goto L35;
        boolean r2 = true;
        Intent r5 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", UriProtector.parse("package:" + r7.getPackageName()));     // Catch: Exception -> L15
        r5.addFlags(268435456);     // Catch: Exception -> L15
        List<ResolveInfo> r0 = r7.getPackageManager().queryIntentActivities(r5, 65536);     // Catch: Exception -> L15
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L16;
        r7.startActivity(r5);     // Catch: Exception -> L15
        boolean r3 = true;
    L17:
        if (r3 == true) goto L36;
        Intent r4 = new Intent("android.settings.APPLICATION_SETTINGS");     // Catch: Exception -> L29
        r4.addFlags(268435456);     // Catch: Exception -> L29
        List<ResolveInfo> r6 = r7.getPackageManager().queryIntentActivities(r4, 65536);     // Catch: Exception -> L29
        if (r6 != null) goto L22;
    L24:
        r2 = false;
    L25:
        if (r2 == false) goto L34;
        r7.startActivity(r4);     // Catch: Exception -> L29
        return;
    L34:
        return;
    L22:
        if (r6.size() <= 0) goto L24;
    L37:
        return;
    L36:
        return;
    L8:
        if (r0.size() <= 0) goto L10;
        r1 = true;
    L16:
        r3 = false;
        goto L17
    }

    public static boolean b(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return NotificationManagerCompat.from(r1).areNotificationsEnabled();
    L5:
        return false;
    }
}
