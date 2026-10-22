package yz7;

import android.os.Build;
import com.larksuite.framework.utils.RomUtils;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static boolean a;
    public static final boolean b = false;

    static {
        a = true;
        boolean r2 = false;
        boolean r1 = RomUtils.b[0].equals(RomUtils.e().a);
        if (r1 == false) goto L5;
        Log.i("GlobalFontFgUtil", "vivo font hook close");
    L5:
        if (r1 == false) goto L12;
        StringBuilder r3 = new StringBuilder("sdk version is ");
        int r4 = Build.VERSION.SDK_INT;
        r3.append(r4);
        Log.i("GlobalFontFgUtil", r3.toString());
        if (r4 >= 34) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
        r2 = true;
        goto L12
    L9:
        r5 = false;
    L12:
        Log.i("GlobalFontFgUtil", "global font Android 14 close " + r2);
        b = true ^ r2;
    }
}
