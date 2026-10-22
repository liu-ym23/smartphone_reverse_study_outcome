package r4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f12658a = null;

    static {
        f12658a = Pattern.compile("\\Wcharset=([^\\s;]+)", 2);
    }

    public static String a(String r10, String r11) {
        Matcher r12 = f12658a.matcher(r10);     // Catch: IllegalArgumentException -> L7
        if (r12.find() == false) goto L6;
        return r12.group(1).replaceAll("[\"\\\\]", "");
    L6:
        return r11;
    }
}
