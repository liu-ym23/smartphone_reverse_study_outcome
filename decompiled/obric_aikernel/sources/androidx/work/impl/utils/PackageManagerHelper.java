package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.work.Logger;

/* JADX INFO: loaded from: classes.dex */
public class PackageManagerHelper {
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("PackageManagerHelper");
    }

    private PackageManagerHelper() {
    }

    public static boolean isComponentExplicitlyEnabled(@NonNull Context r10, @NonNull Class<?> r11) {
        return isComponentExplicitlyEnabled(r10, r11.getName());
    }

    public static boolean isComponentExplicitlyEnabled(@NonNull Context r10, @NonNull String r11) {
        if (r10.getPackageManager().getComponentEnabledSetting(new ComponentName(r10, r11)) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void setComponentEnabled(@NonNull Context r10, @NonNull Class<?> r11, boolean r12) {
        String r13 = "enabled";
        PackageManager r14 = r10.getPackageManager();     // Catch: Exception -> L13
        ComponentName r15 = new ComponentName(r10, r11.getName());     // Catch: Exception -> L13
        if (r12 == false) goto L6;
        int r16 = 1;
    L7:
        r14.setComponentEnabledSetting(r15, r16, 1);     // Catch: Exception -> L13
        Logger r17 = Logger.get();     // Catch: Exception -> L13
        String r18 = TAG;     // Catch: Exception -> L13
        StringBuilder r19 = new StringBuilder();     // Catch: Exception -> L13
        r19.append(r11.getName());     // Catch: Exception -> L13
        r19.append(" ");     // Catch: Exception -> L13
        if (r12 == false) goto L10;
        String r20 = "enabled";
    L11:
        r19.append(r20);     // Catch: Exception -> L13
        r17.debug(r18, r19.toString());     // Catch: Exception -> L13
        return;
    L10:
        r20 = "disabled";
        goto L11
    L6:
        r16 = 2;
    L13:
        e = move-exception;
        Logger r21 = Logger.get();
        String r22 = TAG;
        StringBuilder r23 = new StringBuilder();
        r23.append(r11.getName());
        r23.append("could not be ");
        if (r12 == true) goto L18;
        r13 = "disabled";
    L18:
        r23.append(r13);
        r21.debug(r22, r23.toString(), e);
    }
}
