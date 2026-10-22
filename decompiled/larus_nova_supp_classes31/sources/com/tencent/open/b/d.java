package com.tencent.open.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class d {
    private static String a;
    private static String b;

    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static String a(Context r2) {
        if (TextUtils.isEmpty(a) == true) goto L7;
        return a;
    L7:
        if (r2 != null) goto L9;
        return "";
    L9:
        a = "";
        WindowManager r3 = (WindowManager) r2.getSystemService("window");
        if (r3 == null) goto L13;
        a = r3.getDefaultDisplay().getWidth() + "x" + r3.getDefaultDisplay().getHeight();
    L13:
        return a;
    }
}
