package com.larus.dora.impl.util;

import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a() {
        if (AppHost.a.getApplication().getPackageManager().getPackageInfo("com.huawei.smartaudio", 0) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public static boolean b(String r6) {
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        g49.d.d("ExternalRoute", "open schema, schema: " + r6);
        Intent r3 = new Intent("android.intent.action.VIEW");
        r3.setData(UriProtector.parse(r6));
        r3.addFlags(335544320);
        AppHost.Companion r4 = AppHost.a;
        if (r3.resolveActivity(r4.getApplication().getPackageManager()) != null) goto L19;
        return false;
    L19:
        r4.getApplication().startActivity(r3);     // Catch: Exception -> L16
        return true;
    L16:
        e = move-exception;
        FLogger.a.e("ExternalRoute", "open schema failed, schema: " + r6 + ", e: " + e);
        return false;
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
