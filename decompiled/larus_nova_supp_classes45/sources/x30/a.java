package x30;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static boolean a(String r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return false;
    L7:
        if (r3.length() >= r4.length()) goto L9;
        return false;
    L9:
        if (r3.endsWith(r4) == true) goto L12;
        return false;
    L12:
        if (r4.equals(r3) == false) goto L14;
    L15:
        return true;
    L14:
        if (r3.endsWith(".".concat(r4)) == true) goto L15;
        return false;
    }
}
