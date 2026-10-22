package com.bytedance.awemeopen.infra.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l {
    static {
    }

    public static void b(Context r4) {
        Intrinsics.checkNotNullParameter("com.ss.android.ugc.aweme", "appPkg");
        Intrinsics.checkNotNullParameter(r4, "context");
    L11:
        e = move-exception;
        AoLogger.c("PackageUtils", new Object[]{e.getMessage()});
        return;
    L4:
        if (TextUtils.isEmpty("com.ss.android.ugc.aweme") == false) goto L6;
        return;
    L6:
        Intent r2 = new Intent("android.intent.action.VIEW", UriProtector.parse("market://details?id=com.ss.android.ugc.aweme"));     // Catch: Exception -> L11
        if (TextUtils.isEmpty("") == true) goto L9;
        r2.setPackage("");     // Catch: Exception -> L11
    L9:
        r2.addFlags(268435456);     // Catch: Exception -> L11
        r4.startActivity(r2);     // Catch: Exception -> L11
    }

    public static boolean a(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "pkgname");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r3.getPackageManager().getPackageInfo(r2, 0) != null) goto L13;
        return false;
    L13:
        return true;
    L8:
        e = move-exception;
        AoLogger.c("PackageUtils", new Object[]{e.getMessage()});
        return false;
    }
}
