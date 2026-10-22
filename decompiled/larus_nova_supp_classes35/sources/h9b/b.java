package h9b;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static String a(String r5) {
        if (r5 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        StringBuilder r0 = new StringBuilder();
        char[] r6 = r5.toCharArray();
        int r1 = r6.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        char r3 = r6[r2];
        if (Character.isDigit(r3) == false) goto L10;
        r0.append(r3);
    L10:
        r2 = r2 + 1;
        goto L6
    L12:
        return r0.toString();
    }

    public static boolean b(String r1, CharSequence r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (r2.length() <= 0) goto L8;
        if (Pattern.matches(r1, r2) == false) goto L8;
        return true;
    }
}
