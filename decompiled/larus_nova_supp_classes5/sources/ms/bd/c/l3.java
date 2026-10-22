package ms.bd.c;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import f06.b;
import f06.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class l3 {
    public static String a(Context r3) {
        String r4 = b(r3.getContentResolver());     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return "null_";
    L6:
        if (r4.contains("/") == false) goto L19;
        return r4.split("/")[0];
    L19:
        return r4;
    L10:
        th = move-exception;
        return "null_" + th.getMessage();
    L21:
        return "null_";
    }

    public static String b(ContentResolver r13) {
        c r8 = new c();
        Object[] r9 = {r13, "default_input_method"};
        b r11 = new b();
        f06.d r12 = r8.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, "java.lang.String", r11);
        if (r12.a == false) goto L6;
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, null, r11, false);
        return (String) r12.b;
    L6:
        String r14 = Settings.Secure.getString(r13, "default_input_method");
        r8.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r9, r14, r11, true);
        return r14;
    }
}
