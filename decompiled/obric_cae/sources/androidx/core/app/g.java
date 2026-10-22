package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    public static class a {
        public static Intent a(Activity r8) {
            return r8.getParentActivityIntent();
        }

        public static boolean b(Activity r8, Intent r10) {
            return r8.navigateUpTo(r10);
        }

        public static boolean c(Activity r8, Intent r10) {
            return r8.shouldUpRecreateTask(r10);
        }
    }

    public static Intent a(Activity r8) {
        Intent r10 = a.a(r8);
        if (r10 == null) goto L20;
        return r10;
    L20:
        String r11 = b(r8, r8.getComponentName());     // Catch: PackageManager.NameNotFoundException -> L17
        if (r11 != null) goto L9;
        return null;
    L9:
        ComponentName r12 = new ComponentName(r8, r11);
    L15:
        Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + r11 + "' in manifest");
        return null;
    L11:
        if (b(r8, r12) != null) goto L14;
        return Intent.makeMainActivity(r12);
    L14:
        return new Intent().setComponent(r12);
    L17:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String b(Context r8, ComponentName r10) {
        ActivityInfo r11 = r8.getPackageManager().getActivityInfo(r10, 269222528);
        String r12 = r11.parentActivityName;
        if (r12 == null) goto L5;
        return r12;
    L5:
        Bundle r13 = r11.metaData;
        if (r13 != null) goto L8;
        return null;
    L8:
        String r14 = r13.getString("android.support.PARENT_ACTIVITY");
        if (r14 != null) goto L12;
        return null;
    L12:
        if (r14.charAt(0) == '.') goto L14;
        return r14;
    L14:
        return r8.getPackageName() + r14;
    }
}
