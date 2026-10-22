package xia;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    static {
    }

    public static boolean a(Context r3, ComponentName r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "componentName");
        PackageManager r5 = r3.getPackageManager();
        boolean r0 = !r5.getApplicationInfo(r4.getPackageName(), 0).enabled;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        int r1 = r5.getComponentEnabledSetting(r4);
        if (r1 == 0) goto L23;
        if (r1 != 1) goto L20;
        return true;
    L23:
        boolean r6 = r5.getActivityInfo(r4, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L14 Exception -> L22
    L13:
        return r6;
    L14:
        r6 = r5.getServiceInfo(r4, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L16 Exception -> L22
    L16:
        r6 = r5.getReceiverInfo(r4, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L18 Exception -> L22
    L18:
        r6 = r5.getProviderInfo(r4, 0).enabled;     // Catch: Exception -> L22
    L20:
        return false;
    L5:
        r0 = true;
        goto L6
    }
}
