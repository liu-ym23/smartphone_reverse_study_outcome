package z2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(String r10, String r11) {
        Matcher r12 = Pattern.compile(".*(((" + r11 + "=[^;]*)|(" + r11 + "=\"[\";]*))|(" + r11 + "=.*$)).*").matcher(r10);     // Catch: IllegalArgumentException -> L7
        if (r12.matches() == false) goto L10;
        return r12.group(1);
    L10:
        return null;
    L11:
        return null;
    }
}
