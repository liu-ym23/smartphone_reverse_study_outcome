package swb;

import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n {
    public static String a(Context r4) {
        String r0 = "";
        if (r4 == null) goto L17;
        String r5 = r4.getPackageManager().getPackageInfo(r4.getPackageName(), 0).versionName;     // Catch: Exception -> L13
        if (r5 != null) goto L18;
    L12:
        return "";
    L18:
        if (r5.length() <= 0) goto L12;
        r0 = r5;
    L10:
        Exception e = e;
    L15:
        com.ss.android.lark.officesdk.utils.di.j.c("VersionInfo", "Exception", e);
        return r5;
    L13:
        e = move-exception;
        e = e;
        r5 = "";
    L17:
        return r0;
    }
}
