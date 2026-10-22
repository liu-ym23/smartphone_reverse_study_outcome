package swb;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static String a;

    public static boolean b() {
        return LarkAppContext.inst().buildConfig().isOfficeSDK();
    }

    public static String a(Context r4) {
        String r1 = a;
        if (r1 == null) goto L17;
        return r1;
    L17:
        String r5 = r4.getPackageManager().getPackageInfo(r4.getPackageName(), 128).versionName;     // Catch: Exception -> L11
        a = r5;     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r5) == false) goto L14;
        return "";
    L14:
        return r5;
    L9:
        Exception e = e;
    L13:
        com.ss.android.lark.officesdk.utils.di.j.g("ApkUtil", "get version name exception", e);
    L11:
        e = move-exception;
        e = e;
        r5 = "";
        goto L13
    }
}
