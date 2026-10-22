package com.larksuite.framework.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u {
    public static void a(Context r4) {
        Intent r0 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");     // Catch: Exception -> L4
        r0.addFlags(268435456);     // Catch: Exception -> L4
        r0.setData(Uri.fromParts("package", r4.getPackageName(), null));     // Catch: Exception -> L4
        r4.startActivity(r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("NavigationUtils", e.getMessage());
    }

    public static boolean startActivity(Context r2, Intent r3) {
        if (r2 == null) goto L14;
        if (r3 == null) goto L14;
    L12:
        e = move-exception;
        Log.e("NavigationUtils", e.getMessage());
        goto L14
    L7:
        if ((r2 instanceof Activity) == true) goto L9;
        r3.addFlags(268435456);     // Catch: Exception -> L12
    L9:
        r2.startActivity(r3);     // Catch: Exception -> L12
        return true;
    L14:
        return false;
    }

    public static boolean startActivity(Context r1, Class<? extends Activity> r2) {
        return startActivity(r1, r2, null);
    }

    public static boolean startActivity(Context r1, Class<? extends Activity> r2, Bundle r3) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L12;
        Intent r0 = new Intent();
        if (r3 == null) goto L8;
        r0.putExtras(r3);
    L8:
        r0.setClass(r1, r2);
        return startActivity(r1, r0);
    L12:
        return false;
    L10:
        return false;
    }

    public static boolean startActivityForResult(Activity r1, Intent r2, int r3) {
        if (r1 == null) goto L11;
        if (r2 == null) goto L11;
        r1.startActivityForResult(r2, r3);     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        Log.e("NavigationUtils", e.getMessage());
    L11:
        return false;
    }
}
